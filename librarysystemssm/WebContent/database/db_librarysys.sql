/*
Navicat MySQL Data Transfer

Source Server         : usemysql
Source Server Version : 50713
Source Host           : localhost:3306
Source Database       : db_librarysys

Target Server Type    : MYSQL
Target Server Version : 50713
File Encoding         : 65001

Date: 2018-12-20 12:16:47
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for tb_applyinfo
-- ----------------------------
DROP TABLE IF EXISTS `tb_applyinfo`;
CREATE TABLE `tb_applyinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `readerid` int(11) DEFAULT NULL,
  `del` tinyint(4) DEFAULT NULL,
  `operator` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_applyinfo
-- ----------------------------
INSERT INTO `tb_applyinfo` VALUES ('4', '5', '1', 'tsoft');

-- ----------------------------
-- Table structure for tb_bookcase
-- ----------------------------
DROP TABLE IF EXISTS `tb_bookcase`;
CREATE TABLE `tb_bookcase` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `Column_3` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_bookcase
-- ----------------------------
INSERT INTO `tb_bookcase` VALUES ('1', 'C架', null);
INSERT INTO `tb_bookcase` VALUES ('3', 'A架', null);
INSERT INTO `tb_bookcase` VALUES ('4', 'B架', null);
INSERT INTO `tb_bookcase` VALUES ('5', 'D架', null);
INSERT INTO `tb_bookcase` VALUES ('6', 'E架', null);
INSERT INTO `tb_bookcase` VALUES ('7', 'F架', null);

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
) ENGINE=InnoDB AUTO_INCREMENT=70 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_bookinfo
-- ----------------------------
INSERT INTO `tb_bookinfo` VALUES ('833198569328', '围城', '3', '钱钟书', '钱钟书', '7-302', '20.00', '0', '3', '2018-12-19', '', '0', '55');
INSERT INTO `tb_bookinfo` VALUES ('199521030073', '追风筝的人', '3', '卡勒德·胡赛尼', '', '978-7', '25.00', '1', '3', '2018-12-19', '', '0', '56');
INSERT INTO `tb_bookinfo` VALUES ('889965852136', '活着', '3', '余华', '余华', '978-7', '20.00', '1', '3', '2018-12-19', '', '0', '57');
INSERT INTO `tb_bookinfo` VALUES ('635457467279', 'Java编程规范', '1', 'xxxx', '', '7-302', '40.00', '1', '4', '2018-12-19', '', '0', '58');
INSERT INTO `tb_bookinfo` VALUES ('163510129291', 'Java编程思想', '1', 'xxxx', '', '7-302', '50.00', '1', '4', '2018-12-19', '', '0', '59');
INSERT INTO `tb_bookinfo` VALUES ('435036505350', 'Java数据结构和算法', '1', 'xxxxx', '', '7-302', '60.00', '1', '4', '2018-12-19', '', '0', '60');
INSERT INTO `tb_bookinfo` VALUES ('752707176020', '重构：改善既有代码的设计', '1', 'xxxx', '', '978-7', '50.00', '1', '1', '2018-12-19', '', '0', '61');
INSERT INTO `tb_bookinfo` VALUES ('378030070939', 'XML入门经典', '1', 'xxxx', '', '7-302', '50.00', '1', '1', '2018-12-19', '', '0', '62');
INSERT INTO `tb_bookinfo` VALUES ('216937180683', 'JavaScript权威指南', '1', 'xxx', '', '7-302', '60.00', '1', '1', '2018-12-19', '', '0', '63');
INSERT INTO `tb_bookinfo` VALUES ('527759074498', 'Java并发编程实践', '1', 'xxx', '', '7-302', '50.00', '1', '4', '2018-12-19', '', '0', '64');
INSERT INTO `tb_bookinfo` VALUES ('642845758570', '建筑空间组合论', '4', '彭一刚', '', '978-7', '30.00', '1', '5', '2018-12-19', '', '0', '65');
INSERT INTO `tb_bookinfo` VALUES ('387106313966', '形式空间与秩序', '4', '程大锦', '程大锦', '978-7', '50.00', '1', '5', '2018-12-19', '', '0', '66');
INSERT INTO `tb_bookinfo` VALUES ('701877042098', '建筑学教程1：设计原理', '4', 'xxx', '', '8-256', '80.00', '1', '5', '2018-12-19', '', '0', '67');
INSERT INTO `tb_bookinfo` VALUES ('160100264040', '平面设计法则', '5', '德比·米尔曼', '', '978-7', '30.00', '1', '6', '2018-12-19', '', '0', '68');
INSERT INTO `tb_bookinfo` VALUES ('876056640989', '设计心理学', '5', '唐纳德﹒A﹒诺曼', '', '7-302', '40.00', '1', '6', '2018-12-19', '', '0', '69');

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
  `status` tinyint(4) DEFAULT NULL COMMENT '0--新建,1--处理完成,2--归还,3--续借4--拒绝借阅,5--拒绝续借6--拒绝归还',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_borrow
-- ----------------------------
INSERT INTO `tb_borrow` VALUES ('1', '5', '55', '2018-12-20', '2019-01-24', 'tsoft', '1', '2');
INSERT INTO `tb_borrow` VALUES ('2', '5', '58', '2018-12-20', '2019-01-19', 'tsoft', '1', '2');
INSERT INTO `tb_borrow` VALUES ('3', '5', '59', '2018-12-20', '2019-01-19', 'tsoft', '1', '2');

-- ----------------------------
-- Table structure for tb_giveback
-- ----------------------------
DROP TABLE IF EXISTS `tb_giveback`;
CREATE TABLE `tb_giveback` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `readerid` int(11) DEFAULT NULL,
  `bookid` int(11) DEFAULT NULL,
  `backTime` date DEFAULT NULL,
  `status` tinyint(4) DEFAULT NULL,
  `operator` varchar(30) DEFAULT NULL,
  `borrowid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_giveback
-- ----------------------------
INSERT INTO `tb_giveback` VALUES ('1', '5', '55', '2018-12-20', '1', 'tsoft', '1');
INSERT INTO `tb_giveback` VALUES ('2', '5', '58', '2018-12-20', '1', 'tsoft', '2');
INSERT INTO `tb_giveback` VALUES ('3', '5', '59', '2018-12-20', '1', 'tsoft', '3');

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
INSERT INTO `tb_library` VALUES ('1', '212', '4112', '18276354736', 'ccsd', '123@163.com', 'http://', '2018-11-30', '是');

-- ----------------------------
-- Table structure for tb_manager
-- ----------------------------
DROP TABLE IF EXISTS `tb_manager`;
CREATE TABLE `tb_manager` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(30) DEFAULT NULL,
  `PWD` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_manager
-- ----------------------------
INSERT INTO `tb_manager` VALUES ('4', 'tsoft', '1234');
INSERT INTO `tb_manager` VALUES ('6', 'java12', '1234');
INSERT INTO `tb_manager` VALUES ('8', 'java1234', '1234');

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
INSERT INTO `tb_parameter` VALUES ('1', '35', '24');

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
INSERT INTO `tb_publishing` VALUES ('8-256', '中国青年出版社');

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
  `url` varchar(200) DEFAULT NULL COMMENT '图片在服务器上的地址',
  `status` varchar(50) DEFAULT NULL,
  `libraryCard` varchar(50) DEFAULT NULL COMMENT '借书证号',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_reader
-- ----------------------------
INSERT INTO `tb_reader` VALUES ('1', 'wgh', '男', '2008010100001', '的', '1980-07-17', '身份证', '2201041980********', '17865345674', 'wgh717@163.com', '2007-11-22', 'tsoft', '的', '1', '123', null, '1', '465823947640');
INSERT INTO `tb_reader` VALUES ('5', 'lucy', '女', '591347167323', null, '2000-12-10', '身份证', '291826200012109837', '18767568735', 'lucy@163.com', '2018-12-19', null, '', '1', '1234', null, '1', '218966913541');

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
INSERT INTO `tb_readertype` VALUES ('3', '其他', '6');
