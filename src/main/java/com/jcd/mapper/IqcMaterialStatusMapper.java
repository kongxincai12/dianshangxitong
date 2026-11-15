package com.jcd.mapper;

import com.jcd.model.IqcMaterialStatus;
import com.jcd.model.IqcMaterialStatusExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper()
public interface IqcMaterialStatusMapper {
    int countByExample(IqcMaterialStatusExample example);

    int deleteByExample(IqcMaterialStatusExample example);

    int deleteByPrimaryKey(String statusid);

    int insert(IqcMaterialStatus record);

    int insertSelective(IqcMaterialStatus record);

    List<IqcMaterialStatus> selectByExample(IqcMaterialStatusExample example);

    IqcMaterialStatus selectByPrimaryKey(String statusid);
    IqcMaterialStatus selectByStatus(String status);

    int updateByExampleSelective(@Param("record") IqcMaterialStatus record, @Param("example") IqcMaterialStatusExample example);

    int updateByExample(@Param("record") IqcMaterialStatus record, @Param("example") IqcMaterialStatusExample example);

    int updateByPrimaryKeySelective(IqcMaterialStatus record);

    int updateByPrimaryKey(IqcMaterialStatus record);
}