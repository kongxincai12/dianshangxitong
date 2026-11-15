package com.jcd.mapper;

import com.jcd.model.Mlmappinginfo;
import com.jcd.model.MlmappinginfoExample;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper()
public interface MlmappinginfoMapper {
    int deleteByPrimaryKey(String mlmiid);

    int insert(Mlmappinginfo record);

    int insertSelective(Mlmappinginfo record);

    List<Mlmappinginfo> selectByExample(MlmappinginfoExample example);

    Mlmappinginfo selectByPrimaryKey(String mlmiid);
    List<Mlmappinginfo>  MlmappinginfoGetByPartnumber(String partnumber);
    List<Mlmappinginfo>  MlmappinginfoGetByPntype(String pntype);
    int updateByPrimaryKeySelective(Mlmappinginfo record);

    int updateByPrimaryKey(Mlmappinginfo record);
}