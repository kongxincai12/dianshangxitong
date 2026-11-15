package com.jcd.model.shop;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 购物车条目
 * 表: SHOP_CART
 */
@Data
public class ShopCart {
    private String id;
    private String userId;
    private String productId;
    private Integer quantity;
    private Date createTime;
    private Date updateTime;

    /* ===== 关联商品展示字段, 非数据库字段 ===== */
    private String productName;
    private BigDecimal price;
    private String imageUrl;
    private Integer stock;
    private Integer status;
}
