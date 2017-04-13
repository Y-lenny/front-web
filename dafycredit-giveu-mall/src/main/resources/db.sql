/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : mall

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2017-04-12 00:14:56
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for v_sys_admin
-- ----------------------------
DROP TABLE IF EXISTS `v_sys_admin`;
CREATE TABLE `v_sys_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(150) DEFAULT NULL,
  `password` varchar(150) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  `status` varchar(20) DEFAULT 'ENABLE',
  `create_time` datetime DEFAULT NULL,
  `create_userid` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `v_sys_admin_account` (`account`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_sys_admin
-- ----------------------------
INSERT INTO `v_sys_admin` VALUES ('25', 'admin', '96E79218965EB72C92A549DD5A330112', '1', 'ENABLE', null, '1', null, null);

-- ----------------------------
-- Table structure for v_sys_module
-- ----------------------------
DROP TABLE IF EXISTS `v_sys_module`;
CREATE TABLE `v_sys_module` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) DEFAULT NULL,
  `sort` int(11) DEFAULT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `url` varchar(250) DEFAULT NULL,
  `remark` varchar(300) DEFAULT NULL,
  `status` varchar(20) DEFAULT 'ENABLE',
  `create_time` datetime DEFAULT NULL,
  `create_userid` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_sys_module
-- ----------------------------
INSERT INTO `v_sys_module` VALUES ('1', '角色管理', '1', null, '/admin/sys/listSysRole.shtml', null, 'ENABLE', '2016-09-01 14:01:33', '3', '2016-09-02 22:33:02', '3');
INSERT INTO `v_sys_module` VALUES ('2', '系统用户', '3', null, '/admin/sys/listSysAdmin.shtml', null, 'ENABLE', '2016-09-01 14:01:33', '3', '2016-09-02 22:33:02', '3');
INSERT INTO `v_sys_module` VALUES ('3', '修改密码', '4', null, '/admin/auth/modifyPassword.shtml', null, 'ENABLE', '2016-09-01 14:01:33', '3', '2016-09-02 22:33:02', '3');
INSERT INTO `v_sys_module` VALUES ('4', '模块管理', '2', null, '/admin/sys/listSysModule.shtml', null, 'ENABLE', '2016-09-01 14:01:33', '3', '2016-09-02 22:33:02', '3');
INSERT INTO `v_sys_module` VALUES ('18', '软件升级管理', '5', null, '/admin/version/queryVersionByPage.shtml', null, 'ENABLE', '2016-11-17 11:38:33', null, '2016-11-17 11:38:33', null);
INSERT INTO `v_sys_module` VALUES ('19', '升级策略管理', '6', null, '/admin/version/updateStrategy/queryUpdateStrategyByPage.shtml', null, 'ENABLE', '2016-11-17 11:38:33', null, '2016-11-17 11:38:33', null);
INSERT INTO `v_sys_module` VALUES ('20', '渠道编号管理', '7', null, '/admin/channel/queryChannelByPage.shtml', null, 'ENABLE', '2016-11-17 11:38:33', null, '2016-11-17 11:38:33', null);
INSERT INTO `v_sys_module` VALUES ('21', '云端控制类型管理', '8', null, '/admin/cloudControlType/findTypeByPage.shtml', null, 'ENABLE', '2016-11-17 11:38:33', null, '2016-11-17 11:38:33', null);
INSERT INTO `v_sys_module` VALUES ('22', '云端控制事项管理', '9', null, '/admin/cloudControlItem/findItemByPage.shtml', null, 'ENABLE', '2016-11-17 11:38:33', null, '2016-11-17 11:38:33', null);
INSERT INTO `v_sys_module` VALUES ('23', '云端控制参数管理', '10', null, '/admin/cloudControlParameter/findParameterByPage.shtml', null, 'ENABLE', '2016-11-17 11:38:33', null, '2016-11-17 11:38:33', null);
INSERT INTO `v_sys_module` VALUES ('24', '缓存信息管理', '11', null, '/admin/appCacheInfo/findCacheByPage.shtml', null, 'ENABLE', '2016-11-17 11:38:33', null, '2016-11-17 11:38:33', null);
INSERT INTO `v_sys_module` VALUES ('25', '残留信息管理', '12', null, '/admin/appResidualInfo/findAllByPage.shtml', null, 'ENABLE', '2016-11-17 11:38:33', null, '2016-11-17 11:38:33', null);
INSERT INTO `v_sys_module` VALUES ('26', '广告信息管理', '13', null, '/admin/appAdvertiseInfo/findAdvertiseByAllPage.shtml', null, 'ENABLE', '2016-11-17 11:38:33', null, '2016-11-17 11:38:33', null);
INSERT INTO `v_sys_module` VALUES ('27', '系统白名单信息管理', '14', null, '/admin/appSystemWhiteListInfo/findSystemWhiteListByPage.shtml', null, 'ENABLE', '2016-11-17 11:38:33', null, '2016-11-17 11:38:33', null);
INSERT INTO `v_sys_module` VALUES ('28', '录入特征白名单管理', '15', null, '/admin/appWhiteList/findAllByPage.shtml', null, 'ENABLE', '2016-11-17 11:38:33', null, '2016-11-17 11:38:33', null);
INSERT INTO `v_sys_module` VALUES ('29', '历史记录查询', '16', null, '/admin/appOperatingHistory/toOpseratingHistoryPage.shtml', null, 'ENABLE', '2016-11-17 11:38:33', null, '2016-11-17 11:38:33', null);
INSERT INTO `v_sys_module` VALUES ('30', '高频库生成', '17', null, '/admin/appHFDatabaseLogsInfo/toHighFrequencyInfoManage.shtml', null, 'ENABLE', '2016-11-17 11:38:41', null, '2016-11-17 11:38:41', null);
INSERT INTO `v_sys_module` VALUES ('31', '登录日志', '31', null, '/clean.tclclouds.com/admin/sys/findUserLoginLog.shtml', null, 'ENABLE', '2016-12-03 10:04:20', '1', '2016-12-03 10:04:36', '1');
INSERT INTO `v_sys_module` VALUES ('32', '功能推荐管理', '32', null, '/admin/functionRecommend/queryFunctionRecommendByPage.shtml', null, 'ENABLE', '2016-12-22 02:21:32', '1', '2017-03-13 11:54:52', '1');
INSERT INTO `v_sys_module` VALUES ('33', '升级多语言管理', '16', null, '/admin/version/trans/queryVersionTransByPage.shtml', null, 'ENABLE', '2017-03-13 11:51:58', '1', '2017-03-13 11:54:40', '1');
INSERT INTO `v_sys_module` VALUES ('34', '结果页卡片管理', '20', null, '/admin/resultpage/queryResultPage.shtml?cleanPage=0', null, 'ENABLE', '2017-03-15 12:03:24', '1', '2017-03-15 12:03:24', '1');

-- ----------------------------
-- Table structure for v_sys_role
-- ----------------------------
DROP TABLE IF EXISTS `v_sys_role`;
CREATE TABLE `v_sys_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `status` varchar(20) DEFAULT 'ENABLE',
  `app_id` varchar(20) DEFAULT NULL,
  `remark` varchar(300) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `create_userid` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_sys_role
