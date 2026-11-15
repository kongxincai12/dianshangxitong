package com.jcd.mapper.shop;

import com.jcd.model.shop.ShopProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShopProductMapper {

    ShopProduct selectById(@Param("id") String id);

    /** 分页条件查询商品 */
    List<ShopProduct> queryList(@Param("name") String name,
                                @Param("categoryId") String categoryId,
                                @Param("status") Integer status,
                                @Param("offset") int offset,
                                @Param("limit") int limit);

    int queryListCount(@Param("name") String name,
                       @Param("categoryId") String categoryId,
                       @Param("status") Integer status);

    int insert(ShopProduct product);

    int updateSelective(ShopProduct product);

    int deleteById(@Param("id") String id);

    /** 扣减库存(允许时才扣), 返回受影响行数 */
    int deductStock(@Param("id") String id, @Param("qty") int qty);

    /** 回补库存 */
    int restoreStock(@Param("id") String id, @Param("qty") int qty);
}
