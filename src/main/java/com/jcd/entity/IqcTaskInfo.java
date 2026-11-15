package com.jcd.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 对应接收单任务列表的实体类
 */
public class IqcTaskInfo implements Serializable {
    private String invoiceDetailId;   // 明细ID (主键)
    private String invoiceId;         // 头ID
    private String invoiceNumber;   // 接收单号
    private String poNumber;        // PO号
    private String partNumber;      // 料号 (PN)
    private String vendorName;      // 供应商名称
    private BigDecimal totalQty;       // 应收总数
    private BigDecimal scannedQty;     // 实收总数 (实时计算)
    private String status;          // 状态 (DEFAULT/OH/CHECKED)
    private String caigouyuanName;  // 采购员
    private BigDecimal realScannedQty;


    private String submitNumber;    // 送货单号
    private String checkResult;     // 检验结果
    private String materialType;    // 物料类型
    private String deliverNumber;   // 厂商送货单号
    private String pnId;            // 料号ID
    private String vendorCode;      // 供应商代码
    private String vendorLotNo;     // 供应商批次
    private String partSpec;        // 物料规格
    private String largeCategory;   // 大类
    private BigDecimal unitQty;     // 单位数量 (UNITQTY)
    private String esdLevel;        // ESD等级
    private String msdLevel;        // MSD等级
    private String leadFree;        // 无铅标识
    private String rmaPo;           // RMA单号
    private String controlFlag;     // 管控标识
    private String mark;            // Mark标记
    private String approvedFlag;    // 审核标识
    private Date datetime;          //生产日期
    private Date limitedDay;        // 有效期/限制日期
    private String packStyle;       // 包装方式
    private String vendorWeekCode;  // 供应商周期代码
    private String vendorSn;        // 供应商SN
    private String materialStorage; // 储位
    private String unit;



    public String getInvoiceDetailId() {
        return invoiceDetailId;
    }

    public void setInvoiceDetailId(String invoiceDetailId) {
        this.invoiceDetailId = invoiceDetailId;
    }

    public String getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(String invoiceId) {
        this.invoiceId = invoiceId;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public String getPoNumber() {
        return poNumber;
    }

    public void setPoNumber(String poNumber) {
        this.poNumber = poNumber;
    }

    public String getPartNumber() {
        return partNumber;
    }

    public void setPartNumber(String partNumber) {
        this.partNumber = partNumber;
    }

    public String getVendorName() {
        return vendorName;
    }

    public void setVendorName(String vendorName) {
        this.vendorName = vendorName;
    }

    public BigDecimal getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(BigDecimal totalQty) {
        this.totalQty = totalQty;
    }

    public BigDecimal getScannedQty() {
        return scannedQty;
    }

    public void setScannedQty(BigDecimal scannedQty) {
        this.scannedQty = scannedQty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCaigouyuanName() {
        return caigouyuanName;
    }

    public void setCaigouyuanName(String caigouyuanName) {
        this.caigouyuanName = caigouyuanName;
    }

    public BigDecimal getRealScannedQty() {
        return realScannedQty;
    }

    public void setRealScannedQty(BigDecimal realScannedQty) {
        this.realScannedQty = realScannedQty;
    }

    public String getPartSpec() {
        return partSpec;
    }

    public void setPartSpec(String partSpec) {
        this.partSpec = partSpec;
    }

    public String getSubmitNumber() {
        return submitNumber;
    }

    public void setSubmitNumber(String submitNumber) {
        this.submitNumber = submitNumber;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public String getDeliverNumber() {
        return deliverNumber;
    }

    public void setDeliverNumber(String deliverNumber) {
        this.deliverNumber = deliverNumber;
    }

    public String getPnId() {
        return pnId;
    }

    public void setPnId(String pnId) {
        this.pnId = pnId;
    }

    public String getVendorCode() {
        return vendorCode;
    }

    public void setVendorCode(String vendorCode) {
        this.vendorCode = vendorCode;
    }

    public String getVendorLotNo() {
        return vendorLotNo;
    }

    public void setVendorLotNo(String vendorLotNo) {
        this.vendorLotNo = vendorLotNo;
    }

    public String getLargeCategory() {
        return largeCategory;
    }

    public void setLargeCategory(String largeCategory) {
        this.largeCategory = largeCategory;
    }

    public BigDecimal getUnitQty() {
        return unitQty;
    }

    public void setUnitQty(BigDecimal unitQty) {
        this.unitQty = unitQty;
    }

    public String getEsdLevel() {
        return esdLevel;
    }

    public void setEsdLevel(String esdLevel) {
        this.esdLevel = esdLevel;
    }

    public String getMsdLevel() {
        return msdLevel;
    }

    public void setMsdLevel(String msdLevel) {
        this.msdLevel = msdLevel;
    }

    public String getLeadFree() {
        return leadFree;
    }

    public void setLeadFree(String leadFree) {
        this.leadFree = leadFree;
    }

    public String getRmaPo() {
        return rmaPo;
    }

    public void setRmaPo(String rmaPo) {
        this.rmaPo = rmaPo;
    }

    public String getControlFlag() {
        return controlFlag;
    }

    public void setControlFlag(String controlFlag) {
        this.controlFlag = controlFlag;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getApprovedFlag() {
        return approvedFlag;
    }

    public void setApprovedFlag(String approvedFlag) {
        this.approvedFlag = approvedFlag;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Date getLimitedDay() {
        return limitedDay;
    }

    public void setLimitedDay(Date limitedDay) {
        this.limitedDay = limitedDay;
    }

    public String getPackStyle() {
        return packStyle;
    }

    public void setPackStyle(String packStyle) {
        this.packStyle = packStyle;
    }

    public String getVendorWeekCode() {
        return vendorWeekCode;
    }

    public void setVendorWeekCode(String vendorWeekCode) {
        this.vendorWeekCode = vendorWeekCode;
    }

    public String getVendorSn() {
        return vendorSn;
    }

    public void setVendorSn(String vendorSn) {
        this.vendorSn = vendorSn;
    }

    public String getMaterialStorage() {
        return materialStorage;
    }

    public void setMaterialStorage(String materialStorage) {
        this.materialStorage = materialStorage;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}