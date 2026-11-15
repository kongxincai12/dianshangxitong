package com.jcd.model.shop;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品
 * 表: SHOP_PRODUCT
 */
@Data
public class ShopProduct {
    private String id;
    private String name;
    private String categoryId;
    private BigDecimal price;
    private Integer stock;
    private String description;
    private String imageUrl;
    /** 状态: 1-上架, 0-下架 */
    private Integer status;
    private Date createTime;
    private Date updateTime;

    /** 关联分类名称, 非数据库字段 */
    private String categoryName;
}
