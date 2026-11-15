package com.jcd.controller;

import com.jcd.dto.ElectricalTestRecordDto;
import com.jcd.mapper.ElectricalTestRecordMapper;
import com.jcd.model.Prp_lot;
import com.jcd.service.ElectricalTestService;
import com.jcd.service.MesService;
import com.jcd.utils.Result;
import com.jcd.vo.ElectricalTestRecordVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/electricaltest")
public class ElectricalTestController {

    private static final Logger log = LoggerFactory.getLogger(ElectricalTestController.class);

    @Autowired
    private ElectricalTestService electricalTestService;

    @Autowired
    private MesService mesService;


    /**
     * 根据批次号查询批次信息（型号等）
     */
    @GetMapping("/lot-info")
    public Result<Map<String, Object>> getLotInfo(@RequestParam String lotCode,@RequestParam String recordId) {
        List<Prp_lot> lots = mesService.lotfindbyLotname(lotCode);
        int totalQty=0;
        try{
            totalQty=electricalTestService.getSumByLotCode(lotCode,recordId);
        }
        catch(Exception e){
            totalQty=0;
        }

        if (lots != null && !lots.isEmpty()) {

            Prp_lot lot = lots.get(0);
            Map<String, Object> data = new HashMap<>();
            data.put("lotCode", lot.getLotname());
            data.put("modelName", lot.getProductpn());
            int num = lot.getTotalqty().intValue();//将BigDecimal转换为int类型
            data.put("totalQty", num-totalQty);
            data.put("panelPcs", lot.getPanelpcs());
            //获取标准产能
            int standardCapacity=electricalTestService.selectStandardCapacity(lot.getProductpn());
            data.put("standardCapacity", standardCapacity);
            return Result.success(data);
        } else {
            return Result.error(404, "未找到该批次信息");
        }
    }

    /**
     * 检查当前用户 电测检验 权限
     */
    @GetMapping("/permission")
    public Result<Map<String, Object>> checkPermission(HttpServletRequest request) {
        String employeeId = (String) request.getAttribute("current_employee_id");
        boolean hasPermission = electricalTestService.checkElectricalTestPermission(employeeId);
        Map<String, Object> result = new HashMap<>();
        result.put("hasPermission", hasPermission);
        return Result.success(result);
    }

    /**
     * 获取 电测检验 预设缺陷列表
     */
    @GetMapping("/defect-presets")
    public Result<List<Map<String, String>>> getDefectPresets() {
        List<Map<String, String>> presets = electricalTestService.getElectricalTestDefectPresets();
        return Result.success(presets);
    }

    /**
     * 获取 电测设备已录入的工艺参数
     */
    @GetMapping("/craft-parameters")
    public Result<List<Map<String, String>>> getCraftParameters(@RequestParam String recordId, HttpServletRequest request) {
        List<Map<String, String>> presets = electricalTestService.getElectricalTestCraftParameters(recordId);
        return Result.success(presets);
    }

    /**
     * 保存/更新 电测检验 记录（自动保存调用）
     */
    @PostMapping("/save")
    public Result<ElectricalTestRecordVo> saveElectricalTestRecord(@RequestBody ElectricalTestRecordDto dto, HttpServletRequest request) {
        String employeeId = (String) request.getAttribute("current_employee_id");
        // 获取员工姓名（从登录时存的属性或通过 employeeId 查询）
        String employeeName = (String) request.getAttribute("current_employee_name");
        if (employeeName == null) {
            employeeName = employeeId; // fallback
        }
        try {
            ElectricalTestRecordVo vo = electricalTestService.saveOrUpdateElectricalTestRecord(dto, employeeId, employeeName);
            return Result.success(vo);
        } catch (RuntimeException e) {
            log.error("保存电测检验记录失败: {}", e.getMessage());
            return Result.error(400, e.getMessage());
        }
    }

    /**
     * 提交 电测检验 记录
     */
    @PostMapping("/submit/{recordId}")
    public Result<String> submitElectricalTestRecord(@PathVariable String recordId, HttpServletRequest request) {
        String employeeId = (String) request.getAttribute("current_employee_id");
        try {
            electricalTestService.submitElectricalTestRecord(recordId, employeeId);
            return Result.success("提交成功");
        } catch (RuntimeException e) {
            log.error("提交电测检验记录失败: {}", e.getMessage());
            return Result.error(400, e.getMessage());
        }
    }

    /**
     * 撤回编辑（仅当天可撤回）
     */
    @PostMapping("/reopen/{recordId}")
    public Result<String> reopenElectricalTestRecord(@PathVariable String recordId, HttpServletRequest request) {
        String employeeId = (String) request.getAttribute("current_employee_id");
        try {
            electricalTestService.reopenElectricalTestRecord(recordId, employeeId);
            return Result.success("已撤回，可以继续编辑");
        } catch (RuntimeException e) {
            log.error("撤回电测检验记录失败: {}", e.getMessage());
            return Result.error(400, e.getMessage());
        }
    }

