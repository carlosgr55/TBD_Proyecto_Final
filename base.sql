-- MySQL dump 10.13  Distrib 8.0.36, for Win64 (x86_64)
--
-- Host: localhost    Database: veterinaria_bd
-- ------------------------------------------------------
-- Server version	8.0.37

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
-- Table structure for table `citas`
--

DROP TABLE IF EXISTS `citas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `citas` (
  `id` varchar(7) CHARACTER SET utf8mb3 COLLATE utf8mb3_spanish2_ci NOT NULL,
  `cliente` varchar(255) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `veterinario` varchar(255) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `mascota` varchar(100) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `dia` int NOT NULL,
  `mes` int NOT NULL,
  `ano` int NOT NULL,
  `hora` int NOT NULL,
  `minutos` int NOT NULL,
  `tipo` varchar(50) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `estatus` varchar(1) COLLATE utf8mb3_spanish2_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `citas_ibfk_1` (`cliente`),
  KEY `citas_ibfk_2` (`veterinario`),
  CONSTRAINT `citas_ibfk_1` FOREIGN KEY (`cliente`) REFERENCES `clientes` (`usuario`) ON DELETE SET NULL ON UPDATE CASCADE,
  CONSTRAINT `citas_ibfk_2` FOREIGN KEY (`veterinario`) REFERENCES `veterinarios` (`usuario`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `citas`
--

LOCK TABLES `citas` WRITE;
/*!40000 ALTER TABLE `citas` DISABLE KEYS */;
INSERT INTO `citas` VALUES ('0524001','Rosalia','Kali','El Mal Querer',5,5,2024,9,0,'Revision','A'),('0524002','Tashi','Kali','Tennis',5,5,2024,10,0,'Vacunacion','A'),('0524003','Art',NULL,'Duncanator',5,5,2024,10,0,'Estetico','A'),('0524004','Patrick','Phoebe','Art',5,5,2024,11,0,'Estetico','A'),('0524005','Ethel','Beyonce','Willoughby',6,5,2024,10,0,'Esterelizacion','A'),('0524006','LanaDelRey','Arca','Vape',6,5,2024,16,0,'Estetico','A'),('0524007','Shakira','Phoebe','Ladron',6,5,2024,13,0,'Revision','C'),('0524008','Shakira','Phoebe','Ladron',7,5,2024,8,0,'Revision','A'),('0524009','Fiona','Arca','Janet',7,5,2024,9,0,'Estetico','A'),('0524010','Rosalia','Arca','El Mal Querer',7,5,2024,10,0,'Estetico','A'),('0524011','Shakira','Phoebe','Ladron',9,5,2024,13,0,'Revision','A'),('0524013','Shakira','Phoebe','Ladron',6,5,2024,9,0,'Baño','C'),('0524014','dani','Phoebe','coco',27,5,2024,9,0,'Corte','A'),('0524015','lala2','Phoebe','pol',15,5,2024,18,0,'Baño','P'),('0524016',NULL,'Beyonce','Toby',5,5,2024,9,0,'Baño','A'),('0524017','danii','Phoebe','estrella',15,5,2024,12,0,'Baño','P'),('0524018','Ame','Phoebe','justin',30,5,2024,9,0,'Baño','A'),('0524019','Prueba','Phoebe','Kali',31,5,2024,9,0,'Baño','A'),('0524020','Carlos','Arca','Firulais',31,5,2024,9,0,'Baño','A'),('0524021','Andy','Phoebe','Ray',30,5,2024,13,0,'Baño','P'),('0524022','Rosalia','Phoebe','El Mal Querer',9,5,2024,9,0,'Baño','P'),('0524023','anha','Phoebe','gato',30,5,2024,11,0,'Baño','P'),('0524024','anha','Phoebe','gato',14,5,2024,9,0,'Baño','P'),('0524025','maria2','Arca','coco',30,5,2024,13,0,'Baño','P'),('0524026','Sigalita','Arca','Lucas',30,5,2024,11,0,'Baño','P'),('0524027','Guerita','Arca','Rocco',30,5,2024,9,0,'Baño','A'),('0524028','anha2','Phoebe','gato2',31,5,2024,13,0,'Baño','A'),('0524029','Rosalia','Arca','El Mal Querer',5,5,2024,9,0,'Baño','A'),('0624001','Tashi','Beyonce','Tennis',8,6,2024,10,0,'Estetico','A'),('0624002','Guerita','Phoebe','Rocco',3,6,2024,11,0,'Baño','C'),('1224001','Rosalia','Phoebe','El Mal Querer',2,12,2024,9,0,'Baño','A');
/*!40000 ALTER TABLE `citas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `clientes`
--

