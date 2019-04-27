/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : scetc-show-video-dev

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2019-03-17 11:00:04
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
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adminusers
-- ----------------------------
INSERT INTO `adminusers` VALUES ('1', 'admin', 'xyf', '34F673DE50D97DD69F401B07EDD23739', '?????????', '?????????@qq.com', '?????????', '111111', '?????????', '39.91488908', '116.40387397116', '2018-11-27 10:30:34', '2018-11-28 10:30:37', '10.127.11.22', 'Mozilla/5.0 (Windows N', '282904150014060920', '0');
INSERT INTO `adminusers` VALUES ('2', 'username', 'lhj', '34F673DE50D97DD69F401B07EDD23739', '?????????', '?????????@qq.com', '?????????                  ', '?????????', '445729490', null, null, '2018-12-03 17:48:21', '2018-12-03 17:48:25', '10.127.11.22', 'Mozilla/5.0 (Windows N', '282904150014060920', '0');
INSERT INTO `adminusers` VALUES ('3', 'dh34', 'dh', 'da4799f536c020929a55f2631039118f', '?????????', '?????????@qq.com', '?????????', '111111', '?????????', null, null, '2018-12-07 11:26:57', '2018-12-07 11:27:01', '10.127.11.22', null, null, '0');

-- ----------------------------
-- Table structure for `admin_to_role`
-- ----------------------------
DROP TABLE IF EXISTS `admin_to_role`;
CREATE TABLE `admin_to_role` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `adminId` bigint(22) DEFAULT NULL,
  `roleId` bigint(22) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_to_role
