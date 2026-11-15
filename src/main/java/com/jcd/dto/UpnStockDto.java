package com.jcd.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * UPN库存明细DTO
 * 用于库存FIFO分配，包含UPN条码、料号、剩余数量、入库时间、储位信息等
 */
public class UpnStockDto {

    /** UPN主键ID */
    private String upnId;

    /** UPN条码名称 */
    private String upnName;

    /** 料号 */
    private String pnId;

    /** 料号描述 */
    private String description;

    /** 剩余数量 */
    private BigDecimal remainingQty;

    /** 入库时间（用于FIFO排序） */
    private Date datetime;

    /** UPN状态（ACTIVE/HOLD/NG） */
    private String state;

    /** 储位ID */
    private String locationId;

    /** 储位名称 */
    private String locationName;

    /** 站别描述 */
    private String stationDescription;

    public UpnStockDto() {
    }

    public String getUpnId() {
        return upnId;
    }

    public void setUpnId(String upnId) {
        this.upnId = upnId;
    }

    public String getUpnName() {
        return upnName;
    }

    public void setUpnName(String upnName) {
        this.upnName = upnName;
    }

    public String getPnId() {
        return pnId;
    }

    public void setPnId(String pnId) {
        this.pnId = pnId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getRemainingQty() {
        return remainingQty;
    }

    public void setRemainingQty(BigDecimal remainingQty) {
        this.remainingQty = remainingQty;
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
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

    @Override
    public String toString() {
        return "UpnStockDto{" +
                "upnName='" + upnName + '\'' +
                ", pnId='" + pnId + '\'' +
                ", remainingQty=" + remainingQty +
                ", locationName='" + locationName + '\'' +
                '}';
    }
}
