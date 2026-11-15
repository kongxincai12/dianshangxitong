package com.jcd.model;

import java.util.Date;

public class MesDefectPresets {
    private String id;

    private String siteName;

    private String defectName;

    private Long displayOrder;

    private Short isEnabled;

    private Date createTime;

    private Date updateTime;

    private String attribute1;

    private String attribute2;

    private String attribute3;

    private Short attributeNum1;

    private Short attributeNum2;

    private Date attributeDate1;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getSiteName() {
        return siteName;
    }

    public void setSiteName(String siteName) {
        this.siteName = siteName == null ? null : siteName.trim();
    }

    public String getDefectName() {
        return defectName;
    }

    public void setDefectName(String defectName) {
        this.defectName = defectName == null ? null : defectName.trim();
    }

    public Long getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Long displayOrder) {
        this.displayOrder = displayOrder;
    }

    public Short getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Short isEnabled) {
        this.isEnabled = isEnabled;
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

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1 == null ? null : attribute1.trim();
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2 == null ? null : attribute2.trim();
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3 == null ? null : attribute3.trim();
    }

    public Short getAttributeNum1() {
        return attributeNum1;
    }

    public void setAttributeNum1(Short attributeNum1) {
        this.attributeNum1 = attributeNum1;
    }

    public Short getAttributeNum2() {
        return attributeNum2;
    }

    public void setAttributeNum2(Short attributeNum2) {
        this.attributeNum2 = attributeNum2;
    }

    public Date getAttributeDate1() {
        return attributeDate1;
    }

    public void setAttributeDate1(Date attributeDate1) {
        this.attributeDate1 = attributeDate1;
    }
}