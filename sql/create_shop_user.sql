-- ============================================
-- 电商独立客户账号表 SHOP_USER - Oracle
-- 商城登录已完全独立于 MES 员工体系, 不再查询 USERPROFILE
--
-- 口径说明（重要）:
--   JWT subject 以及 SHOP_ORDER / SHOP_CART / SHOP_ADDRESS 的 USER_ID 存的都是 USERNAME,
--   不是这里的 ID。存量数据就是这个口径, 不要改成 ID, 否则历史订单和购物车会全部查不到。
--
-- 本文件可直接整体执行(建表 + 索引 + 注释)。
-- 下面两段"账号数据"默认用 -- 注释掉, 按场景二选一手工放开后再执行。
-- ============================================

CREATE TABLE SHOP_USER (
    ID           VARCHAR2(32)   PRIMARY KEY,
    USERNAME     VARCHAR2(100)  NOT NULL,
    PASSWORD     VARCHAR2(200)  NOT NULL,
    NICKNAME     VARCHAR2(100),
    PHONE        VARCHAR2(50),
    EMAIL        VARCHAR2(100),
    ROLE         VARCHAR2(100),
    STATUS       NUMBER(1)      DEFAULT 1 NOT NULL,
    CREATE_TIME  TIMESTAMP      DEFAULT SYSTIMESTAMP NOT NULL,
    UPDATE_TIME  TIMESTAMP      DEFAULT SYSTIMESTAMP NOT NULL
);
CREATE UNIQUE INDEX UK_SHOP_USER_USERNAME ON SHOP_USER(USERNAME);

COMMENT ON TABLE  SHOP_USER IS '电商客户账号表';
COMMENT ON COLUMN SHOP_USER.ID IS '主键ID(UUID)。仅作主键, 登录态和业务表 USER_ID 都用 USERNAME';
COMMENT ON COLUMN SHOP_USER.USERNAME IS '登录账号(唯一), 同时作为 JWT subject 与订单/购物车/地址的 USER_ID';
COMMENT ON COLUMN SHOP_USER.PASSWORD IS '密码摘要: md5(md5(明文) + 明文前5位), 32位小写hex';
COMMENT ON COLUMN SHOP_USER.NICKNAME IS '昵称, 登录接口里以 fullname 返回给前端做显示名';
COMMENT ON COLUMN SHOP_USER.ROLE IS '角色, 写入 JWT role claim, 命中 shop.admin-positions 才能进后台管理';
COMMENT ON COLUMN SHOP_USER.STATUS IS '状态: 1-正常, 0-禁用';


-- ============================================
-- 账号数据：两种场景二选一
-- ============================================

-- 【场景 A】从老 MES 库搬已有账号（只有库里存在 USERPROFILE 时才可用）
-- 密码摘要原样复制, 用户不用改密码; 同名多行时按 USERNAME 聚合成一条。
-- INSERT INTO SHOP_USER (ID, USERNAME, PASSWORD, NICKNAME, PHONE, EMAIL, ROLE, STATUS, CREATE_TIME, UPDATE_TIME)
-- SELECT RAWTOHEX(SYS_GUID()),
--        u.USERNAME, u.PASSWORD, u.FULLNAME, u.PHONENUMBER, u.EMAILADDRESS, u.USERPOSITION,
--        1, SYSTIMESTAMP, SYSTIMESTAMP
-- FROM (SELECT USERNAME,
--              MAX(PASSWORD)     PASSWORD,
--              MAX(FULLNAME)     FULLNAME,
--              MAX(PHONENUMBER)  PHONENUMBER,
--              MAX(EMAILADDRESS) EMAILADDRESS,
--              MAX(USERPOSITION) USERPOSITION
--       FROM USERPROFILE
--       WHERE USERNAME IN ('admin', 'buyer1')
--       GROUP BY USERNAME) u
-- WHERE NOT EXISTS (SELECT 1 FROM SHOP_USER s WHERE s.USERNAME = u.USERNAME);

-- 【场景 B】全新数据库直接建账号, 明文密码都是 123456
-- 摘要 1028891b0dfec429ea1bde26b32f012f = md5(md5('123456') + '12345'),
-- 与后端 ShopUserServiceImpl.getMd5Str 一致。
-- admin 的 ROLE 必须是 shop.admin-positions 里的值(或用户名在 shop.admin-usernames 里),
-- 否则进不了后台管理; buyer1 用普通买家角色。
-- INSERT INTO SHOP_USER (ID, USERNAME, PASSWORD, NICKNAME, ROLE, STATUS, CREATE_TIME, UPDATE_TIME)
-- VALUES (RAWTOHEX(SYS_GUID()), 'admin',  '1028891b0dfec429ea1bde26b32f012f', '商城管理员', '管理员', 1, SYSTIMESTAMP, SYSTIMESTAMP);
-- INSERT INTO SHOP_USER (ID, USERNAME, PASSWORD, NICKNAME, ROLE, STATUS, CREATE_TIME, UPDATE_TIME)
-- VALUES (RAWTOHEX(SYS_GUID()), 'buyer1', '1028891b0dfec429ea1bde26b32f012f', '商城买家',   '客户',   1, SYSTIMESTAMP, SYSTIMESTAMP);
-- COMMIT;
