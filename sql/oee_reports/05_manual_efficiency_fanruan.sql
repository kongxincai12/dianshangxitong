/*
 * 帆软数据集：按设备/工序/人员人工效率报表
 * 数据库：Oracle 12c
 * 当前口径：人工效率 = 设备生产产量 / 员工实际出勤小时
 * 出勤来源：cux_erp_hr_hrdetail@jcd_demo.TOTALTIMENUMBER，USERNUMBER 对应 MES_PRODUCTION_RECORD.EMPLOYEE_ID
 * 班别口径：白班 08:00-20:00；晚班 20:00-次日 08:00
 * 作业时间口径：按设备生产记录与班别窗口的交集计算；同员工+设备+工序+班别重叠区间合并
 * 出勤分摊：员工当天出勤小时按其当天各设备/工序/班别的作业分钟占比分摊；缺少 HR 出勤时用作业分钟兜底并标记
 *
 * 帆软参数：
 *   ${开始日期}   格式 YYYY-MM-DD，例如 2026-05-14
 *   ${结束日期}   格式 YYYY-MM-DD，例如 2026-05-29；可空，为空时默认等于开始日期
 *   ${月份}       格式 YYYY-MM，例如 2026-05；可空。填写后优先按整月统计
 *   ${统计粒度}   日 / 周 / 月；可空，默认按日
 *   ${班别}       白班 / 晚班；可空，为空表示全部班别
 *   ${工序}       可空，为空表示全部工序；按 MES_PRODUCTION_RECORD.LOT_SITE 精确匹配
 *   ${员工工号}   可空，为空表示全部员工
 *   ${设备名称}   可空，为空表示全部设备。多选逗号分隔；按 EPM_EQP.EQP_NAME 匹配
 *   ${产品编号}   可空，为空表示全部产品
 */
