/*
 * 帆软数据集：设备名称列表（用于多选下拉框）
 * 数据库：Oracle 12c
 * 用途：给 OEE 报表的 ${设备名称} 参数提供下拉选项
 * 返回字段：设备编号、设备名称，按设备名称排序
 *
 * 帆软参数：无（返回所有已启用设备）
 */
SELECT DISTINCT
    EQP_CODE AS "设备编号",
    EQP_NAME AS "设备名称"
FROM EPM_EQP
WHERE EQP_NAME IS NOT NULL
  AND ENABLE_FLAG = 'Y'
ORDER BY EQP_NAME
