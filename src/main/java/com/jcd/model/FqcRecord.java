package com.jcd.model;

import java.util.Date;

public class FqcRecord {
    private String id;

    private String lotCode;

    private String fqcEqp;

    private String productType;

    private String modelName;

    private Long totalQty;

    private Long goodQty;

    private Long defectQty;

    private Double passRate;

    private Double cycleTime;

    private Long forkQty;

    private Long packageQty;

    private Long standardCapacity;

    private Double outputHours;

    private String inspectorId;

    private String inspectorName;

    private String status;

    private Date inspDate;

    private Integer reopenCount;

    private Date lastReopenTime;

    private String remark;

    private Date createTime;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getLotCode() {
        return lotCode;
    }

    public void setLotCode(String lotCode) {
        this.lotCode = lotCode == null ? null : lotCode.trim();
    }

    public String getFqcEqp() {
        return fqcEqp;
    }

    public void setFqcEqp(String fqcEqp) {
        this.fqcEqp = fqcEqp;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType == null ? null : productType.trim();
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName == null ? null : modelName.trim();
    }

    public Long getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(Long totalQty) {
        this.totalQty = totalQty;
    }

    public Long getGoodQty() {
        return goodQty;
    }

    public void setGoodQty(Long goodQty) {
        this.goodQty = goodQty;
    }

    public Long getDefectQty() {
        return defectQty;
    }

    public void setDefectQty(Long defectQty) {
        this.defectQty = defectQty;
    }

    public Double getPassRate() {
        return passRate;
    }

    public void setPassRate(Double passRate) {
        this.passRate = passRate;
    }

    public Double getCycleTime() {
        return cycleTime;
    }

    public void setCycleTime(Double cycleTime) {
        this.cycleTime = cycleTime;
    }

    public Long getForkQty() {
        return forkQty;
    }

    public void setForkQty(Long forkQty) {
        this.forkQty = forkQty;
    }

    public Long getPackageQty() {
        return packageQty;
    }

    public void setPackageQty(Long packageQty) {
        this.packageQty = packageQty;
    }

    public Long getStandardCapacity() {
        return standardCapacity;
    }

    public void setStandardCapacity(Long standardCapacity) {
        this.standardCapacity = standardCapacity;
    }

    public Double getOutputHours() {
        return outputHours;
    }

    public void setOutputHours(Double outputHours) {
        this.outputHours = outputHours;
    }

    public String getInspectorId() {
        return inspectorId;
    }

    public void setInspectorId(String inspectorId) {
        this.inspectorId = inspectorId == null ? null : inspectorId.trim();
    }

    public String getInspectorName() {
        return inspectorName;
    }

    public void setInspectorName(String inspectorName) {
        this.inspectorName = inspectorName == null ? null : inspectorName.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getInspDate() {
        return inspDate;
    }

    public void setInspDate(Date inspDate) {
        this.inspDate = inspDate;
    }

    public Integer getReopenCount() {
        return reopenCount;
    }

    public void setReopenCount(Integer reopenCount) {
        this.reopenCount = reopenCount;
    }

    public Date getLastReopenTime() {
        return lastReopenTime;
    }

    public void setLastReopenTime(Date lastReopenTime) {
        this.lastReopenTime = lastReopenTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
