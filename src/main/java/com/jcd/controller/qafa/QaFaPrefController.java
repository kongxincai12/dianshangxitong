package com.jcd.controller.qafa;

import com.jcd.exception.BusinessException;
import com.jcd.service.qafa.QaFaUserPrefService;
import com.jcd.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/qa-fa/pref")
public class QaFaPrefController {

    @Autowired private QaFaUserPrefService prefService;

    /** GET /api/qa-fa/pref/{key} */
    @GetMapping("/{key}")
    public Result<?> get(@PathVariable String key, HttpServletRequest request) {
        try {
            String userId = (String) request.getAttribute("current_employee_id");
            if (userId == null) return Result.error(401, "未登录");
            Map<String, Object> data = new HashMap<>();
            data.put("key", key);
            data.put("value", prefService.get(userId, key));
            return Result.success(data);
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("查询失败: " + e.getMessage());
        }
    }

    /** PUT/POST /api/qa-fa/pref  body: { key, value } */
    @RequestMapping(method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<?> set(@RequestBody Map<String, String> body, HttpServletRequest request) {
        try {
            String userId = (String) request.getAttribute("current_employee_id");
            if (userId == null) return Result.error(401, "未登录");
            String key = body.get("key");
            String value = body.get("value");
            if (key == null || key.isEmpty()) return Result.error(400, "key 必填");
            prefService.set(userId, key, value == null ? "" : value);
            return Result.success(null);
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("保存失败: " + e.getMessage());
        }
    }
}
