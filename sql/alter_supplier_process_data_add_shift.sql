-- =====================================================
-- 供应商制程数据表字段补充脚本
-- 添加 shift (班别) 字段
-- 数据库: Oracle
-- =====================================================

-- 1. 添加 shift 字段
ALTER TABLE SUPPLIER_PROCESS_DATA ADD SHIFT VARCHAR2(50);

-- 2. 添加字段注释
COMMENT ON COLUMN SUPPLIER_PROCESS_DATA.SHIFT IS '班别';

-- 3. 创建索引（可选，如果需要经常按班别查询）
CREATE INDEX IDX_SPD_SHIFT ON SUPPLIER_PROCESS_DATA(SHIFT);

-- 4. 验证字段已添加
SELECT COLUMN_NAME, DATA_TYPE, DATA_LENGTH, NULLABLE
FROM USER_TAB_COLUMNS
WHERE TABLE_NAME = 'SUPPLIER_PROCESS_DATA'
AND COLUMN_NAME = 'SHIFT';

-- 5. 查看表结构
DESC SUPPLIER_PROCESS_DATA;

-- 提交更改
COMMIT;
