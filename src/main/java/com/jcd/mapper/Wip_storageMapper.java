package com.jcd.mapper;

import com.jcd.model.V_location_all;
import com.jcd.model.Wip_storage;
import com.jcd.model.Wip_storageExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper()
public interface Wip_storageMapper {
    int deleteByPrimaryKey(String storageid);

    int Wip_storageInsert(Wip_storage record);


    int insertSelective(Wip_storage record);

    List<Wip_storage> selectByExample(Wip_storageExample example);

    List<Wip_storage> Wip_storageGetByCartoncode(String cartoncode);

    Wip_storage selectByPrimaryKey(String storageid);

    int updateByExampleSelective(@Param("record") Wip_storage record, @Param("example") Wip_storageExample example);

    int updateByExample(@Param("record") Wip_storage record, @Param("example") Wip_storageExample example);

    int updateByPrimaryKeySelective(Wip_storage record);

    int Wip_storageUpdate(Wip_storage record);
}