package com.jcd.service.Impl;

import com.jcd.mapper.EquipmentMapper;
import com.jcd.mapper.EquipmentStationBindingMapper;
import com.jcd.model.Equipment;
import com.jcd.model.EquipmentStationBinding;
import com.jcd.service.EquipmentStationBindingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

@Service
public class EquipmentStationBindingServiceImpl implements EquipmentStationBindingService {
    @Autowired
    private EquipmentStationBindingMapper bindingMapper;

    @Autowired
    private EquipmentMapper equipmentMapper;

    @Override
    public List<EquipmentStationBinding> listEffectiveByEquipment(String equipmentId) {
        if (!StringUtils.hasText(equipmentId)) {
            return Collections.emptyList();
        }
        Equipment equipment = equipmentMapper.findByCodeOrAssetsCode(equipmentId.trim());
        if (equipment == null || !StringUtils.hasText(equipment.getEqpCode())) {
            return Collections.emptyList();
        }
        return bindingMapper.listByEqpCode(equipment.getEqpCode());
    }
}
