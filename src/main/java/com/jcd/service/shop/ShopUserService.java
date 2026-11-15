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

    /** 登录成功返回 {token, user} */
    Map<String, Object> login(ShopLoginDto dto);

    /** 校验客户ID是否为有效且启用的账号, 不存在或禁用则抛异常 */
    ShopUser assertCustomer(String customerId);
}
