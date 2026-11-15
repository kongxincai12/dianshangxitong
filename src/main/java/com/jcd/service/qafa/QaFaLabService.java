package com.jcd.service.qafa;

import com.jcd.model.qafa.QaFaLabData;

import java.util.List;
import java.util.Map;

public interface QaFaLabService {

    /** 浏览 SMB 目录 */
    Map<String, Object> browse(String relativePath) throws Exception;

    /**
     * 解析 SMB 上的 xlsx 文件并落库到指定 record.
     * 若 recordId 为空, 仅返回解析结果不落库 (预览).
     */
    Map<String, Object> parseAndSave(String relativePath, String recordId, String userId) throws Exception;

    /** 列出 record 的实验室数据 */
    List<Map<String, Object>> listByRecord(String recordId);

    /** 删除一条 lab data */
    void delete(String labDataId, String userId);

    /** 获取 SMB 根目录 */
    String getRoot();
}
