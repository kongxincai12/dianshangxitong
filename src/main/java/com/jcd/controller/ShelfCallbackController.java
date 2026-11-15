package com.jcd.controller;

import com.jcd.dto.ShelfCallbackResponse;
import com.jcd.dto.ShelfStatusChangedRequest;
import com.jcd.service.SmartShelfService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 智能货架硬件回调Controller
 * 接收货架系统主动推送的回调请求
 * <p>
 * 注意: 返回格式遵循货架厂商规范 {Result: 0/1, Message: "..."}
 * 而非项目标准的 ResponseDTO
 * <p>
 * 本服务(z:\pdaserver port 9900)是货架硬件回调和前端App的统一入口，
 * PENDING操作在本服务内存中，所有回调由本服务直接处理。
 * y:\pdaserver(port 7007)仅用于备料亮灯(MaterialCalculation)场景，
 * 两者各自独立处理各自的业务回调，互不转发。
 */
@RestController
@RequestMapping("/WmsApi")
public class ShelfCallbackController {

    private static final Logger logger = LoggerFactory.getLogger(ShelfCallbackController.class);

    @Autowired
    private SmartShelfService smartShelfService;

    /**
     * 3.3 感应式灯条反馈 - 储位状态变更回调
     * 货架硬件检测到物料放入/取走时调用此接口
     *
     * 处理策略: 本地直接处理，不转发
     * - State=0 (取走): 检查非法取料
     * - State=1 (放入): 匹配PENDING操作执行入库/移库
     */
    @PostMapping("/StatusChanged/")
    public ShelfCallbackResponse statusChanged(@RequestBody ShelfStatusChangedRequest request) {
        try {
            logger.info("[货架回调] 收到StatusChanged: LocationId={}, State={}, LightColor={}",
                    request.getLocationId(), request.getState(), request.getLightColor());

            ShelfCallbackResponse response = smartShelfService.handleStatusChanged(request);

            logger.info("[货架回调] StatusChanged处理完成: LocationId={}, Result={}, Message={}",
                    request.getLocationId(), response.getResult(), response.getMessage());

            return response;
        } catch (Exception e) {
            logger.error("[货架回调] StatusChanged处理异常: {}", e.getMessage(), e);
            return ShelfCallbackResponse.fail("处理异常: " + e.getMessage());
        }
    }

    /**
     * 3.8 扫码枪扫码反馈 (预留)
     */
    @PostMapping("/ScanChanged/")
    public ShelfCallbackResponse scanChanged(@RequestBody java.util.Map<String, Object> request) {
        String locationId = (String) request.get("LocationId");
        String barCode = (String) request.get("BarCode");
        logger.info("[货架回调] ScanChanged: LocationId={}, BarCode={}", locationId, barCode);
        return ShelfCallbackResponse.success("扫码接收成功");
    }

    /**
     * 4.1 自检反馈 (预留)
     */
    @PostMapping("/Self_Checking/")
    public ShelfCallbackResponse selfChecking(@RequestBody java.util.Map<String, Object> request) {
        logger.info("[货架回调] Self_Checking: {}", request);
        return ShelfCallbackResponse.success("自检接收成功");
    }

    /**
     * 3.4 900U 拍灯反馈 (预留)
     */
    @PostMapping("/ptl900U_Pressed/")
    public ShelfCallbackResponse ptl900UPressed(@RequestBody java.util.Map<String, Object> request) {
        logger.info("[货架回调] ptl900U_Pressed: {}", request);
        return ShelfCallbackResponse.success("拍灯接收成功");
    }
}
