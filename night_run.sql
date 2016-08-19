/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : night_run

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2016-07-14 11:17:45
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log` (
  `log_id` int(11) NOT NULL AUTO_INCREMENT,
  `log_table` varchar(255) CHARACTER SET utf8 NOT NULL,
  `log_dml` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  `log_key_id` int(11) DEFAULT NULL,
  `log_date` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `log_username` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`log_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for permission
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `permissionname` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `permissionsign` varchar(128) CHARACTER SET utf8 DEFAULT NULL,
  `desription` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rolename` varchar(20) CHARACTER SET utf8 DEFAULT NULL,
  `rolesign` varchar(128) CHARACTER SET utf8 DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8 DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for role_permission
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_id` int(11) DEFAULT NULL,
  `permission_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for run
-- ----------------------------
DROP TABLE IF EXISTS `run`;
CREATE TABLE `run` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `meter` double(8,2) NOT NULL DEFAULT '2000.00',
  `starttime` datetime NOT NULL,
  `endtime` datetime NOT NULL,
  `userid` int(8) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userno` varchar(8) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(128) NOT NULL DEFAULT 'e10adc3949ba59abbe56e057f20f883e',
  `userbranch` varchar(1) DEFAULT NULL,
  `usergrade` varchar(2) DEFAULT NULL,
  `addtime` datetime NOT NULL,
  `deltime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Procedure structure for prc_user_insert
-- ----------------------------
DROP PROCEDURE IF EXISTS `prc_user_insert`;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `prc_user_insert`(v_sno varchar(8),
	v_sname varchar(20))
begin
DECLARE
  v_s varchar(8) DEFAULT '';
	select sno into v_s from beanuser where sno=v_sno;
if v_s='' then
	insert into beanuser(sno,sname,sgrade,sbranch,addtime) values(v_sno,v_sname,substr(v_sno, 2, 2),substr(v_sno, 5, 1),CURRENT_TIMESTAMP);
end if;
END
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `trg_user_insert`;
DELIMITER ;;
CREATE TRIGGER `trg_user_insert` AFTER INSERT ON `user` FOR EACH ROW BEGIN
	insert into user_role(user_id,role_id) values(new.id,2);
end
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `trg_user_delete`;
DELIMITER ;;
CREATE TRIGGER `trg_user_delete` AFTER DELETE ON `user` FOR EACH ROW BEGIN
	delete from user_role where user_id not in (select id from user);
	delete from run where userid not in (select id from user);
end
;;
DELIMITER ;
SET FOREIGN_KEY_CHECKS=1;
