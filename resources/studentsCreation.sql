-- MySQL Script generated by MySQL Workbench
-- Sun Dec 17 23:21:52 2017
-- Model: Registrar Model    Version: 1.0
-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Registrar
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `Registrar` ;

-- -----------------------------------------------------
-- Schema Registrar
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Registrar` DEFAULT CHARACTER SET utf8 ;
USE `Registrar` ;

-- -----------------------------------------------------
-- Table `Registrar`.`Students`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Registrar`.`Students` (
  `student_num` INT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `date_birth` DATE NOT NULL,
  `enrolled` DATE NOT NULL,
  PRIMARY KEY (`student_num`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Registrar`.`Courses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Registrar`.`Courses` (
  `course_num` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`course_num`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Registrar`.`Registry`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Registrar`.`Registry` (
  `student_num` INT NOT NULL,
  `course_num` VARCHAR(45) NOT NULL,
  `term` ENUM('W', 'F', 'S') NOT NULL,
  `year` INT NOT NULL,
  INDEX `course_num_idx` (`course_num` ASC),
  PRIMARY KEY (`course_num`, `student_num`),
  CONSTRAINT `student_num_reg`
    FOREIGN KEY (`student_num`)
    REFERENCES `Registrar`.`Students` (`student_num`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `course_num_reg`
    FOREIGN KEY (`course_num`)
    REFERENCES `Registrar`.`Courses` (`course_num`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Registrar`.`ClassRep`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Registrar`.`ClassRep` (
  `student_num` INT NOT NULL,
  `course_num` VARCHAR(45) NOT NULL,
  `term` ENUM('W', 'F', 'S') NOT NULL,
  `year` INT NOT NULL,
  PRIMARY KEY (`student_num`, `course_num`),
  INDEX `course_num_idx` (`course_num` ASC),
  CONSTRAINT `student_num_rep`
    FOREIGN KEY (`student_num`)
    REFERENCES `Registrar`.`Students` (`student_num`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION,
  CONSTRAINT `course_num_rep`
    FOREIGN KEY (`course_num`)
    REFERENCES `Registrar`.`Courses` (`course_num`)
    ON DELETE CASCADE
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Registrar`.`Tuition`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Registrar`.`Tuition` (
  `student_num` INT NOT NULL,
  `paid` DECIMAL(13,4) NOT NULL,
  `remainder` DECIMAL(13,4) NOT NULL,
  PRIMARY KEY (`student_num`),
  CONSTRAINT `student_num`
    FOREIGN KEY (`student_num`)
    REFERENCES `Registrar`.`Students` (`student_num`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
