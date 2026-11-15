package com.jcd.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * 商城后台管理权限判定。
 *
 * 商城登录账号复用 MES 用户表 USERPROFILE，现有数据里 USERPOSITION 全是"工程师"，
 * 并不存在"管理员"职位，所以不能只按职位判：那样连测试账号自己都会被挡在门外。
 * 这里以用户名白名单为主、职位白名单为辅，命中任意一个即视为管理员；
 * 两个白名单都来自配置，以后给人开权限只改配置不改代码。
 */
@Component
public class ShopAdminGuard {

    /** 登录账号，即 JWT subject，由 JwtInterceptor 写入 */
    public static final String ATTR_USERNAME = "current_employee_id";

    /** 角色，即 JWT role claim (USERPROFILE.USERPOSITION)，由 JwtInterceptor 写入 */
    public static final String ATTR_ROLE = "current_user_role";

    private static final String DENY_MESSAGE = "无权限：仅商城管理员可以维护商品与分类";

    @Value("${shop.admin-usernames:}")
    private String adminUsernames;

    @Value("${shop.admin-positions:}")
    private String adminPositions;

    private Set<String> usernameWhitelist = Collections.emptySet();
    private Set<String> positionWhitelist = Collections.emptySet();

    @PostConstruct
    public void init() {
        usernameWhitelist = toLowerCaseSet(adminUsernames);
        positionWhitelist = toLowerCaseSet(adminPositions);
    }

    /** 当前请求是否来自商城管理员 */
    public boolean isAdmin(HttpServletRequest request) {
        return isAdmin(attr(request, ATTR_USERNAME), attr(request, ATTR_ROLE));
    }

    private boolean isAdmin(String username, String role) {
        return matches(usernameWhitelist, username) || matches(positionWhitelist, role);
    }

    /** 拒绝访问时统一提示语 */
    public String denyMessage() {
        return DENY_MESSAGE;
    }

    private static String attr(HttpServletRequest request, String name) {
        Object v = request.getAttribute(name);
        return v == null ? null : String.valueOf(v);
    }

    private static Set<String> toLowerCaseSet(String raw) {
        if (raw == null || raw.trim().isEmpty()) {
            return Collections.emptySet();
        }
        Set<String> set = new HashSet<>();
        for (String part : raw.split(",")) {
            String v = part.trim();
            if (!v.isEmpty()) {
                set.add(v.toLowerCase());
            }
        }
        return set;
    }

    private static boolean matches(Set<String> whitelist, String value) {
        return value != null && !value.trim().isEmpty()
                && whitelist.contains(value.trim().toLowerCase());
    }
}
