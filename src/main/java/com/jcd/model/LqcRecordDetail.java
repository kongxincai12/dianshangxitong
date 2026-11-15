package com.jcd.model;

public class LqcRecordDetail {
    private String id;

    private String recordId;

    private String defectName;

    private Integer defectQty;

    private String attribute1;

    private Short attributeNum1;

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

    public String getDefectName() {
        return defectName;
    }

    public void setDefectName(String defectName) {
        this.defectName = defectName == null ? null : defectName.trim();
    }

    public Integer getDefectQty() {
        return defectQty;
    }

    public void setDefectQty(Integer defectQty) {
        this.defectQty = defectQty;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1 == null ? null : attribute1.trim();
    }

    public Short getAttributeNum1() {
        return attributeNum1;
    }

    public void setAttributeNum1(Short attributeNum1) {
        this.attributeNum1 = attributeNum1;
    }
}