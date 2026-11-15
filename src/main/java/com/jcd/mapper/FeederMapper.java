package com.jcd.mapper;

import com.jcd.model.Feeder;
import com.jcd.model.FeederExample;
import org.apache.ibatis.annotations.Mapper;


import java.util.List;
@Mapper()
public interface FeederMapper {
    int deleteByPrimaryKey(String feederid);

    int insert(Feeder record);

    int insertSelective(Feeder record);

    List<Feeder> selectByExample(FeederExample example);
    List<Feeder> GetFeederByFeedername(String feeder);

    Feeder selectByPrimaryKey(String feederid);

    int updateByPrimaryKeySelective(Feeder record);

    int updateByPrimaryKey(Feeder record);
}