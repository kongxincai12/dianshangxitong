package com.jcd.mapper.shop;

import com.jcd.model.shop.ShopAddress;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShopAddressMapper {

    /** 按创建时间升序, 保证"没有默认地址时取第一个"结果稳定 */
    List<ShopAddress> selectByUser(@Param("userId") String userId);

    ShopAddress selectById(@Param("id") String id);

    /** 当前用户的默认地址, 没有则返回 null */
    ShopAddress selectDefault(@Param("userId") String userId);

    int countByUser(@Param("userId") String userId);

    int insert(ShopAddress address);

    /** 只改收货人三要素, 默认标记走单独的接口 */
    int update(ShopAddress address);

    /** 带 USER_ID 条件, 防止越权删除他人地址 */
    int deleteByIdAndUser(@Param("id") String id, @Param("userId") String userId);

    int clearDefault(@Param("userId") String userId);

    int markDefault(@Param("id") String id, @Param("userId") String userId);
}
