package com.jcd.service.shop.impl;

import com.jcd.exception.BusinessException;
import com.jcd.mapper.shop.ShopAddressMapper;
import com.jcd.model.shop.ShopAddress;
import com.jcd.service.shop.ShopAddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class ShopAddressServiceImpl implements ShopAddressService {

    @Autowired private ShopAddressMapper addressMapper;

    @Override
    public List<ShopAddress> list(String userId) {
        return addressMapper.selectByUser(userId);
    }

    @Override
    @Transactional
    public ShopAddress save(String userId, ShopAddress address) {
        if (address == null) {
            throw new BusinessException(400, "地址信息不能为空");
        }
        requireText(address.getReceiverName(), "收货人不能为空");
        requireText(address.getReceiverPhone(), "手机号不能为空");
        requireText(address.getReceiverAddress(), "收货地址不能为空");
        Date now = new Date();

        if (!StringUtils.hasText(address.getId())) {
            address.setId(UUID.randomUUID().toString().replace("-", ""));
            address.setUserId(userId);
            // 第一条地址自动设为默认, 否则用户下第一单时没有默认地址可用
            address.setIsDefault(addressMapper.countByUser(userId) == 0 ? 1 : 0);
            address.setCreateTime(now);
            address.setUpdateTime(now);
            addressMapper.insert(address);
            return address;
        }

        // 更新: 先确认这条地址确实属于当前用户, 不认前端传的 USER_ID
        ShopAddress exist = mustOwned(userId, address.getId());
        exist.setReceiverName(address.getReceiverName());
        exist.setReceiverPhone(address.getReceiverPhone());
        exist.setReceiverAddress(address.getReceiverAddress());
        exist.setUpdateTime(now);
        addressMapper.update(exist);
        return exist;
    }

    @Override
    @Transactional
    public void delete(String userId, String id) {
        ShopAddress exist = mustOwned(userId, id);
        addressMapper.deleteByIdAndUser(id, userId);
        // 删掉的正好是默认地址时, 把剩下最早的一条提上来, 避免出现"有地址但没默认"
        if (exist.getIsDefault() != null && exist.getIsDefault() == 1) {
            List<ShopAddress> rest = addressMapper.selectByUser(userId);
            if (!CollectionUtils.isEmpty(rest)) {
                addressMapper.markDefault(rest.get(0).getId(), userId);
            }
        }
    }

    @Override
    @Transactional
    public void setDefault(String userId, String id) {
        mustOwned(userId, id);
        addressMapper.clearDefault(userId);
        addressMapper.markDefault(id, userId);
    }

    @Override
    public ShopAddress pickForOrder(String userId, String addressId) {
        if (StringUtils.hasText(addressId)) {
            // 用户明确选了某条地址, 这时候查不到属于异常, 不能悄悄换成别的地址下单
            return mustOwned(userId, addressId);
        }
        ShopAddress def = addressMapper.selectDefault(userId);
        if (def != null) {
            return def;
        }
        List<ShopAddress> all = addressMapper.selectByUser(userId);
        return CollectionUtils.isEmpty(all) ? null : all.get(0);
    }

    /* ================= helpers ================= */

    private ShopAddress mustOwned(String userId, String id) {
        ShopAddress address = addressMapper.selectById(id);
        if (address == null) {
            throw new BusinessException(404, "收货地址不存在: " + id);
        }
        if (userId == null || !userId.equals(address.getUserId())) {
            throw new BusinessException(403, "无权操作他人收货地址");
        }
        return address;
    }

    private void requireText(String value, String message) {
        if (!StringUtils.hasText(value)) {
            throw new BusinessException(400, message);
        }
    }
}
