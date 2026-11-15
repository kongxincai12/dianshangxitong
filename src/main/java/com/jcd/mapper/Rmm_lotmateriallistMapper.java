package com.jcd.mapper;

import com.jcd.model.Rmm_lotmateriallist;
import org.apache.ibatis.annotations.Mapper;

@Mapper()
public interface Rmm_lotmateriallistMapper {
    int deleteByPrimaryKey(String lmid);

    int insert(Rmm_lotmateriallist record);

    int insertSelective(Rmm_lotmateriallist record);

    Rmm_lotmateriallist selectByPrimaryKey(String lmid);
    Rmm_lotmateriallist selectByLotAndPn(String lotname, String pn);

    int updateByPrimaryKeySelective(Rmm_lotmateriallist record);

    int updateByPrimaryKey(Rmm_lotmateriallist record);
}