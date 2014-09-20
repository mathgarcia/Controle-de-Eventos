CREATE DATABASE  IF NOT EXISTS `controle_de_eventos` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `controle_de_eventos`;
-- MySQL dump 10.13  Distrib 5.6.17, for Win32 (x86)
--
-- Host: 127.0.0.1    Database: controle_de_eventos
-- ------------------------------------------------------
-- Server version	5.6.20

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `atividade`
--

DROP TABLE IF EXISTS `atividade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atividade` (
  `codigo` tinyint(3) unsigned NOT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `local` varchar(25) DEFAULT NULL,
  `resumo` varchar(100) DEFAULT NULL,
  `data` date DEFAULT NULL,
  `hora` time DEFAULT NULL,
  `duracao` tinyint(4) DEFAULT NULL,
  `cod_evento` tinyint(3) unsigned DEFAULT NULL,
  `cod_tipo` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `index_cod_evento` (`cod_evento`),
  KEY `fk_cod_tipo_idx` (`cod_tipo`),
  CONSTRAINT `fk_cod_evento` FOREIGN KEY (`cod_evento`) REFERENCES `evento` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cod_tipo` FOREIGN KEY (`cod_tipo`) REFERENCES `tipo` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atividade`
--

LOCK TABLES `atividade` WRITE;
/*!40000 ALTER TABLE `atividade` DISABLE KEYS */;
INSERT INTO `atividade` VALUES (1,'Geogebra','Multipla','Palestra sobre software de operações cartesianas','2014-10-20','07:00:00',2,1,1),(2,'Inteligencia Artifical','Hibrida 2','Palestra abordando o tema sobre AI e suas aplicações hoje e no futuro','2014-10-21','09:00:00',3,1,1);
/*!40000 ALTER TABLE `atividade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `atividade_palestrantes`
--

DROP TABLE IF EXISTS `atividade_palestrantes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `atividade_palestrantes` (
  `codigo` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `cod_atividade` tinyint(3) unsigned DEFAULT NULL,
  `cod_palestrante` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `responsaveis` (`cod_atividade`,`cod_palestrante`),
  KEY `fk_cod_atividade_ap_idx` (`cod_atividade`),
  KEY `fk_cod_palestrante_ap_idx` (`cod_palestrante`),
  CONSTRAINT `fk_cod_atividade_ap` FOREIGN KEY (`cod_atividade`) REFERENCES `atividade` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cod_palestrante_ap` FOREIGN KEY (`cod_palestrante`) REFERENCES `palestrante` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `atividade_palestrantes`
--

LOCK TABLES `atividade_palestrantes` WRITE;
/*!40000 ALTER TABLE `atividade_palestrantes` DISABLE KEYS */;
/*!40000 ALTER TABLE `atividade_palestrantes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `endereco`
--

DROP TABLE IF EXISTS `endereco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `endereco` (
  `codigo` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `cep` varchar(45) DEFAULT NULL,
  `logradouro` varchar(45) DEFAULT NULL,
  `numero` varchar(10) DEFAULT NULL,
  `bairro` varchar(20) DEFAULT NULL,
  `cidade` varchar(30) DEFAULT NULL,
  `estado` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `endereco`
--

LOCK TABLES `endereco` WRITE;
/*!40000 ALTER TABLE `endereco` DISABLE KEYS */;
/*!40000 ALTER TABLE `endereco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `evento`
--

DROP TABLE IF EXISTS `evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `evento` (
  `codigo` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `descricao` varchar(100) DEFAULT NULL,
  `data_inicio` date DEFAULT NULL,
  `data_fim` date DEFAULT NULL,
  `local` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `evento`
--

LOCK TABLES `evento` WRITE;
/*!40000 ALTER TABLE `evento` DISABLE KEYS */;
INSERT INTO `evento` VALUES (1,'Semana Tecnológica 2014.2','Semana de Apresentações e Palestras Tecnológicas voltada aos alunos e professores','2014-10-20','2014-10-25','FAETERJ-Rio Quintino'),(2,'Jornada Academica','Semana de integração dos alunos novos e de novas disciplinas','2014-09-15','2014-10-29','FAETERJ-Rio Quintino'),(3,'Aula Magna','Apresentações de Palestras com a reunião de grandes nomes da FAETERJ-Rio','2014-03-03','2014-03-07','Botafogo');
/*!40000 ALTER TABLE `evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `grau_instrucao`
--

DROP TABLE IF EXISTS `grau_instrucao`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `grau_instrucao` (
  `codigo` tinyint(3) unsigned NOT NULL,
  `descricao` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `grau_instrucao`
--

LOCK TABLES `grau_instrucao` WRITE;
/*!40000 ALTER TABLE `grau_instrucao` DISABLE KEYS */;
INSERT INTO `grau_instrucao` VALUES (1,'Ensino Fundamental'),(2,'Ensino Médio'),(3,'Ensino Superior');
/*!40000 ALTER TABLE `grau_instrucao` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscricao_atividade`
--

DROP TABLE IF EXISTS `inscricao_atividade`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inscricao_atividade` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `cod_atividade` tinyint(3) unsigned DEFAULT NULL,
  `cod_inscricao_evento` int(11) DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_cod_atividade_idx` (`cod_atividade`),
  KEY `fk_cod_evento_inscricao_idx` (`cod_inscricao_evento`),
  CONSTRAINT `fk_cod_atividade` FOREIGN KEY (`cod_atividade`) REFERENCES `atividade` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cod_evento_inscricao` FOREIGN KEY (`cod_inscricao_evento`) REFERENCES `inscricao_evento` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscricao_atividade`
--

LOCK TABLES `inscricao_atividade` WRITE;
/*!40000 ALTER TABLE `inscricao_atividade` DISABLE KEYS */;
/*!40000 ALTER TABLE `inscricao_atividade` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inscricao_evento`
--

DROP TABLE IF EXISTS `inscricao_evento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `inscricao_evento` (
  `codigo` int(11) NOT NULL,
  `cod_evento` tinyint(3) unsigned DEFAULT NULL,
  `cod_participante` smallint(5) unsigned DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inscricao_evento`
--

LOCK TABLES `inscricao_evento` WRITE;
/*!40000 ALTER TABLE `inscricao_evento` DISABLE KEYS */;
/*!40000 ALTER TABLE `inscricao_evento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `material`
--

DROP TABLE IF EXISTS `material`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `material` (
  `codigo` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `material` blob,
  `cod_atividade` tinyint(3) unsigned DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_cod_atividade_idx` (`cod_atividade`),
  CONSTRAINT `fk_cod_atividade_material` FOREIGN KEY (`cod_atividade`) REFERENCES `atividade` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `material`
--

LOCK TABLES `material` WRITE;
/*!40000 ALTER TABLE `material` DISABLE KEYS */;
/*!40000 ALTER TABLE `material` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `palestrante`
--

DROP TABLE IF EXISTS `palestrante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `palestrante` (
  `codigo` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `curriculum` blob,
  `lattes` varchar(45) DEFAULT NULL,
  `cod_participante` smallint(5) unsigned DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  UNIQUE KEY `cod_palestrante_UNIQUE` (`cod_participante`),
  CONSTRAINT `fk_cod_palestrante` FOREIGN KEY (`cod_participante`) REFERENCES `participante` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `palestrante`
--

LOCK TABLES `palestrante` WRITE;
/*!40000 ALTER TABLE `palestrante` DISABLE KEYS */;
/*!40000 ALTER TABLE `palestrante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `participante`
--

DROP TABLE IF EXISTS `participante`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `participante` (
  `codigo` smallint(5) unsigned NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) DEFAULT NULL,
  `nomesocial` varchar(45) DEFAULT NULL,
  `senha` varchar(20) DEFAULT NULL,
  `sexo` char(1) DEFAULT NULL,
  `cpf` varchar(14) DEFAULT NULL,
  `data_nascimento` date DEFAULT NULL,
  `telefone_residencial` varchar(14) DEFAULT NULL,
  `telefone_celular` varchar(15) DEFAULT NULL,
  `email` varchar(40) DEFAULT NULL,
  `cod_grauist` tinyint(3) unsigned DEFAULT NULL,
  `cod_perfil` tinyint(3) unsigned DEFAULT NULL,
  `cod_endereco` smallint(5) unsigned DEFAULT NULL,
  PRIMARY KEY (`codigo`),
  KEY `fk_cod_perfil_idx` (`cod_perfil`),
  KEY `fk_grau_ist_idx` (`cod_grauist`),
  KEY `fk_cod_endereco_idx` (`cod_endereco`),
  CONSTRAINT `fk_cod_endereco` FOREIGN KEY (`cod_endereco`) REFERENCES `endereco` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cod_perfil` FOREIGN KEY (`cod_perfil`) REFERENCES `perfil` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_grau_ist` FOREIGN KEY (`cod_grauist`) REFERENCES `grau_instrucao` (`codigo`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `participante`
--

LOCK TABLES `participante` WRITE;
/*!40000 ALTER TABLE `participante` DISABLE KEYS */;
/*!40000 ALTER TABLE `participante` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `perfil` (
  `codigo` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo`
--

DROP TABLE IF EXISTS `tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tipo` (
  `codigo` tinyint(3) unsigned NOT NULL AUTO_INCREMENT,
  `descricao` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo`
--

LOCK TABLES `tipo` WRITE;
/*!40000 ALTER TABLE `tipo` DISABLE KEYS */;
INSERT INTO `tipo` VALUES (1,'Palestra');
/*!40000 ALTER TABLE `tipo` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2014-09-20 20:16:21
