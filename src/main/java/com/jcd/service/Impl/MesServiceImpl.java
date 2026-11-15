package com.jcd.service.Impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcd.dto.*;
import com.jcd.mapper.*;
import com.jcd.model.*;
import com.jcd.service.MesService;
import com.jcd.vo.ApprovalRecordVo;
import com.jcd.vo.GroupTaskStatusVo;
import com.jcd.vo.ProductionRecordVO;
import com.jcd.vo.TaskStatusVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.jcd.dto.ParameterDto;
import com.jcd.dto.ValidationDto;
import com.jcd.model.Equipment;
import com.jcd.model.EquipmentTypeParam;
import com.jcd.exception.BusinessException;
import com.jcd.mapper.EquipmentMapper;
import com.jcd.mapper.EquipmentTypeParamMapper;


import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Service("MesService")
public class MesServiceImpl implements MesService {
    @Autowired
    private Prp_lotMapper prpLotMapper;

    @Autowired
    private MesDefectPresetsMapper defectPresetMapper;

    @Autowired
    private LqcRecordMapper lqcRecordMapper;

    @Autowired
    private LqcRecordDetailMapper lqcRecordDetailMapper;

    @Autowired
    private ProductionRecordMapper  productionRecordMapper;
    @Autowired
    private UserprofileMapper userprofileMapper;

    @Autowired
    private WorkstationMapper workstationMapper;

    @Override
    public List<Prp_lot> lotfindbyLotname(String lotname){
        return prpLotMapper.selectByLotname(lotname);
    }


    @Autowired
    private EquipmentMapper equipmentMapper;

    @Autowired
    private EquipmentStationBindingMapper equipmentStationBindingMapper;

    @Autowired
    private EquipmentTypeParamMapper equipmentTypeParamMapper;

    @Autowired
    private MaterialModuleMapper materialModuleMapper;

    @Autowired
    private RecordMaterialMapper recordMaterialMapper;

    @Autowired
    private ParamOverrideMapper paramOverrideMapper;

    @Autowired
    private EpmParamProductMapper epmParamProductMapper;

    @Autowired
    private Rmm_lotmateriallistMapper rmm_lotmateriallistMapper;

    @Autowired
    private InspectionAuthMapper inspectionAuthMapper;

    @Autowired
    private InspectionMapper inspectionMapper;

    @Autowired
    private PackingMapper packingMapper;



    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public List<String> findDefectNamesBySite(String siteName) {
        List<MesDefectPresets> presets = defectPresetMapper.findEnabledBySiteName(siteName);
        // 2. 使用 Java Stream API，提取出每个对象的 defectName 字段，并收集成一个新的字符串列表
        return presets.stream()
                .map(MesDefectPresets::getDefectName)
                .collect(Collectors.toList());
    }


    /**
     * 【新增实现】保存记录的业务逻辑
     * @Transactional 注解确保主表和明细表的插入操作要么都成功，要么都失败回滚。
     */
    @Override
    @Transactional
    public void saveLqcRecord(LqcRecordDto recordDto, String username) {
        // 1. 创建主表实体对象
        LqcRecord mainRecord = new LqcRecord();
        String mainRecordId = UUID.randomUUID().toString().replace("-", "");
        mainRecord.setId(mainRecordId);

        // 转换日期格式
        try {//new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
            mainRecord.setCheckDate(new SimpleDateFormat("yyyy-MM-dd").parse(recordDto.getDate()));
        } catch (Exception e) {
            // 在实际项目中，这里应该抛出自定义异常或进行更完善的处理
            throw new RuntimeException("日期格式转换失败", e);
        }

        mainRecord.setShift(recordDto.getShift());
        mainRecord.setInspectorUsername(username); // 前端传的是 inspectorId
        mainRecord.setSiteName(recordDto.getSite());
        mainRecord.setLotName(recordDto.getLotname());
        mainRecord.setProductPn(recordDto.getProductPn());
        mainRecord.setTotalQty(recordDto.getTotalQty());
        mainRecord.setSampleQty(recordDto.getSampleQty());
        mainRecord.setTotalDefectQty(recordDto.getTotalDefectQty());
        mainRecord.setRecordStatus("CREATED"); // 初始状态
        mainRecord.setCreatedBy(username);
        mainRecord.setAttribute1(recordDto.getJudgementResult());
        mainRecord.setAttribute2(String.valueOf(recordDto.getPanelPcs()));
        mainRecord.setLastUpdatedBy(username); // 创建时，更新人也是创建人

        // 2. 插入主表数据
        lqcRecordMapper.insert(mainRecord);

        // 3. 遍历并插入明细表数据
        if (recordDto.getDefects() != null && !recordDto.getDefects().isEmpty()) {
            for (LqcRecordDto.DefectDetailDto detailDto : recordDto.getDefects()) {
                LqcRecordDetail detailRecord = new LqcRecordDetail();
                detailRecord.setId(UUID.randomUUID().toString().replace("-", ""));
                detailRecord.setRecordId(mainRecordId); // 关联主表ID
                detailRecord.setDefectName(detailDto.getName());
                detailRecord.setDefectQty(detailDto.getQty());

                lqcRecordDetailMapper.insert(detailRecord);
            }
        }
    }

    @Override
    public List<ProcessDto> getProcessList() {
        // 目前返回一个静态列表。未来可以改为从数据库的工序配置表中查询。
        return Arrays.asList(
                new ProcessDto("表面处理", "表面处理", "点击进入录入界面"),
                new ProcessDto("钻孔", "钻孔", "点击进入录入界面"),
                new ProcessDto("......", "......", "其他工序待开放中")
        );
    }

    @Override
    public List<TaskDto> getTasksForUser(String userRole, String dateStr) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date checkDate;
        try {
            checkDate = sdf.parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException("无效的日期格式", e);
        }

        List<TaskDto> tasks = new ArrayList<>();

        // 目前只实现了班长的逻辑，您可以后续扩展组长的逻辑
        if (userRole.contains("SHIFT_LEADER")) {
            List<TaskStatusVo> statuses = lqcRecordMapper.findTaskStatusByDate(checkDate);

            for (TaskStatusVo statusVo : statuses) {
                String id = dateStr + "-" + statusVo.getSiteName() + "-" + statusVo.getShift();
                String title = id;
                String description = "";
                String statusText = "";

                if ("PENDING_SHIFT_CONFIRM".equals(statusVo.getStatus())) {
                    description = statusVo.getShift() + "数据已提交，待您确认";
                    statusText = "待班长确认";
                } else if ("SHIFT_CONFIRMED".equals(statusVo.getStatus())) {
                    description = "您已确认";
                    statusText = "已确认";
                }

                Map<String, String> params = new HashMap<>();
                params.put("site", statusVo.getSiteName());
                params.put("shift", statusVo.getShift());
                tasks.add(new TaskDto(id, title, description, statusVo.getStatus(), statusText, params));
            }
        }else if (userRole.contains("GROUP_LEADER")) {
            // 【新增】组长的任务逻辑
            List<GroupTaskStatusVo> groupStatuses = lqcRecordMapper.findGroupTaskStatusByDate(checkDate);

            // 1. 按站点名称对查询结果进行分组
            Map<String, List<GroupTaskStatusVo>> siteStatusMap = groupStatuses.stream()
                    .collect(Collectors.groupingBy(GroupTaskStatusVo::getSiteName));

            // 2. 遍历每个站点，判断其整日任务状态
            for (Map.Entry<String, List<GroupTaskStatusVo>> entry : siteStatusMap.entrySet()) {
                String siteName = entry.getKey();
                List<GroupTaskStatusVo> statusList = entry.getValue();

                boolean hasCreated = statusList.stream().anyMatch(s -> "CREATED".equals(s.getRecordStatus()));
                boolean hasShiftConfirmed = statusList.stream().anyMatch(s -> "SHIFT_CONFIRMED".equals(s.getRecordStatus()));
                boolean hasLeaderConfirmed = statusList.stream().anyMatch(s -> "LEADER_CONFIRMED".equals(s.getRecordStatus()));

                // 如果还存在“已创建”状态的记录，说明班长还没确认完，组长看不到这个任务
                if (hasCreated) {
                    continue;
                }

                String id = dateStr + "-" + siteName;
                String title = id;
                String description = "";
                String status = "";
                String statusText = "";

                if (hasLeaderConfirmed) {
                    // 只要有一条被组长确认过，就认为整日任务已确认
                    status = "LEADER_CONFIRMED";
                    statusText = "已确认";
                    description = "您已完成本日确认";
                } else if (hasShiftConfirmed) {
                    // 只要有班长确认过的记录，并且没有被组长确认，就认为是待组长确认
                    status = "PENDING_LEADER_CONFIRM";
                    statusText = "待组长确认";
                    description = "白/晚班数据已由班长确认，待您审批";
                } else {
                    // 其他情况（例如，所有记录都被驳回了），暂时不生成任务
                    continue;
                }

                Map<String, String> params = new HashMap<>();
                params.put("site", siteName);
                params.put("shift", "全天"); // 组长的任务是针对全天的
                tasks.add(new TaskDto(id, title, description, status, statusText, params));
            }
        }


