package com.jcd.model;

import java.util.Date;

public class Wip_upnhist {
    private String histid;

    private String lotid;

    private String moid;

    private String slot;

    private String upnid;

    private Date begintime;

    private Date endtime;

    public String getHistid() {
        return histid;
    }

    public void setHistid(String histid) {
        this.histid = histid == null ? null : histid.trim();
    }

    public String getLotid() {
        return lotid;
    }

    public void setLotid(String lotid) {
        this.lotid = lotid == null ? null : lotid.trim();
    }

    public String getMoid() {
        return moid;
    }

    public void setMoid(String moid) {
        this.moid = moid == null ? null : moid.trim();
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot == null ? null : slot.trim();
    }

    public String getUpnid() {
        return upnid;
    }

    public void setUpnid(String upnid) {
        this.upnid = upnid == null ? null : upnid.trim();
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Date getEndtime() {
        return endtime;
    }

    public void setEndtime(Date endtime) {
        this.endtime = endtime;
    }
}