package com.jcd.service.Impl;

import com.jcd.dto.ElectricalTestParameterDto;
import com.jcd.dto.FqcDefectItemDto;
import com.jcd.dto.ElectricalTestRecordDto;
import com.jcd.mapper.*;
import com.jcd.model.*;
import com.jcd.service.ElectricalTestService;
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

@Service
public class ElectricalTestServiceImpl implements ElectricalTestService {

    private static final Logger log = LoggerFactory.getLogger(ElectricalTestServiceImpl.class);

    @Autowired
    private ElectricalTestRecordMapper electricalTestRecordMapper;

    @Autowired
    private ElectricalTestRecordDefectMapper electricalTestRecordDefectMapper;

    @Autowired
    private PdaLineUserRelMapper pdaLineUserRelMapper;

    @Autowired
    private UserprofileMapper userprofileMapper;

    @Resource
    private Environment env;

    @Autowired
    private ElectricalTestParametersMapper electricalTestParametersMapper;


    /**
     * 检查员工是否有 电测检验 权限
     */
    public boolean checkElectricalTestPermission(String employeeId) {
        int count = electricalTestRecordMapper.checkElectricalPermission(employeeId);
        return count > 0;
    }

    /**
     * 获取 电测检验 预设缺陷列表（DEFECTCODE 表中 IS_FQC=1 的记录）
     */
    public List<Map<String, String>> getElectricalTestDefectPresets() {
        return electricalTestRecordMapper.selectElectricalTestDefectPresets();
    }

    /**
     * 获取 电测检验 已录入的工艺参数（ELECTRICAL_TEST_PARAMETERS 表中 IS_FQC=1 的记录）
     */
    public List<Map<String, String>> getElectricalTestCraftParameters(String recordId) {
        return electricalTestParametersMapper.selectElectricalTestCraftParameters(recordId);
    }

