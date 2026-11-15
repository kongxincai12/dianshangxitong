package com.jcd.dto.shop;

import lombok.Data;

/**
 * 客户登录请求
 */
@Data
public class ShopLoginDto {
    private String username;
    private String password;
}
