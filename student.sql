/*
 Navicat Premium Data Transfer

 Source Server         : xsyz
 Source Server Type    : MySQL
 Source Server Version : 80018
 Source Host           : localhost:3306
 Source Schema         : student

 Target Server Type    : MySQL
 Target Server Version : 80018
 File Encoding         : 65001

 Date: 12/01/2020 00:12:29
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `cno` int(5) UNSIGNED ZEROFILL NOT NULL,
  `cname` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `class1` int(255) NOT NULL,
  `credit` int(255) NOT NULL,
  `bixiu` int(255) NOT NULL,
  PRIMARY KEY (`cno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (00001, 'c语言', 2018, 5, 1);
INSERT INTO `course` VALUES (00002, '英语', 2017, 5, 0);
INSERT INTO `course` VALUES (00003, '数学', 2017, 4, 0);
INSERT INTO `course` VALUES (00004, '算法', 2017, 4, 1);

-- ----------------------------
-- Table structure for keqi
-- ----------------------------
DROP TABLE IF EXISTS `keqi`;
CREATE TABLE `keqi`  (
  `cno` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `t_name` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `add` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `zhou` int(255) NOT NULL,
  `time` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `bixiu` int(255) NOT NULL,
  `credit` int(255) NOT NULL,
  `class1` int(255) NOT NULL,
  `num` int(11) NULL DEFAULT NULL,
  PRIMARY KEY (`cno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of keqi
-- ----------------------------
INSERT INTO `keqi` VALUES (1, 'c语言', 'Lily', '公教一101', 5, '10：00-12:00', 1, 5, 2018, 50);
INSERT INTO `keqi` VALUES (2, '英语', 'Jack', '公教一102', 4, '8：00-10：00', 0, 5, 2017, 49);
INSERT INTO `keqi` VALUES (3, '数学', 'Bill', '公教二302', 3, '14：00-16：00', 0, 4, 2017, 50);
INSERT INTO `keqi` VALUES (4, '算法', 'Anny', '公教三203', 2, '8：00-10：00', 1, 4, 2017, 50);

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `sno` int(11) NOT NULL,
  `sname` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `psw` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `class1` int(255) NULL DEFAULT NULL,
  `major` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `age` int(3) NULL DEFAULT NULL,
  `sex` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  PRIMARY KEY (`sno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES (1, '小明', '123', 2017, '计科', 21, '男');
INSERT INTO `student` VALUES (2, '小红', '123', 2018, '计科', 21, '女');
INSERT INTO `student` VALUES (3, '1', '1', 2017, '计科', 22, '女');
INSERT INTO `student` VALUES (4, '2', '2', 2018, '计科', 20, '男');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `tno` int(11) NOT NULL,
  `psw` int(255) NOT NULL,
  `tname` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `sex` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `rank` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  `dep` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NOT NULL,
  PRIMARY KEY (`tno`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES (1, 123, 'Lily', '女', '教授', '信工学院');
INSERT INTO `teacher` VALUES (2, 123, 'Anny', '女', '教授', '信工学院');
INSERT INTO `teacher` VALUES (3, 123, 'Jack', '男', '副教授', '外国语学院');
INSERT INTO `teacher` VALUES (4, 123, 'Bill', '男', '讲师', '数统学院');

-- ----------------------------
-- Table structure for xk
-- ----------------------------
DROP TABLE IF EXISTS `xk`;
CREATE TABLE `xk`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cno` int(11) NOT NULL COMMENT '课程号',
  `sno` int(11) NOT NULL COMMENT '学号',
  `sname` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `cname` varchar(255) CHARACTER SET gbk COLLATE gbk_chinese_ci NULL DEFAULT NULL,
  `score` int(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 142 CHARACTER SET = gbk COLLATE = gbk_chinese_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of xk
-- ----------------------------
INSERT INTO `xk` VALUES (142, 2, 3, '1', '英语', NULL);

-- ----------------------------
-- View structure for course1
-- ----------------------------
DROP VIEW IF EXISTS `course1`;
CREATE ALGORITHM = UNDEFINED DEFINER = `root`@`localhost` SQL SECURITY DEFINER VIEW `course1` AS select `course`.`id` AS `id`,`course`.`name` AS `name`,`course`.`class` AS `class`,`course`.`t_name` AS `t_name` from `course`;

-- ----------------------------
-- Procedure structure for aa
-- ----------------------------
DROP PROCEDURE IF EXISTS `aa`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `aa`()
begin
 select * from admin;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for cr
-- ----------------------------
DROP PROCEDURE IF EXISTS `cr`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `cr`(in id1 int,in cno1 int,in sno1 int,in sname1 VARCHAR(255), in cname1 VARCHAR(255),in score1 int )
begin
insert into xk(id,cno,sno,sname,cname,score)
values(id1,cno1,sno1,sname1,cname1,score1);
update xk,student,course
set xk.sname=student.sname,xk.cname=course.cname
where xk.sno=student.sno and xk.cno=course.cno;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for cxkb
-- ----------------------------
DROP PROCEDURE IF EXISTS `cxkb`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `cxkb`()
begin
 select * from course;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for i
-- ----------------------------
DROP PROCEDURE IF EXISTS `i`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `i`( in id1 int)
begin
   select * from admin
	 where id=id1;




end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for o
-- ----------------------------
DROP PROCEDURE IF EXISTS `o`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `o`()
begin
   insert into admin(id,name,psw)
	 VALUES(2,sq,111);
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for oq
-- ----------------------------
DROP PROCEDURE IF EXISTS `oq`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `oq`()
begin
   insert into admin(id,name,psw)
	 VALUES(2,'sq',111);
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for pd
-- ----------------------------
DROP PROCEDURE IF EXISTS `pd`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `pd`()
begin
select student.class1 as c1,keqi.class1 as c2
from student ,keqi ,course ,xk 
where   xk.cno=course.cno and student.class1>keqi.class1 and student.sno=xk.sno;
end
;;
delimiter ;

-- ----------------------------
-- Procedure structure for xk
-- ----------------------------
DROP PROCEDURE IF EXISTS `xk`;
delimiter ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `xk`()
begin
update xk,student,course
set xk.sname=student.sname,xk.cname=course.cname
where xk.sno=student.sno and xk.cno=course.cno;
end
;;
delimiter ;

SET FOREIGN_KEY_CHECKS = 1;
