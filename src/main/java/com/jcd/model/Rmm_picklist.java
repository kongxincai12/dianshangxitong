package com.jcd.model;

import java.util.Date;
import java.math.BigDecimal;

public class Rmm_picklist {
    private String picklistid;

    private String transferid;

    private String upn;

    private String location;

    private BigDecimal releaseqty;

    private BigDecimal retrunqty;

    private String releasetype;

    private String status;

    private String picktype;

    private Date datetime;

    private String username;

    public String getPicklistid() {
        return picklistid;
    }

    public void setPicklistid(String picklistid) {
        this.picklistid = picklistid == null ? null : picklistid.trim();
    }

    public String getTransferid() {
        return transferid;
    }

    public void setTransferid(String transferid) {
        this.transferid = transferid == null ? null : transferid.trim();
    }

    public String getUpn() {
        return upn;
    }

    public void setUpn(String upn) {
        this.upn = upn == null ? null : upn.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public BigDecimal getReleaseqty() {
        return releaseqty;
    }

    public void setReleaseqty(BigDecimal releaseqty) {
        this.releaseqty = releaseqty;
    }

    public BigDecimal getRetrunqty() {
        return retrunqty;
    }

    public void setRetrunqty(BigDecimal retrunqty) {
        this.retrunqty = retrunqty;
    }

    public String getReleasetype() {
        return releasetype;
    }

    public void setReleasetype(String releasetype) {
        this.releasetype = releasetype == null ? null : releasetype.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getPicktype() {
        return picktype;
    }

    public void setPicktype(String picktype) {
        this.picktype = picktype == null ? null : picktype.trim();
    }

    public Date getDatetime() {
        return datetime;
    }

    public void setDatetime(Date datetime) {
        this.datetime = datetime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }
}