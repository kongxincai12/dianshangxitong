package com.jcd.mapper;

import com.jcd.model.EquipmentTypeParam;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
// 【修改】移除 @Select 注解
// import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper()
public interface EquipmentTypeParamMapper {
    /**
     * 根据设备类型ID查询所有启用的参数，并按顺序排序
     * @param eqpTypeId 设备类型ID
     * @return 参数列表
     */
    // 【修改】移除 @Select 注解
    List<EquipmentTypeParam> findEnabledByEqpTypeId(@Param("eqpTypeId") String eqpTypeId); // 原方法名修改得更清晰
    List<EquipmentTypeParam> findAllByEqpTypeId(@Param("eqpTypeId") String eqpTypeId); // 新增方法
    void insert(EquipmentTypeParam entity);
    void update(EquipmentTypeParam entity);
    void delete(@Param("id") String id);
    long countByKeyAndTypeId(@Param("paramKey") String paramKey,@Param("eqpTypeId") String eqpTypeId);

    List<EquipmentTypeParam> findActiveByEqpTypeId(String eqpTypeId);
}