-- ----------------------------
INSERT INTO `admin_to_role` VALUES ('6', '1', '2');
INSERT INTO `admin_to_role` VALUES ('7', '3', '1');

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
) ENGINE=InnoDB AUTO_INCREMENT=289 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of bgm
-- ----------------------------
INSERT INTO `bgm` VALUES ('255', 'Six60+-+Special.mp3', 'Six60+-+Special.mp3', '\\bgm\\db64f2d1-f5c9-4332-b8e3-8839b25249e6.mp3');
INSERT INTO `bgm` VALUES ('257', 'test3.mp3', 'test3.mp3', '\\bgm\\f03c9830-1fa5-4db7-8993-6e8faadf6b46.mp3');
INSERT INTO `bgm` VALUES ('258', 'TheFatRat - Unity.mp3', 'TheFatRat - Unity.mp3', '\\bgm\\599b0ff2-2fcf-4e27-958d-590f04ec246b.mp3');
INSERT INTO `bgm` VALUES ('260', 'Бамбинтон+-+Зая.mp3', 'Бамбинтон+-+Зая.mp3', '\\bgm\\20cb6501-3335-484f-a6c7-d7af70ad24af.mp3');
INSERT INTO `bgm` VALUES ('261', 'ラムジ - Planet.mp3', 'ラムジ - Planet.mp3', '\\bgm\\19ea1a99-aac9-4034-96e4-248ef1554a29.mp3');
INSERT INTO `bgm` VALUES ('262', '李袁杰_曾惜 - 讲真的.mp3', '李袁杰_曾惜 - 讲真的.mp3', '\\bgm\\c588f795-a367-410f-ba80-b9a3b15eb516.mp3');
INSERT INTO `bgm` VALUES ('263', 'bgm10.mp3', 'bgm10.mp3', '\\bgm\\31d15033-65a1-438f-94cc-e22f65d62c92.mp3');
INSERT INTO `bgm` VALUES ('264', '3Bangz _ 未来星 - 别管我要存在感 (clip) (clip).mp3', '3Bangz _ 未来星 - 别管我要存在感 (clip) (clip).mp3', '\\bgm\\361e93fa-c3b2-4288-bed4-e782a39f0808.mp3');
INSERT INTO `bgm` VALUES ('266', '3Bangz _ 未来星 - 习惯你 (clip) (clip).mp3', '3Bangz _ 未来星 - 习惯你 (clip) (clip).mp3', '\\bgm\\d6f23a2f-3402-4cb8-9f69-41b6b198be2b.mp3');
INSERT INTO `bgm` VALUES ('267', 'amazarashi (アマザラシ) - 古いSF映画 (科幻老电影) (clip).mp3', 'amazarashi (アマザラシ) - 古いSF映画 (科幻老电影) (clip).mp3', '\\bgm\\cfe7fb1a-2dee-4983-ac34-662cca9fd264.mp3');
INSERT INTO `bgm` VALUES ('268', 'Gifty - 戒烟 (clip) (clip).mp3', 'Gifty - 戒烟 (clip) (clip).mp3', '\\bgm\\d0e68f4e-65f5-46fd-834d-dcdf7f42a10b.mp3');
INSERT INTO `bgm` VALUES ('269', 'bbno$ _ Slight - Yoyo Toyko (clip) (clip).mp3', 'bbno$ _ Slight - Yoyo Toyko (clip) (clip).mp3', '\\bgm\\7d325d7c-4f31-441f-8544-f3b29eaf77ed.mp3');
INSERT INTO `bgm` VALUES ('270', 'Mocca - Happy! (clip).mp3', 'Mocca - Happy! (clip).mp3', '\\bgm\\276b02e9-81a6-4cb2-bcba-a691ea50953b.mp3');
INSERT INTO `bgm` VALUES ('271', 'Laoz G - 开车开去L.A. (clip) (clip).mp3', 'Laoz G - 开车开去L.A. (clip) (clip).mp3', '\\bgm\\4231b183-ed52-48da-9869-38bff5e5d5a2.mp3');
INSERT INTO `bgm` VALUES ('272', 'Ti&euml;sto _ Sevenn - Boom (clip).mp3', 'Ti&euml;sto _ Sevenn - Boom (clip).mp3', '\\bgm\\fb6929df-5028-4967-be62-9e254166355a.mp3');
INSERT INTO `bgm` VALUES ('273', 'ƱZ - Trap Sh_t V22 (clip).mp3', 'ƱZ - Trap Sh_t V22 (clip).mp3', '\\bgm\\52936f37-53f6-4cd3-a318-4d53bc7a6577.mp3');
INSERT INTO `bgm` VALUES ('274', '程嘉敏 - 一点点喜欢 (clip) (clip).mp3', '程嘉敏 - 一点点喜欢 (clip) (clip).mp3', '\\bgm\\724ac1ad-93d2-46b4-bc9e-a8214773a90a.mp3');
INSERT INTO `bgm` VALUES ('275', '冯提莫 - 再见前任 (clip) (clip).mp3', '冯提莫 - 再见前任 (clip) (clip).mp3', '\\bgm\\b77557f3-837c-4dc4-8f76-5d81fb1c89f7.mp3');
INSERT INTO `bgm` VALUES ('276', '华晨宇 - Here We Are.mp3', '华晨宇 - Here We Are.mp3', '\\bgm\\b8954351-3b5d-43f4-af92-ef6c89d1db2c.mp3');
INSERT INTO `bgm` VALUES ('277', '劲乐团 - 菠菜进行曲 (clip).mp3', '劲乐团 - 菠菜进行曲 (clip).mp3', '\\bgm\\45f723f6-1bab-4987-8ee5-4864cdfd68df.mp3');
INSERT INTO `bgm` VALUES ('278', '李少白 - 山楂树之恋.mp3', '李少白 - 山楂树之恋.mp3', '\\bgm\\427cb37f-3496-4cfe-b6ad-0819a76971d5.mp3');
INSERT INTO `bgm` VALUES ('279', '罗百吉 - 机车女孩 (clip).mp3', '罗百吉 - 机车女孩 (clip).mp3', '\\bgm\\d450a39d-d49e-4fb0-a98b-0e2562fd2913.mp3');
INSERT INTO `bgm` VALUES ('282', 'backsound.mp3', 'backsound.mp3', '\\bgm\\aa775051-f820-4bcd-b17a-eb7b81e8ae5a.mp3');
INSERT INTO `bgm` VALUES ('283', 'bgm02.mp3', 'bgm02.mp3', '\\bgm\\f5575bef-124b-4546-996b-ec967057e7f6.mp3');
INSERT INTO `bgm` VALUES ('284', 'bgm03.mp3', 'bgm03.mp3', '\\bgm\\a15d7d7b-c4a8-4cc3-a971-084df3bd24ae.mp3');
INSERT INTO `bgm` VALUES ('285', 'bgm06.mp3', 'bgm06.mp3', '\\bgm\\ea05e911-6168-4828-ac75-fef81ac5a38d.mp3');
INSERT INTO `bgm` VALUES ('286', 'test2.mp3', 'test2.mp3', '\\bgm\\b65acc2a-b718-4f2b-85dd-329e67a9b58b.mp3');
INSERT INTO `bgm` VALUES ('287', 'db64f2d1-f5c9-4332-b8e3-8839b25249e6.mp3', 'db64f2d1-f5c9-4332-b8e3-8839b25249e6.mp3', '\\bgm\\e3957199-b1e2-40e7-a2d0-d32cd6f1eee0.mp3');
INSERT INTO `bgm` VALUES ('288', '599b0ff2-2fcf-4e27-958d-590f04ec246b.mp3', '599b0ff2-2fcf-4e27-958d-590f04ec246b.mp3', '\\bgm\\20444ac4-26d5-4a5c-b963-68cbb457eb0f.mp3');

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` bigint(22) NOT NULL AUTO_INCREMENT,
  `name` varchar(22) DEFAULT NULL,
  `label` varchar(22) DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `imageUrl` varchar(100) DEFAULT NULL,
  `createtime` datetime DEFAULT NULL,
  `isDeleted` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('1', '美拍类', 'define', '秀一下自己吧', '/images/dsp.jpg', '2018-12-03 20:31:57', '0');
INSERT INTO `category` VALUES ('2', '美食类', 'food', '秀一下自己吧', '/images/food.jpg', '2018-12-03 20:32:58', '0');
INSERT INTO `category` VALUES ('3', '美装类', 'dress', '秀一下自己吧', '/images/dress.jpg', '2018-12-03 20:33:01', '0');
INSERT INTO `category` VALUES ('4', '更多内容', 'more', '秀一下自己吧', '/images/tm.jpg', '2018-12-04 17:23:31', '0');

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
INSERT INTO `comments` VALUES ('18121266P0B95KP0', '1812047W067DH65P', '181027HKFNAXK494', 'haha', '2018-12-12 08:44:35');
INSERT INTO `comments` VALUES ('1812206WCT24TAA8', '181202DZY7SC6894', 'undefined', 'sss', '2018-12-20 09:37:51');

-- ----------------------------
-- Table structure for `power`
-- ----------------------------
DROP TABLE IF EXISTS `power`;
CREATE TABLE `power` (
  `id` bigint(22) NOT NULL DEFAULT '0',
  `name` varchar(100) DEFAULT NULL,
  `path` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of power
-- ----------------------------
INSERT INTO `power` VALUES ('1', '视频管理权限', '//');
INSERT INTO `power` VALUES ('2', '背景音乐管理权限', '//');
INSERT INTO `power` VALUES ('3', '举报模块管理权限', '//');

-- ----------------------------
-- Table structure for `roles`
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` bigint(22) NOT NULL DEFAULT '0',
  `name` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('1', '超级管理员');
