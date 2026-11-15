package com.jcd.service.shop;

import com.jcd.model.shop.ShopCategory;
import com.jcd.model.shop.ShopProduct;

import java.util.List;
import java.util.Map;

/**
 * 商品/分类服务
 */
public interface ShopProductService {

    List<ShopCategory> listCategories();

    ShopCategory addCategory(ShopCategory category);

    /** 商品分页查询 */
    Map<String, Object> queryProducts(String name, String categoryId, Integer status, int pageNo, int pageSize);

    ShopProduct getProduct(String id);

    /** 新增或修改商品(id 为空则新增) */
    ShopProduct saveProduct(ShopProduct product);

    /** 上架/下架 */
    void updateStatus(String id, Integer status);

    void deleteProduct(String id);
}
