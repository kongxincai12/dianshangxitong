package com.jcd.service.Impl;

import java.math.BigDecimal;

import com.jcd.dto.*;
import com.jcd.exception.BusinessException;
import com.jcd.mapper.*;
import com.jcd.model.*;
import com.jcd.service.SmartShelfService;
import com.jcd.service.WcfMaterialService;
import com.jcd.utils.UtilityMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;
import java.util.stream.Collectors;

/**
 * 智能货架业务服务实现
 * <p>
 * 核心流程:
 * 1. 前端扫货架 → validateRack() 校验货架存在性 + 查询绑定的货架服务IP
 * 2. 前端扫UPN → prepareOperation() 校验UPN + 创建PENDING操作 + 通过料架对应IP亮灯指引
 * 3. 用户放入物料 → 货架回调 handleStatusChanged() → 匹配PENDING操作 → 执行入库/移库
 * 4. 前端轮询 getOperationStatus() 获取结果
 * <p>
 * 多IP支持: 每个料架(RACK)绑定不同的货架服务IP，通过SHELF_RACK_CONFIG表配置
 * 字段对应: RACK=货架, LOC_NAME=储位, 货架接口的LocationId=储位编码(LOC_NAME)
 */
@Service("SmartShelfService")
public class SmartShelfServiceImpl implements SmartShelfService {

    private static final Logger logger = LoggerFactory.getLogger(SmartShelfServiceImpl.class);

        /**
         * 货架硬件可能在极短时间内重复上报同一放入回调，3 秒内视为重复并忽略。
         */
        private static final long CALLBACK_DEDUP_WINDOW_MS = 3000L;

    // ===================== 操作状态常量 =====================
    public static final String STATUS_PENDING = "PENDING";
        public static final String STATUS_PROCESSING = "PROCESSING";
    public static final String STATUS_DONE = "DONE";
    public static final String STATUS_FAILED = "FAILED";
    public static final String STATUS_EXPIRED = "EXPIRED";

    public static final String OP_INBOUND = "INBOUND";
    public static final String OP_TRANSFER = "TRANSFER";

    // ===================== 待处理操作内存队列 =====================
    /**
     * key = operationId, value = PendingOperation
     */
    private final ConcurrentHashMap<String, PendingOperation> pendingOperations = new ConcurrentHashMap<>();

    /**
     * key = rackCode, value = operationId 列表 (同一货架可能有多个待处理UPN)
     */
    private final ConcurrentHashMap<String, List<String>> rackOperationMap = new ConcurrentHashMap<>();

    /**
     * 非法操作报警储位 - key=locationName (LOC_NAME), value=shelfBaseUrl
     * 当检测到非法取料/放料时，储位亮红灯并记录在此Map中
     * 只有经过正常入库/移库操作完成后才清除
     */
    private final ConcurrentHashMap<String, String> alertLocations = new ConcurrentHashMap<>();

    /**
     * UPN 级别的入库/移库锁 — 暂时用 upnname 作为 key
     * 理想情况下应该用 wmid（工单ID），但 z 端查询 wmid 需要补充 DAL 层支持
     * 目前用 upnname 作为锁 key，至少可以防止同一物料的并发操作
     * key = upnname, value = ReentrantLock
     * 
     * TODO: 后续补充从 locationId 查询 wmid 的 mapper 方法，改为用 wmid 级锁，这样更精确
     */
    private final ConcurrentHashMap<String, ReentrantLock> upnReleaseLocks = new ConcurrentHashMap<>();

    /**
     * 最近处理过的放入回调时间戳，key=locationName。
     */
    private final ConcurrentHashMap<String, Long> recentPutCallbacks = new ConcurrentHashMap<>();

    // ===================== 依赖注入 =====================
    @Autowired
    @Resource
    private UpnMapper upnMapper;

    @Autowired
    @Resource
    private V_location_allMapper locationMapper;

    @Autowired
    @Resource
    private StationMapper stationMapper;

    @Autowired
    @Resource
    private WipupnMapper wipupnMapper;

    @Autowired
    @Resource
    private Erp_message_transMapper erpMessageTransMapper;

    @Autowired
    @Resource
    private ShelfRackConfigMapper shelfRackConfigMapper;

    @Autowired
    private WcfMaterialService wcfMaterialService;

    @Value("${smartshelf.base-url:http://localhost:9090}")
    private String defaultShelfBaseUrl;

    @Value("${smartshelf.operation-timeout-minutes:10}")
    private int operationTimeoutMinutes;

    @Value("${smartshelf.default-return-location:TSSMT-01}")
    private String defaultReturnLocation;

    /** 备料亮灯远程服务URL (y:\pdaserver port 7007) */
    @Value("${smartshelf.prep-light-service-url:}")
    private String prepLightServiceUrl;

    private RestTemplate restTemplate;

