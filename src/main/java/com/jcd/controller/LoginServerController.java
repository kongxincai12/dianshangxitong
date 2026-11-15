package com.jcd.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcd.dto.AppVersionDto;
import com.jcd.dto.Hrdetail;
import com.jcd.dto.UserPermissionInfoDto;
import com.jcd.model.Prp_lot;
import com.jcd.model.Userprofile;

import com.jcd.service.MesService;
import com.jcd.service.UserprofileService;
import com.jcd.utils.JwtUtils;
import com.jcd.utils.Result;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.security.Principal;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 1. 【路径建议】建议将 Controller 的总路径与前端 api.js 中的 BASE_URL 对齐。
//    前端使用的是 /api，所以这里最好也用 /api。
//    例如 @RequestMapping("/api/auth")
@RestController
@RequestMapping("/api/auth") // 将路径修改为 /api/auth 以匹配前端
public class LoginServerController {

    @Autowired
    private UserprofileService us;


    @Autowired
    private JwtUtils jwtUtils;

    @Autowired
    private MesService mesService;

    /**
     * 获取当前登录用户的批次检测模块权限
     * 前端应在主系统登录成功后调用此接口
     * @return 包含用户角色和站点权限的 DTO
     */

    /**
     * 登录接口
     * @param loginRequest 包含 userid 和 password 的 Map
     * @return 符合前端期望的 ResponseEntity
     */
    @PostMapping("/login")
    // 2. 【代码风格优化】使用 ResponseEntity<Map<String, Object>> 作为返回类型。
    //    这是现代 Spring Boot 的标准做法，可以自动将 Map 转换为 JSON，无需手动操作 HttpServletResponse。
    public ResponseEntity<Map<String, Object>> login(@RequestBody Map<String, String> loginRequest) {

        // 3. 【创建标准响应结构】始终创建一个 Map 来存放 code, message, data
        Map<String, Object> response = new HashMap<>();
        String userid = loginRequest.get("username");
        // 注意：前端发送的是明文密码，后端接收后再加密比对
        String password = loginRequest.get("password");

        if (userid == null || password == null) {
            response.put("code", 400); // Bad Request
            response.put("message", "用户名和密码不能为空");
            response.put("data", null);
            return ResponseEntity.badRequest().body(response);
        }

        String encryptedPassword = us.GetMd5Str(password);
        List<Userprofile> userprofiles = us.UserprofileGetByUserNameAndPassword(userid, encryptedPassword);

        if (userprofiles != null && !userprofiles.isEmpty()) {
            // --- 登录成功 ---
            Userprofile user = userprofiles.get(0);

            // 4. 【构建 data 对象】创建一个 Map 来存放所有业务数据
            final String token = jwtUtils.generateToken(user.getUsername(), user.getUserposition());

            // 构建返回给前端的数据结构
            Map<String, Object> data = new HashMap<>();
            Map<String, Object> userDetails = new HashMap<>();
            userDetails.put("username", user.getUsername());
            userDetails.put("fullname", user.getFullname());
            // 注意：您之前的代码里有两个 "username"，这里修正一下
            userDetails.put("userposition", user.getUserposition());



            // 将 user 对象和 token 放入 data 中
            data.put("user", userDetails);
            data.put("token", token);

            // 7. 【组装成功响应】将 data 放入最终的 response
            response.put("code", 200);
            response.put("message", "登录成功");
            response.put("data", data);

            return ResponseEntity.ok(response);

        } else {
            // --- 登录失败 ---
            // 8. 【组装失败响应】保持与成功时一致的结构
            response.put("code", 401); // 401 Unauthorized 更适合表示认证失败
            response.put("message", "登录失败！账号或密码错误！");
            response.put("data", null);

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }

    @PostMapping("/mes/check")
    // 2. 【代码风格优化】使用 ResponseEntity<Map<String, Object>> 作为返回类型。
    //    这是现代 Spring Boot 的标准做法，可以自动将 Map 转换为 JSON，无需手动操作 HttpServletResponse。
    public ResponseEntity<Map<String, Object>> check(@RequestBody Map<String, String> loginRequest) {



        // 3. 【创建标准响应结构】始终创建一个 Map 来存放 code, message, data
        Map<String, Object> response = new HashMap<>();
        String rawInput = loginRequest.get("employeeId");

        String userid = loginRequest.get("employeeId");
        // 注意：前端发送的是明文密码，后端接收后再加密比对
        //String password = loginRequest.get("password");

        if (rawInput == null || rawInput.trim().isEmpty()) {
            response.put("code", 400); // Bad Request
            response.put("message", "工号不能为空");
            response.put("data", null);
            return ResponseEntity.badRequest().body(response);
        }
        String finalEmployeeId;
        try {
            finalEmployeeId = resolveEmployeeId(rawInput);
        } catch (Exception e) {
            // 如果解析 JWT 失败（例如伪造的二维码），视为无效请求
            response.put("code", 401);
            response.put("message", "无效的二维码或工号格式");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }


        //Hrdetail userprofile  = us.selectByHrDetail(finalEmployeeId);

        /*if (userprofile != null ) {
            // --- 登录成功 ---


            // 4. 【构建 data 对象】创建一个 Map 来存放所有业务数据
            final String token = jwtUtils.generateToken(userprofile.getEmployeeId(), userprofile.getSite());

            // 构建返回给前端的数据结构
            Map<String, Object> data = new HashMap<>();
            Map<String, Object> userDetails = new HashMap<>();
            userDetails.put("employeeId", userprofile.getEmployeeId());
            userDetails.put("employeeName", userprofile.getEmployeeName());
            String site = userprofile.getSite();
            if(site.contains("项目"))
                site+=".工艺参数维护";

            userDetails.put("site", site);

            // 将 user 对象和 token 放入 data 中
            data.put("employeeInfo", userDetails);
            data.put("token", token);*/

            // 构建返回给前端的数据结构
            final String token = jwtUtils.generateToken(rawInput,"SZMES工厂");
            Map<String, Object> data = new HashMap<>();
            Map<String, Object> userDetails = new HashMap<>();
            userDetails.put("employeeId", rawInput);
            userDetails.put("employeeName",rawInput);
            userDetails.put("site", "SZMES工厂");
            data.put("employeeInfo", userDetails);
            data.put("token", token);

            // 7. 【组装成功响应】将 data 放入最终的 response
            response.put("code", 200);
            response.put("message", "登录成功");
            response.put("data", data);

            return ResponseEntity.ok(response);

        /*} else {
            // --- 登录失败 ---
            // 8. 【组装失败响应】保持与成功时一致的结构
            response.put("code", 401); // 401 Unauthorized 更适合表示认证失败
            response.put("message", "登录失败！账号或密码错误！");
            response.put("data", null);

            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }*/
    }

    @GetMapping("/latest-version")
    public ResponseEntity<Map<String, Object>> getLatestVersion() {
        // --- 在这里定义您App的最新版本信息 ---
        // TODO: 未来可以从数据库或配置文件动态获取
        String latestVersion = "1.0.1";
        String downloadUrl = "http://10.10.100.208:9999/PDA/jcd-qcm-100.apk"; // 替换为您的真实APK或wgt包下载地址
        String updateNotes = "1. 优化了登录体验。\n2. 修复了一些已知问题。";
        // ------------------------------------

        AppVersionDto versionDto = new AppVersionDto(latestVersion, downloadUrl, updateNotes);

        // 使用一个通用的Map结构返回，与您现有的API格式保持一致
        Map<String, Object> response = new HashMap<>();
        response.put("code", 200);
        response.put("message", "获取成功");
        response.put("data", versionDto);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/insp/permissions")
    public Result<UserPermissionInfoDto> getCurrentUserPermissions(HttpServletRequest request) { // 【新增】注入HttpServletRequest

        // 1. 从request的Attribute中，获取拦截器存入的工号
        Object employeeIdObj = request.getAttribute("current_employee_id");

        if (employeeIdObj == null) {
            // 如果获取不到，说明拦截器逻辑有问题或请求未被拦截，返回无权限
            return Result.success(null);
        }

        String employeeId = (String) employeeIdObj;

        // 2. 使用安全获取的工号，去查询权限
        UserPermissionInfoDto permissionInfo = mesService.getUserPermissions(employeeId);

        return Result.success(permissionInfo);
    }




    /**
     * 智能解析方法
     * 兼容：
     * 1. 新版 JWT (key = "i")
     * 2. 旧版 JWT (key = "employee_id")
     * 3. 普通明文工号
     */
    private String resolveEmployeeId(String input) {
        // 1. 基础特征检查
        if (input == null || !input.contains(".") || !input.startsWith("ey")) {
            return input; // 不是 JWT，直接按普通工号处理
        }

        try {
            // --- 第一步：手动验证签名 (绕过 JJWT 的长度检查) ---

            // 拆分 JWT: Header.Payload.Signature
            String[] parts = input.split("\\.");
            if (parts.length != 3) {
                return input; // 格式不对，按普通工号处理
            }

            String content = parts[0] + "." + parts[1]; // 签名的原始内容
            String providedSignature = parts[2];        // 前端传来的签名

            // 你的短密钥
            String secretKeyString = "MyFactory_SecretKey_@2025!";
            byte[] keyBytes = secretKeyString.getBytes(StandardCharsets.UTF_8);

            // 使用 Java 原生 Mac 计算签名
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(keyBytes, "HmacSHA256");
            sha256_HMAC.init(secret_key);

            byte[] signatureBytes = sha256_HMAC.doFinal(content.getBytes(StandardCharsets.US_ASCII));

            // 将二进制签名转为 Base64URL 字符串 (注意：必须是 URL 安全且无 Padding)
            String calculatedSignature = Base64.getUrlEncoder().withoutPadding().encodeToString(signatureBytes);

            // 比对签名 (如果不一致，说明数据被篡改或密钥不对)
            if (!calculatedSignature.equals(providedSignature)) {
                System.err.println("JWT Signature mismatch! (Manual verification)");
                throw new RuntimeException("Invalid QR Code Token");
            }

            // --- 第二步：手动解码 Payload 获取数据 ---

            // Payload 是第二部分
            String payloadJson = new String(Base64.getUrlDecoder().decode(parts[1]), StandardCharsets.UTF_8);

            // 使用 Jackson 解析 JSON (Spring Boot 自带)
            ObjectMapper mapper = new ObjectMapper();
            Map<String, Object> claims = mapper.readValue(payloadJson, Map.class);

            // --- 第三步：兼容旧字段 ---

            // 尝试取 'i'
            Object iVal = claims.get("i");
            if (iVal != null && !"".equals(iVal.toString())) {
                return iVal.toString();
            }

            // 尝试取 'employee_id'
            Object empVal = claims.get("employee_id");
            if (empVal != null && !"".equals(empVal.toString())) {
                return empVal.toString();
            }

            throw new RuntimeException("JWT valid but no ID found");

        } catch (Exception e) {
            System.err.println("Token resolve failed: " + e.getMessage());
            // 如果解析出错（比如签名不对），这可能不是一个 Token，或者是一个伪造的
            // 这里抛出异常，让外层 Controller 捕获并返回 401
            throw new RuntimeException("Invalid Token");
        }
    }
}
