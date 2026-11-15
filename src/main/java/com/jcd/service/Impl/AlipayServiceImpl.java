package com.jcd.service.Impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.domain.*;
import com.alipay.api.internal.util.AlipaySignature;
import com.alipay.api.request.*;
import com.alipay.api.response.*;
import com.jcd.config.AlipayConfig;
import com.jcd.dto.*;
import com.jcd.exception.BusinessException;
import com.jcd.mapper.PaymentOrderMapper;
import com.jcd.model.PaymentOrder;
import com.jcd.service.AlipayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * 支付宝支付服务实现类
 */
@Service
public class AlipayServiceImpl implements AlipayService {

    private static final Logger logger = LoggerFactory.getLogger(AlipayServiceImpl.class);

    /** 订单状态常量 */
    private static final String STATUS_WAIT_PAY = "WAIT_PAY";
    private static final String STATUS_PAID = "PAID";
    private static final String STATUS_CLOSED = "CLOSED";
    private static final String STATUS_REFUNDED = "REFUNDED";

    @Autowired
    private AlipayClient alipayClient;

    @Autowired
    private AlipayConfig alipayConfig;

    @Autowired
    private PaymentOrderMapper paymentOrderMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public AlipayPayResponseDto createPayOrder(AlipayPayRequestDto requestDto) {
        logger.info("创建支付宝订单, subject={}, amount={}", requestDto.getSubject(), requestDto.getTotalAmount());

        if (requestDto.getTotalAmount() == null || requestDto.getTotalAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BusinessException("支付金额必须大于0");
        }
        if (requestDto.getSubject() == null || requestDto.getSubject().trim().isEmpty()) {
            throw new BusinessException("订单标题不能为空");
        }

        String outTradeNo = requestDto.getOutTradeNo();
        if (outTradeNo == null || outTradeNo.trim().isEmpty()) {
            outTradeNo = generateOutTradeNo();
        }

        PaymentOrder order = new PaymentOrder();
        order.setId(UUID.randomUUID().toString().replace("-", ""));
        order.setOutTradeNo(outTradeNo);
        order.setSubject(requestDto.getSubject());
        order.setTotalAmount(requestDto.getTotalAmount());
        order.setOrderStatus(STATUS_WAIT_PAY);
        order.setCreateBy(requestDto.getCreateBy());
        order.setRemark(requestDto.getRemark());
        paymentOrderMapper.insert(order);

        // 手机端直接使用 wap.pay，PC端优先尝试 precreate
        String userAgent = getUserAgent();
        boolean isMobile = userAgent != null && (userAgent.contains("Mobile") || userAgent.contains("Android") || userAgent.contains("iPhone"));

        if (isMobile) {
            logger.info("检测到移动端，直接使用wap.pay");
            return createWapPayOrder(outTradeNo, requestDto);
        }

        // PC端：优先 precreate（二维码），失败降级 wap.pay
        try {
            AlipayTradePrecreateModel preModel = new AlipayTradePrecreateModel();
            preModel.setOutTradeNo(outTradeNo);
            preModel.setTotalAmount(requestDto.getTotalAmount().toString());
            preModel.setSubject(requestDto.getSubject());
            preModel.setBody(requestDto.getBody());
            preModel.setTimeoutExpress(requestDto.getTimeoutExpress() != null ? requestDto.getTimeoutExpress() : "30m");

            AlipayTradePrecreateRequest preRequest = new AlipayTradePrecreateRequest();
            preRequest.setNotifyUrl(alipayConfig.getNotifyUrl());
            preRequest.setBizModel(preModel);

            AlipayTradePrecreateResponse preResponse = alipayClient.execute(preRequest);
            logger.info("precreate响应, outTradeNo={}, isSuccess={}, subCode={}",
                    outTradeNo, preResponse.isSuccess(), preResponse.getSubCode());

            if (preResponse.isSuccess() && preResponse.getQrCode() != null) {
                logger.info("precreate成功, 二维码链接: {}", preResponse.getQrCode());
                AlipayPayResponseDto result = new AlipayPayResponseDto();
                result.setOutTradeNo(outTradeNo);
                result.setSubject(requestDto.getSubject());
                result.setTotalAmount(requestDto.getTotalAmount());
                result.setOrderStatus(STATUS_WAIT_PAY);
                result.setPayUrl(preResponse.getQrCode());
                result.setPayType("QR");
                return result;
            }
            logger.warn("precreate失败, 降级到wap.pay. subCode={}, subMsg={}",
                    preResponse.getSubCode(), preResponse.getSubMsg());
        } catch (AlipayApiException e) {
            logger.warn("precreate调用异常, 降级到wap.pay: {}", e.getMessage());
        }

        return createWapPayOrder(outTradeNo, requestDto);
    }

