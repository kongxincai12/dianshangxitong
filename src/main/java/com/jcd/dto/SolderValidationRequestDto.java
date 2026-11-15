package com.jcd.dto;

public class SolderValidationRequestDto {
    private String upn;
    private String lineId;
    private String employeeId;
    private String employeeName; // 假设 employeeName 也会传来用于记录

    // Getters and Setters
    public String getUpn() { return upn; }
    public void setUpn(String upn) { this.upn = upn; }
    public String getLineId() { return lineId; }
    public void setLineId(String lineId) { this.lineId = lineId; }
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }
}
