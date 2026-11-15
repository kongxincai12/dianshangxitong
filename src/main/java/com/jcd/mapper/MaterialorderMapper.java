package com.jcd.mapper;

import com.jcd.model.Materialorder;
import org.apache.ibatis.annotations.Mapper;

@Mapper()
public interface MaterialorderMapper {

    int deleteByPrimaryKey(String moid);

    int insert(Materialorder record);

    int insertSelective(Materialorder record);

    Materialorder selectByPrimaryKey(String moid);

    int updateByPrimaryKeySelective(Materialorder record);

    int updateByPrimaryKey(Materialorder record);
}