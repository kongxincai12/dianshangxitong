/*
 * 帆软数据集：按工序稼动率报表
 * 数据库：Oracle 12c
 * 当前口径：工序稼动率 = 工序内设备计入运行分钟 / 工序内设备计划分钟
 * 班别口径：白班 08:00-20:00；晚班 20:00-次日 08:00
 * 计划时间：每台设备每班按 10.5H = 630 分钟计算
 * 运行时间口径：按生产记录与班别窗口的交集计算；同设备+工序+班别重叠区间合并；单设备单班最多计入 630 分钟
 * 工序来源：优先使用 MES_PRODUCTION_RECORD.LOT_SITE（生产记录落库时的批次站点/工序）
 *
 * 帆软参数：
 *   ${开始日期}   格式 YYYY-MM-DD，例如 2026-05-14
 *   ${结束日期}   格式 YYYY-MM-DD，例如 2026-05-29；可空，为空时默认等于开始日期
 *   ${月份}       格式 YYYY-MM，例如 2026-05；可空。填写后优先按整月统计
 *   ${统计粒度}   日 / 周 / 月；可空，默认按日
 *   ${班别}       白班 / 晚班；可空，为空表示全部班别
 *   ${工序}       可空，为空表示全部工序；按 MES_PRODUCTION_RECORD.LOT_SITE 精确匹配
 *   ${设备名称}   可空，为空表示全部设备。多选逗号分隔，例如 "YAMAHA冲孔机,全自动贴片机"；按 EPM_EQP.EQP_NAME 匹配
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
        device_filter_csv,
        product_filter,
        630 AS plan_minutes_per_shift
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
        NVL(em.eqp_code, mpr.EQUIPMENT_ID) AS equipment_id,
        NVL(mpr.LOT_SITE, '未记录工序') AS process_name,
        MIN(mpr.START_TIME) AS start_time,
        MAX(mpr.END_TIME) AS end_time,
        SUM(NVL(mpr.PCS_QTY, 0)) AS pcs_qty,
        SUM(NVL(mpr.PNL_QTY, 0)) AS pnl_qty
    FROM MES_PRODUCTION_RECORD mpr
    LEFT JOIN eqp_map em
        ON em.equipment_key = mpr.EQUIPMENT_ID
    CROSS JOIN param p
    LEFT JOIN PRP_LOT pl
        ON pl.LOTNAME = mpr.LOT_CODE
    WHERE mpr.RECORD_TYPE = 'EQUIPMENT'
      AND mpr.STATUS = 'COMPLETED'
      AND mpr.START_TIME IS NOT NULL
      AND mpr.END_TIME IS NOT NULL
      AND mpr.END_TIME > CAST(p.work_date_from + 8 / 24 AS TIMESTAMP)
      AND mpr.START_TIME < CAST(p.work_date_to + 1 + 8 / 24 AS TIMESTAMP)
      AND (p.process_filter IS NULL OR NVL(mpr.LOT_SITE, '未记录工序') = p.process_filter)
      AND (
          p.device_filter_csv IS NULL
          OR INSTR(p.device_filter_csv, ',' || em.eqp_name || ',') > 0
      )
      AND (p.product_filter IS NULL OR pl.PRODUCTPN = p.product_filter)
    GROUP BY
        NVL(mpr.BATCH_GROUP_ID, mpr.ID),
        NVL(em.eqp_code, mpr.EQUIPMENT_ID),
        NVL(mpr.LOT_SITE, '未记录工序')
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
        q.process_name
),
overlap_intervals AS (
    SELECT
        sw.work_date,
        sw.shift_name,
        f.equipment_id,
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
            PARTITION BY v.equipment_id, v.process_name, v.work_date, v.shift_name
            ORDER BY v.interval_start, v.interval_end
            ROWS BETWEEN UNBOUNDED PRECEDING AND 1 PRECEDING
        ) AS prev_max_end
    FROM valid_intervals v
),
islanded_intervals AS (
    SELECT
        o.*,
        SUM(CASE WHEN o.prev_max_end IS NULL OR o.interval_start > o.prev_max_end THEN 1 ELSE 0 END) OVER (
            PARTITION BY o.equipment_id, o.process_name, o.work_date, o.shift_name
            ORDER BY o.interval_start, o.interval_end
            ROWS UNBOUNDED PRECEDING
        ) AS island_id
    FROM ordered_intervals o
),
merged_intervals AS (
    SELECT
        equipment_id,
        process_name,
        work_date,
        shift_name,
        island_id,
        MIN(interval_start) AS merged_start,
        MAX(interval_end) AS merged_end
    FROM islanded_intervals
    GROUP BY equipment_id, process_name, work_date, shift_name, island_id
),
run_by_device_process_shift AS (
    SELECT
        m.equipment_id,
        m.process_name,
        m.work_date,
        m.shift_name,
        SUM((CAST(m.merged_end AS DATE) - CAST(m.merged_start AS DATE)) * 24 * 60) AS raw_run_minutes,
        LEAST(SUM((CAST(m.merged_end AS DATE) - CAST(m.merged_start AS DATE)) * 24 * 60), p.plan_minutes_per_shift) AS run_minutes
    FROM merged_intervals m
    CROSS JOIN param p
    GROUP BY m.equipment_id, m.process_name, m.work_date, m.shift_name, p.plan_minutes_per_shift
),
run_agg AS (
    SELECT
        CASE p.period_grain
            WHEN '周' THEN TRUNC(r.work_date, 'IW')
            WHEN '月' THEN TRUNC(r.work_date, 'MM')
            ELSE r.work_date
        END AS period_start,
        r.shift_name,
        r.process_name,
        COUNT(DISTINCT r.equipment_id) AS device_count,
        COUNT(DISTINCT r.equipment_id || '|' || TO_CHAR(r.work_date, 'YYYYMMDD') || '|' || r.shift_name) AS device_shift_count,
        SUM(r.raw_run_minutes) AS raw_run_minutes,
        SUM(r.run_minutes) AS run_minutes
    FROM run_by_device_process_shift r
    CROSS JOIN param p
    GROUP BY
        CASE p.period_grain
            WHEN '周' THEN TRUNC(r.work_date, 'IW')
            WHEN '月' THEN TRUNC(r.work_date, 'MM')
            ELSE r.work_date
        END,
        r.shift_name,
        r.process_name
)
SELECT
    CASE p.period_grain
        WHEN '周' THEN TO_CHAR(r.period_start, 'IYYY') || '-W' || TO_CHAR(r.period_start, 'IW')
        WHEN '月' THEN TO_CHAR(r.period_start, 'YYYY-MM')
        ELSE TO_CHAR(r.period_start, 'YYYY-MM-DD')
    END AS "周期",
    r.shift_name AS "班别",
    r.process_name AS "工序",
    r.device_count AS "设备数",
    ROUND(r.run_minutes, 2) AS "运行分钟",
    ROUND(r.raw_run_minutes, 2) AS "原始占用分钟",
    r.device_shift_count * p.plan_minutes_per_shift AS "计划分钟",
    ROUND(r.run_minutes / NULLIF(r.device_shift_count * p.plan_minutes_per_shift, 0) * 100, 2) AS "工序稼动率(%)",
    ROUND(NVL(q.pcs_qty, 0), 0) AS "PCS产量",
    ROUND(NVL(q.pnl_qty, 0), 0) AS "PNL产量",
    NVL(q.job_count, 0) AS "作业次数"
FROM run_agg r
CROSS JOIN param p
LEFT JOIN qty_agg q
    ON q.period_start = r.period_start
   AND q.shift_name = r.shift_name
   AND q.process_name = r.process_name
ORDER BY
    r.period_start,
    DECODE(r.shift_name, '白班', 1, '晚班', 2, 3),
    "工序稼动率(%)" DESC,
    r.process_name