INSERT INTO `roles` VALUES ('2', '普通管理员');

-- ----------------------------
-- Table structure for `role_to_power`
-- ----------------------------
DROP TABLE IF EXISTS `role_to_power`;
CREATE TABLE `role_to_power` (
  `id` bigint(22) NOT NULL DEFAULT '0',
  `roleId` bigint(22) DEFAULT NULL,
  `powerId` bigint(22) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_to_power
-- ----------------------------
INSERT INTO `role_to_power` VALUES ('1', '1', '1');
INSERT INTO `role_to_power` VALUES ('2', '1', '2');

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
INSERT INTO `search_reports` VALUES ('18121965S06D8NXP', '测试');

-- ----------------------------
-- Table structure for `setting`
-- ----------------------------
DROP TABLE IF EXISTS `setting`;
CREATE TABLE `setting` (
  `id` bigint(22) NOT NULL DEFAULT '0',
  `name` varchar(255) DEFAULT NULL,
  `value` varchar(255) DEFAULT NULL,
  `isDeleted` bit(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of setting
-- ----------------------------
INSERT INTO `setting` VALUES ('1', 'email_smtp_host', 'smtp.163.com', '');
INSERT INTO `setting` VALUES ('2', 'email_smtp_username', 'showvideos@163.com', '');
INSERT INTO `setting` VALUES ('3', 'email_smtp_password', 'xuyuanfeng1', '');
INSERT INTO `setting` VALUES ('4', 'email_from', 'showvideos@163.com', '');

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
INSERT INTO `users` VALUES ('181027HKFNAXK494', 'test', '4QrcOUm6Wau+VuBX8g+IPg==', '/181027HKFNAXK494/face/wx44630c92b1ed1bf0.o6zAJs5YZVxhvgLOJLiAQ9XKeQ-A.PUBiDUkfJbHXac71c0759a2c8ecd366bebef2a769c5e.png', 'test', '3', '7', '38');
INSERT INTO `users` VALUES ('181027HRA75GCY3C', '1234', '4QrcOUm6Wau+VuBX8g+IPg==', null, '1234', '0', '1', '0');
INSERT INTO `users` VALUES ('181027HS0A2W34SW', 'test2', '4QrcOUm6Wau+VuBX8g+IPg==', '/181027HS0A2W34SW/face/wx44630c92b1ed1bf0.o6zAJs5YZVxhvgLOJLiAQ9XKeQ-A.p67zIdw2PNBm5fcc1ec08f7ade9dd895003f2d3eead9.jpg', 'test2', '2', '1', '1');
INSERT INTO `users` VALUES ('181031HD3RAWWKKP', 'test3', '4QrcOUm6Wau+VuBX8g+IPg==', '/181031HD3RAWWKKP/face/wx44630c92b1ed1bf0.o6zAJs5YZVxhvgLOJLiAQ9XKeQ-A.Bc6BWxp5jzeW4411156c4ca31538933426ab64ade903.jpg', 'test3', '1', '0', '2');
INSERT INTO `users` VALUES ('181123FGHRGD4TF8', 'test22', '4QrcOUm6Wau+VuBX8g+IPg==', '/181123FGHRGD4TF8/face/wx44630c92b1ed1bf0.o6zAJs5YZVxhvgLOJLiAQ9XKeQ-A.ansMhMdeDy5y5fcc1ec08f7ade9dd895003f2d3eead9.jpg', 'test22', '3', '1', '4');
INSERT INTO `users` VALUES ('181126CF1FG3M5P0', 'ttt', '4QrcOUm6Wau+VuBX8g+IPg==', null, 'ttt', '0', '0', '0');
INSERT INTO `users` VALUES ('181129AC5C8KMCX4', 'tt17', '4QrcOUm6Wau+VuBX8g+IPg==', null, 'tt17', '0', '0', '0');
INSERT INTO `users` VALUES ('181129DK382N5D40', 't3', '4QrcOUm6Wau+VuBX8g+IPg==', '/181129DK382N5D40/face/wx44630c92b1ed1bf0.o6zAJs5YZVxhvgLOJLiAQ9XKeQ-A.d7nQacHqBAPj7ef2498726e6babb42fe4a704302fda0.jpeg', 't3', '0', '0', '0');
INSERT INTO `users` VALUES ('18113061MX8NKF3C', 'spring', '4QrcOUm6Wau+VuBX8g+IPg==', '/18113061MX8NKF3C/face/wx44630c92b1ed1bf0.o6zAJs5YZVxhvgLOJLiAQ9XKeQ-A.Fd5Ya8AvNGpz82d5365a0d74d51947f9a10af0447ee2.png', 'spring', '0', '0', '2');
INSERT INTO `users` VALUES ('1812047T304S8WSW', 'cvcv', '4QrcOUm6Wau+VuBX8g+IPg==', '/1812047T304S8WSW/face/wx44630c92b1ed1bf0.o6zAJs5YZVxhvgLOJLiAQ9XKeQ-A.dOVVDhN58cnKf57e5ecf05a754f39b4e9f0b0ded22a6.jpg', 'cvcv', '1', '0', '2');
INSERT INTO `users` VALUES ('181210BZ57SD4BR4', 'r3', '4QrcOUm6Wau+VuBX8g+IPg==', null, 'r3', '0', '0', '0');

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
INSERT INTO `users_like_videos` VALUES ('1812038D5DR4W754', '181027HKFNAXK494', '181202DZA793X5KP');
INSERT INTO `users_like_videos` VALUES ('181204CCBKN922CH', '181027HKFNAXK494', '181202DYXD4597HH');
INSERT INTO `users_like_videos` VALUES ('181205A50KKB45WH', '181027HKFNAXK494', '18113065BHPSWGMW');
INSERT INTO `users_like_videos` VALUES ('181205AGXTG4W9S8', '181027HKFNAXK494', '1812047W067DH65P');
INSERT INTO `users_like_videos` VALUES ('181210C5WKRBFTMW', '181027HKFNAXK494', '181202DR71CR46FW');
INSERT INTO `users_like_videos` VALUES ('18121265X7ANSCH0', '181027HKFNAXK494', '1812047TAZ7B437C');
INSERT INTO `users_like_videos` VALUES ('181219FWNZXTZ5S8', '181027HKFNAXK494', '1812196AWB4Y6140');
INSERT INTO `users_like_videos` VALUES ('1812207AN4MK66NC', '181027HKFNAXK494', 'undefined');

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
INSERT INTO `users_report` VALUES ('18121079CWYB4CBC', '181027HKFNAXK494', '181202DYXD4597HH', '11', '222', '181027HKFNAXK494', '2018-12-10 10:16:54');
INSERT INTO `users_report` VALUES ('181210BZ8S6Y09S8', '181027HKFNAXK494', '181202DZY7SC6894', 'ttt', '', '181210BZ57SD4BR4', '2018-12-10 16:46:47');
INSERT INTO `users_report` VALUES ('181210BZBRCFY98H', '1812047T304S8WSW', '1812047W067DH65P', 'yyyy', '98989', '181210BZ57SD4BR4', '2018-12-10 16:47:06');
INSERT INTO `users_report` VALUES ('181210BZD58P1CDP', '181027HKFNAXK494', '181202DR71CR46FW', 'uuu', '', '181210BZ57SD4BR4', '2018-12-10 16:47:15');
INSERT INTO `users_report` VALUES ('181210BZG9GMGHX4', '181027HKFNAXK494', '181202DZA793X5KP', 'oooo', 'uuuu', '181210BZ57SD4BR4', '2018-12-10 16:47:29');
INSERT INTO `users_report` VALUES ('181210BZHH22C094', '181027HKFNAXK494', '181202DZA793X5KP', 'yyyy', '', '181210BZ57SD4BR4', '2018-12-10 16:47:37');
INSERT INTO `users_report` VALUES ('181210BZWTKY70H0', '181027HKFNAXK494', '181202DYXD4597HH', 'QQQ', '', '181210BZ57SD4BR4', '2018-12-10 16:48:30');
INSERT INTO `users_report` VALUES ('181210BZZ29K22CH', '181027HKFNAXK494', '181202DYXD4597HH', 'QQ', '', '181210BZ57SD4BR4', '2018-12-10 16:48:45');
INSERT INTO `users_report` VALUES ('181210C3AXNGNY14', '181027HKFNAXK494', '181201H8H5ZRRP94', 'ss', 'aa', '181027HKFNAXK494', '2018-12-10 16:59:01');
INSERT INTO `users_report` VALUES ('181210C3DR4W15YW', '181027HKFNAXK494', '181202DR71CR46FW', 'test', '123', '181027HKFNAXK494', '2018-12-10 16:59:19');
INSERT INTO `users_report` VALUES ('181210C3ZAKTR1AW', '181027HKFNAXK494', '181202DR71CR46FW', 'test', '123', '181027HKFNAXK494', '2018-12-10 17:00:47');
INSERT INTO `users_report` VALUES ('181210C40WRKWMK4', '181027HKFNAXK494', '181202DYXD4597HH', 'xxx', 'aaa', '181027HKFNAXK494', '2018-12-10 17:00:57');
INSERT INTO `users_report` VALUES ('181217727F177SCH', '1812047T304S8WSW', '1812047TAZ7B437C', '举报类型：色情低俗', 'qwe草草草草', '181027HKFNAXK494', '2018-12-17 09:55:18');
INSERT INTO `users_report` VALUES ('18121779R70C6RAW', '18113061MX8NKF3C', '18113065CRTB1F3C', 'undefined', 'asdasd', '181027HKFNAXK494', '2018-12-17 10:17:47');
INSERT INTO `users_report` VALUES ('1812177DX057DHBC', '1812047T304S8WSW', '1812047TAZ7B437C', '色情低俗', '123', '181027HKFNAXK494', '2018-12-17 10:30:12');
INSERT INTO `users_report` VALUES ('1812177FX126SZ7C', '181027HKFNAXK494', '181202DR71CR46FW', '色情低俗', '123123', '181027HKFNAXK494', '2018-12-17 10:33:13');

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
INSERT INTO `user_fans` VALUES ('181205101096060092416', '1812047T304S8WSW', '181027HKFNAXK494');

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
INSERT INTO `videos` VALUES ('18113065BHPSWGMW', '18113061MX8NKF3C', '', 'define', 'define', '', '/18113061MX8NKF3C/video/wx44630c92b1ed1bf0.o6zAJs5YZVxhvgLOJLiAQ9XKeQ-A.ffmIisbBOCPh2bd1bc4ff0d727ed2a6e758e35f31a93.mp4', '14.12', '960', '544', '/18113061MX8NKF3C/video/wx44630c92b1ed1bf0bf5e1ba0-b40b-48c2-b8c3-cc874ea1400a.jpg', '1', '1', '2018-11-30 08:40:41');
INSERT INTO `videos` VALUES ('18113065CRTB1F3C', '18113061MX8NKF3C', '', 'define', 'define', '', '/18113061MX8NKF3C/video/wx44630c92b1ed1bf0.o6zAJs5YZVxhvgLOJLiAQ9XKeQ-A.Z3uY4QsbE7Cd219f2991acef7e1596c29139f87afd02.mp4', '11.97', '960', '544', '/18113061MX8NKF3C/video/wx44630c92b1ed1bf0c1eb4b21-0b18-4370-a9b6-5fa8010a577a.jpg', '1', '1', '2018-11-30 08:40:48');
INSERT INTO `videos` VALUES ('181201H8H5ZRRP94', '181027HKFNAXK494', '54', 'light', 'define', '', '/181027HKFNAXK494/video/57fb0cb8-1de6-4d0c-841d-18bf4400a879.mp4', '24.80', '544', '960', '/181027HKFNAXK494/video/wx44630c92b1ed1bf0cdc9466f-fff3-42a9-abcb-b733e321070a.jpg', '0', '1', '2018-12-01 22:50:53');
INSERT INTO `videos` VALUES ('181202DR71CR46FW', '181027HKFNAXK494', '', 'define', 'food', '', '/181027HKFNAXK494/video/wx44630c92b1ed1bf0.o6zAJs5YZVxhvgLOJLiAQ9XKeQ-A.7CEzZGJCFsvu71cd368ba9270f5b3963531ce3147f3e.mp4', '14.61', '576', '1024', '/181027HKFNAXK494/video/wx44630c92b1ed1bf0beeb30b5-dc61-417b-a7df-77c4db485b69.jpg', '1', '1', '2018-12-02 19:16:43');
INSERT INTO `videos` VALUES ('181202DYXD4597HH', '181027HKFNAXK494', '228', 'define', 'food', '', '/181027HKFNAXK494/video/1b47b574-d192-4cae-9e8e-7234b3689310.mp4', '15.05', '576', '1024', '/181027HKFNAXK494/video/wx44630c92b1ed1bf09d005d0a-e675-4538-8d22-7b0fb57bccba.jpg', '1', '1', '2018-12-02 19:33:42');
INSERT INTO `videos` VALUES ('181202DZA793X5KP', '181027HKFNAXK494', '227', 'light', 'food', '', '/181027HKFNAXK494/video/e05c8164-1e56-4f91-8c93-a3807c73956c.mp4', '15.05', '576', '1024', '/181027HKFNAXK494/video/wx44630c92b1ed1bf0fe8a0dea-e727-4d6c-a5c3-e019295ad83a.jpg', '1', '1', '2018-12-02 19:35:05');
INSERT INTO `videos` VALUES ('181202DZY7SC6894', '181027HKFNAXK494', '227', 'black', 'food', '不胖', '/181027HKFNAXK494/video/8f0d8a4d-e68f-41f2-b8c4-f04b5ecd23af.mp4', '15.05', '576', '1024', '/181027HKFNAXK494/video/wx44630c92b1ed1bf05cde8a30-3a47-4446-b3dd-dabef6d3cf82.jpg', '0', '1', '2018-12-02 19:36:48');
INSERT INTO `videos` VALUES ('18120388AHF6XYW0', '181027HKFNAXK494', '232', 'light', 'define', '', '/181027HKFNAXK494/video/e6a8741d-5fad-444e-afbd-16332249264e.mp4', '19.55', '576', '1024', '/181027HKFNAXK494/video/wx44630c92b1ed1bf0191c9b1b-4988-40d5-8be7-771ffeef4462.jpg', '0', '1', '2018-12-03 11:37:43');
INSERT INTO `videos` VALUES ('1812047TAZ7B437C', '1812047T304S8WSW', '253', 'light', 'define', 'ahaha', '/1812047T304S8WSW/video/24f8ea15-249f-4178-b4b1-cf6f745a3245.mp4', '14.12', '960', '544', '/1812047T304S8WSW/video/wx44630c92b1ed1bf0c7c2b329-47c5-4527-b74f-2cb0af61e4ac.jpg', '1', '1', '2018-12-04 10:58:43');
INSERT INTO `videos` VALUES ('1812047TWGMX4TF8', '1812047T304S8WSW', '256', 'define', 'define', '', '/1812047T304S8WSW/video/a9f83e32-eeb7-4a52-be05-b1bc3c3ed30a.mp4', '19.55', '576', '1024', '/1812047T304S8WSW/video/wx44630c92b1ed1bf0e3f0addc-e162-4881-be92-416b1dfc5461.jpg', '0', '1', '2018-12-04 11:00:11');
INSERT INTO `videos` VALUES ('1812047W067DH65P', '1812047T304S8WSW', '255', 'define', 'food', '', '/1812047T304S8WSW/video/15b04006-6877-447e-8411-c90eaf913833.mp4', '14.61', '576', '1024', '/1812047T304S8WSW/video/wx44630c92b1ed1bf0786824f5-65d5-4cb0-8e46-02d5a709a22b.jpg', '1', '1', '2018-12-04 11:00:34');
