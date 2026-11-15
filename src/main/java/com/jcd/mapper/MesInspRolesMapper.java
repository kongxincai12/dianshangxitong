package com.jcd.mapper;

import com.jcd.model.MesInspRoles;
import com.jcd.model.MesInspRolesExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesInspRolesMapper {
    int countByExample(MesInspRolesExample example);

    int deleteByExample(MesInspRolesExample example);

    int deleteByPrimaryKey(String id);

    int insert(MesInspRoles record);

    int insertSelective(MesInspRoles record);

    List<MesInspRoles> selectByExample(MesInspRolesExample example);

    MesInspRoles selectByPrimaryKey(String id);
    MesInspRoles findUserByEmployeeId(String employeeId);

    int updateByExampleSelective(@Param("record") MesInspRoles record, @Param("example") MesInspRolesExample example);

    int updateByExample(@Param("record") MesInspRoles record, @Param("example") MesInspRolesExample example);

    int updateByPrimaryKeySelective(MesInspRoles record);

    int updateByPrimaryKey(MesInspRoles record);
}