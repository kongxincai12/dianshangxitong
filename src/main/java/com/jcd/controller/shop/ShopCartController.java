package com.jcd.controller.shop;

import com.jcd.exception.BusinessException;
import com.jcd.service.shop.ShopCartService;
import com.jcd.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 电商-购物车
 */
@RestController
@RequestMapping("/api/shop/cart")
public class ShopCartController {

    @Autowired private ShopCartService cartService;

    @GetMapping
    public Result<?> list(HttpServletRequest request) {
        try {
            return Result.success(cartService.listCart(userId(request)));
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("查询购物车失败: " + e.getMessage());
        }
    }

    @PostMapping
    public Result<?> add(@RequestBody Map<String, Object> body, HttpServletRequest request) {
        try {
            String productId = body == null ? null : str(body.get("productId"));
            Integer quantity = body == null ? null : toInt(body.get("quantity"));
            return Result.success(cartService.addItem(userId(request), productId, quantity));
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("加入购物车失败: " + e.getMessage());
        }
    }

    @PutMapping("/{cartId}")
    public Result<?> updateQty(@PathVariable String cartId,
                               @RequestBody Map<String, Object> body,
                               HttpServletRequest request) {
        try {
            Integer quantity = body == null ? null : toInt(body.get("quantity"));
            cartService.updateQuantity(userId(request), cartId, quantity);
            return Result.success(null);
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("修改数量失败: " + e.getMessage());
        }
    }

    @DeleteMapping("/{cartId}")
    public Result<?> remove(@PathVariable String cartId, HttpServletRequest request) {
        try {
            cartService.removeItem(userId(request), cartId);
            return Result.success(null);
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("移除失败: " + e.getMessage());
        }
    }

    @DeleteMapping
    public Result<?> clear(HttpServletRequest request) {
        try {
            cartService.clear(userId(request));
            return Result.success(null);
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("清空购物车失败: " + e.getMessage());
        }
    }

    /* ---------------- helper ---------------- */

    private String userId(HttpServletRequest request) {
        String id = (String) request.getAttribute("current_employee_id");
        if (id == null || id.isEmpty()) {
            throw new BusinessException(401, "未登录或登录已过期");
        }
        return id;
    }

    private String str(Object o) { return o == null ? null : String.valueOf(o); }

    private Integer toInt(Object o) {
        if (o == null) return null;
        if (o instanceof Number) return ((Number) o).intValue();
        try { return Integer.parseInt(String.valueOf(o)); } catch (Exception e) { return null; }
    }
}
