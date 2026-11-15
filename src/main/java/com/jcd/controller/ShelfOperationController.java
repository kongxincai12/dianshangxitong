package com.jcd.controller;

import com.jcd.dto.*;
import com.jcd.model.ShelfRackConfig;
import com.jcd.service.SmartShelfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 智能货架操作Controller - 供UniApp前端调用
 * 路径: /api/shelf/
 * 返回格式: 标准 ResponseDTO
 */
@RestController
@RequestMapping("/api/shelf")
public class ShelfOperationController {

    private static final Logger logger = LoggerFactory.getLogger(ShelfOperationController.class);

    @Autowired
    private SmartShelfService smartShelfService;

    /**
     * 校验货架编号
     * 扫描货架后调用，返回货架信息及其下所有储位
     */
    @PostMapping("/validate-rack")
    public ResponseDTO<ShelfValidateRackResponse> validateRack(@RequestBody java.util.Map<String, String> params) {
        try {
            String rackCode = params.get("rackCode");
            if (rackCode == null || rackCode.trim().isEmpty()) {
                return ResponseDTO.error("货架编号不能为空");
            }
            ShelfValidateRackResponse response = smartShelfService.validateRack(rackCode.trim());
            return ResponseDTO.success(response);
        } catch (Exception e) {
            logger.error("[智能货架] 校验货架失败: {}", e.getMessage(), e);
            return ResponseDTO.error(e.getMessage());
        }
    }

    /**
     * 入库前查询是否需要确认SMT直接退料数量
     */
    @PostMapping("/inbound-preview")
    public ResponseDTO<ShelfInboundPreviewResponse> previewInbound(@RequestBody java.util.Map<String, String> params) {
        try {
            String upnname = params.get("upnname");
            String userId = params.get("userId");
            if (upnname == null || upnname.trim().isEmpty()) {
                return ResponseDTO.error("UPN不能为空");
            }
            ShelfInboundPreviewResponse response = smartShelfService.previewInbound(upnname.trim(), userId);
            return ResponseDTO.success(response);
        } catch (Exception e) {
            logger.error("[智能货架] 入库预检查失败: {}", e.getMessage(), e);
            return ResponseDTO.error(e.getMessage());
        }
    }

    /**
     * 准备入库/移库操作
     * 扫UPN后调用，创建待处理记录，等待货架StatusChanged回调
     */
    @PostMapping("/prepare")
    public ResponseDTO<ShelfOperationStatusDTO> prepareOperation(@RequestBody ShelfPrepareRequest request) {
        try {
            ShelfOperationStatusDTO status = smartShelfService.prepareOperation(request);
            return ResponseDTO.success(status);
        } catch (Exception e) {
            logger.error("[智能货架] 准备操作失败: {}", e.getMessage(), e);
            return ResponseDTO.error(e.getMessage());
        }
    }

    /**
     * 查询操作状态（前端轮询）
     * 前端每2秒调用一次，直到状态非PENDING
     */
    @GetMapping("/status/{operationId}")
    public ResponseDTO<ShelfOperationStatusDTO> getOperationStatus(@PathVariable String operationId) {
        try {
            ShelfOperationStatusDTO status = smartShelfService.getOperationStatus(operationId);
            return ResponseDTO.success(status);
        } catch (Exception e) {
            logger.error("[智能货架] 查询操作状态失败: {}", e.getMessage(), e);
            return ResponseDTO.error(e.getMessage());
        }
    }

    /**
     * 取消待处理操作
     */
    @PostMapping("/cancel/{operationId}")
    public ResponseDTO<String> cancelOperation(@PathVariable String operationId) {
        try {
            smartShelfService.cancelOperation(operationId);
            return ResponseDTO.success("取消成功", null);
        } catch (Exception e) {
            logger.error("[智能货架] 取消操作失败: {}", e.getMessage(), e);
            return ResponseDTO.error(e.getMessage());
        }
    }

    /**
     * 根据料架取消所有待处理操作并关闭全部灯
     */
    @PostMapping("/cancel-by-rack")
    public ResponseDTO<String> cancelByRack(@RequestBody java.util.Map<String, String> params) {
        try {
            String rackCode = params.get("rackCode");
            if (rackCode == null || rackCode.trim().isEmpty()) {
                return ResponseDTO.error("料架编号不能为空");
            }
            smartShelfService.cancelByRack(rackCode.trim());
            return ResponseDTO.success("取消成功", null);
        } catch (Exception e) {
            logger.error("[智能货架] 按料架取消操作失败: {}", e.getMessage(), e);
            return ResponseDTO.error(e.getMessage());
        }
    }

