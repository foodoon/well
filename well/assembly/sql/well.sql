/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50617
Source Host           : localhost:3306
Source Database       : game

Target Server Type    : MYSQL
Target Server Version : 50617
File Encoding         : 65001

Date: 2014-07-28 06:14:13
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `well_challenge`
-- ----------------------------
DROP TABLE IF EXISTS `well_challenge`;
CREATE TABLE `well_challenge` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `court_id` int(11) NOT NULL,
  `challenge_time` date NOT NULL,
  `challenge_desc` varchar(1024) DEFAULT NULL,
  `challenge_result` varchar(255) DEFAULT NULL,
  `goal_count` int(11)  DEFAULT NULL,
  `is_deleted` int(11) NOT NULL default '0',
  `gmt_modify` datetime NOT NULL,
  `gmt_create` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of well_challenge
-- ----------------------------

-- ----------------------------
-- Table structure for `well_challenge_accept`
-- ----------------------------
DROP TABLE IF EXISTS `well_challenge_accept`;
CREATE TABLE `well_challenge_accept` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `challenge_id` int(11) NOT NULL,
  `team_id` int(11) NOT NULL,
  `goal_count` int(11) DEFAULT NULL,
  `challenge_result` varchar(16) DEFAULT NULL,
  `accept` int(11) NOT NULL DEFAULT '0',
  `is_deleted` int(11) NOT NULL default '0',
  `gmt_modify` datetime NOT NULL,
  `gmt_create` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of well_challenge_accept
-- ----------------------------

-- ----------------------------
-- Table structure for `well_challenge_msg`
-- ----------------------------
DROP TABLE IF EXISTS `well_challenge_msg`;
CREATE TABLE `well_challenge_msg` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `challenge_id` int(11) NOT NULL,
  `msg` varchar(1024) NOT NULL,
  `is_deleted` int(11) NOT NULL default '0',
  `gmt_modify` datetime NOT NULL,
  `gmt_create` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of well_challenge_msg
-- ----------------------------

-- ----------------------------
-- Table structure for `well_court`
-- ----------------------------
DROP TABLE IF EXISTS `well_court`;
CREATE TABLE `well_court` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(256) NOT NULL,
  `address` varchar(1024) DEFAULT NULL,
  `type` varchar(32) DEFAULT NULL,
  `open_time` varchar(16) DEFAULT NULL,
  `square` varchar(256) DEFAULT NULL,
  `user_id` int(11) NOT NULL,
  `is_deleted` int(11)  NOT NULL default '0',
  `status` int(11) DEFAULT NULL,
  `court_desc` varchar(1024) DEFAULT NULL,
  `gmt_modify` datetime NOT NULL,
  `gmt_create` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of well_court
-- ----------------------------

-- ----------------------------
-- Table structure for `well_court_apply`
-- ----------------------------
DROP TABLE IF EXISTS `well_court_apply`;
CREATE TABLE `well_court_apply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `court_id` int(11) NOT NULL,
  `booking_time` datetime NOT NULL,
  `is_deleted` int(11) DEFAULT NULL default '0',
  `gmt_modify` datetime DEFAULT NULL,
  `gmt_create` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of well_court_apply
-- ----------------------------

-- ----------------------------
-- Table structure for `well_goods`
-- ----------------------------
DROP TABLE IF EXISTS `well_goods`;
CREATE TABLE `well_goods` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(64) NOT NULL,
  `goods_desc` varchar(1024) DEFAULT NULL,
  `price` bigint(20) NOT NULL DEFAULT '0',
  `court_id` int(11) NOT NULL,
  `is_deleted` int(11) NOT NULL default '0',
  `gmt_modify` datetime NOT NULL,
  `gmt_create` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of well_goods
-- ----------------------------

-- ----------------------------
-- Table structure for `well_order`
-- ----------------------------
DROP TABLE IF EXISTS `well_order`;
CREATE TABLE `well_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `goods_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `delivery_time` datetime DEFAULT NULL,
  `leave_msg` varchar(1024) DEFAULT NULL,
  `is_deleted` int(11) NOT NULL default '0',
  `gmt_modify` datetime NOT NULL,
  `gmt_create` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of well_order
-- ----------------------------

-- ----------------------------
-- Table structure for `well_team`
-- ----------------------------
DROP TABLE IF EXISTS `well_team`;
CREATE TABLE `well_team` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(64) NOT NULL,
  `team_desc` varchar(1024) DEFAULT NULL,
  `can_join` int(11) DEFAULT NULL,
  `is_deleted` int(11) DEFAULT NULL default '0',
  `gmt_modify` datetime NOT NULL,
  `gmt_create` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of well_team
-- ----------------------------

-- ----------------------------
-- Table structure for `well_team_apply`
-- ----------------------------
DROP TABLE IF EXISTS `well_team_apply`;
CREATE TABLE `well_team_apply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `team_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `status` int(11) NOT NULL,
  `is_deleted` int(11) NOT NULL default '0',
  `gmt_modify` datetime NOT NULL,
  `gmt_create` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of well_team_apply
-- ----------------------------

-- ----------------------------
-- Table structure for `well_team_recruit`
-- ----------------------------
DROP TABLE IF EXISTS `well_team_recruit`;
CREATE TABLE `well_team_recruit` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `recruit_desc` varchar(1024) DEFAULT NULL,
  `is_deleted` int(11) NOT NULL default '0',
  `gmt_modify` datetime NOT NULL,
  `gmt_create` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of well_team_recruit
-- ----------------------------

-- ----------------------------
-- Table structure for `well_user`
-- ----------------------------
DROP TABLE IF EXISTS `well_user`;
CREATE TABLE `well_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(16) NOT NULL,
  `real_name` varchar(16) ,
  `email` varchar(16) ,
  `address` varchar(1024) ,
  `password` varchar(32) NOT NULL,
  `phone` varchar(16) ,
  `ground_type_of_enjoy` varchar(32) DEFAULT NULL,
  `special` varchar(1024) DEFAULT NULL,
  `ground_of_daily` varchar(1024) DEFAULT NULL,
  `status` int(11) DEFAULT NULL,
  `img` varchar(256) DEFAULT NULL,
  `gmt_modify` datetime NOT NULL,
  `gmt_create` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of well_user
-- ----------------------------
