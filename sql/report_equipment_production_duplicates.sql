-- 仅生成疑似重复清单，不执行删除。
-- 判定口径：同员工、同设备、同批次、同PNL/PCS，且与上一笔相隔不超过10秒。

WITH ordered_records AS (
    SELECT r.*,
           LAG(r.ID) OVER (
               PARTITION BY r.EMPLOYEE_ID, r.EQUIPMENT_ID, r.LOT_CODE, r.PNL_QTY, r.PCS_QTY
               ORDER BY r.START_TIME, r.ID
           ) AS previous_id,
           LAG(r.START_TIME) OVER (
               PARTITION BY r.EMPLOYEE_ID, r.EQUIPMENT_ID, r.LOT_CODE, r.PNL_QTY, r.PCS_QTY
               ORDER BY r.START_TIME, r.ID
           ) AS previous_start_time
      FROM MES_PRODUCTION_RECORD r
     WHERE r.RECORD_TYPE = 'EQUIPMENT'
)
SELECT ID,
       previous_id,
       EMPLOYEE_ID,
       EQUIPMENT_ID,
       LOT_CODE,
       PNL_QTY,
       PCS_QTY,
       STATUS,
       START_TIME,
       ROUND((CAST(START_TIME AS DATE) - CAST(previous_start_time AS DATE)) * 86400, 3)
           AS gap_seconds
  FROM ordered_records
 WHERE previous_start_time IS NOT NULL
   AND (CAST(START_TIME AS DATE) - CAST(previous_start_time AS DATE)) * 86400 BETWEEN 0 AND 10
 ORDER BY START_TIME DESC;

