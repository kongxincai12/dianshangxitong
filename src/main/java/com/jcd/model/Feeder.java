package com.jcd.model;

import java.math.BigDecimal;
import java.util.Date;

public class Feeder {
    private String feederid;

    private String feedername;

    private String description;

    private String feedertype;

    private String eqptypeid;

    private String needpm;

    private BigDecimal maxqty;

    private BigDecimal usedqty;

    private String moid;

    private String eqpid;

    private String stage;

    private String slot;

    private String username;

    private Date datetime;

    private Integer warningqty;

    public String getFeederid() {
        return feederid;
    }

    public void setFeederid(String feederid) {
        this.feederid = feederid == null ? null : feederid.trim();
    }

    public String getFeedername() {
        return feedername;
    }

    public void setFeedername(String feedername) {
        this.feedername = feedername == null ? null : feedername.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getFeedertype() {
        return feedertype;
    }

    public void setFeedertype(String feedertype) {
        this.feedertype = feedertype == null ? null : feedertype.trim();
    }

    public String getEqptypeid() {
        return eqptypeid;
    }

    public void setEqptypeid(String eqptypeid) {
        this.eqptypeid = eqptypeid == null ? null : eqptypeid.trim();
    }

    public String getNeedpm() {
        return needpm;
    }

    public void setNeedpm(String needpm) {
        this.needpm = needpm == null ? null : needpm.trim();
    }

    public BigDecimal getMaxqty() {
        return maxqty;
    }

    public void setMaxqty(BigDecimal maxqty) {
        this.maxqty = maxqty;
    }

    public BigDecimal getUsedqty() {
        return usedqty;
    }

    public void setUsedqty(BigDecimal usedqty) {
        this.usedqty = usedqty;
    }

    public String getMoid() {
        return moid;
    }

    public void setMoid(String moid) {
        this.moid = moid == null ? null : moid.trim();
    }

    public String getEqpid() {
        return eqpid;
    }

    public void setEqpid(String eqpid) {
        this.eqpid = eqpid == null ? null : eqpid.trim();
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

    public Integer getWarningqty() {
        return warningqty;
    }

    public void setWarningqty(Integer warningqty) {
        this.warningqty = warningqty;
    }
}