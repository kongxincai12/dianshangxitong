package com.jcd.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootConfiguration
public class MyWebConfigurer implements WebMvcConfigurer {

    // 注入JWT拦截器
    @Autowired
    private JwtInterceptor jwtInterceptor;

    /**
     * 使用 CorsFilter（Filter层级）替代 addCorsMappings（Interceptor层级），
     * 确保即使 JwtInterceptor 返回401，CORS头也能正确添加到响应中。
     * 解决 H5 浏览器访问时 CORS 报错的问题。
     */
    @Bean
    @Order(Ordered.HIGHEST_PRECEDENCE)
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOriginPattern("*");
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        config.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    // JWT 拦截器: 除下面列出的公开接口外, /api/** 一律要带 Token
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                .addPathPatterns("/api/**")
                .excludePathPatterns("/api/auth/login")            // 登录接口本身没有 Token
                .excludePathPatterns("/api/auth/register")         // 注册同理, 且注册只能拿到普通客户角色
                .excludePathPatterns("/api/alipay/notify")         // 支付宝异步回调由支付宝服务器发起
                .excludePathPatterns("/api/alipay/return")         // 支付宝同步跳转
                .excludePathPatterns("/api/alipay/**");           // 其余支付宝接口
    }
}
