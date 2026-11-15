package com.jcd.mapper;

import com.jcd.model.LqcRecord;
import com.jcd.model.LqcRecordExample;

import java.util.Date;
import java.util.List;

import com.jcd.vo.ApprovalRecordVo;
import com.jcd.vo.GroupTaskStatusVo;
import com.jcd.vo.TaskStatusVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper()
public interface LqcRecordMapper {
    int deleteByPrimaryKey(String id);

    int insert(LqcRecord record);

    int insertSelective(LqcRecord record);

    List<LqcRecord> selectByExample(LqcRecordExample example);

    LqcRecord selectByPrimaryKey(String id);

    List<GroupTaskStatusVo> findGroupTaskStatusByDate(@Param("checkDate") Date checkDate);

    List<TaskStatusVo> findTaskStatusByDate(@Param("checkDate") Date checkDate);

    LqcRecord findByUniqueKey(@Param("checkDate") Date checkDate,
                              @Param("shift") String shift,
                              @Param("lotName") String lotName,
                              @Param("site") String site);

    int update(LqcRecord record);
    List<ApprovalRecordVo> findApprovalRecords(@Param("checkDate") Date checkDate,
                                               @Param("siteName") String siteName,
                                               @Param("shift") String shift);

    /**
     * 【新增方法】根据条件批量更新记录的状态
     */
    int updateStatusByCondition(@Param("checkDate") Date checkDate,
                                @Param("siteName") String siteName,
                                @Param("shift") String shift,
                                @Param("currentStatus") String currentStatus,
                                @Param("newStatus") String newStatus,
                                @Param("confirmer") String confirmer,
                                @Param("confirmDate") Date confirmDate);

    int updateByExampleSelective(@Param("record") LqcRecord record, @Param("example") LqcRecordExample example);

    int updateByExample(@Param("record") LqcRecord record, @Param("example") LqcRecordExample example);

    int updateByPrimaryKeySelective(LqcRecord record);

    int updateByPrimaryKey(LqcRecord record);
}