    /**
     * 保存或更新 电测检验 记录（自动保存/草稿保存）
     */
    @Override
    public ElectricalTestRecordVo saveOrUpdateElectricalTestRecord(ElectricalTestRecordDto dto, String inspectorId, String inspectorName) {
        //获取配置文件连接的数据库是SZ还是TS
        Boolean url =env.getProperty("spring.datasource.url").endsWith("szmes");

        Date now = new Date();
        String recordId = dto.getRecordId();

        if (recordId != null && !recordId.isEmpty()) {
            // 更新已有记录
            ElectricalTestRecord existing = electricalTestRecordMapper.selectByPrimaryKey(recordId);
            if (existing == null) {
                throw new RuntimeException("记录不存在: " + recordId);
            }
            if ("SUBMITTED".equals(existing.getStatus())) {
                throw new RuntimeException("已提交的记录不允许修改，请先撤回");
            }

            // 更新主记录字段
            ElectricalTestRecord update = new ElectricalTestRecord();
            update.setId(recordId);
            update.setLotCode(dto.getLotCode());
            update.setProductType(dto.getProductType());
            update.setModelName(dto.getModelName());
            update.setTotalQty(dto.getTotalQty());
            update.setGoodQty(dto.getGoodQty());
            update.setStandardCapacity(dto.getStandardCapacity());
            update.setOutputHours(dto.getOutputHours());
            update.setRemark(dto.getRemark());
            update.setUpdateTime(now);

            update.setPnlPcs(dto.getPnlPcs());
            update.setPnlTestTimes(dto.getPnlTestTimes());
            update.setCheckResult(dto.getCheckResult());
            update.setCheckExceptionResult(dto.getCheckExceptionResult());
            update.setCheckHandleResult(dto.getCheckHandleResult());
            update.setRetestPassQty(dto.getRetestPassQty());
            update.setPreStepDefectsqty(dto.getPreStepDefectsqty());
            update.setAddOpenWay(dto.getAddOpenWay());
            update.setAddShortWay(dto.getAddShortWay());
            //update.setPunchingScrapqty(dto.getPunchingScrapqty());
            //update.setIsfollow(dto.getIsfollow());
            update.setEqpCode(dto.getEqpCode());
            update.setEndDate(dto.getEndDate());
            electricalTestRecordMapper.updateByPrimaryKeySelective(update);

        } else {
            //通过工单的料号获取标准产能
            //int standardCapacity=electricalTestRecordMapper.selectStandardCapacity(dto.getModelName());
            // 新建记录
            recordId = UUID.randomUUID().toString().replace("-", "");
            ElectricalTestRecord record = new ElectricalTestRecord();
            record.setId(recordId);
            record.setLotCode(dto.getLotCode());
            record.setProductType(dto.getProductType());
            record.setModelName(dto.getModelName());
            record.setTotalQty(dto.getTotalQty());
            record.setGoodQty(dto.getGoodQty());
            record.setStandardCapacity(dto.getStandardCapacity());
            record.setOutputHours(dto.getOutputHours());
            record.setInspectorId(inspectorId);
            record.setInspectorName(inspectorName);
            record.setStatus("DRAFT");
            record.setInspDate(now);
            record.setReopenCount(0);
            record.setRemark(dto.getRemark());
            record.setCreateTime(now);
            record.setUpdateTime(now);

            record.setPnlPcs(dto.getPnlPcs());
            record.setPnlTestTimes(dto.getPnlTestTimes());
            record.setCheckResult(dto.getCheckResult());
            record.setCheckExceptionResult(dto.getCheckExceptionResult());
            record.setCheckHandleResult(dto.getCheckHandleResult());
            record.setRetestPassQty(dto.getRetestPassQty());
            record.setPreStepDefectsqty(dto.getPreStepDefectsqty());
            record.setAddOpenWay(dto.getAddOpenWay());
            record.setAddShortWay(dto.getAddShortWay());
            //record.setPunchingScrapqty(dto.getPunchingScrapqty());
            //record.setIsfollow(dto.getIsfollow());
            record.setEqpCode(dto.getEqpCode());
            record.setEndDate(dto.getEndDate());
            electricalTestRecordMapper.insertSelective(record);

        }

        // 删除旧的缺陷明细，重新插入
        electricalTestRecordDefectMapper.deleteByRecordId(recordId);

        if (dto.getDefects() != null) {
            for (int i = 0; i < dto.getDefects().size(); i++) {
                FqcDefectItemDto defectDto = dto.getDefects().get(i);
                ElectricalTestRecordDefect defect = new ElectricalTestRecordDefect();
                defect.setId(UUID.randomUUID().toString().replace("-", ""));
                defect.setRecordId(recordId);
                defect.setDefectCodeId(defectDto.getDefectCodeId());
                defect.setDefectName(defectDto.getDefectName());
                defect.setDefectQty(defectDto.getDefectQty() != null ? defectDto.getDefectQty() : 0L);
                defect.setIsCustom(defectDto.getIsCustom() != null ? defectDto.getIsCustom() : 0);
                defect.setDisplayOrder(defectDto.getDisplayOrder() != null ? defectDto.getDisplayOrder() : i);
                defect.setCreateTime(now);
                defect.setUpdateTime(now);
                electricalTestRecordDefectMapper.insertSelective(defect);
            }
        }

        // 聚合计算不良总数和合格率，回写主记录
        Long totalDefectQty = electricalTestRecordDefectMapper.sumDefectQtyByRecordId(recordId);
        Double passRate = null;
        if (dto.getTotalQty() != null && dto.getTotalQty() > 0 && dto.getGoodQty() != null) {
            passRate = Math.round(dto.getGoodQty().doubleValue() / dto.getTotalQty().doubleValue() * 10000.0) / 100.0;
        }

        ElectricalTestRecord aggregateUpdate = new ElectricalTestRecord();
        aggregateUpdate.setId(recordId);
        aggregateUpdate.setDefectQty(totalDefectQty);
        aggregateUpdate.setPassRate(passRate);
        aggregateUpdate.setUpdateTime(now);
        electricalTestRecordMapper.updateByPrimaryKeySelective(aggregateUpdate);


        // 删除旧的工艺参数，重新插入
        electricalTestParametersMapper.deleteByRecordId(recordId);

        if (dto.getParameters()!= null) {
            for (int i = 0; i < dto.getParameters().size(); i++) {
                ElectricalTestParameterDto parametersDto = dto.getParameters().get(i);
                ElectricalTestParameters parameters = new ElectricalTestParameters();
                parameters.setId(UUID.randomUUID().toString().replace("-", ""));
                parameters.setElectricalTestId(recordId);
                parameters.setEqpId(parametersDto.getEqp_id());
                parameters.setParameterName(parametersDto.getParamName());
                parameters.setParameterValue(parametersDto.getParamValue());
                parameters.setCreateTime(now);
                parameters.setIsCustom(parametersDto.getIsCustom());
                if(parametersDto.getDisplayOrder()==null){
                    parametersDto.setDisplayOrder(0);
                }
                parameters.setDisplayOrder(parametersDto.getDisplayOrder());

                electricalTestParametersMapper.insertSelective(parameters);
            }
        }

        return getElectricalTestRecordById(recordId);
    }

