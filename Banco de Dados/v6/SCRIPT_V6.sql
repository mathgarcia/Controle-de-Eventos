-- MySQL Script generated by MySQL Workbench
-- 11/02/14 10:56:31
-- Model: New Model    Version: 1.0
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`grau_instituicao`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`grau_instituicao` (
  `codigo` TINYINT(3) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`perfil`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`perfil` (
  `codigo` TINYINT(3) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`endereco` (
  `codigo` SMALLINT(5) NOT NULL AUTO_INCREMENT,
  `cep` VARCHAR(45) NULL,
  `logradouro` VARCHAR(45) NULL,
  `numero` VARCHAR(10) NULL,
  `bairro` VARCHAR(20) NULL,
  `cidade` VARCHAR(30) NULL,
  `estado` VARCHAR(20) NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`participante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`participante` (
  `codigo` SMALLINT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `nomesocial` VARCHAR(45) NULL,
  `senha` VARCHAR(45) NULL,
  `sexo` CHAR(1) NULL,
  `cpf` VARCHAR(45) NULL,
  `data_nascimento` DATE NULL,
  `telefone_residencial` VARCHAR(45) NULL,
  `telefone_celular` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  `cod_grauist` TINYINT(3) NOT NULL,
  `cod_perfil` TINYINT(3) NOT NULL,
  `cod_endereco` SMALLINT(5) NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`istrio`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`istrio` (
  `matricula` VARCHAR(20) NOT NULL,
  `cod_paticipante` SMALLINT NOT NULL,
  PRIMARY KEY (`matricula`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`palestrante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`palestrante` (
  `codigo` TINYINT(3) NOT NULL AUTO_INCREMENT,
  `curiculum` BLOB NULL,
  `lattes` VARCHAR(45) NULL,
  `cod_participante` SMALLINT NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`tipo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`tipo` (
  `codigo` TINYINT(3) NOT NULL AUTO_INCREMENT,
  `descricao` VARCHAR(45) NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`evento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`evento` (
  `codigo` TINYINT(3) NOT NULL,
  `nome` VARCHAR(45) NULL,
  `descricao` VARCHAR(100) NULL,
  `data_inicio` DATE NULL,
  `data_fin` DATE NULL,
  `local` VARCHAR(45) NULL,
  `status` TINYINT(1) NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`atividade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`atividade` (
  `codigo` TINYINT(3) NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(45) NULL,
  `resumo` VARCHAR(100) NULL,
  `data` DATE NULL,
  `hora` TIME NULL,
  `duracao` TINYINT(4) NULL,
  `descricao` VARCHAR(250) NULL,
  `status` TINYINT(1) NOT NULL,
  `cod_tipo` TINYINT(3) NOT NULL,
  `cod_evento` TINYINT(3) NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`atividade_palestrante`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`atividade_palestrante` (
  `codigo` TINYINT(3) NOT NULL AUTO_INCREMENT,
  `cod_atividade` TINYINT(3) NOT NULL,
  `cod_palestrante` TINYINT(3) NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`materia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`materia` (
  `codigo` SMALLINT(5) NOT NULL,
  `material` BLOB NULL,
  `cod_atividade` TINYINT(3) NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`inscricao_evento`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`inscricao_evento` (
  `codigo` INT(11) NOT NULL AUTO_INCREMENT,
  `cod_evento` TINYINT(3) NOT NULL,
  `cod_participante` SMALLINT NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`inscricao_atividade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`inscricao_atividade` (
  `codigo` INT(11) NOT NULL AUTO_INCREMENT,
  `cod_inscricao_evento` INT(11) NOT NULL,
  `cod_atividade` TINYINT(3) NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`salas`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `mydb`.`salas` (
  `codigo` SMALLINT NOT NULL,
  `nome` VARCHAR(45) NULL,
  `capacidade` INT NOT NULL,
  `cod_atividade` TINYINT(3) NOT NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
