package com.jcd.service;

import com.jcd.model.EquipmentStationBinding;

import java.util.List;

public interface EquipmentStationBindingService {
    List<EquipmentStationBinding> listEffectiveByEquipment(String equipmentId);
}
