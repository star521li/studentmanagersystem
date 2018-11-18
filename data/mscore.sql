# Host: localhost  (Version: 5.6.14)
# Date: 2016-12-03 14:46:50
# Generator: MySQL-Front 5.3  (Build 4.13)

/*!40101 SET NAMES utf8 */;

#
# Source for table "admin"
#

DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) DEFAULT NULL COMMENT '账号',
  `upassword` varchar(255) DEFAULT NULL COMMENT '密码',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='管理员信息管理';

#
# Data for table "admin"
#

INSERT INTO `admin` VALUES (1,'admin','admin');

#
# Source for table "course"
#

DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `cname` varchar(255) DEFAULT NULL COMMENT '课程名称',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='课程信息';

#
# Data for table "course"
#

INSERT INTO `course` VALUES (1,'计算机文化基础'),(2,'Java程序设计');

#
# Source for table "score"
#

DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `stuid` int(11) DEFAULT NULL COMMENT '学生id',
  `cid` int(11) DEFAULT NULL COMMENT '课程id',
  `tmid` int(11) DEFAULT NULL COMMENT '学期id',
  `val` float DEFAULT NULL COMMENT '分数',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='成绩信息';

#
# Data for table "score"
#

INSERT INTO `score` VALUES (1,1,1,2,80),(2,2,1,2,70),(3,3,1,2,75),(4,4,1,2,50),(5,5,1,2,61),(6,6,1,2,95),(7,1,2,2,30),(8,2,2,2,65),(9,3,2,2,75),(10,4,2,2,85),(11,5,2,2,95),(12,6,2,2,55);

#
# Source for table "students"
#

DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `sno` varchar(255) DEFAULT NULL COMMENT '学号',
  `sname` varchar(255) DEFAULT NULL COMMENT '姓名',
  `gender` varchar(255) DEFAULT NULL COMMENT '性别',
  `clssname` varchar(255) DEFAULT NULL COMMENT '班级',
  `upassword` varchar(255) DEFAULT '0' COMMENT '密码',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COMMENT='学生';

#
# Data for table "students"
#

INSERT INTO `students` VALUES (1,'100','学生1','男','14软件一班','1'),(2,'101','学生101','女','14软件一班','0'),(3,'102','学生102','女','14软件一班','0'),(4,'200','学生200','男','14软件一班','0'),(5,'201','学生201','男','14软件一班','0'),(6,'202','学生202','女','14软件一班','0');

#
# Source for table "terms"
#

DROP TABLE IF EXISTS `terms`;
CREATE TABLE `terms` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `tmname` varchar(255) DEFAULT NULL COMMENT '学期名称',
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='学期';

#
# Data for table "terms"
#

INSERT INTO `terms` VALUES (1,'2016-2017第一学期'),(2,'2016-2017第二学期');
