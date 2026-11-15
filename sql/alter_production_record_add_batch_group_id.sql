-- ============================================================================
-- 文件: alter_production_record_add_batch_group_id.sql
-- 用途: 为 MES_PRODUCTION_RECORD 增加 BATCH_GROUP_ID 列
--       用于"设备作业批量录入"功能：同一次批量提交的 N 条记录共享同一个 UUID，
--       便于任务中心按组聚合显示、一键结束。单批次录入时该列保持 NULL。
-- 兼容: .NET MES 端只读取已知列，不感知此新增列；老数据自然为 NULL。
-- ============================================================================

ALTER TABLE MES_PRODUCTION_RECORD ADD BATCH_GROUP_ID VARCHAR2(36) NULL;

COMMENT ON COLUMN MES_PRODUCTION_RECORD.BATCH_GROUP_ID IS
    '批量录入分组ID(UUID)。同组N条共享员工/设备/参数/料号，可一键结束；单批次录入时为NULL';

CREATE INDEX IDX_MES_PROD_REC_BATCH_GRP ON MES_PRODUCTION_RECORD(BATCH_GROUP_ID);

COMMIT;
