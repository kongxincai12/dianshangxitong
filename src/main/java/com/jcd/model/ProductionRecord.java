package com.jcd.model;

import java.math.BigDecimal;
import java.util.Date;

public class ProductionRecord {

    private String id;

    private String recordType;

    private String employeeId;

    private String equipmentId;

    private String lotCode;

    private BigDecimal pnlQty;

    private BigDecimal pcsQty;

    private Date startTime;

    private Date endTime;

    private String status;

    private String siteCode;

    private String lotSite;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private String productCode;

    private String workstationId;

    private String remark;

    /** 批量录入分组ID(UUID)；单批次录入时为 null */
    private String batchGroupId;

    /** 客户端一次逻辑提交的幂等请求号。 */
    private String requestId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType == null ? null : recordType.trim();
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId == null ? null : employeeId.trim();
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId == null ? null : equipmentId.trim();
    }

    public String getLotCode() {
        return lotCode;
    }

    public void setLotCode(String lotCode) {
        this.lotCode = lotCode == null ? null : lotCode.trim();
    }

    public BigDecimal getPnlQty() {
        return pnlQty;
    }

    public void setPnlQty(BigDecimal pnlQty) {
        this.pnlQty = pnlQty;
    }

    public BigDecimal getPcsQty() {
        return pcsQty;
    }

    public void setPcsQty(BigDecimal pcsQty) {
        this.pcsQty = pcsQty;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode == null ? null : siteCode.trim();
    }

    public String getLotSite() {
        return lotSite;
    }

    public void setLotSite(String lotSite) {
        this.lotSite = lotSite == null ? null : lotSite.trim();
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getWorkstationId() {
        return workstationId;
    }

    public void setWorkstationId(String workstationId) {
        this.workstationId = workstationId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getBatchGroupId() {
        return batchGroupId;
    }

    public void setBatchGroupId(String batchGroupId) {
        this.batchGroupId = batchGroupId == null ? null : batchGroupId.trim();
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId == null ? null : requestId.trim();
    }
}
