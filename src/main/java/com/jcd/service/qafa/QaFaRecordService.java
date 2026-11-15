package com.jcd.service.qafa;

import com.jcd.dto.qafa.QaFaCreateRecordDto;
import com.jcd.dto.qafa.QaFaSaveProdDto;
import com.jcd.dto.qafa.QaFaSaveQcDto;
import com.jcd.dto.qafa.QaFaStageJudgeDto;
import com.jcd.dto.qafa.QaFaTransitionDto;
import com.jcd.model.qafa.QaFaRecord;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface QaFaRecordService {

    /** 扫批次校验 */
    Map<String, Object> checkLot(String lotName);

    /** 创建首件 (DRAFT) */
    QaFaRecord createRecord(QaFaCreateRecordDto dto, String userId, String userName);

    /** 详情 (含 record/template/items/labData/auditLogs) */
    Map<String, Object> getDetail(String recordId);

    /** 生产端草稿保存 */
    void saveProd(String recordId, QaFaSaveProdDto dto, String userId, String userName);

    /** 生产端提交 */
    void submitProd(String recordId, String userId, String userName);

    /** 品管端草稿保存 (首次自动接单转 QC_REVIEWING) */
    void saveQc(String recordId, QaFaSaveQcDto dto, String userId, String userName);

    /** 状态流转: APPROVE/REJECT/RETURN/VOID */
    void transition(String recordId, QaFaTransitionDto dto, String userId, String userName);

    /** 品管按模板配置的审核阶段提交判定 */
    void judgeStage(String recordId, QaFaStageJudgeDto dto, String userId, String userName);

    /** 删除草稿或品管退回待生产修改的记录 */
    void deleteRecord(String recordId, String userId);

    /** 列表 (分页) */
    Map<String, Object> queryList(List<String> statusList, String processCode,
                                  String lotName, Date dateFrom, Date dateTo,
                                  String ownerUserId, int pageNo, int pageSize);
}
