package com.jcd.dto;

import java.util.Date;
import java.util.List;

public class ElectricalTestRecordDto {
    private String recordId;
    private String lotCode;
    private String productType;
    private String modelName;
    private Long totalQty;
    private Long goodQty;
    private Double outputHours;
    private String remark;
    private List<FqcDefectItemDto> defects;

    private Integer pnlPcs;
    private Integer pnlTestTimes;
    private String checkResult;
    private String checkExceptionResult;
    private String checkHandleResult;
    private Integer retestPassQty;
    private Integer preStepDefectsqty;
    private Integer addOpenWay;
    private Integer addShortWay;
    private Integer punchingScrapqty;
    private String isfollow;
    private String eqpCode;
    private Date endDate;
    private List<ElectricalTestParameterDto> parameters;


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

    public Integer getPnlPcs() {
        return pnlPcs;
    }

    public void setPnlPcs(Integer pnlPcs) {
        this.pnlPcs = pnlPcs;
    }

    public Integer getPnlTestTimes() {
        return pnlTestTimes;
    }

    public void setPnlTestTimes(Integer pnlTestTimes) {
        this.pnlTestTimes = pnlTestTimes;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getCheckExceptionResult() {
        return checkExceptionResult;
    }

    public void setCheckExceptionResult(String checkExceptionResult) {
        this.checkExceptionResult = checkExceptionResult;
    }

    public String getCheckHandleResult() {
        return checkHandleResult;
    }

    public void setCheckHandleResult(String checkHandleResult) {
        this.checkHandleResult = checkHandleResult;
    }

    public Integer getRetestPassQty() {
        return retestPassQty;
    }

    public void setRetestPassQty(Integer retestPassQty) {
        this.retestPassQty = retestPassQty;
    }

    public Integer getPreStepDefectsqty() {
        return preStepDefectsqty;
    }

    public void setPreStepDefectsqty(Integer preStepDefectsqty) {
        this.preStepDefectsqty = preStepDefectsqty;
    }

    public Integer getAddOpenWay() {
        return addOpenWay;
    }

    public void setAddOpenWay(Integer addOpenWay) {
        this.addOpenWay = addOpenWay;
    }

    public Integer getAddShortWay() {
        return addShortWay;
    }

    public void setAddShortWay(Integer addShortWay) {
        this.addShortWay = addShortWay;
    }

    public Integer getPunchingScrapqty() {
        return punchingScrapqty;
    }

    public void setPunchingScrapqty(Integer punchingScrapqty) {
        this.punchingScrapqty = punchingScrapqty;
    }

    public String getIsfollow() {
        return isfollow;
    }

    public void setIsfollow(String isfollow) {
        this.isfollow = isfollow;
    }

    public String getEqpCode() {
        return eqpCode;
    }

    public void setEqpCode(String eqpCode) {
        this.eqpCode = eqpCode;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<ElectricalTestParameterDto> getParameters() {
        return parameters;
    }

    public void setParameters(List<ElectricalTestParameterDto> parameters) {
        this.parameters = parameters;
    }

}
