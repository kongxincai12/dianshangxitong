package com.jcd.service.shop;

import com.jcd.dto.shop.ShopLoginDto;
import com.jcd.dto.shop.ShopRegisterDto;
import com.jcd.model.shop.ShopUser;

import java.util.Map;

/**
 * 电商客户账号服务: 注册 / 登录 / 校验
 */
public interface ShopUserService {

    /** 注册新客户, 返回脱敏后的用户信息 */
    ShopUser register(ShopRegisterDto dto);

    /**
     * 登录成功返回 {token, user:{username, fullname, userposition, phone, email}}
     * user 里的字段名沿用 MES 登录接口, 前端靠 fullname 显示昵称, 不要改。
     */
    Map<String, Object> login(ShopLoginDto dto);

    /** 校验登录账号是否为有效且启用的商城账号, 不存在或禁用则抛异常 */
    ShopUser assertCustomer(String username);
}
