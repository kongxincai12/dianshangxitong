package com.jcd.mapper.shop;

import com.jcd.model.shop.ShopCategory;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShopCategoryMapper {

    List<ShopCategory> selectAll();

    ShopCategory selectById(String id);

    int insert(ShopCategory category);

    int deleteById(String id);
}
