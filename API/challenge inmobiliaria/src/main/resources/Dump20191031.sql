-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: localhost    Database: inmobiliaria
-- ------------------------------------------------------
-- Server version	8.0.17

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `alquiler`
--

DROP TABLE IF EXISTS `alquiler`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alquiler` (
  `alquiler_id` int(11) NOT NULL AUTO_INCREMENT,
  `tipo_alquiler` varchar(45) NOT NULL,
  `moneda` varchar(5) NOT NULL,
  `valor` decimal(16,2) NOT NULL,
  `plazo_meses` int(3) NOT NULL,
  `aviso_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`alquiler_id`),
  KEY `alquiler_aviso_FK_idx` (`aviso_id`),
  CONSTRAINT `alquiler_aviso_FK` FOREIGN KEY (`aviso_id`) REFERENCES `aviso` (`aviso_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alquiler`
--

LOCK TABLES `alquiler` WRITE;
/*!40000 ALTER TABLE `alquiler` DISABLE KEYS */;
INSERT INTO `alquiler` VALUES (1,'Vivienda','AR$',27000.00,24,2),(2,'Vivienda','AR$',30000.00,24,NULL),(3,'Vivienda','AR$',30000.00,24,3),(4,'Vivienda','AR$',25000.00,36,5),(5,'Comercial','AR$',30000.00,36,NULL),(6,'Comercial','AR$',30000.00,36,NULL),(7,'Comercial','AR$',30000.00,36,NULL),(8,'Comercial','AR$',30000.00,36,NULL),(9,'Vivienda','AR$',50000.00,24,NULL),(10,'Vivienda','AR$',50000.00,24,NULL),(11,'Vivienda','AR$',50000.00,24,NULL),(12,'Vivienda','AR$',50000.00,24,6);
/*!40000 ALTER TABLE `alquiler` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `aviso`
--

DROP TABLE IF EXISTS `aviso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `aviso` (
  `aviso_id` int(11) NOT NULL AUTO_INCREMENT,
  `inmueble_id` int(11) NOT NULL,
  `tipo_operacion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`aviso_id`),
  KEY `aviso_inmueble_fk_idx` (`inmueble_id`),
  CONSTRAINT `aviso_inmueble_fk` FOREIGN KEY (`inmueble_id`) REFERENCES `inmueble` (`inmueble_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `aviso`
--

LOCK TABLES `aviso` WRITE;
/*!40000 ALTER TABLE `aviso` DISABLE KEYS */;
INSERT INTO `aviso` VALUES (1,1,'Venta'),(2,1,'Alquiler'),(3,2,'Alquiler'),(4,2,'Venta'),(5,2,'Alquiler'),(6,4,'Alquiler'),(7,4,'Venta');
/*!40000 ALTER TABLE `aviso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inmobiliaria`
--

DROP TABLE IF EXISTS `inmobiliaria`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inmobiliaria` (
  `inmobiliaria_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `cuit` varchar(30) NOT NULL,
  `usuario_id` int(11) NOT NULL,
  PRIMARY KEY (`inmobiliaria_id`),
  UNIQUE KEY `cuit_UNIQUE` (`cuit`),
  KEY `inmobiliaria_usuario_idx` (`usuario_id`),
  CONSTRAINT `inmobiliaria_usuario` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`usuario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inmobiliaria`
--

LOCK TABLES `inmobiliaria` WRITE;
/*!40000 ALTER TABLE `inmobiliaria` DISABLE KEYS */;
INSERT INTO `inmobiliaria` VALUES (1,'Muchas Casitas','29-65777493-0',4),(2,'Inmobiliaria Mandinga','27-76937764-0',14),(3,'Inmobiliaria Chamuyo','27-71117764-0',15),(4,'Inmobiliaria Coquito','27-71987764-0',16),(5,'Inmobiliaria Mayonesa','27-99987764-0',17);
/*!40000 ALTER TABLE `inmobiliaria` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `inmueble`
--

DROP TABLE IF EXISTS `inmueble`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `inmueble` (
  `inmueble_id` int(11) NOT NULL AUTO_INCREMENT,
  `locador_id` int(11) NOT NULL,
  `tipo_inmueble` varchar(45) NOT NULL,
  `cant_amb` int(11) NOT NULL,
  `direccion` varchar(255) NOT NULL,
  `reservado` char(1) NOT NULL,
  `superficie` decimal(14,2) NOT NULL,
  `cant_dormitorio` int(11) NOT NULL,
  `apto_prof` char(1) NOT NULL,
  `disposicion` varchar(45) NOT NULL,
  `cant_banios` int(11) NOT NULL,
  `antiguedad_anios` int(11) NOT NULL,
  PRIMARY KEY (`inmueble_id`),
  KEY `locador_inmueble_fk_idx` (`locador_id`),
  CONSTRAINT `inmueble_locador_fk` FOREIGN KEY (`locador_id`) REFERENCES `locador` (`locador_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `inmueble`
--

LOCK TABLES `inmueble` WRITE;
/*!40000 ALTER TABLE `inmueble` DISABLE KEYS */;
INSERT INTO `inmueble` VALUES (1,1,'Departamento',0,'Córdoba 4300','s',70.00,3,'y','Frente',2,5),(2,1,'Casa',0,'Independencia 4300','n',90.00,3,'y','Frente',2,10),(3,1,'Departamento',0,'Av. de Mayo 915','n',80.00,2,'y','Lateral',1,15),(4,1,'Casa',0,'Av. Monroe 1500','n',200.00,4,'y','Frente',3,5);
/*!40000 ALTER TABLE `inmueble` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locador`
--

DROP TABLE IF EXISTS `locador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locador` (
  `locador_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `dni` varchar(20) NOT NULL,
  `edad` int(10) NOT NULL,
  `email` varchar(255) CHARACTER SET armscii8 COLLATE armscii8_general_ci NOT NULL,
  PRIMARY KEY (`locador_id`),
  UNIQUE KEY `dni_UNIQUE` (`dni`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locador`
--

LOCK TABLES `locador` WRITE;
/*!40000 ALTER TABLE `locador` DISABLE KEYS */;
INSERT INTO `locador` VALUES (1,'Jorge Perez','45678432',65,'jperez@g.com'),(2,'Jorge Lopez','45578432',66,'jlo@g.com'),(4,'Jorge Chacrun','45678430',57,'chacri@g.com'),(5,'Jorge Chuhu','46678430',57,'chuhui@g.com');
/*!40000 ALTER TABLE `locador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `locatario`
--

DROP TABLE IF EXISTS `locatario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `locatario` (
  `locatario_id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `dni` varchar(20) NOT NULL,
  `edad` int(10) NOT NULL,
  `email` varchar(255) NOT NULL,
  `reserva_id` int(11) DEFAULT NULL,
  `usuario_id` int(11) NOT NULL,
  PRIMARY KEY (`locatario_id`),
  UNIQUE KEY `dni_UNIQUE` (`dni`),
  KEY `locatario_reserva_fk_idx` (`reserva_id`),
  KEY `locatario_usuario_fk_idx` (`usuario_id`),
  CONSTRAINT `locatario_reserva_fk` FOREIGN KEY (`reserva_id`) REFERENCES `reserva` (`reserva_id`),
  CONSTRAINT `locatario_usuario_fk` FOREIGN KEY (`usuario_id`) REFERENCES `usuario` (`usuario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `locatario`
--

LOCK TABLES `locatario` WRITE;
/*!40000 ALTER TABLE `locatario` DISABLE KEYS */;
INSERT INTO `locatario` VALUES (1,'Ana María Cleta','76854503',35,'pedaless@g.com',NULL,8),(2,'Rosa Parks','32167503',56,'rosita@g.com',NULL,10),(3,'Angela Davis','31675053',66,'ladavis@g.com',NULL,11),(4,'Locatario Perdido','31611053',68,'perdido@g.com',NULL,12),(5,'Andrea','31423567',35,'a@g.com',NULL,18),(6,'Lucía','32423567',35,'l@g.com',NULL,20);
/*!40000 ALTER TABLE `locatario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reserva`
--

DROP TABLE IF EXISTS `reserva`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `reserva` (
  `reserva_id` int(11) NOT NULL AUTO_INCREMENT,
  `fecha` date NOT NULL,
  `locatario_id` int(11) NOT NULL,
  `inmueble_id` int(11) NOT NULL,
  `aviso_id` int(11) NOT NULL,
  PRIMARY KEY (`reserva_id`),
  KEY `reserva_locatario_fk_idx` (`locatario_id`),
  KEY `reserva_inmueble_fk_idx` (`inmueble_id`),
  KEY `reserva_aviso_fk_idx` (`aviso_id`),
  CONSTRAINT `reserva_aviso_fk` FOREIGN KEY (`aviso_id`) REFERENCES `aviso` (`aviso_id`),
  CONSTRAINT `reserva_inmueble_fk` FOREIGN KEY (`inmueble_id`) REFERENCES `inmueble` (`inmueble_id`),
  CONSTRAINT `reserva_locatario_fk` FOREIGN KEY (`locatario_id`) REFERENCES `locatario` (`locatario_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reserva`
--

LOCK TABLES `reserva` WRITE;
/*!40000 ALTER TABLE `reserva` DISABLE KEYS */;
INSERT INTO `reserva` VALUES (1,'2019-10-25',1,1,1),(2,'2019-10-31',1,1,2);
/*!40000 ALTER TABLE `reserva` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `usuario_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(100) NOT NULL,
  `email` varchar(255) NOT NULL,
  `tipo_usuario` varchar(45) NOT NULL,
  `estado_usuario` varchar(45) NOT NULL,
  `fecha_alta` datetime NOT NULL,
  `fecha_baja` datetime DEFAULT NULL,
  PRIMARY KEY (`usuario_id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'AltosGarcas','hsklue7','ag@gmail.com','Inmobiliaria','','2019-10-23 18:47:08',NULL),(2,'tcasitas@g.com','45578432','tcasitas@g.com','Inmobiliaria','','2019-10-23 18:47:09',NULL),(4,'mcasitas@g.com','45578432','mcasitas@g.com','Inmobiliaria','','2019-10-23 18:47:07',NULL),(5,'pedalin@g.com','478432','pedalin@g.com','Locatario','','2019-10-23 18:47:06',NULL),(7,'pedalea@g.com','478432','pedalea@g.com','Locatario','','2019-10-23 18:47:05',NULL),(8,'pedaless@g.com','478432','pedaless@g.com','Locatario','','2019-10-23 18:47:04',NULL),(9,'pedaleale@g.com','478432','pedaleale@g.com','Locatario','','2019-10-23 18:47:03',NULL),(10,'rosita@g.com','456432','rosita@g.com','Locatario','Activo','2019-10-23 18:47:09',NULL),(11,'ladavis@g.com','4564432','ladavis@g.com','Locatario','Baja','2019-10-23 18:48:19','2019-10-23 18:53:59'),(12,'perdido@g.com','4565432','perdido@g.com','Locatario','Baja','2019-10-24 19:27:54','2019-10-31 19:55:34'),(13,'sarlanga@g.com','+exLNFpf9S8Fy8hbl3NfLQ==','sarlanga@g.com','Inmobiliaria','Activo','2019-10-28 12:56:33',NULL),(14,'mandinga@g.com','Wiy2dYyghaHKrymCd1YKJg==','mandinga@g.com','Inmobiliaria','Activo','2019-10-28 13:08:05',NULL),(15,'chamuyo@g.com','DRJ2XrWnPwkaLgoOrcX0Lw==','chamuyo@g.com','Inmobiliaria','Activo','2019-10-28 13:21:07',NULL),(16,'coquito@g.com','KR0Td5KcsiuAwq8WBF61TA==','coquito@g.com','Inmobiliaria','Activo','2019-10-28 13:26:23',NULL),(17,'mayo@g.com','lBRCMcnKDDkhYBMZJn7boA==','mayo@g.com','Inmobiliaria','Activo','2019-10-31 18:34:18',NULL),(18,'a@g.com','870BKcTeiBm7Twlwfyd1kw==','a@g.com','Locatario','Activo','2019-10-31 18:34:59',NULL),(20,'l@g.com','5gMcMe1W1+fx8m+HphyM8w==','l@g.com','Locatario','Activo','2019-10-31 18:36:37',NULL);
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `venta`
--

DROP TABLE IF EXISTS `venta`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `venta` (
  `venta_id` int(11) NOT NULL AUTO_INCREMENT,
  `moneda` varchar(5) NOT NULL,
  `valor` decimal(16,2) NOT NULL,
  `aviso_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`venta_id`),
  KEY `venta_aviso_FK_idx` (`aviso_id`),
  CONSTRAINT `venta_aviso_FK` FOREIGN KEY (`aviso_id`) REFERENCES `aviso` (`aviso_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `venta`
--

LOCK TABLES `venta` WRITE;
/*!40000 ALTER TABLE `venta` DISABLE KEYS */;
INSERT INTO `venta` VALUES (1,'U$S',200000.00,1),(2,'U$S',300000.00,4),(3,'U$S',400000.00,NULL),(4,'U$S',400000.00,NULL),(5,'U$S',400000.00,7);
/*!40000 ALTER TABLE `venta` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-10-31 16:58:17
