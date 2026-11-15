package com.jcd.model;

import java.math.BigDecimal;
import java.util.Date;

public class Wiplog {
    private String wiplogid;

    private String wipid;

    private String stepid;

    private Date steppasstime;

    private String defectflag;

    private String remark;

    private String username;

    private String lineid;

    private String stationid;

    private String lotid;

    private String moid;

    private String wipresid;

    private BigDecimal defectqty;

    private BigDecimal wipqty;

    private BigDecimal scrapqty;

    private BigDecimal workinghours;

    private String ospInvoicedetailid;

    private String testversion;

    private String processseq;

    private String workorderid;

    private String status;

    private String datecode;

    private String shipid;

    private BigDecimal eqpworkhours;

    private String ospvendorcode;

    private String ospvendorname;

    private String stepidparent;

    public String getWiplogid() {
        return wiplogid;
    }

    public void setWiplogid(String wiplogid) {
        this.wiplogid = wiplogid == null ? null : wiplogid.trim();
    }

    public String getWipid() {
        return wipid;
    }

    public void setWipid(String wipid) {
        this.wipid = wipid == null ? null : wipid.trim();
    }

    public String getStepid() {
        return stepid;
    }

    public void setStepid(String stepid) {
        this.stepid = stepid == null ? null : stepid.trim();
    }

    public Date getSteppasstime() {
        return steppasstime;
    }

    public void setSteppasstime(Date steppasstime) {
        this.steppasstime = steppasstime;
    }

    public String getDefectflag() {
        return defectflag;
    }

    public void setDefectflag(String defectflag) {
        this.defectflag = defectflag == null ? null : defectflag.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getLineid() {
        return lineid;
    }

    public void setLineid(String lineid) {
        this.lineid = lineid == null ? null : lineid.trim();
    }

    public String getStationid() {
        return stationid;
    }

    public void setStationid(String stationid) {
        this.stationid = stationid == null ? null : stationid.trim();
    }

    public String getLotid() {
        return lotid;
    }

    public void setLotid(String lotid) {
        this.lotid = lotid == null ? null : lotid.trim();
    }

    public String getMoid() {
        return moid;
    }

    public void setMoid(String moid) {
        this.moid = moid == null ? null : moid.trim();
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

    public BigDecimal getWipqty() {
        return wipqty;
    }

    public void setWipqty(BigDecimal wipqty) {
        this.wipqty = wipqty;
    }

    public BigDecimal getScrapqty() {
        return scrapqty;
    }

    public void setScrapqty(BigDecimal scrapqty) {
        this.scrapqty = scrapqty;
    }

    public BigDecimal getWorkinghours() {
        return workinghours;
    }

    public void setWorkinghours(BigDecimal workinghours) {
        this.workinghours = workinghours;
    }

    public String getOspInvoicedetailid() {
        return ospInvoicedetailid;
    }

    public void setOspInvoicedetailid(String ospInvoicedetailid) {
        this.ospInvoicedetailid = ospInvoicedetailid == null ? null : ospInvoicedetailid.trim();
    }

    public String getTestversion() {
        return testversion;
    }

    public void setTestversion(String testversion) {
        this.testversion = testversion == null ? null : testversion.trim();
    }

    public String getProcessseq() {
        return processseq;
    }

    public void setProcessseq(String processseq) {
        this.processseq = processseq == null ? null : processseq.trim();
    }

    public String getWorkorderid() {
        return workorderid;
    }

    public void setWorkorderid(String workorderid) {
        this.workorderid = workorderid == null ? null : workorderid.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getDatecode() {
        return datecode;
    }

    public void setDatecode(String datecode) {
        this.datecode = datecode == null ? null : datecode.trim();
    }

    public String getShipid() {
        return shipid;
    }

    public void setShipid(String shipid) {
        this.shipid = shipid == null ? null : shipid.trim();
    }

    public BigDecimal getEqpworkhours() {
        return eqpworkhours;
    }

    public void setEqpworkhours(BigDecimal eqpworkhours) {
        this.eqpworkhours = eqpworkhours;
    }

    public String getOspvendorcode() {
        return ospvendorcode;
    }

    public void setOspvendorcode(String ospvendorcode) {
        this.ospvendorcode = ospvendorcode == null ? null : ospvendorcode.trim();
    }

    public String getOspvendorname() {
        return ospvendorname;
    }

    public void setOspvendorname(String ospvendorname) {
        this.ospvendorname = ospvendorname == null ? null : ospvendorname.trim();
    }

    public String getStepidparent() {
        return stepidparent;
    }

    public void setStepidparent(String stepidparent) {
        this.stepidparent = stepidparent == null ? null : stepidparent.trim();
    }
}