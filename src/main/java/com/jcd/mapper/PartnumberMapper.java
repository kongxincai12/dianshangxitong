package com.jcd.mapper;

import com.jcd.model.Partnumber;
import org.apache.ibatis.annotations.Mapper;

@Mapper()
public interface PartnumberMapper {
    int deleteByPrimaryKey(String pnid);

    int insert(Partnumber record);

    int insertSelective(Partnumber record);

    Partnumber selectByPrimaryKey(String pnid);

    int updateByPrimaryKeySelective(Partnumber record);

    int updateByPrimaryKey(Partnumber record);
}