        return tasks;
    }
    @Override
    public ApprovalDataDto getApprovalData(String dateStr, String site, String shift) {
        Date checkDate;
        try {
            checkDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException("无效的日期格式", e);
        }

        List<ApprovalRecordVo> flatRecords = lqcRecordMapper.findApprovalRecords(checkDate, site, shift);

        Map<String, Map<String, Object>> groupedRecords = new LinkedHashMap<>();
        Set<String> defectHeaderSet = new TreeSet<>();

        for (ApprovalRecordVo vo : flatRecords) {
            groupedRecords.computeIfAbsent(vo.getLotName(), k -> {
                Map<String, Object> newRecord = new HashMap<>();
                newRecord.put("lot_name", vo.getLotName());
                newRecord.put("product_pn", vo.getProductPn());
                newRecord.put("total_qty", vo.getTotalQty());
                newRecord.put("sample_qty", vo.getSampleQty());
                newRecord.put("total_defect_qty", vo.getTotalDefectQty());
                newRecord.put("inspector_fullname", vo.getInspectorFullname());
                newRecord.put("shift_confirmer_fullname", vo.getShiftConfirmerFullname());
                newRecord.put("defects", new HashMap<String, BigDecimal>());
                return newRecord;
            });

            if (vo.getDefectName() != null && vo.getDefectQty() != null) {
                Map<String, BigDecimal> defects = (Map<String, BigDecimal>) groupedRecords.get(vo.getLotName()).get("defects");
                defects.put(vo.getDefectName(), vo.getDefectQty());
                defectHeaderSet.add(vo.getDefectName());
            }
        }

        List<String> defectHeaders = new ArrayList<>(defectHeaderSet);
        List<Map<String, Object>> records = new ArrayList<>(groupedRecords.values());

        return new ApprovalDataDto(defectHeaders, records);
    }

    @Override
    @Transactional
    public void confirmRecords(String dateStr, String site, String shift, String currentTaskStatus, String newStatus, String username) {
        Date checkDate;
        try {
            checkDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException("无效的日期格式", e);
        }

        // 【核心修正】根据前端传来的“任务状态”，转换为数据库中记录的“真实状态”
        String dbRecordStatus;
        if ("PENDING_SHIFT_CONFIRM".equals(currentTaskStatus)) {
            dbRecordStatus = "CREATED";
        } else if ("PENDING_LEADER_CONFIRM".equals(currentTaskStatus)) {
            dbRecordStatus = "SHIFT_CONFIRMED";
        } else {
            // 如果状态不是待办状态，则不允许确认，抛出异常
            throw new IllegalStateException("无法确认当前状态的任务: " + currentTaskStatus);
        }

        // 调用Mapper，传入转换后的真实状态 dbRecordStatus
        lqcRecordMapper.updateStatusByCondition(checkDate, site, shift, dbRecordStatus, newStatus, username, new Date());
    }

    @Override
    public InspectionDataDto getInspectionData(String dateStr, String shift, String lotname,String site) {
        // ... (日期转换逻辑)
        Date checkDate;
        try {
            checkDate = new SimpleDateFormat("yyyy-MM-dd").parse(dateStr);
        } catch (ParseException e) {
            throw new RuntimeException("无效的日期格式", e);
        }

        // 1. 尝试查找已存在的记录
        LqcRecord existingRecord = lqcRecordMapper.findByUniqueKey(checkDate, shift,lotname,site);

        InspectionDataDto dto = new InspectionDataDto();
        if (existingRecord != null) {
            // 2. 如果记录已存在
            dto.setExistingRecord(true);
            dto.setRecordId(existingRecord.getId());
            dto.setProductPn(existingRecord.getProductPn());
            dto.setTotalQty(existingRecord.getTotalQty());
            dto.setSampleQty(existingRecord.getSampleQty());
            dto.setJudgementResult(existingRecord.getAttribute1());
            dto.setPanelPcs(Integer.valueOf(existingRecord.getAttribute2()));

            // 2.1 查询并填充缺陷明细
            List<LqcRecordDetail> details = lqcRecordDetailMapper.findByRecordId(existingRecord.getId());
            List<LqcRecordDto.DefectDetailDto> defectDtos = details.stream().map(d -> {
                LqcRecordDto.DefectDetailDto defectDto = new LqcRecordDto.DefectDetailDto();
                defectDto.setName(d.getDefectName());
                defectDto.setQty(d.getDefectQty());
                return defectDto;
            }).collect(Collectors.toList());
            dto.setDefects(defectDtos);
        } else {
            // 3. 如果记录不存在
            dto.setExistingRecord(false);
            // 3.1 从 prp_lot 获取基础信息
            List<Prp_lot> lots = prpLotMapper.selectByLotname(lotname);
            if (lots == null || lots.isEmpty()) {
                throw new RuntimeException("批次信息不存在");
            }
            Prp_lot lot = lots.get(0);
            Integer samlqty = lot.getPanelpcs().intValue() * 12;
            Integer totalqty = lot.getTotalqty().intValue();
            dto.setProductPn(lot.getProductpn());
            dto.setTotalQty(totalqty);
            if(samlqty > totalqty){
                dto.setSampleQty(totalqty);
            }else {
                dto.setSampleQty(samlqty); // 默认抽查数
            }
            dto.setPanelPcs(lot.getPanelpcs().intValue());
            dto.setDefects(new ArrayList<>()); // 空的缺陷列表
        }
        return dto;
    }

    @Override
    @Transactional
    public void upsertLqcRecord(LqcRecordDto recordDto, String username) {
        if (recordDto.getRecordId() != null && !recordDto.getRecordId().isEmpty()) {
            // --- 更新逻辑 ---
            // 1. 更新主表
            LqcRecord mainRecord = new LqcRecord();
            mainRecord.setId(recordDto.getRecordId());
            mainRecord.setTotalQty(recordDto.getTotalQty());
            mainRecord.setSampleQty(recordDto.getSampleQty());
            mainRecord.setRecordStatus("CREATED");//更新为未审批
            mainRecord.setTotalDefectQty(recordDto.getTotalDefectQty());
            mainRecord.setLastUpdatedBy(username);
            mainRecord.setAttribute1(recordDto.getJudgementResult());
            mainRecord.setAttribute2(String.valueOf(recordDto.getPanelPcs()));
            lqcRecordMapper.update(mainRecord);

            // 2. 先删除所有旧明细
            lqcRecordDetailMapper.deleteByRecordId(recordDto.getRecordId());

            // 3. 重新插入所有新明细
            for (LqcRecordDto.DefectDetailDto detailDto : recordDto.getDefects()) {
                LqcRecordDetail detailRecord = new LqcRecordDetail();
                detailRecord.setId(UUID.randomUUID().toString().replace("-", ""));
                detailRecord.setRecordId(recordDto.getRecordId());
                detailRecord.setDefectName(detailDto.getName());
                detailRecord.setDefectQty(detailDto.getQty());

                lqcRecordDetailMapper.insert(detailRecord);
            }
        } else {

            this.saveLqcRecord(recordDto,username);
            // --- 新增逻辑 (与之前的 saveLqcRecord 相同) ---
            // ... (此处省略，代码与之前的 saveLqcRecord 逻辑一致)
        }
    }

    @Override
    public List<ProductionRecordVO> findProductionRecords(String employeeId, LocalDate date, String workType) {
        // 实现“当天8点到次日8点为一天”的逻辑
        LocalDateTime startDateTime = date.atTime(LocalTime.of(8, 0));
        LocalDateTime endDateTime = startDateTime.plusDays(1);

        Date startTimeFrom = Date.from(startDateTime.atZone(ZoneId.systemDefault()).toInstant());
        Date startTimeTo = Date.from(endDateTime.atZone(ZoneId.systemDefault()).toInstant());

        // 调用 Mapper 的新方法
        List<ProductionRecord> records = productionRecordMapper.findProductionRecords(
                employeeId, workType, startTimeFrom, startTimeTo);

        return records.stream()
                .map(this::convertToVO)
                .collect(Collectors.toList());
    }

    @Override
    public GetEquipmentParametersResponseDto getEquipmentParameters(String identifier) {
        // 1. 根据设备编码或资产编码查找设备实体
        Equipment equipment = equipmentMapper.findByCodeOrAssetsCode(identifier);
        if (equipment == null || "N".equals(equipment.getEnableFlag())) {
            throw new BusinessException("设备不存在或已禁用");
        }

        GetEquipmentParametersResponseDto response = new GetEquipmentParametersResponseDto();
        response.setEquipmentId(equipment.getId());
        response.setEquipmentCode(equipment.getEqpCode());
        response.setEquipmentName(equipment.getEqpName());
        // 假设设备本身没有在线/离线状态，我们认为凡是需要录入参数的都是离线
        response.setIsOnline(false);

        // 2. 【V3 核心逻辑】按优先级查找参数
        // 优先级1: 查找该设备的独立参数 (EPM_PARAM_OVERRIDE)
        List<ParamOverride> overrideParams = paramOverrideMapper.findByEqpId(equipment.getId());

        if (!CollectionUtils.isEmpty(overrideParams)) {
            // 2.1 如果找到了独立参数，则使用独立参数
            response.setParamSource("OVERRIDE"); // 设置参数来源为“独立”
            response.setParameters(overrideParams.stream()
                    .filter(p -> "Y".equals(p.getEnableFlag())) // 只返回启用的参数
                    .map(this::convertFromOverrideEntity)
                    .collect(Collectors.toList()));
        } else {
            // 2.2 如果没有独立参数，则查找设备类型的默认参数 (EPM_EQP_TYPE_PARAM)
            //String prefix = extractPrefixFromEqpCode(equipment);

            if (equipment.getEqpTypeId() == null) {
                // 如果设备没有关联类型，且没有独立参数，则返回空列表
                response.setParameters(Collections.emptyList());
            } else {
                response.setParamSource("DEFAULT"); // 设置参数来源为“默认”
                List<EquipmentTypeParam> defaultParams = equipmentTypeParamMapper.findEnabledByEqpTypeId(equipment.getEqpTypeId());
                response.setParameters(defaultParams.stream()
                        .map(this::convertFromTypeParamEntity)
                        .collect(Collectors.toList()));
            }
        }

        return response;
    }
    private String extractPrefixFromEqpCode(Equipment equipment) {
        String eqpCode = equipment.getEqpCode();
        String location = equipment.getLocation();
        if (eqpCode == null || eqpCode.isEmpty()) {
            return null;
        }
        int lastDashIndex = eqpCode.lastIndexOf('-');
        if (lastDashIndex > 0) {
            // 确保 '-' 不是最后一个字符
            if (lastDashIndex < eqpCode.length() - 1) {
                // 检查 '-' 后面的部分是否是纯数字 (可选，增加健壮性)
                String suffix = eqpCode.substring(lastDashIndex + 1);
                if (suffix.matches("\\d+")) { // 正则表达式 \d+ 匹配一个或多个数字
                    return eqpCode.substring(0, lastDashIndex + 1) + location; // 返回包含最后一个 '-' 的前缀
                }
            }
            // 如果规则不完全匹配 (例如 ALM-ZHT-A)，可以返回原始code或null，根据业务决定
            // return eqpCode;
        }
        // 如果没有 '-' 或不符合规则，可以返回 null 或原始 code
        return null;
    }

