-- ============================================================
-- FQC 报表查询 SQL（供报表平台使用）
-- ============================================================

-- 1. 日报汇总：按日期+批次汇总
-- ============================================================
SELECT
    r.INSP_DATE,
    r.LOT_CODE,
    r.MODEL_NAME,
    r.PRODUCT_TYPE,
    r.TOTAL_QTY,
    r.GOOD_QTY,
    r.DEFECT_QTY,
    r.PASS_RATE,
    r.CYCLE_TIME,
    r.FORK_QTY,
    r.PACKAGE_QTY,
    r.INSPECTOR_NAME,
    r.STATUS,
    r.CREATE_TIME
FROM FQC_RECORDS r
WHERE TRUNC(r.INSP_DATE) = TO_DATE(:reportDate, 'YYYY-MM-DD')
  AND r.STATUS = 'SUBMITTED'
ORDER BY r.CREATE_TIME;

-- 2. 明细报表：记录+缺陷展开
-- ============================================================
SELECT
    r.INSP_DATE,
    r.LOT_CODE,
    r.MODEL_NAME,
    r.PRODUCT_TYPE,
    r.TOTAL_QTY,
    r.GOOD_QTY,
    r.PASS_RATE,
    d.DEFECT_NAME,
    d.DEFECT_QTY,
    r.INSPECTOR_NAME
FROM FQC_RECORDS r
LEFT JOIN FQC_RECORD_DEFECTS d ON d.RECORD_ID = r.ID
WHERE TRUNC(r.INSP_DATE) = TO_DATE(:reportDate, 'YYYY-MM-DD')
  AND r.STATUS = 'SUBMITTED'
ORDER BY r.LOT_CODE, d.DISPLAY_ORDER;

-- 3. 缺陷TOP排行：按不良项目统计
-- ============================================================
SELECT
    d.DEFECT_NAME,
    SUM(d.DEFECT_QTY) AS TOTAL_DEFECT_QTY,
    COUNT(DISTINCT d.RECORD_ID) AS AFFECTED_RECORDS
FROM FQC_RECORD_DEFECTS d
JOIN FQC_RECORDS r ON r.ID = d.RECORD_ID
WHERE TRUNC(r.INSP_DATE) BETWEEN TO_DATE(:startDate, 'YYYY-MM-DD') AND TO_DATE(:endDate, 'YYYY-MM-DD')
  AND r.STATUS = 'SUBMITTED'
  AND d.DEFECT_QTY > 0
GROUP BY d.DEFECT_NAME
ORDER BY TOTAL_DEFECT_QTY DESC;
