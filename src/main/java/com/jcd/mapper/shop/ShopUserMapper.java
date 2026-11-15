package com.jcd.mapper.shop;

import com.jcd.model.shop.ShopUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShopUserMapper {

    ShopUser selectById(@Param("id") String id);

    ShopUser selectByUsername(@Param("username") String username);

    int insert(ShopUser user);

    int updateSelective(ShopUser user);
}
