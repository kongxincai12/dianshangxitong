package com.jcd.mapper;

import com.jcd.model.PaymentOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 支付订单 Mapper
 */
@Mapper
public interface PaymentOrderMapper {

    /**
     * 根据ID查询订单
     */
    PaymentOrder selectById(@Param("id") String id);

    /**
     * 根据商户订单号查询订单
     */
    PaymentOrder selectByOutTradeNo(@Param("outTradeNo") String outTradeNo);

    /**
     * 根据支付宝交易号查询订单
     */
    PaymentOrder selectByTradeNo(@Param("tradeNo") String tradeNo);

    /**
     * 插入订单
     */
    int insert(PaymentOrder order);

    /**
     * 更新订单状态
     */
    int updateStatus(@Param("id") String id,
                     @Param("orderStatus") String orderStatus,
                     @Param("tradeNo") String tradeNo,
                     @Param("buyerLogonId") String buyerLogonId,
                     @Param("buyerId") String buyerId,
                     @Param("payTime") java.util.Date payTime,
                     @Param("notifyTime") java.util.Date notifyTime,
                     @Param("updateBy") String updateBy);

    /**
     * 根据状态查询订单列表
     */
    List<PaymentOrder> selectByStatus(@Param("orderStatus") String orderStatus);

    /**
     * 根据创建人查询订单列表
     */
    List<PaymentOrder> selectByCreateBy(@Param("createBy") String createBy);
}
