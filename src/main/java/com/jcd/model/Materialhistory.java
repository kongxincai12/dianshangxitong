package com.jcd.model;

import java.math.BigDecimal;

public class Materialhistory {
    private String mhid;

    private String moid;

    private String moname;

    private String taskname;

    private String eqpname;

    private String stage;

    private String slot;

    private String pn;

    private BigDecimal qty;

    private String boardside;

    private String upnname;

    private BigDecimal upnqty;

    private String feedername;

    private String previouslocation;

    private String tolocation;

    private String description;

    private String username;

    private String datetime;

    public String getMhid() {
        return mhid;
    }

    public void setMhid(String mhid) {
        this.mhid = mhid == null ? null : mhid.trim();
    }

    public String getMoid() {
        return moid;
    }

    public void setMoid(String moid) {
        this.moid = moid == null ? null : moid.trim();
    }

    public String getMoname() {
        return moname;
    }

    public void setMoname(String moname) {
        this.moname = moname == null ? null : moname.trim();
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname == null ? null : taskname.trim();
    }

    public String getEqpname() {
        return eqpname;
    }

    public void setEqpname(String eqpname) {
        this.eqpname = eqpname == null ? null : eqpname.trim();
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage == null ? null : stage.trim();
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot == null ? null : slot.trim();
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn == null ? null : pn.trim();
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public String getBoardside() {
        return boardside;
    }

    public void setBoardside(String boardside) {
        this.boardside = boardside == null ? null : boardside.trim();
    }

    public String getUpnname() {
        return upnname;
    }

    public void setUpnname(String upnname) {
        this.upnname = upnname == null ? null : upnname.trim();
    }

    public BigDecimal getUpnqty() {
        return upnqty;
    }

    public void setUpnqty(BigDecimal upnqty) {
        this.upnqty = upnqty;
    }

    public String getFeedername() {
        return feedername;
    }

    public void setFeedername(String feedername) {
        this.feedername = feedername == null ? null : feedername.trim();
    }

    public String getPreviouslocation() {
        return previouslocation;
    }

    public void setPreviouslocation(String previouslocation) {
        this.previouslocation = previouslocation == null ? null : previouslocation.trim();
    }

    public String getTolocation() {
        return tolocation;
    }

    public void setTolocation(String tolocation) {
        this.tolocation = tolocation == null ? null : tolocation.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime == null ? null : datetime.trim();
    }
}