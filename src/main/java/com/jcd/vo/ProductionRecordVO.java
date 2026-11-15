package com.jcd.vo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class ProductionRecordVO {
    private String id;
    private String lotCode;
    private String productCode;
    private String equipmentId;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT+8")
    private Date startTime;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT+8")
    private Date endTime;
    private String status;
    private String statusText;
    private String workstationId; // 【新增或确认存在此字段】

    /** 批量录入分组ID；前端按此字段聚合显示 */
    private String batchGroupId;

    private BigDecimal pnlQty;
    private BigDecimal pcsQty;
    // Getters and Setters...

    public BigDecimal getPnlQty() {
        return pnlQty;
    }

    public void setPnlQty(BigDecimal pnlQty) {
        this.pnlQty = pnlQty;
    }

    public BigDecimal getPcsQty() {
        return pcsQty;
    }

    public void setPcsQty(BigDecimal pcsQty) {
        this.pcsQty = pcsQty;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getLotCode() { return lotCode; }
    public void setLotCode(String lotCode) { this.lotCode = lotCode; }
    public String getProductCode() { return productCode; }
    public void setProductCode(String productCode) { this.productCode = productCode; }
    public String getEquipmentId() { return equipmentId; }
    public void setEquipmentId(String equipmentId) { this.equipmentId = equipmentId; }
    public Date getStartTime() { return startTime; }
    public void setStartTime(Date startTime) { this.startTime = startTime; }
    public Date getEndTime() { return endTime; }
    public void setEndTime(Date endTime) { this.endTime = endTime; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getStatusText() { return statusText; }
    public void setStatusText(String statusText) { this.statusText = statusText; }

    public String getWorkstationId() {
        return workstationId;
    }

    public void setWorkstationId(String workstationId) {
        this.workstationId = workstationId;
    }

    public String getBatchGroupId() {
        return batchGroupId;
    }

    public void setBatchGroupId(String batchGroupId) {
        this.batchGroupId = batchGroupId;
    }
}
