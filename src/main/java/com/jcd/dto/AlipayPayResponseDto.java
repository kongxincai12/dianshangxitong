package com.jcd.dto;

import lombok.Data;
import java.math.BigDecimal;

/**
 * 支付宝支付响应 DTO
 */
@Data
public class AlipayPayResponseDto {

    /** 商户订单号 */
    private String outTradeNo;

    /** 支付宝交易号 */
    private String tradeNo;

    /** 订单标题 */
    private String subject;

    /** 支付金额 */
    private BigDecimal totalAmount;

    /** 订单状态: WAIT_PAY-待支付, PAID-已支付 */
    private String orderStatus;

    /** 支付表单内容 (用于前端唤起支付宝支付) */
    private String form;

    /** 支付链接 (用于扫码支付) */
    private String payUrl;

    /** 支付类型: QR-二维码, WAP-手机网站支付页面 */
    private String payType;
}
