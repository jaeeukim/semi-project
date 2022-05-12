CREATE USER for_semi IDENTIFIED BY for_semi;

GRANT RESOURCE, CONNECT TO for_semi;
GRANT INSERT ANY TABLE, UPDATE ANY TABLE, DELETE ANY TABLE,
	CREATE VIEW TO for_semi;
GRANT CREATE SESSION TO for_semi;



CREATE TABLE (
	prod_name 		PRIMARY KEY
  , prod_type		NOT NULL
  , prod_price		NOT NULL
  , reason			NOT NULL
  , exp_user		NOT NULL
  , des_percentage 	NOT NULL
);
