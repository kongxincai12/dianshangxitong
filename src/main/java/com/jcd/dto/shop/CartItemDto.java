package com.jcd.dto.shop;

import lombok.Data;

/**
 * 购物车/结算的商品条目
 */
@Data
public class CartItemDto {
    private String productId;
    private Integer quantity;
}
