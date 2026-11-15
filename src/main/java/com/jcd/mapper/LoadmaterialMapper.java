package com.jcd.mapper;

import com.jcd.model.Loadmaterial;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper()
public interface LoadmaterialMapper {
    int deleteByPrimaryKey(String lmid);

    int insert(Loadmaterial record);

    int insertSelective(Loadmaterial record);

    Loadmaterial selectByPrimaryKey(String lmid);

    int updateByPrimaryKeySelective(Loadmaterial record);

    int updateByPrimaryKey(Loadmaterial record);
    List<Loadmaterial> LoadmateriaInfoGetByMoid(String moid);

    List<Loadmaterial> LoadMaterialGetByEqpAndSlotAndPnAndNullTaskname(String moid,String eqpname,String slot,String pn);

    List<Loadmaterial> LoadMaterialGetByEqpAndSlotAndNullTaskname(String moid,String eqpname,String slot);
    List<Loadmaterial> LoadMaterialGetByEqpAndSlotAndPnAndTaskname(String moid,String eqpname,String slot,String pn,String taskname);
    List<Loadmaterial> LoadMaterialGetByEqpAndSlotAndTaskname(String moid,String eqpname,String slot,String taskname);


    List<Loadmaterial> LoadmateriaInfoGetByEqpandSlot(String moid,String eqpname,String slot);
}