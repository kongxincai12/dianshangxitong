package com.jcd.service;

import com.jcd.dto.EquipmentTypeDto;
import com.jcd.dto.EquipmentTypeParamDto;
import com.jcd.dto.ParamMaintenanceDto;
import com.jcd.dto.ParamOverrideDto;
import com.jcd.model.Equipment;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface EquipmentTypeParamService {
    List<EquipmentTypeParamDto> findEnabledByEqpTypeId(String eqpTypeId);
    List<EquipmentTypeParamDto> findAllByEqpTypeId(String eqpTypeId);
    void create(EquipmentTypeParamDto dto);
    void update(EquipmentTypeParamDto dto);
    void delete(String paramId);
    List<EquipmentTypeDto> findAll();

    void deleteParam(String id);

    EquipmentTypeParamDto updateParam(EquipmentTypeParamDto paramDto);

    EquipmentTypeParamDto createParamV2(EquipmentTypeParamDto paramDto);

    List<Equipment> searchEquipmentsByKeyword(String keyword);

    ParamMaintenanceDto getEffectiveParamsForMaintenance(String eqpId);

    @Transactional
    List<ParamOverrideDto> createOverrideFromDefault(String eqpId);

    @Transactional
    void revertToDefault(String eqpId);

    @Transactional
    ParamOverrideDto createOverrideParam(ParamOverrideDto dto);

    @Transactional
    ParamOverrideDto updateOverrideParam(ParamOverrideDto dto);

    @Transactional
    void deleteOverrideParam(String id);

//    @Transactional
//    ParamOverrideDto createOverrideParam(ParamOverrideDto dto);
//
//    @Transactional
//    ParamOverrideDto updateOverrideParam(ParamOverrideDto dto);
//
//    @Transactional
//    ParamOverrideDto createOverrideParam(ParamOverrideDto dto);
//
//    @Transactional
//    void deleteOverrideParam(String id);
}

