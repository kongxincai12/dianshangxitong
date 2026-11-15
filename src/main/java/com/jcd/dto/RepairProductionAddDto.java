package com.jcd.dto;

import lombok.Data;

import java.util.List;

@Data
public class RepairProductionAddDto {
    // 此 DTO 与 EquipmentProductionAddDto 类似，但不包含设备相关字段
    private String employeeId;
    private String workstationId; // 注意这里是 workstationId
    private String lotCode;
    private List<String> materials;
    private int pnl;
    private int pcs;
    private String startTime; // ISO 8601 格式的字符串, e.g., "2025-08-28T10:00:00.000Z"

    // 从前端的用户信息或批次信息中获取
    private String siteCode;
    private String lotSite;
    private String remark;

    private int countQty;
    private int totalQty;
    private int panelPcs;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getWorkstationId() {
        return workstationId;
    }

    public void setWorkstationId(String workstationId) {
        this.workstationId = workstationId;
    }

    public String getLotCode() {
        return lotCode;
    }

    public void setLotCode(String lotCode) {
        this.lotCode = lotCode;
    }

    public List<String> getMaterials() {
        return materials;
    }

    public void setMaterials(List<String> materials) {
        this.materials = materials;
    }

    public int getPnl() {
        return pnl;
    }

    public void setPnl(int pnl) {
        this.pnl = pnl;
    }

    public int getPcs() {
        return pcs;
    }

    public void setPcs(int pcs) {
        this.pcs = pcs;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getSiteCode() {
        return siteCode;
    }

    public void setSiteCode(String siteCode) {
        this.siteCode = siteCode;
    }

    public String getLotSite() {
        return lotSite;
    }

    public void setLotSite(String lotSite) {
        this.lotSite = lotSite;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getCountQty() {
        return countQty;
    }

    public void setCountQty(int countQty) {
        this.countQty = countQty;
    }

    public int getTotalQty() {
        return totalQty;
    }

    public void setTotalQty(int totalQty) {
        this.totalQty = totalQty;
    }

    public int getPanelPcs() {
        return panelPcs;
    }

    public void setPanelPcs(int panelPcs) {
        this.panelPcs = panelPcs;
    }
}
