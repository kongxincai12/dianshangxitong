package com.jcd.model;

import java.math.BigDecimal;

public class Loadinglistcontent {
    private String llcid;

    private String llid;

    private String eqpname;

    private String boardnum;

    private String stage;

    private String slot;

    private String pn;

    private String alternatepn;

    private BigDecimal qty;

    private String boardside;

    private String location;

    private String orignalslot;

    public String getLlcid() {
        return llcid;
    }

    public void setLlcid(String llcid) {
        this.llcid = llcid == null ? null : llcid.trim();
    }

    public String getLlid() {
        return llid;
    }

    public void setLlid(String llid) {
        this.llid = llid == null ? null : llid.trim();
    }

    public String getEqpname() {
        return eqpname;
    }

    public void setEqpname(String eqpname) {
        this.eqpname = eqpname == null ? null : eqpname.trim();
    }

    public String getBoardnum() {
        return boardnum;
    }

    public void setBoardnum(String boardnum) {
        this.boardnum = boardnum == null ? null : boardnum.trim();
    }

    public String getStage() {
        return stage;
    }

    public void setStage(String stage) {
        this.stage = stage == null ? null : stage.trim();
    }

    public String getSlot() {
        return slot;
    }

    public void setSlot(String slot) {
        this.slot = slot == null ? null : slot.trim();
    }

    public String getPn() {
        return pn;
    }

    public void setPn(String pn) {
        this.pn = pn == null ? null : pn.trim();
    }

    public String getAlternatepn() {
        return alternatepn;
    }

    public void setAlternatepn(String alternatepn) {
        this.alternatepn = alternatepn == null ? null : alternatepn.trim();
    }

    public BigDecimal getQty() {
        return qty;
    }

    public void setQty(BigDecimal qty) {
        this.qty = qty;
    }

    public String getBoardside() {
        return boardside;
    }

    public void setBoardside(String boardside) {
        this.boardside = boardside == null ? null : boardside.trim();
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location == null ? null : location.trim();
    }

    public String getOrignalslot() {
        return orignalslot;
    }

    public void setOrignalslot(String orignalslot) {
        this.orignalslot = orignalslot == null ? null : orignalslot.trim();
    }
}