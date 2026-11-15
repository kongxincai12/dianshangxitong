package com.jcd.model;

import java.math.BigDecimal;
import java.util.Date;

public class Eqp {
    private String eqpid;

    private String eqpname;

    private String description;

    private String eqptypeid;

    private String templateid;

    private BigDecimal maxcapacity;

    private BigDecimal currentcapacity;

    private String unitofcapacity;

    private String state;

    private String currentlot;

    private String username;

    private String datetime;

    private String eventsetid;

    private String eqpmodule;

    private String eqpseq;

    private String version;

    private Date buydate;

    public String getEqpid() {
        return eqpid;
    }

    public void setEqpid(String eqpid) {
        this.eqpid = eqpid == null ? null : eqpid.trim();
    }

    public String getEqpname() {
        return eqpname;
    }

    public void setEqpname(String eqpname) {
        this.eqpname = eqpname == null ? null : eqpname.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getEqptypeid() {
        return eqptypeid;
    }

    public void setEqptypeid(String eqptypeid) {
        this.eqptypeid = eqptypeid == null ? null : eqptypeid.trim();
    }

    public String getTemplateid() {
        return templateid;
    }

    public void setTemplateid(String templateid) {
        this.templateid = templateid == null ? null : templateid.trim();
    }

    public BigDecimal getMaxcapacity() {
        return maxcapacity;
    }

    public void setMaxcapacity(BigDecimal maxcapacity) {
        this.maxcapacity = maxcapacity;
    }

    public BigDecimal getCurrentcapacity() {
        return currentcapacity;
    }

    public void setCurrentcapacity(BigDecimal currentcapacity) {
        this.currentcapacity = currentcapacity;
    }

    public String getUnitofcapacity() {
        return unitofcapacity;
    }

    public void setUnitofcapacity(String unitofcapacity) {
        this.unitofcapacity = unitofcapacity == null ? null : unitofcapacity.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getCurrentlot() {
        return currentlot;
    }

    public void setCurrentlot(String currentlot) {
        this.currentlot = currentlot == null ? null : currentlot.trim();
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

    public String getEventsetid() {
        return eventsetid;
    }

    public void setEventsetid(String eventsetid) {
        this.eventsetid = eventsetid == null ? null : eventsetid.trim();
    }

    public String getEqpmodule() {
        return eqpmodule;
    }

    public void setEqpmodule(String eqpmodule) {
        this.eqpmodule = eqpmodule == null ? null : eqpmodule.trim();
    }

    public String getEqpseq() {
        return eqpseq;
    }

    public void setEqpseq(String eqpseq) {
        this.eqpseq = eqpseq == null ? null : eqpseq.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public Date getBuydate() {
        return buydate;
    }

    public void setBuydate(Date buydate) {
        this.buydate = buydate;
    }
}