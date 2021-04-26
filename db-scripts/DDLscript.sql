-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema product_catalog_db
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema product_catalog_db
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `product_catalog_db` DEFAULT CHARACTER SET utf8 ;
USE `product_catalog_db` ;

-- -----------------------------------------------------
-- Table `product_catalog_db`.`product_type`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `product_catalog_db`.`product_type` (
`product_type_id` INT(11) NOT NULL,
`product_type_code` VARCHAR(10) NOT NULL,
`product_type_name` VARCHAR(100) NOT NULL,
`created_date_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`created_by` INT(11) NOT NULL,
`modified_date_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`modified_by` INT(11) NOT NULL,
PRIMARY KEY (`product_type_id`),
UNIQUE INDEX `product_type_id_UNIQUE` (`product_type_id` ASC) ,
UNIQUE INDEX `product_type_code_UNIQUE` (`product_type_code` ASC) ,
UNIQUE INDEX `product_type_name_UNIQUE` (`product_type_name` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `product_catalog_db`.`product`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `product_catalog_db`.`product` (
`product_id` INT(11) NOT NULL AUTO_INCREMENT,
`product_code` VARCHAR(10) NOT NULL,
`product_name` VARCHAR(100) NOT NULL,
`product_price` DOUBLE NOT NULL,
`created_date_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`created_by` INT(11) NOT NULL,
`modified_date_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`modified_by` INT(11) NOT NULL,
`product_type_product_type_id` INT(11) NOT NULL,
PRIMARY KEY (`product_id`),
UNIQUE INDEX `product_name_UNIQUE` (`product_name` ASC) ,
UNIQUE INDEX `product_code_UNIQUE` (`product_code` ASC) ,
UNIQUE INDEX `product_id_UNIQUE` (`product_id` ASC) ,
INDEX `fk_product_product_type_idx` (`product_type_product_type_id` ASC) ,
CONSTRAINT `fk_product_product_type`
FOREIGN KEY (`product_type_product_type_id`)
REFERENCES `product_catalog_db`.`product_type` (`product_type_id`)
ON DELETE NO ACTION
ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


-- -----------------------------------------------------
-- Table `product_catalog_db`.`product_history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `product_catalog_db`.`product_history` (
`product_history_id` INT(11) NOT NULL,
`product_id` INT(11) NOT NULL,
`product_code` VARCHAR(10) NOT NULL,
`product_name` VARCHAR(100) NOT NULL,
`product_price` DOUBLE NOT NULL,
`created_date_time` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`created_by` INT(11) NOT NULL,
`modified_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
`modified_by` INT(11) NOT NULL,
PRIMARY KEY (`product_history_id`),
UNIQUE INDEX `product_history_id_UNIQUE` (`product_history_id` ASC) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;