DROP DATABASE IF EXISTS `githubdb`;
CREATE DATABASE `githubdb`;

USE `githubdb`;

DROP TABLE IF EXISTS `pull_request`;
CREATE TABLE `pull_request` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `number` int(11) NOT NULL,
  `pull_request_id` int(11) NOT NULL,
  `state` varchar(50) NOT NULL,
  `title` varchar(1024),
  `body` TEXT ,
  `closed_at` DATETIME ,
  `merged_at` DATETIME ,
  `created_at` DATETIME ,
  `updated_at` DATETIME ,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_pull_request_id` (`pull_request_id`)
);