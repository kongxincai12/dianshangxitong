package com.jcd.model.shop;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 订单主表
 * 表: SHOP_ORDER
 */
@Data
public class ShopOrder {
    private String id;
    private String orderNo;
    private String userId;
    private BigDecimal totalAmount;
    /** 订单状态: PENDING-待支付, PAID-已支付, CANCELLED-已取消 */
    private String status;
    private String receiverName;
    private String receiverPhone;
    private String receiverAddress;
    private String remark;
    private Date payTime;
    private Date createTime;
    private Date updateTime;

    /** 订单明细, 非数据库字段 */
    private java.util.List<ShopOrderItem> items;
}
