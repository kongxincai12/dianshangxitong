package com.jcd.service.Impl;

import com.jcd.entity.IqcScanLog;
import com.jcd.entity.IqcTaskInfo;
import com.jcd.mapper.*;
import com.jcd.model.*;
import com.jcd.service.IqcScanService;
import com.jcd.utils.UtilityMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class IqcScanServiceImpl implements IqcScanService {

    @Autowired
    private IqcTaskMapper taskMapper;

    @Autowired
    private IqcScanLogMapper scanLogMapper;

    @Autowired
    private RmmInvoicedetailMapper rmmInvoicedetailMapper;

    @Autowired
    private RmmInvoiceMapper rmmInvoiceMapper;

    @Autowired
    private Rmm_upnprintMapper rmm_upnprintMapper;

    @Autowired
    private IqcMaterialStatusMapper materialStatusMapper;

    @Autowired
    private UpnMapper upnMapper;

    // 常量定义，方便维护
    private static final String DEFAULT_FACTORY_ID = "5E0BBB956B264ABC9619A2FF3AEB54D3";
    private static final String DEFAULT_IQC_STATUS_ID = "917faeae-7c10-4e0e-b8ea-4b6f4a0682c0";//合格


    // ★★★ 固定流程参数
    private static final String FIXED_CURRENT_STEP = "82CD9B520C8F478B8FD6A111C9BDB2AB";
    private static final String FIXED_PROCESS_ID = "458837DD623349078CF125C4864999F7";
    private static final String FIXED_NODE_HANDLE = "100001";

    /**
     * 核心扫码处理逻辑 (加事务锁)
     *
     * @param scanText 扫码原始内容
     * @param detailId 任务ID
     * @param userId   操作员ID
     */
    @Transactional(rollbackFor = Exception.class)
    @Override
    public synchronized Map<String, Object> processScan(String scanText, String detailId, String userId) throws Exception {

        // --- 1. 格式校验 (Rule 1) ---
        String[] parts = scanText.split("\\|");
        if (parts.length < 7) {
            throw new Exception("格式错误：必须符合7段式标准格式: UPN|订单号|厂商型号|数量|批次号|生产日期|有效期");
        }

        String upn = parts[0].trim();
        String po = parts[1].trim();

        BigDecimal qty = new BigDecimal(parts[3].trim());
        String lot = parts[4].trim();
        // 二维码中的日期字符串 (YYYYMMDD)
        String dateCodeStr = parts[5].trim(); // 生产日期
        String expDateStr = parts[6].trim();  // 有效期


        //获取厂内料号
        String[] upnParts=upn.split("-");
        String pn = upnParts[0].trim();

        //获取厂商型号
        String vendorPn = parts[2].trim();

        // --- 获取当前任务详情 ---
        IqcTaskInfo task = taskMapper.selectTaskById(detailId);
        if (task == null) {
            throw new Exception("任务不存在或已过期");
        }

        // --- 2. 订单匹配 (Rule 2) ---
        if (!po.equals(task.getPoNumber())) {
            throw new Exception("PO不一致! 扫码:" + po + ", 任务:" + task.getPoNumber());
        }

        // --- 3. 物料匹配 (Rule 3) ---
        //--- 3.1对比厂内料号 ---
        if (!pn.equals(task.getPartNumber())) {
            throw new Exception("料号不符! 扫码:" + pn + ", 任务:" + task.getPartNumber());
        }
        //--- 3.2对比厂商料号 ---
        if(task.getPartSpec() == null || !task.getPartSpec().contains(vendorPn)) {
            throw new Exception("厂商型号不符! 扫码:" + vendorPn + ", 任务:" + task.getPartSpec());
        }


        // --- 4. 唯一性校验 (Rule 4: 防重码) ---
        int exists = scanLogMapper.checkUpnExists(upn);
        if (exists > 0) {
            throw new Exception("重复扫描！UPN: " + upn + " 已被录入");
        }

        // --- 5. 数量与并发校验 (Rule 5: 防超量) ---
        // 防止空指针，如果没有已扫数量则默认为 0
        BigDecimal currentTotal = task.getScannedQty() == null ? BigDecimal.ZERO : task.getScannedQty();

        Date qrExpDate = null;
        Date qrProdDate = null;
        try {
            // 定义格式化工具：统一转为 yyyyMMdd 字符串进行比对
            SimpleDateFormat sdf8 = new SimpleDateFormat("yyyyMMdd");

            // --- 校验 A：有效期 (Expiry Date) ---
            if (task.getLimitedDay() != null) {
                // 将 Task 中的 Date (可能含时分秒) 格式化为 "yyyyMMdd"
                String taskLimitedStr = sdf8.format(task.getLimitedDay());

                // 二维码有效期 (expDateStr) 已经是 "yyyyMMdd"
                // 直接字符串相等比较
                if (!expDateStr.equals(taskLimitedStr)) {
                   // throw new Exception("有效期不匹配! 标签:" + expDateStr + " != 单据:" + taskLimitedStr);
                }
            }

            // --- 校验 B：生产日期 (Production Date) ---
            // 如果您在 TaskInfo 中也有 datetime 字段需要和二维码的生产日期严格匹配，逻辑同上：

            if (task.getVendorCode() != null) {
                String taskProdStr = task.getVendorWeekCode().replaceAll("[^0-9]", "");
                if (!dateCodeStr.equals(taskProdStr)) {
                    //throw new Exception("生产日期不匹配! 标签:" + dateCodeStr + " != 单据:" + taskProdStr);
                }
            }


            // 简单的格式合法性检查 (确保二维码日期是合法日期)
            sdf8.setLenient(false);
            qrProdDate = sdf8.parse(dateCodeStr);
            qrExpDate = sdf8.parse(expDateStr);

        } catch (java.text.ParseException e) {
            throw new Exception("日期格式解析错误，标签日期格式应为YYYYMMDD");
        }
        // ★★★ 计算本次后的新总数
        BigDecimal newTotal = currentTotal.add(qty);


        if (newTotal.compareTo(task.getTotalQty()) > 0)  {
            throw new Exception("数量超标！当前:" + currentTotal + " + 本次:" + qty + " > 总数:" + task.getTotalQty());
        }





        //更新rmmInvoicedetail表的REMAININGQTY
        RmmInvoicedetail invoicedetail = rmmInvoicedetailMapper.selectByPrimaryKey(detailId);
        BigDecimal totalQty = invoicedetail.getTotalqty() == null ? BigDecimal.ZERO : invoicedetail.getTotalqty();
        BigDecimal newRemaining = totalQty.subtract(newTotal);
        if (newRemaining.compareTo(BigDecimal.ZERO) < 0) {
            newRemaining = BigDecimal.ZERO;
        }

        invoicedetail.setRemainingqty(newRemaining);
        rmmInvoicedetailMapper.updateByPrimaryKeySelective(invoicedetail);

        // --- 通过所有校验，保存记录 ---
        IqcScanLog log = new IqcScanLog();
        log.setInvoiceDetailId(detailId);
        log.setUpn(upn);
        log.setPoNumber(po);
        log.setPartNumber(pn);
        log.setScanQty(qty);
        log.setVendorLot(lot);
        log.setDateCode(dateCodeStr);
        log.setScanBy(userId);

        scanLogMapper.insert(log);

        // --- ★★★ 新增：插入 RMM_UPNPRINT 表 (旧系统逻辑移植) ★★★ ---
        // 参数：task, detail, 扫码解析出的数据, 转换后的日期
        Rmm_upnprint   upnPrintObj = insertUpnPrint(task, invoicedetail, qty, lot, qrProdDate, qrExpDate, userId,upn);

        createAndInsertUpn(upnPrintObj, userId, upn);

        //此处还需要增加一个校验rmm_invoice表是否已经完成的逻辑,如果rmm_invoice对应的明细表都完成了,那么它就要更新状态STATE为FINISH,否则为OH
        checkAndUpdateInvoiceStatus(invoicedetail.getInvoiceid());

        // --- ★★★ 准备返回结果 Map ---
        Map<String, Object> result = new HashMap<>();
        result.put("incrementQty", qty);      // 本次扫的数量
        result.put("totalScanned", newTotal); // 最新的总数量 (用于前端更新 UI)

        // --- 检查是否完成 ---
        if (newTotal.compareTo(task.getTotalQty()) == 0) {
            taskMapper.updateLegacyStatus(detailId);
            result.put("msg", "校验成功 (本单已完成)");
        } else {
            result.put("msg", "校验成功");
        }



        return result;
    }
    private void checkAndUpdateInvoiceStatus(String invoiceId) {
        if (invoiceId == null) return;

        // 1. 查询该 Invoice 下的所有明细

        List<RmmInvoicedetail> details = rmmInvoicedetailMapper.selectByInvoiceId(invoiceId);

        if (details == null || details.isEmpty()) return;

        boolean allFinished = true;

        for (RmmInvoicedetail det : details) {
            //BigDecimal total = det.getTotalqty() == null ? BigDecimal.ZERO : det.getTotalqty();
            // 同样基于你的定义：RemainingQty 是已扫数量
            //BigDecimal scanned = det.getRemainingqty() == null ? BigDecimal.ZERO : det.getRemainingqty();
            BigDecimal remaining = det.getRemainingqty() == null ? BigDecimal.ZERO : det.getRemainingqty();

            // 只要有一行没扫完 (已扫 < 总数)，则整单未完成
            if (remaining.compareTo(BigDecimal.ZERO) > 0) {
                allFinished = false;
                break;
            }
        }

        // 2. 决定新状态
        String newState = allFinished ? "FINISH" : "OH";

        // 3. 更新主表
        RmmInvoice invoice = rmmInvoiceMapper.selectByPrimaryKey(invoiceId);
        if (invoice != null) {
            // 只有状态确实变了才去更新数据库，减少操作
            if (!newState.equals(invoice.getState())) {
                invoice.setState(newState);
                rmmInvoiceMapper.updateByPrimaryKeySelective(invoice);
            }
        }
    }

    private Rmm_upnprint insertUpnPrint(IqcTaskInfo task, RmmInvoicedetail detail,
                                BigDecimal qty, String lot,
                                Date prodDate, Date expDate, String userId,String upn) {

        Rmm_upnprint info = new Rmm_upnprint();

        // 1. 基础关联信息
        info.setPrintid(UtilityMethod.GetUUID());
        info.setInvoiceid(task.getInvoiceId());
        info.setPnid(task.getPnId()); // 直接用 task 中的 pnId
        info.setUpnname(upn);

        // FactoryId 对应 detail 中的 OrganizationCode
        // 需要确认 RmmInvoicedetail 实体中是否有 getOrganizationcode() 方法，如果没有请补充
        // 这里假设您已经加了这个 getter，或者在实体类补充它
        //info.setFactoryid(detail.getOrganizationcode());
        // 暂时用 task 的 supplierCode 或其他字段替代，或者如果您确定 detail 有这个字段：
        info.setFactoryid(DEFAULT_FACTORY_ID);//固定ID

        info.setVendorcode(task.getVendorCode());

        // 2. 数量与日期
        info.setQty(qty);
        info.setLimitedday(expDate);     // 使用二维码解析后的有效期
        info.setVendordatecode(prodDate); // 使用二维码解析后的生产日期

        // 3. 属性信息 (来自 Task)
        info.setEsdlevel(task.getEsdLevel());
        info.setMsdlevel(task.getMsdLevel());
        info.setRoshflag(task.getLeadFree()); // 对应 RoHS
        info.setState("DEFAULT");


        String statusId = DEFAULT_IQC_STATUS_ID;
        if (task.getStatus() != null) {
            IqcMaterialStatus materialStatus = materialStatusMapper.selectByStatus(task.getCheckResult());
            if (materialStatus != null) {
                statusId = materialStatus.getStatusid();
            }
        }
        info.setIqcstatusid(statusId);

        info.setVendorweekcode(task.getVendorWeekCode());

        // 假设 RmmInvoicedetail 实体有 getTransactionid()
        info.setTranscationid(detail.getTransactionid() != null ? detail.getTransactionid() : "");

       //info.setVendorsn(task.getVendorSn());
        info.setVendorsn(lot);

        // 5. 用户与时间
        info.setUsername(userId);
        info.setDatetime(new Date());
        info.setObj1(userId); // Operator

        // 6. 其他规格/批次信息
        // 假设 TaskInfo 或 Detail 中有 Unit
         info.setUom(task.getUnit());

        info.setMaterialattr(task.getPartSpec());
        info.setMaterialstorage(task.getMaterialStorage());
        info.setPackstyle(task.getPackStyle());

        info.setAsn(task.getSubmitNumber());
        info.setObj2(lot); // 供应商批次

        // 执行插入
        rmm_upnprintMapper.insert(info);
        return info;
    }

    private void createAndInsertUpn(Rmm_upnprint upnPrint, String userId, String upn) throws Exception {
        Upn upnInfo = new Upn();

        // 1. 固定流程信息 (由您指定)
        upnInfo.setCurrentstepid(FIXED_CURRENT_STEP);
        upnInfo.setProcessid(FIXED_PROCESS_ID);
        upnInfo.setNodehandle(FIXED_NODE_HANDLE);

        // 2. 基础固定值
        upnInfo.setDatetime(new Date());
        upnInfo.setSplitflag("0");
        upnInfo.setReturnflag("0");
        upnInfo.setUsername(userId);

        // 3. 状态信息
        IqcMaterialStatus iqcMaterialStatus = materialStatusMapper.selectByPrimaryKey(upnPrint.getIqcstatusid());
        // 假设 selectByPrimaryKey 存在，或者使用 selectByStatusId

        upnInfo.setUpnid(UtilityMethod.GetUUID());
        upnInfo.setUpnname(upn); // 直接取 UPN

        // 4. DateCode 转换逻辑 (C# 逻辑移植)
        if (upnPrint.getVendordatecode() != null) {
            Date dt = upnPrint.getVendordatecode();
            SimpleDateFormat sdfYear = new SimpleDateFormat("yy");
            SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
            SimpleDateFormat sdfDay = new SimpleDateFormat("dd");

            String yy = sdfYear.format(dt);
            String mm = sdfMonth.format(dt);
            String dd = sdfDay.format(dt);

            String monthCode = mm;
            if ("10".equals(mm)) monthCode = "A";
            else if ("11".equals(mm)) monthCode = "B";
            else if ("12".equals(mm)) monthCode = "C";

            upnInfo.setDatecode(yy + monthCode + dd);
        } else {
            // 容错逻辑，防止 substring 越界
            int lastDash = upn != null ? upn.lastIndexOf("-") : -1;
            if (lastDash >= 5) {
                upnInfo.setDatecode(upn.substring(lastDash - 5, lastDash));
            } else {
                upnInfo.setDatecode("00000"); // 兜底默认值
            }
        }

        // 5. 状态判断
        upnInfo.setState("ACTIVE");
        if (iqcMaterialStatus != null && "不合格".equals(iqcMaterialStatus.getStatusname())) {
            upnInfo.setState("NG");
        }

        // 6. 属性复制
        upnInfo.setUom(upnPrint.getUom());
        upnInfo.setPackstyle(upnPrint.getPackstyle());
        upnInfo.setMaterialattr(upnPrint.getMaterialattr());
        upnInfo.setMaterialstorage(upnPrint.getMaterialstorage());
        upnInfo.setPnid(upnPrint.getPnid());
        upnInfo.setFactoryid(upnPrint.getFactoryid());

        if (iqcMaterialStatus != null) {
            upnInfo.setIqcstatus(iqcMaterialStatus.getStatusname());
            // 注意类型转换，假设 Fifopriority 是数字字符串
            if(iqcMaterialStatus.getFifopriority() != null) {
                try {
                    upnInfo.setReleasepriority(Integer.parseInt(iqcMaterialStatus.getFifopriority()));
                } catch(NumberFormatException e) {
                    upnInfo.setReleasepriority(0);
                }
            }
        }

        //upnInfo.setMsdlevel(upnPrint.getMsdlevel());
        upnInfo.setLeadfree(upnPrint.getRoshflag()); // 对应 Leadfree
        upnInfo.setTotalqty(upnPrint.getQty());
        upnInfo.setRemainingqty(upnPrint.getQty());

        upnInfo.setIqccheckinfo(""); // 暂无 CheckInfo，设为空
        upnInfo.setAsn(upnPrint.getAsn());
        upnInfo.setMaterialattr2(upnPrint.getMaterialattr2());
        upnInfo.setOthers(upnPrint.getOthers());

        // 7. 更新 UPNPRINT 状态为 PRINTED (模拟已打印)
        upnPrint.setState("PRINTED");
        rmm_upnprintMapper.updateByPrimaryKeySelective(upnPrint);

        // 8. 插入 UPN
        upnMapper.insert(upnInfo);

        // TODO: 如果需要湿敏管控逻辑 (InsertdewcelltimecontrolForPrint)，在此处添加
    }
}
