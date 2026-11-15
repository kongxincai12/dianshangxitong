-- ============================================================
-- FQC 不良项排序脚本（按现场确认顺序）
-- 日期: 2026-04-14
-- 说明:
--   1) 依赖字段: DEFECTCODE.FQC_DISPLAY_ORDER
--   2) 仅更新 IS_FQC=1 的缺陷项
--   3) 名称匹配兼容 BRIEFDESCRIPTION / DEFECTCODENAME
-- ============================================================

UPDATE DEFECTCODE d
SET d.FQC_DISPLAY_ORDER = CASE
    WHEN d.BRIEFDESCRIPTION = '开路' OR d.DEFECTCODENAME = '开路' THEN 10
    WHEN d.BRIEFDESCRIPTION = '短路' OR d.DEFECTCODENAME = '短路' THEN 20
    WHEN d.BRIEFDESCRIPTION = '皱折' OR d.DEFECTCODENAME = '皱折' THEN 30
    WHEN d.BRIEFDESCRIPTION = '金面氧化' OR d.DEFECTCODENAME = '金面氧化' THEN 40
    WHEN d.BRIEFDESCRIPTION = '保偏' OR d.DEFECTCODENAME = '保偏' THEN 50
    WHEN d.BRIEFDESCRIPTION = '压痕/压坑' OR d.DEFECTCODENAME = '压痕/压坑' THEN 60
    WHEN d.BRIEFDESCRIPTION = '板面脏污' OR d.DEFECTCODENAME = '板面脏污' THEN 70
    WHEN d.BRIEFDESCRIPTION = '露铜/镍' OR d.DEFECTCODENAME = '露铜/镍' THEN 80
    WHEN d.BRIEFDESCRIPTION = '冲偏' OR d.DEFECTCODENAME = '冲偏' THEN 90
    WHEN d.BRIEFDESCRIPTION = '手指皱' OR d.DEFECTCODENAME = '手指皱' THEN 100
    WHEN d.BRIEFDESCRIPTION = '印痕' OR d.DEFECTCODENAME = '印痕' THEN 110
    WHEN d.BRIEFDESCRIPTION = '补强外来物' OR d.DEFECTCODENAME = '补强外来物' THEN 120
    WHEN d.BRIEFDESCRIPTION = '金面白渍' OR d.DEFECTCODENAME = '金面白渍' THEN 130
    WHEN d.BRIEFDESCRIPTION = '补强偏位' OR d.DEFECTCODENAME = '补强偏位' THEN 140
    WHEN d.BRIEFDESCRIPTION = '保护膜外来物' OR d.DEFECTCODENAME = '保护膜外来物' THEN 150
    WHEN d.BRIEFDESCRIPTION = '保护膜皱折' OR d.DEFECTCODENAME = '保护膜皱折' THEN 160
    WHEN d.BRIEFDESCRIPTION IN ('擦花/划伤', '划伤/擦花') OR d.DEFECTCODENAME IN ('擦花/划伤', '划伤/擦花') THEN 170
    WHEN d.BRIEFDESCRIPTION = '流胶不均' OR d.DEFECTCODENAME = '流胶不均' THEN 180
    WHEN d.BRIEFDESCRIPTION = '漏补强' OR d.DEFECTCODENAME = '漏补强' THEN 190
    WHEN d.BRIEFDESCRIPTION = '油墨污板' OR d.DEFECTCODENAME = '油墨污板' THEN 200
    WHEN d.BRIEFDESCRIPTION = '掉油' OR d.DEFECTCODENAME = '掉油' THEN 210
    WHEN d.BRIEFDESCRIPTION = '油墨上焊盘' OR d.DEFECTCODENAME = '油墨上焊盘' THEN 220
    WHEN d.BRIEFDESCRIPTION = '油墨上手指' OR d.DEFECTCODENAME = '油墨上手指' THEN 230
    ELSE d.FQC_DISPLAY_ORDER
END
WHERE d.IS_FQC = 1
  AND (
    d.BRIEFDESCRIPTION IN (
      '开路','短路','皱折','金面氧化','保偏','压痕/压坑','板面脏污','露铜/镍','冲偏','手指皱',
      '印痕','补强外来物','金面白渍','补强偏位','保护膜外来物','保护膜皱折','擦花/划伤','划伤/擦花',
      '流胶不均','漏补强','油墨污板','掉油','油墨上焊盘','油墨上手指'
    )
    OR d.DEFECTCODENAME IN (
      '开路','短路','皱折','金面氧化','保偏','压痕/压坑','板面脏污','露铜/镍','冲偏','手指皱',
      '印痕','补强外来物','金面白渍','补强偏位','保护膜外来物','保护膜皱折','擦花/划伤','划伤/擦花',
      '流胶不均','漏补强','油墨污板','掉油','油墨上焊盘','油墨上手指'
    )
  );

COMMIT;

-- 校验顺序（接口就是按这个字段升序）
SELECT DEFECTCODEID,
       DEFECTCODENAME,
       BRIEFDESCRIPTION,
       IS_FQC,
       FQC_DISPLAY_ORDER
  FROM DEFECTCODE
 WHERE IS_FQC = 1
   AND (
     BRIEFDESCRIPTION IN (
       '开路','短路','皱折','金面氧化','保偏','压痕/压坑','板面脏污','露铜/镍','冲偏','手指皱',
       '印痕','补强外来物','金面白渍','补强偏位','保护膜外来物','保护膜皱折','擦花/划伤','划伤/擦花',
       '流胶不均','漏补强','油墨污板','掉油','油墨上焊盘','油墨上手指'
     )
     OR DEFECTCODENAME IN (
       '开路','短路','皱折','金面氧化','保偏','压痕/压坑','板面脏污','露铜/镍','冲偏','手指皱',
       '印痕','补强外来物','金面白渍','补强偏位','保护膜外来物','保护膜皱折','擦花/划伤','划伤/擦花',
       '流胶不均','漏补强','油墨污板','掉油','油墨上焊盘','油墨上手指'
     )
   )
 ORDER BY FQC_DISPLAY_ORDER ASC, DEFECTCODENAME ASC;