    private AlipayPayResponseDto createWapPayOrder(String outTradeNo, AlipayPayRequestDto requestDto) {
        try {
            AlipayTradeWapPayModel wapModel = new AlipayTradeWapPayModel();
            wapModel.setOutTradeNo(outTradeNo);
            wapModel.setTotalAmount(requestDto.getTotalAmount().toString());
            wapModel.setSubject(requestDto.getSubject());
            wapModel.setBody(requestDto.getBody());
            wapModel.setProductCode("QUICK_WAP_WAY");
            wapModel.setTimeoutExpress(requestDto.getTimeoutExpress() != null ? requestDto.getTimeoutExpress() : "30m");

            AlipayTradeWapPayRequest wapRequest = new AlipayTradeWapPayRequest();
            wapRequest.setNotifyUrl(alipayConfig.getNotifyUrl());
            wapRequest.setReturnUrl(alipayConfig.getReturnUrl());
            wapRequest.setBizModel(wapModel);

            AlipayTradeWapPayResponse wapResponse = alipayClient.pageExecute(wapRequest);
            logger.info("wap.pay响应, outTradeNo={}, isSuccess={}", outTradeNo, wapResponse.isSuccess());

            if (wapResponse.isSuccess()) {
                String payUrl = wapResponse.getBody();
                logger.info("wap.pay成功, 支付URL长度: {}", payUrl != null ? payUrl.length() : 0);
                AlipayPayResponseDto result = new AlipayPayResponseDto();
                result.setOutTradeNo(outTradeNo);
                result.setSubject(requestDto.getSubject());
                result.setTotalAmount(requestDto.getTotalAmount());
                result.setOrderStatus(STATUS_WAIT_PAY);
                result.setPayUrl(payUrl);
                result.setPayType("WAP");
                return result;
            } else {
                logger.error("wap.pay失败, subCode={}, subMsg={}", wapResponse.getSubCode(), wapResponse.getSubMsg());
                throw new BusinessException("创建支付订单失败: " + wapResponse.getSubMsg());
            }
        } catch (AlipayApiException e) {
            logger.error("wap.pay调用异常: {}", e.getMessage(), e);
            throw new BusinessException("创建支付订单失败: " + e.getMessage());
        }
    }

