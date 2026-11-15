package com.jcd.controller;


import com.jcd.dto.*;
import com.jcd.mapper.MaterialModuleMapper;
import com.jcd.mapper.ProductionRecordMapper;
import com.jcd.model.Equipment;
import com.jcd.service.MesService;
import com.jcd.service.EquipmentTypeParamService;
import com.jcd.utils.Result;
import com.jcd.vo.ApiResponse;
import com.jcd.vo.ProductionRecordVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/mes")
public class MesServerController {

    @Autowired
    private MesService mesService;
    @Autowired
    private MaterialModuleMapper materialModuleMapper;
    @Autowired
    private EquipmentTypeParamService paramService;
    @Autowired
    private ProductionRecordMapper productionRecordMapper;


    @GetMapping("/latest-version")
    public Result<AppVersionDto> getLatestVersion(
            @RequestParam(defaultValue = "mes-pda-app") String appId,
            @RequestParam(defaultValue = "Android") String platform) {

        AppVersionDto latestVersion = mesService.getLatestVersion(appId, platform);

        // 即使没有找到版本信息，也返回成功，避免前端报错
        return Result.success(latestVersion);
    }

    /**
     * 获取生产记录列表
     * 【更新】增加了 site 参数
     */
    @GetMapping("/production/list")
    public ResponseEntity<ApiResponse<List<ProductionRecordVO>>> getProductionList(
            @RequestParam String employeeId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam String workType) { // 新增 site 参数
        List<ProductionRecordVO> list = mesService.findProductionRecords(employeeId, date, workType);
        return ResponseEntity.ok(ApiResponse.success(list));
    }

    /**
     * 根据设备编号或资产编号获取设备及其预设参数
     * @param equipmentId 前端扫描传入的设备号或资产编号
     * @return 设备参数信息
     */
    @GetMapping("/equipment/parameters")
    public Result<GetEquipmentParametersResponseDto> getEquipmentParameters(@RequestParam("equipmentId") String equipmentId) {
        GetEquipmentParametersResponseDto data = mesService.getEquipmentParameters(equipmentId);
        return Result.success(data);
    }

    /**
     * 按料号获取有效参数（优先级：料号参数 > 设备独立 > 类型默认）
     */
    @GetMapping("/equipment/parameters-with-product")
    public Result<GetEquipmentParametersResponseDto> getEquipmentParametersWithProduct(
            @RequestParam("equipmentId") String equipmentId,
            @RequestParam("productCode") String productCode) {
        GetEquipmentParametersResponseDto data =
                mesService.getEquipmentParametersWithProduct(equipmentId, productCode);
        return Result.success(data);
    }

    /**
     * 获取当班最近一次该设备+料号的参数值（用于按班次自动回填）
     */
    @GetMapping("/equipment/latest-shift-params")
    public Result<Map<String, String>> getLatestShiftParams(
            @RequestParam("equipmentId") String equipmentId,
            @RequestParam("productCode") String productCode) {
        Map<String, String> latestValues =
                mesService.getLatestShiftParams(equipmentId, productCode);
        return Result.success(latestValues);
    }



    @GetMapping("/equipment-type-params/{eqpTypeId}")
    public Result<List<EquipmentTypeParamDto>> getParamsByEqpTypeId(@PathVariable String eqpTypeId) {
        return Result.success(paramService.findEnabledByEqpTypeId(eqpTypeId));
    }

    /*@GetMapping("/equipment-type-params/all/{eqpTypeId}")
    public Result<List<EquipmentTypeParamDto>> getAllParamsByEqpTypeId(@PathVariable String eqpTypeId) {
        return Result.success(paramService.findAllByEqpTypeId(eqpTypeId));
    }*/

    /*@PostMapping("/equipment-type-params")
    public Result<?> createParam(@RequestBody EquipmentTypeParamDto dto) {
        paramService.create(dto);
        return Result.success(null);
    }*/

    /*@PutMapping("/equipment-type-params/{paramId}")
    public Result<?> updateParam(@PathVariable String paramId, @RequestBody EquipmentTypeParamDto dto) {
        dto.setId(paramId);
        paramService.update(dto);
        return Result.success(null);
    }*/

