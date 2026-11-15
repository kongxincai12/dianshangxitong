package com.jcd.utils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Component
public class JwtUtils {

    // 1. 【修改点】不再直接初始化密钥，而是声明一个实例变量
    private Key secretKey;

    // 2. 【修改点】声明一个变量来接收来自配置文件的密钥字符串
    @Value("${jwt.secret}")
    private String secretString;

    // 3. 【修改点】使用 @PostConstruct 注解，在依赖注入完成后，根据配置的字符串来初始化密钥
    //    这样做的好处是，既能从配置文件读取，又能保持其他方法的简洁性。
    @PostConstruct
    public void init() {
        // 将 Base64 编码的密钥字符串解码成字节数组
        byte[] keyBytes = Decoders.BASE64.decode(secretString);
        // 根据字节数组生成一个安全的密钥对象
        this.secretKey = Keys.hmacShaKeyFor(keyBytes);
    }

    // 2. 【过期时间】Token的有效时间（毫秒）。这里设置为24小时。
    private static final long EXPIRATION_TIME = 24 * 60 * 60 * 1000; // 24 hours

    public String generateToken(String userid, String role) {
        Map<String, Object> claims = new HashMap<>();
        // 将角色信息作为一个自定义声明放入，键为 "role"
        claims.put("role", role);
        return createToken(claims, userid);
    }

    /**
     * 根据用户ID生成JWT Token
     * @param userid 用户ID
     * @return 生成的Token字符串
     */
    public String generateToken(String userid) {
        Map<String, Object> claims = new HashMap<>();
        // 您可以在 claims 中存放任何想包含在Token中的非敏感信息
        return createToken(claims, userid);
    }

    /**
     * 核心的Token创建方法
     * @param claims 额外信息
     * @param subject 通常是用户的唯一标识（如用户ID）
     * @return Token字符串
     */
    private String createToken(Map<String, Object> claims, String subject) {
        return Jwts.builder()
                .setClaims(claims) // 设置自定义声明
                .setSubject(subject) // 设置主题，可以是用户名、用户ID等
                .setIssuedAt(new Date(System.currentTimeMillis())) // 设置签发时间
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // 设置过期时间
                .signWith(secretKey, SignatureAlgorithm.HS256) // 4. 【修改点】使用实例变量 secretKey
                .compact();
    }



    // --- 以下方法用于验证和解析Token，在后续的请求拦截器中会用到 ---

    /**
     * 从Token中解析出用户ID
     * @param token JWT Token
     * @return 用户ID
     */
    public String extractUserid(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    public String extractRole(String token) {
        return extractClaim(token, claims -> (String) claims.get("role"));
    }
    /**
     * 验证Token是否有效
     * @param token Token
     * @param userid 用于验证的用户ID
     * @return 如果有效返回true，否则返回false
     */
    public Boolean validateToken(String token, String userid) {
        final String extractedUserid = extractUserid(token);
        return (extractedUserid.equals(userid) && !isTokenExpired(token));
    }

    /**
     * 检查Token是否已过期
     * @param token Token
     * @return 如果已过期返回true
     */
    public Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    /**
     * 从Token中解析出过期时间
     * @param token Token
     * @return 过期时间
     */
    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * 通用的从Token中解析声明(Claim)的方法
     * @param token Token
     * @param claimsResolver 解析函数
     * @return 声明的值
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * 解析出Token中的所有声明
     * @param token Token
     * @return 所有声明
     */
    public Claims extractAllClaims(String token) {
        // 5. 【修改点】使用实例变量 secretKey
        return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody();
    }
}
