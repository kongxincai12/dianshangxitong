package com.jcd.model;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class Workorder {
    private String orderid;

    private String ordername;

    private String organizationcode;

    private String description;

    private String productname;

    private String salesnumber;

    private String customercode;

    private BigInteger totalqty;

    private BigInteger startqty;

    private BigInteger remainqty;

    private String state;

    private String ordertype;

    private String bondertype;

    private String category;

    private String unit;

    private BigDecimal panellength;

    private BigDecimal panelwidth;

    private BigDecimal panelpcs;

    private BigDecimal panelarea;

    private String bomversion;

    private Date planstartdate;

    private Date planenddate;

    private String ordercomment;

    private String username;

    private Date datetime;

    private String auditor;

    private Date auditdate;

    private String customerPn;

    private BigDecimal qty;

    private String attribute1;

    private String attribute2;

    private String attribute3;

    private String attribute4;

    private String attribute5;

    public String getOrderid() {
        return orderid;
    }

    public void setOrderid(String orderid) {
        this.orderid = orderid == null ? null : orderid.trim();
    }

    public String getOrdername() {
        return ordername;
    }

    public void setOrdername(String ordername) {
        this.ordername = ordername == null ? null : ordername.trim();
    }

    public String getOrganizationcode() {
        return organizationcode;
    }

    public void setOrganizationcode(String organizationcode) {
        this.organizationcode = organizationcode == null ? null : organizationcode.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }

    public String getSalesnumber() {
        return salesnumber;
    }

    public void setSalesnumber(String salesnumber) {
        this.salesnumber = salesnumber == null ? null : salesnumber.trim();
    }

    public String getCustomercode() {
        return customercode;
    }

    public void setCustomercode(String customercode) {
        this.customercode = customercode == null ? null : customercode.trim();
    }

    public BigInteger getTotalqty() {
        return totalqty;
    }

    public void setTotalqty(BigInteger totalqty) {
        this.totalqty = totalqty;
    }

    public BigInteger getStartqty() {
        return startqty;
    }

    public void setStartqty(BigInteger startqty) {
        this.startqty = startqty;
    }

    public BigInteger getRemainqty() {
        return remainqty;
    }

    public void setRemainqty(BigInteger remainqty) {
        this.remainqty = remainqty;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getOrdertype() {
        return ordertype;
    }

    public void setOrdertype(String ordertype) {
        this.ordertype = ordertype == null ? null : ordertype.trim();
    }

    public String getBondertype() {
        return bondertype;
    }

    public void setBondertype(String bondertype) {
        this.bondertype = bondertype == null ? null : bondertype.trim();
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category == null ? null : category.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public BigDecimal getPanellength() {
        return panellength;
    }

    public void setPanellength(BigDecimal panellength) {
        this.panellength = panellength;
    }

    public BigDecimal getPanelwidth() {
        return panelwidth;
    }

    public void setPanelwidth(BigDecimal panelwidth) {
        this.panelwidth = panelwidth;
    }

    public BigDecimal getPanelpcs() {
        return panelpcs;
    }

    public void setPanelpcs(BigDecimal panelpcs) {
        this.panelpcs = panelpcs;
    }

    public BigDecimal getPanelarea() {
        return panelarea;
    }

    public void setPanelarea(BigDecimal panelarea) {
        this.panelarea = panelarea;
    }

    public String getBomversion() {
        return bomversion;
    }

    public void setBomversion(String bomversion) {
        this.bomversion = bomversion == null ? null : bomversion.trim();
    }

    public Date getPlanstartdate() {
        return planstartdate;
    }

    public void setPlanstartdate(Date planstartdate) {
        this.planstartdate = planstartdate;
    }

    public Date getPlanenddate() {
        return planenddate;
    }

    public void setPlanenddate(Date planenddate) {
        this.planenddate = planenddate;
    }

    public String getOrdercomment() {
        return ordercomment;
    }

    public void setOrdercomment(String ordercomment) {
        this.ordercomment = ordercomment == null ? null : ordercomment.trim();
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

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor == null ? null : auditor.trim();
    }

    public Date getAuditdate() {
        return auditdate;
    }

    public void setAuditdate(Date auditdate) {
        this.auditdate = auditdate;
    }

    public String getCustomerPn() {
        return customerPn;
    }

    public void setCustomerPn(String customerPn) {
        this.customerPn = customerPn == null ? null : customerPn.trim();
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1 == null ? null : attribute1.trim();
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2 == null ? null : attribute2.trim();
    }

    public String getAttribute3() {
        return attribute3;
    }

    public void setAttribute3(String attribute3) {
        this.attribute3 = attribute3 == null ? null : attribute3.trim();
    }

    public String getAttribute4() {
        return attribute4;
    }

    public void setAttribute4(String attribute4) {
        this.attribute4 = attribute4 == null ? null : attribute4.trim();
    }

    public String getAttribute5() {
        return attribute5;
    }

    public void setAttribute5(String attribute5) {
        this.attribute5 = attribute5 == null ? null : attribute5.trim();
    }
}