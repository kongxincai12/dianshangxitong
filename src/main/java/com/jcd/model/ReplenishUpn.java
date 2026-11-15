package com.jcd.model;

import java.util.Date;

public class ReplenishUpn {
    private String replenishupnid;

    private String replenishgroupid;

    private String slot;

    private String moid;

    private String upnid;

    private String currentflag;

    private String username;

    private Date datetime;

    private String obj1;

    private String obj2;

    public String getReplenishupnid() {
        return replenishupnid;
    }

    public void setReplenishupnid(String replenishupnid) {
        this.replenishupnid = replenishupnid == null ? null : replenishupnid.trim();
    }

    public String getReplenishgroupid() {
        return replenishgroupid;
    }

    public void setReplenishgroupid(String replenishgroupid) {
        this.replenishgroupid = replenishgroupid == null ? null : replenishgroupid.trim();
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot == null ? null : slot.trim();
    }

    public String getMoid() {
        return moid;
    }

    public void setMoid(String moid) {
        this.moid = moid == null ? null : moid.trim();
    }

    public String getUpnid() {
        return upnid;
    }

    public void setUpnid(String upnid) {
        this.upnid = upnid == null ? null : upnid.trim();
    }

    public String getCurrentflag() {
        return currentflag;
    }

    public void setCurrentflag(String currentflag) {
        this.currentflag = currentflag == null ? null : currentflag.trim();
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

    public String getObj1() {
        return obj1;
    }

    public void setObj1(String obj1) {
        this.obj1 = obj1 == null ? null : obj1.trim();
    }

    public String getObj2() {
        return obj2;
    }

    public void setObj2(String obj2) {
        this.obj2 = obj2 == null ? null : obj2.trim();
    }
}