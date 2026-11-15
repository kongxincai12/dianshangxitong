package com.jcd.mapper;

import com.jcd.dto.RepairProductionAddDto;
import com.jcd.model.ProductionRecord;
import com.jcd.model.RecordParameter;
import com.jcd.dto.ProductionRecordDetailVO;
import com.jcd.dto.ProductionAllocatedQtyDto;



import java.util.Date;
import java.util.List;
import java.util.Map;

import com.jcd.model.RecordMaterial;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper()
public interface ProductionRecordMapper {


    int deleteByPrimaryKey(String id);

    int insert(ProductionRecord record);

    int insertSelective(ProductionRecord record);


    ProductionRecord selectByPrimaryKey(String id);



    int updateByPrimaryKeySelective(ProductionRecord record);

    int updateByPrimaryKey(ProductionRecord record);

    List<ProductionRecord> findProductionRecords(
            @Param("employeeId") String employeeId,
            @Param("recordType") String recordType,
            @Param("startTimeFrom") Date startTimeFrom,
            @Param("startTimeTo") Date startTimeTo
    );

    /**
     * 【新增】根据ID查询主记录详情
     */
    ProductionRecordDetailVO findRecordDetailById(@Param("recordId") String recordId);

    /**
     * 【新增】根据记录ID查询物料列表
     */
    List<RecordMaterial> findMaterialsByRecordId(@Param("recordId") String recordId);

    /**
     * 【新增】根据记录ID查询参数列表
     */
    List<RecordParameter> findParametersByRecordId(@Param("recordId") String recordId);

    /**
     * 【新增】根据批次号查询panelPcs
     */
    Integer findPanelPcsByLotCode(@Param("lotCode") String lotCode);

        ProductionRecord findInprogressTaskByEmployee(String employeeId,String recordType);

    int insertProductionRecord(ProductionRecord record);

    /** 锁定生产批次行，串行化同一批次下多设备的数量占用。 */
    String lockProductionLot(@Param("lotCode") String lotCode);

    /** 查询同批次、同工序站点、同设备已占用的 PNL/PCS；手工作业按操作台独立统计。 */
    ProductionAllocatedQtyDto sumAllocatedQty(
            @Param("lotCode") String lotCode,
            @Param("stationId") String stationId,
            @Param("lotSite") String lotSite,
            @Param("equipmentId") String equipmentId,
            @Param("excludeRecordId") String excludeRecordId
    );

    /** 按客户端请求号查询已落库记录，用于幂等返回。 */
    List<ProductionRecord> findRecordsByRequestId(@Param("requestId") String requestId);

    /**
     * 【新增】按 batch_group_id 查询同组所有记录详情（含 productCode）
     */
    List<ProductionRecordDetailVO> findRecordsByBatchGroupId(@Param("batchGroupId") String batchGroupId);

    /**
     * 查询当班最近一条该设备+料号的生产记录的参数值
     */
    List<Map<String, String>> getLatestShiftParamValues(
            @Param("equipmentId") String equipmentId,
            @Param("productCode") String productCode,
            @Param("shiftStart") Date shiftStart,
            @Param("shiftEnd") Date shiftEnd
    );

    /**
     * 查询当班最近一条该设备+料号的生产记录的参数值
     */
    RepairProductionAddDto searchLotInfo(@Param("lotCode") String lotCode);
}
