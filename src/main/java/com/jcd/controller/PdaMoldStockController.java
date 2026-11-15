package com.jcd.controller;

import com.jcd.dto.ResponseDTO;
import com.jcd.model.Location;
import com.jcd.model.PdaMoldStock;
import com.jcd.service.PdaMoldStockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api/PdaMoldStock")
public class PdaMoldStockController {

    @Autowired
    private PdaMoldStockService pdaMoldStockService;

    /**
     *  入库校验模具二维码，校验系统是否有这个磨具存在系统和是否已经入库  修改:不校验模具在mes系统
     * */
    @GetMapping("/checkByMoldCode")
    public ResponseDTO<String> checkByMoldCode(String moldCode){

       /* //todo 提取模具号：XinYiCheng$TSCZX-41TRM-2$20260618;区分两种情况
        String realMoldCode;


        if (moldCode.contains("$")) {
            realMoldCode = extractMoldCode(moldCode);
        } else {
            realMoldCode = moldCode.trim().replaceAll("\\s+", "");
        }


        Integer moldNum = pdaMoldStockService.getMoleByMoldCode(realMoldCode);

        if (moldNum == 0){
            return ResponseDTO.error("验证失败，该模具未维护，请联系工艺维护该模具号");
        }*/

        PdaMoldStock pdaMoldStock = pdaMoldStockService.getStockByMoldCode(moldCode);
        if(pdaMoldStock == null){

            return ResponseDTO.success("验证通过，请继续扫描储位二维码");

        }else {
            return ResponseDTO.error("验证失败，该模具已放入储位;模具所处储位编号:"+pdaMoldStock.getLocationCode());
        }

    }

    /**
     * 入库校验储位（储位是否已经被占用）
     * */
    @GetMapping("/checkByLocationName")
    public ResponseDTO<String> checkByLocationName(String locationName){

        Location location = pdaMoldStockService.getLocationByLocationName(locationName);

        if (location == null){
            return ResponseDTO.error("mes中没有维护该储位，请先维护该储位编码");
        }



        return ResponseDTO.success("储位校验通过");

    }


    /**
     *  入库：新增记录到模具当前储位状态表和模具出入库流水表（模具和储位均校验通过之后）
     * */
    @PostMapping("/insertion")
    public ResponseDTO<String> insertion(@RequestBody PdaMoldStock pdaMoldStock, HttpServletRequest request){
        String employeeId = (String) request.getAttribute("current_employee_id");

        if (employeeId == null || "".equals(employeeId)) {
            return ResponseDTO.error("未获取到当前登录用户");
        }

        try {
            Boolean b = pdaMoldStockService.insertion(pdaMoldStock, employeeId);
            return b ? ResponseDTO.success("成功入库")
                    : ResponseDTO.error("入库失败，请联系IT进行处理");
        } catch (Exception e) {
            return ResponseDTO.error("入库失败：" + e.getMessage());
        }
    }


    /**
     *  出库校验:储位校验 校验模具当前储位状态表
     * */
    @GetMapping("/checkLocationOutStatus")
    public ResponseDTO<String> checkLocationOutStatus(String locationCode){

        //校验校验模具当前储位状态表
        Integer num = pdaMoldStockService.checkLocationOutStatus(locationCode);
        if (num == 0){

            return ResponseDTO.error("该储位没有模治具，无法进行出库操作");

        }else {
            return ResponseDTO.success("校验成功，请继续操作");
        }


    }

    /**
     * 出库扫描储位自动带出储位库存模具
     * */
    @GetMapping("/getMoldsByLocationCode")
    public ResponseDTO<List<String>> getMoldsByLocationCode(String locationCode){

        List<String> list = pdaMoldStockService.getMoldsByLocationCode(locationCode);
        if (list.isEmpty()){

            return ResponseDTO.error("该储位没有模治具，无法进行出库操作");

        }else {
            return ResponseDTO.success(list);
        }

    }



    /**
     * 出库校验：模具校验 校验模具
     * */

    @GetMapping("/checkMoldInLocation")
    public ResponseDTO<String> checkMoldInLocation(String moldCode,String locationCode){

        Integer num = pdaMoldStockService.checkMoldInLocation(moldCode,locationCode);
        if (num == 1){
            return ResponseDTO.success("模具校验成功，模具放置在该储位");
        }else {
            return ResponseDTO.error("模具校验失败，模具不在该储位");
        }
    }

    /**
     * 出库
     * */
    @PostMapping("/outOfStock")
    public ResponseDTO<String> outOfStock(@RequestParam String locationCode, @RequestParam String moldCode,HttpServletRequest request){
        String employeeId = (String) request.getAttribute("current_employee_id");

        if (employeeId == null || "".equals(employeeId)) {
            return ResponseDTO.error("未获取到当前登录用户");
        }

        try {
            Boolean b = pdaMoldStockService.outOfStock(locationCode,moldCode,employeeId);
            return b ? ResponseDTO.success("出库成功"):ResponseDTO.error("出库失败,请联系IT");
        }catch (Exception e){
            return ResponseDTO.error("出库失败：" + e.getMessage());
        }


    }

    /**
    *  查询模具库存
    * */
    @GetMapping("/searchStock")
    public ResponseDTO<List<PdaMoldStock>> searchStock(@RequestParam(required = false) String moldCode,@RequestParam(required = false) String locationCode){

          List<PdaMoldStock> list = pdaMoldStockService.searchStock(moldCode,locationCode);
          return ResponseDTO.success(list);

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
