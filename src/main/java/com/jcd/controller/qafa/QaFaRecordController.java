package com.jcd.controller.qafa;

import com.jcd.dto.qafa.QaFaCreateRecordDto;
import com.jcd.dto.qafa.QaFaSaveProdDto;
import com.jcd.dto.qafa.QaFaSaveQcDto;
import com.jcd.dto.qafa.QaFaStageJudgeDto;
import com.jcd.dto.qafa.QaFaTransitionDto;
import com.jcd.exception.BusinessException;
import com.jcd.model.qafa.QaFaRecord;
import com.jcd.service.qafa.QaFaRecordService;
import com.jcd.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/qa-fa")
public class QaFaRecordController {

    @Autowired private QaFaRecordService recordService;

    /* ---------------- 批次校验 ---------------- */

    @PostMapping("/lot/check")
    public Result<?> checkLot(@RequestBody Map<String, String> body) {
        try {
            return Result.success(recordService.checkLot(body == null ? null : body.get("lotName")));
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("批次校验失败: " + e.getMessage());
        }
    }

    /* ---------------- 创建/详情 ---------------- */

    @PostMapping("/records")
    public Result<?> create(@RequestBody QaFaCreateRecordDto dto, HttpServletRequest request) {
        try {
            String userId = userId(request);
            QaFaRecord r = recordService.createRecord(dto, userId, userId);
            return Result.success(r);
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("创建失败: " + e.getMessage());
        }
    }

    @GetMapping("/records/{id}")
    public Result<?> detail(@PathVariable String id) {
        try {
            return Result.success(recordService.getDetail(id));
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("查询详情失败: " + e.getMessage());
        }
    }

    /* ---------------- 生产端 ---------------- */

    @RequestMapping(value = "/records/{id}/prod", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<?> saveProd(@PathVariable String id, @RequestBody QaFaSaveProdDto dto, HttpServletRequest request) {
        try {
            String userId = userId(request);
            recordService.saveProd(id, dto, userId, userId);
            return Result.success(null);
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("保存失败: " + e.getMessage());
        }
    }

    @PostMapping("/records/{id}/submit-prod")
    public Result<?> submitProd(@PathVariable String id, HttpServletRequest request) {
        try {
            String userId = userId(request);
            recordService.submitProd(id, userId, userId);
            return Result.success(null);
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("提交失败: " + e.getMessage());
        }
    }

    /* ---------------- 品管端 ---------------- */

    @RequestMapping(value = "/records/{id}/qc", method = {RequestMethod.PUT, RequestMethod.POST})
    public Result<?> saveQc(@PathVariable String id, @RequestBody QaFaSaveQcDto dto, HttpServletRequest request) {
        try {
            String userId = userId(request);
            recordService.saveQc(id, dto, userId, userId);
            return Result.success(null);
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("保存失败: " + e.getMessage());
        }
    }

    @PostMapping("/records/{id}/transition")
    public Result<?> transition(@PathVariable String id, @RequestBody QaFaTransitionDto dto, HttpServletRequest request) {
        try {
            String userId = userId(request);
            recordService.transition(id, dto, userId, userId);
            return Result.success(null);
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("操作失败: " + e.getMessage());
        }
    }

    @PostMapping("/records/{id}/stages/{stageCode}/judge")
    public Result<?> judgeStage(@PathVariable String id,
                                @PathVariable String stageCode,
                                @RequestBody QaFaStageJudgeDto dto,
                                HttpServletRequest request) {
        try {
            String userId = userId(request);
            if (dto == null) {
                dto = new QaFaStageJudgeDto();
            }
            dto.setStageCode(stageCode);
            recordService.judgeStage(id, dto, userId, userId);
            return Result.success(null);
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("阶段判定失败: " + e.getMessage());
        }
    }

    @DeleteMapping("/records/{id}")
    public Result<?> delete(@PathVariable String id, HttpServletRequest request) {
        return deleteRecord(id, request);
    }

    @PostMapping("/records/{id}/delete")
    public Result<?> deleteByPost(@PathVariable String id, HttpServletRequest request) {
        return deleteRecord(id, request);
    }

    private Result<?> deleteRecord(String id, HttpServletRequest request) {
        try {
            String userId = userId(request);
            recordService.deleteRecord(id, userId);
            return Result.success(null);
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("删除失败: " + e.getMessage());
        }
    }

    /* ---------------- 列表 ---------------- */

    @GetMapping("/records")
    public Result<?> list(@RequestParam(required = false) List<String> status,
                          @RequestParam(required = false) String processCode,
                          @RequestParam(required = false) String lotName,
                          @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateFrom,
                          @RequestParam(required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateTo,
                          @RequestParam(required = false, defaultValue = "false") boolean mineOnly,
                          @RequestParam(required = false, defaultValue = "1") int pageNo,
                          @RequestParam(required = false, defaultValue = "20") int pageSize,
                          HttpServletRequest request) {
        try {
            String owner = mineOnly ? userId(request) : null;
            return Result.success(recordService.queryList(status, processCode, lotName, dateFrom, dateTo, owner, pageNo, pageSize));
        } catch (BusinessException e) {
            return Result.error(e.getCode(), e.getMessage());
        } catch (Exception e) {
            return Result.fail("查询失败: " + e.getMessage());
        }
    }

    /* ---------------- helper ---------------- */

    private String userId(HttpServletRequest request) {
        String id = (String) request.getAttribute("current_employee_id");
        if (id == null || id.isEmpty()) {
            throw new BusinessException(401, "未登录或登录已过期");
        }
        return id;
    }
}
