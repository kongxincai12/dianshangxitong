package com.jcd.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jcd.dto.ProductionRecordDetailVO;
import com.jcd.model.RecordParameter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 批量任务详情 VO
 *
 * 头部展示同组共享信息（员工/设备/料号/参数），明细列出每条记录。
 * 整体状态：任意一条 INPROGRESS 即为 INPROGRESS，全部 COMPLETED 才算 COMPLETED。
 */
public class BatchProductionDetailVO {

    private String batchGroupId;
    private String employeeId;
    private String equipmentId;
    private String productCode;
    private String status;        // INPROGRESS / COMPLETED
    private String statusText;
    private String remark;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT+8")
    private Date startTime;        // 取最早 startTime
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "GMT+8")
    private Date endTime;          // 全部完成则取最晚 endTime，否则 null

    private Integer lotCount;
    private BigDecimal totalPnl;
    private BigDecimal totalPcs;
    private Integer panelPcs;      // 共享 panelPcs（同料号）

    /** 共享参数定义（取首条记录） */
    private List<RecordParameter> parameters;

    /** 每条 lot 的明细 */
    private List<ProductionRecordDetailVO> records;

    public String getBatchGroupId() { return batchGroupId; }
    public void setBatchGroupId(String batchGroupId) { this.batchGroupId = batchGroupId; }
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public String getEquipmentId() { return equipmentId; }
    public void setEquipmentId(String equipmentId) { this.equipmentId = equipmentId; }
    public String getProductCode() { return productCode; }
    public void setProductCode(String productCode) { this.productCode = productCode; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getStatusText() { return statusText; }
    public void setStatusText(String statusText) { this.statusText = statusText; }
    public String getRemark() { return remark; }
    public void setRemark(String remark) { this.remark = remark; }
    public Date getStartTime() { return startTime; }
    public void setStartTime(Date startTime) { this.startTime = startTime; }
    public Date getEndTime() { return endTime; }
    public void setEndTime(Date endTime) { this.endTime = endTime; }
    public Integer getLotCount() { return lotCount; }
    public void setLotCount(Integer lotCount) { this.lotCount = lotCount; }
    public BigDecimal getTotalPnl() { return totalPnl; }
    public void setTotalPnl(BigDecimal totalPnl) { this.totalPnl = totalPnl; }
    public BigDecimal getTotalPcs() { return totalPcs; }
    public void setTotalPcs(BigDecimal totalPcs) { this.totalPcs = totalPcs; }
    public Integer getPanelPcs() { return panelPcs; }
    public void setPanelPcs(Integer panelPcs) { this.panelPcs = panelPcs; }
    public List<RecordParameter> getParameters() { return parameters; }
    public void setParameters(List<RecordParameter> parameters) { this.parameters = parameters; }
    public List<ProductionRecordDetailVO> getRecords() { return records; }
    public void setRecords(List<ProductionRecordDetailVO> records) { this.records = records; }
}
