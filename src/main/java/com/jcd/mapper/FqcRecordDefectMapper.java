package com.jcd.mapper;

import com.jcd.model.FqcRecordDefect;

import java.util.List;

public interface FqcRecordDefectMapper {

    int insertSelective(FqcRecordDefect record);

    int updateByPrimaryKeySelective(FqcRecordDefect record);

    List<FqcRecordDefect> selectByRecordId(String recordId);

    int deleteByRecordId(String recordId);

    Long sumDefectQtyByRecordId(String recordId);
}