    /**
     * 提交 电测检验 记录
     */
    @Transactional
    public void submitElectricalTestRecord(String recordId, String inspectorId) {
        ElectricalTestRecord record = electricalTestRecordMapper.selectByPrimaryKey(recordId);
        if (record == null) {
            throw new RuntimeException("记录不存在");
        }
        if (!record.getInspectorId().equals(inspectorId)) {
            throw new RuntimeException("无权操作此记录");
        }
        if ("SUBMITTED".equals(record.getStatus())) {
            throw new RuntimeException("记录已经提交过了");
        }

        ElectricalTestRecord update = new ElectricalTestRecord();
        update.setId(recordId);
        update.setStatus("SUBMITTED");
        update.setUpdateTime(new Date());
        electricalTestRecordMapper.updateByPrimaryKeySelective(update);
    }

    /**
     * 撤回编辑（仅当天可撤回）
     */
    @Transactional
    public void reopenElectricalTestRecord(String recordId, String inspectorId) {
        ElectricalTestRecord record = electricalTestRecordMapper.selectByPrimaryKey(recordId);
        if (record == null) {
            throw new RuntimeException("记录不存在");
        }
        if (!record.getInspectorId().equals(inspectorId)) {
            throw new RuntimeException("无权操作此记录");
        }
        if (!"SUBMITTED".equals(record.getStatus())) {
            throw new RuntimeException("只有已提交的记录才能撤回");
        }

        //检验日期加两天
        Date inspDate = record.getInspDate();
        Calendar cal = Calendar.getInstance();
        cal.setTime(inspDate);
        cal.add(Calendar.DAY_OF_MONTH, 2);
        Date result = cal.getTime();

        // 判断是否当天
        Calendar inspCal = Calendar.getInstance();
        Calendar todayCal = Calendar.getInstance();
        inspCal.setTime(result);
        // 比较：检验日期+2天 是否 大于 当前日期
        //boolean sameDay=todayCal.after(inspCal);
        boolean sameDay = inspCal.get(Calendar.YEAR) == todayCal.get(Calendar.YEAR)
                && inspCal.get(Calendar.DAY_OF_YEAR) >= todayCal.get(Calendar.DAY_OF_YEAR);
        if (!sameDay) {
            throw new RuntimeException("仅两天内的记录可以撤回编辑");
        }

        Date now = new Date();
        ElectricalTestRecord update = new ElectricalTestRecord();
        update.setId(recordId);
        update.setStatus("DRAFT");
        update.setReopenCount(record.getReopenCount() != null ? record.getReopenCount() + 1 : 1);
        update.setLastReopenTime(now);
        update.setUpdateTime(now);
        electricalTestRecordMapper.updateByPrimaryKeySelective(update);
    }

    /**
     * 删除 电测检验 记录（仅草稿可删）
     */
    @Transactional
    public void deleteElectricalTestRecord(String recordId, String inspectorId) {
        ElectricalTestRecord record = electricalTestRecordMapper.selectByPrimaryKey(recordId);
        if (record == null) {
            throw new RuntimeException("记录不存在");
        }
        if (!record.getInspectorId().equals(inspectorId)) {
            throw new RuntimeException("无权删除此记录");
        }
        if ("SUBMITTED".equals(record.getStatus())) {
            throw new RuntimeException("已提交的记录不允许删除，请先撤回");
        }
        // 先删除缺陷明细
        electricalTestRecordDefectMapper.deleteByRecordId(recordId);
        // 再删除主记录
        electricalTestRecordMapper.deleteByPrimaryKey(recordId);

        // 删除该记录对应的工艺参数
        electricalTestParametersMapper.deleteByRecordId(recordId);

    }

    /**
     * 按批次号和日期查找记录（扫码查重）
     */
    public List<ElectricalTestRecordVo> getRecordsByLotAndDate(String lotCode, Date inspDate) {
        List<ElectricalTestRecord> records = electricalTestRecordMapper.selectByLotAndDate(lotCode, inspDate);
        return records.stream().map(this::convertToVo).collect(Collectors.toList());
    }

    /**
     * 按检验员和日期查记录列表
     */
    public List<ElectricalTestRecordVo> getElectricalTestRecordList(String inspectorId, Date inspDate) {
        List<ElectricalTestRecord> records = electricalTestRecordMapper.selectByInspectorAndDate(inspectorId, inspDate);
        return records.stream().map(this::convertToVo).collect(Collectors.toList());
    }

