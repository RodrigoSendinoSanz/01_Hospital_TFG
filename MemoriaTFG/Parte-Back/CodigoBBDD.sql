-- MySQL dump 10.13  Distrib 8.0.28, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: hospital_bbdd
-- ------------------------------------------------------
-- Server version	8.0.28

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
-- Table structure for table `cita`
--

DROP TABLE IF EXISTS `cita`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cita` (
  `ID_CITA` int NOT NULL AUTO_INCREMENT,
  `FECHA_CITA` date NOT NULL,
  `HORA_CITA` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `DIRECCION_CENTROSALUD` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `SINTOMAS` varchar(30) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `NOMBRE_MEDICO` varchar(30) COLLATE utf8mb4_spanish_ci NOT NULL,
  `NOMBRE_PACIENTE` varchar(30) COLLATE utf8mb4_spanish_ci NOT NULL,
  `ESTADO` varchar(30) COLLATE utf8mb4_spanish_ci NOT NULL,
  `DNI` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`ID_CITA`),
  KEY `DNI` (`DNI`),
  CONSTRAINT `cita_ibfk_1` FOREIGN KEY (`DNI`) REFERENCES `usuario` (`DNI`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cita`
--

LOCK TABLES `cita` WRITE;
/*!40000 ALTER TABLE `cita` DISABLE KEYS */;
INSERT INTO `cita` VALUES (1,'2022-04-28','08:20','Direcion rontonda 2','Dedos rotos','med123','rodrigo','Realizado','71706550w'),(2,'2022-06-12','10:30','Direccion1',NULL,'med123','rodrigo','Pendiente','71706550w'),(3,'2022-04-23','11:45','Direcion rontonda 1','Congestion','med123','jaume','Pendiente','34728920w'),(4,'2022-05-13','11:30','Direccion2','asd','Medico1','456','Pendiente','456'),(5,'2022-05-18','11:30','Direccion2','123','Medico1','123','Pendiente','123'),(6,'2022-05-26','11:30','Direccion2','asd','456','789','Pendiente','789'),(7,'2022-05-18','13:30','Direccion3','asd','456','789','Pendiente','789'),(8,'2022-05-17','21:30','Direccion3','mañana','456','789','Pendiente','789'),(9,'2022-05-20','17:30','Direccion2','123251515nvcbfc','456','789','Pendiente','789'),(10,'2022-05-21','16:30','Direccion2','ASDASD','456','789','Realizado','789'),(11,'2022-05-26','18:30','Direccion2','A','456','789','Realizado','789');
/*!40000 ALTER TABLE `cita` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comentarios`
--

DROP TABLE IF EXISTS `comentarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `comentarios` (
  `ID_COM` int NOT NULL AUTO_INCREMENT,
  `DNI_1` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `DNI_2` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `COMENTARIO` varchar(100) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`ID_COM`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comentarios`
--

LOCK TABLES `comentarios` WRITE;
/*!40000 ALTER TABLE `comentarios` DISABLE KEYS */;
INSERT INTO `comentarios` VALUES (2,'456','789','poipoipiuoiu'),(8,'456','789','hola'),(9,'789','456','prueba de 789'),(10,'789','456','sale?'),(11,'456','71706550w','hols');
/*!40000 ALTER TABLE `comentarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diagnostico`
--

DROP TABLE IF EXISTS `diagnostico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diagnostico` (
  `ID_DIAG` int NOT NULL AUTO_INCREMENT,
  `ALERGIAS` varchar(300) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `TRATAMIENTO` varchar(300) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `OPERACIONES` varchar(300) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `ENFERMEDADES` varchar(300) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `DNI` varchar(50) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`ID_DIAG`),
  UNIQUE KEY `DNI` (`DNI`),
  CONSTRAINT `diagnostico_ibfk_1` FOREIGN KEY (`DNI`) REFERENCES `usuario` (`DNI`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diagnostico`
--

LOCK TABLES `diagnostico` WRITE;
/*!40000 ALTER TABLE `diagnostico` DISABLE KEYS */;
INSERT INTO `diagnostico` VALUES (6,'polen, cereales',NULL,NULL,'COVID','34728920w'),(7,'cereales',NULL,'operacion de rodilla',NULL,'483920m'),(8,'graminias','colirio',NULL,'lyme','503942f'),(9,'frutos secos',NULL,NULL,'VIH','6574848e'),(10,'graminias','colirio','coartacion de aorta',NULL,'71706550w'),(11,'qwe','qwe','qweqwe','qwe','789');
/*!40000 ALTER TABLE `diagnostico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `historial_clinico`
--

DROP TABLE IF EXISTS `historial_clinico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `historial_clinico` (
  `ID_HISTORIAL` int NOT NULL AUTO_INCREMENT,
  `ID_CITA` int NOT NULL,
  `COD_MED` int NOT NULL,
  `DES_CITAHIS` varchar(300) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `INSTRUCCIONES` varchar(300) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`ID_HISTORIAL`),
  KEY `ID_CITA` (`ID_CITA`),
  KEY `COD_MED` (`COD_MED`),
  CONSTRAINT `historial_clinico_ibfk_1` FOREIGN KEY (`ID_CITA`) REFERENCES `cita` (`ID_CITA`),
  CONSTRAINT `historial_clinico_ibfk_2` FOREIGN KEY (`COD_MED`) REFERENCES `medicina` (`COD_MED`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `historial_clinico`
--

LOCK TABLES `historial_clinico` WRITE;
/*!40000 ALTER TABLE `historial_clinico` DISABLE KEYS */;
INSERT INTO `historial_clinico` VALUES (1,4,1234,'sdfsdf','asdasd'),(4,10,1234,'10','Realizado'),(5,11,1234,'11','Realizado');
/*!40000 ALTER TABLE `historial_clinico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `informacion`
--

DROP TABLE IF EXISTS `informacion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `informacion` (
  `ID_INFO` int NOT NULL AUTO_INCREMENT,
  `PESO` int DEFAULT NULL,
  `ALTURA` varchar(10) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `EDAD` int DEFAULT NULL,
  `SEXO` varchar(10) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `DNI` varchar(50) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`ID_INFO`),
  UNIQUE KEY `DNI` (`DNI`),
  CONSTRAINT `informacion_ibfk_1` FOREIGN KEY (`DNI`) REFERENCES `usuario` (`DNI`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `informacion`
--

LOCK TABLES `informacion` WRITE;
/*!40000 ALTER TABLE `informacion` DISABLE KEYS */;
INSERT INTO `informacion` VALUES (6,23,'1,23',23,'m','34728920w'),(7,34,'1,45',32,'f','483920m'),(8,70,'1,80',45,'m','503942f'),(9,65,'1,70',32,'m','6574848e'),(10,68,'1,78',25,'m','71706550w'),(11,19,'19',19,'f','456'),(12,19,'19',19,'f','789');
/*!40000 ALTER TABLE `informacion` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `medicina`
--

DROP TABLE IF EXISTS `medicina`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `medicina` (
  `COD_MED` int NOT NULL,
  `NOMBRE_MED` varchar(200) COLLATE utf8mb4_spanish_ci NOT NULL,
  `CANTIDAD` int DEFAULT NULL,
  `FECHA_INICIO` date NOT NULL,
  `FECHA_FIN` date NOT NULL,
  `ACTIVO` varchar(2) COLLATE utf8mb4_spanish_ci NOT NULL,
  `ID_TIPO` int NOT NULL,
  PRIMARY KEY (`COD_MED`),
  KEY `ID_TIPO` (`ID_TIPO`),
  CONSTRAINT `medicina_ibfk_1` FOREIGN KEY (`ID_TIPO`) REFERENCES `tipo` (`ID_TIPO`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `medicina`
--

LOCK TABLES `medicina` WRITE;
/*!40000 ALTER TABLE `medicina` DISABLE KEYS */;
INSERT INTO `medicina` VALUES (1234,'DALSY',12,'2022-06-12','2023-04-12','SI',1),(2342,'NOLOTIL',13,'2027-06-23','2022-10-12','NO',3),(4321,'IBUPORFENO',12,'2024-06-23','2025-04-12','SI',2);
/*!40000 ALTER TABLE `medicina` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `perfil`
--

DROP TABLE IF EXISTS `perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `perfil` (
  `ID_PERFIL` int NOT NULL AUTO_INCREMENT,
  `DESC_PER` varchar(20) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`ID_PERFIL`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `perfil`
--

LOCK TABLES `perfil` WRITE;
/*!40000 ALTER TABLE `perfil` DISABLE KEYS */;
INSERT INTO `perfil` VALUES (1,'Paciente'),(2,'Medico');
/*!40000 ALTER TABLE `perfil` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipo`
--

DROP TABLE IF EXISTS `tipo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipo` (
  `ID_TIPO` int NOT NULL AUTO_INCREMENT,
  `DESCRIPCION` varchar(300) COLLATE utf8mb4_spanish_ci NOT NULL,
  PRIMARY KEY (`ID_TIPO`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipo`
--

LOCK TABLES `tipo` WRITE;
/*!40000 ALTER TABLE `tipo` DISABLE KEYS */;
INSERT INTO `tipo` VALUES (1,'ANALGESICO'),(2,'ANTIFLAMATORIO'),(3,'ANTIPIRUETICOS');
/*!40000 ALTER TABLE `tipo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `DNI` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `PASSWORD` varchar(200) COLLATE utf8mb4_spanish_ci NOT NULL,
  `ENABLED` int DEFAULT NULL,
  `ONLINEUSU` int NOT NULL,
  `EMAIL` varchar(100) COLLATE utf8mb4_spanish_ci NOT NULL,
  `NOMBRE` varchar(50) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `APELLIDO` varchar(50) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `DIRECCION` varchar(100) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `IMGURL` varchar(200) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  `TELEFONO` varchar(10) COLLATE utf8mb4_spanish_ci DEFAULT NULL,
  PRIMARY KEY (`DNI`),
  UNIQUE KEY `EMAIL` (`EMAIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES ('123','$2a$10$9LwcuM.qBUOZZz6znX4Z8Oy25ApUJDZf9vW5RA1kya1jhg0y.l6b6',1,0,'123@123','123','123','123','https://w7.pngwing.com/pngs/831/88/png-transparent-user-profile-computer-icons-user-interface-mystique-miscellaneous-user-interface-design-smile.png','123'),('34728920w','wdn23',1,1,'jauma@sdm.cp,','jaume','juame','jaume','juame','29372293'),('456','$2a$10$0Vrz3QcSOThWZOe4u6cAqO5X3Qco1fPHR.CKfA26UV80jKpg3HBTC',1,1,'456@456','456','fghfghfgh','fghfsdfs','','1123'),('483920m','maria123',1,1,'maria@meail.com','maria','maria','maria','maria()','54372293'),('503942f','124',1,0,'jaunsd@rfkwer','juan','juan','juan','juan','34728291'),('6574848e','1234',1,1,'epepe@gmoalm,','pepe','pepe','manue','manue','627787324'),('71706550w','1234',1,1,'rodrigo@email.com','rodrigo','sendino','glorieta','url(1)','627787302'),('789','$2a$10$pdgo.XVDnDAa9o/lNfGGweRg1GyKg1YdhYThesdY.dEKoJGHl7Ola',1,1,'789@789','789','789','789',NULL,'789'),('888','asdaswf',1,0,'888@888','888','888','888',NULL,'888'),('med123','$2a$10$WSnxyOn52.VlQ2DYDNo/BObsySZ5Q2Z9GswF5586duFjOjnubJIV2',1,1,'medico@mail.com','medico','medico','medico','medico','673782812');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario_perfil`
--

DROP TABLE IF EXISTS `usuario_perfil`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario_perfil` (
  `DNI` varchar(50) COLLATE utf8mb4_spanish_ci NOT NULL,
  `ID_PERFIL` int NOT NULL,
  PRIMARY KEY (`DNI`,`ID_PERFIL`),
  KEY `ID_PERFIL` (`ID_PERFIL`),
  CONSTRAINT `usuario_perfil_ibfk_1` FOREIGN KEY (`DNI`) REFERENCES `usuario` (`DNI`),
  CONSTRAINT `usuario_perfil_ibfk_2` FOREIGN KEY (`ID_PERFIL`) REFERENCES `perfil` (`ID_PERFIL`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_spanish_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario_perfil`
--

LOCK TABLES `usuario_perfil` WRITE;
/*!40000 ALTER TABLE `usuario_perfil` DISABLE KEYS */;
INSERT INTO `usuario_perfil` VALUES ('789',1),('888',1),('123',2),('456',2);
/*!40000 ALTER TABLE `usuario_perfil` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-05-19 18:29:25
