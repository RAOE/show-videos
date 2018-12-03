/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : scetc-show-video-dev

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2018-12-03 10:22:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `adminusers`
-- ----------------------------
DROP TABLE IF EXISTS `adminusers`;
CREATE TABLE `adminusers` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `username` varchar(22) DEFAULT NULL,
  `realname` varchar(22) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `phonenumber` varchar(22) DEFAULT NULL,
  `email` varchar(22) DEFAULT NULL,
  `position` varchar(22) DEFAULT NULL,
  `salt` varchar(22) DEFAULT NULL,
  `qq` varchar(22) DEFAULT NULL,
  `latitude` double DEFAULT NULL,
  `longitude` double DEFAULT NULL,
  `registerDate` datetime DEFAULT NULL,
  `updateDate` datetime DEFAULT NULL,
  `loginIp` varchar(22) DEFAULT NULL,
  `useragent` varchar(22) DEFAULT NULL,
  `geohash` bigint(22) DEFAULT NULL,
  `isDeleted` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adminusers
-- ----------------------------
INSERT INTO `adminusers` VALUES ('1', 'admin', '徐塬峰', 'da4799f536c020929a55f2631039118f', '15008121886', '986771570@qq.com', '四川成都', '111111', '986771570', '39.91488908', '116.40387397116', '2018-11-27 10:30:34', '2018-11-28 10:30:37', '10.127.11.22', 'Mozilla/5.0 (Windows N', '282904150014060920', '0');

