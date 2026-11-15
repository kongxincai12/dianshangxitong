package com.jcd.dto.shop;

import lombok.Data;

import java.util.List;

/**
 * 下单结算请求
 * 若 items 为空, 则结算当前用户购物车中的全部商品。
 * 收货人信息优先由 addressId 指向的地址簿记录决定, 下面三个手填字段仅在地址簿为空时作为兼容回退。
 */
@Data
public class CheckoutDto {
    /** 收货地址簿ID(可选); 为空时取默认地址, 没有默认地址则取最早创建的一条 */
    private String addressId;
    private String receiverName;
    private String receiverPhone;
    private String receiverAddress;
    private String remark;
    /** 直接结算的商品明细(可选); 为空时使用购物车 */
    private List<CartItemDto> items;
}
