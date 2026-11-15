package com.jcd.service;

import com.jcd.dto.*;
import com.jcd.model.ShelfRackConfig;

import java.util.List;

/**
 * 智能货架业务服务接口
 */
public interface SmartShelfService {

    /**
     * 校验货架编号是否存在，并查询绑定的货架服务IP
     * @param rackCode 货架编号 (V_LOCATION_ALL.RACK)
     * @return 货架信息及其下所有储位 + 绑定的IP信息
     */
    ShelfValidateRackResponse validateRack(String rackCode);

    /**
     * 查询UPN本次入库是否需要确认SMT直接退料数量
     */
    ShelfInboundPreviewResponse previewInbound(String upnname, String userId);

    /**
     * 准备入库/移库操作 — 扫UPN后调用
     * 校验UPN合法性, 创建待处理记录, 等待货架StatusChanged回调
     * @param request 包含rackCode, upnname, username, operationType
     * @return 操作状态（含operationId用于轮询）
     */
    ShelfOperationStatusDTO prepareOperation(ShelfPrepareRequest request);

    /**
     * 处理货架硬件StatusChanged回调
     * 匹配待处理记录 → 执行入库或移库逻辑
     * @param request 货架回调请求（LocationId, State, LightColor, time）
     * @return 货架回调响应
     */
    ShelfCallbackResponse handleStatusChanged(ShelfStatusChangedRequest request);

    /**
     * 查询操作状态（前端轮询）
     * @param operationId 操作ID
     * @return 操作当前状态
     */
    ShelfOperationStatusDTO getOperationStatus(String operationId);

    /**
     * 取消待处理操作
     * @param operationId 操作ID
     */
    void cancelOperation(String operationId);

    /**
     * 根据UPN名称取消所有待处理操作（用于清理残留操作）
     * @param upnname UPN名称
     */
    void cancelByUpn(String upnname);

    /**
     * 根据料架编号取消该料架所有待处理操作并关闭全部灯
     * @param rackCode 料架编号
     */
    void cancelByRack(String rackCode);

    /**
     * 根据料架编号解析对应的货架服务URL
     * 从SHELF_RACK_CONFIG表查询，若未配置则返回默认URL
     * @param rackCode 料架编号
     * @return 货架服务基础URL (如 http://192.168.1.10:9090)
     */
    String resolveShelfBaseUrl(String rackCode);

    /**
     * 调用货架系统亮灯接口（PostInfo）
     * @param shelfBaseUrl 货架服务基础URL (如 http://192.168.1.10:9090)
     * @param locationId 储位编码(LOC_NAME)
     * @param lightColor 灯颜色: 0灭灯, 32红, 64绿, 96蓝, 128黄
     * @param twinkle 是否闪烁: 0不闪, 1闪烁
     */
    void callShelfLight(String shelfBaseUrl, String locationId, int lightColor, int twinkle);

    /**
     * 调用货架系统灭灯接口
     * @param shelfBaseUrl 货架服务基础URL
     * @param locationId 储位编码(LOC_NAME)
     */
    void callShelfLightOff(String shelfBaseUrl, String locationId);

    /**
     * 批量调用货架亮灯/灭灯接口（一次HTTP请求包含多个储位）
     * @param shelfBaseUrl 货架服务基础URL
     * @param details 储位灯光明细列表
     */
    void callShelfLightBatch(String shelfBaseUrl, java.util.List<ShelfPostInfoRequest.Detail> details);

    // ===================== 货架配置管理 =====================

    /**
     * 查询所有货架IP配置
     */
    List<ShelfRackConfig> getAllRackConfigs();

    /**
     * 保存货架IP配置（新增或更新）
     */
    void saveRackConfig(ShelfRackConfig config);

    /**
     * 删除货架IP配置
     */
    void deleteRackConfig(String configId);
}
