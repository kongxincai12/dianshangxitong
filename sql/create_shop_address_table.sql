-- ============================================
-- 电商收货地址簿 - Oracle
-- 用途: 下单时从地址簿选择收货人信息, 不再每次手填
-- 说明: USER_ID 与 SHOP_ORDER.USER_ID 同一套口径, 存的是登录账号(JWT subject), 不是 USERPROFILE.USERID
-- ============================================

CREATE TABLE SHOP_ADDRESS (
    ID               VARCHAR2(32)  PRIMARY KEY,
    USER_ID          VARCHAR2(100) NOT NULL,
    RECEIVER_NAME    VARCHAR2(100) NOT NULL,
    RECEIVER_PHONE   VARCHAR2(50)  NOT NULL,
    RECEIVER_ADDRESS VARCHAR2(500) NOT NULL,
    IS_DEFAULT       NUMBER(1)     DEFAULT 0 NOT NULL,
    CREATE_TIME      TIMESTAMP     DEFAULT SYSTIMESTAMP NOT NULL,
    UPDATE_TIME      TIMESTAMP     DEFAULT SYSTIMESTAMP NOT NULL
);

-- 一个用户的默认地址最多一条; 没有默认地址时下单取最早创建的那条
-- 这里必须用函数索引: 假设写成 (USER_ID, IS_DEFAULT) 的唯一索引,
-- 同一用户的多条非默认地址都是 (user, 0), 会互相冲突, 地址簿只能存一条。
-- CASE 非默认时返回 NULL, Oracle 唯一索引不校全 NULL 键, 所以可以共存。
CREATE UNIQUE INDEX UK_SHOP_ADDRESS_DEFAULT
    ON SHOP_ADDRESS (CASE WHEN IS_DEFAULT = 1 THEN USER_ID ELSE NULL END);
CREATE INDEX IDX_SHOP_ADDRESS_USER ON SHOP_ADDRESS(USER_ID);

COMMENT ON TABLE  SHOP_ADDRESS IS '电商收货地址簿';
COMMENT ON COLUMN SHOP_ADDRESS.USER_ID IS '所属用户(登录账号)';
COMMENT ON COLUMN SHOP_ADDRESS.IS_DEFAULT IS '是否默认收货地址: 1-是, 0-否';
COMMENT ON COLUMN SHOP_ADDRESS.RECEIVER_ADDRESS IS '收货地址(省市区+详细地址)';
