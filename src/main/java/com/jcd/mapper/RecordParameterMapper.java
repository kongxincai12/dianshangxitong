package com.jcd.mapper;

import com.jcd.model.RecordParameter;
import com.jcd.model.RecordParameterExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper()
public interface RecordParameterMapper {
    int countByExample(RecordParameterExample example);

    int deleteByExample(RecordParameterExample example);

    int deleteByPrimaryKey(String id);

    int insert(RecordParameter record);

    int insertSelective(RecordParameter record);

    List<RecordParameter> selectByExample(RecordParameterExample example);

    RecordParameter selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") RecordParameter record, @Param("example") RecordParameterExample example);

    int updateByExample(@Param("record") RecordParameter record, @Param("example") RecordParameterExample example);

    int updateByPrimaryKeySelective(RecordParameter record);

    int updateByPrimaryKey(RecordParameter record);
}