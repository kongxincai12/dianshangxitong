package com.jcd.mapper;

import com.jcd.dto.EquipmentTypeDto;
import com.jcd.model.EquipmentType;
import com.jcd.model.EquipmentTypeExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper()

public interface EquipmentTypeMapper {

    List<EquipmentType> findAll();
}