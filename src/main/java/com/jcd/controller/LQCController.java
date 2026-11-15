package com.jcd.controller;

import com.jcd.dto.*;
import com.jcd.model.Prp_lot;
import com.jcd.service.MesService;
import com.jcd.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/lqc")


public class LQCController {//LQC (Line Quality Control)： 生产线快速抽检

    @Autowired
    private MesService mesService;
    @Autowired
    private JwtUtils jwtUtils;


    @PostMapping("/getlotinfo")
    public ResponseEntity<Map<String, Object>> getlotinfo(@RequestBody Map<String, String> requestBody){
        Map<String, Object> response = new HashMap<>();
        String lotname = requestBody.get("lotname");
        List<Prp_lot> lots = mesService.lotfindbyLotname(lotname);
        if (lots != null && !lots.isEmpty()) {
            Prp_lot lot = lots.get(0);
            Map<String, Object> data = new HashMap<>();
            data.put("lotname", lot.getLotname());
            data.put("productPn", lot.getProductpn());
            data.put("totalQty", lot.getTotalqty());
            data.put("panelpcs", lot.getPanelpcs());

            response.put("code", 200);
            response.put("message", "查询成功");
            response.put("data", data);

            return ResponseEntity.ok(response);
        } else {
            response.put("code", 404);
            response.put("message", "未找到该批次信息");
            response.put("data", null);

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
        }
    }

    @PostMapping("/get-inspection-data")
    public ResponseEntity<Map<String, Object>> getInspectionData(@RequestBody Map<String, String> requestBody) {
        Map<String, Object> response = new HashMap<>();
        try {
            String date = requestBody.get("date");
            String shift = requestBody.get("shift");
            String lotname = requestBody.get("lotname");
            String site = requestBody.get("site");

            InspectionDataDto data = mesService.getInspectionData(date, shift, lotname,site);
            response.put("code", 200);
            response.put("message", "查询成功");
            response.put("data", data);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("code", 500);
            response.put("message", "查询失败: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }


    @GetMapping("/presets")
    public ResponseEntity<Map<String, Object>> getPresetDefectsBySite(@RequestParam String site) {
        Map<String, Object> response = new HashMap<>();

        List<String> defectNames = mesService.findDefectNamesBySite(site);
        response.put("code", 200);
        response.put("message", "查询成功");
        response.put("data", defectNames);

        return ResponseEntity.ok(response);
    }


    @PostMapping("/upsert-inspection")
    public ResponseEntity<Map<String, Object>> saveInspection(@RequestBody LqcRecordDto recordDto, HttpServletRequest request) {
        Map<String, Object> response = new HashMap<>();
        try {
            // 从Token中解析出当前操作员的用户名
            String authHeader = request.getHeader("Authorization");
            String token = authHeader.substring(7);
            String username = jwtUtils.extractUserid(token); // 假设Token的主体就是用户名

            mesService.upsertLqcRecord(recordDto, username);

            response.put("code", 200);
            response.put("message", "保存成功");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            // 在实际项目中，这里应该进行更详细的日志记录
            e.printStackTrace();
            response.put("code", 500);
            response.put("message", "保存失败：" + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }

    @GetMapping("/tasks")
    public ResponseEntity<Map<String, Object>> getTasks(@RequestParam String date, HttpServletRequest request) {
        Map<String, Object> response = new HashMap<>();
        try {
            // 1. 从请求头中获取 Authorization 字段
            String authHeader = request.getHeader("Authorization");
            if (authHeader == null || !authHeader.startsWith("Bearer ")) {
                response.put("code", 401);
                response.put("message", "请求未包含有效的Token");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
            }

            // 2. 截取 "Bearer " 前缀，得到纯净的 Token 字符串
            String token = authHeader.substring(7);

            // 3. 【核心】调用 jwtUtils 从 Token 中提取角色信息
            String userRole = jwtUtils.extractRole(token);

            // 如果 Token 中没有角色信息，可以给一个默认值或直接报错
            if (userRole == null || userRole.isEmpty()) {
                response.put("code", 403);
                response.put("message", "Token中缺少角色信息，权限不足");
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body(response);
            }

            List<TaskDto> tasks = mesService.getTasksForUser(userRole, date);

            response.put("code", 200);
            response.put("message", "查询成功");
            response.put("data", tasks);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("code", 500);
            response.put("message", "查询任务列表失败: " + e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @GetMapping("/processes")
    public ResponseEntity<Map<String, Object>> getProcesses() {
        Map<String, Object> response = new HashMap<>();
        try {
            List<ProcessDto> processes = mesService.getProcessList();
            response.put("code", 200);
            response.put("message", "查询成功");
            response.put("data", processes);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            response.put("code", 500);
            response.put("message", "查询工序列表失败: " + e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @GetMapping("/summary")
    public ResponseEntity<Map<String, Object>> getSummaryData(
            @RequestParam String date,
            @RequestParam String site,
            @RequestParam String shift) {

        Map<String, Object> response = new HashMap<>();
        try {
            ApprovalDataDto data = mesService.getApprovalData(date, site, shift);
            response.put("code", 200);
            response.put("message", "查询成功");
            response.put("data", data);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            response.put("code", 500);
            response.put("message", "查询汇总数据失败: " + e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    @PostMapping("/confirm")
    public ResponseEntity<Map<String, Object>> confirmRecords(@RequestBody Map<String, String> payload, HttpServletRequest request) {
        Map<String, Object> response = new HashMap<>();
        try {
            String date = payload.get("date");
            String site = payload.get("site");
            String shift = payload.get("shift");
            String currentStatus = payload.get("status");
            String newStatus = payload.get("newStatus");

            String token = request.getHeader("Authorization").substring(7);
            String username = jwtUtils.extractUserid(token);

            mesService.confirmRecords(date, site, shift, currentStatus, newStatus, username);

            response.put("code", 200);
            response.put("message", "确认成功");
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            e.printStackTrace();
            response.put("code", 500);
            response.put("message", "确认失败: " + e.getMessage());
            return ResponseEntity.internalServerError().body(response);
        }
    }

    // helloworld 方法可以保持不变，或同样用 ResponseEntity 改造
    @GetMapping("/helloworld")
    public ResponseEntity<Map<String, Object>> helloworld() {
        Map<String, Object> response = new HashMap<>();
        response.put("code", 200);
        response.put("message", "helloworld！");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/latest-version")
    public ResponseEntity<Map<String, Object>> getLatestVersion() {
        // --- 在这里定义您App的最新版本信息 ---
        // TODO: 未来可以从数据库或配置文件动态获取
        String latestVersion = "1.0.1";
        String downloadUrl = "http://10.10.100.208:9999/PDA/c71eb570-aeb1-4518-98eb-1442147da213.apk"; // 替换为您的真实APK或wgt包下载地址
        String updateNotes = "1. 优化了登录体验。\n2. 修复了一些已知问题。";
        // ------------------------------------

        AppVersionDto versionDto = new AppVersionDto(latestVersion, downloadUrl, updateNotes);

        // 使用一个通用的Map结构返回，与您现有的API格式保持一致
        Map<String, Object> response = new HashMap<>();
        response.put("code", 200);
        response.put("message", "获取成功");
        response.put("data", versionDto);

        return ResponseEntity.ok(response);
    }

}
