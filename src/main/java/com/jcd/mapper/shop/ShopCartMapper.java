package com.jcd.mapper.shop;

import com.jcd.model.shop.ShopCart;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShopCartMapper {

    ShopCart selectByUserAndProduct(@Param("userId") String userId,
                                    @Param("productId") String productId);

    /** 查询某用户购物车(关联商品展示信息) */
    List<ShopCart> selectByUser(@Param("userId") String userId);

    int insert(ShopCart cart);

    int updateQuantity(@Param("id") String id, @Param("quantity") int quantity);

    int deleteById(@Param("id") String id);

    int deleteByUser(@Param("userId") String userId);

    int deleteByUserAndProducts(@Param("userId") String userId,
                                @Param("productIds") List<String> productIds);
}
