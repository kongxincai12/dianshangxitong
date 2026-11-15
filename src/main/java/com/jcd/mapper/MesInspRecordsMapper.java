package com.jcd.mapper;

import com.jcd.model.MesInspRecords;
import com.jcd.model.MesInspRecordsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesInspRecordsMapper {
    int countByExample(MesInspRecordsExample example);

    int deleteByExample(MesInspRecordsExample example);

    int deleteByPrimaryKey(String id);

    int insert(MesInspRecords record);

    int insertSelective(MesInspRecords record);

    List<MesInspRecords> selectByExample(MesInspRecordsExample example);

    MesInspRecords selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MesInspRecords record, @Param("example") MesInspRecordsExample example);

    int updateByExample(@Param("record") MesInspRecords record, @Param("example") MesInspRecordsExample example);

    int updateByPrimaryKeySelective(MesInspRecords record);

    int updateByPrimaryKey(MesInspRecords record);
}