-- ----------------------------
-- Table structure for `bgm`
-- ----------------------------
DROP TABLE IF EXISTS `bgm`;
CREATE TABLE `bgm` (
  `id` bigint(64) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=233 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bgm
-- ----------------------------
INSERT INTO `bgm` VALUES ('226', 'bgm04.mp3', 'bgm04.mp3', '\\bgm\\3f7c327b-1029-4468-8c5f-a448310b54fc.mp3');
INSERT INTO `bgm` VALUES ('227', 'bgm03.mp3', 'bgm03.mp3', '\\bgm\\cf81f9e1-991c-4d5e-b4c9-42e676779c63.mp3');
INSERT INTO `bgm` VALUES ('228', 'Superstar-Beatrich.mp3', 'Superstar-Beatrich.mp3', '\\bgm\\5f49ba83-18b2-46b7-9000-8adeda410ee1.mp3');
INSERT INTO `bgm` VALUES ('230', 'test1.mp3', 'test1.mp3', '\\bgm\\48b1a613-dd01-47d0-964c-995e5c2e29d1.mp3');
INSERT INTO `bgm` VALUES ('231', 'test2.mp3', 'test2.mp3', '\\bgm\\3cc7949d-e4b1-4243-96c8-014a85261fe8.mp3');
INSERT INTO `bgm` VALUES ('232', 'test3.mp3', 'test3.mp3', '\\bgm\\1c517942-bfa5-4883-8c2e-342f82c5f376.mp3');

-- ----------------------------
-- Table structure for `blockip`
-- ----------------------------
DROP TABLE IF EXISTS `blockip`;
CREATE TABLE `blockip` (
  `id` bigint(22) NOT NULL DEFAULT '0',
  `userId` varchar(50) DEFAULT NULL,
  `ip` varchar(50) DEFAULT NULL,
  `city` varchar(22) DEFAULT NULL,
  `browserType` varchar(22) DEFAULT NULL,
  `platformType` varchar(22) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blockip
-- ----------------------------

-- ----------------------------
-- Table structure for `comments`
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `id` varchar(20) DEFAULT NULL,
  `video_id` varchar(20) DEFAULT NULL,
  `from_user_id` varchar(20) DEFAULT NULL,
  `comment` text,
  `create_time` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES ('181030HHDZ4896K4', '181027HZ5T8YR494', '181027HKFNAXK494', '123', '2018-10-30 23:14:39');
INSERT INTO `comments` VALUES ('1810317WNFCPFWM8', '181027HZ5T8YR494', '181027HKFNAXK494', '好好吃', '2018-10-31 11:02:39');
INSERT INTO `comments` VALUES ('1810317Y7K5AYBXP', '181027HZ5T8YR494', '181027HKFNAXK494', '123', '2018-10-31 11:07:22');
INSERT INTO `comments` VALUES ('18103186MM1NNHX4', '181027HT6X1HRN9P', '181027HKFNAXK494', 'aaa', '2018-10-31 11:32:34');
INSERT INTO `comments` VALUES ('181031875X2WA23C', '181027HZ5T8YR494', '181027HKFNAXK494', '看起来很好吃的样子', '2018-10-31 11:34:13');
INSERT INTO `comments` VALUES ('18103188P2S6ZCM8', '181027HZ5T8YR494', '181027HKFNAXK494', '12', '2018-10-31 11:38:44');
INSERT INTO `comments` VALUES ('181031GTK4PDYFW0', '181027HZ5T8YR494', '181027HKFNAXK494', '啦啦啦', '2018-10-31 22:11:57');
INSERT INTO `comments` VALUES ('181031GTXYR7GCM8', '181027HZ5T8YR494', '181027HKFNAXK494', '饺子饺子！！！！', '2018-10-31 22:12:53');
INSERT INTO `comments` VALUES ('181031GW2FZ5WNXP', '181027HZ5T8YR494', '181027HKFNAXK494', '大饺子', '2018-10-31 22:13:23');
INSERT INTO `comments` VALUES ('181031GW3FA115KP', '181027HZ5T8YR494', '181027HKFNAXK494', '啦啦啦啦啦', '2018-10-31 22:13:29');
INSERT INTO `comments` VALUES ('181031H31HXFK1AW', '181027HY408D0HM8', '181027HKFNAXK494', '直男暖男pk', '2018-10-31 22:34:18');
INSERT INTO `comments` VALUES ('181031HDBBMZBFY8', '181031HDA371NXAW', '181031HD3RAWWKKP', '哈哈哈 ', '2018-10-31 23:05:23');
INSERT INTO `comments` VALUES ('181031HDC2YMRFRP', '181031HDA371NXAW', '181031HD3RAWWKKP', '好搞笑', '2018-10-31 23:05:27');
INSERT INTO `comments` VALUES ('181031HDCP68M2RP', '181031HDA371NXAW', '181031HD3RAWWKKP', '好搞笑', '2018-10-31 23:05:31');
INSERT INTO `comments` VALUES ('181031HDFY2HAPBC', '181027HZ5T8YR494', '181031HD3RAWWKKP', '无敌', '2018-10-31 23:05:45');
INSERT INTO `comments` VALUES ('181031HDP9W3AZ7C', '181031HDA371NXAW', '181031HD3RAWWKKP', '123', '2018-10-31 23:06:20');
INSERT INTO `comments` VALUES ('181031HF5KCPWRGC', '181027HT6X1HRN9P', '181031HD3RAWWKKP', '小火锅', '2018-10-31 23:07:45');
INSERT INTO `comments` VALUES ('181031HF6K2WR7HH', '181027HT6X1HRN9P', '181031HD3RAWWKKP', '小火锅看起来很好吃的样子', '2018-10-31 23:07:52');
INSERT INTO `comments` VALUES ('1811038DG35KZ2FW', '181027HZBW4RFDWH', '181027HKFNAXK494', '鸡蛋', '2018-11-03 11:53:13');
INSERT INTO `comments` VALUES ('1811038DS273TSCH', '181027HZ5T8YR494', '181027HKFNAXK494', '煎饺', '2018-11-03 11:53:58');
INSERT INTO `comments` VALUES ('1811038FD4D91ZTC', '181031HDA371NXAW', '181027HKFNAXK494', '测试', '2018-11-03 11:56:00');
INSERT INTO `comments` VALUES ('1811038G0HK526A8', '181027HZ5T8YR494', '181027HKFNAXK494', '123', '2018-11-03 11:57:40');
INSERT INTO `comments` VALUES ('181105G4N3DK6GTC', '181027HWH570177C', '181027HKFNAXK494', 'te', '2018-11-05 21:15:07');
INSERT INTO `comments` VALUES ('181105G4PKDKHKYW', '181027HWH570177C', '181027HKFNAXK494', 'hahaha', '2018-11-05 21:15:16');
INSERT INTO `comments` VALUES ('1811069Y0YM0S32W', '181031HDA371NXAW', '181027HKFNAXK494', 'sss', '2018-11-06 13:54:48');
INSERT INTO `comments` VALUES ('1811069Y2RMB63C0', '181031HDA371NXAW', '181027HKFNAXK494', 'sss', '2018-11-06 13:54:54');
INSERT INTO `comments` VALUES ('181106AX6X0M39AW', '181027HRKS50Y9YW', '181027HKFNAXK494', '222', '2018-11-06 15:16:30');
INSERT INTO `comments` VALUES ('181114G11358KW6W', '181027HZBW4RFDWH', '181027HKFNAXK494', '<script type=\"text/javscript\">alert(\"asd\")</script>', '2018-11-14 21:04:10');
INSERT INTO `comments` VALUES ('181123A0NNDTYM3C', '181123A04SST1F3C', '181027HKFNAXK494', '存储', '2018-11-23 14:02:49');
INSERT INTO `comments` VALUES ('181123GHW6SYN06W', '181123GDC7D78XS8', '181027HKFNAXK494', 'hahaha', '2018-11-23 21:51:41');
INSERT INTO `comments` VALUES ('181126CKKS6Y71WH', '1811239WM4XBBDKP', '181027HKFNAXK494', 'asd', '2018-11-26 17:41:47');
INSERT INTO `comments` VALUES ('1811279PK1R1YX8H', '181123G8ZZ60D494', '181027HKFNAXK494', 'sad', '2018-11-27 13:38:31');
INSERT INTO `comments` VALUES ('181127B6S619M6A8', '181123G8TM69XGC0', '181027HKFNAXK494', 'asd', '2018-11-27 15:45:10');
INSERT INTO `comments` VALUES ('181201H89KZXGNTC', '18113065CRTB1F3C', '181027HKFNAXK494', 'asd', '2018-12-01 22:50:10');

-- ----------------------------
-- Table structure for `search_reports`
-- ----------------------------
DROP TABLE IF EXISTS `search_reports`;
CREATE TABLE `search_reports` (
  `id` varchar(64) NOT NULL DEFAULT '',
  `content` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of search_reports
-- ----------------------------
INSERT INTO `search_reports` VALUES ('181027HR1FY07GHH', 'haha');
INSERT INTO `search_reports` VALUES ('181027HZ9FBC3A14', 'haha');
INSERT INTO `search_reports` VALUES ('181027HZHND2C9D4', '蛋');
INSERT INTO `search_reports` VALUES ('181031HF2CDC9S80', '你不用回来啦');
INSERT INTO `search_reports` VALUES ('181031HF3N52Y428', '接我');
INSERT INTO `search_reports` VALUES ('181105FXW1KFWNHH', '接我');
INSERT INTO `search_reports` VALUES ('181105FXX38SYBXP', '你不用回来啦');
INSERT INTO `search_reports` VALUES ('181105FXY03ZX5KP', '蛋');
INSERT INTO `search_reports` VALUES ('1811068N0XSRC4H0', '接我');
INSERT INTO `search_reports` VALUES ('1811068N2C5KCP6W', '舞蹈');
INSERT INTO `search_reports` VALUES ('181114FD4F3DS04H', '舞蹈');
INSERT INTO `search_reports` VALUES ('181114FD56RGX1P0', '泡面');
INSERT INTO `search_reports` VALUES ('1811187SYBP0XPZC', '泡面');
INSERT INTO `search_reports` VALUES ('1811187TW3Z33M5P', '美食');
INSERT INTO `search_reports` VALUES ('181123G8M5WTYBHH', '美食');
INSERT INTO `search_reports` VALUES ('181123G8MXYP7F80', '训练');
INSERT INTO `search_reports` VALUES ('181123G8NRT9BZ9P', '训练');
INSERT INTO `search_reports` VALUES ('181123G934M6MN2W', '美食');
INSERT INTO `search_reports` VALUES ('181123GB7MGHD5KP', '美食');
INSERT INTO `search_reports` VALUES ('181123GC4WD10HM8', '美食');
INSERT INTO `search_reports` VALUES ('181123GCX8N71GC0', '美食');
INSERT INTO `search_reports` VALUES ('181123GD13PZDW6W', 'asd');
INSERT INTO `search_reports` VALUES ('181123GDDKT12A80', 'test');
INSERT INTO `search_reports` VALUES ('181123GF1AA8XAFW', 'test');
INSERT INTO `search_reports` VALUES ('181123GGDX596MCH', 'asd');
INSERT INTO `search_reports` VALUES ('181123GH1DA0MY80', 'test');
INSERT INTO `search_reports` VALUES ('181123GHX720SMRP', 'test');
INSERT INTO `search_reports` VALUES ('181123GHXWCTB354', '泡面');
INSERT INTO `search_reports` VALUES ('181123GHYG9GN2FW', '训练');
INSERT INTO `search_reports` VALUES ('181123GHZ4C5MS14', '美食');
INSERT INTO `search_reports` VALUES ('181123GKNFP8SW00', 'test');
INSERT INTO `search_reports` VALUES ('181123GKNZHWMGTC', 'asd');
INSERT INTO `search_reports` VALUES ('181126CH6D50NT2W', 'aa');
INSERT INTO `search_reports` VALUES ('181126CH964PTCZC', '美食');
INSERT INTO `search_reports` VALUES ('1811279K58HM9DS8', '美食');
INSERT INTO `search_reports` VALUES ('1811279PNKHWKCDP', '美食');
INSERT INTO `search_reports` VALUES ('1811279S57606C6W', '美食');
INSERT INTO `search_reports` VALUES ('181127B6ZY211H28', '美食');
INSERT INTO `search_reports` VALUES ('181201H8AK7H0940', '美食');

-- ----------------------------
-- Table structure for `users`
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` varchar(64) NOT NULL DEFAULT '',
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(64) DEFAULT NULL,
  `face_image` varchar(255) DEFAULT NULL,
  `nickname` varchar(20) DEFAULT NULL,
  `fans_counts` int(11) DEFAULT NULL,
  `follow_counts` int(11) DEFAULT NULL,
  `receive_like_counts` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('181027HKFNAXK494', 'test', '4QrcOUm6Wau+VuBX8g+IPg==', '/181027HKFNAXK494/face/wx44630c92b1ed1bf0.o6zAJs5YZVxhvgLOJLiAQ9XKeQ-A.PUBiDUkfJbHXac71c0759a2c8ecd366bebef2a769c5e.png', 'test', '3', '6', '34');
INSERT INTO `users` VALUES ('181027HRA75GCY3C', '1234', '4QrcOUm6Wau+VuBX8g+IPg==', null, '1234', '0', '1', '0');
INSERT INTO `users` VALUES ('181027HS0A2W34SW', 'test2', '4QrcOUm6Wau+VuBX8g+IPg==', '/181027HS0A2W34SW/face/wx44630c92b1ed1bf0.o6zAJs5YZVxhvgLOJLiAQ9XKeQ-A.p67zIdw2PNBm5fcc1ec08f7ade9dd895003f2d3eead9.jpg', 'test2', '2', '1', '1');
INSERT INTO `users` VALUES ('181031HD3RAWWKKP', 'test3', '4QrcOUm6Wau+VuBX8g+IPg==', '/181031HD3RAWWKKP/face/wx44630c92b1ed1bf0.o6zAJs5YZVxhvgLOJLiAQ9XKeQ-A.Bc6BWxp5jzeW4411156c4ca31538933426ab64ade903.jpg', 'test3', '1', '0', '2');
INSERT INTO `users` VALUES ('181123FGHRGD4TF8', 'test22', '4QrcOUm6Wau+VuBX8g+IPg==', '/181123FGHRGD4TF8/face/wx44630c92b1ed1bf0.o6zAJs5YZVxhvgLOJLiAQ9XKeQ-A.ansMhMdeDy5y5fcc1ec08f7ade9dd895003f2d3eead9.jpg', 'test22', '3', '1', '4');
INSERT INTO `users` VALUES ('181126CF1FG3M5P0', 'ttt', '4QrcOUm6Wau+VuBX8g+IPg==', null, 'ttt', '0', '0', '0');
INSERT INTO `users` VALUES ('181129AC5C8KMCX4', 'tt17', '4QrcOUm6Wau+VuBX8g+IPg==', null, 'tt17', '0', '0', '0');
INSERT INTO `users` VALUES ('181129DK382N5D40', 't3', '4QrcOUm6Wau+VuBX8g+IPg==', '/181129DK382N5D40/face/wx44630c92b1ed1bf0.o6zAJs5YZVxhvgLOJLiAQ9XKeQ-A.d7nQacHqBAPj7ef2498726e6babb42fe4a704302fda0.jpeg', 't3', '0', '0', '0');
INSERT INTO `users` VALUES ('18113061MX8NKF3C', 'spring', '4QrcOUm6Wau+VuBX8g+IPg==', '/18113061MX8NKF3C/face/wx44630c92b1ed1bf0.o6zAJs5YZVxhvgLOJLiAQ9XKeQ-A.Fd5Ya8AvNGpz82d5365a0d74d51947f9a10af0447ee2.png', 'spring', '0', '0', '1');

-- ----------------------------
-- Table structure for `users_like_videos`
-- ----------------------------
DROP TABLE IF EXISTS `users_like_videos`;
CREATE TABLE `users_like_videos` (
  `id` varchar(64) NOT NULL DEFAULT '',
  `user_id` varchar(64) DEFAULT NULL,
  `video_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users_like_videos
-- ----------------------------
INSERT INTO `users_like_videos` VALUES ('181027HPZ72BFNR4', '181027HKFNAXK494', '181027HPYD7N0MK4');
INSERT INTO `users_like_videos` VALUES ('181027HRC4AZ76RP', '181027HRA75GCY3C', '181027HPYD7N0MK4');
INSERT INTO `users_like_videos` VALUES ('181027HTA3HX07F8', '181027HS0A2W34SW', '181027HRKS50Y9YW');
INSERT INTO `users_like_videos` VALUES ('181027HTZ380HZC0', '181027HKFNAXK494', '181027HTT3GG558H');
INSERT INTO `users_like_videos` VALUES ('181027HZN5PMH5WH', '181027HKFNAXK494', '181027HZBW4RFDWH');
INSERT INTO `users_like_videos` VALUES ('181030HGSF0F0YRP', '181027HKFNAXK494', '181027HZ5T8YR494');
INSERT INTO `users_like_videos` VALUES ('18103186K6KYHXD4', '181027HKFNAXK494', '181027HT6X1HRN9P');
INSERT INTO `users_like_videos` VALUES ('181031HDDMSD59WH', '181031HD3RAWWKKP', '181031HDA371NXAW');
INSERT INTO `users_like_videos` VALUES ('1811038FFXWK2HSW', '181027HKFNAXK494', '181031HDA371NXAW');
INSERT INTO `users_like_videos` VALUES ('1811038GA42Y6F5P', '181027HKFNAXK494', '181027HY408D0HM8');
INSERT INTO `users_like_videos` VALUES ('181105G4RWPFMN2W', '181027HKFNAXK494', '181027HWH570177C');
INSERT INTO `users_like_videos` VALUES ('181106AX6037PYRP', '181027HKFNAXK494', '181027HRKS50Y9YW');
INSERT INTO `users_like_videos` VALUES ('181114G3DANA0RGC', '181027HKFNAXK494', '181027HX54GBB0H0');
INSERT INTO `users_like_videos` VALUES ('1811187TNN022B7C', '181027HKFNAXK494', '1811187TKY162614');
INSERT INTO `users_like_videos` VALUES ('18112381F8SKGANC', '181027HKFNAXK494', '181122AWP2GKWR68');
INSERT INTO `users_like_videos` VALUES ('181123A0PKSHA9YW', '181027HKFNAXK494', '181123A04SST1F3C');
INSERT INTO `users_like_videos` VALUES ('181123BCDBZNFMCH', '181027HKFNAXK494', '181123BCC62YAK40');
INSERT INTO `users_like_videos` VALUES ('181123BSBP7BC3XP', '181027HKFNAXK494', '181123BFR91ZTC00');
INSERT INTO `users_like_videos` VALUES ('181123FFTHZ66140', '181027HKFNAXK494', '1811239XSSYB68M8');
INSERT INTO `users_like_videos` VALUES ('181123FGDWZHCKYW', '181027HKFNAXK494', '181123BFTFGMPKYW');
INSERT INTO `users_like_videos` VALUES ('181123FHMT208DP0', '181123FGHRGD4TF8', '181123FHM5XXAAY8');
INSERT INTO `users_like_videos` VALUES ('181123FHRC5WWYRP', '181123FGHRGD4TF8', '181123BBYM5NG8PH');
INSERT INTO `users_like_videos` VALUES ('181123FKG01W33F8', '181027HKFNAXK494', '1811239WM4XBBDKP');
INSERT INTO `users_like_videos` VALUES ('181123FNDTGA2KS8', '181027HKFNAXK494', '181123BBYM5NG8PH');
INSERT INTO `users_like_videos` VALUES ('181123FW63C20P6W', '181027HKFNAXK494', '181123BBYM5NG8PH');
INSERT INTO `users_like_videos` VALUES ('181123FW9HNKMHSW', '181027HKFNAXK494', '181123FW8747N91P');
INSERT INTO `users_like_videos` VALUES ('181123FXFG1A6CX4', '181027HKFNAXK494', '1811239XC3CBCY3C');
INSERT INTO `users_like_videos` VALUES ('181123FXGTCMWBR4', '181027HKFNAXK494', '1811239X8AHCW37C');
INSERT INTO `users_like_videos` VALUES ('181123FY2C2KZ3TC', '181027HKFNAXK494', '181123FY1SNYS6A8');
INSERT INTO `users_like_videos` VALUES ('181123GH00T8YPBC', '181027HKFNAXK494', '181123GDC7D78XS8');
INSERT INTO `users_like_videos` VALUES ('181126CSRRMW8H94', '181027HKFNAXK494', '181123FHM5XXAAY8');
INSERT INTO `users_like_videos` VALUES ('181127B6R91X7RS8', '181027HKFNAXK494', '181123G8TM69XGC0');
INSERT INTO `users_like_videos` VALUES ('181129AC3AYD70X4', '181027HKFNAXK494', '181123G8ZZ60D494');
INSERT INTO `users_like_videos` VALUES ('181129AC6TZCM2RP', '181129AC5C8KMCX4', '181123GDC7D78XS8');
INSERT INTO `users_like_videos` VALUES ('181129AC77TKFDWH', '181129AC5C8KMCX4', '181123G1MW6W3PDP');
INSERT INTO `users_like_videos` VALUES ('181129AC7TKT9MNC', '181129AC5C8KMCX4', '181123FY1SNYS6A8');
INSERT INTO `users_like_videos` VALUES ('181129AC8A4YG540', '181129AC5C8KMCX4', '181123FHM5XXAAY8');
INSERT INTO `users_like_videos` VALUES ('181129DHF0AW0Y3C', '181027HKFNAXK494', '181129DH9ZNNB8BC');
INSERT INTO `users_like_videos` VALUES ('181129FWPWA8N0X4', '181027HKFNAXK494', '181129FWNRZ4D9GC');
INSERT INTO `users_like_videos` VALUES ('181129FWR719F8M8', '181027HKFNAXK494', '181129FT8NH861S8');
INSERT INTO `users_like_videos` VALUES ('181201H89598X400', '181027HKFNAXK494', '18113065CRTB1F3C');

-- ----------------------------
-- Table structure for `users_report`
-- ----------------------------
DROP TABLE IF EXISTS `users_report`;
CREATE TABLE `users_report` (
  `id` varchar(64) NOT NULL DEFAULT '',
  `deal_user_id` varchar(64) DEFAULT NULL,
  `deal_video_id` varchar(64) DEFAULT NULL,
  `title` varchar(128) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `userid` varchar(64) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users_report
-- ----------------------------

-- ----------------------------
-- Table structure for `user_fans`
-- ----------------------------
DROP TABLE IF EXISTS `user_fans`;
CREATE TABLE `user_fans` (
  `id` varchar(64) NOT NULL DEFAULT '',
  `user_id` varchar(64) DEFAULT NULL,
  `fan_id` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_fans
-- ----------------------------
INSERT INTO `user_fans` VALUES ('181027177348469063680', '181027HKFNAXK494', '181027HRA75GCY3C');
INSERT INTO `user_fans` VALUES ('181027178086916128768', '181027HKFNAXK494', '181027HS0A2W34SW');
INSERT INTO `user_fans` VALUES ('18103187119634628608', '181027HS0A2W34SW', '181027HKFNAXK494');
INSERT INTO `user_fans` VALUES ('181105160506922926080', '181031HD3RAWWKKP', '181027HKFNAXK494');
INSERT INTO `user_fans` VALUES ('181123154458738655232', '181027HKFNAXK494', '181123FGHRGD4TF8');
INSERT INTO `user_fans` VALUES ('181127103521236025344', '181123FGHRGD4TF8', '181027HKFNAXK494');
INSERT INTO `user_fans` VALUES ('181127119127414931456', '181123FGHRGD4TF8', '181027HKFNAXK494');

-- ----------------------------
-- Table structure for `videos`
-- ----------------------------
DROP TABLE IF EXISTS `videos`;
CREATE TABLE `videos` (
  `id` varchar(64) NOT NULL DEFAULT '',
  `user_id` varchar(64) DEFAULT NULL,
  `audio_id` varchar(64) DEFAULT NULL,
  `video_filter` varchar(128) DEFAULT NULL,
  `video_category` varchar(128) DEFAULT NULL,
  `video_desc` varchar(128) DEFAULT NULL,
  `video_path` varchar(255) DEFAULT NULL,
  `video_seconds` float(6,2) DEFAULT NULL,
  `video_width` int(6) DEFAULT NULL,
  `video_height` int(6) DEFAULT NULL,
  `cover_path` varchar(255) DEFAULT NULL,
  `like_counts` bigint(20) unsigned DEFAULT NULL,
  `status` int(1) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of videos
-- ----------------------------
INSERT INTO `videos` VALUES ('18113065BHPSWGMW', '18113061MX8NKF3C', '', 'define', 'define', '', '/18113061MX8NKF3C/video/wx44630c92b1ed1bf0.o6zAJs5YZVxhvgLOJLiAQ9XKeQ-A.ffmIisbBOCPh2bd1bc4ff0d727ed2a6e758e35f31a93.mp4', '14.12', '960', '544', '/18113061MX8NKF3C/video/wx44630c92b1ed1bf0bf5e1ba0-b40b-48c2-b8c3-cc874ea1400a.jpg', '0', '1', '2018-11-30 08:40:41');
INSERT INTO `videos` VALUES ('18113065CRTB1F3C', '18113061MX8NKF3C', '', 'define', 'define', '', '/18113061MX8NKF3C/video/wx44630c92b1ed1bf0.o6zAJs5YZVxhvgLOJLiAQ9XKeQ-A.Z3uY4QsbE7Cd219f2991acef7e1596c29139f87afd02.mp4', '11.97', '960', '544', '/18113061MX8NKF3C/video/wx44630c92b1ed1bf0c1eb4b21-0b18-4370-a9b6-5fa8010a577a.jpg', '1', '1', '2018-11-30 08:40:48');
INSERT INTO `videos` VALUES ('181201H8H5ZRRP94', '181027HKFNAXK494', '54', 'light', 'define', '', '/181027HKFNAXK494/video/57fb0cb8-1de6-4d0c-841d-18bf4400a879.mp4', '24.80', '544', '960', '/181027HKFNAXK494/video/wx44630c92b1ed1bf0cdc9466f-fff3-42a9-abcb-b733e321070a.jpg', '0', '1', '2018-12-01 22:50:53');
INSERT INTO `videos` VALUES ('181202DR71CR46FW', '181027HKFNAXK494', '', 'define', 'food', '', '/181027HKFNAXK494/video/wx44630c92b1ed1bf0.o6zAJs5YZVxhvgLOJLiAQ9XKeQ-A.7CEzZGJCFsvu71cd368ba9270f5b3963531ce3147f3e.mp4', '14.61', '576', '1024', '/181027HKFNAXK494/video/wx44630c92b1ed1bf0beeb30b5-dc61-417b-a7df-77c4db485b69.jpg', '0', '1', '2018-12-02 19:16:43');
INSERT INTO `videos` VALUES ('181202DYXD4597HH', '181027HKFNAXK494', '228', 'define', 'food', '', '/181027HKFNAXK494/video/1b47b574-d192-4cae-9e8e-7234b3689310.mp4', '15.05', '576', '1024', '/181027HKFNAXK494/video/wx44630c92b1ed1bf09d005d0a-e675-4538-8d22-7b0fb57bccba.jpg', '0', '1', '2018-12-02 19:33:42');
INSERT INTO `videos` VALUES ('181202DZA793X5KP', '181027HKFNAXK494', '227', 'light', 'food', '', '/181027HKFNAXK494/video/e05c8164-1e56-4f91-8c93-a3807c73956c.mp4', '15.05', '576', '1024', '/181027HKFNAXK494/video/wx44630c92b1ed1bf0fe8a0dea-e727-4d6c-a5c3-e019295ad83a.jpg', '0', '1', '2018-12-02 19:35:05');
INSERT INTO `videos` VALUES ('181202DZY7SC6894', '181027HKFNAXK494', '227', 'black', 'food', '不胖', '/181027HKFNAXK494/video/8f0d8a4d-e68f-41f2-b8c4-f04b5ecd23af.mp4', '15.05', '576', '1024', '/181027HKFNAXK494/video/wx44630c92b1ed1bf05cde8a30-3a47-4446-b3dd-dabef6d3cf82.jpg', '0', '1', '2018-12-02 19:36:48');
