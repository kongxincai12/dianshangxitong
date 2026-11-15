package com.jcd.dto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * 设备作业批量录入请求 DTO
 *
 * 业务约束（由 Service 层强校验）：
 *   1. lots 至少 1 条
 *   2. 所有 lot 的 productCode 必须相同（同一台设备共享参数）
 *   3. 员工/设备/参数全组共享
 */
public class AddProductionBatchDto {

    private String employeeId;
    private String equipmentId;
    private String remark;
    private String siteCode;
    private String siteName;
    private String stationId;
    private String siteSource;
    private String requestId;

    /** 共享参数（与单批次接口一致：paramKey -> value） */
    private Map<String, Object> parameters;

    /** 批次明细列表 */
    private List<LotItem> lots;

    public static class LotItem {
        private String lotCode;
        private BigDecimal pnl;
        private BigDecimal pcs;
        private String lotSite;
        private List<String> materials;

        public String getLotCode() { return lotCode; }
        public void setLotCode(String lotCode) { this.lotCode = lotCode; }
        public BigDecimal getPnl() { return pnl; }
        public void setPnl(BigDecimal pnl) { this.pnl = pnl; }
        public BigDecimal getPcs() { return pcs; }
        public void setPcs(BigDecimal pcs) { this.pcs = pcs; }
        public String getLotSite() { return lotSite; }
        public void setLotSite(String lotSite) { this.lotSite = lotSite; }
        public List<String> getMaterials() { return materials; }
        public void setMaterials(List<String> materials) { this.materials = materials; }
    }

    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public String getEquipmentId() { return equipmentId; }
    public void setEquipmentId(String equipmentId) { this.equipmentId = equipmentId; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
    public String getSiteCode() { return siteCode; }
    public void setSiteCode(String siteCode) { this.siteCode = siteCode; }
    public String getSiteName() { return siteName; }
    public void setSiteName(String siteName) { this.siteName = siteName; }
    public String getStationId() { return stationId; }
    public void setStationId(String stationId) { this.stationId = stationId; }
    public String getSiteSource() { return siteSource; }
    public void setSiteSource(String siteSource) { this.siteSource = siteSource; }
    public String getRequestId() { return requestId; }
    public void setRequestId(String requestId) { this.requestId = requestId; }
    public Map<String, Object> getParameters() { return parameters; }
    public void setParameters(Map<String, Object> parameters) { this.parameters = parameters; }
    public List<LotItem> getLots() { return lots; }
    public void setLots(List<LotItem> lots) { this.lots = lots; }
}
