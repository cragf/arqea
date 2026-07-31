-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               12.3.2-MariaDB - MariaDB Server
-- Server OS:                    Win64
-- HeidiSQL Version:             12.17.0.7270
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for arqeadb
CREATE DATABASE IF NOT EXISTS `arqeadb` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_uca1400_ai_ci */;
USE `arqeadb`;

-- Dumping structure for table arqeadb.artefactos
CREATE TABLE IF NOT EXISTS `artefactos` (
  `IDartefacto` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  `descripcion` text NOT NULL DEFAULT '0',
  `descubridores` int(11) NOT NULL DEFAULT 0,
  `encamino` tinyint(1) NOT NULL DEFAULT 0,
  `museo` int(11) DEFAULT 0,
  `yacimiento` int(11) NOT NULL DEFAULT 0,
  `clave` uuid NOT NULL,
  `img` varchar(50) DEFAULT NULL,
  `clase` int(11) NOT NULL,
  PRIMARY KEY (`IDartefacto`),
  KEY `descubridores` (`descubridores`),
  KEY `museo` (`museo`),
  KEY `yacimiento` (`yacimiento`),
  KEY `clase` (`clase`),
  CONSTRAINT `FK_artefactos_clases` FOREIGN KEY (`clase`) REFERENCES `clases` (`IDclase`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_artefactos_equipos` FOREIGN KEY (`descubridores`) REFERENCES `equipos` (`IDequipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_artefactos_museos` FOREIGN KEY (`museo`) REFERENCES `museos` (`IDmuseo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_artefactos_yacimientos` FOREIGN KEY (`yacimiento`) REFERENCES `yacimientos` (`IDyacimiento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Dumping data for table arqeadb.artefactos: ~0 rows (approximately)
DELETE FROM `artefactos`;

-- Dumping structure for table arqeadb.clases
CREATE TABLE IF NOT EXISTS `clases` (
  `IDclase` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_clase` varchar(50) NOT NULL DEFAULT '0',
  `descripcion_clase` tinytext NOT NULL DEFAULT '0',
  PRIMARY KEY (`IDclase`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Dumping data for table arqeadb.clases: ~0 rows (approximately)
DELETE FROM `clases`;

-- Dumping structure for table arqeadb.equipos
CREATE TABLE IF NOT EXISTS `equipos` (
  `IDequipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_equipo` varchar(50) NOT NULL DEFAULT '0',
  `lider` int(11) NOT NULL,
  PRIMARY KEY (`IDequipo`),
  KEY `lider` (`lider`),
  CONSTRAINT `FK_equipos_lideres` FOREIGN KEY (`lider`) REFERENCES `lideres` (`IDlider`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Dumping data for table arqeadb.equipos: ~0 rows (approximately)
DELETE FROM `equipos`;

-- Dumping structure for table arqeadb.lideres
CREATE TABLE IF NOT EXISTS `lideres` (
  `IDlider` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  `apellido` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`IDlider`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Dumping data for table arqeadb.lideres: ~0 rows (approximately)
DELETE FROM `lideres`;

-- Dumping structure for table arqeadb.museos
CREATE TABLE IF NOT EXISTS `museos` (
  `IDmuseo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_museo` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`IDmuseo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Dumping data for table arqeadb.museos: ~0 rows (approximately)
DELETE FROM `museos`;

-- Dumping structure for table arqeadb.yacimientos
CREATE TABLE IF NOT EXISTS `yacimientos` (
  `IDyacimiento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  `coordenadas` point DEFAULT NULL,
  PRIMARY KEY (`IDyacimiento`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Dumping data for table arqeadb.yacimientos: ~0 rows (approximately)
DELETE FROM `yacimientos`;

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
