package com.jcd.model;

import java.util.Date;

public class Rmm_womateriallist {
    private String wmid;

    private String workorderid;

    private String workordername;

    private String pn;

    private Short unitqty;

    private Short totalqty;

    private Short releaseqty;

    private String description;

    private Date datetime;

    private Date operatetime;

    private String erpid;

    private String erpmoid;

    private String unit;

    private String step;

    private String mainpn;

    private Short mainunitqty;

    public String getWmid() {
        return wmid;
    }

    public void setWmid(String wmid) {
        this.wmid = wmid == null ? null : wmid.trim();
    }

    public String getWorkorderid() {
        return workorderid;
    }

    public void setWorkorderid(String workorderid) {
        this.workorderid = workorderid == null ? null : workorderid.trim();
    }

    public String getWorkordername() {
        return workordername;
    }

    public void setWorkordername(String workordername) {
        this.workordername = workordername == null ? null : workordername.trim();
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn == null ? null : pn.trim();
    }

    public Short getUnitqty() {
        return unitqty;
    }

    public void setUnitqty(Short unitqty) {
        this.unitqty = unitqty;
    }

    public Short getTotalqty() {
        return totalqty;
    }

    public void setTotalqty(Short totalqty) {
        this.totalqty = totalqty;
    }

    public Short getReleaseqty() {
        return releaseqty;
    }

    public void setReleaseqty(Short releaseqty) {
        this.releaseqty = releaseqty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public Date getOperatetime() {
        return operatetime;
    }

    public void setOperatetime(Date operatetime) {
        this.operatetime = operatetime;
    }

    public String getErpid() {
        return erpid;
    }

    public void setErpid(String erpid) {
        this.erpid = erpid == null ? null : erpid.trim();
    }

    public String getErpmoid() {
        return erpmoid;
    }

    public void setErpmoid(String erpmoid) {
        this.erpmoid = erpmoid == null ? null : erpmoid.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step == null ? null : step.trim();
    }

    public String getMainpn() {
        return mainpn;
    }

    public void setMainpn(String mainpn) {
        this.mainpn = mainpn == null ? null : mainpn.trim();
    }

    public Short getMainunitqty() {
        return mainunitqty;
    }

    public void setMainunitqty(Short mainunitqty) {
        this.mainunitqty = mainunitqty;
    }
}