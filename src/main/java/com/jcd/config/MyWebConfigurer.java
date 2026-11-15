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

    // 这是新增的拦截器配置
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jwtInterceptor)
                // 1. addPathPatterns: 指定要拦截的路径
                .addPathPatterns("/api/**") // 拦截所有 /api/ 开头的请求
                // 2. excludePathPatterns: 指定要放行的路径
                .excludePathPatterns("/api/auth/latest-version")// 放行更新版本接口
                .excludePathPatterns("/api/mes/latest-version")// 放行更新版本接口
                .excludePathPatterns("/api/auth/login")// 放行登录接口，否则无法获取Token
                .excludePathPatterns("/api/auth/mes/check")
                .excludePathPatterns("/api/system/factory")// 放行厂区身份核验接口
                .excludePathPatterns("/api/materialcheck/**")
                .excludePathPatterns("/api/upload/**")
                .excludePathPatterns("/api/shelf/**")
                .excludePathPatterns("/api/alipay/notify")// 放行支付宝异步通知回调
                .excludePathPatterns("/api/alipay/return")// 放行支付宝同步跳转回调
                .excludePathPatterns("/api/alipay/**")// 放行支付宝支付相关接口

        ;
    }
}