-- ----------------------------
INSERT INTO `v_sys_role` VALUES ('1', '超级管理员', 'ENABLE', null, null, '2016-11-17 11:39:57', '1', '2017-03-15 12:07:52', '1');
INSERT INTO `v_sys_role` VALUES ('2', 'space', 'ENABLE', null, null, '2016-11-17 11:39:57', '1', '2017-03-15 12:08:46', '1');
INSERT INTO `v_sys_role` VALUES ('6', 'space-developer', 'ENABLE', null, null, '2016-11-18 05:55:04', '1', '2017-03-15 12:07:36', '1');
INSERT INTO `v_sys_role` VALUES ('7', '产品运营管理', 'ENABLE', null, null, '2016-11-21 08:09:59', '1', '2017-03-15 12:08:28', '1');
INSERT INTO `v_sys_role` VALUES ('8', '数据运营管理', 'ENABLE', null, null, '2016-11-21 08:12:10', '1', '2017-04-12 00:12:35', '1');

-- ----------------------------
-- Table structure for v_sys_role_module
-- ----------------------------
DROP TABLE IF EXISTS `v_sys_role_module`;
CREATE TABLE `v_sys_role_module` (
  `role_id` int(11) NOT NULL,
  `module_id` int(11) NOT NULL,
  `status` varchar(20) DEFAULT 'ENABLE',
  `create_time` datetime DEFAULT NULL,
  `create_userid` int(11) DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `update_userid` int(11) DEFAULT NULL,
  PRIMARY KEY (`role_id`,`module_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of v_sys_role_module
-- ----------------------------
INSERT INTO `v_sys_role_module` VALUES ('1', '1', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('1', '2', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('1', '3', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('1', '4', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('1', '18', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('1', '19', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('1', '20', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('1', '21', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('1', '22', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('1', '23', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('1', '24', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('1', '25', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('1', '26', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('1', '27', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('1', '28', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('1', '29', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('1', '30', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('1', '31', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('1', '32', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('1', '33', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('1', '34', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('2', '3', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('2', '18', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('2', '19', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('2', '20', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('2', '21', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('2', '22', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('2', '23', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('2', '24', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('2', '25', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('2', '26', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('2', '27', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('2', '28', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('2', '29', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('2', '30', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('2', '32', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('2', '33', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('2', '34', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('4', '1', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('4', '18', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('4', '24', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('5', '3', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('5', '18', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('5', '19', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('5', '20', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('5', '21', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('5', '22', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('5', '23', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('5', '24', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('5', '25', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('5', '26', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('5', '27', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('5', '28', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('5', '29', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('5', '30', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('6', '3', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('6', '18', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('6', '19', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('6', '20', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('6', '21', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('6', '22', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('6', '23', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('6', '24', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('6', '25', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('6', '26', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('6', '27', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('6', '28', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('6', '29', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('6', '30', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('6', '32', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('6', '33', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('6', '34', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('7', '3', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('7', '18', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('7', '20', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('7', '21', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('7', '22', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('7', '23', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('7', '32', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('7', '33', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('7', '34', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('8', '2', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('8', '3', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('8', '4', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('8', '24', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('8', '25', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('8', '26', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('8', '27', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('8', '28', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('8', '29', 'ENABLE', null, null, null, null);
INSERT INTO `v_sys_role_module` VALUES ('8', '30', 'ENABLE', null, null, null, null);
