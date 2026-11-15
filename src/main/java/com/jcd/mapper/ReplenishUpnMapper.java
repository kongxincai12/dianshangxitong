package com.jcd.mapper;

import com.jcd.model.ReplenishUpn;
import org.apache.ibatis.annotations.Mapper;

@Mapper()
public interface ReplenishUpnMapper {
    int deleteByPrimaryKey(String replenishupnid);

    int insert(ReplenishUpn record);

    int insertSelective(ReplenishUpn record);

    ReplenishUpn selectByPrimaryKey(String replenishupnid);

    int updateByPrimaryKeySelective(ReplenishUpn record);

    int updateByPrimaryKey(ReplenishUpn record);
}