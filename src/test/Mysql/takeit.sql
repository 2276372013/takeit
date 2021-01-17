/*
 Navicat Premium Data Transfer

 Source Server         : whl
 Source Server Type    : MySQL
 Source Server Version : 80020
 Source Host           : localhost:3306
 Source Schema         : takeit

 Target Server Type    : MySQL
 Target Server Version : 80020
 File Encoding         : 65001

 Date: 17/01/2021 17:07:01
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for action
-- ----------------------------
DROP TABLE IF EXISTS `action`;
CREATE TABLE `action`  (
  `actionId` int(0) NOT NULL COMMENT '用户行为id',
  `actionName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户行为名称',
  `actionPath` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '访问Path',
  `requestMethod` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '请求方式(get/post/......)',
  PRIMARY KEY (`actionId`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of action
-- ----------------------------
INSERT INTO `action` VALUES (1, '登录系统', NULL, NULL);

-- ----------------------------
-- Table structure for goods
-- ----------------------------
DROP TABLE IF EXISTS `goods`;
CREATE TABLE `goods`  (
  `goodsId` int(0) NOT NULL AUTO_INCREMENT COMMENT '物品Id',
  `goodsName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '物品名称',
  `userId` int(0) NOT NULL COMMENT '属于',
  `goodsPlace` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '放置位置',
  `goodsPublic` int(0) NULL DEFAULT 1 COMMENT '公开权限',
  `goodsCode` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '物品分享代码',
  `saveTimes` datetime(0) NULL DEFAULT NULL COMMENT '存放多久',
  `placeTime` datetime(0) NULL DEFAULT NULL COMMENT '放置时间',
  `takeTime` datetime(0) NULL DEFAULT NULL COMMENT '拿走时间',
  `goodsType` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '标签种类',
  `frequency` int(0) NULL DEFAULT NULL COMMENT '使用频率',
  `goodsPhoto` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '物品照片',
  `goodsDescribe` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '物品描述',
  PRIMARY KEY (`goodsId`) USING BTREE,
  INDEX `userid1`(`userId`) USING BTREE,
  CONSTRAINT `userid1` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goods
-- ----------------------------
INSERT INTO `goods` VALUES (1, '手机', 1, '床头', 1, NULL, '2021-01-05 13:30:16', '2021-01-04 13:30:44', '2021-01-06 13:30:50', '1', 1, NULL, '我的三星手机');

-- ----------------------------
-- Table structure for goodstype
-- ----------------------------
DROP TABLE IF EXISTS `goodstype`;
CREATE TABLE `goodstype`  (
  `typeName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '标签名称',
  `userId` int(0) NOT NULL COMMENT '用户Id',
  INDEX `userid2`(`userId`) USING BTREE,
  CONSTRAINT `userid2` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of goodstype
-- ----------------------------
INSERT INTO `goodstype` VALUES ('电子', 1);

-- ----------------------------
-- Table structure for log
-- ----------------------------
DROP TABLE IF EXISTS `log`;
CREATE TABLE `log`  (
  `logId` int(0) NOT NULL COMMENT '日志id',
  `userId` int(0) NOT NULL COMMENT '用户id',
  `actionTime` datetime(0) NULL DEFAULT NULL COMMENT '行为时间',
  `actionId` int(0) NOT NULL COMMENT '用户行为',
  `actionObject` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '操作对象',
  INDEX `userid4`(`userId`) USING BTREE,
  INDEX `actionid`(`actionId`) USING BTREE,
  CONSTRAINT `actionid` FOREIGN KEY (`actionId`) REFERENCES `action` (`actionId`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `userid4` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of log
-- ----------------------------
INSERT INTO `log` VALUES (1, 1, '2021-01-05 14:32:46', 1, '手机');

-- ----------------------------
-- Table structure for place
-- ----------------------------
DROP TABLE IF EXISTS `place`;
CREATE TABLE `place`  (
  `placeId` int(0) NULL DEFAULT NULL COMMENT '位置Id',
  `placeName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '位置名称',
  `userId` int(0) NOT NULL COMMENT '用户名',
  `placePhoto` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '地点照片',
  INDEX `userid3`(`userId`) USING BTREE,
  CONSTRAINT `userid3` FOREIGN KEY (`userId`) REFERENCES `users` (`userId`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of place
-- ----------------------------
INSERT INTO `place` VALUES (NULL, '主卧', 1, NULL);

-- ----------------------------
-- Table structure for text
-- ----------------------------
DROP TABLE IF EXISTS `text`;
CREATE TABLE `text`  (
  `id` int(0) NOT NULL,
  `parentid` int(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of text
-- ----------------------------
INSERT INTO `text` VALUES (1, 2);
INSERT INTO `text` VALUES (2, 3);
INSERT INTO `text` VALUES (3, 4);
INSERT INTO `text` VALUES (4, NULL);
INSERT INTO `text` VALUES (5, 2);
INSERT INTO `text` VALUES (6, 1);

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users`  (
  `userId` int(0) NOT NULL AUTO_INCREMENT COMMENT '用户Id',
  `userName` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `userPassword` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '密码',
  `userEmail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '用户邮箱',
  `userCall` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '电话',
  `userSex` int(0) NULL DEFAULT NULL COMMENT '性别',
  `userBirth` datetime(0) NULL DEFAULT NULL COMMENT 'birthday',
  `userLevel` int(0) NOT NULL DEFAULT 3 COMMENT '等级 1.supermanager 2.manager 3.publicUser',
  PRIMARY KEY (`userId`) USING BTREE,
  UNIQUE INDEX `userid`(`userId`) USING BTREE,
  UNIQUE INDEX `username`(`userName`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES (1, 'admin', '123', '227@qq.com', '13920722222', 1, '2021-01-05 00:00:00', 3);
INSERT INTO `users` VALUES (14, '7687687686', '42eb61549424579830582f5b0fa2cedd', '21312321@qq', '12311232131', 0, '2021-01-15 05:44:09', 3);
INSERT INTO `users` VALUES (15, '1111111222', '6fe6757d37ee5b534b20c9e7b3e43fd8', '21312321@qq', '12311232131', 0, '2021-01-15 05:45:23', 3);
INSERT INTO `users` VALUES (16, 'adminaa', '08a931dabf64563d2a415c4daaf5e6c3', '21312321@qq', '12312321311', 0, '2021-01-15 05:46:35', 3);
INSERT INTO `users` VALUES (20, 'adminauuu', 'd6aac3b334372f1e0489365075a9a039', '21312321@qq', '12312321311', 0, '2021-01-15 05:52:07', 3);
INSERT INTO `users` VALUES (21, '54657657657', '8d4e8109b6d35ee9c18d33b78c5562a1', '21312321@qq', '12377777777', 0, '2021-01-15 06:17:43', 3);
INSERT INTO `users` VALUES (22, '2474920409', '3e1ad6d18320a6d9da7173c7e71b8c55', '21312321@qq', '11111111111', 0, '2021-01-15 06:24:56', 3);
INSERT INTO `users` VALUES (23, '757857857857', '8dd978e3661ad8780cb76a0e949c22f3', '21312321@qq', '11111111111', 0, '2021-01-15 06:25:42', 3);

SET FOREIGN_KEY_CHECKS = 1;
