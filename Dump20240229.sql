-- MySQL dump 10.13  Distrib 8.0.34, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: mydb
-- ------------------------------------------------------
-- Server version	8.2.0

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
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `name` varchar(25) NOT NULL,
  `employeeInCharge` varchar(25) NOT NULL,
  `phoneNumber` varchar(10) NOT NULL,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `employeeInCharge` (`employeeInCharge`),
  KEY `companyname` (`name`),
  CONSTRAINT `company_ibfk_1` FOREIGN KEY (`employeeInCharge`) REFERENCES `register` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=12 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES ('trial 1','trial','123456',9),('trial 2 ','hello','123456',11);
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `companyregistration`
--

DROP TABLE IF EXISTS `companyregistration`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `companyregistration` (
  `company` varchar(25) DEFAULT NULL,
  `accountant` varchar(25) DEFAULT NULL,
  `date` date NOT NULL,
  `certificate` blob,
  `boj5` blob,
  `isic` blob,
  `loanAgreement` blob,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `companyname` (`company`),
  CONSTRAINT `companyregistration_ibfk_1` FOREIGN KEY (`company`) REFERENCES `company` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `companyregistration`
--

LOCK TABLES `companyregistration` WRITE;
/*!40000 ALTER TABLE `companyregistration` DISABLE KEYS */;
INSERT INTO `companyregistration` VALUES ('trial 1','inging','2024-01-09',_binary 'Test 4 (2).png',_binary 'Test 3 (2).xlsx',_binary 'Test 2 (2).docx',_binary 'Test 1 (2).pdf',12),('trial 1','hi','2024-02-22',_binary 'IngIng - Global IA (1).pdf',_binary 'Screenshot 2024-02-22 171312.png',_binary 'LoginFlowchart.png',_binary 'IngIng - Math IA (2).pdf',13);
/*!40000 ALTER TABLE `companyregistration` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `financialstatement`
--

DROP TABLE IF EXISTS `financialstatement`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `financialstatement` (
  `company` varchar(25) DEFAULT NULL,
  `year` int DEFAULT NULL,
  `excelStatement` blob,
  `pdfStatement` blob,
  `vatSummary` blob,
  `pnd50` blob,
  `excelProfitAndInterest` blob,
  `id` int NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  KEY `company` (`company`),
  CONSTRAINT `financialstatement_ibfk_1` FOREIGN KEY (`company`) REFERENCES `company` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `financialstatement`
--

LOCK TABLES `financialstatement` WRITE;
/*!40000 ALTER TABLE `financialstatement` DISABLE KEYS */;
INSERT INTO `financialstatement` VALUES ('trial 1',2003,_binary 'IngIng - Global IA (1).pdf',_binary 'IngIng - Macro IA (2).pdf',_binary 'IngIng - Micro IA.pdf',_binary '2684_0.jpg',_binary 'Test 3 (1).xlsx',8);
/*!40000 ALTER TABLE `financialstatement` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `register`
--

DROP TABLE IF EXISTS `register`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `register` (
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `mobileNum` varchar(10) NOT NULL,
  `access` varchar(25) DEFAULT NULL,
  PRIMARY KEY (`username`),
  KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `register`
--

LOCK TABLES `register` WRITE;
/*!40000 ALTER TABLE `register` DISABLE KEYS */;
INSERT INTO `register` VALUES ('hi','hello','hello','1234','123@gmail.com','12345','Manager'),('Inging','L','hi','1234','123@gmail.com','12345','null'),('Inging','L','iii','1234','123@gmail.com','12345','null'),('I','L','inging','12345','iiinging49@gmail.com','0622615461','Manager'),('hi','hello','it','1234','123@gmail.com','12345','null'),('Pattaraporn','Chaijumroonpun','Joe','12345','utt_joe@hotmail.com','0818888530','Admin'),('w','f','rr','12','iiinging49@gmail.com','0622615461','Viewer'),('trial','trial','trial','1234','1234@gmail.com','123456','Manager');
/*!40000 ALTER TABLE `register` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2024-02-29 13:39:15
