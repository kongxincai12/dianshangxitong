package com.jcd.model;

import java.math.BigDecimal;

public class Loadmaterial {
    private String lmid;

    private String moid;

    private String eqpname;

    private String stage;

    private String slot;

    private String mfuname;

    private String pn;

    private BigDecimal qty;

    private String boardside;

    private String pda1;

    private String pda2;

    private String taskname;

    private String username;

    private String datetime;

    private String orignalslot;
    private String feeder;

    public String getFeeder() {
        return feeder;
    }

    public void setFeeder(String feeder) {
        this.feeder = feeder == null ? null : feeder.trim();
    }

    public String getLmid() {
        return lmid;
    }

    public void setLmid(String lmid) {
        this.lmid = lmid == null ? null : lmid.trim();
    }

    public String getMoid() {
        return moid;
    }

    public void setMoid(String moid) {
        this.moid = moid == null ? null : moid.trim();
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

    public String getMfuname() {
        return mfuname;
    }

    public void setMfuname(String mfuname) {
        this.mfuname = mfuname == null ? null : mfuname.trim();
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

    public String getPda1() {
        return pda1;
    }

    public void setPda1(String pda1) {
        this.pda1 = pda1 == null ? null : pda1.trim();
    }

    public String getPda2() {
        return pda2;
    }

    public void setPda2(String pda2) {
        this.pda2 = pda2 == null ? null : pda2.trim();
    }

    public String getTaskname() {
        return taskname;
    }

    public void setTaskname(String taskname) {
        this.taskname = taskname == null ? null : taskname.trim();
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

    public String getOrignalslot() {
        return orignalslot;
    }

    public void setOrignalslot(String orignalslot) {
        this.orignalslot = orignalslot == null ? null : orignalslot.trim();
    }
}