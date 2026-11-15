package com.jcd.dto;

import lombok.Data;
import java.math.BigDecimal;

/**
 * 支付宝退款请求 DTO
 */
@Data
public class AlipayRefundRequestDto {

    /** 商户订单号 (与支付宝交易号二选一, 优先使用支付宝交易号) */
    private String outTradeNo;

    /** 支付宝交易号 (与商户订单号二选一) */
    private String tradeNo;

    /** 退款金额, 单位: 元 (必填, 不能超过订单总金额) */
    private BigDecimal refundAmount;

    /** 退款原因 (可选) */
    private String refundReason;

    /** 退款请求号 (同一笔订单多次退款时必填, 用于标识唯一的退款请求) */
    private String outRequestNo;

    /** 操作员 (可选) */
    private String operatorId;
}
