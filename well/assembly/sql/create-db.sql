DROP DATABASE IF EXISTS `game`;
CREATE DATABASE `game`;
use `game`;


delete from mysql.user where User = 'game_user';
grant select,update,delete,insert on `game`.* to 'news_user'@'%' identified by 'game_pwd';
grant select,update,delete,insert on `game`.* to 'news_user'@'localhost' identified by 'game_pwd';
flush privileges;