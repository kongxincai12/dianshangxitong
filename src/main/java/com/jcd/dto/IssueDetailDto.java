package com.jcd.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 发料明细表DTO
 * 每一行代表：某个工单需求 → 被分配了哪一盘UPN物料、分配了多少数量
 */
public class IssueDetailDto {

    /** 生产工单号 */
    private String workOrderName;

    /** 生产型号 */
    private String model;

    /** 子件料号 */
    private String pn;

    /** 子件描述 */
    private String description;

    /** 本次分配数量（从该UPN扣减的数量） */
    private BigDecimal allocateQty;

    /** UPN条码名称 */
    private String upnName;

    /** UPN剩余数量（分配前） */
    private BigDecimal upnRemainingQty;

    /** 储位名称 */
    private String locationName;

    /** 站别描述 */
    private String stationDescription;

    /** UPN状态 */
    private String state;

    /** 入库时间 */
    private Date datetime;

    public IssueDetailDto() {
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

    public BigDecimal getAllocateQty() {
        return allocateQty;
    }

    public void setAllocateQty(BigDecimal allocateQty) {
        this.allocateQty = allocateQty;
    }

    public String getUpnName() {
        return upnName;
    }

    public void setUpnName(String upnName) {
        this.upnName = upnName;
    }

    public BigDecimal getUpnRemainingQty() {
        return upnRemainingQty;
    }

    public void setUpnRemainingQty(BigDecimal upnRemainingQty) {
        this.upnRemainingQty = upnRemainingQty;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getStationDescription() {
        return stationDescription;
    }

    public void setStationDescription(String stationDescription) {
        this.stationDescription = stationDescription;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    @Override
    public String toString() {
        return "IssueDetailDto{" +
                "workOrderName='" + workOrderName + '\'' +
                ", pn='" + pn + '\'' +
                ", allocateQty=" + allocateQty +
                ", upnName='" + upnName + '\'' +
                '}';
    }
}
