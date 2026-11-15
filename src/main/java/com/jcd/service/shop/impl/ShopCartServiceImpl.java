package com.jcd.service.shop.impl;

import com.jcd.exception.BusinessException;
import com.jcd.mapper.shop.ShopCartMapper;
import com.jcd.mapper.shop.ShopProductMapper;
import com.jcd.model.shop.ShopCart;
import com.jcd.model.shop.ShopProduct;
import com.jcd.service.shop.ShopCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ShopCartServiceImpl implements ShopCartService {

    @Autowired private ShopCartMapper    cartMapper;
    @Autowired private ShopProductMapper productMapper;

    @Override
    public ShopCart addItem(String userId, String productId, Integer quantity) {
        if (!StringUtils.hasText(productId)) {
            throw new BusinessException(400, "商品ID不能为空");
        }
        int qty = quantity == null || quantity <= 0 ? 1 : quantity;
        ShopProduct product = productMapper.selectById(productId);
        if (product == null) {
            throw new BusinessException(404, "商品不存在: " + productId);
        }
        if (product.getStatus() != null && product.getStatus() == 0) {
            throw new BusinessException(409, "商品已下架: " + product.getName());
        }

        Date now = new Date();
        ShopCart exist = cartMapper.selectByUserAndProduct(userId, productId);
        if (exist != null) {
            cartMapper.updateQuantity(exist.getId(), exist.getQuantity() + qty);
            exist.setQuantity(exist.getQuantity() + qty);
            return exist;
        }
        ShopCart cart = new ShopCart();
        cart.setId(uuid());
        cart.setUserId(userId);
        cart.setProductId(productId);
        cart.setQuantity(qty);
        cart.setCreateTime(now);
        cart.setUpdateTime(now);
        cartMapper.insert(cart);
        return cart;
    }

    @Override
    public List<ShopCart> listCart(String userId) {
        return cartMapper.selectByUser(userId);
    }

    @Override
    public void updateQuantity(String userId, String cartId, Integer quantity) {
        if (quantity == null || quantity <= 0) {
            throw new BusinessException(400, "数量必须大于0");
        }
        ShopCart target = findOwnedCart(userId, cartId);
        cartMapper.updateQuantity(target.getId(), quantity);
    }

    @Override
    public void removeItem(String userId, String cartId) {
        ShopCart target = findOwnedCart(userId, cartId);
        cartMapper.deleteById(target.getId());
    }

    @Override
    public void clear(String userId) {
        cartMapper.deleteByUser(userId);
    }

    /** 校验购物车条目归属当前用户 */
    private ShopCart findOwnedCart(String userId, String cartId) {
        List<ShopCart> carts = cartMapper.selectByUser(userId);
        for (ShopCart c : carts) {
            if (c.getId().equals(cartId)) {
                return c;
            }
        }
        throw new BusinessException(404, "购物车条目不存在: " + cartId);
    }

    private String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
