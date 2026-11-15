package com.jcd.mapper;

import com.jcd.model.Rmm_upnprint;
import org.apache.ibatis.annotations.Mapper;

@Mapper()
public interface Rmm_upnprintMapper {
    int deleteByPrimaryKey(String printid);

    int insert(Rmm_upnprint record);

    int insertSelective(Rmm_upnprint record);

    Rmm_upnprint selectByPrimaryKey(String printid);

    int updateByPrimaryKeySelective(Rmm_upnprint record);

    int updateByPrimaryKey(Rmm_upnprint record);
}