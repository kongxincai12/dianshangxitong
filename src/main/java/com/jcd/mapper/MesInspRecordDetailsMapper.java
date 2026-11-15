package com.jcd.mapper;

import com.jcd.model.MesInspRecordDetails;
import com.jcd.model.MesInspRecordDetailsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MesInspRecordDetailsMapper {
    int countByExample(MesInspRecordDetailsExample example);

    int deleteByExample(MesInspRecordDetailsExample example);

    int deleteByPrimaryKey(String id);

    int insert(MesInspRecordDetails record);

    int insertSelective(MesInspRecordDetails record);

    List<MesInspRecordDetails> selectByExample(MesInspRecordDetailsExample example);

    MesInspRecordDetails selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MesInspRecordDetails record, @Param("example") MesInspRecordDetailsExample example);

    int updateByExample(@Param("record") MesInspRecordDetails record, @Param("example") MesInspRecordDetailsExample example);

    int updateByPrimaryKeySelective(MesInspRecordDetails record);

    int updateByPrimaryKey(MesInspRecordDetails record);
}