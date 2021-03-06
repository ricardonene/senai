-- MySQL Script generated by MySQL Workbench
-- 04/27/16 19:40:54
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema dbtarefa
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `dbtarefa` DEFAULT CHARACTER SET latin1 ;
USE `dbtarefa` ;

-- -----------------------------------------------------
-- Table `dbtarefa`.`tarefa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `dbtarefa`.`tarefa` (
  `idtarefa` INT(11) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(2000) NULL DEFAULT NULL,
  `prazo` DATETIME NULL DEFAULT NULL,
  `concluido` TINYINT(4) NULL DEFAULT NULL,
  PRIMARY KEY (`idtarefa`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