DROP TABLE IF EXISTS `clientes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `clientes` (
  `usuario` varchar(255) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `nombre` varchar(100) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `apellido` varchar(100) COLLATE utf8mb3_spanish2_ci NOT NULL,
  PRIMARY KEY (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `clientes`
--

LOCK TABLES `clientes` WRITE;
/*!40000 ALTER TABLE `clientes` DISABLE KEYS */;
INSERT INTO `clientes` VALUES ('Ame','ame','Ame','ame'),('Andy','txt','Andrea','Corral '),('anha','1234','anha','chavira'),('anha2','1234','angel','chabvira'),('Art','LoveTashi','Art','Donaldson'),('Carlos','123','Carlosss','Gamboa'),('dani','123','dani','polanco'),('danii','1234','daniela','polanco'),('elphaba','WWoW','elphaba','thropp'),('Ethel','Preacher','Ethel','Cain'),('Fiona','whenthepawn','Fiona','Apple'),('Glinda','Galinda','Glinda','Upland'),('Guerita','Doki123','Liliana','Rosales'),('Jesus','Hola123','Jesus','x'),('lala2','45','lala','esc'),('LanaDelRey','OceanBLDV','Lana','del Rey'),('maria2','123','maria','rdg'),('Patrick','LoveArt','Patrick','Zweig'),('Prueba','Hola123','Jol','hol'),('Rosalia','Motomami','Rosalia','Vita'),('Shakira','FijacionOral','Shakiraa','Mebarak'),('Sigalita','aaron123','Bryan ','Sigala'),('Tashi','Tennis','Tashi','Duncan');
/*!40000 ALTER TABLE `clientes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `correocliente`
--

DROP TABLE IF EXISTS `correocliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `correocliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(255) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `correo` varchar(100) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `usuario` (`usuario`),
  CONSTRAINT `correocliente_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `clientes` (`usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `correocliente`
--

