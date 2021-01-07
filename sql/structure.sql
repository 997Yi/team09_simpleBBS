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
  PRIMARY KEY (`blog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for comment_tb
-- ----------------------------
DROP TABLE IF EXISTS `comment_tb`;
CREATE TABLE `comment_tb` (
  `comment_id` varchar(36) NOT NULL,
  `comment_content` varchar(255) NOT NULL,
  `comment_status` varchar(255) NOT NULL,
  `comment_time` datetime NOT NULL,
  PRIMARY KEY (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_blog_comment_tb
-- ----------------------------
DROP TABLE IF EXISTS `user_blog_comment_tb`;
CREATE TABLE `user_blog_comment_tb` (
  `blog_id` varchar(36) NOT NULL,
  `user_id` varchar(36) NOT NULL,
  `comment_id` varchar(36) NOT NULL,
  KEY `comment_id` (`comment_id`),
  CONSTRAINT `comment_id` FOREIGN KEY (`comment_id`) REFERENCES `comment_tb` (`comment_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Table structure for user_blog_tb
-- ----------------------------
DROP TABLE IF EXISTS `user_blog_tb`;
CREATE TABLE `user_blog_tb` (
  `user_id` varchar(36) NOT NULL,
  `blog_id` varchar(36) NOT NULL,
  KEY `user_id` (`user_id`),
  KEY `blog_id` (`blog_id`),
  CONSTRAINT `blog_id` FOREIGN KEY (`blog_id`) REFERENCES `blog_tb` (`blog_id`),
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user_tb` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

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
  PRIMARY KEY (`user_id`,`user_name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