    @PostConstruct
    public void initRestTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(3000);  // 3秒连接超时
        factory.setReadTimeout(5000);     // 5秒读取超时
        this.restTemplate = new RestTemplate(factory);
        logger.info("[智能货架] RestTemplate已配置超时: connect=3s, read=5s");
    }

    // ===================== 接口实现 =====================

    @Override
    public ShelfValidateRackResponse validateRack(String rackCode) {
        if (rackCode == null || rackCode.trim().isEmpty()) {
            throw new BusinessException("货架编号不能为空");
        }

        String trimmedRack = rackCode.trim();
        logger.info("[智能货架] validateRack: 查询料架 [{}]", trimmedRack);
        List<V_location_all> locations = locationMapper.selectByRack(trimmedRack);
        logger.info("[智能货架] validateRack: 料架 [{}] 查询到 {} 个储位", trimmedRack,
                locations != null ? locations.size() : 0);
        if (locations == null || locations.isEmpty()) {
            throw new BusinessException("货架 [" + rackCode + "] 不存在或无储位");
        }

        ShelfValidateRackResponse response = new ShelfValidateRackResponse();
        response.setRackCode(rackCode.trim());
        // 取第一个储位的类型和仓库信息
        V_location_all firstLoc = locations.get(0);
        response.setLocationType(firstLoc.getLocType());
        response.setWarehouse(firstLoc.getWarehouse());

        // 查询该料架绑定的货架服务IP
        ShelfRackConfig rackConfig = shelfRackConfigMapper.selectByRackCode(rackCode.trim());
        if (rackConfig != null) {
            response.setShelfIp(rackConfig.getShelfIp());
            response.setShelfPort(rackConfig.getShelfPort());
        }

        List<ShelfValidateRackResponse.LocationInfo> locInfos = locations.stream()
                .map(loc -> new ShelfValidateRackResponse.LocationInfo(
                        loc.getLocId(), loc.getLocName(), loc.getLocStatus()))
                .collect(Collectors.toList());
        response.setLocations(locInfos);

        return response;
    }

    @Override
    public ShelfInboundPreviewResponse previewInbound(String upnname, String userId) {
        if (upnname == null || upnname.trim().isEmpty()) {
            throw new BusinessException("UPN不能为空");
        }

        WcfMaterialService.WcfSmtDirectReturnPreviewResult result =
                wcfMaterialService.checkSmtDirectReturnForInbound(upnname.trim(), userId == null ? "" : userId);
        if (!result.success) {
            throw new BusinessException(result.message);
        }

        ShelfInboundPreviewResponse response = new ShelfInboundPreviewResponse();
        response.setNeedConfirm(result.needConfirm);
        response.setRemainingQty(result.remainingQty);
        response.setMessage(result.message);
        return response;
    }

    @Override
    public ShelfOperationStatusDTO prepareOperation(ShelfPrepareRequest request) {
        // 1. 参数校验
        if (request.getRackCode() == null || request.getRackCode().trim().isEmpty()) {
            throw new BusinessException("货架编号不能为空");
        }
        if (request.getUpnname() == null || request.getUpnname().trim().isEmpty()) {
            throw new BusinessException("UPN不能为空");
        }
        if (request.getUsername() == null || request.getUsername().trim().isEmpty()) {
            throw new BusinessException("用户名不能为空");
        }
        String opType = request.getOperationType();
        if (opType == null || (!OP_INBOUND.equals(opType) && !OP_TRANSFER.equals(opType))) {
            throw new BusinessException("操作类型无效，必须为 INBOUND 或 TRANSFER");
        }

        String rackCode = request.getRackCode().trim();
        String upnname = request.getUpnname().trim();

        // 2. 校验货架存在
        List<V_location_all> rackLocations = locationMapper.selectByRack(rackCode);
        if (rackLocations == null || rackLocations.isEmpty()) {
            throw new BusinessException("货架 [" + rackCode + "] 不存在");
        }

        // 3. 校验UPN存在及状态
        List<Upn> upns = upnMapper.GetUpnByUpnname(upnname);
        if (upns == null || upns.isEmpty()) {
            throw new BusinessException("UPN [" + upnname + "] 不存在");
        }
        Upn upn = upns.get(0);
        String state = upn.getState();
        if (state == null || (!"ACTIVE".equalsIgnoreCase(state) && !"NG".equalsIgnoreCase(state))) {
            throw new BusinessException("UPN [" + upnname + "] 状态为 [" + state + "]，不允许操作（需ACTIVE或NG）");
        }

        BigDecimal confirmedRemainingQty = null;
        if (OP_INBOUND.equals(opType)) {
            WcfMaterialService.WcfSmtDirectReturnPreviewResult preview =
                    wcfMaterialService.checkSmtDirectReturnForInbound(upnname,
                            request.getUserId() == null ? "" : request.getUserId());
            if (!preview.success) {
                throw new BusinessException(preview.message);
            }
            if (preview.needConfirm) {
                confirmedRemainingQty = request.getConfirmedRemainingQty();
                if (confirmedRemainingQty == null) {
                    throw new BusinessException("此UPN需要先确认剩余数量后才能入库");
                }
                if (confirmedRemainingQty.compareTo(preview.remainingQty) != 0) {
                    throw new BusinessException("UPN剩余数量已变化，当前数量为【" + preview.remainingQty.toPlainString()
                            + "】，请重新确认后入库");
                }
            }
        }

        // 4. 对同一 UPN 的“查重 + 创建”加锁，避免短时间重复扫码创建两个待处理操作
        ReentrantLock upnLock = upnReleaseLocks.computeIfAbsent(upnname, k -> new ReentrantLock());
        upnLock.lock();
        PendingOperation op;
        String operationId;
        try {
            for (PendingOperation existing : pendingOperations.values()) {
                if ((STATUS_PENDING.equals(existing.status) || STATUS_PROCESSING.equals(existing.status))
                        && upnname.equals(existing.upnname)) {
                    throw new BusinessException("UPN [" + upnname + "] 已有待处理操作，请等待完成或取消");
                }
            }

            // 5. 创建待处理操作
            operationId = UtilityMethod.GetUUID();
            op = new PendingOperation();
            op.operationId = operationId;
            op.rackCode = rackCode;
            op.upnname = upnname;
            op.upnid = upn.getUpnid();
            op.username = request.getUsername().trim();
            op.userId = request.getUserId();
            op.operationType = opType;
            op.confirmedRemainingQty = confirmedRemainingQty;
            op.status = STATUS_PENDING;
            op.createTime = System.currentTimeMillis();
            // 解析并缓存该料架对应的货架服务URL
            op.shelfBaseUrl = resolveShelfBaseUrl(rackCode);
            // 保存该货架下所有储位LOC_NAME，用于后续StatusChanged匹配
            op.rackLocationNames = rackLocations.stream()
                    .map(V_location_all::getLocName)
                    .collect(Collectors.toSet());

            pendingOperations.put(operationId, op);
            rackOperationMap.computeIfAbsent(rackCode, k -> Collections.synchronizedList(new ArrayList<>()))
                    .add(operationId);
        } finally {
            upnLock.unlock();
        }

        logger.info("[智能货架] 创建待处理操作: id={}, rack={}, upn={}, type={}",
                operationId, rackCode, upnname, opType);

        // 6. 查询空储位，只对空储位亮绿灯（批量）
        try {
            List<V_location_all> emptyLocations = locationMapper.selectEmptyLocationsByRack(rackCode);
            if (emptyLocations != null && !emptyLocations.isEmpty()) {
                List<ShelfPostInfoRequest.Detail> details = new ArrayList<>();
                for (V_location_all loc : emptyLocations) {
                    // 跳过报警储位，保持红灯
                    if (alertLocations.containsKey(loc.getLocName())) {
                        continue;
                    }
                    // 跳过备料亮灯储位，保持备料灯色
                    if (isLocationInPrepLight(loc.getLocName())) {
                        logger.info("[智能货架] 储位 [{}] 正在备料亮灯中，跳过入库绿灯", loc.getLocName());
                        continue;
                    }
                    ShelfPostInfoRequest.Detail d = new ShelfPostInfoRequest.Detail();
                    d.setLocationId(loc.getLocName());
                    d.setLightColor(64);  // 绿色
                    d.setTwinkle(0);      // 常亮
                    d.setIsLocked(0);
                    d.setIsMustCollect(0);
                    d.setQuantity(0);
                    d.setRelateToTower(false);
                    details.add(d);
                }
                callShelfLightBatch(op.shelfBaseUrl, details);
                logger.info("[智能货架] 批量亮灯: 空储位 {}/{} 个", emptyLocations.size(), rackLocations.size());
            } else {
                logger.warn("[智能货架] 料架 [{}] 无空储位，跳过亮灯", rackCode);
            }
        } catch (Exception e) {
            logger.warn("[智能货架] 亮灯失败(不影响操作): {}", e.getMessage());
        }

        // 7. 构建返回
        ShelfOperationStatusDTO statusDTO = new ShelfOperationStatusDTO();
        statusDTO.setOperationId(operationId);
        statusDTO.setStatus(STATUS_PENDING);
        statusDTO.setOperationType(opType);
        statusDTO.setUpnname(upnname);
        statusDTO.setRackCode(rackCode);
        statusDTO.setMessage("请将物料放入货架 [" + rackCode + "]");
        return statusDTO;
    }

    @Override
    public ShelfCallbackResponse handleStatusChanged(ShelfStatusChangedRequest request) {
        String locationId = request.getLocationId(); // 这是储位编码(LOC_NAME)
        Integer state = request.getState();

        logger.info("[智能货架] 收到StatusChanged回调: LocationId={}, State={}, LightColor={}, time={}",
                locationId, state, request.getLightColor(), request.getTime());

        if (locationId == null || locationId.trim().isEmpty()) {
            return ShelfCallbackResponse.fail("LocationId不能为空");
        }

        // State=1 表示从无到有（放入操作）— 这是入库/移库关心的
        // State=0 表示从有到无（取走操作）— 暂时只记录日志
        if (state == null) {
            return ShelfCallbackResponse.fail("State不能为空");
        }

        if (state == 0) {
            // 取走操作 — 检测是否为非法取料
            String locName0 = locationId.trim();
            logger.info("[智能货架] 储位 [{}] 物料被取走", locName0);

            // === 优先检查: 远程调用 y 的备料亮灯服务 ===
            // 备料亮灯会话在 y 内存中，z 收到回调需先问 y 是否属于备料取料
            try {
                boolean handledByPrepLight = callPrepLightPickCallback(locName0, 0);
                if (handledByPrepLight) {
                    logger.info("[智能货架] 储位 [{}] 取料已由备料亮灯服务处理(远程y)", locName0);
                    return ShelfCallbackResponse.success("取料回调已处理(备料亮灯)");
                }
            } catch (Exception e) {
                logger.warn("[智能货架] 远程备料回调异常(继续本地处理): {}", e.getMessage());
            }

            // 如果该储位已在报警状态，保持红灯
            if (alertLocations.containsKey(locName0)) {
                logger.info("[智能货架] 储位 [{}] 已在报警状态，物料被取走，保持红灯", locName0);
                return ShelfCallbackResponse.success("储位已在报警状态");
            }

            // 查询该储位上是否有有效UPN（DB中的记录）
            List<Upn> upnsAtLoc = upnMapper.selectActiveUpnByLocationName(locName0);
            if (upnsAtLoc == null || upnsAtLoc.isEmpty()) {
                // DB中无物料记录 — 可能已被MES正常处理，仅记录
                logger.info("[智能货架] 储位 [{}] DB无有效物料记录，取走操作已记录", locName0);
                return ShelfCallbackResponse.success("取走操作已记录");
            }

            Upn takenUpn = upnsAtLoc.get(0);

            // 检查该UPN是否有PENDING操作（正常移库取料）
            boolean hasPendingForUpn = false;
            for (PendingOperation op : pendingOperations.values()) {
                if (STATUS_PENDING.equals(op.status) && takenUpn.getUpnname().equals(op.upnname)) {
                    hasPendingForUpn = true;
                    break;
                }
            }
            if (hasPendingForUpn) {
                logger.info("[智能货架] 储位 [{}] UPN={} 被取走，匹配到待处理操作（正常取料）",
                        locName0, takenUpn.getUpnname());
                return ShelfCallbackResponse.success("正常取料操作");
            }

            // === 非法取料! ===
            logger.warn("[智能货架] 非法取料! 储位={}, UPN={}", locName0, takenUpn.getUpnname());

            // 自动将UPN移库到默认储位
            try {
                WcfMaterialService.WcfResult wcfResult = wcfMaterialService.upnTransfer4Location(
                        defaultReturnLocation, takenUpn.getUpnname(), "SYSTEM", "");
                logger.info("[智能货架] 非法取料自动移库: UPN={} → {}, WCF结果={}",
                        takenUpn.getUpnname(), defaultReturnLocation, wcfResult.message);
            } catch (Exception e) {
                logger.error("[智能货架] 非法取料自动移库失败: UPN={}, error={}",
                        takenUpn.getUpnname(), e.getMessage());
            }

            // 亮红灯报警
            setLocationAlert(locName0, "非法取料(UPN=" + takenUpn.getUpnname() + ")");
            return ShelfCallbackResponse.success("非法操作已记录，储位亮红灯报警");
        }

        // State == 1: 放入操作 — 先去重，再查找并抢占一个待处理操作
        String locName1 = locationId.trim();
        long callbackNow = System.currentTimeMillis();
        Long lastCallbackTime = recentPutCallbacks.put(locName1, callbackNow);
        if (lastCallbackTime != null && (callbackNow - lastCallbackTime) < CALLBACK_DEDUP_WINDOW_MS) {
            logger.warn("[智能货架] 忽略短时间重复放入回调: location={}, interval={}ms",
                locName1, callbackNow - lastCallbackTime);
            return ShelfCallbackResponse.success("重复放入回调已忽略");
        }

        logger.info("[智能货架] 查找储位 [{}] 匹配的PENDING操作, 当前待处理操作数={}",
            locName1, pendingOperations.size());
        PendingOperation matchedOp = claimPendingOperationByLocation(locName1);

        if (matchedOp == null) {
            // === 非法放料! ===
            logger.warn("[智能货架] 非法放料! 储位={}, 无匹配的待处理操作", locName1);
            setLocationAlert(locName1, "非法放料");
            return ShelfCallbackResponse.success("非法操作，储位已亮红灯报警");
        }

        // 执行入库或移库
        try {
            if (OP_INBOUND.equals(matchedOp.operationType)) {
                executeInbound(matchedOp, locationId.trim());
            } else if (OP_TRANSFER.equals(matchedOp.operationType)) {
                executeTransfer(matchedOp, locationId.trim());
            }

            matchedOp.status = STATUS_DONE;
            matchedOp.resultLocationId = locationId.trim();
            matchedOp.resultMessage = matchedOp.operationType.equals(OP_INBOUND)
                    ? "入库成功，储位: " + locationId
                    : "移库成功，目标储位: " + locationId;

            logger.info("[智能货架] 操作完成: id={}, upn={}, location={}",
                    matchedOp.operationId, matchedOp.upnname, locationId);

            // 如果该储位之前有报警，正常操作完成后解除
            if (alertLocations.remove(locationId.trim()) != null) {
                logger.info("[智能货架] 储位 [{}] 报警已解除（正常{}操作完成）",
                        locationId, matchedOp.operationType);
            }

            // 只灭实际放入物料的那个储位的灯，其他空储位保持亮灯方便连续入库
            try {
                callShelfLightOff(matchedOp.shelfBaseUrl, locationId);
            } catch (Exception e) {
                logger.warn("[智能货架] 灭灯失败: {}", e.getMessage());
            }

            return ShelfCallbackResponse.success("操作成功");
        } catch (Exception e) {
            logger.error("[智能货架] 操作执行失败: id={}, error={}",
                    matchedOp.operationId, e.getMessage(), e);
            matchedOp.status = STATUS_FAILED;
            matchedOp.resultMessage = "操作失败: " + e.getMessage();
            return ShelfCallbackResponse.fail("操作失败: " + e.getMessage());
        }
    }

    @Override
    public ShelfOperationStatusDTO getOperationStatus(String operationId) {
        if (operationId == null || operationId.trim().isEmpty()) {
            throw new BusinessException("操作ID不能为空");
        }

        PendingOperation op = pendingOperations.get(operationId.trim());
        if (op == null) {
            throw new BusinessException("操作 [" + operationId + "] 不存在或已过期");
        }

        // 检查是否超时
        if (STATUS_PENDING.equals(op.status) || STATUS_PROCESSING.equals(op.status)) {
            long elapsed = System.currentTimeMillis() - op.createTime;
            if (elapsed > (long) operationTimeoutMinutes * 60 * 1000) {
                op.status = STATUS_EXPIRED;
                op.resultMessage = "操作超时（超过" + operationTimeoutMinutes + "分钟）";
            }
        }

        ShelfOperationStatusDTO dto = new ShelfOperationStatusDTO();
        dto.setOperationId(op.operationId);
        dto.setStatus(STATUS_PROCESSING.equals(op.status) ? STATUS_PENDING : op.status);
        dto.setOperationType(op.operationType);
        dto.setUpnname(op.upnname);
        dto.setRackCode(op.rackCode);
        dto.setLocationId(op.resultLocationId);
        dto.setMessage(op.resultMessage);
        return dto;
    }

    @Override
    public void cancelOperation(String operationId) {
        if (operationId == null || operationId.trim().isEmpty()) {
            throw new BusinessException("操作ID不能为空");
        }

        PendingOperation op = pendingOperations.get(operationId.trim());
        if (op == null) {
            throw new BusinessException("操作 [" + operationId + "] 不存在");
        }

        if (!STATUS_PENDING.equals(op.status)) {
            throw new BusinessException("操作状态为 [" + op.status + "]，无法取消");
        }

        // 批量灭灯
        if (op.rackLocationNames != null && !op.rackLocationNames.isEmpty()) {
            try {
                List<ShelfPostInfoRequest.Detail> details = new ArrayList<>();
                for (String locName : op.rackLocationNames) {
                    ShelfPostInfoRequest.Detail d = new ShelfPostInfoRequest.Detail();
                    d.setLocationId(locName);
                    // 报警储位保持红灯，其他灭灯
                    if (alertLocations.containsKey(locName)) {
                        d.setLightColor(32); // 红灯-保持报警
                    } else {
                        d.setLightColor(0); // 灭灯
                    }
                    d.setTwinkle(0);
                    d.setIsLocked(0);
                    d.setIsMustCollect(0);
                    d.setQuantity(0);
                    d.setRelateToTower(false);
                    details.add(d);
                }
                callShelfLightBatch(op.shelfBaseUrl, details);
                logger.info("[智能货架] 取消操作批量灭灯: {} 个储位", details.size());
            } catch (Exception e) {
                logger.warn("[智能货架] 取消灭灯失败: {}", e.getMessage());
            }
        }

        // 移除
        pendingOperations.remove(operationId.trim());
        List<String> opIds = rackOperationMap.get(op.rackCode);
        if (opIds != null) {
            opIds.remove(operationId.trim());
        }

        logger.info("[智能货架] 操作已取消: id={}, upn={}", operationId, op.upnname);
    }

    @Override
    public void cancelByUpn(String upnname) {
        if (upnname == null || upnname.trim().isEmpty()) {
            throw new BusinessException("UPN不能为空");
        }
        String trimmed = upnname.trim();
        // 收集所有匹配的operationId，避免迭代中修改
        List<String> toCancel = new ArrayList<>();
        for (Map.Entry<String, PendingOperation> entry : pendingOperations.entrySet()) {
            PendingOperation op = entry.getValue();
            if (STATUS_PENDING.equals(op.status) && trimmed.equals(op.upnname)) {
                toCancel.add(op.operationId);
            }
        }
        for (String opId : toCancel) {
            try {
                cancelOperation(opId);
            } catch (Exception e) {
                logger.warn("[智能货架] 取消操作 {} 失败: {}", opId, e.getMessage());
            }
        }
        logger.info("[智能货架] cancelByUpn: UPN={}, 取消了 {} 个操作", trimmed, toCancel.size());
    }

    @Override
    public void cancelByRack(String rackCode) {
        if (rackCode == null || rackCode.trim().isEmpty()) {
            throw new BusinessException("料架编号不能为空");
        }
        String trimmed = rackCode.trim();

        // 1. 取消该料架所有PENDING操作
        List<String> opIds = rackOperationMap.get(trimmed);
        int cancelledCount = 0;
        if (opIds != null) {
            // 复制一份避免并发修改
            List<String> snapshot = new ArrayList<>(opIds);
            for (String opId : snapshot) {
                try {
                    cancelOperation(opId);
                    cancelledCount++;
                } catch (Exception e) {
                    logger.warn("[智能货架] cancelByRack: 取消操作 {} 失败: {}", opId, e.getMessage());
                }
            }
        }

        // 2. 无论有没有PENDING操作，都强制关闭该料架所有灯
        try {
            String shelfBaseUrl = resolveShelfBaseUrl(trimmed);
            List<V_location_all> allLocations = locationMapper.selectByRack(trimmed);
            if (allLocations != null && !allLocations.isEmpty()) {
                List<ShelfPostInfoRequest.Detail> details = new ArrayList<>();
                for (V_location_all loc : allLocations) {
                    ShelfPostInfoRequest.Detail d = new ShelfPostInfoRequest.Detail();
                    d.setLocationId(loc.getLocName());
                    // 报警储位保持红灯，其他灭灯
                    if (alertLocations.containsKey(loc.getLocName())) {
                        d.setLightColor(32); // 红灯-保持报警
                    } else {
                        d.setLightColor(0); // 灭灯
                    }
                    d.setTwinkle(0);
                    d.setIsLocked(0);
                    d.setIsMustCollect(0);
                    d.setQuantity(0);
                    d.setRelateToTower(false);
                    details.add(d);
                }
                callShelfLightBatch(shelfBaseUrl, details);
                logger.info("[智能货架] cancelByRack: 料架 [{}] 灭灯/保持报警 {} 个储位", trimmed, details.size());
            }
        } catch (Exception e) {
            logger.warn("[智能货架] cancelByRack: 灭灯失败: {}", e.getMessage());
        }

        logger.info("[智能货架] cancelByRack: rack={}, 取消了 {} 个操作", trimmed, cancelledCount);
    }

    @Override
    public String resolveShelfBaseUrl(String rackCode) {
        if (rackCode == null || rackCode.trim().isEmpty()) {
            logger.warn("[智能货架] 料架编号为空，使用默认URL: {}", defaultShelfBaseUrl);
            return defaultShelfBaseUrl;
        }
        ShelfRackConfig config = shelfRackConfigMapper.selectByRackCode(rackCode.trim());
        if (config == null) {
            logger.warn("[智能货架] 料架 [{}] 未配置货架IP，使用默认URL: {}", rackCode, defaultShelfBaseUrl);
            return defaultShelfBaseUrl;
        }
        String url = config.getShelfBaseUrl();
        logger.debug("[智能货架] 料架 [{}] 解析货架URL: {}", rackCode, url);
        return url;
    }

    @Override
    public void callShelfLight(String shelfBaseUrl, String locationId, int lightColor, int twinkle) {
        String baseUrl = (shelfBaseUrl != null && !shelfBaseUrl.trim().isEmpty())
                ? shelfBaseUrl : defaultShelfBaseUrl;
        try {
            ShelfPostInfoRequest request = new ShelfPostInfoRequest();
            request.setTwinkleTime(0); // 常亮

            ShelfPostInfoRequest.Detail detail = new ShelfPostInfoRequest.Detail();
            detail.setLocationId(locationId);
            detail.setLightColor(lightColor);
            detail.setTwinkle(twinkle);
            detail.setIsLocked(0);
            detail.setIsMustCollect(0);
            detail.setQuantity(0);
            detail.setRelateToTower(false);

            request.setDetails(Collections.singletonList(detail));

            String url = baseUrl + "/api/Light/PostInfo/";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<ShelfPostInfoRequest> entity = new HttpEntity<>(request, headers);

            String resp = restTemplate.postForObject(url, entity, String.class);
            logger.info("[智能货架] 亮灯成功: location={}, color={}, 货架响应={}", locationId, lightColor, resp);
        } catch (Exception e) {
            logger.error("[智能货架] 调用亮灯接口失败: url={}, location={}, error={}", baseUrl, locationId, e.getMessage(), e);
            throw new BusinessException("调用货架亮灯接口失败: " + e.getMessage());
        }
    }

    @Override
    public void callShelfLightOff(String shelfBaseUrl, String locationId) {
        callShelfLight(shelfBaseUrl, locationId, 0, 0); // LightColor=0 表示灭灯
    }

    @Override
    public void callShelfLightBatch(String shelfBaseUrl, List<ShelfPostInfoRequest.Detail> details) {
        if (details == null || details.isEmpty()) return;
        String baseUrl = (shelfBaseUrl != null && !shelfBaseUrl.trim().isEmpty())
                ? shelfBaseUrl : defaultShelfBaseUrl;
        try {
            ShelfPostInfoRequest request = new ShelfPostInfoRequest();
            request.setTwinkleTime(0);
            request.setDetails(details);

            String url = baseUrl + "/api/Light/PostInfo/";
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<ShelfPostInfoRequest> entity = new HttpEntity<>(request, headers);

            String resp = restTemplate.postForObject(url, entity, String.class);
            logger.info("[智能货架] 批量亮灯成功: {} 个储位, 货架响应={}", details.size(), resp);
        } catch (Exception e) {
            logger.error("[智能货架] 批量亮灯失败: url={}, 储位数={}, error={}", baseUrl, details.size(), e.getMessage(), e);
            throw new BusinessException("调用货架批量亮灯接口失败: " + e.getMessage());
        }
    }

    // ===================== 货架配置管理 =====================

    @Override
    public List<ShelfRackConfig> getAllRackConfigs() {
        return shelfRackConfigMapper.selectAll();
    }

    @Override
    public void saveRackConfig(ShelfRackConfig config) {
        if (config.getRackCode() == null || config.getRackCode().trim().isEmpty()) {
            throw new BusinessException("料架编号不能为空");
        }
        if (config.getShelfIp() == null || config.getShelfIp().trim().isEmpty()) {
            throw new BusinessException("货架IP不能为空");
        }
        if (config.getShelfPort() == null) {
            config.setShelfPort(9090);
        }
        if (config.getStatus() == null) {
            config.setStatus("ACTIVE");
        }

        if (config.getConfigId() != null && !config.getConfigId().trim().isEmpty()) {
            // 更新
            config.setUpdateTime(new Date());
            shelfRackConfigMapper.updateByPrimaryKeySelective(config);
            logger.info("[智能货架] 更新货架配置: rack={}, ip={}:{}", config.getRackCode(), config.getShelfIp(), config.getShelfPort());
        } else {
            // 新增 - 检查是否已有相同料架编号
            ShelfRackConfig existing = shelfRackConfigMapper.selectByRackCode(config.getRackCode().trim());
            if (existing != null) {
                throw new BusinessException("料架 [" + config.getRackCode() + "] 已存在配置，请修改而非新增");
            }
            config.setConfigId(UtilityMethod.GetUUID());
            config.setCreateTime(new Date());
            config.setUpdateTime(new Date());
            shelfRackConfigMapper.insert(config);
            logger.info("[智能货架] 新增货架配置: rack={}, ip={}:{}", config.getRackCode(), config.getShelfIp(), config.getShelfPort());
        }
    }

    @Override
    public void deleteRackConfig(String configId) {
        if (configId == null || configId.trim().isEmpty()) {
            throw new BusinessException("配置ID不能为空");
        }
        shelfRackConfigMapper.deleteByPrimaryKey(configId.trim());
        logger.info("[智能货架] 删除货架配置: configId={}", configId);
    }

    // ===================== 核心业务逻辑 =====================

    /**
     * 执行入库操作 — 调用 C# WCF PassLocation 接口
     * C# 端包含完整的过站校验: StepCheck4UPN、StepPass4UPN、料号-储位映射、湿敏件检查等
     * Java 端不再做任何直接 DB 操作，所有业务逻辑由 C# 统一管控
     * 
     * 并发控制: 不同 UPN 入库竞争数据库，需要串行化（暂时以 upnname 为 key）
     */
    public void executeInbound(PendingOperation op, String locationName) {
        // 用 upnname 作为锁 key - 防止同一物料的并发操作
        ReentrantLock upnLock = upnReleaseLocks.computeIfAbsent(op.upnname, k -> new ReentrantLock());
        upnLock.lock();
        try {
            logger.info("[智能货架入库] 获取upn锁: upn={}", op.upnname);
            logger.info("[智能货架入库] 调用WCF PassLocation: UPN={}, 储位={}, 操作人={}",
                    op.upnname, locationName, op.username);
            
            executePassLocation(op, locationName);
        } finally {
            upnLock.unlock();
            logger.info("[智能货架入库] 释放upn锁: upn={}", op.upnname);
        }
    }

    /**
     * 真正的 WCF PassLocation 调用 — 无锁
     */
    private void executePassLocation(PendingOperation op, String locationName) {
        WcfMaterialService.WcfResult result;
        if (op.confirmedRemainingQty != null) {
            result = wcfMaterialService.passLocationWithSmtReturnConfirmation(
                    locationName,       // ltcode = 储位编码(LOC_NAME)
                    "",                 // locationid = 空串，C#内部通过ltcode查
                    op.upnname,         // upnname = UPN条码
                    "2",                // type = 2(线边仓入库)
                    "线边仓入库",        // stationname
                    op.username,        // username = 操作人
                    "",                 // sys_user_id = 空串
                    op.confirmedRemainingQty
            );
        } else {
            result = wcfMaterialService.passLocation(
                    locationName,       // ltcode = 储位编码(LOC_NAME)
                    "",                 // locationid = 空串，C#内部通过ltcode查
                    op.upnname,         // upnname = UPN条码
                    "2",                // type = 2(线边仓入库)
                    "线边仓入库",        // stationname
                    op.username,        // username = 操作人
                    ""                  // sys_user_id = 空串
            );
        }

        if (!result.success) {
            throw new BusinessException("WCF入库失败: " + result.message);
        }

        logger.info("[智能货架入库] WCF返回成功: UPN={}, 储位={}, msg={}",
                op.upnname, locationName, result.message);
    }

    /**
     * 执行移库操作 — 调用 C# WCF UpnTransfer4Location 接口
     * C# 端包含完整的移库校验和数据库操作
     * Java 端不再做任何直接 DB 操作，所有业务逻辑由 C# 统一管控
     * 
     * 并发控制: 不同 UPN 移库竞争数据库，需要串行化（暂时以 upnname 为 key）
     */
    public void executeTransfer(PendingOperation op, String locationName) {
        // 用 upnname 作为锁 key - 防止同一物料的并发操作
        ReentrantLock upnLock = upnReleaseLocks.computeIfAbsent(op.upnname, k -> new ReentrantLock());
        upnLock.lock();
        try {
            logger.info("[智能货架移库] 获取upn锁: upn={}", op.upnname);
            logger.info("[智能货架移库] 调用WCF UpnTransfer4Location: UPN={}, 目标储位={}, 操作人={}",
                    op.upnname, locationName, op.username);
            
            executeUpnTransfer(op, locationName);
        } finally {
            upnLock.unlock();
            logger.info("[智能货架移库] 释放upn锁: upn={}", op.upnname);
        }
    }

    /**
     * 真正的 WCF UpnTransfer4Location 调用 — 无锁
     */
    private void executeUpnTransfer(PendingOperation op, String locationName) {
        WcfMaterialService.WcfResult result = wcfMaterialService.upnTransfer4Location(
                locationName,       // locationSn = 目标储位编码(LOC_NAME)
                op.upnname,         // upnname = UPN条码
                op.username,        // username = 操作人
                ""                  // sys_user_id = 空串
        );

        if (!result.success) {
            throw new BusinessException("WCF移库失败: " + result.message);
        }

        logger.info("[智能货架移库] WCF返回成功: UPN={}, 目标储位={}, msg={}",
                op.upnname, locationName, result.message);
    }

    // ===================== 备料亮灯远程协调 =====================

    /**
     * 远程调用 y:\pdaserver 的备料亮灯服务，处理取料回调
     * 如果该储位属于备料亮灯会话，y 执行灭灯+自动发料并返回 true
     *
     * @param locationName 储位编码
     * @param state        0=取走
     * @return true=备料服务已处理, false=不属于备料
     */
    private boolean callPrepLightPickCallback(String locationName, int state) {
        if (prepLightServiceUrl == null || prepLightServiceUrl.trim().isEmpty()) {
            return false;
        }
        try {
            String url = prepLightServiceUrl.trim() + "/api/prep-light/handle-pick-callback";
            Map<String, Object> body = new HashMap<>();
            body.put("locationName", locationName);
            body.put("state", state);

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_JSON);
            HttpEntity<Map<String, Object>> entity = new HttpEntity<>(body, headers);

            @SuppressWarnings("unchecked")
            Map<String, Object> response = restTemplate.postForObject(url, entity, Map.class);

            if (response != null && response.get("data") instanceof Boolean) {
                return (Boolean) response.get("data");
            }
            return false;
        } catch (Exception e) {
            logger.warn("[智能货架] 远程备料亮灯回调失败(不影响本地处理): {}", e.getMessage());
            return false;
        }
    }

    /**
     * 远程查询储位是否在 y 的备料亮灯会话中
     * 用于 z 在亮绿灯/红灯前检查，避免覆盖备料灯色
     *
     * @param locationName 储位编码
     * @return true=该储位正在备料亮灯中
     */
    private boolean isLocationInPrepLight(String locationName) {
        if (prepLightServiceUrl == null || prepLightServiceUrl.trim().isEmpty()) {
            return false;
        }
        try {
            String url = prepLightServiceUrl.trim()
                    + "/api/prep-light/is-active-location?locationName="
                    + java.net.URLEncoder.encode(locationName, "UTF-8");

            @SuppressWarnings("unchecked")
            Map<String, Object> response = restTemplate.getForObject(url, Map.class);

            if (response != null && response.get("data") instanceof Boolean) {
                return (Boolean) response.get("data");
            }
            return false;
        } catch (Exception e) {
            logger.warn("[智能货架] 远程查询备料储位失败(不影响本地处理): {}", e.getMessage());
            return false;
        }
    }

    // ===================== 辅助方法 =====================

    /**
     * 标记储位为报警状态 - 亮红灯
     * 只有经过正常入库/移库操作完成后才解除
     */
    private void setLocationAlert(String locName, String reason) {
        try {
            // 备料亮灯期间，不覆盖备料灯色
            if (isLocationInPrepLight(locName)) {
                logger.info("[智能货架] 储位 [{}] 正在备料亮灯中，跳过报警红灯 (原因: {})", locName, reason);
                return;
            }
            List<V_location_all> locs = locationMapper.V_location_allGetByLoc_name(locName);
            if (locs != null && !locs.isEmpty()) {
                String rack = locs.get(0).getRack();
                String shelfBaseUrl = resolveShelfBaseUrl(rack);
                callShelfLight(shelfBaseUrl, locName, 32, 0); // 32=RED, 0=常亮
                alertLocations.put(locName, shelfBaseUrl);
                logger.warn("[智能货架] 报警亮红灯: 储位={}, 原因={}", locName, reason);
            } else {
                logger.warn("[智能货架] 无法设置报警: 储位 [{}] 未找到位置信息", locName);
            }
        } catch (Exception e) {
            logger.error("[智能货架] 报警亮红灯失败: 储位={}, error={}", locName, e.getMessage());
        }
    }

    /**
     * 根据储位 LOC_NAME 查找并抢占一个匹配的待处理操作。
     * 抢占成功后立刻将状态改为 PROCESSING，避免同一操作被并发回调重复执行。
     */
    private synchronized PendingOperation claimPendingOperationByLocation(String locationName) {
        for (PendingOperation op : pendingOperations.values()) {
            if (STATUS_PENDING.equals(op.status) && op.rackLocationNames != null
                    && op.rackLocationNames.contains(locationName)) {
                op.status = STATUS_PROCESSING;
                logger.info("[智能货架] 抢占待处理操作: id={}, upn={}, location={}",
                        op.operationId, op.upnname, locationName);
                return op;
            }
        }
        return null;
    }

    /**
     * 定时清理过期操作（每分钟执行一次）
     */
    @Scheduled(fixedRate = 60000)
    public void cleanupExpiredOperations() {
        long now = System.currentTimeMillis();
        long timeoutMs = (long) operationTimeoutMinutes * 60 * 1000;

        recentPutCallbacks.entrySet().removeIf(e -> (now - e.getValue()) > CALLBACK_DEDUP_WINDOW_MS);

        List<String> toRemove = new ArrayList<>();
        for (Map.Entry<String, PendingOperation> entry : pendingOperations.entrySet()) {
            PendingOperation op = entry.getValue();
            // 非PENDING状态且超过2倍超时时间的也清理（保留一段时间给前端轮询）
            if (!STATUS_PENDING.equals(op.status) && (now - op.createTime) > timeoutMs * 2) {
                toRemove.add(entry.getKey());
            }
                // PENDING / PROCESSING 状态超时
                else if ((STATUS_PENDING.equals(op.status) || STATUS_PROCESSING.equals(op.status))
                    && (now - op.createTime) > timeoutMs) {
                op.status = STATUS_EXPIRED;
                op.resultMessage = "操作超时";
                logger.info("[智能货架] 操作超时自动过期: id={}, upn={}", op.operationId, op.upnname);
                // 过期后批量灭灯
                if (op.rackLocationNames != null && !op.rackLocationNames.isEmpty()) {
                    try {
                        List<ShelfPostInfoRequest.Detail> details = new ArrayList<>();
                        for (String locName : op.rackLocationNames) {
                            ShelfPostInfoRequest.Detail d = new ShelfPostInfoRequest.Detail();
                            d.setLocationId(locName);
                            // 报警储位保持红灯
                            if (alertLocations.containsKey(locName)) {
                                d.setLightColor(32);
                            } else {
                                d.setLightColor(0);
                            }
                            d.setTwinkle(0);
                            d.setIsLocked(0);
                            d.setIsMustCollect(0);
                            d.setQuantity(0);
                            d.setRelateToTower(false);
                            details.add(d);
                        }
                        callShelfLightBatch(op.shelfBaseUrl, details);
                    } catch (Exception ignored) {
                    }
                }
            }
        }

        for (String id : toRemove) {
            PendingOperation removed = pendingOperations.remove(id);
            if (removed != null) {
                List<String> opIds = rackOperationMap.get(removed.rackCode);
                if (opIds != null) {
                    opIds.remove(id);
                }
            }
        }
    }

    // ===================== 内部数据结构 =====================

    /**
     * 待处理操作 - 存储在内存中的临时操作记录
     */
    static class PendingOperation {
        String operationId;
        String rackCode;        // 货架编号(RACK)
        String upnname;
        String upnid;
        String username;
        String userId;
        String operationType;   // INBOUND / TRANSFER
        BigDecimal confirmedRemainingQty; // SMT直接退料入库时用户确认的UPN剩余数量
        String status;          // PENDING / DONE / FAILED / EXPIRED
        String resultLocationId;
        String resultMessage;
        long createTime;
        String shelfBaseUrl;    // 该料架对应的货架服务URL (缓存,避免重复查表)
        Set<String> rackLocationNames; // 该货架下所有储位的LOC_NAME集合
    }
}
