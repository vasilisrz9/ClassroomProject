-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema catalogue
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema catalogue
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `catalogue` DEFAULT CHARACTER SET utf8 ;
USE `catalogue` ;

-- -----------------------------------------------------
-- Table `catalogue`.`members`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `catalogue`.`members` (
  `id` INT(100) NOT NULL AUTO_INCREMENT,
  `LName` VARCHAR(20) NOT NULL,
  `FName` VARCHAR(20) NOT NULL,
  `Tel1` VARCHAR(20) NOT NULL,
  `Tel2` VARCHAR(20) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 11
DEFAULT CHARACTER SET = utf8;

INSERT INTO `members` (`id`,`LName`,`FName`,`Tel1`,`Tel2`) VALUES (1,'nikos','alexis','224245','242422'),(2,'stefanos','dimitris','23244','533535'),(3,'cristina','georgiou','533535353','355335'),(4,'georgiou ','nikos','2424224','442224'),(5,'mixalis','alexiou','44222442','2244242'); SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;