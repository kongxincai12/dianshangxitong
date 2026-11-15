package com.jcd.service.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jcd.dto.*;
import com.jcd.exception.BusinessException;
import com.jcd.mapper.*;
import com.jcd.model.*;
import com.jcd.service.MesService;
import com.jcd.service.PackingService;
import com.jcd.vo.ApprovalRecordVo;
import com.jcd.vo.GroupTaskStatusVo;
import com.jcd.vo.ProductionRecordVO;
import com.jcd.vo.TaskStatusVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.util.*;
import java.util.stream.Collectors;


@Service("PackingService")
public class PackingServiceImpl implements PackingService {
    @Autowired
    private PackingMapper packingMapper;

    @Override
    public void addPackingRecord(AddPackingRecordDto packingRecord) {
        RecordPacking recordPacking = new RecordPacking();
        recordPacking.setID(UUID.randomUUID().toString().replace("-", ""));
        recordPacking.setEMPLOYEEID(packingRecord.getEmployeeId());
        recordPacking.setLOTCODE(packingRecord.getLotCode());
        recordPacking.setPNL(packingRecord.getPnl());
        recordPacking.setPCS(packingRecord.getPcs());
        recordPacking.setMATERIALS(packingRecord.getMaterials());
        recordPacking.setDATECODE(packingRecord.getDateCode());
        recordPacking.setXQTY(packingRecord.getQty());
        recordPacking.setSumPackQty(packingRecord.getPackCompleteQty());
        recordPacking.setSTANDARDCAPACITY(packingRecord.getStandardCapacity());
        recordPacking.setOUTPUTHOURS(packingRecord.getOutputHours());
        recordPacking.setREMARK(packingRecord.getRemark());
        packingMapper.insert(recordPacking);
    }

    @Override
    public List<AddPackingRecordDto> findProductionPackingRecords(String employeeId, LocalDate date, String site) {
        // 实现“当天8点到次日8点为一天”的逻辑
        LocalDateTime startDateTime = date.atTime(LocalTime.of(8, 0));
        LocalDateTime endDateTime = startDateTime.plusDays(1);

        Date startTimeFrom = Date.from(startDateTime.atZone(ZoneId.systemDefault()).toInstant());
        Date startTimeTo = Date.from(endDateTime.atZone(ZoneId.systemDefault()).toInstant());

        // 调用 Mapper 的新方法
        List<RecordPacking> records = packingMapper.findProductionPackingRecords(
                employeeId, site, startTimeFrom, startTimeTo);

        return records.stream().map(this::convertToPackingDto).collect(Collectors.toList());
    }

    @Override
    public void deletePackingRecord(String id) {
        packingMapper.deletePackingRecord(id);
    }

    @Override
    public void updatePackingRecord(AddPackingRecordDto recordDto) {
        RecordPacking recordPacking = new RecordPacking();
        recordPacking.setID(recordDto.getId());
        recordPacking.setEMPLOYEEID(recordDto.getEmployeeId());
        recordPacking.setLOTCODE(recordDto.getLotCode());
        recordPacking.setPNL(recordDto.getPnl());
        recordPacking.setPCS(recordDto.getPcs());
        recordPacking.setMATERIALS(recordDto.getMaterials());
        recordPacking.setDATECODE(recordDto.getDateCode());
        recordPacking.setXQTY(recordDto.getQty());
        //recordPacking.setLASTUPDATEDATE(recordDto());
        recordPacking.setSTANDARDCAPACITY(recordDto.getStandardCapacity());
        recordPacking.setOUTPUTHOURS(recordDto.getOutputHours());
        recordPacking.setREMARK(recordDto.getRemark());
        packingMapper.updatePackingRecord(recordPacking);
    }

    private AddPackingRecordDto convertToPackingDto(RecordPacking entity) {
        AddPackingRecordDto vo = new AddPackingRecordDto();
        vo.setId(entity.getID());
        vo.setEmployeeId(entity.getEMPLOYEEID());
        vo.setLotCode(entity.getLOTCODE());
        vo.setMaterials(entity.getMATERIALS());
        vo.setPnl(entity.getPNL());
        vo.setPcs(entity.getPCS());
        vo.setQty(entity.getXQTY());
        vo.setPackCompleteQty(entity.getSumPackQty());
        vo.setDateCode(entity.getDATECODE());
        vo.setCreateTime(entity.getCREATEDATE());
        vo.setStandardCapacity(entity.getSTANDARDCAPACITY());
        vo.setOutputHours(entity.getOUTPUTHOURS());
        vo.setRemark(entity.getREMARK());
        return vo;
    }
}



