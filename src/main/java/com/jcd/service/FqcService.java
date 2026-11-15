package com.jcd.service;

import com.jcd.dto.FqcDefectItemDto;
import com.jcd.dto.FqcRecordDto;
import com.jcd.dto.Hrdetail;
import com.jcd.mapper.*;
import com.jcd.model.CuxLowcodeFqcdirect;
import com.jcd.model.CuxLowcodeFqcdirectLine;
import com.jcd.model.FqcRecord;
import com.jcd.model.FqcRecordDefect;
import com.jcd.vo.FqcRecordVo;
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
public class FqcService {

    private static final Logger log = LoggerFactory.getLogger(FqcService.class);

    @Autowired
    private FqcRecordMapper fqcRecordMapper;

    @Autowired
    private FqcRecordDefectMapper fqcRecordDefectMapper;

    @Autowired
    private PdaLineUserRelMapper pdaLineUserRelMapper;

    @Autowired
    private UserprofileMapper userprofileMapper;

    @Resource
    private Environment env;

    @Autowired
    private QcFirstPassYieldMapper qcFirstPassYieldMapper;

    @Autowired
    private QcFirstPassYieldDetailMapper qcFirstPassYieldDetailMapper;

    /**
     * 检查员工是否有 FQC 权限
     */
    public boolean checkFqcPermission(String employeeId) {
        int count = fqcRecordMapper.checkFqcPermission(employeeId);
        return count > 0;
    }

    /**
     * 获取 FQC 预设缺陷列表（DEFECTCODE 表中 IS_FQC=1 的记录）
     */
    public List<Map<String, String>> getFqcDefectPresets() {
        return fqcRecordMapper.selectFqcDefectPresets();
    }

    /**
     * 获取 CCD 预设缺陷列表（DEFECTCODE 表中 IS_FQC=2 的记录）
     */
    public List<Map<String, String>> getCcdDefectPresets() {
        return fqcRecordMapper.selectCcdDefectPresets();
    }

    /**
     * 保存或更新 FQC 记录（自动保存/草稿保存）
     */
    @Transactional
    public FqcRecordVo saveOrUpdateFqcRecord(FqcRecordDto dto, String inspectorId, String inspectorName) {
        //获取配置文件连接的数据库是SZ还是TS
        Boolean url =env.getProperty("spring.datasource.url").endsWith("szmes");


        Date now = new Date();
        String recordId = dto.getRecordId();

        if (recordId != null && !recordId.isEmpty()) {
            // 更新已有记录
            FqcRecord existing = fqcRecordMapper.selectByPrimaryKey(recordId);
            if (existing == null) {
                throw new RuntimeException("记录不存在: " + recordId);
            }
            if ("SUBMITTED".equals(existing.getStatus())) {
                throw new RuntimeException("已提交的记录不允许修改，请先撤回");
            }

            // 更新主记录字段
            FqcRecord update = new FqcRecord();
            update.setId(recordId);
            update.setLotCode(dto.getLotCode());
            update.setFqcEqp(dto.getFqcEqp());
            update.setProductType(dto.getProductType());
            update.setModelName(dto.getModelName());
            update.setTotalQty(dto.getTotalQty());
            update.setGoodQty(dto.getGoodQty());
            update.setCycleTime(dto.getCycleTime());
            update.setForkQty(dto.getForkQty());
            update.setPackageQty(dto.getPackageQty());
            update.setStandardCapacity(dto.getStandardCapacity());
            update.setOutputHours(dto.getOutputHours());
            update.setRemark(dto.getRemark());
            update.setUpdateTime(now);
            fqcRecordMapper.updateByPrimaryKeySelective(update);

            if(url){
                updateFirstPassYield(update,dto,"深圳");
            }

        } else {
            //通过工单的料号获取标准产能
            //int standardCapacity=fqcRecordMapper.selectStandardCapacity(dto.getModelName());
            // 新建记录
            recordId = UUID.randomUUID().toString().replace("-", "");
            FqcRecord record = new FqcRecord();
            record.setId(recordId);
            record.setLotCode(dto.getLotCode());
            record.setFqcEqp(dto.getFqcEqp());
            record.setProductType(dto.getProductType());
            record.setModelName(dto.getModelName());
            record.setTotalQty(dto.getTotalQty());
            record.setGoodQty(dto.getGoodQty());
            record.setCycleTime(dto.getCycleTime());
            record.setForkQty(dto.getForkQty());
            record.setPackageQty(dto.getPackageQty());
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
            fqcRecordMapper.insertSelective(record);

            if(url){
                insertFirstPassYield(record,dto,"深圳");
            }
        }

        // 删除旧的缺陷明细，重新插入
        fqcRecordDefectMapper.deleteByRecordId(recordId);

        if (dto.getDefects() != null) {
            for (int i = 0; i < dto.getDefects().size(); i++) {
                FqcDefectItemDto defectDto = dto.getDefects().get(i);
                FqcRecordDefect defect = new FqcRecordDefect();
                defect.setId(UUID.randomUUID().toString().replace("-", ""));
                defect.setRecordId(recordId);
                defect.setDefectCodeId(defectDto.getDefectCodeId());
                defect.setDefectName(defectDto.getDefectName());
                defect.setDefectQty(defectDto.getDefectQty() != null ? defectDto.getDefectQty() : 0L);
                defect.setIsCustom(defectDto.getIsCustom() != null ? defectDto.getIsCustom() : 0);
                defect.setDisplayOrder(defectDto.getDisplayOrder() != null ? defectDto.getDisplayOrder() : i);
                defect.setCreateTime(now);
                defect.setUpdateTime(now);
                fqcRecordDefectMapper.insertSelective(defect);
            }
        }

        // 聚合计算不良总数和合格率，回写主记录
        Long totalDefectQty = fqcRecordDefectMapper.sumDefectQtyByRecordId(recordId);
        Double passRate = null;
        if (dto.getTotalQty() != null && dto.getTotalQty() > 0 && dto.getGoodQty() != null) {
            passRate = Math.round(dto.getGoodQty().doubleValue() / dto.getTotalQty().doubleValue() * 10000.0) / 100.0;
        }

        FqcRecord aggregateUpdate = new FqcRecord();
        aggregateUpdate.setId(recordId);
        aggregateUpdate.setDefectQty(totalDefectQty);
        aggregateUpdate.setPassRate(passRate);
        aggregateUpdate.setUpdateTime(now);
        fqcRecordMapper.updateByPrimaryKeySelective(aggregateUpdate);

        return getFqcRecordById(recordId);
    }

