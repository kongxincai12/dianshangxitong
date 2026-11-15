package com.jcd.model.shop;

import lombok.Data;

import java.util.Date;

/**
 * 商品分类
 * 表: SHOP_CATEGORY
 */
@Data
public class ShopCategory {
    private String id;
    private String name;
    private Integer sortNo;
    private Date createTime;
}
