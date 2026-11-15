package com.jcd.mapper;

import com.jcd.model.Equipment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper()
public interface EquipmentMapper {
    /**
     * 根据设备编码或资产编码查询设备信息
     * @param identifier 可能是eqp_code或assets_code
     * @return 设备实体
     */
    // 【修改】移除 @Select 注解
    Equipment findByCodeOrAssetsCode(@Param("identifier") String identifier);
    Equipment findById(@Param("id") String id);
    List<Equipment> findByKeyword(@Param("keyword") String keyword);
}
