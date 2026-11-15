package com.jcd.dto;

import java.util.List;

public class FqcRecordDto {
    private String recordId;
    private String lotCode;
    private String fqcEqp;
    private String productType;
    private String modelName;
    private Long totalQty;
    private Long goodQty;
    private Double cycleTime;
    private Long forkQty;
    private Long packageQty;
    private Double outputHours;
    private String remark;
    private List<FqcDefectItemDto> defects;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getLotCode() {
        return lotCode;
    }

    public void setLotCode(String lotCode) {
        this.lotCode = lotCode;
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
        this.productType = productType;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
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

    private Long standardCapacity;

    public Double getOutputHours() {
        return outputHours;
    }

    public void setOutputHours(Double outputHours) {
        this.outputHours = outputHours;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<FqcDefectItemDto> getDefects() {
        return defects;
    }

    public void setDefects(List<FqcDefectItemDto> defects) {
        this.defects = defects;
    }
}
