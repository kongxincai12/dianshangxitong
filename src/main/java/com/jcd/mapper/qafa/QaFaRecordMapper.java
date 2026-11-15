package com.jcd.mapper.qafa;

import com.jcd.model.qafa.QaFaRecord;
import com.jcd.model.qafa.QaFaRecordItem;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface QaFaRecordMapper {

    int insert(QaFaRecord record);

    int updateSelective(QaFaRecord record);

    QaFaRecord selectById(@Param("id") String id);

    int deleteById(@Param("id") String id);

    int deleteItemsByRecordId(@Param("recordId") String recordId);

    int deleteAuditLogsByRecordId(@Param("recordId") String recordId);

    /** 同批次的历史首件(简表) */
    List<QaFaRecord> selectByLotName(@Param("lotName") String lotName);

    /** 业务编号生成: 取当天最大流水号 + 1 */
    Integer nextDailyRecordSeq(@Param("prefix") String prefix);

    /** 列表查询 */
    List<QaFaRecord> queryList(@Param("statusList") List<String> statusList,
                               @Param("processCode") String processCode,
                               @Param("lotName") String lotName,
                               @Param("dateFrom") Date dateFrom,
                               @Param("dateTo") Date dateTo,
                               @Param("ownerUserId") String ownerUserId,
                               @Param("offset") int offset,
                               @Param("limit") int limit);

    int queryListCount(@Param("statusList") List<String> statusList,
                       @Param("processCode") String processCode,
                       @Param("lotName") String lotName,
                       @Param("dateFrom") Date dateFrom,
                       @Param("dateTo") Date dateTo,
                       @Param("ownerUserId") String ownerUserId);

    /* ============== record_item ============== */

    int insertItem(QaFaRecordItem item);

    int batchInsertItems(@Param("items") List<QaFaRecordItem> items);

    int updateItemSelective(QaFaRecordItem item);

    QaFaRecordItem selectItemById(@Param("id") String id);

    /** 取某条记录某轮次的所有 item */
    List<QaFaRecordItem> selectItemsByRecordAndRound(@Param("recordId") String recordId,
                                                     @Param("roundNo") Integer roundNo);

    /** 取某条记录所有轮次的 item (展示历史) */
    List<QaFaRecordItem> selectAllItemsByRecord(@Param("recordId") String recordId);

    /** 按 recordId+templateItemId+roundNo 取单条 (保存时 upsert 用) */
    QaFaRecordItem selectItemByKey(@Param("recordId") String recordId,
                                   @Param("templateItemId") String templateItemId,
                                   @Param("roundNo") Integer roundNo);
}
