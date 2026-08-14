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
  `museo` int(11) NOT NULL DEFAULT 0,
  `yacimiento` int(11) NOT NULL DEFAULT 0,
  `clave` varchar(12) NOT NULL DEFAULT '0',
  `img` varchar(50) NOT NULL DEFAULT '0',
  `clase` int(11) NOT NULL DEFAULT 0,
  `habilitado` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`IDartefacto`),
  KEY `descubridores` (`descubridores`),
  KEY `museo` (`museo`),
  KEY `yacimiento` (`yacimiento`),
  KEY `clase` (`clase`),
  CONSTRAINT `FK_artefactos_clases` FOREIGN KEY (`clase`) REFERENCES `clases` (`IDclase`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_artefactos_equipos` FOREIGN KEY (`descubridores`) REFERENCES `equipos` (`IDequipo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_artefactos_museos` FOREIGN KEY (`museo`) REFERENCES `museos` (`IDmuseo`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_artefactos_yacimientos` FOREIGN KEY (`yacimiento`) REFERENCES `yacimientos` (`IDyacimiento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Dumping data for table arqeadb.artefactos: ~16 rows (approximately)
DELETE FROM `artefactos`;
INSERT INTO `artefactos` (`IDartefacto`, `nombre`, `descripcion`, `descubridores`, `encamino`, `museo`, `yacimiento`, `clave`, `img`, `clase`, `habilitado`) VALUES
	(1, 'Máscara funeraria de Tutankamón', 'Máscara de oro macizo incrustada con piedras semipreciosas hallada sobre la momia del faraón Tutankamón.', 3, 0, 2, 2, 'KF9500167403', '00001.webp', 7, 1),
	(2, 'Trono dorado de Tutankamón', 'Trono de madera revestido de oro y plata con escena decorativa del rey y la reina Ankhesenamón.', 3, 0, 2, 2, 'AF6525808631', '00002.webp', 9, 1),
	(3, 'Estatua sedente de Kefrén', '-- Estatua de diorita del faraón Kefrén, protegido por el dios Horus en forma de halcón.', 1, 0, 1, 1, 'VQ8570220212', '00003.webp', 1, 1),
	(4, 'Tríada de Micerinos', 'Grupo escultórico en grauvaca que representa al faraón Micerinos junto a dos divinidades.', 4, 0, 1, 1, 'LF5723964512', '00004.webp', 1, 1),
	(5, 'Sarcófago de Seti I', 'Sarcófago de alabastro finamente tallado con textos del Libro de las Puertas.', 8, 0, 1, 2, 'IP2206298026', '00005.webp', 2, 1),
	(6, 'Estela de la familia real de Amarna', 'Relieve que representa a Akenatón, Nefertiti y sus hijas bajo los rayos del disco solar Atón.', 2, 0, 1, 12, 'LY8251982661', '00006.webp', 8, 1),
	(7, 'Papiro del Libro de los Muertos de Deir el-Medina', 'Papiro funerario con fórmulas y viñetas del Libro de los Muertos hallado en la necrópolis de artesanos.', 6, 0, 1, 7, 'TO7503098830', '00007.webp', 5, 1),
	(8, 'Collar pectoral de escarabeo de Tutankamón', 'Joya de oro y piedras semipreciosas con escarabajo alado hallada entre los ajuares funerarios del rey.', 3, 0, 2, 2, 'FD9547810444', '00008.webp', 3, 1),
	(9, 'Amuletos de la momia de Tutankamón', 'Conjunto de amuletos protectores colocados entre los vendajes de la momia real.', 3, 0, 2, 2, 'ZQ5687203229', '00009.webp', 6, 1),
	(10, 'Vasijas canópicas de Tutankamón', 'Conjunto de cuatro vasijas de alabastro utilizadas para conservar las vísceras del faraón momificado. esta editado?', 3, 0, 2, 2, 'QJ3229661713', '00010.webp', 4, 1),
	(11, 'estatua colosal de Ramsés II de Gerf Hussein', 'Estela tallada en la fachada del templo mayor que conmemora el poder de Ramsés II sobre Nubia.', 11, 0, 5, 6, 'ZN9807652614', '00011.webp', 8, 1),
	(12, 'Relieves del Templo de Hathor en Dendera', 'Relieves decorativos que representan escenas rituales dedicadas a la diosa Hathor.', 1, 0, 1, 8, 'YI0086875935', '00012.webp', 10, 1),
	(13, 'Estatua de Horus de Edfu', 'Estatua de granito negro que representa al dios Horus en forma de halcón, guardián del templo.', 7, 0, 1, 9, 'WI6394225258', '00013.webp', 1, 1),
	(14, 'Momias de cocodrilo', 'Conjunto de relieves y objetos relacionados con la práctica médica en el Egipto ptolemaico.', 12, 0, 3, 10, 'QA2276804025', '00014.webp', 4, 1),
	(15, 'Estatua de Paser', 'Relieve que enumera a los faraones predecesores de Seti I, hallado en su templo funerario.', 9, 0, 1, 11, 'WY0407714528', '00015.jpg', 8, 1),
	(16, 'Estatua de Sobek y Amenofis III', 'meh', 10, 1, 1, 2, 'NP2668013001', '00016.webp', 1, 0);

-- Dumping structure for table arqeadb.clases
CREATE TABLE IF NOT EXISTS `clases` (
  `IDclase` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_clase` varchar(50) NOT NULL DEFAULT '0',
  `descripcion_clase` tinytext NOT NULL DEFAULT '0',
  `habilitado` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`IDclase`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Dumping data for table arqeadb.clases: ~10 rows (approximately)
DELETE FROM `clases`;
INSERT INTO `clases` (`IDclase`, `nombre_clase`, `descripcion_clase`, `habilitado`) VALUES
	(1, 'Estatuas', 'Esculturas de figuras humanas o divinas', 1),
	(2, 'Sarcófagos', 'Contenedores funerarios de piedra o madera', 1),
	(3, 'Joyería', 'Piezas de orfebrería y adorno personal', 1),
	(4, 'Cerámica', 'Vasijas y recipientes de cerámica', 1),
	(5, 'Papiros', 'Documentos escritos sobre papiro', 1),
	(6, 'Amuletos', 'Objetos protectores de uso funerario o personal', 1),
	(7, 'Máscaras funerarias', 'Máscaras colocadas sobre momias', 1),
	(8, 'Estelas', 'Losas grabadas con inscripciones o relieves', 1),
	(9, 'Mobiliario', 'Muebles y objetos de uso cotidiano o ritual', 1),
	(10, 'Relieves', 'Tallas decorativas sobre muros o superficies', 1);

-- Dumping structure for table arqeadb.equipos
CREATE TABLE IF NOT EXISTS `equipos` (
  `IDequipo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_equipo` varchar(50) NOT NULL DEFAULT '0',
  `origen` varchar(50) NOT NULL DEFAULT '0',
  `lider` int(11) NOT NULL DEFAULT 0,
  `habilitado` int(11) NOT NULL DEFAULT 1,
  `clave` varchar(12) NOT NULL DEFAULT '1',
  PRIMARY KEY (`IDequipo`),
  KEY `lider` (`lider`),
  CONSTRAINT `FK_equipos_lideres` FOREIGN KEY (`lider`) REFERENCES `lideres` (`IDlider`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Dumping data for table arqeadb.equipos: ~12 rows (approximately)
DELETE FROM `equipos`;
INSERT INTO `equipos` (`IDequipo`, `nombre_equipo`, `origen`, `lider`, `habilitado`, `clave`) VALUES
	(1, 'Misión Arqueológica Francesa en Karnak (IFAO)', 'Francia', 1, 1, 'DU4677884350'),
	(2, 'Instituto Arqueológico Alemán de El Cairo (DAI)', 'Alemania', 2, 1, 'AS5146961086'),
	(3, 'Sociedad de Exploración de Egipto (EES)', 'Reino Unido', 3, 1, 'KO5454025450'),
	(4, 'Misión del Instituto Oriental de Chicago', 'Estados Unidos', 4, 1, 'BO7354102691'),
	(5, 'Misión Arqueológica Italiana en Saqqara', 'Italia', 5, 1, 'YP1069544098'),
	(6, 'Centro Polaco de Arqueología Mediterránea (PCMA)', 'Polonia', 6, 1, 'TK7002771195'),
	(7, 'Proyecto Djehuty - Misión Española en Luxor', 'España', 7, 1, 'JQ1344021001'),
	(8, 'Instituto Checo de Egiptología', 'Republica Checa', 8, 1, 'TL8446873788'),
	(9, 'Misión Arqueológica de la Universidad de Waseda', 'Japon', 9, 1, 'YD9461352005'),
	(10, 'Consejo Supremo de Antigüedades de Egipto', 'Egipto', 10, 1, 'HO8842584107'),
	(11, 'Misión Arqueológica Portuguesa en Egipto', 'Portugal', 11, 1, 'UI1950240472'),
	(12, 'Misión Neerlandesa de la Universidad de Leiden', 'Paises Bajos', 12, 1, 'AO7269482852');

-- Dumping structure for table arqeadb.lideres
CREATE TABLE IF NOT EXISTS `lideres` (
  `IDlider` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  `apellido` varchar(50) NOT NULL DEFAULT '0',
  `habilitado` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`IDlider`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Dumping data for table arqeadb.lideres: ~12 rows (approximately)
DELETE FROM `lideres`;
INSERT INTO `lideres` (`IDlider`, `nombre`, `apellido`, `habilitado`) VALUES
	(1, 'Jean-Baptiste', 'Moreau', 1),
	(2, 'Klaus', 'Richter', 1),
	(3, 'Sarah', 'Whitfield', 1),
	(4, 'James', 'Anderson', 1),
	(5, 'Giulia', 'Romano', 1),
	(6, 'Katarzyna', 'Nowak', 1),
	(7, 'Carmen', 'Ibáñez', 1),
	(8, 'Petra', 'Nováková', 1),
	(9, 'Haruto', 'Tanaka', 1),
	(10, 'Ahmed', 'El-Sayed', 1),
	(11, 'Mariana', 'Costa', 1),
	(12, 'Willem', 'de Vries', 1);

-- Dumping structure for table arqeadb.museos
CREATE TABLE IF NOT EXISTS `museos` (
  `IDmuseo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_museo` varchar(50) NOT NULL DEFAULT '0',
  `habilitado` int(11) NOT NULL DEFAULT 1,
  `clave` varchar(12) NOT NULL DEFAULT '0',
  `coordenadas` point NOT NULL,
  PRIMARY KEY (`IDmuseo`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Dumping data for table arqeadb.museos: ~10 rows (approximately)
DELETE FROM `museos`;
INSERT INTO `museos` (`IDmuseo`, `nombre_museo`, `habilitado`, `clave`, `coordenadas`) VALUES
	(1, 'Museo Egipcio de El Cairo', 1, 'BC2546196889', _binary 0x0000000001010000007958a835cd3b3f40b1bfec9e3c0c3e40),
	(2, 'Gran Museo Egipcio (GEM), Giza', 1, 'ZE8315986514', _binary 0x000000000101000000772d211ff41c3f40ae47e17a14fe3d40),
	(3, 'Museo Nacional de la Civilización Egipcia (NMEC)', 1, 'RY6531621112', _binary 0x000000000101000000ac8bdb68003f3f408a1f63ee5a023e40),
	(4, 'Museo de Luxor de Arte Antiguo Egipcio', 1, 'LF7998069057', _binary 0x0000000001010000007c61325530524040a52c431cebb23940),
	(5, 'Museo Nubio de Asuán', 1, 'IH3491770535', _binary 0x0000000001010000006c787aa52c734040d7a3703d0a173840),
	(6, 'Museo Grecorromano de Alejandría', 1, 'YQ3393794254', _binary 0x000000000101000000d42b6519e2e83d40c3f5285c8f323f40),
	(7, 'Museo de Mallawi', 1, 'VA7225751911', _binary 0x000000000101000000bec1172653d53e4024287e8cb9bb3b40),
	(8, 'Museo de la Momificación de Luxor', 1, 'NL6427724022', _binary 0x00000000010100000060e5d022db514040a54e401361b33940),
	(9, 'Museo del Oasis de Kharga', 1, 'XN9122636196', _binary 0x000000000101000000eb73b515fb8b3e40713d0ad7a3703940),
	(10, 'Museo de Hurghada', 1, 'AI6262363070', _binary 0x00000000010100000080b74082e2e740406ea301bc05423b40);

-- Dumping structure for table arqeadb.yacimientos
CREATE TABLE IF NOT EXISTS `yacimientos` (
  `IDyacimiento` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(50) NOT NULL DEFAULT '0',
  `coordenadas` point NOT NULL DEFAULT st_geometryfromtext('POINT(0 0)'),
  `habilitado` int(11) NOT NULL DEFAULT 1,
  PRIMARY KEY (`IDyacimiento`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

-- Dumping data for table arqeadb.yacimientos: ~15 rows (approximately)
DELETE FROM `yacimientos`;
INSERT INTO `yacimientos` (`IDyacimiento`, `nombre`, `coordenadas`, `habilitado`) VALUES
	(1, 'Pirámides de Guiza', _binary 0x0000000001010000008a1f63ee5a223f40423ee8d9acfa3d40, 1),
	(2, 'Valle de los Reyes', _binary 0x0000000001010000003ee8d9acfa4c4040cc7f48bf7dbd3940, 1),
	(3, 'Templo de Karnak', _binary 0x00000000010100000095d4096822544040645ddc4603b83940, 1),
	(4, 'Templo de Luxor', _binary 0x000000000101000000c442ad69de514040de02098a1fb33940, 1),
	(5, 'Necrópolis de Saqqara', _binary 0x000000000101000000bada8afd65373f4002bc051214df3d40, 1),
	(6, 'Templos de Abu Simbel', _binary 0x00000000010100000039d6c56d34a03f4011363cbd52563640, 1),
	(7, 'Deir el-Medina', _binary 0x0000000001010000004d158c4aea4c4040ee7c3f355eba3940, 1),
	(8, 'Templo de Dendera', _binary 0x000000000101000000bde3141dc9554040dcd7817346243a40, 1),
	(9, 'Templo de Edfu', _binary 0x0000000001010000002b8716d9ce6f4040b537f8c264fa3840, 1),
	(10, 'Templo de Kom Ombo', _binary 0x000000000101000000022b8716d97640404faf946588733840, 1),
	(11, 'Abidos', _binary 0x00000000010100000008ac1c5a64eb3f40e561a1d6342f3a40, 1),
	(12, 'Tell el-Amarna', _binary 0x000000000101000000f46c567daee63e40da1b7c6132a53b40, 1),
	(13, 'El Kab', _binary 0x000000000101000000787aa52c4364404076711b0de01d3940, 1),
	(14, 'Templo de Filas (Philae)', _binary 0x000000000101000000c58f31772d7140409f3c2cd49a063840, 1),
	(15, 'Pirámide de Meidum', _binary 0x00000000010100000065aa605452273f40166a4df38e633d40, 1);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
