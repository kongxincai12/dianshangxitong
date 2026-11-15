package com.jcd.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.jcd.config.WebSocketServer;
import com.jcd.dto.*;
import com.jcd.exception.BusinessException;
import com.jcd.service.Impl.PackingServiceImpl;
import com.jcd.utils.Result;
import com.jcd.vo.ApiResponse;
//import org.java_websocket.server.WebSocketServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/mes")
public class PackingController {

    @Autowired
    private PackingServiceImpl packingService;
    /**
     * 新增包装作业数据
     * @param recordDto 前端提交的包装作业数据
     * @return 成功响应
     */
    @PostMapping("/production/packing/add")
    public Result<?> addPackingProduction(@RequestBody AddPackingRecordDto recordDto) {
        try{
            packingService.addPackingRecord(recordDto);
        }catch(Exception e){
            throw new BusinessException("新增失败!");
        }

        return Result.success(null);
    }

    /**
     * 获取包装记录列表
     */
    @GetMapping("/production/packing/list")
    public ResponseEntity<ApiResponse<List<AddPackingRecordDto>>> getProductionPackingList(
            @RequestParam String employeeId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date,
            @RequestParam String site) {
        List<AddPackingRecordDto> list = packingService.findProductionPackingRecords(employeeId, date, site);
        return ResponseEntity.ok(ApiResponse.success(list));
    }

    /**
     * 获取包装记录列表
     */
    @GetMapping("/production/packing/delete")
    public Result<?> deletePackingRecord(@RequestParam String id) {
            try{
                  packingService.deletePackingRecord(id);
            }catch(Exception e){
                throw new BusinessException("删除失败!");
            }
            return Result.success(null);
    }

    /**
     * 修改包装作业数据
     * @param recordDto 前端提交的包装作业数据
     * @return 成功响应
     */
    @PostMapping("/production/packing/update")
    public Result<?>  updatePackingRecord(@RequestBody AddPackingRecordDto recordDto) {
           // try{
                packingService.updatePackingRecord(recordDto);
            //}catch(Exception e){
              //  throw new BusinessException("更新失败!");
            //}
            return Result.success(null);
    }


    /**
     * 新增包装作业数据并打印
     * @param recordDto 前端提交的包装作业数据
     * @return 成功响应
     */
    @PostMapping("/production/packing/addAndPrint")
    public Result<?> addPackingProductionAndPrint(@RequestBody AddPackingRecordDto recordDto) throws JsonProcessingException {

        try{
            packingService.addPackingRecord(recordDto);
        }
        catch(Exception e)
        {
            throw new BusinessException("更新失败!");
        }

        //打印模块
        //将获取的数据用@串成字符串
        /*try
        {
            String printData=recordDto.getId()+"@"+recordDto.getEmployeeId()+"@"+recordDto.getLotCode()+"@"+
                    recordDto.getMaterials()+"@"+recordDto.getPnl()+"@"+recordDto.getPcs()+"@"+recordDto.getQty()+"@"+
                    recordDto.getDateCode()+"@"+recordDto.getCreateTime();
            if(WebSocketServer.map.get("userId").toString()!=null){
                WebSocketServer.sendToClient(WebSocketServer.map.get("userId").toString(),printData);
            }
        }
        catch(Exception e)
        {
            throw new BusinessException("打印失败!连接websocket失败，请检查是否打开websocket客户端");
        }*/

        return Result.success(null);
    }

    /**
     * 发送websocket消息给指定客户端
     */
    @PostMapping("/production/packing/print")
    public Result<?> printPackingRecord(@RequestBody AddPackingRecordDto recordDto) {
        //将获取的数据串成字符串
        try
        {
                    /*String printData=recordDto.getId()+"@"+recordDto.getEmployeeId()+"@"+recordDto.getLotCode()+"@"+
                            recordDto.getMaterials()+"@"+recordDto.getPnl()+"@"+recordDto.getPcs()+"@"+recordDto.getQty()+"@"+
                            recordDto.getDateCode()+"@"+recordDto.getCreateTime();
                    if(WebSocketServer.map.get("userId").toString()!=null){
                        WebSocketServer.sendToClient(WebSocketServer.map.get("userId").toString(),printData);
                    }*/
        }
        catch(Exception e)
        {
            throw new BusinessException("打印失败!连接websocket失败，请检查是否打开websocket客户端");
        }

        return Result.success(null);

    }

}