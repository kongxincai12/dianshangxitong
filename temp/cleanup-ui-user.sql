-- remove the account created by the server-side register probe
DELETE FROM SHOP_USER WHERE USERNAME = 'apitest88';
COMMIT;
