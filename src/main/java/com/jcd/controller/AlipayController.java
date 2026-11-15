package com.jcd.controller;

import com.jcd.dto.*;
import com.jcd.model.PaymentOrder;
import com.jcd.service.AlipayService;
import com.jcd.utils.Result;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * 支付宝支付控制器
 * 提供支付、查询、退款、关闭订单等接口
 */
@RestController
@RequestMapping("/api/alipay")
public class AlipayController {

    private static final Logger logger = LoggerFactory.getLogger(AlipayController.class);

    @Autowired
    private AlipayService alipayService;

    /**
     * 创建支付订单
     * 前端调用后获取支付表单, 提交到支付宝完成支付
     *
     * @param requestDto 支付请求参数
     * @return 包含支付表单的响应
     */
    @PostMapping("/pay")
    public Result<AlipayPayResponseDto> createPayOrder(@RequestBody AlipayPayRequestDto requestDto) {
        logger.info("创建支付订单, subject={}, amount={}", requestDto.getSubject(), requestDto.getTotalAmount());
        AlipayPayResponseDto response = alipayService.createPayOrder(requestDto);
        return Result.success(response);
    }

    /**
     * 支付宝异步通知回调
     * 支付宝支付成功后会主动调用此接口通知商户
     *
     * @param request HTTP请求
     * @return "success" 或 "failure"
     */
    @PostMapping("/notify")
    public String handleNotify(HttpServletRequest request) {
        logger.info("收到支付宝异步通知");

        // 将请求参数转换为Map
        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : requestParams.entrySet()) {
            String[] values = entry.getValue();
            StringBuilder valueStr = new StringBuilder();
            for (int i = 0; i < values.length; i++) {
                if (i > 0) {
                    valueStr.append(",");
                }
                valueStr.append(values[i]);
            }
            params.put(entry.getKey(), valueStr.toString());
        }

