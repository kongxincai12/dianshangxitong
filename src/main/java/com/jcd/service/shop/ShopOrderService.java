package com.jcd.service.shop;

import com.jcd.dto.shop.CheckoutDto;
import com.jcd.model.shop.ShopOrder;

import java.util.Date;
import java.util.Map;

/**
 * 订单服务
 */
public interface ShopOrderService {

    /** 结算下单: items 为空时使用购物车 */
    ShopOrder checkout(String userId, CheckoutDto dto);

    /** 支付订单 */
    void pay(String userId, String orderId);

    /** 取消订单(回补库存) */
    void cancel(String userId, String orderId);

    /** 订单详情(含明细) */
    ShopOrder detail(String userId, String orderId);

    /** 我的订单分页 */
    Map<String, Object> queryOrders(String userId, String status, int pageNo, int pageSize);

    /**
     * 支付宝支付成功后按业务订单号把商城订单推进为已支付。
     * 调用方是支付回调, 没有登录态, 因此不做归属校验; 幂等, 重复通知不会重复写库。
     *
     * @return 处理后的订单; 该订单号不属于商城订单时返回 null
     */
    ShopOrder markPaidByOrderNo(String orderNo, Date payTime);
}
