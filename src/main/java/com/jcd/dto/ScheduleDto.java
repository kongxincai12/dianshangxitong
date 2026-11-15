package com.jcd.dto;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 排期Excel解析DTO
 * 对应前端上传的Excel文件中的列：生产型号、排期数量、生产工单
 */
public class ScheduleDto {

    /** 生产型号 */
    @ExcelProperty("生产型号")
    private String model;

    /** 排期数量 */
    @ExcelProperty("排期数量")
    private Integer scheduleQty;

    /** 生产工单号 */
    @ExcelProperty("生产工单")
    private String workOrderName;

    public ScheduleDto() {
    }

    public ScheduleDto(String model, Integer scheduleQty, String workOrderName) {
        this.model = model;
        this.scheduleQty = scheduleQty;
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

    public String getWorkOrderName() {
        return workOrderName;
    }

    public void setWorkOrderName(String workOrderName) {
        this.workOrderName = workOrderName;
    }

    @Override
    public String toString() {
        return "ScheduleDto{" +
                "model='" + model + '\'' +
                ", scheduleQty=" + scheduleQty +
                ", workOrderName='" + workOrderName + '\'' +
                '}';
    }
}
