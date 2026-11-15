package com.jcd.dto;

import lombok.Data;

/**
 * 支付宝交易查询请求 DTO
 */
@Data
public class AlipayQueryRequestDto {

    /** 商户订单号 (与支付宝交易号二选一) */
    private String outTradeNo;

    /** 支付宝交易号 (与商户订单号二选一) */
    private String tradeNo;
}