    /**
     * 更新直通率表数据
     */
    @Transactional
    public void updateFirstPassYield(FqcRecord record,FqcRecordDto recordDto,String plantName) {
        try
        {
            String id=record.getId();
            CuxLowcodeFqcdirect existing = qcFirstPassYieldMapper.selectByPrimaryKeyA(id);
            if (existing == null) {
                throw new RuntimeException("直通率记录不存在: " + record.getId()+"，请检查直通率数据");
            }
            Hrdetail hrdetail=userprofileMapper.selectByHrDetail(record.getInspectorId());

            CuxLowcodeFqcdirect fqcdirect=new CuxLowcodeFqcdirect();
            fqcdirect.setId(record.getId());
            fqcdirect.setCREATEDATE(record.getCreateTime());
            fqcdirect.setFQCDIRECTDATE(record.getInspDate());
            if(hrdetail==null){
                fqcdirect.setUSERNAME(null);
            }
            else
            {
                fqcdirect.setUSERNAME(hrdetail.getEmployeeName());//通过工号找名称
            }
            fqcdirect.setUSERNUMBER(record.getInspectorId());

            fqcdirect.setWEEKCODE(String.valueOf(record.getCycleTime()));
            fqcdirect.setPRODUCTNUMBER(record.getModelName());
            fqcdirect.setLOT(record.getLotCode());
            Long totalQty = record.getTotalQty() == null ? 0L : record.getTotalQty();
            fqcdirect.setALLCHECKNUMBER(totalQty);
            Long goodQty = record.getGoodQty() == null ? 0L : record.getGoodQty();
            fqcdirect.setOKNUMBER(record.getGoodQty());
            Long ngQty=(totalQty-goodQty)<=0?0L:(totalQty-goodQty);
            fqcdirect.setNGNUMBER(ngQty);

            Double totalQtyD = record.getTotalQty() == null ? 0.0 : record.getTotalQty();
            Double goodQtyD = record.getGoodQty() == null ? 0.0: record.getGoodQty();
            Double ngQtyD =(totalQty-goodQty)==0.0? 0.0:(totalQty-goodQty);
            Double ngRate = 0.0;
            Double oKRate = 0.0;
            // 避免除以0
            if (totalQty > 0) {
                ngRate = (double) Math.round(ngQtyD/totalQtyD * 10000) / 10000;
                oKRate = (double) Math.round(goodQtyD/totalQtyD * 10000) / 10000;
            }
            fqcdirect.setNGRATE(ngRate);
            fqcdirect.setOKRATE(oKRate);

            //通过料号获取板型
            String code = record.getModelName().substring(3, 5);
            String cusCode = record.getModelName().substring(0, 3);
            String value="";
            if(record.getModelName().toUpperCase().endsWith("-S")){
                value="SMT";
            }
            switch (cusCode) {
                case "111": value="绿油板";break;
                case "333": value="精细线路板";break;
                case "332": value="精细线路板";break;
                default: value="";
            }
            if(value.equals("")){
                switch (code) {
                    case "D2": value="双面板";break;
                    case "S1": value="单面板";break;
                    case "E1": value="镂空板";break;
                    default: value="";
                }
            }
            fqcdirect.setSEGMENT1(value);
            fqcdirect.setSEGMENT3("1");//检查标记，默认1
            if(plantName!=null){
                fqcdirect.setSEGMENT2(plantName);
            }else{
                fqcdirect.setSEGMENT2("台山");
            }
            qcFirstPassYieldMapper.updateByPrimaryKeySelective(fqcdirect);

            try{
                qcFirstPassYieldDetailMapper.deleteByPrimaryKey(record.getId());
                if (recordDto.getDefects() != null) {
                    for (int i = 0; i < recordDto.getDefects().size(); i++) {
                        FqcDefectItemDto defectDto = recordDto.getDefects().get(i);
                        if(defectDto.getDefectQty()>0){
                            CuxLowcodeFqcdirectLine fqcdirectLine=new CuxLowcodeFqcdirectLine();
                            fqcdirectLine.setId(UUID.randomUUID().toString().replace("-", ""));
                            fqcdirectLine.setHEADID(record.getId());
                            Integer typeId=qcFirstPassYieldDetailMapper.selectTypeId(defectDto.getDefectName(),value);
                            if(typeId!=null){
                                fqcdirectLine.setTYPEID((long) typeId);
                            }
                            else{
                                //记录与FQC明细不一致的类型
                                String uuid=UUID.randomUUID().toString().replace("-", "");
                                qcFirstPassYieldDetailMapper.insertTypeId(uuid,defectDto.getDefectName(),value);
                                fqcdirectLine.setTYPEID(1707L);
                            }
                            fqcdirectLine.setTYPEVALUE(defectDto.getDefectQty() != null ? defectDto.getDefectQty() : 0L);

                            qcFirstPassYieldDetailMapper.insertSelective(fqcdirectLine);
                        }
                    }
                }
            }catch(Exception e){
                System.out.println("删除失败");
            }
        }catch(Exception e){
            System.out.println("发生异常");
        }
    }

