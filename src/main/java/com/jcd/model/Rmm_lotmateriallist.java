package com.jcd.model;

import java.math.BigDecimal;
import java.util.Date;

public class Rmm_lotmateriallist {
    private String lmid;

    private String lotid;

    private String lotname;

    private String pn;

    private BigDecimal unitqty;

    private BigDecimal totalqty;

    private BigDecimal releaseqty;

    private String description;

    private Date datetime;

    private String step;

    private String mainpn;

    private BigDecimal mainunitqty;

    public String getLmid() {
        return lmid;
    }

    public void setLmid(String lmid) {
        this.lmid = lmid == null ? null : lmid.trim();
    }

    public String getLotid() {
        return lotid;
    }

    public void setLotid(String lotid) {
        this.lotid = lotid == null ? null : lotid.trim();
    }

    public String getLotname() {
        return lotname;
    }

    public void setLotname(String lotname) {
        this.lotname = lotname == null ? null : lotname.trim();
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn == null ? null : pn.trim();
    }

    public BigDecimal getUnitqty() {
        return unitqty;
    }

    public void setUnitqty(BigDecimal unitqty) {
        this.unitqty = unitqty;
    }

    public BigDecimal getTotalqty() {
        return totalqty;
    }

    public void setTotalqty(BigDecimal totalqty) {
        this.totalqty = totalqty;
    }

    public BigDecimal getReleaseqty() {
        return releaseqty;
    }

    public void setReleaseqty(BigDecimal releaseqty) {
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

    public BigDecimal getMainunitqty() {
        return mainunitqty;
    }

    public void setMainunitqty(BigDecimal mainunitqty) {
        this.mainunitqty = mainunitqty;
    }
}