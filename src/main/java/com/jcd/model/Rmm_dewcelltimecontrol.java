package com.jcd.model;

import java.math.BigDecimal;
import java.util.Date;

public class Rmm_dewcelltimecontrol {
    private String dewcelltcid;

    private String upnid;

    private BigDecimal fsh;

    private BigDecimal dryingtime;

    private BigDecimal lfsh;

    private BigDecimal warningtimey;

    private BigDecimal warningtimer;

    private BigDecimal leftfsh;

    private Date fshstarttime;

    private Date fshbreaktime;

    private Date bakeintime;

    private Date bakeouttime;

    public String getDewcelltcid() {
        return dewcelltcid;
    }

    public void setDewcelltcid(String dewcelltcid) {
        this.dewcelltcid = dewcelltcid == null ? null : dewcelltcid.trim();
    }

    public String getUpnid() {
        return upnid;
    }

    public void setUpnid(String upnid) {
        this.upnid = upnid == null ? null : upnid.trim();
    }

    public BigDecimal getFsh() {
        return fsh;
    }

    public void setFsh(BigDecimal fsh) {
        this.fsh = fsh;
    }

    public BigDecimal getDryingtime() {
        return dryingtime;
    }

    public void setDryingtime(BigDecimal dryingtime) {
        this.dryingtime = dryingtime;
    }

    public BigDecimal getLfsh() {
        return lfsh;
    }

    public void setLfsh(BigDecimal lfsh) {
        this.lfsh = lfsh;
    }

    public BigDecimal getWarningtimey() {
        return warningtimey;
    }

    public void setWarningtimey(BigDecimal warningtimey) {
        this.warningtimey = warningtimey;
    }

    public BigDecimal getWarningtimer() {
        return warningtimer;
    }

    public void setWarningtimer(BigDecimal warningtimer) {
        this.warningtimer = warningtimer;
    }

    public BigDecimal getLeftfsh() {
        return leftfsh;
    }

    public void setLeftfsh(BigDecimal leftfsh) {
        this.leftfsh = leftfsh;
    }

    public Date getFshstarttime() {
        return fshstarttime;
    }

    public void setFshstarttime(Date fshstarttime) {
        this.fshstarttime = fshstarttime;
    }

    public Date getFshbreaktime() {
        return fshbreaktime;
    }

    public void setFshbreaktime(Date fshbreaktime) {
        this.fshbreaktime = fshbreaktime;
    }

    public Date getBakeintime() {
        return bakeintime;
    }

    public void setBakeintime(Date bakeintime) {
        this.bakeintime = bakeintime;
    }

    public Date getBakeouttime() {
        return bakeouttime;
    }

    public void setBakeouttime(Date bakeouttime) {
        this.bakeouttime = bakeouttime;
    }
}