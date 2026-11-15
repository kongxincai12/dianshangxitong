package com.jcd.model.shop;

import lombok.Data;

import java.util.Date;

/**
 * 电商客户账号
 * 表: SHOP_USER
 */
@Data
public class ShopUser {
    private String id;
    private String username;
    /** 密码(加密存储, 不对外返回) */
    private String password;
    private String nickname;
    private String phone;
    private String email;
    /** 状态: 1-正常, 0-禁用 */
    private Integer status;
    private Date createTime;
    private Date updateTime;
}
