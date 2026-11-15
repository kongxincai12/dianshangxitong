// 用于接收MyBatis进行JOIN查询后的扁平化结果。

package com.jcd.vo;

import java.math.BigDecimal;

public class ApprovalRecordVo {
    // 来自 lqc_records 表
    private String lotName;
    private String productPn;
    private BigDecimal totalQty;
    private BigDecimal sampleQty;
    private BigDecimal totalDefectQty;

    // 来自 lqc_record_details 表
    private String defectName;
    private BigDecimal defectQty;

    // 通过 JOIN userprofile 表获取
    private String inspectorFullname; // 检验员全名
    private String shiftConfirmerFullname; // 班长确认人全名

    // Getters and Setters...
    public String getLotName() { return lotName; }
    public void setLotName(String lotName) { this.lotName = lotName; }
    public String getProductPn() { return productPn; }
    public void setProductPn(String productPn) { this.productPn = productPn; }
    public BigDecimal getTotalQty() { return totalQty; }
    public void setTotalQty(BigDecimal totalQty) { this.totalQty = totalQty; }
    public BigDecimal getSampleQty() { return sampleQty; }
    public void setSampleQty(BigDecimal sampleQty) { this.sampleQty = sampleQty; }
    public BigDecimal getTotalDefectQty() { return totalDefectQty; }
    public void setTotalDefectQty(BigDecimal totalDefectQty) { this.totalDefectQty = totalDefectQty; }
    public String getDefectName() { return defectName; }
    public void setDefectName(String defectName) { this.defectName = defectName; }
    public BigDecimal getDefectQty() { return defectQty; }
    public void setDefectQty(BigDecimal defectQty) { this.defectQty = defectQty; }
    public String getInspectorFullname() { return inspectorFullname; }
    public void setInspectorFullname(String inspectorFullname) { this.inspectorFullname = inspectorFullname; }
    public String getShiftConfirmerFullname() { return shiftConfirmerFullname; }
    public void setShiftConfirmerFullname(String shiftConfirmerFullname) { this.shiftConfirmerFullname = shiftConfirmerFullname; }
}