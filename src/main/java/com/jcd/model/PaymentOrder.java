package com.jcd.model;

import lombok.Data;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 支付订单模型
 * 对应数据库表: PDA_PAYMENT_ORDER
 */
@Data
public class PaymentOrder {

    /** 主键ID */
    private String id;

    /** 商户订单号 (业务系统生成, 唯一) */
    private String outTradeNo;

    /** 支付宝交易号 (支付宝返回) */
    private String tradeNo;

    /** 订单标题/描述 */
    private String subject;

    /** 支付金额 (单位: 元) */
    private BigDecimal totalAmount;

    /** 订单状态: WAIT_PAY-待支付, PAID-已支付, CLOSED-已关闭, REFUNDED-已退款 */
    private String orderStatus;

    /** 买家支付宝账号 */
    private String buyerLogonId;

    /** 买家支付宝用户ID */
    private String buyerId;

    /** 支付时间 */
    private Date payTime;

    /** 通知时间 */
    private Date notifyTime;

    /** 创建人 */
    private String createBy;

    /** 创建时间 */
    private Date createTime;

    /** 更新人 */
    private String updateBy;

    /** 更新时间 */
    private Date updateTime;

    /** 备注 */
    private String remark;
}
