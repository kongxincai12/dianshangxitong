package com.jcd.model;

public class MesInspRecordDetails {
    private String id;

    private String recordId;

    private String defectName;

    private Long defectQty;

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

    public Long getDefectQty() {
        return defectQty;
    }

    public void setDefectQty(Long defectQty) {
        this.defectQty = defectQty;
    }
}