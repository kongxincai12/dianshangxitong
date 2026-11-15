package com.jcd.service;

import com.jcd.dto.*;
import com.jcd.model.PaymentOrder;

import java.util.Map;

/**
 * 支付宝支付服务接口
 */
public interface AlipayService {

    /**
     * 创建支付订单并生成支付宝支付表单
     * @param requestDto 支付请求参数
     * @return 支付响应 (包含支付表单/链接)
     */
    AlipayPayResponseDto createPayOrder(AlipayPayRequestDto requestDto);

    /**
     * 处理支付宝异步通知
     * @param params 支付宝回调参数
     * @return 处理结果
     */
    String handleNotify(Map<String, String> params);

    /**
     * 查询订单状态
     * @param outTradeNo 商户订单号
     * @return 订单信息
     */
    PaymentOrder queryOrder(String outTradeNo);

    /**
     * 主动查询支付宝交易状态
     * @param requestDto 查询请求参数
     * @return 交易信息
     */
    Map<String, String> queryTradeStatus(AlipayQueryRequestDto requestDto);

    /**
     * 申请退款
     * @param requestDto 退款请求参数
     * @return 退款结果
     */
    Map<String, String> refund(AlipayRefundRequestDto requestDto);

    /**
     * 关闭订单 (取消未支付的订单)
     * @param outTradeNo 商户订单号
     * @return 关闭结果
     */
    Map<String, String> closeOrder(String outTradeNo);
}