    /*@DeleteMapping("/equipment-type-params/{paramId}")
    public Result<?> deleteParam(@PathVariable String paramId) {
        paramService.delete(paramId);
        return Result.success(null);
    }*/

    @GetMapping("/equipment-types")
    public Result<List<EquipmentTypeDto>> getAllEquipmentTypes() {
        return Result.success(paramService.findAll());
    }

    /**
     * 根据关键词模糊搜索设备
     *
     * @param keyword 搜索关键词 (设备编号或名称)
     * @return 设备列表
     */
    @GetMapping("/equipments/search/{keyword}")
    public Result<List<Equipment>> searchEquipments(@PathVariable String keyword) {
        return Result.success(paramService.searchEquipmentsByKeyword(keyword));
    }

    /**
     * 获取指定设备类型的所有参数（供后台维护使用）
     */
    @GetMapping("/equipments/by-type/{eqpTypeId}")
    public Result<List<EquipmentTypeParamDto>> getAllParamsByEqpTypeId(@PathVariable String eqpTypeId) {
        return Result.success(paramService.findAllByEqpTypeId(eqpTypeId));
    }

    /**
     * 创建新的设备参数 (自动生成param_key)
     */
    @PostMapping("/equipments/createparam")
    public Result<EquipmentTypeParamDto> createParam(@RequestBody EquipmentTypeParamDto paramDto) {
        paramService.createParamV2(paramDto);
        return Result.success(null);
    }

    /**
     * 更新设备参数
     */
    @PostMapping("/equipments/createparam/{id}")
    public Result<EquipmentTypeParamDto> updateParam(@PathVariable String id, @RequestBody EquipmentTypeParamDto paramDto) {
        paramDto.setId(id);

        return Result.success(paramService.updateParam(paramDto));
    }

    /**
     * 删除设备参数
     */
    @PostMapping("/equipments/deleteparam/{id}")
    public Result<?> deleteParam(@PathVariable String id) {
        paramService.deleteParam(id);
        return Result.success(id);
    }



    @PostMapping("/lot/check")
    public Result<LotInfoDto> checkLot(@RequestBody Map<String, String> payload) {
        String lotCode = payload.get("lotCode");
        LotInfoDto lotInfo = mesService.checkLot(lotCode);

        // 判断是否包含 "SMT"
        //boolean contains = lotCode.contains("SMT");
        //if (contains) {
            //获取标准产能
            int standardCapacity=mesService.selectStandardCapacitySMT(lotInfo.getProduct());
            //lotInfo.setStandardCapacity(standardCapacity);
            //System.out.println("字符串包含 SMT");
        //}
        //else {
            if(standardCapacity==0){
                //获取标准产能
                standardCapacity=mesService.selectStandardCapacity(lotInfo.getProduct());
            }
            lotInfo.setStandardCapacity(standardCapacity);
            //System.out.println("字符串不包含 SMT");
        //}
        return Result.success(lotInfo);
    }


    @PostMapping("/material/check")
    public Result<Boolean> checkMaterial(@RequestBody Map<String, String> payload) {
        String materialCode = payload.get("materialCode");
        String lotCode = payload.get("lotCode");
        mesService.checkMaterial(materialCode,lotCode);
        // 如果service层没有抛出异常，就代表校验成功
        return Result.success(true);
    }
    @PostMapping("/material/add")
    public Result<?> addMaterialToRecord(@RequestBody AddMaterialRequest request) {
        mesService.addMaterialToRecord(request);
        return Result.success(request);
    }
    @PostMapping("/material/remove")
    public Result<?> removeMaterialFromRecord(@RequestBody RemoveMaterialRequest request) {
        mesService.removeMaterialFromRecord(request);
        return Result.success(request);
    }

    @PostMapping("/workstation/check")
    public Result<WorkstationDto> checkWorkstation(@RequestBody Map<String, String> payload) {
        String workstationCode = payload.get("workstationCode");
        WorkstationDto dto = mesService.checkWorkstation(workstationCode);
        return Result.success(dto);
    }


