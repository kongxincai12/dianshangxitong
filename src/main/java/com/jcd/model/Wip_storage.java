package com.jcd.model;

import java.util.Date;

public class Wip_storage {
    private String storageid;

    private String cartoncode;

    private String locationid;

    private String status;

    private Date datetime;

    private String username;

    private String shipid;

    private String remark;

    private String obj01;

    private String obj02;

    private String obj03;

    public String getStorageid() {
        return storageid;
    }

    public void setStorageid(String storageid) {
        this.storageid = storageid == null ? null : storageid.trim();
    }

    public String getCartoncode() {
        return cartoncode;
    }

    public void setCartoncode(String cartoncode) {
        this.cartoncode = cartoncode == null ? null : cartoncode.trim();
    }

    public String getLocationid() {
        return locationid;
    }

    public void setLocationid(String locationid) {
        this.locationid = locationid == null ? null : locationid.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getShipid() {
        return shipid;
    }

    public void setShipid(String shipid) {
        this.shipid = shipid == null ? null : shipid.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
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
}