    /**
     * 获取单条记录详情（含缺陷明细）
     */
    public ElectricalTestRecordVo getElectricalTestRecordById(String recordId) {
        int totalQty=0;
        ElectricalTestRecord record = electricalTestRecordMapper.selectByPrimaryKey(recordId);
        if (record == null) {
            throw new RuntimeException("记录不存在: " + recordId);
        }
        try{
            totalQty=electricalTestRecordMapper.getSumByLotCode(record.getLotCode(), recordId);
        }catch(Exception e){
            totalQty=0;
        }
        record.setTotalQty(record.getTotalQty());
        ElectricalTestRecordVo vo = convertToVo(record);

        // 填充缺陷明细
        List<ElectricalTestRecordDefect> defects = electricalTestRecordDefectMapper.selectByRecordId(recordId);
        List<FqcDefectItemDto> defectDtos = defects.stream().map(d -> {
            FqcDefectItemDto dto = new FqcDefectItemDto();
            dto.setDefectCodeId(d.getDefectCodeId());
            dto.setDefectName(d.getDefectName());
            dto.setDefectQty(d.getDefectQty());
            dto.setIsCustom(d.getIsCustom());
            dto.setDisplayOrder(d.getDisplayOrder());
            return dto;
        }).collect(Collectors.toList());
        vo.setDefects(defectDtos);

        return vo;
    }

    /**
     * 将 Model 转为 VO（不含缺陷明细，列表查询用）
     */
    public ElectricalTestRecordVo convertToVo(ElectricalTestRecord record) {
        ElectricalTestRecordVo vo = new ElectricalTestRecordVo();
        vo.setId(record.getId());
        vo.setLotCode(record.getLotCode());
        vo.setProductType(record.getProductType());
        vo.setModelName(record.getModelName());
        vo.setTotalQty(record.getTotalQty());
        vo.setGoodQty(record.getGoodQty());
        vo.setDefectQty(record.getDefectQty());
        vo.setPassRate(record.getPassRate());
        vo.setStandardCapacity(record.getStandardCapacity());
        vo.setOutputHours(record.getOutputHours());
        vo.setInspectorId(record.getInspectorId());
        vo.setInspectorName(record.getInspectorName());
        vo.setStatus(record.getStatus());
        vo.setInspDate(record.getInspDate());
        vo.setReopenCount(record.getReopenCount());
        vo.setLastReopenTime(record.getLastReopenTime());
        vo.setRemark(record.getRemark());
        vo.setCreateTime(record.getCreateTime());
        vo.setUpdateTime(record.getUpdateTime());

        vo.setPnlPcs(record.getPnlPcs());
        vo.setPnlTestTimes(record.getPnlTestTimes());
        vo.setCheckResult(record.getCheckResult());
        vo.setCheckExceptionResult(record.getCheckExceptionResult());
        vo.setCheckHandleResult(record.getCheckHandleResult());
        vo.setRetestPassQty(record.getRetestPassQty());
        vo.setPreStepDefectsqty(record.getPreStepDefectsqty());
        vo.setAddOpenWay(record.getAddOpenWay());
        vo.setAddShortWay(record.getAddShortWay());
        vo.setPunchingScrapqty(record.getPunchingScrapqty());
        vo.setIsfollow(record.getIsfollow());
        vo.setEqpCode(record.getEqpCode());
        vo.setEndDate(record.getEndDate());
        return vo;
    }

    /**
     * 按批次的料号去ERP查询标准产能
     */
    public int selectStandardCapacity(String modelName) {
        int result=0;
        try{
            Integer standardCapacity=electricalTestRecordMapper.selectStandardCapacity(modelName);
            result=(standardCapacity==null)?0:standardCapacity;
        }catch(Exception e){
            result=0;
        }

        return result;
    }

    public boolean checkPotionPermission(String employeeId) {
        int count = pdaLineUserRelMapper.countPotionPermission(employeeId);
        return count > 0;
    }

    @Override
    public void updatePunchingScrap(ElectricalTestRecordDto dto) {
        //获取配置文件连接的数据库是SZ还是TS
        //Boolean url =env.getProperty("spring.datasource.url").endsWith("szmes");

        Date now = new Date();
        String recordId = dto.getRecordId();

        if (recordId != null && !recordId.isEmpty()) {
            // 更新已有记录
            ElectricalTestRecord existing = electricalTestRecordMapper.selectByPrimaryKey(recordId);
            if (existing == null) {
                throw new RuntimeException("记录不存在: " + recordId);
            }

            // 更新主记录字段
            ElectricalTestRecord update = new ElectricalTestRecord();
            update.setId(recordId);
            update.setPunchingScrapqty(dto.getPunchingScrapqty());
            update.setIsfollow(dto.getIsfollow());
            update.setEndDate(now);

            String s=recordId;
            Integer s1=dto.getPunchingScrapqty();
            String s2=dto.getIsfollow();
            Date s3=now;
            electricalTestRecordMapper.updateByPrimaryKeySelective(update);

        }
    }

    @Override
    public int getSumByLotCode(String lotCode,String recordId) {
        int totalQty=electricalTestRecordMapper.getSumByLotCode(lotCode,recordId);
        return totalQty;
    }

}
