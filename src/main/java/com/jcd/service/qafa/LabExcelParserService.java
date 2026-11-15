package com.jcd.service.qafa;

import com.jcd.model.qafa.QaFaLabData;
import com.jcd.model.qafa.QaFaLabDataItem;
import lombok.Data;

import java.util.List;

public interface LabExcelParserService {

    /**
     * 解析单个 xlsx 文件
     *
     * @param filePath        本地可读路径
     * @param recordLotName   首件记录的批次名(用于 hint 命中)
     */
    ParseResult parse(String filePath, String fileName, String recordLotName) throws Exception;

    @Data
    class ParseResult {
        private QaFaLabData header;
        private List<QaFaLabDataItem> items;
        private String parseStatus; // OK/PARTIAL/FAILED
        private String parseError;
    }
}
