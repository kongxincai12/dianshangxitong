package com.jcd.model.shop;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单明细
 * 表: SHOP_ORDER_ITEM
 */
@Data
public class ShopOrderItem {
    private String id;
    private String orderId;
    private String productId;
    private String productName;
    private BigDecimal price;
    private Integer quantity;
    private BigDecimal subtotal;
}
