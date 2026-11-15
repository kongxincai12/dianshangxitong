package com.jcd.mapper;

import com.jcd.model.Rmm_womateriallist;
import org.apache.ibatis.annotations.Mapper;

@Mapper()
public interface Rmm_womateriallistMapper {
    int deleteByPrimaryKey(String wmid);

    int insert(Rmm_womateriallist record);

    int insertSelective(Rmm_womateriallist record);

    Rmm_womateriallist selectByPrimaryKey(String wmid);

    int updateByPrimaryKeySelective(Rmm_womateriallist record);

    int updateByPrimaryKey(Rmm_womateriallist record);
}