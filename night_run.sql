/*
Navicat MySQL Data Transfer

Source Server         : mysql
Source Server Version : 50623
Source Host           : localhost:3306
Source Database       : night_run

Target Server Type    : MYSQL
Target Server Version : 50623
File Encoding         : 65001

Date: 2016-06-05 22:18:50
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for beanadmin
-- ----------------------------
DROP TABLE IF EXISTS `beanadmin`;
CREATE TABLE `beanadmin` (
  `a_id` int(11) NOT NULL AUTO_INCREMENT,
  `ano` varchar(8) NOT NULL,
  `aname` varchar(20) NOT NULL,
  `apwd` varchar(20) NOT NULL,
  `abranch` int(11) NOT NULL,
  PRIMARY KEY (`a_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for beannotice
-- ----------------------------
DROP TABLE IF EXISTS `beannotice`;
CREATE TABLE `beannotice` (
  `n_id` int(11) NOT NULL AUTO_INCREMENT,
  `time` datetime NOT NULL,
  `content` varchar(255) NOT NULL,
  `ano` varchar(8) NOT NULL,
  `branch` int(11) NOT NULL,
  PRIMARY KEY (`n_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for beanrun
-- ----------------------------
DROP TABLE IF EXISTS `beanrun`;
CREATE TABLE `beanrun` (
  `r_id` int(11) NOT NULL AUTO_INCREMENT,
  `meter` double(8,2) NOT NULL,
  `starttime` datetime NOT NULL,
  `endtime` datetime NOT NULL,
  `sno` varchar(8) NOT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for beanuser
-- ----------------------------
DROP TABLE IF EXISTS `beanuser`;
CREATE TABLE `beanuser` (
  `s_id` int(11) NOT NULL AUTO_INCREMENT,
  `sno` varchar(8) NOT NULL,
  `sname` varchar(20) NOT NULL,
  `spwd` varchar(20) NOT NULL DEFAULT '123456',
  `sbranch` int(255) NOT NULL,
  `sgrade` int(255) NOT NULL,
  `addtime` datetime NOT NULL,
  `deltime` datetime DEFAULT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- viewService structure for view_js_as
-- ----------------------------
DROP VIEW IF EXISTS `view_js_as`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost`  VIEW `view_js_as` AS SELECT
	beanadmin.a_id,
	beanuser.s_id,
	beanadmin.ano,
	beanuser.sno,
	beanuser.sname,
	beanuser.sgrade,
	beanuser.addtime,
	beanuser.deltime
FROM
	beanadmin,
	beanuser
WHERE
	beanadmin.abranch = beanuser.sbranch
AND beanadmin.abranch = 1 ;

-- ----------------------------
-- viewService structure for view_js_run
-- ----------------------------
DROP VIEW IF EXISTS `view_js_run`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `view_js_run` AS SELECT
	beanuser.s_id,
	beanrun.r_id,
	beanuser.sno,
beanuser.sname,
	beanuser.sgrade,
	beanrun.meter,
	(
		UNIX_TIMESTAMP(beanrun.endtime) - UNIX_TIMESTAMP(beanrun.starttime)
	) time,
	beanrun.starttime,
	beanrun.endtime
FROM
	beanuser,
	beanrun
WHERE
	beanuser.sbranch = 1  and beanuser.sno=beanrun.sno  and beanuser.deltime is NULL ;

-- ----------------------------
-- viewService structure for view_js_total
-- ----------------------------
DROP VIEW IF EXISTS `view_js_total`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER  VIEW `view_js_total` AS SELECT
	beanuser.s_id,
	beanuser.sno,
	beanuser.sgrade,
	count(beanrun.sno) count,
	sum(beanrun.meter) summeter,
	sum(
		UNIX_TIMESTAMP(beanrun.endtime) - UNIX_TIMESTAMP(beanrun.starttime)
	) sumtime
FROM
	beanuser,
	beanrun
WHERE
	beanuser.sbranch = 1
AND beanrun.sno = beanuser.sno and beanuser.deltime is NULL
GROUP BY
	beanuser.sno ;