LOCK TABLES `correocliente` WRITE;
/*!40000 ALTER TABLE `correocliente` DISABLE KEYS */;
INSERT INTO `correocliente` VALUES (1,'Ame','jdfklsafjkljadfs'),(2,'Andy','andyg,aiñ.com'),(3,'anha','downgmail.com'),(4,'anha2','downb@gmail.com'),(5,'Art','tashifan@gmail.com'),(6,'Carlos','carlos@gmail.com'),(7,'dani','danipp'),(8,'danii','daniooi'),(9,'Ethel','preachersdaughter@live.com'),(10,'Fiona','tidalpawn@gmail.com'),(11,'Guerita','lili@gmail.com'),(12,'Jesus','jesucorreo'),(13,'lala2','lala123'),(14,'LanaDelRey','borntodie@hotmail.com'),(15,'maria2','maestrgmail.com'),(16,'Patrick','artytashi@gmail.com'),(17,'Prueba','sailudio'),(18,'Rosalia','holamotomami@gmail.com'),(19,'Shakira','shakira@gmail.com'),(20,'Sigalita','bryan@tec.com'),(21,'Tashi','tennis@gmail.com'),(32,'elphaba','wickedwitch@gmail.com'),(33,'Glinda','glinda@glinda.com');
/*!40000 ALTER TABLE `correocliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `correovet`
--

DROP TABLE IF EXISTS `correovet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `correovet` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(255) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `correo` varchar(100) COLLATE utf8mb3_spanish2_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `usuario` (`usuario`),
  CONSTRAINT `correovet_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `veterinarios` (`usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `correovet`
--

LOCK TABLES `correovet` WRITE;
/*!40000 ALTER TABLE `correovet` DISABLE KEYS */;
INSERT INTO `correovet` VALUES (1,'Arca','kick@gmail.com'),(2,'Beyonce','queenb@gmail.com'),(3,'Kali','kaliuchis@gmail.com'),(4,'Phoebe','dogatyourdoor@gmail.com'),(8,'madonna','madona@gmail.com');
/*!40000 ALTER TABLE `correovet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `diagnosticos`
--

DROP TABLE IF EXISTS `diagnosticos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `diagnosticos` (
  `id` varchar(8) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `cita` varchar(7) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `diagnostico` longtext COLLATE utf8mb3_spanish2_ci NOT NULL,
  `precio` double NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cita` (`cita`),
  CONSTRAINT `diagnosticos_ibfk_1` FOREIGN KEY (`cita`) REFERENCES `citas` (`id`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `diagnosticos`
--

LOCK TABLES `diagnosticos` WRITE;
/*!40000 ALTER TABLE `diagnosticos` DISABLE KEYS */;
INSERT INTO `diagnosticos` VALUES ('D0524001','0524001','El Mal Querer está en excelentes condiciones de salud, se recomienda salir de paseo mas a menudo',1500),('D0524002','0524002','Se vacuno a Tennis contra la rabia, y otras enfermedades, se recomienda reposo',3600),('D0524003','0524003','Se corta el cabello y baña a Duncanator. Tratamiento de spa',5000),('D0524004','0524004','Se corta el cabello y bana a Art. Tratamiento nomral',800),('D0524005','0524005','Se esterilizó a Willoughby se le aplican tratamiento y se recetan medicamentos. Se recomienda reposo0',7500),('D0524006','0524006','Se baña a Vape y se le corta el cabello de una manera Lana Del Rey vibes',4892),('D0524008','0524008','Se diagnostica a Ladron. Se receta que su dueña vuelva a sus eras de los incios y que vuelva la Shakira que \nescribió Fijacion Oral, Pies Descalzos, Donde Están Los Ladrones, se cobra extra por dar unsolicited opinions',7800.5),('D0524009','0524009','Se diagnostica a Janet con buena salud. Se felicita a su dueña por su increible\n trayectoria musical y por darnos los mejores albumes. Se cobra menos',1500),('D0524010','0524010','Se corta el cabello y baña a El Mal Querer y se le da un look Motomami',3500),('D0524011','0624001','Hola',5000),('D0524012','0524011','Todo bien con Ladron, pero se vueve a solicitar que vuelva la Shakira que \nescribió Fijacion Oral, Pies Descalzos, Donde Están Los Ladrones, se cobra extra porque Las Mujeres Ya No Lloran fue un album malisimo',9999),('D0524014','0524014','esta resfriado',10000),('D0524016','0524016','DIAGNOSTICOS DE TOBY',5000),('D0524018','0524018','Se le cortaron los huevitos a Justin',2000),('D0524019','0524019','Diagnositocfpo',500),('D0524020','0524020','Diagnostico para firulasi',1500),('D0524027','0524027','Todo bien con rocco esta con sobrepeso, se recomienda ejercicio',500),('D0524028','0524028','prueba diagnostico ',500),('D0524029','0524029','Diagnostico viva motomami\n',10479.46),('D1224001','1224001','Todo bien, todo ok',10000);
/*!40000 ALTER TABLE `diagnosticos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `mascotas`
--

DROP TABLE IF EXISTS `mascotas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `mascotas` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `cliente` varchar(255) COLLATE utf8mb3_spanish2_ci DEFAULT NULL,
  `sexo` varchar(1) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `especie` varchar(50) COLLATE utf8mb3_spanish2_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `cliente` (`cliente`),
  CONSTRAINT `cliente` FOREIGN KEY (`cliente`) REFERENCES `clientes` (`usuario`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `mascotas`
--

LOCK TABLES `mascotas` WRITE;
/*!40000 ALTER TABLE `mascotas` DISABLE KEYS */;
INSERT INTO `mascotas` VALUES (1,'El Mal Querer','Rosalia','H','Gato'),(2,'Mochi','Rosalia','H','Perro'),(3,'Duncanator','Art','M','Perro'),(4,'Tennis','Tashi','H','Gato'),(5,'Art','Patrick','M','Roedor'),(6,'Willoughby','Ethel','M','Ave'),(7,'Vape','LanaDelRey','H','Perro'),(8,'Ladron','Shakira','M','Roedor'),(9,'Janet','Fiona','H','Perro'),(11,'Chicken Teriyaki','Rosalia','H','Ave'),(12,'coco','dani','H','Ave'),(13,'pol','lala2','M','Perro'),(14,'Toby',NULL,'M','Perro'),(15,'estrella','danii','H','Gato'),(16,'Pekita','Jesus','H','Ave'),(17,'justin','Ame','M','Perro'),(18,'Kali','Prueba','M','Perro'),(19,'Firulais','Carlos','M','Perro'),(20,'Ray','Andy','H','Gato'),(21,'gato','anha','H','Gato'),(22,'luis','anha','M','Perro'),(23,'coco','maria2','M','Gato'),(24,'coco3','maria2','H','Gato'),(25,'Lucas','Sigalita','M','Ave'),(26,'julio','Sigalita','H','Gato'),(27,'Rocco','Guerita','M','Perro'),(28,'gato2','anha2','H','Gato'),(29,'Omega','Rosalia','M','Perro'),(30,'Toto','Glinda','M','Perro');
/*!40000 ALTER TABLE `mascotas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telcliente`
--

DROP TABLE IF EXISTS `telcliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telcliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(255) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `telefono` varchar(10) COLLATE utf8mb3_spanish2_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `usuario` (`usuario`),
  CONSTRAINT `telcliente_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `clientes` (`usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telcliente`
--

LOCK TABLES `telcliente` WRITE;
/*!40000 ALTER TABLE `telcliente` DISABLE KEYS */;
INSERT INTO `telcliente` VALUES (1,'Ame','6154685446'),(2,'Andy','1234567'),(3,'anha','612423331'),(4,'anha2','61423213'),(5,'Art','6148532020'),(6,'Carlos','6142301891'),(7,'dani','6146046755'),(8,'danii','6556565'),(9,'Ethel','6147916820'),(10,'Fiona','6147894510'),(11,'Guerita','6142541405'),(12,'Jesus','6145647897'),(13,'lala2','614'),(14,'LanaDelRey','6142846810'),(15,'maria2','1231234124'),(16,'Patrick','6141234567'),(17,'Prueba','6142316800'),(18,'Rosalia','6145823879'),(19,'Shakira','6147891235'),(20,'Sigalita','6148885326'),(21,'Tashi','6142304891'),(32,'elphaba','6145681'),(33,'Glinda','6148648');
/*!40000 ALTER TABLE `telcliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `telvet`
--

DROP TABLE IF EXISTS `telvet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `telvet` (
  `id` int NOT NULL AUTO_INCREMENT,
  `usuario` varchar(255) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `telefono` varchar(10) COLLATE utf8mb3_spanish2_ci NOT NULL,
  PRIMARY KEY (`id`),
  KEY `usuario` (`usuario`),
  CONSTRAINT `telvet_ibfk_1` FOREIGN KEY (`usuario`) REFERENCES `veterinarios` (`usuario`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `telvet`
--

LOCK TABLES `telvet` WRITE;
/*!40000 ALTER TABLE `telvet` DISABLE KEYS */;
INSERT INTO `telvet` VALUES (1,'Arca','6147891050'),(2,'Beyonce','6147894152'),(3,'Kali','6141234795'),(4,'Phoebe','6145821030'),(8,'madonna','6142318149');
/*!40000 ALTER TABLE `telvet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `veterinarios`
--

DROP TABLE IF EXISTS `veterinarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `veterinarios` (
  `usuario` varchar(255) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `nombre` varchar(100) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `apellido` varchar(100) COLLATE utf8mb3_spanish2_ci NOT NULL,
  `sueldo` double NOT NULL,
  `cedula` varchar(50) COLLATE utf8mb3_spanish2_ci NOT NULL,
  PRIMARY KEY (`usuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_spanish2_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `veterinarios`
--

LOCK TABLES `veterinarios` WRITE;
/*!40000 ALTER TABLE `veterinarios` DISABLE KEYS */;
INSERT INTO `veterinarios` VALUES ('Arca','kiick','Arca','Ghersi',12000,'ARCAAAA'),('Beyonce','QueenB','Beyonce','Knowles-Carter',11800.5,'BEY5893'),('Kali','Orquideas','Kali','Uchis',10500,'CED0101'),('madonna','madonna','madonna','madonna',6235.5,'LKAVRGIN'),('Phoebe','MoonSong','Phoebe','Bridgers',10200,'SCT75U93');
/*!40000 ALTER TABLE `veterinarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-12-01 20:27:24
