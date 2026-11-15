package com.jcd.controller;

import com.jcd.dto.FqcRecordDto;
import com.jcd.model.Prp_lot;
import com.jcd.service.FqcService;
import com.jcd.service.MesService;
import com.jcd.utils.Result;
import com.jcd.vo.FqcRecordVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/fqc")
public class FqcController {

    private static final Logger log = LoggerFactory.getLogger(FqcController.class);

    @Autowired
    private FqcService fqcService;

    @Autowired
    private MesService mesService;

    /**
     * 根据批次号查询批次信息（型号等）
     */
    @GetMapping("/lot-info")
    public Result<Map<String, Object>> getLotInfo(@RequestParam String lotCode) {
        List<Prp_lot> lots = mesService.lotfindbyLotname(lotCode);

        if (lots != null && !lots.isEmpty()) {
            Prp_lot lot = lots.get(0);
            Map<String, Object> data = new HashMap<>();
            data.put("lotCode", lot.getLotname());
            data.put("modelName", lot.getProductpn());
            data.put("totalQty", lot.getTotalqty());
            data.put("panelPcs", lot.getPanelpcs());
            //获取标准产能
            int standardCapacity=fqcService.selectStandardCapacity(lot.getProductpn());
            data.put("standardCapacity", standardCapacity);
            return Result.success(data);
        } else {
            return Result.error(404, "未找到该批次信息");
        }
    }

    /**
     * 检查当前用户 FQC 权限
     */
    @GetMapping("/permission")
    public Result<Map<String, Object>> checkPermission(HttpServletRequest request) {
        String employeeId = (String) request.getAttribute("current_employee_id");
        boolean hasPermission = fqcService.checkFqcPermission(employeeId);
        Map<String, Object> result = new HashMap<>();
        result.put("hasPermission", hasPermission);
        return Result.success(result);
    }

    /**
     * 获取 FQC 预设缺陷列表
     */
    @GetMapping("/defect-presets")
    public Result<List<Map<String, String>>> getDefectPresets() {
        List<Map<String, String>> presets = fqcService.getFqcDefectPresets();
        return Result.success(presets);
    }

    /**
     * 获取 CCD 预设缺陷列表
     */
    @GetMapping("/ccd-defect-presets")
    public Result<List<Map<String, String>>> getCcdDefectPresets() {
        List<Map<String, String>> presets = fqcService.getCcdDefectPresets();
        return Result.success(presets);
    }

    /**
     * 保存/更新 FQC 记录（自动保存调用）
     */
    @PostMapping("/save")
    public Result<FqcRecordVo> saveFqcRecord(@RequestBody FqcRecordDto dto, HttpServletRequest request) {
        String employeeId = (String) request.getAttribute("current_employee_id");
        // 获取员工姓名（从登录时存的属性或通过 employeeId 查询）
        String employeeName = (String) request.getAttribute("current_employee_name");
        if (employeeName == null) {
            employeeName = employeeId; // fallback
        }
        try {
            FqcRecordVo vo = fqcService.saveOrUpdateFqcRecord(dto, employeeId, employeeName);
            return Result.success(vo);
        } catch (RuntimeException e) {
            log.error("保存FQC记录失败: {}", e.getMessage());
            return Result.error(400, e.getMessage());
        }
    }

    /**
     * 提交 FQC 记录
     */
    @PostMapping("/submit/{recordId}")
    public Result<String> submitFqcRecord(@PathVariable String recordId, HttpServletRequest request) {
        String employeeId = (String) request.getAttribute("current_employee_id");
        try {
            fqcService.submitFqcRecord(recordId, employeeId);
            return Result.success("提交成功");
        } catch (RuntimeException e) {
            log.error("提交FQC记录失败: {}", e.getMessage());
            return Result.error(400, e.getMessage());
        }
    }

    /**
     * 撤回编辑（仅当天可撤回）
     */
    @PostMapping("/reopen/{recordId}")
    public Result<String> reopenFqcRecord(@PathVariable String recordId, HttpServletRequest request) {
        String employeeId = (String) request.getAttribute("current_employee_id");
        try {
            fqcService.reopenFqcRecord(recordId, employeeId);
            return Result.success("已撤回，可以继续编辑");
        } catch (RuntimeException e) {
            log.error("撤回FQC记录失败: {}", e.getMessage());
            return Result.error(400, e.getMessage());
        }
    }

    /**
     * 获取记录列表（按日期）
     */
    @GetMapping("/records")
    public Result<List<FqcRecordVo>> getFqcRecordList(
            @RequestParam String date,
            HttpServletRequest request) {
        String employeeId = (String) request.getAttribute("current_employee_id");
        try {
            Date inspDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            List<FqcRecordVo> list = fqcService.getFqcRecordList(employeeId, inspDate);
            return Result.success(list);
        } catch (ParseException e) {
            return Result.error(400, "日期格式错误，请使用 yyyy-MM-dd");
        }
    }

    /**
     * 获取单条记录详情
     */
    @GetMapping("/records/{recordId}")
    public Result<FqcRecordVo> getFqcRecordById(@PathVariable String recordId) {
        try {
            FqcRecordVo vo = fqcService.getFqcRecordById(recordId);
            return Result.success(vo);
        } catch (RuntimeException e) {
            return Result.error(404, e.getMessage());
        }
    }

    /**
     * 按批次号查重（扫码后查找同批次同天记录）
     */
    @GetMapping("/records/by-lot")
    public Result<List<FqcRecordVo>> getRecordsByLot(
            @RequestParam String lotCode,
            @RequestParam String date) {
        try {
            Date inspDate = new SimpleDateFormat("yyyy-MM-dd").parse(date);
            List<FqcRecordVo> list = fqcService.getRecordsByLotAndDate(lotCode, inspDate);
            return Result.success(list);
        } catch (ParseException e) {
            return Result.error(400, "日期格式错误，请使用 yyyy-MM-dd");
        }
    }

    /**
     * 删除 FQC 记录（仅草稿）
     */
    @PostMapping("/delete/{recordId}")
    public Result<String> deleteFqcRecord(@PathVariable String recordId, HttpServletRequest request) {
        String employeeId = (String) request.getAttribute("current_employee_id");
        try {
            fqcService.deleteFqcRecord(recordId, employeeId);
            return Result.success("删除成功");
        } catch (RuntimeException e) {
            log.error("删除FQC记录失败: {}", e.getMessage());
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
}
