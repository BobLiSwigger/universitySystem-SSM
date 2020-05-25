-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.4.12-MariaDB - mariadb.org binary distribution
-- 服务器OS:                        Win64
-- HeidiSQL 版本:                  10.2.0.5599
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for universitycourse
DROP DATABASE IF EXISTS `universitycourse`;
CREATE DATABASE IF NOT EXISTS `universitycourse` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `universitycourse`;

-- Dumping structure for table universitycourse.administrator
DROP TABLE IF EXISTS `administrator`;
CREATE TABLE IF NOT EXISTS `administrator` (
  `Admin_ID` char(32) NOT NULL,
  `name` varchar(20) DEFAULT NULL,
  `password` char(32) NOT NULL,
  PRIMARY KEY (`Admin_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table universitycourse.administrator: ~0 rows (大约)
DELETE FROM `administrator`;
/*!40000 ALTER TABLE `administrator` DISABLE KEYS */;
INSERT INTO `administrator` (`Admin_ID`, `name`, `password`) VALUES
	('admin', '管理员阿力', '123456');
/*!40000 ALTER TABLE `administrator` ENABLE KEYS */;

-- Dumping structure for procedure universitycourse.chooseClass
DROP PROCEDURE IF EXISTS `chooseClass`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `chooseClass`(
	IN `classID` INT,
	IN `userID` INT

)
BEGIN
start TRANSACTION;
if (NOT EXISTS (SELECT User_ID from student WHERE User_ID=userID)) then
	ROLLBACK;
	else
	if (EXISTS (SELECT Class_ID FROM take WHERE take.Class_ID=classID AND take.User_ID=userID)) then
		ROLLBACK;
		else
		INSERT INTO take (User_ID, Class_ID, pass) VALUES (userID, classID, 1);
		UPDATE student SET student.credit=student.credit+(SELECT course.credit FROM course WHERE course.Course_ID=(SELECT classes.Course_ID FROM classes WHERE classes.Class_ID=classID)) WHERE User_ID=userID;
		if ((SELECT classes.size FROM classes WHERE classes.Class_ID=classID)>=(SELECT classes.maxSize FROM classes WHERE classes.Class_ID=classID) OR (NOT EXISTS (SELECT class_ID from classes where Class_ID=classID))) then
			ROLLBACK;
		else
		UPDATE classes SET classes.size=classes.size+1 WHERE classes.Class_ID=classID;
		COMMIT;
		END if;
	END if;
END if;
END//
DELIMITER ;

-- Dumping structure for table universitycourse.classes
DROP TABLE IF EXISTS `classes`;
CREATE TABLE IF NOT EXISTS `classes` (
  `Class_ID` int(11) NOT NULL AUTO_INCREMENT,
  `Course_ID` char(8) NOT NULL,
  `year` year(4) DEFAULT NULL,
  `term` tinyint(1) DEFAULT 0,
  `maxSize` smallint(6) NOT NULL DEFAULT 60,
  `size` smallint(6) DEFAULT 0,
  PRIMARY KEY (`Class_ID`),
  KEY `FK_Of` (`Course_ID`),
  CONSTRAINT `FK_Of` FOREIGN KEY (`Course_ID`) REFERENCES `course` (`Course_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- Dumping data for table universitycourse.classes: ~5 rows (大约)
DELETE FROM `classes`;
/*!40000 ALTER TABLE `classes` DISABLE KEYS */;
INSERT INTO `classes` (`Class_ID`, `Course_ID`, `year`, `term`, `maxSize`, `size`) VALUES
	(1, 'CS0001', '2020', 0, 60, 1),
	(2, 'CS1001', '2020', 0, 1, 0),
	(3, 'LW0001', '2020', 0, 60, 1),
	(5, 'CS1002', '2019', 0, 60, 0),
	(9, 'LW5656', '2020', 0, 60, 0);
/*!40000 ALTER TABLE `classes` ENABLE KEYS */;

-- Dumping structure for table universitycourse.course
DROP TABLE IF EXISTS `course`;
CREATE TABLE IF NOT EXISTS `course` (
  `Course_ID` char(8) NOT NULL,
  `Dept_ID` char(4) NOT NULL,
  `name` varchar(20) NOT NULL,
  `description` varchar(1024) DEFAULT NULL,
  `credit` float NOT NULL DEFAULT 0,
  `active` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`Course_ID`),
  KEY `FK_CourseBelong` (`Dept_ID`),
  CONSTRAINT `FK_CourseBelong` FOREIGN KEY (`Dept_ID`) REFERENCES `department` (`Dept_ID`) ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table universitycourse.course: ~5 rows (大约)
DELETE FROM `course`;
/*!40000 ALTER TABLE `course` DISABLE KEYS */;
INSERT INTO `course` (`Course_ID`, `Dept_ID`, `name`, `description`, `credit`, `active`) VALUES
	('CS0001', 'CS', 'C++', '所有计算机专业学生的必修课', 4, 1),
	('CS1001', 'CS', 'JAVA', '魔鬼课程', 2.5, 1),
	('CS1002', 'CS', '线性代数', '', 5, 1),
	('CS2020', 'CS', 'Liner Math', '', 6, 1),
	('LW0001', 'LW', '宪法', '所有法学专业学生必修课', 4, 1),
	('LW5656', 'LW', 'Suuuper Math', '', 6, 1);
/*!40000 ALTER TABLE `course` ENABLE KEYS */;

-- Dumping structure for view universitycourse.currentclasses
DROP VIEW IF EXISTS `currentclasses`;
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `currentclasses` (
	`courseID` CHAR(8) NOT NULL COLLATE 'utf8_general_ci',
	`dept` CHAR(20) NOT NULL COLLATE 'utf8_general_ci',
	`courseName` VARCHAR(20) NOT NULL COLLATE 'utf8_general_ci',
	`credit` FLOAT NOT NULL,
	`classID` INT(11) NOT NULL,
	`year` YEAR NULL,
	`term` TINYINT(1) NULL,
	`maxSize` SMALLINT(6) NOT NULL,
	`size` SMALLINT(6) NULL
) ENGINE=MyISAM;

-- Dumping structure for table universitycourse.department
DROP TABLE IF EXISTS `department`;
CREATE TABLE IF NOT EXISTS `department` (
  `Dept_ID` char(4) NOT NULL,
  `name` char(20) NOT NULL,
  PRIMARY KEY (`Dept_ID`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table universitycourse.department: ~2 rows (大约)
DELETE FROM `department`;
/*!40000 ALTER TABLE `department` DISABLE KEYS */;
INSERT INTO `department` (`Dept_ID`, `name`) VALUES
	('LW', '法学院'),
	('CS', '计算机学院');
/*!40000 ALTER TABLE `department` ENABLE KEYS */;

-- Dumping structure for procedure universitycourse.dropOutClass
DROP PROCEDURE IF EXISTS `dropOutClass`;
DELIMITER //
CREATE DEFINER=`root`@`localhost` PROCEDURE `dropOutClass`(
	IN `classID` BIGINT,
	IN `userID` CHAR(11)


)
BEGIN
start TRANSACTION;
if (NOT EXISTS (SELECT * FROM Take WHERE Take.Class_ID=classID AND Take.User_ID=userID)) then 
	ROLLBACK;
	else
	DELETE FROM Take WHERE Take.Class_ID=classID AND Take.User_ID=userID;
	UPDATE Student SET Student.credit=Student.credit-(SELECT Course.credit FROM Course WHERE Course.Course_ID=(SELECT Classes.Course_ID FROM Classes WHERE Classes.Class_ID=classID)) WHERE User_ID=userID;
	UPDATE Classes SET Classes.size=Classes.size-1 WHERE Classes.Class_ID=classID;
	COMMIT;
END if;
END//
DELIMITER ;

-- Dumping structure for table universitycourse.required
DROP TABLE IF EXISTS `required`;
CREATE TABLE IF NOT EXISTS `required` (
  `Dept_ID` char(4) NOT NULL,
  `Course_ID` char(8) NOT NULL,
  PRIMARY KEY (`Dept_ID`,`Course_ID`),
  KEY `FK_Require2` (`Course_ID`),
  CONSTRAINT `FK_Require` FOREIGN KEY (`Dept_ID`) REFERENCES `department` (`Dept_ID`) ON UPDATE CASCADE,
  CONSTRAINT `FK_Require2` FOREIGN KEY (`Course_ID`) REFERENCES `course` (`Course_ID`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- Dumping data for table universitycourse.required: ~2 rows (大约)
DELETE FROM `required`;
/*!40000 ALTER TABLE `required` DISABLE KEYS */;
INSERT INTO `required` (`Dept_ID`, `Course_ID`) VALUES
	('CS', 'CS0001'),
	('LW', 'LW0001');
/*!40000 ALTER TABLE `required` ENABLE KEYS */;

-- Dumping structure for table universitycourse.student
DROP TABLE IF EXISTS `student`;
CREATE TABLE IF NOT EXISTS `student` (
  `User_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Dept_ID` char(4) NOT NULL,
  `credit` float DEFAULT 0,
  PRIMARY KEY (`User_ID`),
  KEY `FK_StudentBelong` (`Dept_ID`),
  CONSTRAINT `FK_StudentBelong` FOREIGN KEY (`Dept_ID`) REFERENCES `department` (`Dept_ID`) ON UPDATE CASCADE,
  CONSTRAINT `FK_student_users` FOREIGN KEY (`User_ID`) REFERENCES `users` (`User_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=100004 DEFAULT CHARSET=utf8;

-- Dumping data for table universitycourse.student: ~3 rows (大约)
DELETE FROM `student`;
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`User_ID`, `Dept_ID`, `credit`) VALUES
	(100001, 'LW', 0),
	(100002, 'CS', 8),
	(100003, 'CS', 0);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;

-- Dumping structure for view universitycourse.studentview
DROP VIEW IF EXISTS `studentview`;
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `studentview` (
	`id` INT(10) UNSIGNED NOT NULL,
	`name` VARCHAR(20) NOT NULL COLLATE 'utf8_general_ci',
	`password` VARCHAR(20) NOT NULL COLLATE 'utf8_general_ci',
	`email` VARCHAR(32) NULL COLLATE 'utf8_general_ci',
	`sex` TINYINT(1) NULL COMMENT '0-male, 1-female',
	`active` TINYINT(1) NOT NULL,
	`dept` CHAR(20) NOT NULL COLLATE 'utf8_general_ci',
	`credit` FLOAT NULL
) ENGINE=MyISAM;

-- Dumping structure for table universitycourse.take
DROP TABLE IF EXISTS `take`;
CREATE TABLE IF NOT EXISTS `take` (
  `User_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Class_ID` int(11) NOT NULL DEFAULT 0,
  `pass` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`User_ID`,`Class_ID`),
  KEY `FK_take_classes` (`Class_ID`),
  CONSTRAINT `FK_take_classes` FOREIGN KEY (`Class_ID`) REFERENCES `classes` (`Class_ID`),
  CONSTRAINT `FK_take_student` FOREIGN KEY (`User_ID`) REFERENCES `student` (`User_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=100011 DEFAULT CHARSET=utf8;

-- Dumping data for table universitycourse.take: ~2 rows (大约)
DELETE FROM `take`;
/*!40000 ALTER TABLE `take` DISABLE KEYS */;
INSERT INTO `take` (`User_ID`, `Class_ID`, `pass`) VALUES
	(100002, 1, 1),
	(100002, 3, 1);
/*!40000 ALTER TABLE `take` ENABLE KEYS */;

-- Dumping structure for table universitycourse.teach
DROP TABLE IF EXISTS `teach`;
CREATE TABLE IF NOT EXISTS `teach` (
  `User_ID` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `Class_ID` int(11) NOT NULL,
  PRIMARY KEY (`User_ID`,`Class_ID`),
  KEY `FK_teach_classes` (`Class_ID`),
  CONSTRAINT `FK_teach_classes` FOREIGN KEY (`Class_ID`) REFERENCES `classes` (`Class_ID`),
  CONSTRAINT `FK_teach_teacher` FOREIGN KEY (`User_ID`) REFERENCES `teacher` (`User_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=100007 DEFAULT CHARSET=utf8;

-- Dumping data for table universitycourse.teach: ~3 rows (大约)
DELETE FROM `teach`;
/*!40000 ALTER TABLE `teach` DISABLE KEYS */;
INSERT INTO `teach` (`User_ID`, `Class_ID`) VALUES
	(100005, 1),
	(100005, 2),
	(100006, 1),
	(100006, 9);
/*!40000 ALTER TABLE `teach` ENABLE KEYS */;

-- Dumping structure for table universitycourse.teacher
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE IF NOT EXISTS `teacher` (
  `User_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `Dept_ID` char(4) NOT NULL,
  `level` tinyint(4) DEFAULT NULL,
  `salary` smallint(6) DEFAULT NULL,
  PRIMARY KEY (`User_ID`),
  KEY `FK_TeacherBelong` (`Dept_ID`),
  CONSTRAINT `FK_TeacherBelong` FOREIGN KEY (`Dept_ID`) REFERENCES `department` (`Dept_ID`) ON UPDATE CASCADE,
  CONSTRAINT `FK_teacher_users` FOREIGN KEY (`User_ID`) REFERENCES `users` (`User_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=100007 DEFAULT CHARSET=utf8;

-- Dumping data for table universitycourse.teacher: ~2 rows (大约)
DELETE FROM `teacher`;
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` (`User_ID`, `Dept_ID`, `level`, `salary`) VALUES
	(100005, 'CS', 2, 30000),
	(100006, 'CS', 1, 20000);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;

-- Dumping structure for view universitycourse.teacherview
DROP VIEW IF EXISTS `teacherview`;
-- Creating temporary table to overcome VIEW dependency errors
CREATE TABLE `teacherview` (
	`id` INT(10) UNSIGNED NOT NULL,
	`name` VARCHAR(20) NOT NULL COLLATE 'utf8_general_ci',
	`password` VARCHAR(20) NOT NULL COLLATE 'utf8_general_ci',
	`email` VARCHAR(32) NULL COLLATE 'utf8_general_ci',
	`sex` TINYINT(1) NULL COMMENT '0-male, 1-female',
	`active` TINYINT(1) NOT NULL,
	`dept` CHAR(20) NOT NULL COLLATE 'utf8_general_ci',
	`level` TINYINT(4) NULL,
	`salary` SMALLINT(6) NULL
) ENGINE=MyISAM;

-- Dumping structure for table universitycourse.users
DROP TABLE IF EXISTS `users`;
CREATE TABLE IF NOT EXISTS `users` (
  `User_ID` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL DEFAULT '123456',
  `email` varchar(32) DEFAULT NULL,
  `sex` tinyint(1) DEFAULT NULL COMMENT '0-male, 1-female',
  `active` tinyint(1) NOT NULL DEFAULT 1,
  PRIMARY KEY (`User_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=100007 DEFAULT CHARSET=utf8;

-- Dumping data for table universitycourse.users: ~6 rows (大约)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`User_ID`, `name`, `password`, `email`, `sex`, `active`) VALUES
	(100001, '小高', '123456', 'xiaogao@123.com', 0, 1),
	(100002, '小红', '123456', '123455@123.com', 1, 1),
	(100003, '小明', '123456', '123456@123.com', 0, 1),
	(100004, '马老师', '123456', NULL, 1, 1),
	(100005, '白老师', '123456', 'longlong@123com', 0, 1),
	(100006, '王老师', '123456', 'wanglaoshi@123.com', 1, 1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

-- Dumping structure for trigger universitycourse.openClass
DROP TRIGGER IF EXISTS `openClass`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `openClass` AFTER INSERT ON `course` FOR EACH ROW BEGIN
if (NEW.credit > 6) then
	DELETE FROM course WHERE course.Course_ID=NEW.Course_ID;
END if;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dumping structure for trigger universitycourse.PassOrNot
DROP TRIGGER IF EXISTS `PassOrNot`;
SET @OLDTMP_SQL_MODE=@@SQL_MODE, SQL_MODE='STRICT_TRANS_TABLES,ERROR_FOR_DIVISION_BY_ZERO,NO_AUTO_CREATE_USER,NO_ENGINE_SUBSTITUTION';
DELIMITER //
CREATE TRIGGER `PassOrNot` AFTER UPDATE ON `take` FOR EACH ROW BEGIN
update student set student.credit=student.credit-(select course.credit from course where course.Course_ID=(select classes.Course_ID from classes where classes.Class_ID=NEW.Class_ID)) where NEW.pass=0 and OLD.pass<>0 and student.User_ID=NEW.User_ID;
update student set student.credit=student.credit+(select course.credit from course where course.Course_ID=(select classes.Course_ID from classes where classes.Class_ID=NEW.Class_ID)) where NEW.pass<>0 and OLD.pass=0 and student.User_ID=NEW.User_ID;
END//
DELIMITER ;
SET SQL_MODE=@OLDTMP_SQL_MODE;

-- Dumping structure for view universitycourse.currentclasses
DROP VIEW IF EXISTS `currentclasses`;
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `currentclasses`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `currentclasses` AS select course.Course_ID as "courseID",
               department.name as "dept",
               course.name as "courseName",
               course.credit as "credit",
               classes.Class_ID as "classID",
               classes.year as "year",
               classes.term as "term",
               classes.maxSize as "maxSize",
               classes.size as "size" from classes, course, department where classes.Course_ID=course.Course_ID and course.Dept_ID=department.Dept_ID and classes.year=2020 and classes.term=0 WITH CASCADED CHECK OPTION ;

-- Dumping structure for view universitycourse.studentview
DROP VIEW IF EXISTS `studentview`;
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `studentview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `studentview` AS select users.User_ID as id,users.name,users.password,users.email,users.sex,users.active,department.name as dept,student.credit from (student natural join users), department where student.Dept_ID=department.Dept_ID ;

-- Dumping structure for view universitycourse.teacherview
DROP VIEW IF EXISTS `teacherview`;
-- Removing temporary table and create final VIEW structure
DROP TABLE IF EXISTS `teacherview`;
CREATE ALGORITHM=UNDEFINED DEFINER=`root`@`localhost` SQL SECURITY DEFINER VIEW `teacherview` AS SELECT users.User_ID as id,users.name,users.`password`,users.email,users.sex,users.active,department.`name` as dept,teacher.`level`, teacher.salary from (teacher natural join users), department where teacher.Dept_ID=department.Dept_ID ;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
