package com.jcd.model;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class RecordPacking {
    private String ID;
    private String EMPLOYEEID;
    private String LOTCODE;
    private String MATERIALS;
    private BigDecimal PNL;
    private BigDecimal PCS;
    private BigDecimal XQTY;
    private Integer sumPackQty;
    private String DATECODE;
    private Date CREATEDATE;
    private Date LASTUPDATEDATE;
    private BigDecimal STANDARDCAPACITY;
    private BigDecimal OUTPUTHOURS;
    private String REMARK;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }
    public String getEMPLOYEEID() {
        return EMPLOYEEID;
    }

    public void setEMPLOYEEID(String EMPLOYEEID) {
        this.EMPLOYEEID = EMPLOYEEID;
    }

    public String getLOTCODE() {
        return LOTCODE;
    }

    public void setLOTCODE(String LOTCODE) {
        this.LOTCODE = LOTCODE;
    }

    public String getMATERIALS() {
        return MATERIALS;
    }

    public void setMATERIALS(String MATERIALS) {
        this.MATERIALS = MATERIALS;
    }

    public BigDecimal getPNL() {
        return PNL;
    }

    public void setPNL(BigDecimal PNL) {
        this.PNL = PNL;
    }

    public BigDecimal getPCS() {
        return PCS;
    }

    public void setPCS(BigDecimal PCS) {
        this.PCS = PCS;
    }

    public BigDecimal getXQTY() {
        return XQTY;
    }

    public void setXQTY(BigDecimal XQTY) {
        this.XQTY = XQTY;
    }

    public Integer getSumPackQty() {
        return sumPackQty;
    }

    public void setSumPackQty(Integer sumPackQty) {
        this.sumPackQty = sumPackQty;
    }

    public String getDATECODE() {
        return DATECODE;
    }

    public void setDATECODE(String DATECODE) {
        this.DATECODE = DATECODE;
    }

    public Date getCREATEDATE() {
        return CREATEDATE;
    }

    public void setCREATEDATE(Date createTime) {
        this.CREATEDATE = createTime;
    }

    public Date getLASTUPDATEDATE() {
        return LASTUPDATEDATE;
    }

    public void setLASTUPDATEDATE(Date LASTUPDATEDATE) {
        this.LASTUPDATEDATE = LASTUPDATEDATE;
    }

    public BigDecimal getSTANDARDCAPACITY() {
        return STANDARDCAPACITY;
    }

    public void setSTANDARDCAPACITY(BigDecimal STANDARDCAPACITY) {
        this.STANDARDCAPACITY = STANDARDCAPACITY;
    }

    public BigDecimal getOUTPUTHOURS() {
        return OUTPUTHOURS;
    }

    public void setOUTPUTHOURS(BigDecimal OUTPUTHOURS) {
        this.OUTPUTHOURS = OUTPUTHOURS;
    }

    public String getREMARK() {
        return REMARK;
    }

    public void setREMARK(String REMARK) {
        this.REMARK = REMARK;
    }
}