create database SNSApp;

use SNSApp;

create table USER_MASTER(
USER_ID char(12) primary key,
PASSWORD varchar(16) not null
);

create table USER_INFO(
USER_NO char(12) primary key,
FAMILY_NAME varchar(20) not null,
FIRST_NAME varchar(20) not null,
BIRTHDAY date not null,
CHAT_NAME varchar(16)
);

create table ERROR_INFO(
ERROR_CD CHAR(4) primary key,
ERROR_WORDS varchar(100) not null
);

create table MESSAGE(
MSG_NO int(6) UNSIGNED ZEROFILL primary key AUTO_INCREMENT,
USER_NO char(12),
MESSAGE varchar(200),
DEL_FLG boolean,
CREATE_DT timestamp,
UPDATE_DT timestamp,
foreign key (USER_NO) references USER_INFO(USER_NO)
);

select * from user_master;
select * from user_info;
select * from message;

insert into USER_MASTER values('test', 'testtest');
insert into USER_INFO values('test', 'FamilyName', 'FirstName', '20200627','testSNSApp');
insert into message(USER_NO, MESSAGE, DEL_FLG, CREATE_DT, UPDATE_DT)
 values('test','Hello, This is SNSApp.', 0, LOCALTIMESTAMP(), LOCALTIMESTAMP());


