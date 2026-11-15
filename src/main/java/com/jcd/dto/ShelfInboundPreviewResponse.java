package com.jcd.dto;

import java.math.BigDecimal;

/**
 * 智能货架 - 入库前SMT直接退料确认信息
 */
public class ShelfInboundPreviewResponse {

    private boolean needConfirm;
    private BigDecimal remainingQty;
    private String message;

    public boolean isNeedConfirm() {
        return needConfirm;
    }

    public void setNeedConfirm(boolean needConfirm) {
        this.needConfirm = needConfirm;
    }

    public BigDecimal getRemainingQty() {
        return remainingQty;
    }

    public void setRemainingQty(BigDecimal remainingQty) {
        this.remainingQty = remainingQty;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
