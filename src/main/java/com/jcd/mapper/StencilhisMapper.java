package com.jcd.mapper;

import com.jcd.model.Stencilhis;
import com.jcd.model.StencilhisExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper()
public interface StencilhisMapper {
    int deleteByPrimaryKey(String shid);

    int insert(Stencilhis record);

    int insertSelective(Stencilhis record);

    List<Stencilhis> selectByExample(StencilhisExample example);

    Stencilhis selectByPrimaryKey(String shid);

    List<Stencilhis> selectByUsedid(String usedid);

    int updateByExampleSelective(@Param("record") Stencilhis record, @Param("example") StencilhisExample example);

    int updateByExample(@Param("record") Stencilhis record, @Param("example") StencilhisExample example);

    int updateByPrimaryKeySelective(Stencilhis record);

    int updateByPrimaryKey(Stencilhis record);
}