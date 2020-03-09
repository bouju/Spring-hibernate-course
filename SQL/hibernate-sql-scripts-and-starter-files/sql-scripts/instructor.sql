CREATE TABLE `hb_student_tracker`.`instructor` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL DEFAULT NULL,
  `last_name` VARCHAR(45) NULL DEFAULT NULL,
  `email` VARCHAR(45) NULL DEFAULT NULL,
  `instructor_detail_id` INT NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_instructor_detail_id_idx` (`instructor_detail_id` ASC) VISIBLE,
  CONSTRAINT `fk_instructor_detail_id`
    FOREIGN KEY (`instructor_detail_id`)
    REFERENCES `hb_student_tracker`.`instructor_detail` (`id`)
    ON DELETE CASCADE
    ON UPDATE CASCADE);
