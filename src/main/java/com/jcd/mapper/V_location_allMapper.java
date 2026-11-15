package com.jcd.mapper;

import com.jcd.model.V_location_all;
import com.jcd.model.V_location_allExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper()
public interface V_location_allMapper {
    int insert(V_location_all record);

    int insertSelective(V_location_all record);
    //List<V_location_all> selectByLoc_name(String loc_name);
    List<V_location_all> selectByExample(V_location_allExample example);

    List<V_location_all> V_location_allGetByLoc_name(String loc_name);

    /** 根据货架编号(RACK)查询该货架下所有储位 */
    List<V_location_all> selectByRack(@Param("rack") String rack);

    /** 根据储位编码(LOC_NAME)和储位类型(LOC_TYPE)查询 */
    List<V_location_all> selectByLocNameAndType(@Param("locName") String locName, @Param("locType") String locType);

    /** 根据储位ID(LOC_ID)查询 */
    List<V_location_all> selectByLocId(@Param("locId") String locId);

    /**
     * 查询某料架下所有【空储位】(没有UPN库存的储位)
     * 储位与物料为1:1关系，通过 NOT EXISTS 子查询排除已有物料的储位
     * 用于入库亮灯：只亮空储位，引导操作员放料
     */
    List<V_location_all> selectEmptyLocationsByRack(@Param("rack") String rack);
}