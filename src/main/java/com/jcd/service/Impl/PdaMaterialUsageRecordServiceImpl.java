package com.jcd.service.Impl;

import com.jcd.mapper.PdaLineCylinderRelMapper;
import com.jcd.mapper.PdaLineUserRelMapper;
import com.jcd.mapper.PdaMaterialUsageRecordMapper;
import com.jcd.mapper.SysUserAccountMapper;
import com.jcd.model.LineCylinderRelIdAndLindCode;
import com.jcd.model.PdaLineCylinderMatRel;
import com.jcd.model.ResultPo;
import com.jcd.model.UsageRecordDto;
import com.jcd.service.PdaMaterialUsageRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PdaMaterialUsageRecordServiceImpl implements PdaMaterialUsageRecordService {

    @Autowired
    private PdaMaterialUsageRecordMapper pdaMaterialUsageRecordMapper;

    @Autowired
    private PdaLineCylinderRelMapper pdaLineCylinderRelMapper;

    @Autowired
    private PdaLineUserRelMapper pdaLineUserRelMapper;

    @Autowired
    private SysUserAccountMapper sysUserAccountMapper;

    @Override
    public Boolean checkIsLineRelUser(String usernumber, String cylinderCode) {

        //先根据缸体code查出线体code
        String lindeCode = pdaLineCylinderRelMapper.getLineCodeByCylinderCode(cylinderCode);

        //传入校验
        int count = pdaLineUserRelMapper.checkIsLineRelUser(usernumber,lindeCode);
        return count > 0;

    }

    //获取线体，缸体，物料列表 todo 获取线体缸体关系的id来关联缸体物料表
    @Override
    public ResultPo acquireLineCylinderMaterial(String cylinderCode, String usernumber) {
        //先获取LINE_CYLINDER_REL_ID
        LineCylinderRelIdAndLindCode lineCylinderRelIdAndLindCode = pdaMaterialUsageRecordMapper.getLineCylinderRelIdByCylinderCode(cylinderCode);

        //通过LINE_CYLINDER_REL_ID获取物料列表
        List<PdaLineCylinderMatRel> materials = pdaMaterialUsageRecordMapper.getRelMaterials(lineCylinderRelIdAndLindCode.getLineCylinderRelId());
        ResultPo resultPo = new ResultPo();
        resultPo.setMaterials(materials);
        resultPo.setPdaCylinderCode(cylinderCode);
        resultPo.setUsernumber(usernumber);
        resultPo.setPdaLineCode(lineCylinderRelIdAndLindCode.getLindCode());

        return resultPo;
    }

    @Override
    public Boolean insertRecord(UsageRecordDto recordDto) {

        if (recordDto == null) {
            return false;
        }

        if (recordDto.getLineCylinderMatRelId() == null) {
            return false;
        }

        if (recordDto.getMaterialPn() == null || recordDto.getMaterialPn().trim().isEmpty()) {
            return false;
        }

        if (recordDto.getUsageAmount() == null || recordDto.getUsageAmount().trim().isEmpty()) {
            return false;
        }

        String name = sysUserAccountMapper.selectNameByUserId(recordDto.getUsernumber());
        recordDto.setUsername(name);

        Integer num = pdaMaterialUsageRecordMapper.insertRecord(recordDto);

        return num != null && num > 0;

    }

}
