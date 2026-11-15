package com.jcd.controller.shop;

import com.jcd.dto.shop.ShopLoginDto;
import com.jcd.dto.shop.ShopRegisterDto;
import com.jcd.exception.BusinessException;
import com.jcd.model.shop.ShopUser;
import com.jcd.service.shop.ShopUserService;
import com.jcd.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 电商登录 / 注册。
 *
 * 路径保持 /api/auth/login 不变, 响应结构 {code, message, data:{token, user}} 也和原来
 * 查 USERPROFILE 的 LoginServerController 逐字段一致 —— PDA、shop.html、Postman 集合都在调这个
 * 地址, 换实现不能顺带改契约。
 */
@RestController
@RequestMapping("/api/auth")
public class ShopAuthController {

    @Autowired private ShopUserService userService;

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> loginRequest) {
        Map<String, Object> response = new HashMap<>();
        try {
            ShopLoginDto dto = new ShopLoginDto();
            dto.setUsername(loginRequest == null ? null : loginRequest.get("username"));
            dto.setPassword(loginRequest == null ? null : loginRequest.get("password"));

            response.put("code", 200);
            response.put("message", "登录成功");
            response.put("data", userService.login(dto));
            return ResponseEntity.ok(response);
        } catch (BusinessException e) {
            response.put("code", e.getCode());
            response.put("message", e.getMessage());
            response.put("data", null);
            return ResponseEntity.status(httpStatus(e.getCode())).body(response);
        } catch (Exception e) {
            response.put("code", 500);
            response.put("message", "登录失败：" + e.getMessage());
            response.put("data", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    /**
     * 自助注册。默认角色是"客户", 拿不到后台管理入口。
     * 这个接口在 MyWebConfigurer 里是放行的(无 Token), 所以不能被用来提权。
     */
    @PostMapping("/register")
    public Result<?> register(@RequestBody ShopRegisterDto dto) {
        try {
            ShopUser user = userService.register(dto);
            Map<String, Object> data = new HashMap<>();
            data.put("username", user.getUsername());
            data.put("nickname", user.getNickname());
            return Result.success(data);
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("注册失败：" + e.getMessage());
        }
    }

    /** BusinessException 的 code 直接当 HTTP 状态用, 不是合法 HTTP 码时退回 500 */
    private HttpStatus httpStatus(int code) {
        HttpStatus status = HttpStatus.resolve(code);
        return status == null ? HttpStatus.INTERNAL_SERVER_ERROR : status;
    }
}
