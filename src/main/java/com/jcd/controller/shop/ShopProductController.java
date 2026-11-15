package com.jcd.controller.shop;

import com.jcd.config.ShopAdminGuard;
import com.jcd.exception.BusinessException;
import com.jcd.model.shop.ShopCategory;
import com.jcd.model.shop.ShopProduct;
import com.jcd.service.shop.ShopProductService;
import com.jcd.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 电商-商品/分类
 *
 * 读接口对所有登录用户开放 (商品页需要); 写接口是后台管理功能, 必须先过 ShopAdminGuard,
 * 否则买家只要不点菜单、直接调接口就能改商品和价格。
 */
@RestController
@RequestMapping("/api/shop")
public class ShopProductController {

    @Autowired private ShopProductService productService;
    @Autowired private ShopAdminGuard adminGuard;

    /* ---------------- 当前身份 ---------------- */

    /**
     * 前端据此决定是否显示"后台管理"入口。
     * 判定只认 Token 里的信息, 不认前端传的任何参数。
     */
    @GetMapping("/profile")
    public Result<?> profile(HttpServletRequest request) {
        Map<String, Object> data = new HashMap<>();
        data.put("username", request.getAttribute(ShopAdminGuard.ATTR_USERNAME));
        data.put("userposition", request.getAttribute(ShopAdminGuard.ATTR_ROLE));
        data.put("admin", adminGuard.isAdmin(request));
        return Result.success(data);
    }

    /* ---------------- 分类 ---------------- */

    @GetMapping("/categories")
    public Result<?> categories() {
        try {
            return Result.success(productService.listCategories());
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("查询分类失败: " + e.getMessage());
        }
    }

    @PostMapping("/categories")
    public Result<?> addCategory(@RequestBody ShopCategory category, HttpServletRequest request) {
        if (!adminGuard.isAdmin(request)) {
            return Result.error(403, adminGuard.denyMessage());
        }
        try {
            return Result.success(productService.addCategory(category));
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("新增分类失败: " + e.getMessage());
        }
    }

    /* ---------------- 商品 ---------------- */

    @GetMapping("/products")
    public Result<?> products(@RequestParam(required = false) String name,
                              @RequestParam(required = false) String categoryId,
                              @RequestParam(required = false) Integer status,
                              @RequestParam(required = false, defaultValue = "1") int pageNo,
                              @RequestParam(required = false, defaultValue = "20") int pageSize) {
        try {
            return Result.success(productService.queryProducts(name, categoryId, status, pageNo, pageSize));
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("查询商品失败: " + e.getMessage());
        }
    }

    @GetMapping("/products/{id}")
    public Result<?> product(@PathVariable String id) {
        try {
            return Result.success(productService.getProduct(id));
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("查询商品详情失败: " + e.getMessage());
        }
    }

    @PostMapping("/products")
    public Result<?> save(@RequestBody ShopProduct product, HttpServletRequest request) {
        if (!adminGuard.isAdmin(request)) {
            return Result.error(403, adminGuard.denyMessage());
        }
        try {
            return Result.success(productService.saveProduct(product));
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("保存商品失败: " + e.getMessage());
        }
    }

    @PostMapping("/products/{id}/status")
    public Result<?> updateStatus(@PathVariable String id, @RequestParam Integer status,
                                  HttpServletRequest request) {
        if (!adminGuard.isAdmin(request)) {
            return Result.error(403, adminGuard.denyMessage());
        }
        try {
            productService.updateStatus(id, status);
            return Result.success(null);
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("更新商品状态失败: " + e.getMessage());
        }
    }

    @DeleteMapping("/products/{id}")
    public Result<?> delete(@PathVariable String id, HttpServletRequest request) {
        if (!adminGuard.isAdmin(request)) {
            return Result.error(403, adminGuard.denyMessage());
        }
        try {
            productService.deleteProduct(id);
            return Result.success(null);
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("删除商品失败: " + e.getMessage());
        }
    }
}
