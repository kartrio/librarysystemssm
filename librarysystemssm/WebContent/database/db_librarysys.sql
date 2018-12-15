/*
Navicat MySQL Data Transfer

Source Server         : usemysql
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : db_librarysys

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-12-14 16:50:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_bookcase
-- ----------------------------
DROP TABLE IF EXISTS `tb_bookcase`;
CREATE TABLE `tb_bookcase` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `Column_3` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_bookcase
-- ----------------------------
INSERT INTO `tb_bookcase` VALUES ('1', 'C架', null);
INSERT INTO `tb_bookcase` VALUES ('3', 'A架', null);
INSERT INTO `tb_bookcase` VALUES ('4', 'B架', null);
INSERT INTO `tb_bookcase` VALUES ('5', 'D架', null);
INSERT INTO `tb_bookcase` VALUES ('6', 'E架', null);
INSERT INTO `tb_bookcase` VALUES ('7', 'F架', null);
INSERT INTO `tb_bookcase` VALUES ('8', 'G架', null);
INSERT INTO `tb_bookcase` VALUES ('9', 'H架', null);
INSERT INTO `tb_bookcase` VALUES ('10', 'I架', null);

-- ----------------------------
-- Table structure for tb_bookinfo
-- ----------------------------
DROP TABLE IF EXISTS `tb_bookinfo`;
CREATE TABLE `tb_bookinfo` (
  `barcode` varchar(30) DEFAULT NULL,
  `bookname` varchar(70) DEFAULT NULL,
  `typeid` int(10) unsigned DEFAULT NULL,
  `author` varchar(30) DEFAULT NULL,
  `translator` varchar(30) DEFAULT NULL,
  `ISBN` varchar(20) DEFAULT NULL,
  `price` float(8,2) DEFAULT NULL,
  `page` int(10) unsigned DEFAULT NULL,
  `bookcase` int(10) unsigned DEFAULT NULL,
  `inTime` date DEFAULT NULL,
  `operator` varchar(30) DEFAULT NULL,
  `del` tinyint(1) DEFAULT '0',
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=54 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_bookinfo
-- ----------------------------
INSERT INTO `tb_bookinfo` VALUES ('9787302047230', 'Java学习指南', '1', '***', '11', '7-302', '39.00', '440', '3', '2007-11-22', 'tsoft', '0', '1');
INSERT INTO `tb_bookinfo` VALUES ('jk', 'kjkj', '1', '***', '', '7-302', '12.00', '0', '1', '2007-11-22', 'tsoft', '1', '2');
INSERT INTO `tb_bookinfo` VALUES ('001', '建筑测试', '4', '做做', '的', '7-302', '11.00', '11', '4', '2013-05-03', 'java1234', '0', '6');
INSERT INTO `tb_bookinfo` VALUES ('201812111044', 'java编程基础', '1', '潘磊', null, '7-302', '38.00', '300', '3', null, null, '0', '7');
INSERT INTO `tb_bookinfo` VALUES ('213123', 'Java1', '4', 'xxx', null, '7-302', '23.00', '1', '8', '2018-12-13', '', '0', '9');
INSERT INTO `tb_bookinfo` VALUES ('45622', 'Java2', '1', 'sada', null, '7-302', '23.00', '1', '1', '2018-12-13', '', '0', '10');
INSERT INTO `tb_bookinfo` VALUES ('123123', '请问', '1', '1231', null, '7-302', '12.00', '1', '1', null, null, '0', '52');
INSERT INTO `tb_bookinfo` VALUES ('123123', '12321', '1', '21233', null, '7-302', '123.00', '1', '1', '2018-12-13', 'tsoft', '0', '53');

-- ----------------------------
-- Table structure for tb_booktype
-- ----------------------------
DROP TABLE IF EXISTS `tb_booktype`;
CREATE TABLE `tb_booktype` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `typename` varchar(30) DEFAULT NULL,
  `days` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_booktype
-- ----------------------------
INSERT INTO `tb_booktype` VALUES ('1', '计算机类', '30');
INSERT INTO `tb_booktype` VALUES ('3', '文学类', '35');
INSERT INTO `tb_booktype` VALUES ('4', '建筑类', '20');
INSERT INTO `tb_booktype` VALUES ('5', '设计类', '30');

-- ----------------------------
-- Table structure for tb_borrow
-- ----------------------------
DROP TABLE IF EXISTS `tb_borrow`;
CREATE TABLE `tb_borrow` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `readerid` int(10) unsigned DEFAULT NULL,
  `bookid` int(10) DEFAULT NULL,
  `borrowTime` date DEFAULT NULL,
  `backTime` date DEFAULT NULL,
  `operator` varchar(30) DEFAULT NULL,
  `ifback` tinyint(1) DEFAULT '0',
  `status` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_borrow
-- ----------------------------
INSERT INTO `tb_borrow` VALUES ('1', '1', '1', '2007-11-22', '2007-12-22', 'tsoft', '1', '1');
INSERT INTO `tb_borrow` VALUES ('2', '1', '2', '2007-11-26', '2007-12-26', 'tsoft', '0', '0');
INSERT INTO `tb_borrow` VALUES ('3', '1', '1', '2007-11-26', '2007-12-26', 'tsoft', '0', '0');
INSERT INTO `tb_borrow` VALUES ('4', '2', '6', '2007-12-29', '2007-01-08', 'tsoft', '0', '0');
INSERT INTO `tb_borrow` VALUES ('5', '2', '1', '2007-12-29', '2008-01-28', 'tsoft', '0', '0');
INSERT INTO `tb_borrow` VALUES ('6', '2', '7', '2007-12-29', '2008-01-28', 'tsoft', '1', '1');
INSERT INTO `tb_borrow` VALUES ('7', '1', '6', '2013-05-03', '2013-05-23', 'java1234', '1', '1');
INSERT INTO `tb_borrow` VALUES ('8', '1', '6', '2013-05-03', '2013-05-23', 'java1234', '1', '1');
INSERT INTO `tb_borrow` VALUES ('9', '1', '6', '2013-05-03', '2013-05-23', 'java1234', '1', '1');
INSERT INTO `tb_borrow` VALUES ('10', '1', '1', '2013-05-03', '2013-06-02', 'java1234', '0', '0');

-- ----------------------------
-- Table structure for tb_giveback
-- ----------------------------
DROP TABLE IF EXISTS `tb_giveback`;
CREATE TABLE `tb_giveback` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `readerid` int(11) DEFAULT NULL,
  `bookid` int(11) DEFAULT NULL,
  `backTime` date DEFAULT NULL,
  `operator` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_giveback
-- ----------------------------
INSERT INTO `tb_giveback` VALUES ('1', '1', '1', '2007-11-22', 'tsoft');
INSERT INTO `tb_giveback` VALUES ('2', '3', '3', '2007-01-03', 'Tsoft');
INSERT INTO `tb_giveback` VALUES ('3', '1', '6', '2013-05-03', 'java1234');
INSERT INTO `tb_giveback` VALUES ('4', '1', '6', '2013-05-03', 'java1234');
INSERT INTO `tb_giveback` VALUES ('5', '1', '6', '2013-05-03', 'java1234');

-- ----------------------------
-- Table structure for tb_library
-- ----------------------------
DROP TABLE IF EXISTS `tb_library`;
CREATE TABLE `tb_library` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `libraryname` varchar(50) DEFAULT NULL,
  `curator` varchar(10) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `url` varchar(100) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `introduce` text,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_library
-- ----------------------------
INSERT INTO `tb_library` VALUES ('1', '212', '4112', '6756896', 'ccsd', '123@163.com', 'http://', '2018-11-28', '是');

-- ----------------------------
-- Table structure for tb_manager
-- ----------------------------
DROP TABLE IF EXISTS `tb_manager`;
CREATE TABLE `tb_manager` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `PWD` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_manager
-- ----------------------------
INSERT INTO `tb_manager` VALUES ('4', 'tsoft', '123');
INSERT INTO `tb_manager` VALUES ('6', 'java12', '1234');
INSERT INTO `tb_manager` VALUES ('8', 'java1234', '1234');
INSERT INTO `tb_manager` VALUES ('22', 'wgh', '1234');
INSERT INTO `tb_manager` VALUES ('27', '的', '1234');

-- ----------------------------
-- Table structure for tb_parameter
-- ----------------------------
DROP TABLE IF EXISTS `tb_parameter`;
CREATE TABLE `tb_parameter` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `cost` int(10) unsigned DEFAULT NULL,
  `validity` int(10) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_parameter
-- ----------------------------
INSERT INTO `tb_parameter` VALUES ('1', '40', '24');

-- ----------------------------
-- Table structure for tb_permission
-- ----------------------------
DROP TABLE IF EXISTS `tb_permission`;
CREATE TABLE `tb_permission` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `url` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_permission
-- ----------------------------
INSERT INTO `tb_permission` VALUES ('1', '系统菜单', '0', null);
INSERT INTO `tb_permission` VALUES ('2', '系统设置', '1', null);
INSERT INTO `tb_permission` VALUES ('3', '读者管理', '1', null);
INSERT INTO `tb_permission` VALUES ('4', '图书管理', '1', null);
INSERT INTO `tb_permission` VALUES ('5', '图书借还', '1', null);
INSERT INTO `tb_permission` VALUES ('6', '系统查询', '1', null);
INSERT INTO `tb_permission` VALUES ('7', '图书馆信息', '2', null);
INSERT INTO `tb_permission` VALUES ('8', '管理员设置', '2', null);
INSERT INTO `tb_permission` VALUES ('9', '参数设置', '2', null);
INSERT INTO `tb_permission` VALUES ('10', '书架设置', '2', null);
INSERT INTO `tb_permission` VALUES ('11', '读者类型管理', '3', null);
INSERT INTO `tb_permission` VALUES ('12', '读者档案管理', '3', null);
INSERT INTO `tb_permission` VALUES ('13', '图书类型管理', '4', null);
INSERT INTO `tb_permission` VALUES ('14', '图书档案管理', '4', null);
INSERT INTO `tb_permission` VALUES ('15', '图书借阅', '5', null);
INSERT INTO `tb_permission` VALUES ('16', '图书续借', '5', null);
INSERT INTO `tb_permission` VALUES ('17', '图书归还', '5', null);
INSERT INTO `tb_permission` VALUES ('18', '图书档案查询', '6', null);
INSERT INTO `tb_permission` VALUES ('19', '图书借阅查询', '6', null);
INSERT INTO `tb_permission` VALUES ('20', '借阅到期提醒', '6', null);

-- ----------------------------
-- Table structure for tb_publishing
-- ----------------------------
DROP TABLE IF EXISTS `tb_publishing`;
CREATE TABLE `tb_publishing` (
  `ISBN` varchar(20) DEFAULT NULL,
  `pubname` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_publishing
-- ----------------------------
INSERT INTO `tb_publishing` VALUES ('7-302', '电子工业出版社');
INSERT INTO `tb_publishing` VALUES ('978-7', '清华大学出版社');

-- ----------------------------
-- Table structure for tb_purview
-- ----------------------------
DROP TABLE IF EXISTS `tb_purview`;
CREATE TABLE `tb_purview` (
  `id` int(11) NOT NULL,
  `sysset` tinyint(1) DEFAULT '0',
  `readerset` tinyint(1) DEFAULT '0',
  `bookset` tinyint(1) DEFAULT '0',
  `borrowback` tinyint(1) DEFAULT '0',
  `sysquery` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_purview
-- ----------------------------
INSERT INTO `tb_purview` VALUES ('3', '1', '1', '1', '1', '1');
INSERT INTO `tb_purview` VALUES ('4', '1', '1', '1', '1', '1');

-- ----------------------------
-- Table structure for tb_reader
-- ----------------------------
DROP TABLE IF EXISTS `tb_reader`;
CREATE TABLE `tb_reader` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `sex` varchar(4) DEFAULT NULL,
  `barcode` varchar(30) DEFAULT NULL,
  `vocation` varchar(50) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `paperType` varchar(10) DEFAULT NULL,
  `paperNO` varchar(20) DEFAULT NULL,
  `tel` varchar(20) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `operator` varchar(30) DEFAULT NULL,
  `remark` text,
  `typeid` int(11) DEFAULT NULL,
  `pwd` varchar(20) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_reader
-- ----------------------------
INSERT INTO `tb_reader` VALUES ('1', 'wgh', '男', '2008010100001', '的', '1980-07-17', '身份证', '2201041980********', '13634*******', 'wgh717@****.com', '2007-11-22', 'tsoft', '的', '1', '1234', null);
INSERT INTO `tb_reader` VALUES ('2', '的', '女', '123123123', '的', '1983-02-22', '身份证', '220', '', '', '2007-12-29', 'tsoft', '', '2', '1234', null);

-- ----------------------------
-- Table structure for tb_readertype
-- ----------------------------
DROP TABLE IF EXISTS `tb_readertype`;
CREATE TABLE `tb_readertype` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `number` int(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_readertype
-- ----------------------------
INSERT INTO `tb_readertype` VALUES ('1', '学生', '15');
INSERT INTO `tb_readertype` VALUES ('2', '教师', '20');
INSERT INTO `tb_readertype` VALUES ('3', '其他', '5');
