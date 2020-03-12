CREATE SCHEMA `school` DEFAULT CHARACTER SET utf8mb4 ;

DROP TABLE if exists `school`.`s_homework`;
CREATE TABLE `school`.`s_homework` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(20) NULL,
  `content` TEXT NULL,
  `create_time` TIMESTAMP NOT NULL,
  `update_time` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));


DROP TABLE if exists `school`.`s_student`;
CREATE TABLE school.s_student (
  id BIGINT NOT NULL,
  name VARCHAR(20) NOT NULL,
  create_time TIMESTAMP NOT NULL,
  update_time TIMESTAMP NULL,
  PRIMARY KEY (id));


DROP TABLE if exists `school`.`s_student_homework`;
CREATE TABLE `school`.`s_student_homework` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `student_id` BIGINT NOT NULL,
  `homework_id` BIGINT NOT NULL,
  `homework_title` VARCHAR(45) NOT NULL,
  `homework_content` TEXT NULL,
  `create_time` TIMESTAMP NOT NULL,
  `update_time` TIMESTAMP NULL,
  PRIMARY KEY (`id`));

INSERT INTO `school`.`s_student_homework` (`id`, `student_id`, `homework_id`, `homework_title`, `homework_content`, `create_time`) VALUES ('1', '100', '100', '作业', 'https://www.google.com', '2020-03-03 12:00:00');
INSERT INTO `school`.`s_student_homework` (`student_id`, `homework_id`, `homework_title`, `homework_content`, `create_time`) VALUES ( '101', '101', '作业', 'https://www.google.com', '2020-03-03 12:00:00');
INSERT INTO `school`.`s_student_homework`
 (`student_id`, `homework_id`, `homework_title`, `homework_content`, `create_time`)
 VALUES ( '101', '101', '作业', 'https://www.google.com', now());
 insert INTO school.s_student(id,name,create_time)values('123','Jana',now());
