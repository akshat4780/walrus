DROP SCHEMA IF EXISTS `walrus`;

CREATE SCHEMA `walrus`;
USE `walrus` ;
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uname` varchar(50) NOT NULL,
  `phone_number` bigint(20) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` varchar(50) NOT NULL,
  `screen_name` varchar(50) NOT NULL,
  PRIMARY KEY (`phone_number`),
  UNIQUE KEY `screen_name` (`screen_name`),
  UNIQUE KEY `screen_name_2` (`screen_name`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `post_likes`;
CREATE TABLE `post_likes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `screen_name` varchar(45) NOT NULL,
  `post_id` varchar(45) NOT NULL,
  `likedby` varchar(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unik` (`post_id`,`likedby`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

DROP TABLE IF EXISTS `posts`;
CREATE TABLE `posts` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(140) NOT NULL,
  `screen_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci
;
DROP TABLE IF EXISTS `followers_`;
CREATE TABLE `followers_` (
  `screen_name` varchar(45) NOT NULL,
  `followers` varchar(45) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `followscol_UNIQUE` (`followers`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