    private String getUserAgent() {
        try {
            javax.servlet.http.HttpServletRequest request = ((org.springframework.web.context.request.ServletRequestAttributes)
                    org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).getRequest();
            return request.getHeader("User-Agent");
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public String handleNotify(Map<String, String> params) {
        logger.info("收到支付宝异步通知, params={}", params);

        try {
            // 验证签名
            boolean signVerified = AlipaySignature.rsaCheckV1(
                    params,
                    alipayConfig.getAlipayPublicKey(),
                    "UTF-8",
                    alipayConfig.getSignType()
            );

            if (!signVerified) {
                logger.warn("支付宝签名验证失败");
                return "failure";
            }

            // 获取通知参数
            String outTradeNo = params.get("out_trade_no");
            String tradeNo = params.get("trade_no");
            String tradeStatus = params.get("trade_status");
            String buyerLogonId = params.get("buyer_logon_id");
            String buyerId = params.get("buyer_id");
            String gmtPayment = params.get("gmt_payment");

            logger.info("通知参数: outTradeNo={}, tradeNo={}, tradeStatus={}", outTradeNo, tradeNo, tradeStatus);

            // 查询订单
            PaymentOrder order = paymentOrderMapper.selectByOutTradeNo(outTradeNo);
            if (order == null) {
                logger.warn("订单不存在, outTradeNo={}", outTradeNo);
                return "failure";
            }

            // 防止重复通知
            if (STATUS_PAID.equals(order.getOrderStatus())) {
                logger.info("订单已处理, outTradeNo={}", outTradeNo);
                return "success";
            }

            // 交易成功
            if ("TRADE_SUCCESS".equals(tradeStatus) || "TRADE_FINISHED".equals(tradeStatus)) {
                Date payTime = null;
                if (gmtPayment != null) {
                    try {
                        payTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(gmtPayment);
                    } catch (Exception e) {
                        logger.error("解析支付时间失败, gmtPayment={}", gmtPayment);
                    }
                }

                paymentOrderMapper.updateStatus(
                        order.getId(),
                        STATUS_PAID,
                        tradeNo,
                        buyerLogonId,
                        buyerId,
                        payTime,
                        new Date(),
                        "alipay_notify"
                );
                logger.info("订单支付成功, outTradeNo={}, tradeNo={}", outTradeNo, tradeNo);

                // TODO: 这里可以添加业务逻辑, 如: 更新业务订单状态、发送通知等
            }

            return "success";
        } catch (Exception e) {
            logger.error("处理支付宝通知异常, error={}", e.getMessage(), e);
            return "failure";
        }
    }

    @Override
    public PaymentOrder queryOrder(String outTradeNo) {
        return paymentOrderMapper.selectByOutTradeNo(outTradeNo);
    }

    @Override
    public Map<String, String> queryTradeStatus(AlipayQueryRequestDto requestDto) {
        logger.info("查询支付宝交易状态, outTradeNo={}, tradeNo={}", 
                requestDto.getOutTradeNo(), requestDto.getTradeNo());

        AlipayTradeQueryModel model = new AlipayTradeQueryModel();
        model.setOutTradeNo(requestDto.getOutTradeNo());
        model.setTradeNo(requestDto.getTradeNo());

        AlipayTradeQueryRequest request = new AlipayTradeQueryRequest();
        request.setBizModel(model);

        try {
            AlipayTradeQueryResponse response = alipayClient.execute(request);
            Map<String, String> result = new HashMap<>();

            if (response.isSuccess()) {
                result.put("tradeNo", response.getTradeNo());
                result.put("outTradeNo", response.getOutTradeNo());
                result.put("tradeStatus", response.getTradeStatus());
                result.put("totalAmount", response.getTotalAmount());
                result.put("buyerLogonId", response.getBuyerLogonId());
                if (response.getSendPayDate() != null) {
                    result.put("sendPayDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(response.getSendPayDate()));
                }
                logger.info("查询交易状态成功, tradeNo={}, status={}", 
                        response.getTradeNo(), response.getTradeStatus());
            } else {
                result.put("code", response.getCode());
                result.put("msg", response.getMsg());
                result.put("subCode", response.getSubCode());
                result.put("subMsg", response.getSubMsg());
                logger.warn("查询交易状态失败, code={}, msg={}", response.getCode(), response.getMsg());
            }

            return result;
        } catch (AlipayApiException e) {
            logger.error("查询交易状态异常, error={}", e.getMessage(), e);
            throw new BusinessException("查询交易状态失败: " + e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, String> refund(AlipayRefundRequestDto requestDto) {
        logger.info("申请退款, outTradeNo={}, amount={}", 
                requestDto.getOutTradeNo(), requestDto.getRefundAmount());

        if (requestDto.getRefundAmount() == null || requestDto.getRefundAmount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new BusinessException("退款金额必须大于0");
        }

        AlipayTradeRefundModel model = new AlipayTradeRefundModel();
        model.setOutTradeNo(requestDto.getOutTradeNo());
        model.setTradeNo(requestDto.getTradeNo());
        model.setRefundAmount(requestDto.getRefundAmount().toString());
        model.setRefundReason(requestDto.getRefundReason());
        model.setOutRequestNo(requestDto.getOutRequestNo());

        AlipayTradeRefundRequest request = new AlipayTradeRefundRequest();
        request.setBizModel(model);

        try {
            AlipayTradeRefundResponse response = alipayClient.execute(request);
            Map<String, String> result = new HashMap<>();

            if (response.isSuccess()) {
                result.put("tradeNo", response.getTradeNo());
                result.put("outTradeNo", response.getOutTradeNo());
                result.put("refundFee", response.getRefundFee());
                result.put("fundChange", response.getFundChange());

                // 更新订单状态
                PaymentOrder order = paymentOrderMapper.selectByOutTradeNo(requestDto.getOutTradeNo());
                if (order != null) {
                    paymentOrderMapper.updateStatus(
                            order.getId(),
                            STATUS_REFUNDED,
                            order.getTradeNo(),
                            order.getBuyerLogonId(),
                            order.getBuyerId(),
                            order.getPayTime(),
                            new Date(),
                            requestDto.getOperatorId()
                    );
                }
                logger.info("退款成功, tradeNo={}, refundFee={}", response.getTradeNo(), response.getRefundFee());
            } else {
                result.put("code", response.getCode());
                result.put("msg", response.getMsg());
                result.put("subCode", response.getSubCode());
                result.put("subMsg", response.getSubMsg());
                logger.warn("退款失败, code={}, msg={}", response.getCode(), response.getMsg());
            }

            return result;
        } catch (AlipayApiException e) {
            logger.error("退款异常, error={}", e.getMessage(), e);
            throw new BusinessException("退款失败: " + e.getMessage());
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public Map<String, String> closeOrder(String outTradeNo) {
        logger.info("关闭订单, outTradeNo={}", outTradeNo);

        AlipayTradeCloseModel model = new AlipayTradeCloseModel();
        model.setOutTradeNo(outTradeNo);

        AlipayTradeCloseRequest request = new AlipayTradeCloseRequest();
        request.setBizModel(model);

        try {
            AlipayTradeCloseResponse response = alipayClient.execute(request);
            Map<String, String> result = new HashMap<>();

            if (response.isSuccess()) {
                result.put("tradeNo", response.getTradeNo());
                result.put("outTradeNo", response.getOutTradeNo());

                // 更新订单状态
                PaymentOrder order = paymentOrderMapper.selectByOutTradeNo(outTradeNo);
                if (order != null) {
                    paymentOrderMapper.updateStatus(
                            order.getId(),
                            STATUS_CLOSED,
                            order.getTradeNo(),
                            order.getBuyerLogonId(),
                            order.getBuyerId(),
                            order.getPayTime(),
                            new Date(),
                            "system"
                    );
                }
                logger.info("订单关闭成功, outTradeNo={}", outTradeNo);
            } else {
                result.put("code", response.getCode());
                result.put("msg", response.getMsg());
                result.put("subCode", response.getSubCode());
                result.put("subMsg", response.getSubMsg());
                logger.warn("订单关闭失败, code={}, msg={}", response.getCode(), response.getMsg());
            }

            return result;
        } catch (AlipayApiException e) {
            logger.error("关闭订单异常, error={}", e.getMessage(), e);
            throw new BusinessException("关闭订单失败: " + e.getMessage());
        }
    }

    /**
     * 生成商户订单号: PAY + 年月日时分秒 + 4位随机数
     */
    private String generateOutTradeNo() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStr = sdf.format(new Date());
        String randomStr = String.format("%04d", new Random().nextInt(10000));
        return "PAY" + dateStr + randomStr;
    }
}
