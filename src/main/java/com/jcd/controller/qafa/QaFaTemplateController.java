package com.jcd.controller.qafa;

import com.jcd.dto.qafa.QaFaTemplateSaveDto;
import com.jcd.exception.BusinessException;
import com.jcd.service.qafa.QaFaTemplateService;
import com.jcd.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api/qa-fa/templates")
public class QaFaTemplateController {

    @Autowired
    private QaFaTemplateService templateService;

    /** GET /api/qa-fa/templates?processCode=DJ */
    @GetMapping
    public Result<?> list(@RequestParam(required = false) String processCode) {
        try {
            return Result.success(templateService.listActive(processCode));
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("查询模板失败: " + e.getMessage());
        }
    }

    /** GET /api/qa-fa/templates/processes */
    @GetMapping("/processes")
    public Result<?> processes() {
        try {
            return Result.success(templateService.listActiveProcesses());
        } catch (Exception e) {
            return Result.fail("查询工序失败: " + e.getMessage());
        }
    }

    /** GET /api/qa-fa/templates/{id} */
    @GetMapping("/{id}")
    public Result<?> detail(@PathVariable String id) {
        try {
            return Result.success(templateService.getTemplateDetail(id));
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("查询模板失败: " + e.getMessage());
        }
    }

    /** POST /api/qa-fa/templates/save-active */
    @PostMapping("/save-active")
    public Result<?> saveActive(@RequestBody QaFaTemplateSaveDto dto, HttpServletRequest request) {
        try {
            return Result.success(templateService.saveActiveVersion(dto, userId(request)));
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("保存模板失败: " + e.getMessage());
        }
    }

    private String userId(HttpServletRequest request) {
        String id = (String) request.getAttribute("current_employee_id");
        if (id == null || id.isEmpty()) {
            throw new BusinessException(401, "未登录或登录已过期");
        }
        return id;
    }
}
