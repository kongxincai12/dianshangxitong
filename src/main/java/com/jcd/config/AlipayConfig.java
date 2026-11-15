package com.jcd.config;

import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 支付宝支付配置类
 * 读取 application-*.properties 中以 alipay. 为前缀的配置项
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "alipay")
public class AlipayConfig {

    /** 应用ID (在支付宝开放平台创建应用后获得) */
    private String appId;

    /** 商户私钥 (PKCS8格式) */
    private String merchantPrivateKey;

    /** 支付宝公钥 (在支付宝开放平台设置后获得) */
    private String alipayPublicKey;

    /** 支付宝网关地址 */
    private String gatewayUrl;

    /** 签名类型 (RSA2) */
    private String signType;

    /** 异步通知回调地址 */
    private String notifyUrl;

    /** 页面跳转同步通知地址 */
    private String returnUrl;

    /**
     * 初始化 AlipayClient
     * AlipayClient 是线程安全的，全局只需创建一个实例
     */
    @Bean
    public AlipayClient alipayClient() {
        return new DefaultAlipayClient(
                gatewayUrl,
                appId,
                merchantPrivateKey,
                "json",
                "UTF-8",
                alipayPublicKey,
                signType
        );
    }
}
