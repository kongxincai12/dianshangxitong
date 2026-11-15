package com.jcd.config;

import com.alibaba.fastjson.JSONObject;
import com.jcd.utils.JwtUtils;
import io.jsonwebtoken.Claims; // 【新增】引入Claims
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtUtils jwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            return true;
        }

        final String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            sendErrorResponse(response, 401, "认证失败：缺少或无效的Token");
            return false;
        }

        final String token = authHeader.substring(7);

        try {
            // 【核心改造#1】不再仅仅校验是否过期，而是直接解析出Claims
            Claims claims = jwtUtils.extractAllClaims(token); // 假设您的JwtUtils有这个方法

            // 从Claims中获取工号 (通常是'subject')
            String employeeId = claims.getSubject();

            if (employeeId == null) {
                sendErrorResponse(response, 401, "认证失败：Token中缺少用户信息");
                return false;
            }

            // 【核心改造#2】将解析出的工号，存入request的Attribute中
            // 这样，后续的Controller就可以通过 request.getAttribute("employeeId") 来获取
            request.setAttribute("current_employee_id", employeeId);


        } catch (ExpiredJwtException e) {
            sendErrorResponse(response, 401, "认证失败：Token已过期");
            return false;
        } catch (SignatureException e) {
            sendErrorResponse(response, 401, "认证失败：Token签名无效");
            return false;
        } catch (Exception e) {
            sendErrorResponse(response, 401, "认证失败：无效的Token");
            return false;
        }

        return true;
    }

    private void sendErrorResponse(HttpServletResponse httpResponse, int code, String message) throws Exception {
        httpResponse.setStatus(code);
        httpResponse.setContentType("application/json;charset=UTF-8");

        Map<String, Object> responseMap = new HashMap<>();
        responseMap.put("code", code);
        responseMap.put("message", message);
        responseMap.put("data", null);

        httpResponse.getWriter().write(new JSONObject(responseMap).toJSONString());
    }
}
