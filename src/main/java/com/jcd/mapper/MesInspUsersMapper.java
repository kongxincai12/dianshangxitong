package com.jcd.mapper;

import com.jcd.model.MesInspUsers;
import com.jcd.model.MesInspUsersExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesInspUsersMapper {
    int countByExample(MesInspUsersExample example);

    int deleteByExample(MesInspUsersExample example);

    int deleteByPrimaryKey(String id);

    int insert(MesInspUsers record);

    int insertSelective(MesInspUsers record);

    List<MesInspUsers> selectByExample(MesInspUsersExample example);

    MesInspUsers selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MesInspUsers record, @Param("example") MesInspUsersExample example);

    int updateByExample(@Param("record") MesInspUsers record, @Param("example") MesInspUsersExample example);

    int updateByPrimaryKeySelective(MesInspUsers record);

    int updateByPrimaryKey(MesInspUsers record);
}