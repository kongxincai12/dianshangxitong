package com.jcd.service.shop;

import com.jcd.model.shop.ShopAddress;

import java.util.List;

/**
 * 电商收货地址簿
 */
public interface ShopAddressService {

    List<ShopAddress> list(String userId);

    /** id 为空则新增, 否则更新; 返回落库后的对象 */
    ShopAddress save(String userId, ShopAddress address);

    void delete(String userId, String id);

    void setDefault(String userId, String id);

    /**
     * 下单时解析收货地址: 指定地址 &gt; 默认地址 &gt; 最早创建的一条。
     * 地址簿为空返回 null, 由调用方决定是回退到手填还是报错。
     *
     * @param addressId 可为空; 传了但不存在或不属于该用户则直接报错, 不做静默回退
     */
    ShopAddress pickForOrder(String userId, String addressId);
}
