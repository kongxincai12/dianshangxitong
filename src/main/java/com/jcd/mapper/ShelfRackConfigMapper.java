package com.jcd.mapper;

import com.jcd.model.ShelfRackConfig;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper()
public interface ShelfRackConfigMapper {

    int insert(ShelfRackConfig record);

    int insertSelective(ShelfRackConfig record);

    ShelfRackConfig selectByPrimaryKey(String configId);

    /**
     * 按料架编号查询配置（RACK_CODE唯一）
     */
    ShelfRackConfig selectByRackCode(String rackCode);

    /**
     * 查询所有启用的货架配置
     */
    List<ShelfRackConfig> selectAllActive();

    /**
     * 查询所有货架配置
     */
    List<ShelfRackConfig> selectAll();

    int updateByPrimaryKeySelective(ShelfRackConfig record);

    int deleteByPrimaryKey(String configId);
}
