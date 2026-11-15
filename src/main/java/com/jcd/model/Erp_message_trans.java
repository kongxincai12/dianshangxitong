package com.jcd.model;

import java.util.Date;

public class Erp_message_trans {
    private String id;

    private String transactions;

    private String logtable;

    private String logtableid;

    private String transFlag;

    private String username;

    private Date datetime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getTransactions() {
        return transactions;
    }

    public void setTransactions(String transactions) {
        this.transactions = transactions == null ? null : transactions.trim();
    }

    public String getLogtable() {
        return logtable;
    }

    public void setLogtable(String logtable) {
        this.logtable = logtable == null ? null : logtable.trim();
    }

    public String getLogtableid() {
        return logtableid;
    }

    public void setLogtableid(String logtableid) {
        this.logtableid = logtableid == null ? null : logtableid.trim();
    }

    public String getTransFlag() {
        return transFlag;
    }

    public void setTransFlag(String transFlag) {
        this.transFlag = transFlag == null ? null : transFlag.trim();
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
}