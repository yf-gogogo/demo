/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : upload

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-01-23 17:27:58
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for res
-- ----------------------------
DROP TABLE IF EXISTS `res`;
CREATE TABLE `res` (
  `r_id` int(11) NOT NULL AUTO_INCREMENT,
  `r_md5` varchar(255) DEFAULT NULL,
  `r_path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`r_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of res
-- ----------------------------
INSERT INTO `res` VALUES ('1', '7c6bbfb022ec54f74fef2eef29788137', 'D:/game/cf/CN103180850A.caj');
INSERT INTO `res` VALUES ('2', 'f086173be1d090e1effca46983352771', 'D:/game/cf/多媒体网络传输的研究与实现_王军.caj');
INSERT INTO `res` VALUES ('3', '4b2943b7a69c022654ae49bb76d0f193', 'D:/game/cf/多媒体技术在教育教学中的应用综述_封莉.pdf');
INSERT INTO `res` VALUES ('4', 'bd9d7e669db8acdf55c3c531d1cee341', 'D:/game/cf/楚门的世界.mp4');
INSERT INTO `res` VALUES ('5', 'feacf333c24825dd31edef0bc317d8d8', 'D:/game/cf/sintel_trailer-720p.mp4');
