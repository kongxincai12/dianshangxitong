-- temp account for verifying the Chinese ROLE whitelist path end to end
-- (properties value is unicode-escaped; DB value is real Chinese)
UPDATE SHOP_USER SET ROLE = '管理员' WHERE USERNAME = 'roletest1';
COMMIT;
