/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : shipmanager

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2021-07-11 10:27:48
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cargo`
-- ----------------------------
DROP TABLE IF EXISTS `cargo`;
CREATE TABLE `cargo` (
  `cargoId` smallint(6) NOT NULL,
  `cargoName` varchar(20) DEFAULT NULL,
  `cargoWeight` smallint(6) DEFAULT NULL,
  `shipId` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`cargoId`),
  KEY `cargo_ibfk_1` (`shipId`),
  CONSTRAINT `cargo_ibfk_1` FOREIGN KEY (`shipId`) REFERENCES `ship` (`shipId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cargo
-- ----------------------------
INSERT INTO `cargo` VALUES ('1', 'dasdasd', '15', '1');
INSERT INTO `cargo` VALUES ('3', '阿斯达·', '10', '2');
INSERT INTO `cargo` VALUES ('666', '防护服', '10', '2');

-- ----------------------------
-- Table structure for `ship`
-- ----------------------------
DROP TABLE IF EXISTS `ship`;
CREATE TABLE `ship` (
  `shipId` smallint(6) NOT NULL,
  `shipName` varchar(20) DEFAULT NULL,
  `shipDeparture` varchar(20) DEFAULT NULL,
  `shipDestination` varchar(20) DEFAULT NULL,
  `shipLoad` smallint(6) DEFAULT NULL,
  `shipVolume` smallint(6) NOT NULL,
  PRIMARY KEY (`shipId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ship
-- ----------------------------
INSERT INTO `ship` VALUES ('1', 'asdasd', 'asdasd', 'adada', '15', '50');
INSERT INTO `ship` VALUES ('2', '大事发声', '阿斯达', '萨达萨达撒1', '20', '50');

-- ----------------------------
-- Table structure for `userinfo`
-- ----------------------------
DROP TABLE IF EXISTS `userinfo`;
CREATE TABLE `userinfo` (
  `userName` char(20) NOT NULL,
  `pwd` char(20) NOT NULL,
  PRIMARY KEY (`userName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of userinfo
-- ----------------------------
INSERT INTO `userinfo` VALUES ('23', '12');
INSERT INTO `userinfo` VALUES ('a', '12');
INSERT INTO `userinfo` VALUES ('zw', '123');
INSERT INTO `userinfo` VALUES ('周巍', '123');
DROP TRIGGER IF EXISTS `update_load`;
DELIMITER ;;
CREATE TRIGGER `update_load` AFTER INSERT ON `cargo` FOR EACH ROW update Ship
set shipLoad=(select sum(cargoWeight)
from Cargo
where shipId=Ship.shipId)
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `update_load2`;
DELIMITER ;;
CREATE TRIGGER `update_load2` AFTER UPDATE ON `cargo` FOR EACH ROW update Ship
set shipLoad=(select sum(cargoWeight)
from Cargo
where shipId=Ship.shipId)
;;
DELIMITER ;
DROP TRIGGER IF EXISTS `update_load3`;
DELIMITER ;;
CREATE TRIGGER `update_load3` AFTER DELETE ON `cargo` FOR EACH ROW update Ship
set shipLoad=(select sum(cargoWeight)
from Cargo
where shipId=Ship.shipId)
;;
DELIMITER ;