    /**
     * 提交冲孔报废数据
     */
    @PostMapping("/submitPunchingScrap")
    public Result<String> submitPunchingScrap(@RequestBody ElectricalTestRecordDto dto, HttpServletRequest request) {
        //String employeeId = (String) request.getAttribute("current_employee_id");
        // 获取员工姓名（从登录时存的属性或通过 employeeId 查询）
        //String employeeName = (String) request.getAttribute("current_employee_name");
        //if (employeeName == null) {
         //   employeeName = employeeId; // fallback
        //}
        try {
            electricalTestService.updatePunchingScrap(dto);
            return Result.success("保存成功");
        } catch (RuntimeException e) {
            //log.error("保存电测冲孔记录失败: {}", e.getMessage());
            //throw new RuntimeException("记保存电测冲孔记录失败！");
            log.error("保存电测冲孔记录失败: {}", e.getMessage());
            return Result.error(400, e.getMessage());
        }
    }

    /**
     * 获取记录列表（按日期）
     */
    @GetMapping("/records")
    public Result<List<ElectricalTestRecordVo>> getElectricalTestRecordList(
            @RequestParam String date,
            HttpServletRequest request) {
        String employeeId = (String) request.getAttribute("current_employee_id");
        try {
            Date inspDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            List<ElectricalTestRecordVo> list = electricalTestService.getElectricalTestRecordList(employeeId, inspDate);
            return Result.success(list);
        } catch (ParseException e) {
            return Result.error(400, "日期格式错误，请使用 yyyy-MM-dd");
        }
    }

    /**
     * 获取单条记录详情
     */
    @GetMapping("/records/{recordId}")
    public Result<ElectricalTestRecordVo> getElectricalTestRecordById(@PathVariable String recordId) {
        try {
            ElectricalTestRecordVo vo = electricalTestService.getElectricalTestRecordById(recordId);
            return Result.success(vo);
        } catch (RuntimeException e) {
            return Result.error(404, e.getMessage());
        }
    }

    /**
     * 按批次号查重（扫码后查找同批次同天记录）
     */
    @GetMapping("/records/by-lot")
    public Result<List<ElectricalTestRecordVo>> getRecordsByLot(
            @RequestParam String lotCode,
            @RequestParam String date) {
        try {
            Date inspDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            List<ElectricalTestRecordVo> list = electricalTestService.getRecordsByLotAndDate(lotCode, inspDate);
            return Result.success(list);
        } catch (ParseException e) {
            return Result.error(400, "日期格式错误，请使用 yyyy-MM-dd");
        }
    }

    /**
     * 删除 电测检验 记录（仅草稿）
     */
    @PostMapping("/delete/{recordId}")
    public Result<String> deleteElectricalTestRecord(@PathVariable String recordId, HttpServletRequest request) {
        String employeeId = (String) request.getAttribute("current_employee_id");
        try {
            electricalTestService.deleteElectricalTestRecord(recordId, employeeId);
            return Result.success("删除成功");
        } catch (RuntimeException e) {
            log.error("删除电测检验记录失败: {}", e.getMessage());
            return Result.error(400, e.getMessage());
        }
    }

    /**
     * PAD 打印标签 - TODO: 待对接硬件
     */
    @PostMapping("/print-label")
    public Result<String> printLabel(@RequestBody Map<String, Object> data) {
        // TODO: 对接 PAD 打印硬件
        // 预期参数: modelName(型号), qty(数量), forkQty(叉数)
        log.info("打印标签请求（功能待对接）: {}", data);
        return Result.success("打印功能待对接");
    }

    /**
     * 根据批次查询已录入的总数量
     */
    @GetMapping("/getLotSumQty")
    public Result<Map<String, Object>> getLotSumQty(@RequestParam String lotCode,@RequestParam String recordId) {
        if(recordId==null){
            recordId="1";
        }
        int qty=0;
        int totalQty=0;
        try{
            Map<String, Object> data = new HashMap<>();
            Prp_lot prplotInfo=mesService.lotfindbyLotname(lotCode).get(0);
            try{
                if(recordId.equals("")){
                    recordId="1";
                }
                totalQty=electricalTestService.getSumByLotCode(lotCode,recordId);
            }catch(Exception e){
                totalQty=0;
            }
            int intNum = prplotInfo.getTotalqty().intValue();
            qty=intNum-totalQty;
            data.put("remainTotalQty", qty);
            return Result.success(data);
        }catch(Exception e){
            qty=0;
            return Result.error(404, "查询剩余数量报错");
        }
    }
}
