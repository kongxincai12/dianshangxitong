-- ============================================================
-- 为 EPM_EQP_TYPE_PARAM 和 EPM_PARAM_OVERRIDE 表添加 SHIFT_BASED 字段
-- 用于支持设备类型默认参数和设备独立参数的按班次自动回填功能
-- 执行日期: 2026-03-23
-- ============================================================

-- 1. 设备类型默认参数表
ALTER TABLE EPM_EQP_TYPE_PARAM ADD SHIFT_BASED CHAR(1) DEFAULT 'N';
COMMENT ON COLUMN EPM_EQP_TYPE_PARAM.SHIFT_BASED IS '是否按班次自动回填: Y/N';

-- 2. 设备独立参数表
ALTER TABLE EPM_PARAM_OVERRIDE ADD SHIFT_BASED CHAR(1) DEFAULT 'N';
COMMENT ON COLUMN EPM_PARAM_OVERRIDE.SHIFT_BASED IS '是否按班次自动回填: Y/N';

COMMIT;
