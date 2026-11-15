package com.jcd.mapper;

import com.jcd.model.MesInspDefectItems;
import com.jcd.model.MesInspRecordDetails;
import com.jcd.model.MesInspRecords;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper()
public interface InspectionMapper {
    List<MesInspDefectItems> findBySite(@Param("site") String site);
    /**
     * 对应 <insert id="insertRecord">
     *
     * @param record 对应的 parameterType="com.jcd.model.MesInspRecords"
     * @return 影响的行数
     */
    int insertRecord(MesInspRecords record);

    /**
     * 对应 <update id="updateRecord">
     *
     * @param record 对应的 parameterType="com.jcd.model.MesInspRecords"
     * @return 影响的行数
     */
    int updateRecord(MesInspRecords record);

    /**
     * 对应 <select id="findRecordById">
     *
     * @param id 对应的 #{id}
     * @return 单个巡检记录
     */
    MesInspRecords findRecordById(@Param("id") String id);

    /**
     * 对应 <delete id="deleteByRecordId">
     *
     * @param recordId 对应的 #{recordId}
     * @return 影响的行数
     */
    int deleteByRecordId(@Param("recordId") String recordId);

    /**
     * 对应 <insert id="batchInsert">
     *
     * @param details 对应 <foreach collection="details" ...>
     * @return 影响的行数
     */
    int batchInsert(@Param("details") List<MesInspRecordDetails> details);

    /**
     * 对应 <select id="findByRecordId">
     *
     * @param recordId 对应的 #{recordId}
     * @return 巡检记录详情列表
     */
    List<MesInspRecordDetails> findByRecordId(@Param("recordId") String recordId);
}