        logger.info("通知参数: {}", params);
        return alipayService.handleNotify(params);
    }

    /**
     * 查询订单状态 (本地数据库)
     *
     * @param outTradeNo 商户订单号
     * @return 订单信息
     */
    @GetMapping("/query/{outTradeNo}")
    public Result<PaymentOrder> queryOrder(@PathVariable String outTradeNo) {
        logger.info("查询订单, outTradeNo={}", outTradeNo);
        PaymentOrder order = alipayService.queryOrder(outTradeNo);
        if (order == null) {
            return Result.fail("订单不存在");
        }
        return Result.success(order);
    }

    /**
     * 主动查询支付宝交易状态
     * 用于实时获取支付宝端的交易状态
     *
     * @param requestDto 查询请求参数
     * @return 交易状态信息
     */
    @PostMapping("/query/status")
    public Result<Map<String, String>> queryTradeStatus(@RequestBody AlipayQueryRequestDto requestDto) {
        logger.info("查询交易状态, outTradeNo={}", requestDto.getOutTradeNo());
        Map<String, String> result = alipayService.queryTradeStatus(requestDto);
        return Result.success(result);
    }

    /**
     * 申请退款
     *
     * @param requestDto 退款请求参数
     * @return 退款结果
     */
    @PostMapping("/refund")
    public Result<Map<String, String>> refund(@RequestBody AlipayRefundRequestDto requestDto) {
        logger.info("申请退款, outTradeNo={}, amount={}", 
                requestDto.getOutTradeNo(), requestDto.getRefundAmount());
        Map<String, String> result = alipayService.refund(requestDto);
        return Result.success(result);
    }

    /**
     * 关闭订单 (取消未支付的订单)
     *
     * @param outTradeNo 商户订单号
     * @return 关闭结果
     */
    @PostMapping("/close/{outTradeNo}")
    public Result<Map<String, String>> closeOrder(@PathVariable String outTradeNo) {
        logger.info("关闭订单, outTradeNo={}", outTradeNo);
        Map<String, String> result = alipayService.closeOrder(outTradeNo);
        return Result.success(result);
    }

    /**
     * 支付成功同步跳转页面
     * 用户支付完成后, 支付宝会跳转到此页面
     *
     * @return 支付成功页面
     */
    @GetMapping("/return")
    public void payReturn(HttpServletRequest request, HttpServletResponse response) throws IOException {
        logger.info("支付同步回调");

        Map<String, String> params = new HashMap<>();
        Map<String, String[]> requestParams = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : requestParams.entrySet()) {
            String[] values = entry.getValue();
            StringBuilder valueStr = new StringBuilder();
            for (int i = 0; i < values.length; i++) {
                if (i > 0) {
                    valueStr.append(",");
                }
                valueStr.append(values[i]);
            }
            params.put(entry.getKey(), valueStr.toString());
        }

        String outTradeNo = params.get("out_trade_no");
        String tradeNo = params.get("trade_no");
        String totalAmount = params.get("total_amount");

        logger.info("同步回调参数: outTradeNo={}, tradeNo={}", outTradeNo, tradeNo);

        // 从数据库查询实际订单状态
        String orderStatus = "WAIT_PAY";
        String statusText = "等待支付";
        String statusIcon = "&#x23F3;";
        String statusColor = "#fa8c16";

        if (outTradeNo != null) {
            PaymentOrder order = alipayService.queryOrder(outTradeNo);
            if (order != null) {
                orderStatus = order.getOrderStatus();
                if ("PAID".equals(orderStatus)) {
                    statusText = "支付成功";
                    statusIcon = "&#x2705;";
                    statusColor = "#52c41a";
                } else if ("CLOSED".equals(orderStatus)) {
                    statusText = "交易关闭";
                    statusIcon = "&#x274C;";
                    statusColor = "#ff4d4f";
                } else if ("REFUNDED".equals(orderStatus)) {
                    statusText = "已退款";
                    statusIcon = "&#x1F504;";
                    statusColor = "#1677ff";
                }
            }
        }

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html lang='zh-CN'><head><meta charset='UTF-8'><meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>支付结果</title>");
        out.println("<style>");
        out.println("* { margin: 0; padding: 0; box-sizing: border-box; }");
        out.println("body { font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', 'PingFang SC', 'Microsoft YaHei', sans-serif;");
        out.println("  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%); min-height: 100vh;");
        out.println("  display: flex; align-items: center; justify-content: center; }");
        out.println(".card { background: #fff; border-radius: 16px; box-shadow: 0 20px 60px rgba(0,0,0,0.15);");
        out.println("  padding: 40px; width: 420px; max-width: 95%; text-align: center; }");
        out.println(".icon { font-size: 64px; margin-bottom: 16px; }");
        out.println("h1 { font-size: 22px; color: #333; margin-bottom: 20px; }");
        out.println(".info { background: #f5f7fa; border-radius: 10px; padding: 16px; margin: 16px 0; text-align: left; }");
        out.println(".info .row { display: flex; justify-content: space-between; padding: 6px 0; font-size: 14px; }");
        out.println(".info .row .label { color: #888; } .info .row .value { color: #333; font-weight: 500; }");
        out.println(".status { color: " + statusColor + "; font-weight: 700; }");
        out.println(".btn { display: inline-block; margin-top: 16px; padding: 12px 32px; background: #1677ff;");
        out.println("  color: #fff; text-decoration: none; border-radius: 8px; font-size: 14px; font-weight: 600; border: none; cursor: pointer; }");
        out.println(".btn:hover { background: #0958d9; }");
        out.println(".tip { margin-top: 12px; font-size: 12px; color: #999; }");
        out.println("</style></head><body><div class='card'>");

        out.println("<div class='icon'>" + statusIcon + "</div>");
        out.println("<h1>" + statusText + "</h1>");

        out.println("<div class='info'>");
        out.println("<div class='row'><span class='label'>商户订单号</span><span class='value'>" + (outTradeNo != null ? outTradeNo : "-") + "</span></div>");
        if (tradeNo != null) {
            out.println("<div class='row'><span class='label'>支付宝交易号</span><span class='value'>" + tradeNo + "</span></div>");
        }
        if (totalAmount != null) {
            out.println("<div class='row'><span class='label'>支付金额</span><span class='value' style='color:#ff4d4f;font-weight:700;'>¥" + totalAmount + "</span></div>");
        }
        out.println("<div class='row'><span class='label'>订单状态</span><span class='value status'>" + orderStatus + "</span></div>");
        out.println("</div>");

        out.println("<a class='btn' href='/alipay-pay.html'>返回支付页面</a>");
        out.println("<p class='tip'>订单最终状态以系统异步通知为准</p>");
        out.println("</div></body></html>");
        out.flush();
    }
}
