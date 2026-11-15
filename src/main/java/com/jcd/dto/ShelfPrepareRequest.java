package com.jcd.dto;

import java.math.BigDecimal;

/**
 * 智能货架 - 准备入库/移库操作请求体 (前端 → pdaserver)
 */
public class ShelfPrepareRequest {

    /** 货架编号 - 对应 V_LOCATION_ALL.RACK */
    private String rackCode;

    /** UPN名称 */
    private String upnname;

    /** 操作用户名 */
    private String username;

    /** 用户ID */
    private String userId;

    /** 操作类型: INBOUND=入库, TRANSFER=移库 */
    private String operationType;

    /** SMT直接退料入库时，用户确认的UPN剩余数量 */
    private BigDecimal confirmedRemainingQty;

    public String getRackCode() {
        return rackCode;
    }

    public void setRackCode(String rackCode) {
        this.rackCode = rackCode;
    }

    public String getUpnname() {
        return upnname;
    }

    public void setUpnname(String upnname) {
        this.upnname = upnname;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getOperationType() {
        return operationType;
    }

    public void setOperationType(String operationType) {
        this.operationType = operationType;
    }

    public BigDecimal getConfirmedRemainingQty() {
        return confirmedRemainingQty;
    }

    public void setConfirmedRemainingQty(BigDecimal confirmedRemainingQty) {
        this.confirmedRemainingQty = confirmedRemainingQty;
    }
}
