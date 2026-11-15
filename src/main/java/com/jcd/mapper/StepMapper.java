package com.jcd.mapper;

import com.jcd.model.Step;
import com.jcd.model.StepExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper()
public interface StepMapper {
    int deleteByPrimaryKey(String stepid);

    int insert(Step record);

    int insertSelective(Step record);

    List<Step> selectByExampleWithBLOBs(StepExample example);

    List<Step> selectByExample(StepExample example);

    Step selectByPrimaryKey(String stepid);
    List<Step> selectByStepname(String Stepname);
    List<Step> selectByUsername(String Username);
    List<Step> selectByUsernameAll(String Username);

    int updateByExampleSelective(@Param("record") Step record, @Param("example") StepExample example);

    int updateByExampleWithBLOBs(@Param("record") Step record, @Param("example") StepExample example);

    int updateByExample(@Param("record") Step record, @Param("example") StepExample example);

    int updateByPrimaryKeySelective(Step record);

    int updateByPrimaryKeyWithBLOBs(Step record);

    int updateByPrimaryKey(Step record);
}