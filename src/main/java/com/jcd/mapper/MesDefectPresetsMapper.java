package com.jcd.mapper;

import com.jcd.model.MesDefectPresets;
import com.jcd.model.Mes_defect_presetsExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper()
public interface MesDefectPresetsMapper {
    int deleteByPrimaryKey(String id);

    int insert(MesDefectPresets record);

    int insertSelective(MesDefectPresets record);

    List<MesDefectPresets> selectByExample(Mes_defect_presetsExample example);

    MesDefectPresets selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MesDefectPresets record, @Param("example") Mes_defect_presetsExample example);

    int updateByExample(@Param("record") MesDefectPresets record, @Param("example") Mes_defect_presetsExample example);

    int updateByPrimaryKeySelective(MesDefectPresets record);

    int updateByPrimaryKey(MesDefectPresets record);

    List<MesDefectPresets> findEnabledBySiteName(@Param("siteName") String siteName);

}