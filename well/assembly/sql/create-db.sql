DROP DATABASE IF EXISTS `well`;
CREATE DATABASE `well`;
use `well`;


delete from mysql.user where User = 'well_user';
grant select,update,delete,insert on `well`.* to 'well_user'@'%' identified by 'well_pwd';
grant select,update,delete,insert on `well`.* to 'well_user'@'localhost' identified by 'well_pwd';
flush privileges;