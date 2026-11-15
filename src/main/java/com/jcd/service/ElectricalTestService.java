package com.jcd.service;

import com.jcd.dto.FqcDefectItemDto;
import com.jcd.dto.ElectricalTestRecordDto;
import com.jcd.dto.Hrdetail;
import com.jcd.mapper.*;
import com.jcd.model.CuxLowcodeFqcdirect;
import com.jcd.model.CuxLowcodeFqcdirectLine;
import com.jcd.model.ElectricalTestRecord;
import com.jcd.model.ElectricalTestRecordDefect;
import com.jcd.vo.ElectricalTestRecordVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.stream.Collectors;

public interface ElectricalTestService {

    /**
     * 检查员工是否有 电测检验 权限
     */
    boolean checkElectricalTestPermission(String employeeId);

    /**
     * 获取 电测检验 预设缺陷列表（DEFECTCODE 表中 IS_FQC=1 的记录）
     */
    List<Map<String, String>> getElectricalTestDefectPresets();

    /**
     * 获取 电测检验 已录入的工艺参数（ELECTRICAL_TEST_PARAMETERS 表中 IS_FQC=1 的记录）
     */
    List<Map<String, String>> getElectricalTestCraftParameters(String recordId);

    /**
     * 保存或更新 电测检验 记录（自动保存/草稿保存）
     */
    @Transactional
    ElectricalTestRecordVo saveOrUpdateElectricalTestRecord(ElectricalTestRecordDto dto, String inspectorId, String inspectorName);

    /**
     * 提交 电测检验 记录
     */
    @Transactional
    void submitElectricalTestRecord(String recordId, String inspectorId);

    /**
     * 撤回编辑（仅当天可撤回）
     */
    @Transactional
    void reopenElectricalTestRecord(String recordId, String inspectorId);

    /**
     * 删除 电测检验 记录（仅草稿可删）
     */
    @Transactional
    void deleteElectricalTestRecord(String recordId, String inspectorId);

    /**
     * 按批次号和日期查找记录（扫码查重）
     */
    List<ElectricalTestRecordVo> getRecordsByLotAndDate(String lotCode, Date inspDate) ;

    /**
     * 按检验员和日期查记录列表
     */
    List<ElectricalTestRecordVo> getElectricalTestRecordList(String inspectorId, Date inspDate);

    /**
     * 获取单条记录详情（含缺陷明细）
     */
    ElectricalTestRecordVo getElectricalTestRecordById(String recordId) ;

    /**
     * 将 Model 转为 VO（不含缺陷明细，列表查询用）
     */
    ElectricalTestRecordVo convertToVo(ElectricalTestRecord record) ;

    /**
     * 按批次的料号去ERP查询标准产能
     */
    int selectStandardCapacity(String modelName) ;

    boolean checkPotionPermission(String employeeId) ;

    /**
     * 更新 电测检验 记录
     */
    @Transactional
    void updatePunchingScrap(ElectricalTestRecordDto dto);

    /**
     * 按批次查询当前批次已录入的总数量
     */
    int getSumByLotCode(String lotCode,String recordId) ;

}
