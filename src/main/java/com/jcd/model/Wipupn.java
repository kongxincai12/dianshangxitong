package com.jcd.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * WIPUPN 表 - UPN物料操作日志（入库/移库/过站等）
 */
public class Wipupn {

    private String wipupnid;
    private String upnid;
    private String stationid;
    private String fromlocation;
    private String tolocation;
    private BigDecimal qty;
    private String transcationtype;
    private String locationname;
    private String stationname;
    private String username;
    private Date datetime;
    private String moid;
    private String lotid;
    private String obj01;
    private String obj02;
    private String obj03;
    private String obj04;
    private String obj05;

    public String getWipupnid() {
        return wipupnid;
    }

    public void setWipupnid(String wipupnid) {
        this.wipupnid = wipupnid == null ? null : wipupnid.trim();
    }

    public String getUpnid() {
        return upnid;
    }

    public void setUpnid(String upnid) {
        this.upnid = upnid == null ? null : upnid.trim();
    }

    public String getStationid() {
        return stationid;
    }

    public void setStationid(String stationid) {
        this.stationid = stationid == null ? null : stationid.trim();
    }

    public String getFromlocation() {
        return fromlocation;
    }

    public void setFromlocation(String fromlocation) {
        this.fromlocation = fromlocation == null ? null : fromlocation.trim();
    }

    public String getTolocation() {
        return tolocation;
    }

    public void setTolocation(String tolocation) {
        this.tolocation = tolocation == null ? null : tolocation.trim();
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public String getTranscationtype() {
        return transcationtype;
    }

    public void setTranscationtype(String transcationtype) {
        this.transcationtype = transcationtype == null ? null : transcationtype.trim();
    }

    public String getLocationname() {
        return locationname;
    }

    public void setLocationname(String locationname) {
        this.locationname = locationname == null ? null : locationname.trim();
    }

    public String getStationname() {
        return stationname;
    }

    public void setStationname(String stationname) {
        this.stationname = stationname == null ? null : stationname.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getMoid() {
        return moid;
    }

    public void setMoid(String moid) {
        this.moid = moid == null ? null : moid.trim();
    }

    public String getLotid() {
        return lotid;
    }

    public void setLotid(String lotid) {
        this.lotid = lotid == null ? null : lotid.trim();
    }

    public String getObj01() {
        return obj01;
    }

    public void setObj01(String obj01) {
        this.obj01 = obj01 == null ? null : obj01.trim();
    }

    public String getObj02() {
        return obj02;
    }

    public void setObj02(String obj02) {
        this.obj02 = obj02 == null ? null : obj02.trim();
    }

    public String getObj03() {
        return obj03;
    }

    public void setObj03(String obj03) {
        this.obj03 = obj03 == null ? null : obj03.trim();
    }

    public String getObj04() {
        return obj04;
    }

    public void setObj04(String obj04) {
        this.obj04 = obj04 == null ? null : obj04.trim();
    }

    public String getObj05() {
        return obj05;
    }

    public void setObj05(String obj05) {
        this.obj05 = obj05 == null ? null : obj05.trim();
    }
}
