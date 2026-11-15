package com.jcd.controller.shop;

import com.jcd.exception.BusinessException;
import com.jcd.model.shop.ShopAddress;
import com.jcd.service.shop.ShopAddressService;
import com.jcd.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 电商-收货地址簿
 * 属于个人数据, 所有登录用户都可以维护"自己的"地址, 因此不需要管理员权限;
 * 越权由 SQL 里的 USER_ID 条件和 Service 里的归属校验兜住。
 */
@RestController
@RequestMapping("/api/shop/addresses")
public class ShopAddressController {

    @Autowired private ShopAddressService addressService;

    @GetMapping
    public Result<?> list(HttpServletRequest request) {
        try {
            return Result.success(addressService.list(userId(request)));
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("查询收货地址失败: " + e.getMessage());
        }
    }

    /** 新增, body 不带 id */
    @PostMapping
    public Result<?> create(@RequestBody ShopAddress address, HttpServletRequest request) {
        try {
            return Result.success(addressService.save(userId(request), address));
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("保存收货地址失败: " + e.getMessage());
        }
    }

    /** 修改, 以路径上的 id 为准, 不认 body 里可能的他人 id */
    @PutMapping("/{id}")
    public Result<?> update(@PathVariable String id, @RequestBody ShopAddress address, HttpServletRequest request) {
        try {
            if (address != null) {
                address.setId(id);
            }
            return Result.success(addressService.save(userId(request), address));
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("修改收货地址失败: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable String id, HttpServletRequest request) {
        try {
            addressService.delete(userId(request), id);
            return Result.success(null);
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("删除收货地址失败: " + e.getMessage());
        }
    }

    /** 设为默认收货地址 */
    @PostMapping("/{id}/default")
    public Result<?> setDefault(@PathVariable String id, HttpServletRequest request) {
        try {
            addressService.setDefault(userId(request), id);
            return Result.success(null);
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("设置默认地址失败: " + e.getMessage());
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
