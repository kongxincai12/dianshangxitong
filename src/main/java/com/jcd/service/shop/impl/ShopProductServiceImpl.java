package com.jcd.service.shop.impl;

import com.jcd.exception.BusinessException;
import com.jcd.mapper.shop.ShopCategoryMapper;
import com.jcd.mapper.shop.ShopProductMapper;
import com.jcd.model.shop.ShopCategory;
import com.jcd.model.shop.ShopProduct;
import com.jcd.service.shop.ShopProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ShopProductServiceImpl implements ShopProductService {

    @Autowired private ShopCategoryMapper categoryMapper;
    @Autowired private ShopProductMapper  productMapper;

    @Override
    public List<ShopCategory> listCategories() {
        return categoryMapper.selectAll();
    }

    @Override
    public ShopCategory addCategory(ShopCategory category) {
        if (category == null || !StringUtils.hasText(category.getName())) {
            throw new BusinessException(400, "分类名称不能为空");
        }
        category.setId(uuid());
        if (category.getSortNo() == null) category.setSortNo(0);
        category.setCreateTime(new Date());
        categoryMapper.insert(category);
        return category;
    }

    @Override
    public Map<String, Object> queryProducts(String name, String categoryId, Integer status, int pageNo, int pageSize) {
        if (pageNo < 1) pageNo = 1;
        if (pageSize < 1) pageSize = 20;
        if (pageSize > 200) pageSize = 200;
        int offset = (pageNo - 1) * pageSize;

        int total = productMapper.queryListCount(name, categoryId, status);
        List<ShopProduct> list = productMapper.queryList(name, categoryId, status, offset, pageSize);

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("total", total);
        result.put("pageNo", pageNo);
        result.put("pageSize", pageSize);
        result.put("list", list);
        return result;
    }

    @Override
    public ShopProduct getProduct(String id) {
        ShopProduct p = productMapper.selectById(id);
        if (p == null) {
            throw new BusinessException(404, "商品不存在: " + id);
        }
        return p;
    }

    @Override
    public ShopProduct saveProduct(ShopProduct product) {
        if (product == null || !StringUtils.hasText(product.getName())) {
            throw new BusinessException(400, "商品名称不能为空");
        }
        Date now = new Date();
        if (!StringUtils.hasText(product.getId())) {
            // 新增
            product.setId(uuid());
            if (product.getPrice() == null) product.setPrice(BigDecimal.ZERO);
            if (product.getStock() == null) product.setStock(0);
            if (product.getStatus() == null) product.setStatus(1);
            product.setCreateTime(now);
            product.setUpdateTime(now);
            productMapper.insert(product);
        } else {
            // 修改
            ShopProduct exist = productMapper.selectById(product.getId());
            if (exist == null) {
                throw new BusinessException(404, "商品不存在: " + product.getId());
            }
            product.setUpdateTime(now);
            productMapper.updateSelective(product);
        }
        return productMapper.selectById(product.getId());
    }

    @Override
    public void updateStatus(String id, Integer status) {
        if (status == null || (status != 0 && status != 1)) {
            throw new BusinessException(400, "状态只能为 0(下架) 或 1(上架)");
        }
        ShopProduct upd = new ShopProduct();
        upd.setId(id);
        upd.setStatus(status);
        upd.setUpdateTime(new Date());
        if (productMapper.updateSelective(upd) == 0) {
            throw new BusinessException(404, "商品不存在: " + id);
        }
    }

    @Override
    public void deleteProduct(String id) {
        if (productMapper.deleteById(id) == 0) {
            throw new BusinessException(404, "商品不存在: " + id);
        }
    }

    private String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
