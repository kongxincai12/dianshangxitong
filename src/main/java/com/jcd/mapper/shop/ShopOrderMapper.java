package com.jcd.mapper.shop;

import com.jcd.model.shop.ShopOrder;
import com.jcd.model.shop.ShopOrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface ShopOrderMapper {

    int insert(ShopOrder order);

    int insertItem(ShopOrderItem item);

    int batchInsertItems(@Param("items") List<ShopOrderItem> items);

    ShopOrder selectById(@Param("id") String id);

    /** 按业务订单号查询; 支付宝回调用它把 SHOP_ORDER 推进为已支付 */
    ShopOrder selectByOrderNo(@Param("orderNo") String orderNo);

    List<ShopOrderItem> selectItemsByOrderId(@Param("orderId") String orderId);

    /** 更新订单状态; 支付时同步写入支付时间 */
    int updateStatus(@Param("id") String id,
                     @Param("status") String status,
                     @Param("payTime") Date payTime,
                     @Param("updateTime") Date updateTime);

    /** 分页查询用户订单 */
    List<ShopOrder> queryByUser(@Param("userId") String userId,
                                @Param("status") String status,
                                @Param("offset") int offset,
                                @Param("limit") int limit);

    int queryByUserCount(@Param("userId") String userId, @Param("status") String status);

    /** 业务订单号生成: 取当天最大流水 + 1 */
    Integer nextDailyOrderSeq(@Param("prefix") String prefix);
}
