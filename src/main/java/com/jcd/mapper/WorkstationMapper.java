package com.jcd.mapper;

import com.jcd.model.Workstation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper()
public interface WorkstationMapper {
    //int countByExample(WorkstationExample example);

    //int deleteByExample(WorkstationExample example);

    int deleteByPrimaryKey(String id);

    int insert(Workstation record);

    int insertSelective(Workstation record);

    //List<Workstation> selectByExample(WorkstationExample example);

    Workstation selectByPrimaryKey(String id);

    //int updateByExampleSelective(@Param("record") Workstation record, @Param("example") WorkstationExample example);

    //int updateByExample(@Param("record") Workstation record, @Param("example") WorkstationExample example);

    int updateByPrimaryKeySelective(Workstation record);

    int updateByPrimaryKey(Workstation record);

    Workstation findByCode(@Param("workstationCode") String workstationCode);
}