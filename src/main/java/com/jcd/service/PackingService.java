package com.jcd.service;

import com.jcd.dto.*;
import com.jcd.model.Prp_lot;
import com.jcd.vo.ProductionRecordVO;

import java.time.LocalDate;
import java.util.List;

public interface PackingService {
    void addPackingRecord(AddPackingRecordDto packingRecord);

    List<AddPackingRecordDto> findProductionPackingRecords(String employeeId, LocalDate date, String site);

    void deletePackingRecord(String id);

    void updatePackingRecord(AddPackingRecordDto recordDto);
}
