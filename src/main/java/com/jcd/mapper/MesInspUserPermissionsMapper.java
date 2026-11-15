package com.jcd.mapper;

import com.jcd.model.MesInspUserPermissions;
import com.jcd.model.MesInspUserPermissionsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesInspUserPermissionsMapper {
    int countByExample(MesInspUserPermissionsExample example);

    int deleteByExample(MesInspUserPermissionsExample example);

    int deleteByPrimaryKey(String id);

    int insert(MesInspUserPermissions record);

    int insertSelective(MesInspUserPermissions record);

    List<MesInspUserPermissions> selectByExample(MesInspUserPermissionsExample example);

    MesInspUserPermissions selectByPrimaryKey(String id);

    //List<MesInspUserPermissions> MesInspUserPermissions(String userId)

    int updateByExampleSelective(@Param("record") MesInspUserPermissions record, @Param("example") MesInspUserPermissionsExample example);

    int updateByExample(@Param("record") MesInspUserPermissions record, @Param("example") MesInspUserPermissionsExample example);

    int updateByPrimaryKeySelective(MesInspUserPermissions record);

    int updateByPrimaryKey(MesInspUserPermissions record);
}