    /**
     * 插入数据到直通率表
     */
    @Transactional
    public void insertFirstPassYield(FqcRecord record,FqcRecordDto recordDto,String plantName) {
        try
        {
            Hrdetail hrdetail=userprofileMapper.selectByHrDetail(record.getInspectorId());

            CuxLowcodeFqcdirect fqcdirect=new CuxLowcodeFqcdirect();
            fqcdirect.setId(record.getId());
            fqcdirect.setCREATEDATE(record.getCreateTime());
            fqcdirect.setFQCDIRECTDATE(record.getInspDate());
            if(hrdetail==null){
                fqcdirect.setUSERNAME(null);
            }
            else
            {
                fqcdirect.setUSERNAME(hrdetail.getEmployeeName());//通过工号找名称
            }
            fqcdirect.setUSERNUMBER(record.getInspectorId());

            fqcdirect.setWEEKCODE(String.valueOf(record.getCycleTime()));
            fqcdirect.setPRODUCTNUMBER(record.getModelName());
            fqcdirect.setLOT(record.getLotCode());
            fqcdirect.setALLCHECKNUMBER((record.getTotalQty() == null || record.getTotalQty() == 0) ? 0 : record.getTotalQty());
            //fqcdirect.setALLCHECKNUMBER(record.getTotalQty());
            fqcdirect.setOKNUMBER((record.getGoodQty() == null || record.getGoodQty() == 0) ? 0 : record.getGoodQty());
            //fqcdirect.setOKNUMBER(record.getGoodQty());
            fqcdirect.setNGNUMBER((record.getDefectQty() == null || record.getDefectQty() == 0) ? 0 : record.getDefectQty());
            //fqcdirect.setNGNUMBER(record.getDefectQty());
            //计算NG比率
            if(record.getTotalQty()!=null&&record.getTotalQty()!=0){
                Double ngRate= (double) Math.round(record.getDefectQty()/record.getTotalQty()*10000)/10000;
                fqcdirect.setNGRATE(ngRate);//通过不良数除以总投料数得出
            }
            fqcdirect.setOKRATE(record.getPassRate());

            //通过料号获取板型
            String code = record.getModelName().substring(3, 5);
            String cusCode = record.getModelName().substring(0, 3);
            String value="";
            if(record.getModelName().toUpperCase().endsWith("-S")){
                value="SMT";
            }
            switch (cusCode) {
                case "111": value="绿油板";break;
                case "333": value="精细线路板";break;
                case "332": value="精细线路板";break;
                default: value="";
            }
            if(value.equals("")){
                switch (code) {
                    case "D2": value="双面板";break;
                    case "S1": value="单面板";break;
                    case "E1": value="镂空板";break;
                    default: value="";
                }
            }
            fqcdirect.setSEGMENT1(value);
            fqcdirect.setSEGMENT3("1");//检查标记，默认1
            if(plantName!=null){
                fqcdirect.setSEGMENT2("深圳");
            }else{
                fqcdirect.setSEGMENT2("台山");
            }

            qcFirstPassYieldMapper.insertSelective(fqcdirect);

            if (recordDto.getDefects() != null) {
                for (int i = 0; i < recordDto.getDefects().size(); i++) {
                    FqcDefectItemDto defectDto = recordDto.getDefects().get(i);
                    if(defectDto.getDefectQty()>0){
                        CuxLowcodeFqcdirectLine fqcdirectLine=new CuxLowcodeFqcdirectLine();
                        fqcdirectLine.setId(UUID.randomUUID().toString().replace("-", ""));
                        fqcdirectLine.setHEADID(record.getId());
                        Integer typeId=qcFirstPassYieldDetailMapper.selectTypeId(defectDto.getDefectName(),value);
                        if(typeId!=null){
                            fqcdirectLine.setTYPEID((long) typeId);
                        }
                        else{
                            //记录与FQC明细不一致的类型
                            String uuid=UUID.randomUUID().toString().replace("-", "");
                            qcFirstPassYieldDetailMapper.insertTypeId(uuid,defectDto.getDefectName(),value);
                            fqcdirectLine.setTYPEID(0L);
                        }
                        fqcdirectLine.setTYPEVALUE(defectDto.getDefectQty() != null ? defectDto.getDefectQty() : 0L);

                        qcFirstPassYieldDetailMapper.insertSelective(fqcdirectLine);
                    }
                }
            }
        }catch(Exception e){
            System.out.println("发生异常");
        }
    }

