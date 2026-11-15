package com.jcd.mapper;

import com.jcd.model.Materialhistory;
import org.apache.ibatis.annotations.Mapper;

@Mapper()
public interface MaterialhistoryMapper {
    int deleteByPrimaryKey(String mhid);

    int insert(Materialhistory record);

    int insertSelective(Materialhistory record);

    Materialhistory selectByPrimaryKey(String mhid);

    int updateByPrimaryKeySelective(Materialhistory record);

    int updateByPrimaryKey(Materialhistory record);
}