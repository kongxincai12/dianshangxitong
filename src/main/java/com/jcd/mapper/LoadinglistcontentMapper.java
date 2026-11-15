package com.jcd.mapper;

import com.jcd.model.Loadinglistcontent;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper()
public interface LoadinglistcontentMapper {
    int deleteByPrimaryKey(String llcid);

    int insert(Loadinglistcontent record);

    int insertSelective(Loadinglistcontent record);

    List<Loadinglistcontent> selectByPrimaryKey(String llcid);
    List<Loadinglistcontent> selectByPrimaryKeyLlid(String llid);

    int updateByPrimaryKeySelective(Loadinglistcontent record);

    int updateByPrimaryKey(Loadinglistcontent record);
}