package com.jcd.model.shop;

import lombok.Data;

import java.util.Date;

/**
 * 收货地址簿
 * 表: SHOP_ADDRESS
 */
@Data
public class ShopAddress {
    private String id;
    /** 所属用户, 登录账号, 与 SHOP_ORDER.USER_ID 同一口径 */
    private String userId;
    private String receiverName;
    private String receiverPhone;
    private String receiverAddress;
    /** 是否默认收货地址: 1-是, 0-否 */
    private Integer isDefault;
    private Date createTime;
    private Date updateTime;
}
