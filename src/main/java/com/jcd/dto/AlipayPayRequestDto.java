package com.jcd.dto;

import lombok.Data;
import java.math.BigDecimal;

/**
 * 支付宝支付请求 DTO
 */
@Data
public class AlipayPayRequestDto {

    /** 订单标题 (必填, 如: "商城订单-20261107001") */
    private String subject;

    /** 订单描述 (可选) */
    private String body;

    /** 支付金额, 单位: 元 (必填, 精确到小数点后两位) */
    private BigDecimal totalAmount;

    /** 商户订单号 (可选, 不传则系统自动生成) */
    private String outTradeNo;

    /** 订单超时时间 (可选, 如: "30m" 表示30分钟, "1h" 表示1小时) */
    private String timeoutExpress;

    /** 创建人/操作员 (可选) */
    private String createBy;

    /** 备注 (可选) */
    private String remark;
}
