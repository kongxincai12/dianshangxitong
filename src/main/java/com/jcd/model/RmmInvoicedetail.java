package com.jcd.model;

import java.math.BigDecimal;
import java.util.Date;

public class RmmInvoicedetail {
    private String invoicedetailid;

    private String invoiceid;

    private String invoicenumber;

    private String submitnumber;

    private String materialtype;

    private String delivernumber;

    private String po;

    private String pn;

    private String vendorcode;

    private String vendorname;

    private BigDecimal totalqty;

    private BigDecimal remainingqty;

    private String checkstatus;

    private String vendorlotno;

    private String description;

    private Date datetime;

    private String checkresult;

    private BigDecimal polinenum;

    private BigDecimal headerid;

    private String transactionid;

    private BigDecimal lineid;

    private String sonumber;

    private String solinenum;

    private String rmapo;

    private String mo;

    private String organizationcode;

    private String username;

    private String unit;

    private BigDecimal verdorsiteid;

    private String vmi;

    private String obj01;

    private String obj02;

    private Date limitedday;

    private String packstyle;

    private String vendorweekcode;

    private String materialstorage;

    private String msd;

    private String esd;

    private String vendorsn;

    public String getInvoicedetailid() {
        return invoicedetailid;
    }

    public void setInvoicedetailid(String invoicedetailid) {
        this.invoicedetailid = invoicedetailid == null ? null : invoicedetailid.trim();
    }

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

    public String getMaterialtype() {
        return materialtype;
    }

    public void setMaterialtype(String materialtype) {
        this.materialtype = materialtype == null ? null : materialtype.trim();
    }

    public String getDelivernumber() {
        return delivernumber;
    }

    public void setDelivernumber(String delivernumber) {
        this.delivernumber = delivernumber == null ? null : delivernumber.trim();
    }

    public String getPo() {
        return po;
    }

    public void setPo(String po) {
        this.po = po == null ? null : po.trim();
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn == null ? null : pn.trim();
    }

    public String getVendorcode() {
        return vendorcode;
    }

    public void setVendorcode(String vendorcode) {
        this.vendorcode = vendorcode == null ? null : vendorcode.trim();
    }

    public String getVendorname() {
        return vendorname;
    }

    public void setVendorname(String vendorname) {
        this.vendorname = vendorname == null ? null : vendorname.trim();
    }

    public BigDecimal getTotalqty() {
        return totalqty;
    }

    public void setTotalqty(BigDecimal totalqty) {
        this.totalqty = totalqty;
    }

    public BigDecimal getRemainingqty() {
        return remainingqty;
    }

    public void setRemainingqty(BigDecimal remainingqty) {
        this.remainingqty = remainingqty;
    }

    public String getCheckstatus() {
        return checkstatus;
    }

    public void setCheckstatus(String checkstatus) {
        this.checkstatus = checkstatus == null ? null : checkstatus.trim();
    }

    public String getVendorlotno() {
        return vendorlotno;
    }

    public void setVendorlotno(String vendorlotno) {
        this.vendorlotno = vendorlotno == null ? null : vendorlotno.trim();
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

    public String getCheckresult() {
        return checkresult;
    }

    public void setCheckresult(String checkresult) {
        this.checkresult = checkresult == null ? null : checkresult.trim();
    }

    public BigDecimal getPolinenum() {
        return polinenum;
    }

    public void setPolinenum(BigDecimal polinenum) {
        this.polinenum = polinenum;
    }

    public BigDecimal getHeaderid() {
        return headerid;
    }

    public void setHeaderid(BigDecimal headerid) {
        this.headerid = headerid;
    }

    public String getTransactionid() {
        return transactionid;
    }

    public void setTransactionid(String transactionid) {
        this.transactionid = transactionid == null ? null : transactionid.trim();
    }

    public BigDecimal getLineid() {
        return lineid;
    }

    public void setLineid(BigDecimal lineid) {
        this.lineid = lineid;
    }

    public String getSonumber() {
        return sonumber;
    }

    public void setSonumber(String sonumber) {
        this.sonumber = sonumber == null ? null : sonumber.trim();
    }

    public String getSolinenum() {
        return solinenum;
    }

    public void setSolinenum(String solinenum) {
        this.solinenum = solinenum == null ? null : solinenum.trim();
    }

    public String getRmapo() {
        return rmapo;
    }

    public void setRmapo(String rmapo) {
        this.rmapo = rmapo == null ? null : rmapo.trim();
    }

    public String getMo() {
        return mo;
    }

    public void setMo(String mo) {
        this.mo = mo == null ? null : mo.trim();
    }

    public String getOrganizationcode() {
        return organizationcode;
    }

    public void setOrganizationcode(String organizationcode) {
        this.organizationcode = organizationcode == null ? null : organizationcode.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public BigDecimal getVerdorsiteid() {
        return verdorsiteid;
    }

    public void setVerdorsiteid(BigDecimal verdorsiteid) {
        this.verdorsiteid = verdorsiteid;
    }

    public String getVmi() {
        return vmi;
    }

    public void setVmi(String vmi) {
        this.vmi = vmi == null ? null : vmi.trim();
    }

    public String getObj01() {
        return obj01;
    }

    public void setObj01(String obj01) {
        this.obj01 = obj01 == null ? null : obj01.trim();
    }

    public String getObj02() {
        return obj02;
    }

    public void setObj02(String obj02) {
        this.obj02 = obj02 == null ? null : obj02.trim();
    }

    public Date getLimitedday() {
        return limitedday;
    }

    public void setLimitedday(Date limitedday) {
        this.limitedday = limitedday;
    }

    public String getPackstyle() {
        return packstyle;
    }

    public void setPackstyle(String packstyle) {
        this.packstyle = packstyle == null ? null : packstyle.trim();
    }

    public String getVendorweekcode() {
        return vendorweekcode;
    }

    public void setVendorweekcode(String vendorweekcode) {
        this.vendorweekcode = vendorweekcode == null ? null : vendorweekcode.trim();
    }

    public String getMaterialstorage() {
        return materialstorage;
    }

    public void setMaterialstorage(String materialstorage) {
        this.materialstorage = materialstorage == null ? null : materialstorage.trim();
    }

    public String getMsd() {
        return msd;
    }

    public void setMsd(String msd) {
        this.msd = msd == null ? null : msd.trim();
    }

    public String getEsd() {
        return esd;
    }

    public void setEsd(String esd) {
        this.esd = esd == null ? null : esd.trim();
    }

    public String getVendorsn() {
        return vendorsn;
    }

    public void setVendorsn(String vendorsn) {
        this.vendorsn = vendorsn == null ? null : vendorsn.trim();
    }
}