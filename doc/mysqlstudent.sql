/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.5.40 : Database - java1707
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`java1707` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `java1707`;

/*Table structure for table `banji` */

DROP TABLE IF EXISTS `banji`;

CREATE TABLE `banji` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `banji` */

insert  into `banji`(`id`,`name`) values (1,'java1705'),(2,'java1707'),(6,'java');

/*Table structure for table `banji_coures` */

DROP TABLE IF EXISTS `banji_coures`;

CREATE TABLE `banji_coures` (
  `banji_id` int(11) NOT NULL DEFAULT '0',
  `coure_id` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`banji_id`,`coure_id`),
  KEY `coure_id` (`coure_id`),
  CONSTRAINT `banji_coures_ibfk_1` FOREIGN KEY (`banji_id`) REFERENCES `banji` (`id`),
  CONSTRAINT `banji_coures_ibfk_2` FOREIGN KEY (`coure_id`) REFERENCES `coures` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `banji_coures` */

insert  into `banji_coures`(`banji_id`,`coure_id`) values (1,1),(2,1),(1,2),(2,2),(2,3);

/*Table structure for table `coures` */

DROP TABLE IF EXISTS `coures`;

CREATE TABLE `coures` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `credit` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

/*Data for the table `coures` */

insert  into `coures`(`id`,`name`,`credit`) values (1,'java',5),(2,'ui',3),(3,'html',2),(4,'uu',5);

/*Table structure for table `student` */

DROP TABLE IF EXISTS `student`;

CREATE TABLE `student` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(10) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `gender` varchar(1) DEFAULT NULL,
  `address` varchar(4) DEFAULT NULL,
  `banji_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `banji_id` (`banji_id`),
  CONSTRAINT `student_ibfk_1` FOREIGN KEY (`banji_id`) REFERENCES `banji` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `student` */

insert  into `student`(`id`,`name`,`age`,`gender`,`address`,`banji_id`) values (1,'zhangsan',18,'男','青岛',1),(2,'lisi',18,'男','济南',2),(3,'libai',18,'男','青岛',2),(4,'wangwu',76,'女','上海',NULL),(5,'yang',22,'济',NULL,NULL),(6,'hh',5,'女',NULL,NULL),(8,'ll',2,'女',NULL,NULL),(9,'jj',54,'男',NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
