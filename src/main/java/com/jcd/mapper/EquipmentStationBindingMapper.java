package com.jcd.mapper;

import com.jcd.model.EquipmentStationBinding;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EquipmentStationBindingMapper {
    List<EquipmentStationBinding> listByEqpCode(@Param("eqpCode") String eqpCode);
}
