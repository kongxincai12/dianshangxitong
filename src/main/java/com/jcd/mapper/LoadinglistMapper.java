package com.jcd.mapper;

import com.jcd.model.Loadinglist;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper()
public interface LoadinglistMapper {
    int deleteByPrimaryKey(String llid);

    int insert(Loadinglist record);

    int insertSelective(Loadinglist record);

    Loadinglist selectByPrimaryKey(String llid);
    List<Loadinglist> selectByProductname(String productpn);

    int updateByPrimaryKeySelective(Loadinglist record);

    int updateByPrimaryKey(Loadinglist record);
}