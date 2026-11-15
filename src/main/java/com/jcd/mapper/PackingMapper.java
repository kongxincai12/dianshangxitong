package com.jcd.mapper;

import com.jcd.dto.AddPackingRecordDto;
import com.jcd.model.Equipment;
import com.jcd.model.ProductionRecord;
import com.jcd.model.RecordPacking;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;


@Mapper()
public interface PackingMapper {
    /**
     * 新增包装信息
     * @return 空
     */
    void insert(RecordPacking recordPacking);

    List<RecordPacking> findProductionPackingRecords(String employeeId, String site, Date startTimeFrom, Date startTimeTo);

    void deletePackingRecord(String id);

    void updatePackingRecord(RecordPacking recordPacking);

   AddPackingRecordDto findAddQtyByLot(@Param("LOTNAME")String LOTNAME);

    int selectStandardCapacity(String modelName);

    int selectStandardCapacitySMT(String modelName);
}
