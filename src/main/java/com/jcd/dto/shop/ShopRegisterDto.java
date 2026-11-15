package com.jcd.dto.shop;

import lombok.Data;

/**
 * 客户注册请求
 */
@Data
public class ShopRegisterDto {
    private String username;
    private String password;
    private String nickname;
    private String phone;
    private String email;
}
