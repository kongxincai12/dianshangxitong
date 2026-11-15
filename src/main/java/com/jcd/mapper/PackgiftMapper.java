package com.jcd.mapper;

import com.jcd.model.Packgift;
import org.apache.ibatis.annotations.Mapper;

@Mapper()
public interface PackgiftMapper {
    int deleteByPrimaryKey(String giftid);

    int insert(Packgift record);

    int insertSelective(Packgift record);

    Packgift selectByPrimaryKey(String giftid);

    int updateByPrimaryKeySelective(Packgift record);

    int updateByPrimaryKey(Packgift record);
}