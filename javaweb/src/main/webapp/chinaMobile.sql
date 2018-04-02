CREATE TABLE XMobiles
(
  mobiles_num char(11) PRIMARY KEY,
  mobiles_type CHAR(3) not null,
  card_num varchar(20) ,
  is_available CHAR(1) CHECK (is_available='0' or is_available='1')
);

insert into XMobiles values('18390854580','SIM','2018012210000001','1');
insert into XMobiles values('18390854581','SIM','2018012210000002','1');
insert into XMobiles values('18390854582','SIM','2018012210000003','1');
insert into XMobiles values('18190854580','UIM','2018012210000004','1');
insert into XMobiles values('18190854581','UIM','2018012210000005','1');
delete XMobiles;
drop TABLE XMobiles;
-----------------------------------------------------
CREATE TABLE xoperator(
  op_id CHAR(10) PRIMARY KEY,
  op_name VARCHAR2(20) not null,
  op_pwd CHAR(32) not null,
  op_mark CHAR(1) default 'N'
);
INSERT INTO xoperator(op_id,op_name,op_pwd,op_mark)
VALUES ('A000000001','admin','2de6266ff6f07dacbbc0c9e36c282d6f','Y');
SELECT * FROM xoperator;
-----------------------------------------------------
CREATE TABLE xcharge
(
  charge_code CHAR(1) PRIMARY KEY,
  charge_name VARCHAR2(10) not null,
  charge NUMBER(8,2) not null
);
INSERT INTO xcharge(charge_code,charge_name,charge)
VALUES ('A','开户费',10);
INSERT INTO xcharge(charge_code,charge_name,charge)
VALUES ('B','漫游费',5);
INSERT INTO xcharge(charge_code,charge_name,charge)
VALUES ('C','押金',100);
INSERT INTO xcharge(charge_code,charge_name,charge)
VALUES ('D','入网费',50);
INSERT INTO xcharge(charge_code,charge_name,charge)
VALUES ('E','选号费',10);
SELECT * FROM xcharge;
-----------------------------------------------------
CREATE TABLE XCUSTOMER
(
  CUS_ID       NUMBER(8) PRIMARY KEY,
  CUS_TYPE     VARCHAR2(10) not null,
  CUS_NUMEBR   VARCHAR2(20) not null,
  CUS_NAME     VARCHAR2(20) not null,
  CUS_BIRTH DATE,
  CUS_SEX      CHAR(2),
  CUS_ADD  VARCHAR2(50)
);
create sequence SEQ_XCUS
  minvalue 0
  maxvalue 99999999
  start with 0
  increment by 1
  nocache
  nocycle;
--添加顾客
INSERT INTO xcustomer
VALUES(seq_xcus.nextval,'身份证','430111198007285521','李云龙',sysdate,'男','湖南长沙');
SELECT * FROM XCUSTOMER;
-------------------------------------------------------------------------
/*CREATE TABLE XACCOUNT
(
  ACC_ID      VARCHAR2(19) PRIMARY KEY,
  ACC_NAME    VARCHAR2(20) not null ,
  ACC_ADD VARCHAR2(50) NOT NULL ,
  ACC_BALANCE NUMBER(10, 2) DEFAULT 0.00
);

--账户
INSERT INTO XACCOUNT(ACC_ID,ACC_NAME,ACC_ADD,ACC_BALANCE)
VALUES('6217002920125899999','李云龙','湖南长沙',666.01);
SELECT * FROM XACCOUNT;
drop table XACCOUNT;*/
-------------------------------------------------------------------------
create table XUser
(
  user_id     number(8) PRIMARY KEY,
  user_status char(1) not null,
  user_level  char(1) not null,
  user_balance NUMBER(8,2) DEFAULT 0.00,
  mobiles_num  char(11) REFERENCES XMobiles(mobiles_num),
  cus_id      number(8) REFERENCES XCUSTOMER(CUS_ID)
);
drop table XUser;

--序列
create sequence seq_xuser
start with 0
increment by 1
minvalue 0
maxvalue 99999999
nocache
nocycle
order;

-------------------------------------------------------------------------
create table XFunction
(
  func_code   char(1) not null ,
  func_name   varchar2(10) not null,
  charge_code char(1) not null REFERENCES xcharge(charge_code)
);


insert into XFunction(func_code, func_name, charge_code) VALUES ('O','开户业务','A');
insert into XFunction(func_code, func_name, charge_code) VALUES ('O','开户业务','D');
insert into XFunction(func_code, func_name, charge_code) VALUES ('O','开户业务','E');
-------------------------------------------------------------------------
SELECT user_id,user_status,user_level,user_balance,mobiles_num,cus_type,cus_number
FROM XUSER u INNER JOIN  XCUSTOMER X ON u.CUS_ID = X.CUS_ID;

SELECT user_id,user_status,user_level,user_balance,mobiles_num,cus_type,cus_number
FROM XUSER u INNER JOIN  XCUSTOMER X ON u.CUS_ID = X.CUS_ID;

update xuser set user_balance=user_balance+10 where user_id=4;

insert into XFunction(func_id, func_name, charge_code) VALUES ('O','开户业务','A');
insert into XFunction(func_id, func_name, charge_code) VALUES ('O','开户业务','D');
insert into XFunction(func_id, func_name, charge_code) VALUES ('O','开户业务','E');


SELECT CUS_ID,CUS_TYPE,cus_number,CUS_NAME,CUS_BIRTH,CUS_SEX,CUS_ADD FROM XCUSTOMER
where CUS_TYPE='身份证' and CUS_NUMber='430111198007285521';

SELECT CUS_ID,CUS_TYPE,cus_number,CUS_NAME,CUS_BIRTH,CUS_SEX,CUS_ADD FROM XCUSTOMER
where cus_type='身份证' and cus_number='430111198007285521';

select mobiles_num,mobiles_type,card_num,is_available from xmobiles where is_available='1';

SELECT xm.* from(
  SELECT x.*,row_number() OVER(order by mobiles_num asc) rn from XMOBILES x
  where is_available='1' and mobiles_type='SIM'
) xm where rn>0 and rn<=10
order by mobiles_num asc;

SELECT xu.*,xc.CUS_NAME,xm.mobiles_type from XUser xu INNER JOIN XCUSTOMER xc ON xu.cus_id = xc.CUS_ID
INNER JOIN XMobiles xm ON xu.mobiles_num = xm.mobiles_num where xu.mobiles_num='18199998883';
