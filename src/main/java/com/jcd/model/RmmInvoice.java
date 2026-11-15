package com.jcd.model;

import java.math.BigDecimal;
import java.util.Date;

public class RmmInvoice {
    private String invoiceid;

    private String invoicenumber;

    private String submitnumber;

    private String state;

    private String version;

    private String description;

    private Date datetime;

    private BigDecimal blno;

    private String erpuser;

    private String batchprint;

    private String printer;

    private Date printdate;

    private BigDecimal printcnt;

    private String organizationcode;

    private BigDecimal erpheaderid;

    private Date invoicedate;

    public String getInvoiceid() {
        return invoiceid;
    }

    public void setInvoiceid(String invoiceid) {
        this.invoiceid = invoiceid == null ? null : invoiceid.trim();
    }

    public String getInvoicenumber() {
        return invoicenumber;
    }

    public void setInvoicenumber(String invoicenumber) {
        this.invoicenumber = invoicenumber == null ? null : invoicenumber.trim();
    }

    public String getSubmitnumber() {
        return submitnumber;
    }

    public void setSubmitnumber(String submitnumber) {
        this.submitnumber = submitnumber == null ? null : submitnumber.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
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

    public BigDecimal getBlno() {
        return blno;
    }

    public void setBlno(BigDecimal blno) {
        this.blno = blno;
    }

    public String getErpuser() {
        return erpuser;
    }

    public void setErpuser(String erpuser) {
        this.erpuser = erpuser == null ? null : erpuser.trim();
    }

    public String getBatchprint() {
        return batchprint;
    }

    public void setBatchprint(String batchprint) {
        this.batchprint = batchprint == null ? null : batchprint.trim();
    }

    public String getPrinter() {
        return printer;
    }

    public void setPrinter(String printer) {
        this.printer = printer == null ? null : printer.trim();
    }

    public Date getPrintdate() {
        return printdate;
    }

    public void setPrintdate(Date printdate) {
        this.printdate = printdate;
    }

    public BigDecimal getPrintcnt() {
        return printcnt;
    }

    public void setPrintcnt(BigDecimal printcnt) {
        this.printcnt = printcnt;
    }

    public String getOrganizationcode() {
        return organizationcode;
    }

    public void setOrganizationcode(String organizationcode) {
        this.organizationcode = organizationcode == null ? null : organizationcode.trim();
    }

    public BigDecimal getErpheaderid() {
        return erpheaderid;
    }

    public void setErpheaderid(BigDecimal erpheaderid) {
        this.erpheaderid = erpheaderid;
    }

    public Date getInvoicedate() {
        return invoicedate;
    }

    public void setInvoicedate(Date invoicedate) {
        this.invoicedate = invoicedate;
    }
}