    @GetMapping("/production/detail/{recordId}")
    public Result<ProductionRecordDetailVO> getProductionRecordDetail(@PathVariable("recordId") String recordId) {
        ProductionRecordDetailVO recordDetail = mesService.getProductionRecordDetail(recordId);
        return Result.success(recordDetail);
    }



    /**
     * 新增设备作业记录
     * @param recordDto 前端提交的作业数据
     * @return 成功响应
     */
    @PostMapping("/production/equipment/add")
    public Result<java.util.Map<String, String>> addEquipmentProduction(@RequestBody AddProductionRecordDto recordDto) {
        String recordId = mesService.addEquipmentProduction(recordDto);
        java.util.Map<String, String> data = new java.util.HashMap<>();
        data.put("recordId", recordId);
        return Result.success(data);
    }

    /**
     * 查询同一工单、同一工序站点已占用和剩余的 PNL。
     */
    @PostMapping("/production/quota")
    public Result<ProductionQuotaDto> getProductionQuota(@RequestBody Map<String, String> payload) {
        return Result.success(mesService.getProductionQuota(
                payload.get("lotCode"), payload.get("equipmentId"),
                payload.get("stationId"), payload.get("lotSite")));
    }

    @PostMapping("/production/manual/add")
    public Result<?> addManualProduction(@RequestBody ManualProductionAddDto dto) {
        mesService.addManualProduction(dto);
        return Result.success(null);
    }

    /**
     * 结束生产任务
     * @param taskDto 包含记录ID和最终数量
     * @return 成功响应
     */
    @PostMapping("/production/end")
    public Result<?> endProductionTask(@RequestBody EndProductionTaskDto taskDto) {
        mesService.endProductionTask(taskDto);
        return Result.success(null);
    }

    // ════════════════════════════════════════════════════════════════════
    // 【新增】设备作业 - 批量录入 / 一键结束 / 批量详情
    // ════════════════════════════════════════════════════════════════════

    /**
     * 设备作业批量录入：同员工/设备/参数，N 个料号相同的批次一次性提交
     * @return data: { batchGroupId }
     */
    @PostMapping("/production/equipment/add-batch")
    public Result<java.util.Map<String, String>> addEquipmentProductionBatch(
            @RequestBody com.jcd.dto.AddProductionBatchDto dto) {
        String batchGroupId = mesService.addEquipmentProductionBatch(dto);
        java.util.Map<String, String> data = new java.util.HashMap<>();
        data.put("batchGroupId", batchGroupId);
        return Result.success(data);
    }

    /**
     * 一键结束批量任务
     */
    @PostMapping("/production/end-batch")
    public Result<?> endProductionTaskBatch(@RequestBody com.jcd.dto.EndProductionBatchDto dto) {
        mesService.endProductionTaskBatch(dto);
        return Result.success(null);
    }

    /**
     * 获取批量任务详情（按 batchGroupId）
     */
    @GetMapping("/production/batch-detail/{batchGroupId}")
    public Result<com.jcd.vo.BatchProductionDetailVO> getBatchProductionDetail(
            @PathVariable String batchGroupId) {
        return Result.success(mesService.getBatchProductionDetail(batchGroupId));
    }

    /**
     * 为指定设备创建一套独立的参数 (基于其类型默认参数)
     * @param eqpId 设备ID
     * @return 创建后的独立参数列表
     */
    @GetMapping("/params/maintenance-params/{eqpId}")
    public Result<ParamMaintenanceDto> getEffectiveParamsForMaintenance(@PathVariable String eqpId) {
        return Result.success(paramService.getEffectiveParamsForMaintenance(eqpId));
    }

    /**
     * 为指定设备创建一套独立的参数 (基于其类型默认参数)
     * @param eqpId 设备ID
     * @return 创建后的独立参数列表
     */
    @PostMapping("/params/create-override/{eqpId}")
    public Result<List<ParamOverrideDto>> createOverrideFromDefault(@PathVariable String eqpId) {
        return Result.success(paramService.createOverrideFromDefault(eqpId));
    }

    /**
     * 删除指定设备的所有独立参数，使其恢复为默认
     * @param eqpId 设备ID
     */
    @PostMapping("/params/revert-to-default/{eqpId}")
    public Result<?> revertToDefault(@PathVariable String eqpId) {
        paramService.revertToDefault(eqpId);
        return Result.success(null);
    }

