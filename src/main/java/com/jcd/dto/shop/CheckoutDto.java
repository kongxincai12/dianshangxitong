package com.jcd.dto.shop;

import lombok.Data;

import java.util.List;

/**
 * 下单结算请求
 * 若 items 为空, 则结算当前用户购物车中的全部商品。
 */
@Data
public class CheckoutDto {
    private String receiverName;
    private String receiverPhone;
    private String receiverAddress;
    private String remark;
    /** 直接结算的商品明细(可选); 为空时使用购物车 */
    private List<CartItemDto> items;
}
