/*
 Navicat Premium Data Transfer

 Source Server         : local
 Source Server Type    : MySQL
 Source Server Version : 80028
 Source Host           : localhost:3306
 Source Schema         : keep

 Target Server Type    : MySQL
 Target Server Version : 80028
 File Encoding         : 65001

 Date: 23/06/2022 17:54:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '123');

-- ----------------------------
-- Table structure for coach
-- ----------------------------
DROP TABLE IF EXISTS `coach`;
CREATE TABLE `coach`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` char(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `name`(`name`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of coach
-- ----------------------------
INSERT INTO `coach` VALUES (4, 'ws', '123', '王五', '男');
INSERT INTO `coach` VALUES (6, 'lx', '123', '李雪', '女');
INSERT INTO `coach` VALUES (7, 'zs', '123', '赵四', '男');

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NOT NULL,
  `user_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_id` int(0) NOT NULL,
  `context` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `date` datetime(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_comment_course`(`course_id`) USING BTREE,
  INDEX `fk_comment_user`(`user_id`) USING BTREE,
  CONSTRAINT `fk_comment_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_comment_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 15 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES (14, 37, 'wswangd', 6, 'zhenhao', '2022-06-10 08:55:45');
INSERT INTO `comment` VALUES (15, 37, 'wswangd', 8, '好好好！', '2022-06-13 21:55:32');

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `coach_id` int(0) NOT NULL,
  `coach` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `classes` int(0) NOT NULL,
  `introduction` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `price` decimal(10, 2) NOT NULL,
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `video` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_course_coach_name`(`coach`) USING BTREE,
  INDEX `price`(`price`) USING BTREE,
  INDEX `name`(`name`) USING BTREE,
  INDEX `classes`(`classes`) USING BTREE,
  INDEX `picture`(`picture`) USING BTREE,
  INDEX `fk_course_coach_id`(`coach_id`) USING BTREE,
  CONSTRAINT `fk_course_coach_id` FOREIGN KEY (`coach_id`) REFERENCES `coach` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 12 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (6, '燃脂操', 4, '王五', 18, '毽子燃脂操，快点跟我跳起来！', 299.00, 'https://wswangd-1305336648.cos.ap-shanghai.myqcloud.com/yd_4.jpg', 'null');
INSERT INTO `course` VALUES (7, '背部塑性', 6, '李雪', 20, 'tabata背部塑性|少女背养成', 299.00, 'https://wswangd-1305336648.cos.ap-shanghai.myqcloud.com/yd_5.jpg', 'null');
INSERT INTO `course` VALUES (8, '健身操', 7, '赵四', 20, '《爱你》适合新手三遍燃脂暴汗', 200.00, 'https://wswangd-1305336648.cos.ap-shanghai.myqcloud.com/yd_6.jpg', 'null');

-- ----------------------------
-- Table structure for my_course
-- ----------------------------
DROP TABLE IF EXISTS `my_course`;
CREATE TABLE `my_course`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `user_id` int(0) NOT NULL,
  `course_id` int(0) NOT NULL,
  `course_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `picture` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `my_classes` int(0) NULL DEFAULT NULL,
  `classes` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_course_classes`(`classes`) USING BTREE,
  INDEX `fk_course_id`(`course_id`) USING BTREE,
  INDEX `fk_course_name`(`course_name`) USING BTREE,
  INDEX `fk_course_picture`(`picture`) USING BTREE,
  INDEX `fk_course_user`(`user_id`) USING BTREE,
  CONSTRAINT `fk_course_classes` FOREIGN KEY (`classes`) REFERENCES `course` (`classes`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_course_id` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_course_name` FOREIGN KEY (`course_name`) REFERENCES `course` (`name`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_course_picture` FOREIGN KEY (`picture`) REFERENCES `course` (`picture`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_course_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of my_course
-- ----------------------------
INSERT INTO `my_course` VALUES (27, 37, 6, '燃脂操', 'https://wswangd-1305336648.cos.ap-shanghai.myqcloud.com/yd_4.jpg', 1, 18);
INSERT INTO `my_course` VALUES (28, 37, 8, '健身操', 'https://wswangd-1305336648.cos.ap-shanghai.myqcloud.com/yd_6.jpg', 1, 20);

-- ----------------------------
-- Table structure for order
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `course_id` int(0) NOT NULL,
  `user_id` int(0) NOT NULL,
  `date` datetime(0) NOT NULL,
  `price` decimal(10, 2) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `fk_course_order_id`(`course_id`) USING BTREE,
  INDEX `fkk_user_order_id`(`user_id`) USING BTREE,
  INDEX `fk_order_course_price`(`price`) USING BTREE,
  CONSTRAINT `fk_order_course` FOREIGN KEY (`course_id`) REFERENCES `course` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_order_course_price` FOREIGN KEY (`price`) REFERENCES `course` (`price`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `fk_order_user` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of order
-- ----------------------------
INSERT INTO `order` VALUES (27, 6, 37, '2022-06-10 08:49:05', 299.00);
INSERT INTO `order` VALUES (28, 8, 37, '2022-06-13 21:48:40', 200.00);

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(16) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `username`(`username`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 48 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (37, 'wswangd', '123');
INSERT INTO `user` VALUES (38, 'w', '1');
INSERT INTO `user` VALUES (39, 'w', '2');
INSERT INTO `user` VALUES (40, 'a', 'e');
INSERT INTO `user` VALUES (41, 'a', 's');
INSERT INTO `user` VALUES (42, 'q', 'q');
INSERT INTO `user` VALUES (43, 'as', 'as');
INSERT INTO `user` VALUES (44, 'ss', 'ss');
INSERT INTO `user` VALUES (45, 'a', 'a');
INSERT INTO `user` VALUES (46, 'ac', 'ac');
INSERT INTO `user` VALUES (47, 'aaa', 'aaa');
INSERT INTO `user` VALUES (48, 'qqqq', 'qqqq');

SET FOREIGN_KEY_CHECKS = 1;
