package com.jcd.model;

import java.math.BigDecimal;

public class Uf_loadsteppasstime {
    private BigDecimal id;

    private BigDecimal requestid;

    private BigDecimal formmodeid;

    private BigDecimal modedatacreater;

    private BigDecimal modedatacreatertype;

    private String modedatacreatedate;

    private String modedatacreatetime;

    private String step;
    private String step2;

    private BigDecimal time;

    private String bz;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public BigDecimal getRequestid() {
        return requestid;
    }

    public void setRequestid(BigDecimal requestid) {
        this.requestid = requestid;
    }

    public BigDecimal getFormmodeid() {
        return formmodeid;
    }

    public void setFormmodeid(BigDecimal formmodeid) {
        this.formmodeid = formmodeid;
    }

    public BigDecimal getModedatacreater() {
        return modedatacreater;
    }

    public void setModedatacreater(BigDecimal modedatacreater) {
        this.modedatacreater = modedatacreater;
    }

    public BigDecimal getModedatacreatertype() {
        return modedatacreatertype;
    }

    public void setModedatacreatertype(BigDecimal modedatacreatertype) {
        this.modedatacreatertype = modedatacreatertype;
    }

    public String getModedatacreatedate() {
        return modedatacreatedate;
    }

    public void setModedatacreatedate(String modedatacreatedate) {
        this.modedatacreatedate = modedatacreatedate == null ? null : modedatacreatedate.trim();
    }

    public String getModedatacreatetime() {
        return modedatacreatetime;
    }

    public void setModedatacreatetime(String modedatacreatetime) {
        this.modedatacreatetime = modedatacreatetime == null ? null : modedatacreatetime.trim();
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step == null ? null : step.trim();
    }

    public String getStep2() {
        return step2;
    }

    public void setStep2(String step2) {
        this.step2 = step2 == null ? null : step2.trim();
    }

    public BigDecimal getTime() {
        return time;
    }

    public void setTime(BigDecimal time) {
        this.time = time;
    }

    public String getBz() {
        return bz;
    }

    public void setBz(String bz) {
        this.bz = bz == null ? null : bz.trim();
    }
}