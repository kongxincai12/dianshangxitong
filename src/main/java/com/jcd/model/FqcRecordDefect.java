package com.jcd.model;

import java.util.Date;

public class FqcRecordDefect {
    private String id;

    private String recordId;

    private String defectCodeId;

    private String defectName;

    private Long defectQty;

    private Integer isCustom;

    private Integer displayOrder;

    private Date createTime;

    private Date updateTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId == null ? null : recordId.trim();
    }

    public String getDefectCodeId() {
        return defectCodeId;
    }

    public void setDefectCodeId(String defectCodeId) {
        this.defectCodeId = defectCodeId == null ? null : defectCodeId.trim();
    }

    public String getDefectName() {
        return defectName;
    }

    public void setDefectName(String defectName) {
        this.defectName = defectName == null ? null : defectName.trim();
    }

    public Long getDefectQty() {
        return defectQty;
    }

    public void setDefectQty(Long defectQty) {
        this.defectQty = defectQty;
    }

    public Integer getIsCustom() {
        return isCustom;
    }

    public void setIsCustom(Integer isCustom) {
        this.isCustom = isCustom;
    }

    public Integer getDisplayOrder() {
        return displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
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
