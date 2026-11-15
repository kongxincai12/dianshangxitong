package com.jcd.model.shop;

import lombok.Data;

import java.util.Date;

/**
 * 电商客户账号
 * 表: SHOP_USER
 * 注意: JWT subject 和 SHOP_ORDER/SHOP_CART/SHOP_ADDRESS 的 USER_ID 用的都是 USERNAME,
 * 不是这个 ID; 存量数据已经是这个口径, 改用 ID 会让历史订单和购物车全部查不到。
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
    /** 角色, 写入 JWT role claim, 供 ShopAdminGuard 判定后台入口 */
    private String role;
    /** 状态: 1-正常, 0-禁用 */
    private Integer status;
    private Date createTime;
    private Date updateTime;
}
