package com.jcd.service.Impl;

import com.jcd.mapper.PdaMoldStockMapper;
import com.jcd.model.Location;
import com.jcd.model.PdaMoldIoRecord;
import com.jcd.model.PdaMoldStock;
import com.jcd.service.PdaMoldStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PdaMoldStockServiceImpl implements PdaMoldStockService {

    @Autowired
    private PdaMoldStockMapper pdaMoldStockMapper;



    @Override
    public PdaMoldStock getStockByMoldCode(String moldCode) {

        return pdaMoldStockMapper.getStockByMoldCode(moldCode);


    }

    //todo 改成一对多
    @Override
    public Integer checkByLocationName(String locationName) {

        return pdaMoldStockMapper.checkByLocationName(locationName);

    }

    @Transactional
    @Override
    public Boolean insertion(PdaMoldStock pdaMoldStock, String employeeId) {

        //1.向模具储位状态表中新增记录
        pdaMoldStock.setOperateUser(employeeId);
        //pdaMoldStock.setMoldCode(extractMoldCode(pdaMoldStock.getMoldCode())); //todo 对传入的模具号进行格式化

        Integer stockSuccessNum = pdaMoldStockMapper.insertIntoPdaMoldStock(pdaMoldStock);

        //2.向出入库流水表新增记录 入库
        PdaMoldIoRecord pdaMoldIoRecord = new PdaMoldIoRecord();
        pdaMoldIoRecord.setFacilityType(pdaMoldStock.getMoldCode());
        pdaMoldIoRecord.setLocationCode(pdaMoldStock.getLocationCode());
        pdaMoldIoRecord.setIoType("IN"); //设置为入库
        pdaMoldIoRecord.setOperateUser(pdaMoldStock.getOperateUser());
        Integer recordSuccessNum= pdaMoldStockMapper.insertIntoPdaMoldIORecord(pdaMoldIoRecord);

        if (stockSuccessNum != 1 || recordSuccessNum != 1) {
            throw new RuntimeException("模具入库失败，事务回滚");
        }

        return true;

    }

    @Override
    public Location getLocationByLocationName(String locationName) {

        return pdaMoldStockMapper.getLocationByLocationName(locationName);

    }

    @Override
    public Integer getMoleByMoldCode(String moldCode) {
        return pdaMoldStockMapper.getMoleByMoldCode(moldCode);
    }

    @Override
    public Integer checkLocationOutStatus(String locationCode) {
        return pdaMoldStockMapper.checkLocationOutStatus(locationCode);
    }


    //todo 修改出库逻辑 先扫描储位，再扫描模具
    @Override
    @Transactional
    public Boolean outOfStock(String locationCode,String moldCode,String employeeId) {

        String newMoldCode = moldCode;
        //先删除当前储位状态表PDA_MOLD_STOCK的记录
        Integer num = pdaMoldStockMapper.deletePdaMoldStockByLocationCodeAndMoldCold(locationCode,newMoldCode);

        PdaMoldIoRecord pdaMoldIoRecord = new PdaMoldIoRecord();
        pdaMoldIoRecord.setFacilityType(newMoldCode);
        pdaMoldIoRecord.setLocationCode(locationCode);
        pdaMoldIoRecord.setIoType("OUT");
        pdaMoldIoRecord.setOperateUser(employeeId);


        Integer recordNum = pdaMoldStockMapper.insertIntoPdaMoldOUTRecord(pdaMoldIoRecord);
        return num + recordNum == 2;

    }

    @Override
    public Integer checkMoldInLocation(String moldCode, String locationCode) {

        return pdaMoldStockMapper.checkMoldInLocation(moldCode,locationCode);

    }

    @Override
    public List<PdaMoldStock> searchStock(String moldCode, String locationCode) {
        return pdaMoldStockMapper.searchStock(moldCode,locationCode);
    }

    @Override
    public List<String> getMoldsByLocationCode(String locationCode) {
        return pdaMoldStockMapper.getMoldsByLocationCode(locationCode);
    }

    /**
     * 提取模具方法
     * */
    private String extractMoldCode(String moldCode) {
        if (moldCode == null || moldCode.trim().isEmpty()) {
            return null;
        }

        int firstIndex = moldCode.indexOf("$");
        int secondIndex = moldCode.indexOf("$", firstIndex + 1);

        // 没有 $，说明本身可能就是模具号，直接返回清洗后的原值
        if (firstIndex == -1 || secondIndex == -1 || secondIndex <= firstIndex + 1) {
            return moldCode.trim().replace(" ", "");
        }

        // 有 $，取两个 $ 中间的内容
        return moldCode.substring(firstIndex + 1, secondIndex)
                .trim()
                .replace(" ", "");
    }


}
