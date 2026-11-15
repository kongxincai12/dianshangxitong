package com.jcd.controller;

import com.jcd.dto.ResponseDTO;
import com.jcd.model.ResultPo;
import com.jcd.model.UsageRecordDto;
import com.jcd.service.FqcService;
import com.jcd.service.PdaMaterialUsageRecordService;
import com.jcd.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/permission")
public class PermissionController {

    @Autowired
    private FqcService fqcService;

    @Autowired
    private PdaMaterialUsageRecordService pdaMaterialUsageRecordService;

    @GetMapping("/potion")
    public Result<Map<String, Object>> checkPotionPermission(HttpServletRequest request) {
        String employeeId = (String) request.getAttribute("current_employee_id");

        boolean hasPermission = fqcService.checkPotionPermission(employeeId);

        Map<String, Object> result = new HashMap<>();
        result.put("hasPermission", hasPermission);

        return Result.success(result);
    }


    /*PDA
     * 先查出缸体属于哪条线，再进行校验
     * */
    @GetMapping("/checkIsLineRelUser")
    public ResponseDTO<String> checkIsLineRelUser(String usernumber, String cylinderCode){

        Boolean b = pdaMaterialUsageRecordService.checkIsLineRelUser(usernumber,cylinderCode);
        if (b){
            return ResponseDTO.success("人员校验通过，请选择相关物料添加并为其添加用量和用途");
        }else {
            return ResponseDTO.error("人员校验不通过，该人员不是线体相关人员，请联系工艺确认");
        }
    }


    /*PDA
     * 校验成功后获取缸体对应的线体，关联物料id，物料列表（包含物料名字和物料单位）
     * */
    @GetMapping("/acquireLineCylinderMaterial")
    public ResponseDTO<ResultPo> acquireLineCylinderMaterial(String cylinderCode,String usernumber){

        ResultPo po = pdaMaterialUsageRecordService.acquireLineCylinderMaterial(cylinderCode,usernumber);
        return ResponseDTO.success(po);

    }

    /*PDA
     * todo 在物料列表中选择了物料后,向使用记录表添加单条记录
     * */
    @PostMapping("/insertRecord")
    public ResponseDTO<String> insertRecord(@RequestBody UsageRecordDto recordDto){
        Boolean b = pdaMaterialUsageRecordService.insertRecord(recordDto);
        if (b){
            return ResponseDTO.success("物料使用记录新增成功");
        }else {
            return ResponseDTO.error("物料使用记录新增失败");
        }


    }


}