    /**
     * 根据UPN取消所有待处理操作（清理残留操作）
     */
    @PostMapping("/cancel-by-upn")
    public ResponseDTO<String> cancelByUpn(@RequestBody java.util.Map<String, String> params) {
        try {
            String upnname = params.get("upnname");
            if (upnname == null || upnname.trim().isEmpty()) {
                return ResponseDTO.error("UPN不能为空");
            }
            smartShelfService.cancelByUpn(upnname.trim());
            return ResponseDTO.success("取消成功", null);
        } catch (Exception e) {
            logger.error("[智能货架] 按UPN取消操作失败: {}", e.getMessage(), e);
            return ResponseDTO.error(e.getMessage());
        }
    }

    /**
     * 手动亮灯 (需提供rackCode用于解析IP)
     */
    @PostMapping("/light-on")
    public ResponseDTO<String> lightOn(@RequestBody java.util.Map<String, Object> params) {
        try {
            String rackCode = (String) params.get("rackCode");
            String locationId = (String) params.get("locationId");
            Integer lightColor = (Integer) params.getOrDefault("lightColor", 64);
            Integer twinkle = (Integer) params.getOrDefault("twinkle", 0);
            if (locationId == null || locationId.trim().isEmpty()) {
                return ResponseDTO.error("储位编码不能为空");
            }
            String shelfBaseUrl = smartShelfService.resolveShelfBaseUrl(rackCode);
            smartShelfService.callShelfLight(shelfBaseUrl, locationId.trim(), lightColor, twinkle);
            return ResponseDTO.success("亮灯成功", null);
        } catch (Exception e) {
            logger.error("[智能货架] 亮灯失败: {}", e.getMessage(), e);
            return ResponseDTO.error(e.getMessage());
        }
    }

    /**
     * 手动灭灯 (需提供rackCode用于解析IP)
     */
    @PostMapping("/light-off")
    public ResponseDTO<String> lightOff(@RequestBody java.util.Map<String, String> params) {
        try {
            String rackCode = params.get("rackCode");
            String locationId = params.get("locationId");
            if (locationId == null || locationId.trim().isEmpty()) {
                return ResponseDTO.error("储位编码不能为空");
            }
            String shelfBaseUrl = smartShelfService.resolveShelfBaseUrl(rackCode);
            smartShelfService.callShelfLightOff(shelfBaseUrl, locationId.trim());
            return ResponseDTO.success("灭灯成功", null);
        } catch (Exception e) {
            logger.error("[智能货架] 灭灯失败: {}", e.getMessage(), e);
            return ResponseDTO.error(e.getMessage());
        }
    }

    // ===================== 货架配置管理 =====================

    /**
     * 查询所有货架IP配置
     */
    @GetMapping("/config/list")
    public ResponseDTO<List<ShelfRackConfig>> listRackConfigs() {
        try {
            List<ShelfRackConfig> configs = smartShelfService.getAllRackConfigs();
            return ResponseDTO.success(configs);
        } catch (Exception e) {
            logger.error("[智能货架] 查询配置失败: {}", e.getMessage(), e);
            return ResponseDTO.error(e.getMessage());
        }
    }

    /**
     * 保存货架IP配置（新增或更新）
     */
    @PostMapping("/config/save")
    public ResponseDTO<String> saveRackConfig(@RequestBody ShelfRackConfig config) {
        try {
            smartShelfService.saveRackConfig(config);
            return ResponseDTO.success("保存成功", null);
        } catch (Exception e) {
            logger.error("[智能货架] 保存配置失败: {}", e.getMessage(), e);
            return ResponseDTO.error(e.getMessage());
        }
    }

    /**
     * 删除货架IP配置
     */
    @DeleteMapping("/config/{configId}")
    public ResponseDTO<String> deleteRackConfig(@PathVariable String configId) {
        try {
            smartShelfService.deleteRackConfig(configId);
            return ResponseDTO.success("删除成功", null);
        } catch (Exception e) {
            logger.error("[智能货架] 删除配置失败: {}", e.getMessage(), e);
            return ResponseDTO.error(e.getMessage());
        }
    }
}
