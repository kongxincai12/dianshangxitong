package com.jcd.service;

import com.jcd.dto.*;
import com.jcd.model.Prp_lot;
import com.jcd.vo.BatchProductionDetailVO;
import com.jcd.vo.ProductionRecordVO;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface MesService {
     List<Prp_lot> lotfindbyLotname(String lotname);

     List<String> findDefectNamesBySite(String siteName);

     void saveLqcRecord(LqcRecordDto recordDto, String username);

     List<TaskDto> getTasksForUser(String userRole, String date);

     List<ProcessDto> getProcessList();
     ApprovalDataDto getApprovalData(String date, String site, String shift);
     void confirmRecords(String date, String site, String shift, String currentTaskStatus, String newStatus, String username);

     /** 【新增】获取检验数据（可能是新的或已存在的） */
     InspectionDataDto getInspectionData(String date, String shift, String lotnamem,String site);

     /** 【修改】将 saveLqcRecord 重命名并升级为 upsertLqcRecord */
     void upsertLqcRecord(LqcRecordDto recordDto, String username);

     List<ProductionRecordVO> findProductionRecords(String employeeId, LocalDate date, String workType);

     //EquipmentParametersDto getEquipmentParameters(String equipmentIdentifier);
    GetEquipmentParametersResponseDto getEquipmentParameters(String equipmentIdentifier);
    LotInfoDto checkLot(String lotCode);

    void checkMaterial(String materialCode,String lotCode);

    String addEquipmentProduction(AddProductionRecordDto recordDto);
    ProductionQuotaDto getProductionQuota(String lotCode, String equipmentId, String stationId, String lotSite);
    void endProductionTask(EndProductionTaskDto taskDto);
    ProductionRecordDetailVO getProductionRecordDetail(String recordId);

    /** 【新增】设备作业批量录入，返回 batchGroupId */
    String addEquipmentProductionBatch(AddProductionBatchDto dto);

    /** 【新增】按 batchGroupId 一键结束任务 */
    void endProductionTaskBatch(EndProductionBatchDto dto);

    /** 【新增】按 batchGroupId 获取批量任务详情 */
    BatchProductionDetailVO getBatchProductionDetail(String batchGroupId);

    WorkstationDto checkWorkstation(String workstationCode);

    void addManualProduction(ManualProductionAddDto dto);

    AppVersionDto getLatestVersion(String appId, String platform);

    void addMaterialToRecord(AddMaterialRequest request);

    void removeMaterialFromRecord(RemoveMaterialRequest request);

    UserPermissionInfoDto getUserPermissions(String employeeId);

    /**
     * 按料号获取有效参数（优先级：料号参数 > 设备独立 > 类型默认）
     */
    GetEquipmentParametersResponseDto getEquipmentParametersWithProduct(String equipmentId, String productCode);

    /**
     * 获取当班最近一次参数录入值（用于按班次自动回填）
     */
    Map<String, String> getLatestShiftParams(String equipmentId, String productCode);

    LotScanResponseDto getDataForLotScan(String site, String lotCode);
    InspectionRecordDto saveOrUpdateDraft(InspectionRecordDto recordDto, String operatorId);
    InspectionRecordDto submitForApproval(String recordId, String operatorId);

    public int selectStandardCapacity(String modelName);

    public int selectStandardCapacitySMT(String modelName);

    void addRepairProduction(RepairProductionAddDto dto);

    RepairProductionAddDto searchRepairProduction(RepairProductionAddDto dto);
}
