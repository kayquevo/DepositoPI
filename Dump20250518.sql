-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: coursejdbc
-- ------------------------------------------------------
-- Server version	9.2.0

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
-- Table structure for table `estoque`
--

DROP TABLE IF EXISTS `estoque`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estoque` (
  `freezer_id` int NOT NULL,
  `item_id` int NOT NULL,
  `quantidade` int DEFAULT NULL,
  PRIMARY KEY (`freezer_id`,`item_id`),
  KEY `item_id` (`item_id`),
  CONSTRAINT `estoque_ibfk_1` FOREIGN KEY (`freezer_id`) REFERENCES `freezers` (`id`),
  CONSTRAINT `estoque_ibfk_2` FOREIGN KEY (`item_id`) REFERENCES `itens` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estoque`
--

LOCK TABLES `estoque` WRITE;
/*!40000 ALTER TABLE `estoque` DISABLE KEYS */;
INSERT INTO `estoque` VALUES (1,4,16),(1,5,9),(1,7,0),(1,8,0),(1,9,0),(1,10,4),(1,11,0),(2,6,0),(2,12,0),(2,13,0),(2,14,0),(2,15,0),(2,16,0),(2,17,0),(2,18,0),(2,19,0),(3,20,0),(3,21,0),(3,22,0),(3,23,0),(3,24,0),(3,25,0),(3,26,0),(3,27,0),(3,28,0),(3,29,0),(4,30,0),(5,31,6),(5,32,4),(5,33,4),(5,34,0),(5,35,0),(5,36,0),(5,37,0),(5,38,0),(5,40,0),(5,41,0),(5,42,0),(5,43,0);
/*!40000 ALTER TABLE `estoque` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `freezers`
--

DROP TABLE IF EXISTS `freezers`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `freezers` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `freezers`
--

LOCK TABLES `freezers` WRITE;
/*!40000 ALTER TABLE `freezers` DISABLE KEYS */;
INSERT INTO `freezers` VALUES (1,'Freezer1'),(2,'Freezer2'),(3,'Freezer3'),(4,'Freezer4'),(5,'Geladeira');
/*!40000 ALTER TABLE `freezers` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `itens`
--

DROP TABLE IF EXISTS `itens`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `itens` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `itens`
--

LOCK TABLES `itens` WRITE;
/*!40000 ALTER TABLE `itens` DISABLE KEYS */;
INSERT INTO `itens` VALUES (3,'Largato'),(4,'Largato'),(5,'Filé Mion'),(6,'Fritas'),(7,'Picanha'),(8,'Frango'),(9,'Salsicha'),(10,'Brócolis'),(11,'Calabresa'),(12,'Hfraudinha'),(13,'Hpicanha'),(14,'Coxa sobre Coxa'),(15,'Pmaracujá'),(16,'Pamora'),(17,'Pmorango'),(18,'P uva'),(19,'Pcaju'),(20,'S Creme'),(21,'B Creme'),(22,'S Chocolate'),(23,'B Chocolate'),(24,'S Morango'),(25,'B Coco'),(26,'B Flocos'),(27,'B Pistache'),(28,'Apple Pie'),(29,'Petit gâteau'),(30,'Gelo'),(31,'Queijo P'),(32,'Mussarela'),(33,'Peru'),(34,'Presunto'),(35,'Bufála M'),(36,'Búfala S'),(37,'Catupiry'),(38,'Queijo Cheddar'),(39,'Parma'),(40,'Parma'),(41,'Legumes /C'),(42,'Pepino /C'),(43,'Tomate Seco');
/*!40000 ALTER TABLE `itens` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-05-18 18:16:53
