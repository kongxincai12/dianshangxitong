package com.jcd.model;

import java.math.BigDecimal;
import java.util.Date;

public class Wip {
    private String wipid;

    private String sn;

    private String trackingunit;

    private String productid;

    private String lotid;

    private String lineid;

    private String currentstepid;

    private String nextstepid;

    private String defectflag;

    private String actionid;

    private BigDecimal qtyin;

    private BigDecimal subcompqtyin;

    private BigDecimal qtyout;

    private BigDecimal subcompqtyout;

    private String commentid;

    private String username;

    private Date datetime;

    private String currentnodehandle;

    private String wipstatus;

    private String wipresid;

    private BigDecimal defectqty;

    private String testversion;

    private String ipqcstatus;

    public String getWipid() {
        return wipid;
    }

    public void setWipid(String wipid) {
        this.wipid = wipid == null ? null : wipid.trim();
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn == null ? null : sn.trim();
    }

    public String getTrackingunit() {
        return trackingunit;
    }

    public void setTrackingunit(String trackingunit) {
        this.trackingunit = trackingunit == null ? null : trackingunit.trim();
    }

    public String getProductid() {
        return productid;
    }

    public void setProductid(String productid) {
        this.productid = productid == null ? null : productid.trim();
    }

    public String getLotid() {
        return lotid;
    }

    public void setLotid(String lotid) {
        this.lotid = lotid == null ? null : lotid.trim();
    }

    public String getLineid() {
        return lineid;
    }

    public void setLineid(String lineid) {
        this.lineid = lineid == null ? null : lineid.trim();
    }

    public String getCurrentstepid() {
        return currentstepid;
    }

    public void setCurrentstepid(String currentstepid) {
        this.currentstepid = currentstepid == null ? null : currentstepid.trim();
    }

    public String getNextstepid() {
        return nextstepid;
    }

    public void setNextstepid(String nextstepid) {
        this.nextstepid = nextstepid == null ? null : nextstepid.trim();
    }

    public String getDefectflag() {
        return defectflag;
    }

    public void setDefectflag(String defectflag) {
        this.defectflag = defectflag == null ? null : defectflag.trim();
    }

    public String getActionid() {
        return actionid;
    }

    public void setActionid(String actionid) {
        this.actionid = actionid == null ? null : actionid.trim();
    }

    public BigDecimal getQtyin() {
        return qtyin;
    }

    public void setQtyin(BigDecimal qtyin) {
        this.qtyin = qtyin;
    }

    public BigDecimal getSubcompqtyin() {
        return subcompqtyin;
    }

    public void setSubcompqtyin(BigDecimal subcompqtyin) {
        this.subcompqtyin = subcompqtyin;
    }

    public BigDecimal getQtyout() {
        return qtyout;
    }

    public void setQtyout(BigDecimal qtyout) {
        this.qtyout = qtyout;
    }

    public BigDecimal getSubcompqtyout() {
        return subcompqtyout;
    }

    public void setSubcompqtyout(BigDecimal subcompqtyout) {
        this.subcompqtyout = subcompqtyout;
    }

    public String getCommentid() {
        return commentid;
    }

    public void setCommentid(String commentid) {
        this.commentid = commentid == null ? null : commentid.trim();
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

    public String getCurrentnodehandle() {
        return currentnodehandle;
    }

    public void setCurrentnodehandle(String currentnodehandle) {
        this.currentnodehandle = currentnodehandle == null ? null : currentnodehandle.trim();
    }

    public String getWipstatus() {
        return wipstatus;
    }

    public void setWipstatus(String wipstatus) {
        this.wipstatus = wipstatus == null ? null : wipstatus.trim();
    }

    public String getWipresid() {
        return wipresid;
    }

    public void setWipresid(String wipresid) {
        this.wipresid = wipresid == null ? null : wipresid.trim();
    }

    public BigDecimal getDefectqty() {
        return defectqty;
    }

    public void setDefectqty(BigDecimal defectqty) {
        this.defectqty = defectqty;
    }

    public String getTestversion() {
        return testversion;
    }

    public void setTestversion(String testversion) {
        this.testversion = testversion == null ? null : testversion.trim();
    }

    public String getIpqcstatus() {
        return ipqcstatus;
    }

    public void setIpqcstatus(String ipqcstatus) {
        this.ipqcstatus = ipqcstatus == null ? null : ipqcstatus.trim();
    }
}