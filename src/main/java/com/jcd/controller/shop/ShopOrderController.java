package com.jcd.controller.shop;

import com.jcd.dto.shop.CheckoutDto;
import com.jcd.exception.BusinessException;
import com.jcd.service.shop.ShopOrderService;
import com.jcd.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 电商-订单
 */
@RestController
@RequestMapping("/api/shop/orders")
public class ShopOrderController {

    @Autowired private ShopOrderService orderService;

    /** 结算下单 */
    @PostMapping("/checkout")
    public Result<?> checkout(@RequestBody CheckoutDto dto, HttpServletRequest request) {
        try {
            return Result.success(orderService.checkout(userId(request), dto));
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("下单失败: " + e.getMessage());
        }
    }

    /** 支付 */
    @PostMapping("/{id}/pay")
    public Result<?> pay(@PathVariable String id, HttpServletRequest request) {
        try {
            orderService.pay(userId(request), id);
            return Result.success(null);
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("支付失败: " + e.getMessage());
        }
    }

    /** 取消 */
    @PostMapping("/{id}/cancel")
    public Result<?> cancel(@PathVariable String id, HttpServletRequest request) {
        try {
            orderService.cancel(userId(request), id);
            return Result.success(null);
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("取消失败: " + e.getMessage());
        }
    }

    /** 详情 */
    @GetMapping("/{id}")
    public Result<?> detail(@PathVariable String id, HttpServletRequest request) {
        try {
            return Result.success(orderService.detail(userId(request), id));
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("查询详情失败: " + e.getMessage());
        }
    }

    /** 我的订单列表 */
    @GetMapping
    public Result<?> list(@RequestParam(required = false) String status,
                          @RequestParam(required = false, defaultValue = "1") int pageNo,
                          @RequestParam(required = false, defaultValue = "20") int pageSize,
                          HttpServletRequest request) {
        try {
            return Result.success(orderService.queryOrders(userId(request), status, pageNo, pageSize));
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("查询订单失败: " + e.getMessage());
        }
    }

    private String userId(HttpServletRequest request) {
        String id = (String) request.getAttribute("current_employee_id");
        if (id == null || id.isEmpty()) {
            throw new BusinessException(401, "未登录或登录已过期");
        }
        return id;
    }
}
