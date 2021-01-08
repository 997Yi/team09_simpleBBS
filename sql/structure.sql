SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin_tb
-- ----------------------------
DROP TABLE IF EXISTS `admin_tb`;
CREATE TABLE `admin_tb` (
                            `admin_id` varchar(36) NOT NULL,
                            `admin_name` varchar(255) NOT NULL,
                            `admin_password` varchar(255) NOT NULL,
                            PRIMARY KEY (`admin_id`,`admin_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin_tb
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for blog_tb
-- ----------------------------
DROP TABLE IF EXISTS `blog_tb`;
CREATE TABLE `blog_tb` (
                           `blog_id` varchar(36) NOT NULL,
                           `blog_title` varchar(255) NOT NULL,
                           `blog_content` varchar(255) NOT NULL,
                           `blog_keywords` varchar(255) NOT NULL,
                           `blog_clicks` int NOT NULL,
                           `blog_time` datetime NOT NULL,
                           `top` int NOT NULL,
                           `quintessence` int NOT NULL,
                           `user_id` varchar(36) NOT NULL,
                           PRIMARY KEY (`blog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of blog_tb
-- ----------------------------
BEGIN;
INSERT INTO `blog_tb` VALUES ('6c0339ce-517a-11eb-be26-00163e10d555', '张三的博客', '这是内容', '关键字', 1, '2021-01-08 00:00:00', 0, 0, 'ee843fee-511a-11eb-be26-00163e10d555');
COMMIT;

-- ----------------------------
-- Table structure for comment_tb
-- ----------------------------
DROP TABLE IF EXISTS `comment_tb`;
CREATE TABLE `comment_tb` (
                              `comment_id` varchar(36) NOT NULL,
                              `comment_content` varchar(255) NOT NULL,
                              `comment_status` varchar(255) NOT NULL,
                              `comment_time` datetime NOT NULL,
                              `user_id` varchar(36) NOT NULL,
                              `blog_id` varchar(36) NOT NULL,
                              PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment_tb
-- ----------------------------
BEGIN;
INSERT INTO `comment_tb` VALUES ('b9d54658-517a-11eb-be26-00163e10d555', 'hello motherfucker', '正常', '2021-01-08 00:00:00', 'ee843fee-511a-11eb-be26-00163e10d555', '6c0339ce-517a-11eb-be26-00163e10d555');
COMMIT;

-- ----------------------------
-- Table structure for user_tb
-- ----------------------------
DROP TABLE IF EXISTS `user_tb`;
CREATE TABLE `user_tb` (
                           `user_id` varchar(36) NOT NULL,
                           `user_name` varchar(255) NOT NULL,
                           `user_password` varchar(255) NOT NULL,
                           `user_img` varchar(255) DEFAULT NULL,
                           `user_profile` varchar(255) DEFAULT NULL,
                           PRIMARY KEY (`user_id`,`user_name`) USING BTREE,
                           KEY `user_id` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_tb
-- ----------------------------
BEGIN;
INSERT INTO `user_tb` VALUES ('ee843fee-511a-11eb-be26-00163e10d555', '张三', '123456', 'imgUrl', '个人简介');
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
