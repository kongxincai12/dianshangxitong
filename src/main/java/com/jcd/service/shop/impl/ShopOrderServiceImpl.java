package com.jcd.service.shop.impl;

import com.jcd.dto.shop.CartItemDto;
import com.jcd.dto.shop.CheckoutDto;
import com.jcd.exception.BusinessException;
import com.jcd.mapper.shop.ShopCartMapper;
import com.jcd.mapper.shop.ShopOrderMapper;
import com.jcd.mapper.shop.ShopProductMapper;
import com.jcd.model.shop.ShopCart;
import com.jcd.model.shop.ShopOrder;
import com.jcd.model.shop.ShopOrderItem;
import com.jcd.model.shop.ShopProduct;
import com.jcd.service.shop.ShopOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ShopOrderServiceImpl implements ShopOrderService {

    public static final String S_PENDING   = "PENDING";
    public static final String S_PAID      = "PAID";
    public static final String S_CANCELLED = "CANCELLED";

    @Autowired private ShopOrderMapper   orderMapper;
    @Autowired private ShopProductMapper productMapper;
    @Autowired private ShopCartMapper    cartMapper;

    @Override
    @Transactional
    public ShopOrder checkout(String userId, CheckoutDto dto) {
        if (dto == null) {
            throw new BusinessException(400, "结算参数不能为空");
        }
        // 1. 归集结算明细: 优先使用传入 items, 否则取购物车
        List<CartItemDto> items;
        boolean fromCart = CollectionUtils.isEmpty(dto.getItems());
        if (fromCart) {
            List<ShopCart> carts = cartMapper.selectByUser(userId);
            if (CollectionUtils.isEmpty(carts)) {
                throw new BusinessException(400, "购物车为空, 无法下单");
            }
            items = carts.stream().map(c -> {
                CartItemDto ci = new CartItemDto();
                ci.setProductId(c.getProductId());
                ci.setQuantity(c.getQuantity());
                return ci;
            }).collect(Collectors.toList());
        } else {
            items = dto.getItems();
        }

        // 2. 校验商品/库存并计算金额, 扣减库存
        Date now = new Date();
        List<ShopOrderItem> orderItems = new ArrayList<>();
        BigDecimal total = BigDecimal.ZERO;
        for (CartItemDto item : items) {
            if (item == null || !StringUtils.hasText(item.getProductId())) {
                throw new BusinessException(400, "结算明细存在空商品");
            }
            int qty = item.getQuantity() == null || item.getQuantity() <= 0 ? 1 : item.getQuantity();
            ShopProduct p = productMapper.selectById(item.getProductId());
            if (p == null) {
                throw new BusinessException(404, "商品不存在: " + item.getProductId());
            }
            if (p.getStatus() != null && p.getStatus() == 0) {
                throw new BusinessException(409, "商品已下架: " + p.getName());
            }
            // 乐观扣减库存: SQL 内含 STOCK >= qty 条件, 影响行数 0 表示库存不足
            if (productMapper.deductStock(p.getId(), qty) == 0) {
                throw new BusinessException(409, "商品库存不足: " + p.getName());
            }
            BigDecimal subtotal = p.getPrice().multiply(BigDecimal.valueOf(qty));
            total = total.add(subtotal);

            ShopOrderItem oi = new ShopOrderItem();
            oi.setId(uuid());
            oi.setProductId(p.getId());
            oi.setProductName(p.getName());
            oi.setPrice(p.getPrice());
            oi.setQuantity(qty);
            oi.setSubtotal(subtotal);
            orderItems.add(oi);
        }

        // 3. 生成订单主表
        ShopOrder order = new ShopOrder();
        order.setId(uuid());
        order.setOrderNo(genOrderNo());
        order.setUserId(userId);
        order.setTotalAmount(total);
        order.setStatus(S_PENDING);
        order.setReceiverName(dto.getReceiverName());
        order.setReceiverPhone(dto.getReceiverPhone());
        order.setReceiverAddress(dto.getReceiverAddress());
        order.setRemark(dto.getRemark());
        order.setCreateTime(now);
        order.setUpdateTime(now);
        orderMapper.insert(order);

        // 4. 明细落库
        for (ShopOrderItem oi : orderItems) {
            oi.setOrderId(order.getId());
        }
        orderMapper.batchInsertItems(orderItems);

        // 5. 来自购物车则清理已下单商品
        if (fromCart) {
            cartMapper.deleteByUserAndProducts(userId,
                    orderItems.stream().map(ShopOrderItem::getProductId).collect(Collectors.toList()));
        }

        order.setItems(orderItems);
        return order;
    }

    @Override
    @Transactional
    public void pay(String userId, String orderId) {
        ShopOrder order = mustOwned(userId, orderId);
        if (!S_PENDING.equals(order.getStatus())) {
            throw new BusinessException(409, "订单当前状态不可支付: " + order.getStatus());
        }
        Date now = new Date();
        orderMapper.updateStatus(orderId, S_PAID, now, now);
    }

    @Override
    @Transactional
    public void cancel(String userId, String orderId) {
        ShopOrder order = mustOwned(userId, orderId);
        if (S_CANCELLED.equals(order.getStatus())) {
            throw new BusinessException(409, "订单已取消");
        }
        if (S_PAID.equals(order.getStatus())) {
            throw new BusinessException(409, "已支付订单不可取消, 请走退款流程");
        }
        // 回补库存
        List<ShopOrderItem> items = orderMapper.selectItemsByOrderId(orderId);
        for (ShopOrderItem it : items) {
            productMapper.restoreStock(it.getProductId(), it.getQuantity());
        }
        orderMapper.updateStatus(orderId, S_CANCELLED, null, new Date());
    }

    @Override
    public ShopOrder detail(String userId, String orderId) {
        ShopOrder order = mustOwned(userId, orderId);
        order.setItems(orderMapper.selectItemsByOrderId(orderId));
        return order;
    }

    @Override
    public Map<String, Object> queryOrders(String userId, String status, int pageNo, int pageSize) {
        if (pageNo < 1) pageNo = 1;
        if (pageSize < 1) pageSize = 20;
        if (pageSize > 200) pageSize = 200;
        int offset = (pageNo - 1) * pageSize;

        int total = orderMapper.queryByUserCount(userId, status);
        List<ShopOrder> list = orderMapper.queryByUser(userId, status, offset, pageSize);

        Map<String, Object> result = new LinkedHashMap<>();
        result.put("total", total);
        result.put("pageNo", pageNo);
        result.put("pageSize", pageSize);
        result.put("list", list);
        return result;
    }

    @Override
    @Transactional
    public ShopOrder markPaidByOrderNo(String orderNo, Date payTime) {
        ShopOrder order = orderMapper.selectByOrderNo(orderNo);
        if (order == null) {
            return null;
        }
        // 已支付或已取消都不再改状态, 交给调用方记日志; 避免重复通知把已取消订单“救活”
        if (!S_PENDING.equals(order.getStatus())) {
            return order;
        }
        Date paidAt = payTime != null ? payTime : new Date();
        orderMapper.updateStatus(order.getId(), S_PAID, paidAt, new Date());
        order.setStatus(S_PAID);
        order.setPayTime(paidAt);
        return order;
    }

    /* ================= helpers ================= */

    private ShopOrder mustOwned(String userId, String orderId) {
        ShopOrder order = orderMapper.selectById(orderId);
        if (order == null) {
            throw new BusinessException(404, "订单不存在: " + orderId);
        }
        if (userId != null && !userId.equals(order.getUserId())) {
            throw new BusinessException(403, "无权操作他人订单");
        }
        return order;
    }

    /** SO + yyyyMMdd + 4位每日流水 */
    private synchronized String genOrderNo() {
        String prefix = "SO" + new SimpleDateFormat("yyyyMMdd").format(new Date());
        Integer seq = orderMapper.nextDailyOrderSeq(prefix);
        if (seq == null) seq = 1;
        if (seq > 9999) {
            throw new BusinessException(409, "当天订单号流水已超过9999");
        }
        return prefix + String.format("%04d", seq);
    }

    private String uuid() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
