package com.jcd.service.shop.impl;

import com.jcd.dto.shop.ShopLoginDto;
import com.jcd.dto.shop.ShopRegisterDto;
import com.jcd.exception.BusinessException;
import com.jcd.mapper.shop.ShopUserMapper;
import com.jcd.model.shop.ShopUser;
import com.jcd.service.shop.ShopUserService;
import com.jcd.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.security.MessageDigest;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 电商客户账号服务实现。
 *
 * 商城从 MES 剥离后不再查 USERPROFILE, 账号全部存在 SHOP_USER。
 * 密码摘要算法刻意与 MES 的 UserServiceImpl.GetMd5Str 保持一致
 * (md5(md5(明文) + 明文前5位)), 这样老账号的摘要可以原样搬过来, 用户不用改密码。
 */
@Service
public class ShopUserServiceImpl implements ShopUserService {

    @Autowired private ShopUserMapper userMapper;
    @Autowired private JwtUtils jwtUtils;

    @Override
    public ShopUser register(ShopRegisterDto dto) {
        if (dto == null || !StringUtils.hasText(dto.getUsername()) || !StringUtils.hasText(dto.getPassword())) {
            throw new BusinessException(400, "用户名和密码不能为空");
        }
        String username = dto.getUsername().trim();
        if (username.length() < 3) {
            throw new BusinessException(400, "用户名至少 3 个字符");
        }
        if (dto.getPassword().length() < 6) {
            throw new BusinessException(400, "密码至少 6 个字符");
        }
        if (userMapper.selectByUsername(username) != null) {
            throw new BusinessException(409, "用户名已存在: " + username);
        }

        Date now = new Date();
        ShopUser user = new ShopUser();
        user.setId(UUID.randomUUID().toString().replace("-", ""));
        user.setUsername(username);
        user.setPassword(getMd5Str(dto.getPassword()));
        user.setNickname(StringUtils.hasText(dto.getNickname()) ? dto.getNickname().trim() : username);
        user.setPhone(dto.getPhone());
        user.setEmail(dto.getEmail());
        // 自助注册的一律是普通客户, 管理员只能由 DBA/配置白名单授予, 不能靠注册拿到
        user.setRole("客户");
        user.setStatus(1);
        user.setCreateTime(now);
        user.setUpdateTime(now);
        userMapper.insert(user);
        return sanitize(user);
    }

    @Override
    public Map<String, Object> login(ShopLoginDto dto) {
        if (dto == null || !StringUtils.hasText(dto.getUsername()) || !StringUtils.hasText(dto.getPassword())) {
            throw new BusinessException(400, "用户名和密码不能为空");
        }
        ShopUser user = userMapper.selectByUsername(dto.getUsername().trim());
        if (user == null || !getMd5Str(dto.getPassword()).equals(user.getPassword())) {
            // 账号不存在和密码错误回同一句话, 避免被人拿这个接口枚举账号
            throw new BusinessException(401, "登录失败！账号或密码错误！");
        }
        if (user.getStatus() != null && user.getStatus() == 0) {
            throw new BusinessException(403, "账号已被禁用，请联系管理员");
        }

        // role claim 不允许为 null, JwtUtils 会直接塞进 claims
        String role = user.getRole() == null ? "" : user.getRole();
        String token = jwtUtils.generateToken(user.getUsername(), role);

        /*
         * 返回结构沿用 MES 登录接口的字段名 fullname / userposition:
         * shop.html 存 data.user 后靠 user.fullname 显示昵称, 换成 nickname 会让顶栏变空白。
         * 改的是数据来源(SHOP_USER), 不改对外的 JSON 结构。
         */
        Map<String, Object> userDetails = new LinkedHashMap<>();
        userDetails.put("username", user.getUsername());
        userDetails.put("fullname", StringUtils.hasText(user.getNickname()) ? user.getNickname() : user.getUsername());
        userDetails.put("userposition", role);
        userDetails.put("phone", user.getPhone());
        userDetails.put("email", user.getEmail());

        Map<String, Object> data = new HashMap<>();
        data.put("user", userDetails);
        data.put("token", token);
        return data;
    }

    @Override
    public ShopUser assertCustomer(String username) {
        if (!StringUtils.hasText(username)) {
            throw new BusinessException(401, "未登录或登录已过期");
        }
        ShopUser user = userMapper.selectByUsername(username);
        if (user == null) {
            throw new BusinessException(401, "账号不存在: " + username);
        }
        if (user.getStatus() != null && user.getStatus() == 0) {
            throw new BusinessException(403, "账号已被禁用，请联系管理员");
        }
        return user;
    }

    /* ================= helpers ================= */

    /** 去掉密码摘要, 返回给前端的用户信息不能带这个 */
    private ShopUser sanitize(ShopUser user) {
        user.setPassword(null);
        return user;
    }

    /**
     * 与 MES UserServiceImpl.GetMd5Str 完全一致: md5(md5(明文) + 明文前 min(len,5) 位)
     */
    static String getMd5Str(String password) {
        int length = Math.min(password.length(), 5);
        return makeMD5(makeMD5(password) + password.substring(0, length));
    }

    /** 小写十六进制, 不足两位补 0 —— 少补这个 0 会让摘要对不上, 老账号全登不进去 */
    private static String makeMD5(String text) {
        try {
            StringBuilder pwd = new StringBuilder();
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(text.getBytes("UTF-8"));
            for (byte b : digest) {
                int v = b & 0xFF;
                String hv = Integer.toHexString(v);
                if (hv.length() < 2) {
                    pwd.append(0);
                }
                pwd.append(hv);
            }
            return pwd.toString();
        } catch (Exception e) {
            throw new BusinessException(500, "密码加密失败: " + e.getMessage());
        }
    }
}