    /**
     * 提交 FQC 记录
     */
    @Transactional
    public void submitFqcRecord(String recordId, String inspectorId) {
        FqcRecord record = fqcRecordMapper.selectByPrimaryKey(recordId);
        if (record == null) {
            throw new RuntimeException("记录不存在");
        }
        if (!record.getInspectorId().equals(inspectorId)) {
            throw new RuntimeException("无权操作此记录");
        }
        if ("SUBMITTED".equals(record.getStatus())) {
            throw new RuntimeException("记录已经提交过了");
        }

        FqcRecord update = new FqcRecord();
        update.setId(recordId);
        update.setStatus("SUBMITTED");
        update.setUpdateTime(new Date());
        fqcRecordMapper.updateByPrimaryKeySelective(update);
    }

    /**
     * 撤回编辑（仅当天可撤回）
     */
    @Transactional
    public void reopenFqcRecord(String recordId, String inspectorId) {
        FqcRecord record = fqcRecordMapper.selectByPrimaryKey(recordId);
        if (record == null) {
            throw new RuntimeException("记录不存在");
        }
        if (!record.getInspectorId().equals(inspectorId)) {
            throw new RuntimeException("无权操作此记录");
        }
        if (!"SUBMITTED".equals(record.getStatus())) {
            throw new RuntimeException("只有已提交的记录才能撤回");
        }

        // 判断是否当天
        Calendar inspCal = Calendar.getInstance();
        inspCal.setTime(record.getInspDate());
        Calendar todayCal = Calendar.getInstance();
        boolean sameDay = inspCal.get(Calendar.YEAR) == todayCal.get(Calendar.YEAR)
                && inspCal.get(Calendar.DAY_OF_YEAR) == todayCal.get(Calendar.DAY_OF_YEAR);
        if (!sameDay) {
            throw new RuntimeException("仅当天的记录可以撤回编辑");
        }

        Date now = new Date();
        FqcRecord update = new FqcRecord();
        update.setId(recordId);
        update.setStatus("DRAFT");
        update.setReopenCount(record.getReopenCount() != null ? record.getReopenCount() + 1 : 1);
        update.setLastReopenTime(now);
        update.setUpdateTime(now);
        fqcRecordMapper.updateByPrimaryKeySelective(update);
    }