WITH param_raw AS (
    SELECT
        CASE WHEN TRIM('${开始日期}') IS NULL THEN NULL ELSE TRIM('${开始日期}') END AS start_date_text,
        CASE WHEN TRIM('${结束日期}') IS NULL THEN NULL ELSE TRIM('${结束日期}') END AS end_date_text,
        CASE WHEN TRIM('${月份}') IS NULL THEN NULL ELSE TRIM('${月份}') END AS month_text,
        NVL(CASE WHEN TRIM('${统计粒度}') IS NULL THEN NULL ELSE TRIM('${统计粒度}') END, '日') AS period_grain,
        CASE WHEN TRIM('${班别}') IS NULL THEN NULL ELSE TRIM('${班别}') END AS shift_filter,
        CASE WHEN TRIM('${工序}') IS NULL THEN NULL ELSE TRIM('${工序}') END AS process_filter,
        CASE WHEN TRIM('${员工工号}') IS NULL THEN NULL ELSE TRIM('${员工工号}') END AS employee_filter,
        CASE WHEN TRIM('${设备名称}') IS NULL THEN NULL ELSE ',' || TRIM('${设备名称}') || ',' END AS device_filter_csv,
        CASE WHEN TRIM('${产品编号}') IS NULL THEN NULL ELSE TRIM('${产品编号}') END AS product_filter
    FROM dual
),
param AS (
    SELECT
        CASE
            WHEN month_text IS NOT NULL THEN TO_DATE(month_text, 'YYYY-MM')
            ELSE TO_DATE(start_date_text, 'YYYY-MM-DD')
        END AS work_date_from,
        CASE
            WHEN month_text IS NOT NULL THEN ADD_MONTHS(TO_DATE(month_text, 'YYYY-MM'), 1) - 1
            ELSE NVL(TO_DATE(end_date_text, 'YYYY-MM-DD'), TO_DATE(start_date_text, 'YYYY-MM-DD'))
        END AS work_date_to,
        period_grain,
        shift_filter,
        process_filter,
        employee_filter,
        device_filter_csv,
        product_filter
    FROM param_raw
),
shift_days AS (
    SELECT p.work_date_from + LEVEL - 1 AS work_date
    FROM param p
    CONNECT BY LEVEL <= p.work_date_to - p.work_date_from + 1
),
shift_window AS (
    SELECT
        d.work_date,
        '白班' AS shift_name,
        CAST(d.work_date + 8 / 24 AS TIMESTAMP) AS shift_start_time,
        CAST(d.work_date + 20 / 24 AS TIMESTAMP) AS shift_end_time
    FROM shift_days d
    UNION ALL
    SELECT
        d.work_date,
        '晚班' AS shift_name,
        CAST(d.work_date + 20 / 24 AS TIMESTAMP) AS shift_start_time,
        CAST(d.work_date + 1 + 8 / 24 AS TIMESTAMP) AS shift_end_time
    FROM shift_days d
),
eqp_map AS (
    SELECT equipment_key, eqp_code, eqp_name
    FROM (
        SELECT
            equipment_key,
            eqp_code,
            eqp_name,
            ROW_NUMBER() OVER (PARTITION BY equipment_key ORDER BY priority_no) AS rn
        FROM (
            SELECT EQP_CODE AS equipment_key, EQP_CODE AS eqp_code, EQP_NAME AS eqp_name, 1 AS priority_no
            FROM EPM_EQP
            WHERE EQP_CODE IS NOT NULL
            UNION ALL
            SELECT ASSETS_CODE AS equipment_key, EQP_CODE AS eqp_code, EQP_NAME AS eqp_name, 2 AS priority_no
            FROM EPM_EQP
            WHERE ASSETS_CODE IS NOT NULL
        )
    )
    WHERE rn = 1
),
filtered_mpr AS (
    SELECT /*+ MATERIALIZE */
        NVL(mpr.BATCH_GROUP_ID, mpr.ID) AS record_group_id,
        mpr.EMPLOYEE_ID AS employee_id,
        NVL(em.eqp_code, mpr.EQUIPMENT_ID) AS equipment_id,
        NVL(em.eqp_name, mpr.EQUIPMENT_ID) AS equipment_name,
        NVL(mpr.LOT_SITE, '未记录工序') AS process_name,
        NVL(pl.PRODUCTPN, '未关联产品') AS product_code,
        MIN(mpr.START_TIME) AS start_time,
        MAX(mpr.END_TIME) AS end_time,
        SUM(NVL(mpr.PCS_QTY, 0)) AS pcs_qty,
        SUM(NVL(mpr.PNL_QTY, 0)) AS pnl_qty
    FROM MES_PRODUCTION_RECORD mpr
    CROSS JOIN param p
    LEFT JOIN PRP_LOT pl
        ON pl.LOTNAME = mpr.LOT_CODE
    LEFT JOIN eqp_map em
        ON em.equipment_key = mpr.EQUIPMENT_ID
    WHERE mpr.RECORD_TYPE = 'EQUIPMENT'
      AND mpr.STATUS = 'COMPLETED'
      AND mpr.EMPLOYEE_ID IS NOT NULL
      AND mpr.START_TIME IS NOT NULL
      AND mpr.END_TIME IS NOT NULL
      AND mpr.END_TIME > CAST(p.work_date_from + 8 / 24 AS TIMESTAMP)
      AND mpr.START_TIME < CAST(p.work_date_to + 1 + 8 / 24 AS TIMESTAMP)
      AND (p.process_filter IS NULL OR NVL(mpr.LOT_SITE, '未记录工序') = p.process_filter)
      AND (p.employee_filter IS NULL OR mpr.EMPLOYEE_ID = p.employee_filter)
      AND (
          p.device_filter_csv IS NULL
          OR INSTR(p.device_filter_csv, ',' || em.eqp_name || ',') > 0
      )
      AND (p.product_filter IS NULL OR pl.PRODUCTPN = p.product_filter)
    GROUP BY
        NVL(mpr.BATCH_GROUP_ID, mpr.ID),
        mpr.EMPLOYEE_ID,
                NVL(em.eqp_code, mpr.EQUIPMENT_ID),
                NVL(em.eqp_name, mpr.EQUIPMENT_ID),
                NVL(mpr.LOT_SITE, '未记录工序'),
                NVL(pl.PRODUCTPN, '未关联产品')
),
qty_base AS (
    SELECT
        f.*,
        CASE
            WHEN TO_NUMBER(TO_CHAR(f.start_time, 'HH24')) >= 8
             AND TO_NUMBER(TO_CHAR(f.start_time, 'HH24')) < 20
                THEN TRUNC(CAST(f.start_time AS DATE))
            WHEN TO_NUMBER(TO_CHAR(f.start_time, 'HH24')) >= 20
                THEN TRUNC(CAST(f.start_time AS DATE))
            ELSE TRUNC(CAST(f.start_time AS DATE)) - 1
        END AS work_date,
        CASE
            WHEN TO_NUMBER(TO_CHAR(f.start_time, 'HH24')) >= 8
             AND TO_NUMBER(TO_CHAR(f.start_time, 'HH24')) < 20
                THEN '白班'
            ELSE '晚班'
        END AS shift_name
    FROM filtered_mpr f
),
qty_agg AS (
    SELECT
        CASE p.period_grain
            WHEN '周' THEN TRUNC(q.work_date, 'IW')
            WHEN '月' THEN TRUNC(q.work_date, 'MM')
            ELSE q.work_date
        END AS period_start,
        q.shift_name,
        q.process_name,
        q.equipment_id,
        q.equipment_name,
        q.employee_id,
        COUNT(DISTINCT q.product_code) AS product_count,
        COUNT(DISTINCT q.record_group_id) AS job_count,
        SUM(q.pcs_qty) AS pcs_qty,
        SUM(q.pnl_qty) AS pnl_qty
    FROM qty_base q
    CROSS JOIN param p
    WHERE q.work_date BETWEEN p.work_date_from AND p.work_date_to
      AND (p.shift_filter IS NULL OR q.shift_name = p.shift_filter)
    GROUP BY
        CASE p.period_grain
            WHEN '周' THEN TRUNC(q.work_date, 'IW')
            WHEN '月' THEN TRUNC(q.work_date, 'MM')
            ELSE q.work_date
        END,
        q.shift_name,
        q.process_name,
        q.equipment_id,
        q.equipment_name,
        q.employee_id
),
overlap_intervals AS (
    SELECT
        sw.work_date,
        sw.shift_name,
        f.employee_id,
        f.equipment_id,
        f.equipment_name,
        f.process_name,
        CASE WHEN f.start_time > sw.shift_start_time THEN f.start_time ELSE sw.shift_start_time END AS interval_start,
        CASE WHEN f.end_time < sw.shift_end_time THEN f.end_time ELSE sw.shift_end_time END AS interval_end
    FROM filtered_mpr f
    JOIN shift_window sw
        ON f.start_time < sw.shift_end_time
       AND f.end_time > sw.shift_start_time
    CROSS JOIN param p
    WHERE p.shift_filter IS NULL OR sw.shift_name = p.shift_filter
),
valid_intervals AS (
    SELECT *
    FROM overlap_intervals
    WHERE interval_end > interval_start
),
ordered_intervals AS (
    SELECT
        v.*,
        MAX(v.interval_end) OVER (
            PARTITION BY v.employee_id, v.equipment_id, v.process_name, v.work_date, v.shift_name
            ORDER BY v.interval_start, v.interval_end
            ROWS BETWEEN UNBOUNDED PRECEDING AND 1 PRECEDING
        ) AS prev_max_end
    FROM valid_intervals v
),
islanded_intervals AS (
    SELECT
        o.*,
        SUM(CASE WHEN o.prev_max_end IS NULL OR o.interval_start > o.prev_max_end THEN 1 ELSE 0 END) OVER (
            PARTITION BY o.employee_id, o.equipment_id, o.process_name, o.work_date, o.shift_name
            ORDER BY o.interval_start, o.interval_end
            ROWS UNBOUNDED PRECEDING
        ) AS island_id
    FROM ordered_intervals o
),
merged_intervals AS (
    SELECT
        employee_id,
        equipment_id,
        equipment_name,
        process_name,
        work_date,
        shift_name,
        island_id,
        MIN(interval_start) AS merged_start,
        MAX(interval_end) AS merged_end
    FROM islanded_intervals
    GROUP BY employee_id, equipment_id, equipment_name, process_name, work_date, shift_name, island_id
),
work_by_employee_process_shift AS (
    SELECT
        employee_id,
        equipment_id,
        equipment_name,
        process_name,
        work_date,
        shift_name,
        SUM((CAST(merged_end AS DATE) - CAST(merged_start AS DATE)) * 24 * 60) AS work_minutes
    FROM merged_intervals
    GROUP BY employee_id, equipment_id, equipment_name, process_name, work_date, shift_name
),
employee_day_work AS (
    SELECT
        employee_id,
        work_date,
        SUM(work_minutes) AS total_work_minutes
    FROM work_by_employee_process_shift
    GROUP BY employee_id, work_date
),
hr_raw AS (
    SELECT /*+ MATERIALIZE */
        TRIM(h.USERNUMBER || '') AS employee_id,
        TO_DATE(SUBSTR(TRIM(h.HRDATE), 1, 10), 'YYYY-MM-DD') AS work_date,
        h.USERNAME AS hr_employee_name,
        NVL(h.TOTALTIMENUMBER, 0) AS total_time_hours
    FROM cux_erp_hr_hrdetail@jcd_demo h
    CROSS JOIN param p
    WHERE TO_DATE(SUBSTR(TRIM(h.HRDATE), 1, 10), 'YYYY-MM-DD') BETWEEN p.work_date_from AND p.work_date_to
      AND (p.employee_filter IS NULL OR TRIM(h.USERNUMBER || '') = p.employee_filter)
),
attendance_day AS (
    SELECT
        employee_id,
        work_date,
        MAX(hr_employee_name) AS hr_employee_name,
        SUM(total_time_hours) * 60 AS attendance_minutes
    FROM hr_raw
    GROUP BY employee_id, work_date
),
attendance_allocated AS (
    SELECT
        w.employee_id,
        w.equipment_id,
        w.equipment_name,
        w.process_name,
        w.work_date,
        w.shift_name,
        w.work_minutes,
        ad.hr_employee_name,
        ad.attendance_minutes AS day_attendance_minutes,
        CASE
            WHEN ad.attendance_minutes IS NULL OR ad.attendance_minutes <= 0 THEN w.work_minutes
            WHEN edw.total_work_minutes > 0 THEN ad.attendance_minutes * w.work_minutes / edw.total_work_minutes
            ELSE ad.attendance_minutes
        END AS allocated_attendance_minutes,
        CASE WHEN ad.attendance_minutes IS NULL OR ad.attendance_minutes <= 0 THEN 1 ELSE 0 END AS missing_attendance_flag
    FROM work_by_employee_process_shift w
    LEFT JOIN employee_day_work edw
        ON edw.employee_id = w.employee_id
       AND edw.work_date = w.work_date
    LEFT JOIN attendance_day ad
        ON ad.employee_id = w.employee_id
       AND ad.work_date = w.work_date
),
work_agg AS (
    SELECT
        CASE p.period_grain
            WHEN '周' THEN TRUNC(a.work_date, 'IW')
            WHEN '月' THEN TRUNC(a.work_date, 'MM')
            ELSE a.work_date
        END AS period_start,
        a.shift_name,
        a.process_name,
        a.equipment_id,
        a.equipment_name,
        a.employee_id,
        MAX(a.hr_employee_name) AS hr_employee_name,
        SUM(a.work_minutes) AS work_minutes,
        SUM(a.allocated_attendance_minutes) AS attendance_minutes,
        SUM(a.day_attendance_minutes) AS day_attendance_minutes_sum,
        SUM(a.missing_attendance_flag) AS missing_attendance_days
    FROM attendance_allocated a
    CROSS JOIN param p
    GROUP BY
        CASE p.period_grain
            WHEN '周' THEN TRUNC(a.work_date, 'IW')
            WHEN '月' THEN TRUNC(a.work_date, 'MM')
            ELSE a.work_date
        END,
        a.shift_name,
        a.process_name,
        a.equipment_id,
        a.equipment_name,
        a.employee_id
)
SELECT
    CASE p.period_grain
        WHEN '周' THEN TO_CHAR(w.period_start, 'IYYY') || '-W' || TO_CHAR(w.period_start, 'IW')
        WHEN '月' THEN TO_CHAR(w.period_start, 'YYYY-MM')
        ELSE TO_CHAR(w.period_start, 'YYYY-MM-DD')
    END AS "周期",
    w.shift_name AS "班别",
    w.process_name AS "工序",
    w.equipment_id AS "设备编号",
    w.equipment_name AS "设备名称",
    w.employee_id AS "员工工号",
    NVL(NVL(u.FULLNAME, w.hr_employee_name), w.employee_id) AS "员工姓名",
    NVL(q.product_count, 0) AS "产品数",
    ROUND(w.work_minutes, 2) AS "作业分钟",
    ROUND(w.attendance_minutes, 2) AS "计入出勤分钟",
    ROUND(w.attendance_minutes / 60, 2) AS "计入出勤小时",
    ROUND(NVL(q.pcs_qty, 0), 0) AS "PCS产量",
    ROUND(NVL(q.pnl_qty, 0), 0) AS "PNL产量",
    ROUND(NVL(q.pcs_qty, 0) / NULLIF(w.attendance_minutes / 60, 0), 2) AS "PCS/人时",
    ROUND(NVL(q.pnl_qty, 0) / NULLIF(w.attendance_minutes / 60, 0), 2) AS "PNL/人时",
    NVL(q.job_count, 0) AS "作业次数",
    CASE WHEN w.missing_attendance_days > 0 THEN 'HR缺失-作业时间兜底' ELSE 'HR出勤' END AS "出勤数据状态"
FROM work_agg w
CROSS JOIN param p
LEFT JOIN qty_agg q
    ON q.period_start = w.period_start
   AND q.shift_name = w.shift_name
   AND q.process_name = w.process_name
   AND q.equipment_id = w.equipment_id
   AND q.employee_id = w.employee_id
LEFT JOIN USERPROFILE u
    ON u.USERNAME = w.employee_id
ORDER BY
    w.period_start,
    DECODE(w.shift_name, '白班', 1, '晚班', 2, 3),
    w.process_name,
    w.equipment_name,
    "PCS/人时" DESC,
    w.employee_id