package com.jcd.model;

import java.math.BigDecimal;
import java.util.Date;

public class EquipmentType {
    private String id;

    private String eqpTypeCode;

    private String eqpTypeName;

    private String imgUrl;

    private String eqpCategory;

    private String owner;

    private String siteCode;

    private String enableFlag;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private BigDecimal revision;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getEqpTypeCode() {
        return eqpTypeCode;
    }

    public void setEqpTypeCode(String eqpTypeCode) {
        this.eqpTypeCode = eqpTypeCode == null ? null : eqpTypeCode.trim();
    }

    public String getEqpTypeName() {
        return eqpTypeName;
    }

    public void setEqpTypeName(String eqpTypeName) {
        this.eqpTypeName = eqpTypeName == null ? null : eqpTypeName.trim();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getEqpCategory() {
        return eqpCategory;
    }

    public void setEqpCategory(String eqpCategory) {
        this.eqpCategory = eqpCategory == null ? null : eqpCategory.trim();
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner == null ? null : owner.trim();
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode == null ? null : siteCode.trim();
    }

    public String getEnableFlag() {
        return enableFlag;
    }

    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag == null ? null : enableFlag.trim();
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

    public BigDecimal getRevision() {
        return revision;
    }

    public void setRevision(BigDecimal revision) {
        this.revision = revision;
    }
}