    // 针对 Override 表的 CRUD
    @PostMapping("/params/override")
    public Result<ParamOverrideDto> createOverrideParam(@RequestBody ParamOverrideDto dto) {
        return Result.success(paramService.createOverrideParam(dto));
    }

    @PostMapping("/params/overrideupdate/{id}")
    public Result<ParamOverrideDto> updateOverrideParam(@PathVariable String id, @RequestBody ParamOverrideDto dto) {
        dto.setId(id);
        return Result.success(paramService.updateOverrideParam(dto));
    }

    @PostMapping("/params/overridedelete/{id}")
    public Result<?> deleteOverrideParam(@PathVariable String id) {
        paramService.deleteOverrideParam(id);
        return Result.success(null);
    }


    @GetMapping("insp/records/init-data")
    public Result<LotScanResponseDto> getInitDataForInspection(@RequestParam String site, @RequestParam String lotCode) {
        LotScanResponseDto data = mesService.getDataForLotScan(site, lotCode);
        return Result.success(data);
    }

    /**
     * 保存或更新一条检测记录 (草稿状态)
     * 如果 DTO 中 id 为 null, 则为新增；否则为更新。
     * @param recordDto 从前端提交的检测记录数据
     * @param request   用于获取当前操作员的工号
     * @return 保存后的检测记录
     */
    @PostMapping("insp/records/save-draft")
    public Result<InspectionRecordDto> saveOrUpdateDraft(@RequestBody InspectionRecordDto recordDto, HttpServletRequest request) {
        String employeeId = (String) request.getAttribute("current_employee_id");
        InspectionRecordDto savedRecord = mesService.saveOrUpdateDraft(recordDto, employeeId);
        return Result.success(savedRecord);
    }

    /**
     * 提交一条检测记录以供审批
     * @param recordId  要提交的记录ID
     * @param request   用于获取当前操作员的工号
     * @return 更新状态后的检测记录
     */
    @PostMapping("insp/records/submit/{recordId}")
    public Result<InspectionRecordDto> submitForApproval(@PathVariable String recordId, HttpServletRequest request) {
        String employeeId = (String) request.getAttribute("current_employee_id");
        InspectionRecordDto submittedRecord = mesService.submitForApproval(recordId, employeeId);
        return Result.success(submittedRecord);
    }

    //新增修理记录
    @PostMapping("/production/repair/add")
    public Result<?> addRepairProduction(@RequestBody RepairProductionAddDto dto) {
        mesService.addRepairProduction(dto);
        return Result.success(null);
    }

    //通过批次查找修理相关数据
    @PostMapping("/production/repair/search")
    public Result<RepairProductionAddDto> searchRepairProduction(@RequestBody RepairProductionAddDto dto) {
        RepairProductionAddDto repairData=null;
        try
        {
            repairData=mesService.searchRepairProduction(dto);
        }
        catch(Exception e){
            System.out.println("Error occurred while searching repair production: " + e.getMessage());
        }

        return Result.success(repairData);
    }

    //获取当前可录入批次最大数量
    @PostMapping("/lot/repair_check")
    public Result<LotInfoDto> checkRepairQty(@RequestBody Map<String, String> payload) {
        String lotCode = payload.get("lotCode");
        LotInfoDto lotInfo = mesService.checkLot(lotCode);

        RepairProductionAddDto inputQty = null;
        try {
            inputQty = productionRecordMapper.searchLotInfo(lotCode);
        } catch (Exception e) {
            inputQty = new RepairProductionAddDto();
            inputQty.setTotalQty(0);
        }
        java.math.BigDecimal wip = lotInfo.getWipQty() == null ? java.math.BigDecimal.ZERO : lotInfo.getWipQty();
        int totalQty = inputQty == null ? 0 : inputQty.getPcs();
        java.math.BigDecimal diff = wip.subtract(java.math.BigDecimal.valueOf(totalQty));
        lotInfo.setWipQty(diff);
        return Result.success(lotInfo);
    }

}
