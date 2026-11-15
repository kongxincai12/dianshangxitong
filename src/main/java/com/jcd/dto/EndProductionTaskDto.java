package com.jcd.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.util.List;

@Data
public class EndProductionTaskDto {
    private String recordId;
    private BigDecimal pnl;
    private BigDecimal pcs;
    private String employeeId; // 结束任务的操作人
    private List<String> materials;
    private String remark;

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public BigDecimal getPnl() {
        return pnl;
    }

    public void setPnl(BigDecimal pnl) {
        this.pnl = pnl;
    }

    public BigDecimal getPcs() {
        return pcs;
    }

    public void setPcs(BigDecimal pcs) {
        this.pcs = pcs;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}