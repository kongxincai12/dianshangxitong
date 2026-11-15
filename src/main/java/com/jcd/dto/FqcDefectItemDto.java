package com.jcd.dto;

public class FqcDefectItemDto {
    private String defectCodeId;
    private String defectName;
    private Long defectQty;
    private Integer isCustom;
    private Integer displayOrder;

    public String getDefectCodeId() {
        return defectCodeId;
    }

    public void setDefectCodeId(String defectCodeId) {
        this.defectCodeId = defectCodeId;
    }

    public String getDefectName() {
        return defectName;
    }

    public void setDefectName(String defectName) {
        this.defectName = defectName;
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
}
