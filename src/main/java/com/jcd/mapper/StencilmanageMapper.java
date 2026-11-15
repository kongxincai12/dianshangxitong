package com.jcd.mapper;

import com.jcd.model.Stencilmanage;
import com.jcd.model.StencilmanageExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper()
public interface StencilmanageMapper {
    int deleteByPrimaryKey(String stencilmanageid);

    int insert(Stencilmanage record);

    int insertSelective(Stencilmanage record);

    List<Stencilmanage> selectByExample(StencilmanageExample example);

    Stencilmanage selectByPrimaryKey(String stencilmanageid);

    List<Stencilmanage>  selectByUpnid(String upnid);

    int updateByExampleSelective(@Param("record") Stencilmanage record, @Param("example") StencilmanageExample example);

    int updateByExample(@Param("record") Stencilmanage record, @Param("example") StencilmanageExample example);

    int updateByPrimaryKeySelective(Stencilmanage record);

    int updateByPrimaryKey(Stencilmanage record);
}