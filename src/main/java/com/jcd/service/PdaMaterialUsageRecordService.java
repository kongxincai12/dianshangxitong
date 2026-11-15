package com.jcd.service;

import com.jcd.model.ResultPo;
import com.jcd.model.UsageRecordDto;

public interface PdaMaterialUsageRecordService {

    //校验人员是否是产线绑定的产线人员
    Boolean checkIsLineRelUser(String usernumber, String cylinderCode);

    //获取线体，缸体，物料
    ResultPo acquireLineCylinderMaterial(String cylinderCode, String usernumber);

    //新增物料使用记录（用量用途）
    Boolean insertRecord(UsageRecordDto recordDto);

}
