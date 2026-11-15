package com.jcd.mapper;

import com.jcd.model.LqcRecordDetail;
import com.jcd.model.LqcRecordDetailExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper()
public interface LqcRecordDetailMapper {
    int deleteByPrimaryKey(String id);

    int insert(LqcRecordDetail record);

    int insertSelective(LqcRecordDetail record);

    List<LqcRecordDetail> selectByExample(LqcRecordDetailExample example);

    LqcRecordDetail selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") LqcRecordDetail record, @Param("example") LqcRecordDetailExample example);

    int updateByExample(@Param("record") LqcRecordDetail record, @Param("example") LqcRecordDetailExample example);

    int updateByPrimaryKeySelective(LqcRecordDetail record);

    int updateByPrimaryKey(LqcRecordDetail record);
    /** 【新增】根据主记录ID查询所有明细 */
    List<LqcRecordDetail> findByRecordId(@Param("recordId") String recordId);

    /** 【新增】根据主记录ID删除所有明细 */
    int deleteByRecordId(@Param("recordId") String recordId);
}