package com.jcd.mapper.qafa;

import com.jcd.model.qafa.QaFaStageResult;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QaFaStageResultMapper {

    int insert(QaFaStageResult result);

    int updateSelective(QaFaStageResult result);

    int deleteByRecordId(@Param("recordId") String recordId);

    List<QaFaStageResult> selectByRecordId(@Param("recordId") String recordId);

    QaFaStageResult selectByRecordAndStage(@Param("recordId") String recordId,
                                           @Param("stageCode") String stageCode);
}
