package com.jcd.mapper;

import com.jcd.model.Workorder;
import com.jcd.model.WorkorderExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper()
public interface WorkorderMapper {
    int deleteByPrimaryKey(String orderid);

    int insert(Workorder record);

    int insertSelective(Workorder record);

    List<Workorder> selectByExample(WorkorderExample example);

    List<Workorder> selectByPrimaryKey(String orderid);

    int updateByExampleSelective(@Param("record") Workorder record, @Param("example") WorkorderExample example);

    int updateByExample(@Param("record") Workorder record, @Param("example") WorkorderExample example);

    int updateByPrimaryKeySelective(Workorder record);

    int updateWorkorderStatus(String state,String orderid);

    int updateByPrimaryKey(Workorder record);
}