    /**
     * 删除 FQC 记录（仅草稿可删）
     */
    @Transactional
    public void deleteFqcRecord(String recordId, String inspectorId) {
        FqcRecord record = fqcRecordMapper.selectByPrimaryKey(recordId);
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
        fqcRecordDefectMapper.deleteByRecordId(recordId);
        // 再删除主记录
        fqcRecordMapper.deleteByPrimaryKey(recordId);

        try
        {
            // 先删除直通率缺陷明细
            //CuxLowcodeFqcdirect cuxLowcodeFqcdirect=qcFirstPassYieldMapper.selectByPrimaryKey(recordId);//查找主表ID
            qcFirstPassYieldDetailMapper.deleteByPrimaryKey(recordId);//通过主表ID删除明细表数据
        }catch(Exception e){
            System.out.println("发生异常");
        }

        try
        {
            // 再删除直通率主记录
            qcFirstPassYieldMapper.deleteByPrimaryKey(recordId);
        }catch(Exception e){
            System.out.println("发生异常");
        }
    }

    /**
     * 按批次号和日期查找记录（扫码查重）
     */
    public List<FqcRecordVo> getRecordsByLotAndDate(String lotCode, Date inspDate) {
        List<FqcRecord> records = fqcRecordMapper.selectByLotAndDate(lotCode, inspDate);
        return records.stream().map(this::convertToVo).collect(Collectors.toList());
    }

    /**
     * 按检验员和日期查记录列表
     */
    public List<FqcRecordVo> getFqcRecordList(String inspectorId, Date inspDate) {
        List<FqcRecord> records = fqcRecordMapper.selectByInspectorAndDate(inspectorId, inspDate);
        return records.stream().map(this::convertToVo).collect(Collectors.toList());
    }

    /**
     * 获取单条记录详情（含缺陷明细）
     */
    public FqcRecordVo getFqcRecordById(String recordId) {
        FqcRecord record = fqcRecordMapper.selectByPrimaryKey(recordId);
        if (record == null) {
            throw new RuntimeException("记录不存在: " + recordId);
        }
        FqcRecordVo vo = convertToVo(record);

        // 填充缺陷明细
        List<FqcRecordDefect> defects = fqcRecordDefectMapper.selectByRecordId(recordId);
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
    private FqcRecordVo convertToVo(FqcRecord record) {
        FqcRecordVo vo = new FqcRecordVo();
        vo.setId(record.getId());
        vo.setLotCode(record.getLotCode());
        vo.setFqcEqp(record.getFqcEqp());
        vo.setProductType(record.getProductType());
        vo.setModelName(record.getModelName());
        vo.setTotalQty(record.getTotalQty());
        vo.setGoodQty(record.getGoodQty());
        vo.setDefectQty(record.getDefectQty());
        vo.setPassRate(record.getPassRate());
        vo.setCycleTime(record.getCycleTime());
        vo.setForkQty(record.getForkQty());
        vo.setPackageQty(record.getPackageQty());
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
        return vo;
    }

    /**
     * 按批次的料号去ERP查询标准产能
     */
    public int selectStandardCapacity(String modelName) {
        int result=0;
        try{
            Integer standardCapacity=fqcRecordMapper.selectStandardCapacity(modelName);
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

}
