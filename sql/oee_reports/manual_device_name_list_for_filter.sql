/*
 * 帆软数据集：人工效率报表设备名称列表（用于多选下拉框）
 * 数据库：Oracle 12c
 * 用途：给 05_manual_efficiency_fanruan.sql 的 ${设备名称} 参数提供下拉选项
 * 返回字段：设备名称
 */
SELECT DISTINCT
    device_name AS "设备名称"
FROM (
    SELECT EQP_NAME AS device_name
    FROM EPM_EQP
    WHERE EQP_NAME IS NOT NULL
      AND NVL(ENABLE_FLAG, 'Y') = 'Y'
    UNION ALL
    SELECT WORKSTATION_NAME AS device_name
    FROM EPM_WORKSTATION
    WHERE WORKSTATION_NAME IS NOT NULL
      AND NVL(ENABLE_FLAG, 'Y') = 'Y'
)
ORDER BY device_name