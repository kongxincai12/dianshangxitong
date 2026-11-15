package com.jcd.mapper;

import com.jcd.model.MesInspDefectItems;
import com.jcd.model.MesInspDefectItemsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesInspDefectItemsMapper {
    int countByExample(MesInspDefectItemsExample example);

    int deleteByExample(MesInspDefectItemsExample example);

    int deleteByPrimaryKey(String id);

    int insert(MesInspDefectItems record);

    int insertSelective(MesInspDefectItems record);

    List<MesInspDefectItems> selectByExample(MesInspDefectItemsExample example);

    MesInspDefectItems selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MesInspDefectItems record, @Param("example") MesInspDefectItemsExample example);

    int updateByExample(@Param("record") MesInspDefectItems record, @Param("example") MesInspDefectItemsExample example);

    int updateByPrimaryKeySelective(MesInspDefectItems record);

    int updateByPrimaryKey(MesInspDefectItems record);
}