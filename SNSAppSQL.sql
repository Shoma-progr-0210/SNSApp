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

create table MESSAGE_INFO(
MSG_NO int(6) UNSIGNED ZEROFILL primary key AUTO_INCREMENT,
USER_NO char(12),
MESSAGE varchar(200),
DEL_FLG boolean,
CREATE_DT timestamp,
UPDATE_DT timestamp,
foreign key (USER_NO) references USER_INFO(USER_NO)
);


insert into USER_MASTER values('tester', 'testtest');
insert into USER_INFO values('tester', 'FamilyName', 'FirstName', '20200627','testSNSApp');
insert into message_INFO(USER_NO, MESSAGE, DEL_FLG, CREATE_DT, UPDATE_DT)
 values('tester','Hello, This is SNSApp.', 0, LOCALTIMESTAMP(), LOCALTIMESTAMP());
 
insert into error_info values('1001','DBアクセスエラーです。');
insert into error_info values('0105','該当するユーザが存在しません。ログインに失敗しました。');
insert into error_info values('0106','ユーザIDは5桁以上12桁以下で入力してください。');
insert into error_info values('0107','ユーザIDは半角英数字で入力してください。');
insert into error_info values('0103','パスワードは8桁以上16桁以下で入力してください。');
insert into error_info values('0104','パスワードは半角英数字で入力してください。');
insert into error_info values('0601','セッションが切断されました。もう一度ログインからやり直してください。');
insert into error_info values('0701','メッセージは200文字以下で入力して下さい。');
insert into error_info values('0702','メッセージが送信出来ませんでした。');


select * from user_master;
select * from user_info;
select * from message_INFO;
 


