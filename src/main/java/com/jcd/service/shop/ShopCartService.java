package com.jcd.service.shop;

import com.jcd.model.shop.ShopCart;

import java.util.List;

/**
 * 购物车服务
 */
public interface ShopCartService {

    /** 加入购物车(同商品则累加数量) */
    ShopCart addItem(String userId, String productId, Integer quantity);

    /** 我的购物车(含商品展示信息) */
    List<ShopCart> listCart(String userId);

    /** 修改购物车某条目数量 */
    void updateQuantity(String userId, String cartId, Integer quantity);

    void removeItem(String userId, String cartId);

    void clear(String userId);
}
