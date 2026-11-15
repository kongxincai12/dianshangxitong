package com.jcd.mapper;

import com.jcd.model.EpmParamProduct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 设备料号参数 Mapper（对应 EPM_PARAM_PRODUCT 表）
 */
@Mapper
public interface EpmParamProductMapper {

    int insert(EpmParamProduct record);

    /**
     * 根据设备ID + 料号 查询参数列表
     */
    List<EpmParamProduct> findByEqpIdAndProductCode(@Param("eqpId") String eqpId,
                                                     @Param("productCode") String productCode);

    EpmParamProduct findById(@Param("id") String id);

    int batchInsert(@Param("list") List<EpmParamProduct> paramList);

    /**
     * 删除指定设备+料号的所有参数
     */
    int deleteByEqpIdAndProductCode(@Param("eqpId") String eqpId,
                                     @Param("productCode") String productCode);

    int deleteById(@Param("id") String id);

    int update(EpmParamProduct record);

    /**
     * 校验料号是否存在（查询 PRODUCT 表）
     */
    java.util.Map<String, Object> checkProductByPn(@Param("pn") String pn);

    /**
     * 查询指定设备下已绑定的所有料号列表
     */
    List<String> findProductCodesByEqpId(@Param("eqpId") String eqpId);
}
