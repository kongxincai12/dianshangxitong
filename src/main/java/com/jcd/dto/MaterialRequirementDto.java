package com.jcd.dto;

import java.math.BigDecimal;

/**
 * 物料需求总表DTO
 * 每一行代表某个工单下某个子件料号的净缺口需求
 */
public class MaterialRequirementDto {

    /** 生产工单号 */
    private String workOrderName;

    /** 生产型号 */
    private String model;

    /** 排期数量 */
    private Integer scheduleQty;

    /** 子件料号 */
    private String pn;

    /** 子件描述 */
    private String description;

    /** 子件单位用量 */
    private BigDecimal unitQty;

    /** FPC已发数量（光板已发料数量） */
    private BigDecimal fpcReleaseQty;

    /** 子件已发数量 */
    private BigDecimal childReleaseQty;

    /** 应发总量 = (fpcReleaseQty + scheduleQty) * unitQty */
    private BigDecimal shouldReleaseQty;

    /** 需发料数量（缺口数量，正数表示缺多少） */
    private BigDecimal shortageQty;

    public MaterialRequirementDto() {
    }

    public String getWorkOrderName() {
        return workOrderName;
    }

    public void setWorkOrderName(String workOrderName) {
        this.workOrderName = workOrderName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Integer getScheduleQty() {
        return scheduleQty;
    }

    public void setScheduleQty(Integer scheduleQty) {
        this.scheduleQty = scheduleQty;
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnitQty() {
        return unitQty;
    }

    public void setUnitQty(BigDecimal unitQty) {
        this.unitQty = unitQty;
    }

    public BigDecimal getFpcReleaseQty() {
        return fpcReleaseQty;
    }

    public void setFpcReleaseQty(BigDecimal fpcReleaseQty) {
        this.fpcReleaseQty = fpcReleaseQty;
    }

    public BigDecimal getChildReleaseQty() {
        return childReleaseQty;
    }

    public void setChildReleaseQty(BigDecimal childReleaseQty) {
        this.childReleaseQty = childReleaseQty;
    }

    public BigDecimal getShouldReleaseQty() {
        return shouldReleaseQty;
    }

    public void setShouldReleaseQty(BigDecimal shouldReleaseQty) {
        this.shouldReleaseQty = shouldReleaseQty;
    }

    public BigDecimal getShortageQty() {
        return shortageQty;
    }

    public void setShortageQty(BigDecimal shortageQty) {
        this.shortageQty = shortageQty;
    }

    @Override
    public String toString() {
        return "MaterialRequirementDto{" +
                "workOrderName='" + workOrderName + '\'' +
                ", model='" + model + '\'' +
                ", pn='" + pn + '\'' +
                ", shortageQty=" + shortageQty +
                '}';
    }
}
