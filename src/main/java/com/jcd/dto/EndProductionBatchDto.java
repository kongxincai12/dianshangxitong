package com.jcd.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * 批量结束生产任务请求 DTO
 *
 * 业务约束（由 Service 层强校验）：
 *   1. items.recordId 必须全部属于同一个 batchGroupId
 *   2. 所有命中记录必须为 INPROGRESS
 *   3. 单事务，任一条失败整批回滚
 */
public class EndProductionBatchDto {

    private String batchGroupId;
    private String employeeId;
    private String remark;

    private List<EndItem> items;

    public static class EndItem {
        private String recordId;
        private BigDecimal pnl;
        private BigDecimal pcs;
        private List<String> materials;

        public String getRecordId() { return recordId; }
        public void setRecordId(String recordId) { this.recordId = recordId; }
        public BigDecimal getPnl() { return pnl; }
        public void setPnl(BigDecimal pnl) { this.pnl = pnl; }
        public BigDecimal getPcs() { return pcs; }
        public void setPcs(BigDecimal pcs) { this.pcs = pcs; }
        public List<String> getMaterials() { return materials; }
        public void setMaterials(List<String> materials) { this.materials = materials; }
    }

    public String getBatchGroupId() { return batchGroupId; }
    public void setBatchGroupId(String batchGroupId) { this.batchGroupId = batchGroupId; }
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
    public List<EndItem> getItems() { return items; }
    public void setItems(List<EndItem> items) { this.items = items; }
}
