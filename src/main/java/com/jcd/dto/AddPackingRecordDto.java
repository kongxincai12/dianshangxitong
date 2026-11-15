package com.jcd.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class AddPackingRecordDto {
    private String id;
    private String employeeId;
    private String lotCode;
    private String materials;
    private BigDecimal pnl;
    private BigDecimal pcs;
    private BigDecimal qty;
    private String dateCode;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date createTime;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date lastUpdateDate;

    private Integer sumPnl;
    private Integer sumPcs;
    private Integer sumPackQty;
    private BigDecimal standardCapacity;
    private BigDecimal outputHours;
    private String remark;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getLotCode() {
        return lotCode;
    }

    public void setLotCode(String lotCode) {
        this.lotCode = lotCode;
    }

    public BigDecimal getPnl() {
        return pnl;
    }

    public void setPnl(BigDecimal pnl) {
        this.pnl = pnl;
    }

    public BigDecimal getPcs() {
        return pcs;
    }

    public void setPcs(BigDecimal pcs) {
        this.pcs = pcs;
    }

    public String getMaterials() {
        return materials;
    }

    public void setMaterials(String materials) {
        this.materials = materials;
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public String getDateCode() {
        return dateCode;
    }

    public void setDateCode(String dateCode) {
        this.dateCode = dateCode;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Integer getSumPcs() {
        return sumPcs;
    }

    public void setSumPcs(Integer sumPcs) {
        this.sumPcs = sumPcs;
    }

    public Integer getSumPnl() {
        return sumPnl;
    }

    public void setSumPnl(Integer sumPnl) {
        this.sumPnl = sumPnl;
    }

    public Integer getPackCompleteQty() {
        return sumPackQty;
    }

    public void setPackCompleteQty(Integer packCompleteQty) {
        this.sumPackQty = packCompleteQty;
    }

    public BigDecimal getStandardCapacity() {
        return standardCapacity;
    }

    public void setStandardCapacity(BigDecimal standardCapacity) {
        this.standardCapacity = standardCapacity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public BigDecimal getOutputHours() {
        return outputHours;
    }

    public void setOutputHours(BigDecimal outputHours) {
        this.outputHours = outputHours;
    }

}