//    public EquipmentParametersDto getEquipmentParameters(String equipmentIdentifier) {
//        if (!StringUtils.hasText(equipmentIdentifier)) {
//            throw new BusinessException("设备编号不能为空");
//        }
//
//        // 1. 校验设备是否存在
//        Equipment equipment = equipmentMapper.findByCodeOrAssetsCode(equipmentIdentifier);
//        if (equipment == null) {
//            throw new BusinessException("设备不存在，请确认设备编号或资产编号");
//        }
//        if (!"Y".equals(equipment.getEnableFlag())) {
//            throw new BusinessException("设备已禁用");
//        }
//
//        // 2. 准备返回的DTO
//        EquipmentParametersDto dto = new EquipmentParametersDto();
//        dto.setEquipmentId(equipment.getEqpCode());
//        dto.setEquipmentName(equipment.getEqpName());
//        // TODO: 判断设备是否在线的逻辑，这里暂时写死为false
//        // 后续可能需要查询设备状态表或调用IoT接口
//        dto.setOnline(false);
//
//        // 3. 如果设备没有关联类型，则直接返回，不带任何参数
//        if (!StringUtils.hasText(equipment.getEqpTypeId())) {
//            dto.setParameters(Collections.emptyList());
//            return dto;
//        }
//
//        // 4. 根据设备类型ID，查询所有预设参数
//        List<EquipmentTypeParam> params = equipmentTypeParamMapper.findEnabledByEqpTypeId(equipment.getEqpTypeId());
//        if (params.isEmpty()) {
//            dto.setParameters(Collections.emptyList());
//            return dto;
//        }
//
//        // 5. 将数据库实体转换为前端需要的DTO格式
//        List<ParameterDto> parameterDtos = params.stream()
//                .map(this::convertToParameterDto)
//                .collect(Collectors.toList());
//
//        dto.setParameters(parameterDtos);
//        return dto;
//    }
    /**
     * 将数据库实体 EquipmentTypeParam 转换为前端DTO ParameterDto
     */


    private ParameterDto convertToParameterDto(EquipmentTypeParam param) {
        ParameterDto dto = new ParameterDto();
        dto.setParamKey(param.getParamKey());
        dto.setParamName(param.getParamName());
        dto.setStandardDisplay(param.getStandardDisplay());

        ValidationDto validationDto = new ValidationDto();
        validationDto.setType(param.getValidationType().toLowerCase()); // e.g., "range"
        validationDto.setDataType(param.getDataType().toLowerCase()); // e.g., "number"

        // 解析 validation_rule JSON字符串
        try {
            JsonNode ruleNode = objectMapper.readTree(param.getValidationRule().traverse());
            String type = param.getValidationType();

            if ("RANGE".equalsIgnoreCase(type)) {
                List<Object> ruleList = new ArrayList<>();
                ruleList.add(ruleNode.has("min") && !ruleNode.get("min").isNull() ? ruleNode.get("min").asDouble() : null);
                ruleList.add(ruleNode.has("max") && !ruleNode.get("max").isNull() ? ruleNode.get("max").asDouble() : null);
                validationDto.setRule(ruleList);
            } else if ("EQUALS".equalsIgnoreCase(type)) {
                validationDto.setRule(ruleNode.get("value").asText());
            } else if ("REGEX".equalsIgnoreCase(type)) {
                validationDto.setRule(ruleNode.get("pattern").asText());
            }
        } catch (JsonProcessingException | NullPointerException e) {
            // 如果JSON解析失败，可以记录日志，并设置一个空的规则，避免程序崩溃
            // log.error("Failed to parse validation rule for param: {}", param.getId(), e);
            validationDto.setRule(null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        dto.setValidation(validationDto);
        return dto;
    }

    private EquipmentTypeParamDto convertFromOverrideEntity(ParamOverride entity) {
        EquipmentTypeParamDto dto = new EquipmentTypeParamDto();
        BeanUtils.copyProperties(entity, dto); // 简化属性复制

        // 确保 shiftBased 字段被正确映射
        dto.setShiftBased(entity.getShiftBased());

        // 构建前端需要的 validation 对象
        EquipmentTypeParamDto.Validation validation = new EquipmentTypeParamDto.Validation();
        validation.setDataType(entity.getDataType());
        validation.setType(entity.getValidationType());
        validation.setRule(parseValidationRule(entity.getValidationRule(), entity.getDataType(), entity.getValidationType()));
        dto.setValidation(validation);

        return dto;
    }

    private EquipmentTypeParamDto convertFromTypeParamEntity(EquipmentTypeParam entity) {
        EquipmentTypeParamDto dto = new EquipmentTypeParamDto();
        BeanUtils.copyProperties(entity, dto);

        // 确保 shiftBased 字段被正确映射
        dto.setShiftBased(entity.getShiftBased());

        EquipmentTypeParamDto.Validation validation = new EquipmentTypeParamDto.Validation();
        validation.setDataType(entity.getDataType());
        validation.setType(entity.getValidationType());
        validation.setRule(parseValidationRule(entity.getValidationRule(), entity.getDataType(), entity.getValidationType()));
        dto.setValidation(validation);

        return dto;
    }
    private ProductionRecordVO convertToVO(ProductionRecord entity) {
        ProductionRecordVO vo = new ProductionRecordVO();
        vo.setLotCode(entity.getLotCode());
        vo.setEquipmentId(entity.getEquipmentId());
        vo.setId(entity.getId());
        vo.setLotCode(entity.getLotCode());
        // 【修复】productCode 是通过JOIN查询得到的，可以直接使用
        vo.setProductCode(entity.getProductCode());
        vo.setEquipmentId(entity.getEquipmentId());
        vo.setStartTime(entity.getStartTime());
        vo.setEndTime(entity.getEndTime());
        vo.setStatus(entity.getStatus());
        vo.setPnlQty(entity.getPnlQty());
        vo.setPcsQty(entity.getPcsQty());
        vo.setBatchGroupId(entity.getBatchGroupId());
        vo.setWorkstationId(entity.getWorkstationId());


        // 状态文本转换
        if ("INPROGRESS".equalsIgnoreCase(entity.getStatus())) {
            vo.setStatusText("进行中");
        } else if ("COMPLETED".equalsIgnoreCase(entity.getStatus())) {
            vo.setStatusText("已完成");
        } else {
            vo.setStatusText("未知");
        }

        return vo;
    }

    private Object parseValidationRule(JsonNode ruleNode, String dataType, String validationType) {
        // 1. 检查节点是否为 null 或表示 JSON null
        if (ruleNode == null || ruleNode.isNull()) {
            return null;
        }

        // 2. 根据校验类型处理
        if ("RANGE".equalsIgnoreCase(validationType)) {
            // 对于范围类型，我们期望一个包含 min 和/或 max 属性的对象
            if (ruleNode.isObject()) {
                JsonNode minNode = ruleNode.get("min");
                JsonNode maxNode = ruleNode.get("max");

                if ("NUMBER".equalsIgnoreCase(dataType)) {
                    // 如果是数字类型，返回一个 Number 数组
                    Number min = (minNode != null && minNode.isNumber()) ? minNode.asDouble() : null;
                    Number max = (maxNode != null && maxNode.isNumber()) ? maxNode.asDouble() : null;
                    return new Number[]{min, max};
                } else {
                    // 否则，返回一个 String 数组
                    String min = (minNode != null && !minNode.isNull()) ? minNode.asText(null) : null;
                    String max = (maxNode != null && !maxNode.isNull()) ? maxNode.asText(null) : null;
                    return new String[]{min, max};
                }
            }
        }

        if ("EQUALS".equalsIgnoreCase(validationType)) {
            // 对于等于类型，我们期望一个包含 value 属性的对象
            if (ruleNode.isObject() && ruleNode.has("value")) {
                JsonNode valueNode = ruleNode.get("value");
                if ("NUMBER".equalsIgnoreCase(dataType) && valueNode.isNumber()) {
                    return valueNode.asDouble();
                }
                return valueNode.asText();
            }
        }

        if ("REGEX".equalsIgnoreCase(validationType)) {
            // 对于正则类型，我们期望一个包含 pattern 属性的对象
            if (ruleNode.isObject() && ruleNode.has("pattern")) {
                return ruleNode.get("pattern").asText();
            }
        }

        // 降级处理：如果以上规则都不匹配，或者 ruleNode 本身就是一个简单值（而不是对象），
        // 则直接返回它的文本表示形式。
        return ruleNode.asText();
    }
    private String getValidationTypeFromEntity(Object entity) {
        if (entity instanceof ParamOverride) {
            return ((ParamOverride) entity).getValidationType();
        } else if (entity instanceof EquipmentTypeParam) {
            return ((EquipmentTypeParam) entity).getValidationType();
        }
        return null;
    }
    @Override
    public LotInfoDto checkLot(String lotCode) {
        if (!StringUtils.hasText(lotCode)) {
            throw new BusinessException("批次号不能为空");
        }

        LotInfoDto lotInfo = materialModuleMapper.findLotInfo(lotCode);

        if (lotInfo == null) {
            throw new BusinessException("批次不存在，请确认批次号");
        }
        try{
            AddPackingRecordDto packingInfo= packingMapper.findAddQtyByLot(lotCode);
            if(packingInfo!=null&&(packingInfo.getSumPackQty()!=0)||(packingInfo.getSumPcs()!=0)||(packingInfo.getSumPnl()!=0))
            {
                lotInfo.setSumPackQty(packingInfo.getSumPackQty());
                lotInfo.setSumPnl(packingInfo.getSumPnl());
                lotInfo.setSumPcs(packingInfo.getSumPcs());
            }
        }catch(Exception e){
                lotInfo.setSumPackQty(0);
                lotInfo.setSumPnl(0);
                lotInfo.setSumPcs(0);
        }




        // 您可以在这里根据实际业务增加对批次状态的校验
        // 例如:
        // if ("HOLD".equalsIgnoreCase(lotInfo.getStatus()) || "SCRAP".equalsIgnoreCase(lotInfo.getStatus())) {
        //     throw new BusinessException("批次状态异常，当前状态为: " + lotInfo.getStatus());
        // }

        return lotInfo;
    }

    @Override
    public ProductionQuotaDto getProductionQuota(String lotCode, String equipmentId,
                                                 String stationId, String lotSite) {
        LotInfoDto lotInfo = checkLot(lotCode);
        ProductionStationScope scope;
        if (StringUtils.hasText(equipmentId)) {
            scope = resolveProductionStation(
                    equipmentId, stationId, lotSite, lotInfo.getLotSite());
        } else {
            String effectiveLotSite = resolveSelectedLotSite(lotSite, null, lotInfo.getLotSite());
            if (!StringUtils.hasText(stationId) && !StringUtils.hasText(effectiveLotSite)) {
                throw new BusinessException("操作台或批次在制站点不能为空");
            }
            scope = new ProductionStationScope(trimToNull(stationId), effectiveLotSite);
        }
        return buildProductionQuota(lotInfo, scope.stationId, scope.lotSite,
                trimToNull(equipmentId), null);
    }

    @Override
    public void checkMaterial(String materialCode,String lotCode) {
        if (!StringUtils.hasText(materialCode)) {
            throw new BusinessException("物料编码不能为空");
        }

        // 1. 首先查询 upn 表
        Integer countInUpn = materialModuleMapper.countByUpnName(materialCode);
        if (countInUpn != null && countInUpn > 0) {
            // 在 upn 表中找到，校验通过
            Integer countInRW=  materialModuleMapper.countByLotNameAndUpn(lotCode,materialCode);
            if(countInRW != null && countInRW > 0){
                return;
            }
            throw new BusinessException("物料不属于当前批次的用料，请确认");
        }

        // 2. 如果 upn 表中没有，再查询 prp_lot 表
        Integer countInPrpLot = materialModuleMapper.countByLotNameAndSection(materialCode, "AUX");
        if (countInPrpLot != null && countInPrpLot > 0) {
            // 在 prp_lot 表中找到，校验通过
            Integer countInRW=  materialModuleMapper.countByLotNameAndLotName(lotCode,materialCode);
            if(countInRW != null && countInRW > 0){
                return;
            }
            throw new BusinessException("物料不属于当前批次的用料，请确认");
        }

        // 3. 如果两个表都没有找到，则抛出异常
        throw new BusinessException("物料不存在，请确认");
    }

    @Override
    @Transactional // 保证所有数据库操作在同一个事务中
    public String addEquipmentProduction(AddProductionRecordDto recordDto) {
        if (recordDto == null || !StringUtils.hasText(recordDto.getEmployeeId())
                || !StringUtils.hasText(recordDto.getEquipmentId())
                || !StringUtils.hasText(recordDto.getLotCode())) {
            throw new BusinessException("员工、设备和批次不能为空");
        }

        Hrdetail employee = userprofileMapper.selectByHrDetail(recordDto.getEmployeeId());
        if (employee == null) {
            throw new BusinessException("员工不存在");
        }
        String siteCode = employee.getSite();

        LotInfoDto lotInfo = materialModuleMapper.findLotInfo(recordDto.getLotCode());
        if (lotInfo == null) {
            throw new BusinessException("批次信息不存在");
        }
        ProductionStationScope stationScope = resolveProductionStation(recordDto.getEquipmentId(),
                recordDto.getStationId(),
                resolveSelectedLotSite(recordDto.getSiteName(), recordDto.getSiteCode(), null),
                lotInfo.getLotSite());
        String lotSite = stationScope.lotSite;
        String requestId = normalizeRequestId(recordDto.getRequestId());

        lockProductionLots(Collections.singleton(lotInfo.getLotCode()));
        ProductionRecord existing = findIdempotentSingle(requestId, recordDto);
        if (existing != null) {
            return existing.getId();
        }

        validateQuantityRelationship(recordDto.getPnl(), recordDto.getPcs(), lotInfo.getPanelPcs());
        validateProductionQuota(lotInfo, stationScope.stationId, lotSite,
                recordDto.getEquipmentId(), recordDto.getPcs(), null);

        // 2. 构建主记录对象
        ProductionRecord record = new ProductionRecord();
        String recordId = UUID.randomUUID().toString().replace("-", "");
        record.setId(recordId);
        record.setRecordType("EQUIPMENT");
        record.setEmployeeId(recordDto.getEmployeeId());
        record.setEquipmentId(recordDto.getEquipmentId());
        record.setLotCode(recordDto.getLotCode());
        record.setPnlQty(recordDto.getPnl());
        record.setPcsQty(recordDto.getPcs());
        record.setStartTime(new Date());
        record.setStatus("INPROGRESS");
        record.setSiteCode(siteCode); // 设置员工站点
        record.setLotSite(lotSite);   // 设置过站站点
        record.setRemark(recordDto.getRemark()); // 设置备注
        record.setCreateBy(recordDto.getEmployeeId());
        record.setCreateTime(new Date());
        record.setWorkstationId(stationScope.stationId);
        record.setRequestId(requestId);

        // 3. 插入主记录
        productionRecordMapper.insertProductionRecord(record);

        // 4. 批量插入物料记录
        if (!CollectionUtils.isEmpty(recordDto.getMaterials())) {
            List<RecordMaterial> materials = recordDto.getMaterials().stream().map(materialCode -> {
                RecordMaterial rm = new RecordMaterial();
                rm.setId(UUID.randomUUID().toString().replace("-", ""));
                rm.setRecordId(recordId);
                rm.setMaterialCode(materialCode);
                return rm;
            }).collect(Collectors.toList());
            recordMaterialMapper.batchInsertMaterials(materials);
        }

        // 5. 批量插入参数记录 (假设前端传递的是一个Map)
        if (recordDto.getParameters() != null && !recordDto.getParameters().isEmpty()) {
            List<RecordParameter> parameters = recordDto.getParameters().entrySet().stream().map(entry -> {
                RecordParameter rp = new RecordParameter();
                rp.setId(UUID.randomUUID().toString().replace("-", ""));
                rp.setRecordId(recordId);
                rp.setParamKey(entry.getKey());
                rp.setParamValue(String.valueOf(entry.getValue()));
                // TODO: 可以从设备参数定义表中冗余param_name, standard_display, is_valid等字段
                return rp;
            }).collect(Collectors.toList());
            recordMaterialMapper.batchInsertParameters(parameters);
        }
        return recordId;
    }

    @Override
    @Transactional
    public void endProductionTask(EndProductionTaskDto taskDto) {
        if (taskDto == null || !StringUtils.hasText(taskDto.getRecordId())) {
            throw new BusinessException("生产记录ID不能为空");
        }
        // 1. 先定位批次并加锁，再重新读取记录，避免两次结束请求并发通过状态校验。
        ProductionRecord record = recordMaterialMapper.findById(taskDto.getRecordId());
        if (record == null) {
            throw new BusinessException("生产记录不存在");
        }
        LotInfoDto lotInfo = materialModuleMapper.findLotInfo(record.getLotCode());
        if (lotInfo == null) {
            throw new BusinessException("生产批次不存在");
        }
        lockProductionLots(Collections.singleton(lotInfo.getLotCode()));
        record = recordMaterialMapper.findById(taskDto.getRecordId());
        lotInfo = materialModuleMapper.findLotInfo(record.getLotCode());
        if (lotInfo == null) {
            throw new BusinessException("生产批次不存在");
        }
        if (!"INPROGRESS".equals(record.getStatus())) {
            throw new BusinessException("该任务不是进行中状态，无法结束");
        }

        BigDecimal finalPcs = capEndPcsToWip(taskDto.getPcs(), lotInfo);
        BigDecimal finalPnl = calculatePnlFromPcs(finalPcs, lotInfo.getPanelPcs(), taskDto.getPnl());
        validateQuantityRelationship(finalPnl, finalPcs, lotInfo.getPanelPcs());
        validateReplacementQuota(lotInfo, record.getWorkstationId(), record.getLotSite(),
                record.getEquipmentId(), record.getPcsQty(), finalPcs);

        // 2. 更新记录
        record.setPnlQty(finalPnl);
        record.setPcsQty(finalPcs);
        record.setEndTime(new Date());
        record.setStatus("COMPLETED");
        if (taskDto.getRemark() != null) {
            record.setRemark(taskDto.getRemark());
        }

        record.setUpdateBy(taskDto.getEmployeeId());
        record.setUpdateTime(new Date());

        // 3. 执行更新
        int updatedRows = recordMaterialMapper.updateProductionRecord(record);
        if (updatedRows == 0) {
            throw new BusinessException("结束任务失败，请重试");
        }

        // 3. 更新物料清单 (先删后增)
        recordMaterialMapper.deleteByRecordId(taskDto.getRecordId());

        if (taskDto.getMaterials() != null && !taskDto.getMaterials().isEmpty()) {
            List<RecordMaterial> materialEntities = taskDto.getMaterials().stream()
                    .map(materialCode -> {
                        RecordMaterial material = new RecordMaterial();
                        material.setId(UUID.randomUUID().toString().replace("-", ""));
                        material.setRecordId(taskDto.getRecordId());
                        material.setMaterialCode(materialCode);
                        return material;
                    })
                    .collect(Collectors.toList());
            recordMaterialMapper.batchInsert(materialEntities);
        }
    }

    // ════════════════════════════════════════════════════════════════════
    // 【新增】设备作业批量录入 / 一键结束 / 批量详情
    // ════════════════════════════════════════════════════════════════════

    @Override
    @Transactional
    public String addEquipmentProductionBatch(com.jcd.dto.AddProductionBatchDto dto) {
        if (dto == null || dto.getLots() == null || dto.getLots().isEmpty()) {
            throw new BusinessException("批次列表不能为空");
        }
        if (dto.getEmployeeId() == null || dto.getEquipmentId() == null) {
            throw new BusinessException("员工和设备不能为空");
        }
        String requestId = normalizeRequestId(dto.getRequestId());

        // 1. 校验员工 + 站点
        Hrdetail userprofile = userprofileMapper.selectByHrDetail(dto.getEmployeeId());
        if (userprofile == null) {
            throw new BusinessException("员工不存在");
        }
        String siteCode = userprofile.getSite();
        ProductionStationScope stationScope = resolveProductionStation(dto.getEquipmentId(),
                dto.getStationId(), resolveSelectedLotSite(dto.getSiteName(), dto.getSiteCode(), null), null);
        String selectedLotSite = stationScope.lotSite;

        // 2. 校验所有批次：必须存在 + 料号必须全部相同
        String firstProduct = null;
        java.util.List<LotInfoDto> lotInfos = new java.util.ArrayList<>();
        java.util.Set<String> lotCodes = new java.util.HashSet<>();
        for (com.jcd.dto.AddProductionBatchDto.LotItem item : dto.getLots()) {
            if (item.getLotCode() == null || item.getLotCode().trim().isEmpty()) {
                throw new BusinessException("存在空批次号");
            }
            if (!lotCodes.add(item.getLotCode().trim())) {
                throw new BusinessException("批次重复: " + item.getLotCode());
            }
            LotInfoDto info = materialModuleMapper.findLotInfo(item.getLotCode());
            if (info == null) {
                throw new BusinessException("批次不存在: " + item.getLotCode());
            }
            if (firstProduct == null) {
                firstProduct = info.getProduct();
            } else if (!firstProduct.equals(info.getProduct())) {
                throw new BusinessException("批量提交的批次料号必须一致（"
                        + firstProduct + " vs " + info.getProduct() + "）");
            }
            lotInfos.add(info);
        }

        lockProductionLots(lotCodes);

        String existingBatchGroupId = findIdempotentBatch(requestId, dto);
        if (existingBatchGroupId != null) {
            return existingBatchGroupId;
        }

        for (int i = 0; i < dto.getLots().size(); i++) {
            com.jcd.dto.AddProductionBatchDto.LotItem item = dto.getLots().get(i);
            LotInfoDto info = lotInfos.get(i);
            validateQuantityRelationship(item.getPnl(), item.getPcs(), info.getPanelPcs());
            String quotaLotSite = StringUtils.hasText(selectedLotSite) ? selectedLotSite : info.getLotSite();
            validateProductionQuota(info, stationScope.stationId, quotaLotSite,
                    dto.getEquipmentId(), item.getPcs(), null);
        }

        // 3. 生成 batchGroupId，逐条写入主记录 + 物料 + 参数（共享一份参数 map）
        String batchGroupId = UUID.randomUUID().toString().replace("-", "");
        Date now = new Date();

        for (int i = 0; i < dto.getLots().size(); i++) {
            com.jcd.dto.AddProductionBatchDto.LotItem item = dto.getLots().get(i);
            LotInfoDto info = lotInfos.get(i);

            String recordId = UUID.randomUUID().toString().replace("-", "");
            ProductionRecord record = new ProductionRecord();
            record.setId(recordId);
            record.setRecordType("EQUIPMENT");
            record.setEmployeeId(dto.getEmployeeId());
            record.setEquipmentId(dto.getEquipmentId());
            record.setLotCode(item.getLotCode());
            record.setPnlQty(item.getPnl());
            record.setPcsQty(item.getPcs());
            record.setStartTime(now);
            record.setStatus("INPROGRESS");
            record.setSiteCode(siteCode);
            record.setLotSite(StringUtils.hasText(selectedLotSite) ? selectedLotSite : info.getLotSite());
            record.setRemark(dto.getRemark());
            record.setCreateBy(dto.getEmployeeId());
            record.setCreateTime(now);
            record.setBatchGroupId(batchGroupId);
            record.setWorkstationId(stationScope.stationId);
            record.setRequestId(requestId);

            productionRecordMapper.insertProductionRecord(record);

            // 物料
            if (!CollectionUtils.isEmpty(item.getMaterials())) {
                List<RecordMaterial> materials = item.getMaterials().stream().map(materialCode -> {
                    RecordMaterial rm = new RecordMaterial();
                    rm.setId(UUID.randomUUID().toString().replace("-", ""));
                    rm.setRecordId(recordId);
                    rm.setMaterialCode(materialCode);
                    return rm;
                }).collect(Collectors.toList());
                recordMaterialMapper.batchInsertMaterials(materials);
            }

            // 参数（共享一份，每条记录都写一份便于单条追溯）
            if (dto.getParameters() != null && !dto.getParameters().isEmpty()) {
                List<RecordParameter> parameters = dto.getParameters().entrySet().stream().map(entry -> {
                    RecordParameter rp = new RecordParameter();
                    rp.setId(UUID.randomUUID().toString().replace("-", ""));
                    rp.setRecordId(recordId);
                    rp.setParamKey(entry.getKey());
                    rp.setParamValue(String.valueOf(entry.getValue()));
                    return rp;
                }).collect(Collectors.toList());
                recordMaterialMapper.batchInsertParameters(parameters);
            }
        }

        return batchGroupId;
    }

    private String normalizeRequestId(String requestId) {
        if (StringUtils.hasText(requestId)) {
            String value = requestId.trim();
            if (value.length() > 64) {
                throw new BusinessException("提交请求号长度不能超过64位");
            }
            return value;
        }
        // 兼容尚未升级的旧客户端；升级后的客户端会传入稳定请求号以获得完整幂等保护。
        return "SERVER-" + UUID.randomUUID().toString().replace("-", "");
    }

    private String trimToNull(String value) {
        return StringUtils.hasText(value) ? value.trim() : null;
    }

    private void lockProductionLots(Collection<String> lotCodes) {
        java.util.List<String> sorted = lotCodes.stream()
                .filter(StringUtils::hasText)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        if (sorted.isEmpty()) {
            throw new BusinessException("生产批次不能为空");
        }
        for (String lotCode : sorted) {
            String locked = productionRecordMapper.lockProductionLot(lotCode);
            if (!StringUtils.hasText(locked)) {
                throw new BusinessException("生产批次不存在: " + lotCode);
            }
        }
    }

    private ProductionRecord findIdempotentSingle(String requestId, AddProductionRecordDto dto) {
        List<ProductionRecord> records = productionRecordMapper.findRecordsByRequestId(requestId);
        if (records == null || records.isEmpty()) {
            return null;
        }
        if (records.size() != 1
                || !Objects.equals(records.get(0).getLotCode(), dto.getLotCode())
                || !Objects.equals(records.get(0).getEquipmentId(), dto.getEquipmentId())) {
            throw new BusinessException("提交请求号已被其他作业使用，请返回后重新录入");
        }
        return records.get(0);
    }

    private String findIdempotentBatch(String requestId, AddProductionBatchDto dto) {
        List<ProductionRecord> records = productionRecordMapper.findRecordsByRequestId(requestId);
        if (records == null || records.isEmpty()) {
            return null;
        }
        java.util.Set<String> expectedLots = dto.getLots().stream()
                .map(AddProductionBatchDto.LotItem::getLotCode)
                .collect(Collectors.toSet());
        java.util.Set<String> actualLots = records.stream()
                .map(ProductionRecord::getLotCode)
                .collect(Collectors.toSet());
        boolean sameEquipment = records.stream()
                .allMatch(record -> Objects.equals(record.getEquipmentId(), dto.getEquipmentId()));
        String batchGroupId = records.get(0).getBatchGroupId();
        boolean sameGroup = records.stream()
                .allMatch(record -> Objects.equals(record.getBatchGroupId(), batchGroupId));
        if (!expectedLots.equals(actualLots) || !sameEquipment || !sameGroup || !StringUtils.hasText(batchGroupId)) {
            throw new BusinessException("提交请求号已被其他作业使用，请返回后重新录入");
        }
        return batchGroupId;
    }

    private void validateQuantityRelationship(BigDecimal pnl, BigDecimal pcs, Integer panelPcs) {
        if (pnl == null || pcs == null || pnl.compareTo(BigDecimal.ZERO) <= 0
                || pcs.compareTo(BigDecimal.ZERO) <= 0) {
            throw new BusinessException("PNL和PCS数量必须大于0");
        }
        if (panelPcs != null && panelPcs > 0) {
            BigDecimal calculatedPnl = pcs.divide(BigDecimal.valueOf(panelPcs), 0, RoundingMode.CEILING);
            if (calculatedPnl.compareTo(pnl) != 0) {
                throw new BusinessException("PNL与PCS数量不匹配，应为 " + calculatedPnl + " PNL");
            }
        }
    }

    /** 结束任务时，旧版APP提交的PCS超过当前WIP则自动使用WIP；较小数量保持不变。 */
    private BigDecimal capEndPcsToWip(BigDecimal requestedPcs, LotInfoDto lotInfo) {
        if (requestedPcs == null || lotInfo == null || lotInfo.getWipQty() == null) {
            return requestedPcs;
        }
        return requestedPcs.compareTo(lotInfo.getWipQty()) > 0
                ? lotInfo.getWipQty() : requestedPcs;
    }

    /** 结束任务的PNL始终由最终PCS按拼版数向上取整。 */
    private BigDecimal calculatePnlFromPcs(BigDecimal pcs, Integer panelPcs, BigDecimal fallbackPnl) {
        if (pcs == null || panelPcs == null || panelPcs <= 0) {
            return fallbackPnl;
        }
        return pcs.divide(BigDecimal.valueOf(panelPcs), 0, RoundingMode.CEILING);
    }

    private void validateProductionQuota(LotInfoDto lotInfo, String stationId, String lotSite,
                                         String equipmentId, BigDecimal requestedPcs,
                                         String excludeRecordId) {
        ProductionQuotaDto quota = buildProductionQuota(
                lotInfo, stationId, lotSite, equipmentId, excludeRecordId);
        if (requestedPcs.compareTo(quota.getRemainingPcs()) > 0) {
            throw new BusinessException("本批次在当前设备/站点仅剩 " + quota.getRemainingPcs()
                    + " PCS（" + quota.getRemainingPnl() + " PNL），本次提交 "
                    + requestedPcs + " PCS，已禁止提交");
        }
    }

    private ProductionQuotaDto buildProductionQuota(LotInfoDto lotInfo, String stationId,
                                                     String lotSite, String equipmentId,
                                                     String excludeRecordId) {
        if (lotInfo == null || !StringUtils.hasText(lotInfo.getLotCode())) {
            throw new BusinessException("生产批次不存在");
        }
        if (lotInfo.getWipQty() == null || lotInfo.getWipQty().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BusinessException("批次WIP数量必须大于0");
        }
        if (lotInfo.getPanelPcs() == null || lotInfo.getPanelPcs() <= 0) {
            throw new BusinessException("批次PANELPCS未维护，无法提交生产作业");
        }
        String effectiveLotSite = StringUtils.hasText(lotSite) ? lotSite.trim() : lotInfo.getLotSite();
        if (!StringUtils.hasText(stationId) && !StringUtils.hasText(effectiveLotSite)) {
            throw new BusinessException("无法确定设备作业站点");
        }
        ProductionAllocatedQtyDto allocated = productionRecordMapper.sumAllocatedQty(
                lotInfo.getLotCode(), trimToNull(stationId), effectiveLotSite,
                trimToNull(equipmentId), excludeRecordId);
        BigDecimal allocatedPnl = allocated == null || allocated.getAllocatedPnl() == null
                ? BigDecimal.ZERO : allocated.getAllocatedPnl();
        BigDecimal allocatedPcs = allocated == null || allocated.getAllocatedPcs() == null
                ? BigDecimal.ZERO : allocated.getAllocatedPcs();
        BigDecimal remainingPcs = lotInfo.getWipQty().subtract(allocatedPcs);
        if (remainingPcs.compareTo(BigDecimal.ZERO) < 0) remainingPcs = BigDecimal.ZERO;
        BigDecimal panelPcs = BigDecimal.valueOf(lotInfo.getPanelPcs());
        BigDecimal batchPnl = lotInfo.getWipQty().divide(panelPcs, 0, RoundingMode.CEILING);
        BigDecimal remainingPnl = remainingPcs.divide(panelPcs, 0, RoundingMode.CEILING);

        ProductionQuotaDto quota = new ProductionQuotaDto();
        quota.setLotCode(lotInfo.getLotCode());
        quota.setStationId(trimToNull(stationId));
        quota.setLotSite(effectiveLotSite);
        quota.setPanelPcs(lotInfo.getPanelPcs());
        quota.setBatchPnl(batchPnl);
        quota.setBatchPcs(lotInfo.getWipQty());
        quota.setAllocatedPnl(allocatedPnl);
        quota.setAllocatedPcs(allocatedPcs);
        quota.setRemainingPnl(remainingPnl);
        quota.setRemainingPcs(remainingPcs);
        return quota;
    }

    private String quotaScopeKey(String lotCode, String stationId, String lotSite, String equipmentId) {
        String stationScope = StringUtils.hasText(stationId)
                ? "ID:" + stationId.trim()
                : "SITE:" + (StringUtils.hasText(lotSite) ? lotSite.trim().toUpperCase(Locale.ROOT) : "");
        String equipmentScope = StringUtils.hasText(equipmentId)
                ? "EQP:" + equipmentId.trim().toUpperCase(Locale.ROOT) : "MANUAL";
        return lotCode + "|" + stationScope + "|" + equipmentScope;
    }

    private void validateReplacementQuota(LotInfoDto lotInfo, String stationId, String lotSite,
                                          String equipmentId, BigDecimal currentPcs,
                                          BigDecimal requestedPcs) {
        BigDecimal current = currentPcs == null ? BigDecimal.ZERO : currentPcs;
        BigDecimal requested = requestedPcs == null ? BigDecimal.ZERO : requestedPcs;
        // 历史重复数据可能已经超额；不增加占用的结束操作仍应允许完成。
        if (requested.compareTo(current) <= 0) {
            return;
        }
        ProductionQuotaDto quota = buildProductionQuota(
                lotInfo, stationId, lotSite, equipmentId, null);
        BigDecimal finalAllocated = quota.getAllocatedPcs()
                .subtract(current)
                .add(requested);
        if (finalAllocated.compareTo(lotInfo.getWipQty()) > 0) {
            BigDecimal available = lotInfo.getWipQty()
                    .subtract(quota.getAllocatedPcs())
                    .add(current);
            if (available.compareTo(BigDecimal.ZERO) < 0) available = BigDecimal.ZERO;
            BigDecimal availablePnl = available.divide(
                    BigDecimal.valueOf(lotInfo.getPanelPcs()), 0, RoundingMode.CEILING);
            throw new BusinessException("本批次在当前设备/站点调整后最多可录入 " + available
                    + " PCS（" + availablePnl + " PNL），本次合计 " + requestedPcs + " PCS，已禁止结束");
        }
    }

    private ProductionStationScope resolveProductionStation(String equipmentId, String requestedStationId,
                                                             String requestedLotSite, String fallbackLotSite) {
        List<EquipmentStationBinding> bindings = equipmentStationBindingMapper.listByEqpCode(equipmentId);
        if (bindings == null || bindings.isEmpty()) {
            String lotSite = resolveSelectedLotSite(requestedLotSite, null, fallbackLotSite);
            if (!StringUtils.hasText(lotSite)) {
                throw new BusinessException("设备未绑定站点，批次也无法带出在制站点");
            }
            // 未维护绑定时只能使用批次在制站点，忽略客户端伪造的 stationId。
            return new ProductionStationScope(null, lotSite);
        }

        EquipmentStationBinding selected = null;
        if (StringUtils.hasText(requestedStationId)) {
            String stationId = requestedStationId.trim();
            for (EquipmentStationBinding binding : bindings) {
                if (stationId.equals(binding.getStationId())) {
                    selected = binding;
                    break;
                }
            }
        } else if (bindings.size() == 1) {
            selected = bindings.get(0);
        }
        if (selected == null) {
            throw new BusinessException("所选站点不属于当前设备，请重新扫描设备并选择站点");
        }

        String canonicalLotSite = StringUtils.hasText(selected.getStationDesc())
                ? selected.getStationDesc().trim()
                : (StringUtils.hasText(selected.getStationName())
                    ? selected.getStationName().trim() : selected.getStationId());
        return new ProductionStationScope(selected.getStationId(), canonicalLotSite);
    }

    private static class ProductionStationScope {
        private final String stationId;
        private final String lotSite;

        private ProductionStationScope(String stationId, String lotSite) {
            this.stationId = stationId;
            this.lotSite = lotSite;
        }
    }

    private String resolveSelectedLotSite(String siteName, String siteCode, String fallbackLotSite) {
        if (StringUtils.hasText(siteName)) {
            return siteName.trim();
        }
        if (StringUtils.hasText(siteCode)) {
            return siteCode.trim();
        }
        return fallbackLotSite;
    }

    @Override
    @Transactional
    public void endProductionTaskBatch(com.jcd.dto.EndProductionBatchDto dto) {
        if (dto == null || dto.getBatchGroupId() == null || dto.getBatchGroupId().trim().isEmpty()) {
            throw new BusinessException("批量分组ID不能为空");
        }
        if (dto.getItems() == null || dto.getItems().isEmpty()) {
            throw new BusinessException("结束项列表不能为空");
        }

        // 1. 查同组所有记录，建索引
        List<ProductionRecordDetailVO> groupRecords =
                productionRecordMapper.findRecordsByBatchGroupId(dto.getBatchGroupId());
        if (groupRecords == null || groupRecords.isEmpty()) {
            throw new BusinessException("批量任务不存在或已无记录");
        }
        java.util.Map<String, ProductionRecordDetailVO> indexById = new java.util.HashMap<>();
        for (ProductionRecordDetailVO r : groupRecords) {
            indexById.put(r.getId(), r);
        }

        // 2. 先校验归属并收集批次，随后统一加锁，避免多台设备同时调整数量。
        java.util.Map<String, LotInfoDto> lotInfoByRecordId = new java.util.HashMap<>();
        java.util.Set<String> lotCodes = new java.util.HashSet<>();
        for (com.jcd.dto.EndProductionBatchDto.EndItem it : dto.getItems()) {
            ProductionRecordDetailVO r = indexById.get(it.getRecordId());
            if (r == null) {
                throw new BusinessException("记录不属于本批量任务: " + it.getRecordId());
            }
            LotInfoDto lotInfo = materialModuleMapper.findLotInfo(r.getLotCode());
            if (lotInfo == null) {
                throw new BusinessException("生产批次不存在: " + r.getLotCode());
            }
            lotInfoByRecordId.put(it.getRecordId(), lotInfo);
            lotCodes.add(lotInfo.getLotCode());
        }
        lockProductionLots(lotCodes);

        // 加锁后重新读取状态；并按“批次+站点”计算调整后的最终PCS占用。
        groupRecords = productionRecordMapper.findRecordsByBatchGroupId(dto.getBatchGroupId());
        indexById.clear();
        for (ProductionRecordDetailVO r : groupRecords) {
            indexById.put(r.getId(), r);
        }
        // 兼容旧版APP：结束PCS超过当前WIP时自动使用WIP，较小的实际生产数保持不变。
        for (com.jcd.dto.EndProductionBatchDto.EndItem it : dto.getItems()) {
            ProductionRecordDetailVO r = indexById.get(it.getRecordId());
            if (r == null || !"INPROGRESS".equalsIgnoreCase(r.getStatus())) {
                throw new BusinessException("记录已结束或不存在: " + it.getRecordId());
            }
            LotInfoDto currentLotInfo = materialModuleMapper.findLotInfo(r.getLotCode());
            if (currentLotInfo == null) {
                throw new BusinessException("生产批次不存在: " + r.getLotCode());
            }
            BigDecimal finalPcs = capEndPcsToWip(it.getPcs(), currentLotInfo);
            BigDecimal finalPnl = calculatePnlFromPcs(finalPcs, currentLotInfo.getPanelPcs(), it.getPnl());
            it.setPcs(finalPcs);
            it.setPnl(finalPnl);
            validateQuantityRelationship(finalPnl, finalPcs, currentLotInfo.getPanelPcs());
            lotInfoByRecordId.put(it.getRecordId(), currentLotInfo);
        }
        java.util.Map<String, BigDecimal> currentByScope = new java.util.HashMap<>();
        java.util.Map<String, BigDecimal> requestedByScope = new java.util.HashMap<>();
        java.util.Map<String, LotInfoDto> infoByScope = new java.util.HashMap<>();
        java.util.Map<String, ProductionRecordDetailVO> recordByScope = new java.util.HashMap<>();
        for (com.jcd.dto.EndProductionBatchDto.EndItem it : dto.getItems()) {
            ProductionRecordDetailVO r = indexById.get(it.getRecordId());
            if (r == null || !"INPROGRESS".equalsIgnoreCase(r.getStatus())) {
                throw new BusinessException("记录已结束或不存在: " + it.getRecordId());
            }
            LotInfoDto info = lotInfoByRecordId.get(it.getRecordId());
            String scopeKey = quotaScopeKey(
                    info.getLotCode(), r.getWorkstationId(), r.getLotSite(), r.getEquipmentId());
            currentByScope.merge(scopeKey,
                    r.getPcsQty() == null ? BigDecimal.ZERO : r.getPcsQty(), BigDecimal::add);
            requestedByScope.merge(scopeKey, it.getPcs(), BigDecimal::add);
            infoByScope.put(scopeKey, info);
            recordByScope.put(scopeKey, r);
        }
        for (String scopeKey : requestedByScope.keySet()) {
            ProductionRecordDetailVO scopeRecord = recordByScope.get(scopeKey);
            validateReplacementQuota(infoByScope.get(scopeKey), scopeRecord.getWorkstationId(),
                    scopeRecord.getLotSite(), scopeRecord.getEquipmentId(),
                    currentByScope.get(scopeKey), requestedByScope.get(scopeKey));
        }

        // 3. 逐条结束（复用 endProductionTask 的写入语义，但在同一事务内）
        Date now = new Date();
        for (com.jcd.dto.EndProductionBatchDto.EndItem it : dto.getItems()) {
            ProductionRecord record = recordMaterialMapper.findById(it.getRecordId());
            if (record == null) {
                throw new BusinessException("生产记录不存在: " + it.getRecordId());
            }
            if (!"INPROGRESS".equals(record.getStatus())) {
                throw new BusinessException("该任务不是进行中状态: " + it.getRecordId());
            }

            record.setPnlQty(it.getPnl());
            record.setPcsQty(it.getPcs());
            record.setEndTime(now);
            record.setStatus("COMPLETED");
            if (dto.getRemark() != null) {
                record.setRemark(dto.getRemark());
            }
            record.setUpdateBy(dto.getEmployeeId());
            record.setUpdateTime(now);

            int updated = recordMaterialMapper.updateProductionRecord(record);
            if (updated == 0) {
                throw new BusinessException("结束任务失败: " + it.getRecordId());
            }

            // 物料先删后增
            recordMaterialMapper.deleteByRecordId(it.getRecordId());
            if (it.getMaterials() != null && !it.getMaterials().isEmpty()) {
                List<RecordMaterial> materials = it.getMaterials().stream().map(code -> {
                    RecordMaterial m = new RecordMaterial();
                    m.setId(UUID.randomUUID().toString().replace("-", ""));
                    m.setRecordId(it.getRecordId());
                    m.setMaterialCode(code);
                    return m;
                }).collect(Collectors.toList());
                recordMaterialMapper.batchInsert(materials);
            }
        }
    }

    @Override
    public com.jcd.vo.BatchProductionDetailVO getBatchProductionDetail(String batchGroupId) {
        if (batchGroupId == null || batchGroupId.trim().isEmpty()) {
            throw new BusinessException("批量分组ID不能为空");
        }
        List<ProductionRecordDetailVO> records =
                productionRecordMapper.findRecordsByBatchGroupId(batchGroupId);
        if (records == null || records.isEmpty()) {
            throw new BusinessException("批量任务不存在");
        }

        // 为每条记录补齐物料、参数
        for (ProductionRecordDetailVO r : records) {
            r.setMaterials(productionRecordMapper.findMaterialsByRecordId(r.getId()));
            r.setParameters(productionRecordMapper.findParametersByRecordId(r.getId()));
        }

        com.jcd.vo.BatchProductionDetailVO vo = new com.jcd.vo.BatchProductionDetailVO();
        ProductionRecordDetailVO first = records.get(0);
        vo.setBatchGroupId(batchGroupId);
        vo.setEmployeeId(first.getEmployeeId());
        vo.setEquipmentId(first.getEquipmentId());
        vo.setProductCode(first.getProductCode());
        vo.setRemark(first.getRemark());
        vo.setParameters(first.getParameters()); // 共享参数定义
        vo.setRecords(records);
        vo.setLotCount(records.size());
        vo.setPanelPcs(productionRecordMapper.findPanelPcsByLotCode(first.getLotCode()));

        // 汇总数量、起止时间、整体状态
        BigDecimal totalPnl = BigDecimal.ZERO;
        BigDecimal totalPcs = BigDecimal.ZERO;
        Date earliestStart = null;
        Date latestEnd = null;
        boolean anyInprogress = false;
        for (ProductionRecordDetailVO r : records) {
            if (r.getPnlQty() != null) totalPnl = totalPnl.add(r.getPnlQty());
            if (r.getPcsQty() != null) totalPcs = totalPcs.add(r.getPcsQty());
            if (r.getStartTime() != null
                    && (earliestStart == null || r.getStartTime().before(earliestStart))) {
                earliestStart = r.getStartTime();
            }
            if (r.getEndTime() != null
                    && (latestEnd == null || r.getEndTime().after(latestEnd))) {
                latestEnd = r.getEndTime();
            }
            if ("INPROGRESS".equalsIgnoreCase(r.getStatus())) {
                anyInprogress = true;
            }
        }
        vo.setTotalPnl(totalPnl);
        vo.setTotalPcs(totalPcs);
        vo.setStartTime(earliestStart);
        vo.setEndTime(anyInprogress ? null : latestEnd);
        vo.setStatus(anyInprogress ? "INPROGRESS" : "COMPLETED");
        vo.setStatusText(anyInprogress ? "进行中" : "已完成");

        return vo;
    }

    @Override
    @Transactional
    public void addMaterialToRecord(AddMaterialRequest request) {
        RecordMaterial material = new RecordMaterial();
        material.setId(UUID.randomUUID().toString().replace("-", ""));
        material.setRecordId(request.getRecordId());
        material.setMaterialCode(request.getMaterialCode());
        recordMaterialMapper.insert(material);
    }

    @Override
    @Transactional
    public void removeMaterialFromRecord(RemoveMaterialRequest request) {
        recordMaterialMapper.deleteByRecordIdAndMaterialCode(request.getRecordId(), request.getMaterialCode());
    }

    @Override
    public ProductionRecordDetailVO getProductionRecordDetail(String recordId) {
        // 1. 查询主记录信息
        ProductionRecordDetailVO detailVO = productionRecordMapper.findRecordDetailById(recordId);
        if (detailVO == null) {
            throw new BusinessException("生产记录不存在");
        }

        // 2. 查询关联的物料信息
        List<RecordMaterial> materials = productionRecordMapper.findMaterialsByRecordId(recordId);
        detailVO.setMaterials(materials);

        // 3. 查询关联的参数信息
        List<RecordParameter> parameters = productionRecordMapper.findParametersByRecordId(recordId);
        detailVO.setParameters(parameters);

        // 4. (可选) 获取 panelPcs 用于前端计算
        Integer panelPcs = productionRecordMapper.findPanelPcsByLotCode(detailVO.getLotCode());
        detailVO.setPanelPcs(panelPcs);

        return detailVO;
    }

    @Override
    public WorkstationDto checkWorkstation(String workstationCode) {
        if (workstationCode == null || workstationCode.trim().isEmpty()) {
            throw new BusinessException("操作台编码不能为空");
        }

        Workstation workstation = workstationMapper.findByCode(workstationCode);

        if (workstation == null) {
            throw new BusinessException("操作台不存在");
        }

        if (!"Y".equalsIgnoreCase(workstation.getEnableFlag())) {
            throw new BusinessException("操作台已禁用");
        }

        WorkstationDto dto = new WorkstationDto();
        dto.setWorkstationId(workstation.getWorkstationCode());
        dto.setWorkstationName(workstation.getWorkstationName());

        return dto;
    }
    @Override
    @Transactional
    public void addManualProduction(ManualProductionAddDto dto) {

        if (dto == null || !StringUtils.hasText(dto.getEmployeeId())
                || !StringUtils.hasText(dto.getLotCode())) {
            throw new BusinessException("员工和生产批次不能为空");
        }
        LotInfoDto lotInfo = checkLot(dto.getLotCode());
        BigDecimal pnl = BigDecimal.valueOf(dto.getPnl());
        BigDecimal pcs = BigDecimal.valueOf(dto.getPcs());
        String effectiveLotSite = resolveSelectedLotSite(dto.getLotSite(), null, lotInfo.getLotSite());
        lockProductionLots(Collections.singleton(lotInfo.getLotCode()));
        validateQuantityRelationship(pnl, pcs, lotInfo.getPanelPcs());
        String workstationId = trimToNull(dto.getWorkstationId());
        validateProductionQuota(lotInfo, workstationId, effectiveLotSite,
                null, pcs, null);

        // 查找并自动结束该员工上一个未完成的人工任务
        ProductionRecord existingTask = productionRecordMapper.findInprogressTaskByEmployee(dto.getEmployeeId(), "MANUAL");

        if (existingTask != null) {
            existingTask.setStatus("COMPLETED");

            existingTask.setEndTime(new Date());
            existingTask.setUpdateBy(dto.getEmployeeId()); // 记录由谁触发的自动结束
            existingTask.setUpdateTime(new Date());
            productionRecordMapper.updateByPrimaryKey(existingTask); // 调用通用的update方法

            //response.setPreviousTaskClosed(true);
            //response.setPreviousTaskLotCode(existingTask.getLotCode());
        }


        ProductionRecord record = new ProductionRecord();
        String recordId = UUID.randomUUID().toString().replace("-", "");

        record.setId(recordId);
        record.setRecordType("MANUAL"); // 记录类型为人工
        record.setEmployeeId(dto.getEmployeeId());
        record.setWorkstationId(workstationId);
        record.setLotCode(dto.getLotCode());
        record.setPnlQty(pnl);
        record.setPcsQty(pcs);
        record.setStatus("INPROGRESS");
        record.setStartTime(Date.from(Instant.parse(dto.getStartTime())));

        // 保存站点信息
        record.setSiteCode(dto.getSiteCode());
        record.setLotSite(effectiveLotSite);
        record.setRemark(dto.getRemark()); // 设置备注

        // 创建人信息 (后续可从用户上下文中获取)
        record.setCreateBy(dto.getEmployeeId());
        record.setCreateTime(new Date());

        // 1. 插入主记录
        productionRecordMapper.insert(record);

        // 2. 批量插入物料
        //List<RecordMaterial> materials = recordDto.getMaterials().stream().map(materialCode -> {
        //    RecordMaterial rm = new RecordMaterial();
        // 4. 批量插入物料记录
        if (!CollectionUtils.isEmpty(dto.getMaterials())) {
            List<RecordMaterial> materials = dto.getMaterials().stream().map(materialCode -> {
                RecordMaterial rm = new RecordMaterial();
                rm.setId(UUID.randomUUID().toString().replace("-", ""));
                rm.setRecordId(recordId);
                rm.setMaterialCode(materialCode);
                return rm;
            }).collect(Collectors.toList());
            recordMaterialMapper.batchInsertMaterials(materials);
        }
    }

    @Override
    public AppVersionDto getLatestVersion(String appId, String platform) {
        SysAppVersion latestVersion = materialModuleMapper.findLatestVersion(appId, platform);
        if (latestVersion == null) {
            return null; // 如果找不到，返回null
        }
        return convertToDto(latestVersion);
    }

    private AppVersionDto convertToDto(SysAppVersion entity) {
        AppVersionDto dto = new AppVersionDto();
        dto.setVersion(entity.getVersionName());
        dto.setDownloadUrl(entity.getDownloadUrl());
        dto.setNotes(entity.getUpdateNotes());
        // 检查是否为强制更新
        dto.setForceUpdate("Y".equalsIgnoreCase(String.valueOf(entity.getIsForced())));
        return dto;
    }



    @Override
    public UserPermissionInfoDto getUserPermissions(String employeeId) {
        UserPermissionInfoDto resultDto = new UserPermissionInfoDto();
        resultDto.setEmployeeId(employeeId);

        MesInspUsers user = inspectionAuthMapper.findUserByEmployeeId(employeeId);

        if (user == null || !"Y".equals(user.getIsActive())) {
            resultDto.setHasPermission(false);
            resultDto.setPermissions(Collections.emptyList());
            return resultDto;
        }

        resultDto.setEmployeeName(user.getEmployeeName());

        List<UserPermissionInfoDto.PermissionDetail> permissions = inspectionAuthMapper.findPermissionsByUserId(user.getId());

        if (CollectionUtils.isEmpty(permissions)) {
            resultDto.setHasPermission(false);
            resultDto.setPermissions(Collections.emptyList());
        } else {
            resultDto.setHasPermission(true);
            resultDto.setPermissions(permissions);
        }

        return resultDto;
    }


    @Override
    public LotScanResponseDto getDataForLotScan(String site, String lotCode) {
        // 1. 根据站点查询不良项列表
        List<MesInspDefectItems> defectItems = inspectionMapper.findBySite(site);
        List<DefectItemDto> defectItemDtos = defectItems.stream().map(item -> {
            DefectItemDto dto = new DefectItemDto();
            BeanUtils.copyProperties(item, dto);
            return dto;
        }).collect(Collectors.toList());

        // 2. 根据批次号查询批次信息
        // 【注意】此处为模拟逻辑。在您的真实场景中，您需要替换为调用您系统中查询批次信息的真实服务。

        List<Prp_lot> lots = lotfindbyLotname(lotCode);
        LotScanResponseDto.LotInfo lotInfo = new LotScanResponseDto.LotInfo();
        LotScanResponseDto response = new LotScanResponseDto();
        if (lots != null && !lots.isEmpty()) {
            Prp_lot lot = lots.get(0);
            Map<String, Object> data = new HashMap<>();
            data.put("lotname", lot.getLotname());
            data.put("productPn", lot.getProductpn());
            data.put("totalQty", lot.getTotalqty());
            data.put("panelpcs", lot.getPanelpcs());

            lotInfo.setProductCode(lot.getProductpn());
            lotInfo.setDefaultTotalQty(lot.getTotalqty());
            RoundingMode roundingMode = RoundingMode.CEILING;
            int scale = 0;
            //defaultSampleQty = defectQty.divide(panelPcs, scale, roundingMode);
            lotInfo.setDefaultSampleQty(lot.getDefectqty().divide(lot.getPanelpcs(),scale, roundingMode));

            response.setLotInfo(lotInfo);
            response.setDefectItems(defectItemDtos);

        }else {

            response.setLotInfo(null);
            response.setDefectItems(null);
        }



        return response;
    }

    @Override
    @Transactional
    public InspectionRecordDto saveOrUpdateDraft(InspectionRecordDto recordDto, String operatorId) {
        if (StringUtils.hasText(recordDto.getId())) {
            // ============ 更新逻辑 ============
            MesInspRecords existingRecord = inspectionMapper.findRecordById(recordDto.getId());
            if (existingRecord == null) {
                throw new BusinessException("记录不存在，无法更新");
            }
            // 只有草稿或被退回的记录才能被创建者编辑
            if (!existingRecord.getInspectorId().equals(operatorId)) {
                throw new BusinessException("您不是该记录的创建者，无法编辑");
            }
            if (!"DRAFT".equals(existingRecord.getStatus()) && !existingRecord.getStatus().startsWith("REJECTED")) {
                throw new BusinessException("记录已提交审批，无法编辑");
            }

            // 更新主表信息
            existingRecord.setEquipmentCode(recordDto.getEquipmentCode());
            existingRecord.setTotalQty(Long.valueOf(recordDto.getTotalQty()));
            existingRecord.setSampleQty(Long.valueOf(recordDto.getSampleQty()));
            existingRecord.setInspectionTime(new Date()); // 更新操作时间
            existingRecord.setUpdateBy(operatorId);
            existingRecord.setUpdateTime(new Date());
            inspectionMapper.updateRecord(existingRecord);

            // 更新明细表信息 (采用先删后增的策略，最简单可靠)
            inspectionMapper.deleteByRecordId(existingRecord.getId());
            if (!CollectionUtils.isEmpty(recordDto.getDetails())) {
                List<MesInspRecordDetails> details = recordDto.getDetails().stream().map(detailDto -> {
                    MesInspRecordDetails detail = new MesInspRecordDetails();
                    detail.setId(UUID.randomUUID().toString().replace("-", ""));
                    detail.setRecordId(existingRecord.getId());
                    detail.setDefectName(detailDto.getDefectName());
                    detail.setDefectQty(Long.valueOf(detailDto.getDefectQty()));
                    return detail;
                }).collect(Collectors.toList());
                inspectionMapper.batchInsert(details);
            }

            return findRecordDtoById(existingRecord.getId());

        } else {
            // ============ 新增逻辑 ============
            MesInspRecords newRecord = new MesInspRecords();
            BeanUtils.copyProperties(recordDto, newRecord);

            String recordId = UUID.randomUUID().toString().replace("-", "");
            newRecord.setId(recordId);
            newRecord.setInspectorId(operatorId);
            newRecord.setStatus("DRAFT"); // 初始状态为草稿
            newRecord.setInspectionTime(new Date());
            newRecord.setCreateBy(operatorId);
            newRecord.setCreateTime(new Date());

            inspectionMapper.insertRecord(newRecord);

            // 插入明细记录
            if (!CollectionUtils.isEmpty(recordDto.getDetails())) {
                List<MesInspRecordDetails> details = recordDto.getDetails().stream().map(detailDto -> {
                    MesInspRecordDetails detail = new MesInspRecordDetails();
                    detail.setId(UUID.randomUUID().toString().replace("-", ""));
                    detail.setRecordId(recordId);
                    detail.setDefectName(detailDto.getDefectName());
                    detail.setDefectQty(Long.valueOf(detailDto.getDefectQty()));
                    return detail;
                }).collect(Collectors.toList());
                inspectionMapper.batchInsert(details);
            }
            return findRecordDtoById(recordId);
        }
    }

    @Override
    @Transactional
    public InspectionRecordDto submitForApproval(String recordId, String operatorId) {
        MesInspRecords record = inspectionMapper.findRecordById(recordId);
        if (record == null) {
            throw new BusinessException("记录不存在");
        }
        if (!record.getInspectorId().equals(operatorId)) {
            throw new BusinessException("您不是该记录的创建者，无法提交");
        }
        if (!"DRAFT".equals(record.getStatus()) && !record.getStatus().startsWith("REJECTED")) {
            throw new BusinessException("只有草稿或被退回的记录才能提交审批");
        }

        // 【核心业务逻辑】根据公司审批流，决定下一状态
        // 这里我们简化为直接提交给班长
        record.setStatus("PENDING_SHIFT_APPROVAL");
        record.setUpdateBy(operatorId);
        record.setUpdateTime(new Date());

        inspectionMapper.updateRecord(record);
        return findRecordDtoById(recordId);
    }

    private InspectionRecordDto findRecordDtoById(String recordId) {
        MesInspRecords record = inspectionMapper.findRecordById(recordId);
        if (record == null) return null;

        List<MesInspRecordDetails> details = inspectionMapper.findByRecordId(recordId);

        InspectionRecordDto dto = new InspectionRecordDto();
        BeanUtils.copyProperties(record, dto);

        List<InspectionRecordDto.DetailDto> detailDtos = details.stream().map(detail -> {
            InspectionRecordDto.DetailDto detailDto = new InspectionRecordDto.DetailDto();
            BeanUtils.copyProperties(detail, detailDto);
            return detailDto;
        }).collect(Collectors.toList());

        dto.setDetails(detailDtos);
        return dto;
    }

    // ==================== 料号参数 & 班次回填 ====================

    /**
     * 按料号获取有效参数（优先级：料号参数 > 设备独立参数 > 类型默认参数）
     */
    @Override
    public GetEquipmentParametersResponseDto getEquipmentParametersWithProduct(
            String equipmentIdentifier, String productCode) {
        // 1. 先按原逻辑获取设备基础信息（含 isOnline、equipmentName、OVERRIDE/DEFAULT 参数）
        GetEquipmentParametersResponseDto base = getEquipmentParameters(equipmentIdentifier);

        // 2. 尝试从 EPM_PARAM_PRODUCT 获取料号参数
        List<EpmParamProduct> productParams =
                epmParamProductMapper.findByEqpIdAndProductCode(base.getEquipmentId(), productCode);

        if (!CollectionUtils.isEmpty(productParams)) {
            // 3a. 有料号参数 → 转换为 EquipmentTypeParamDto 列表
            List<EquipmentTypeParamDto> params = productParams.stream()
                    .filter(p -> "Y".equals(p.getEnableFlag()))
                    .map(this::convertFromProductParamEntity)
                    .collect(Collectors.toList());
            base.setParameters(params);
            base.setParamSource("PRODUCT");
        }
        // 3b. 无料号参数 → 沿用 base 已返回的 OVERRIDE/DEFAULT 参数

        return base;
    }

    /**
     * 获取当班最近一次该设备+料号的参数值（用于按班次自动回填）
     */
    @Override
    public Map<String, String> getLatestShiftParams(String equipmentIdentifier, String productCode) {
        // 1. 获取设备实际ID
        Equipment equipment = equipmentMapper.findByCodeOrAssetsCode(equipmentIdentifier);
        if (equipment == null) {
            return Collections.emptyMap();
        }

        // 2. 获取当前班次起止时间
        //    早班 08:00~20:00, 晚班 20:00~次日08:00
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime shiftStart;
        LocalDateTime shiftEnd;

        int hour = now.getHour();
        if (hour >= 8 && hour < 20) {
            // 早班
            shiftStart = now.toLocalDate().atTime(8, 0);
            shiftEnd = now.toLocalDate().atTime(20, 0);
        } else {
            // 晚班
            if (hour >= 20) {
                shiftStart = now.toLocalDate().atTime(20, 0);
                shiftEnd = now.toLocalDate().plusDays(1).atTime(8, 0);
            } else {
                // 0:00 ~ 8:00 属于前一天晚班
                shiftStart = now.toLocalDate().minusDays(1).atTime(20, 0);
                shiftEnd = now.toLocalDate().atTime(8, 0);
            }
        }

        // 转换为 Date
        Date shiftStartDate = Date.from(shiftStart.atZone(ZoneId.systemDefault()).toInstant());
        Date shiftEndDate = Date.from(shiftEnd.atZone(ZoneId.systemDefault()).toInstant());

        // 3. 查询最近一条记录的参数
        List<Map<String, String>> paramRows = productionRecordMapper.getLatestShiftParamValues(
                equipment.getEqpCode(), productCode, shiftStartDate, shiftEndDate);

        // 4. 转换为 Map<paramKey, paramValue>
        Map<String, String> result = new HashMap<>();
        if (paramRows != null) {
            for (Map<String, String> row : paramRows) {
                String key = row.get("paramKey");
                String value = row.get("paramValue");
                if (key != null) {
                    result.put(key, value);
                }
            }
        }
        return result;
    }

    /**
     * 将 EpmParamProduct 实体转换为 EquipmentTypeParamDto（含 shiftBased 字段）
     */
    private EquipmentTypeParamDto convertFromProductParamEntity(EpmParamProduct entity) {
        EquipmentTypeParamDto dto = new EquipmentTypeParamDto();
        dto.setId(entity.getId());
        dto.setParamKey(entity.getParamKey());
        dto.setParamName(entity.getParamName());
        dto.setParamOrder(entity.getParamOrder());
        dto.setUnit(entity.getUnit());
        dto.setStandardDisplay(entity.getStandardDisplay());
        dto.setDataType(entity.getDataType());
        dto.setValidationType(entity.getValidationType());
        dto.setValidationRule(entity.getValidationRule());
        dto.setEnableFlag(entity.getEnableFlag());
        dto.setShiftBased(entity.getShiftBased());

        // 构建前端需要的 validation 对象
        EquipmentTypeParamDto.Validation validation = new EquipmentTypeParamDto.Validation();
        validation.setDataType(entity.getDataType());
        validation.setType(entity.getValidationType());
        validation.setRule(parseValidationRule(entity.getValidationRule(), entity.getDataType(), entity.getValidationType()));
        dto.setValidation(validation);

        return dto;
    }

    /**
     * 按批次的料号去ERP查询标准产能
     */
    public int selectStandardCapacity(String modelName) {
        int result=0;
        try{
            Integer standardCapacity=packingMapper.selectStandardCapacity(modelName);
            result=(standardCapacity==null)?0:standardCapacity;
        }catch(Exception e){
            result=0;
        }

        return result;
    }

    /**
     * 按批次的料号去ERP查询SMT标准产能
     */
    public int selectStandardCapacitySMT(String modelName) {
        int result=0;
        try{
            Integer standardCapacity=packingMapper.selectStandardCapacitySMT(modelName);
            result=(standardCapacity==null)?0:standardCapacity;
        }catch(Exception e){
            result=0;
        }

        return result;
    }

    @Override
    @Transactional
    public void addRepairProduction(RepairProductionAddDto dto) {

        if (dto == null || !StringUtils.hasText(dto.getEmployeeId())
                || !StringUtils.hasText(dto.getLotCode())) {
            throw new BusinessException("员工和生产批次不能为空");
        }
        LotInfoDto lotInfo = checkLot(dto.getLotCode());
        BigDecimal pnl = BigDecimal.valueOf(dto.getPnl());
        BigDecimal pcs = BigDecimal.valueOf(dto.getPcs());
        String effectiveLotSite = resolveSelectedLotSite(dto.getLotSite(), null, lotInfo.getLotSite());
        lockProductionLots(Collections.singleton(lotInfo.getLotCode()));
        validateQuantityRelationship(pnl, pcs, lotInfo.getPanelPcs());
        String workstationId = trimToNull(dto.getWorkstationId());
        validateProductionQuota(lotInfo, workstationId, effectiveLotSite,
                null, pcs, null);

        // 查找并自动结束该员工上一个未完成的人工任务
        ProductionRecord existingTask = productionRecordMapper.findInprogressTaskByEmployee(dto.getEmployeeId(), "MANUAL");

        if (existingTask != null) {
            existingTask.setStatus("COMPLETED");

            existingTask.setEndTime(new Date());
            existingTask.setUpdateBy(dto.getEmployeeId()); // 记录由谁触发的自动结束
            existingTask.setUpdateTime(new Date());
            productionRecordMapper.updateByPrimaryKey(existingTask); // 调用通用的update方法

            //response.setPreviousTaskClosed(true);
            //response.setPreviousTaskLotCode(existingTask.getLotCode());
        }


        ProductionRecord record = new ProductionRecord();
        String recordId = UUID.randomUUID().toString().replace("-", "");

        record.setId(recordId);
        record.setRecordType("REPAIR"); // 记录类型为批次修理
        record.setEmployeeId(dto.getEmployeeId());
        record.setWorkstationId(workstationId);
        record.setLotCode(dto.getLotCode());
        record.setPnlQty(pnl);
        record.setPcsQty(pcs);
        record.setStatus("INPROGRESS");
        record.setStartTime(Date.from(Instant.parse(dto.getStartTime())));

        // 保存站点信息
        record.setSiteCode(dto.getSiteCode());
        record.setLotSite(effectiveLotSite);
        record.setRemark(dto.getRemark()); // 设置备注

        // 创建人信息 (后续可从用户上下文中获取)
        record.setCreateBy(dto.getEmployeeId());
        record.setCreateTime(new Date());

        // 1. 插入主记录
        productionRecordMapper.insert(record);

        // 2. 批量插入物料
        //List<RecordMaterial> materials = recordDto.getMaterials().stream().map(materialCode -> {
        //    RecordMaterial rm = new RecordMaterial();
        // 4. 批量插入物料记录
        if (!CollectionUtils.isEmpty(dto.getMaterials())) {
            List<RecordMaterial> materials = dto.getMaterials().stream().map(materialCode -> {
                RecordMaterial rm = new RecordMaterial();
                rm.setId(UUID.randomUUID().toString().replace("-", ""));
                rm.setRecordId(recordId);
                rm.setMaterialCode(materialCode);
                return rm;
            }).collect(Collectors.toList());
            recordMaterialMapper.batchInsertMaterials(materials);
        }
    }

    @Override
    @Transactional
    public RepairProductionAddDto searchRepairProduction(RepairProductionAddDto dto) {

        if (dto == null || !StringUtils.hasText(dto.getEmployeeId())|| !StringUtils.hasText(dto.getLotCode()))
        {
            throw new BusinessException("员工和生产批次不能为空");
        }
        RepairProductionAddDto repairData=productionRecordMapper.searchLotInfo(dto.getLotCode());
        return repairData;
    }

}



