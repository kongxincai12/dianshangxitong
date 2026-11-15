package com.jcd.controller.qafa;

import com.jcd.exception.BusinessException;
import com.jcd.service.qafa.QaFaLabService;
import com.jcd.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/qa-fa/lab")
public class QaFaLabController {

    @Autowired private QaFaLabService labService;

    /** GET /api/qa-fa/lab/browse?path=xxx */
    @GetMapping("/browse")
    public Result<?> browse(@RequestParam(required = false, defaultValue = "") String path) {
        try {
            return Result.success(labService.browse(path));
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("浏览失败: " + e.getMessage());
        }
    }

    /** GET /api/qa-fa/lab/root */
    @GetMapping("/root")
    public Result<?> root() {
        Map<String, Object> m = new HashMap<>();
        m.put("root", labService.getRoot());
        return Result.success(m);
    }

    /** POST /api/qa-fa/lab/parse  body: { relativePath, recordId? } */
    @PostMapping("/parse")
    public Result<?> parse(@RequestBody Map<String, String> body, HttpServletRequest request) {
        try {
            String userId = (String) request.getAttribute("current_employee_id");
            if (userId == null) return Result.error(401, "未登录");
            return Result.success(labService.parseAndSave(
                    body.get("relativePath"), body.get("recordId"), userId));
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("解析失败: " + e.getMessage());
        }
    }

    /** GET /api/qa-fa/lab/list?recordId=xxx */
    @GetMapping("/list")
    public Result<?> list(@RequestParam String recordId) {
        try {
            return Result.success(labService.listByRecord(recordId));
        } catch (Exception e) {
            return Result.fail("查询失败: " + e.getMessage());
        }
    }

    /** DELETE /api/qa-fa/lab/{id} */
    @DeleteMapping("/{id}")
    public Result<?> delete(@PathVariable String id, HttpServletRequest request) {
        return deleteLabData(id, request);
    }

    /** POST /api/qa-fa/lab/{id}/delete */
    @PostMapping("/{id}/delete")
    public Result<?> deleteByPost(@PathVariable String id, HttpServletRequest request) {
        return deleteLabData(id, request);
    }

    private Result<?> deleteLabData(String id, HttpServletRequest request) {
        try {
            String userId = (String) request.getAttribute("current_employee_id");
            labService.delete(id, userId);
            return Result.success(null);
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("删除失败: " + e.getMessage());
        }
    }
}
