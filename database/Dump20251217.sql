CREATE DATABASE  IF NOT EXISTS `matchingcardgame` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `matchingcardgame`;
-- MySQL dump 10.13  Distrib 8.0.13, for Win64 (x86_64)
--
-- Host: localhost    Database: matchingcardgame
-- ------------------------------------------------------
-- Server version	8.0.13

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
 SET NAMES utf8 ;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `images`
--

DROP TABLE IF EXISTS `images`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `images` (
  `imageID` int(11) NOT NULL AUTO_INCREMENT,
  `path` varchar(255) NOT NULL,
  PRIMARY KEY (`imageID`),
  UNIQUE KEY `path` (`path`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `images`
--

LOCK TABLES `images` WRITE;
/*!40000 ALTER TABLE `images` DISABLE KEYS */;
INSERT INTO `images` VALUES (1,'memory game images/image-1.png'),(10,'memory game images/image-10.png'),(11,'memory game images/image-11.png'),(12,'memory game images/image-12.png'),(13,'memory game images/image-13.png'),(14,'memory game images/image-14.png'),(15,'memory game images/image-15.png'),(2,'memory game images/image-2.png'),(3,'memory game images/image-3.png'),(4,'memory game images/image-4.png'),(5,'memory game images/image-5.png'),(6,'memory game images/image-6.png'),(7,'memory game images/image-7.png'),(8,'memory game images/image-8.png'),(9,'memory game images/image-9.png');
/*!40000 ALTER TABLE `images` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `levels`
--

DROP TABLE IF EXISTS `levels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `levels` (
  `levelNumber` int(11) NOT NULL,
  `totalTime` int(11) NOT NULL,
  `totalCards` int(11) NOT NULL,
  `firstStarTime` int(11) NOT NULL,
  `secondStarTime` int(11) NOT NULL,
  `thirdStarTime` int(11) NOT NULL,
  PRIMARY KEY (`levelNumber`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `levels`
--

LOCK TABLES `levels` WRITE;
/*!40000 ALTER TABLE `levels` DISABLE KEYS */;
INSERT INTO `levels` VALUES (1,60,4,15,30,45),(2,60,6,15,35,50),(3,75,8,20,40,60),(4,75,12,20,45,60),(5,90,16,20,50,65),(6,105,12,20,55,70),(7,120,16,25,60,70),(8,120,20,30,55,80),(9,135,24,40,75,105),(10,150,28,60,90,120),(11,105,12,60,70,80),(12,110,16,65,75,90),(13,90,20,40,50,65),(14,100,24,55,65,75),(15,90,28,50,60,70);
/*!40000 ALTER TABLE `levels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `levelscore`
--

DROP TABLE IF EXISTS `levelscore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `levelscore` (
  `playerID` int(11) NOT NULL,
  `levelNumber` int(11) NOT NULL,
  `score` int(11) NOT NULL,
  `timeLeft` int(11) NOT NULL,
  `stars` int(11) NOT NULL,
  PRIMARY KEY (`playerID`,`levelNumber`),
  KEY `fk_levelScore_level` (`levelNumber`),
  CONSTRAINT `fk_levelScore_level` FOREIGN KEY (`levelNumber`) REFERENCES `levels` (`levelnumber`) ON DELETE CASCADE,
  CONSTRAINT `fk_levelScore_player` FOREIGN KEY (`playerID`) REFERENCES `players` (`playerid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `levelscore`
--

LOCK TABLES `levelscore` WRITE;
/*!40000 ALTER TABLE `levelscore` DISABLE KEYS */;
INSERT INTO `levelscore` VALUES (1,1,150,30,2),(2,2,225,45,2),(2,3,75,15,0),(3,5,100,20,1),(3,7,350,70,3);
/*!40000 ALTER TABLE `levelscore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `players`
--

DROP TABLE IF EXISTS `players`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `players` (
  `playerID` int(11) NOT NULL AUTO_INCREMENT,
  `totalScores` int(11) DEFAULT '0',
  PRIMARY KEY (`playerID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `players`
--

LOCK TABLES `players` WRITE;
/*!40000 ALTER TABLE `players` DISABLE KEYS */;
INSERT INTO `players` VALUES (1,150),(2,300),(3,450);
/*!40000 ALTER TABLE `players` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `savedlevels`
--

DROP TABLE IF EXISTS `savedlevels`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `savedlevels` (
  `levelID` int(11) NOT NULL AUTO_INCREMENT,
  `playerID` int(11) NOT NULL,
  `levelNumber` int(11) NOT NULL,
  `savedDate` date NOT NULL,
  PRIMARY KEY (`levelID`),
  KEY `fk_savedLevels_player` (`playerID`),
  KEY `fk_savedLevels_level` (`levelNumber`),
  CONSTRAINT `fk_savedLevels_level` FOREIGN KEY (`levelNumber`) REFERENCES `levels` (`levelnumber`) ON DELETE CASCADE,
  CONSTRAINT `fk_savedLevels_player` FOREIGN KEY (`playerID`) REFERENCES `players` (`playerid`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `savedlevels`
--

LOCK TABLES `savedlevels` WRITE;
/*!40000 ALTER TABLE `savedlevels` DISABLE KEYS */;
INSERT INTO `savedlevels` VALUES (1,1,1,'2025-12-09'),(2,1,6,'2025-12-10'),(3,1,9,'2025-12-11'),(4,3,3,'2025-12-09'),(5,3,3,'2025-12-10'),(6,3,15,'2025-12-12'),(7,3,11,'2025-12-12');
/*!40000 ALTER TABLE `savedlevels` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `savedlevelsrecords`
--

DROP TABLE IF EXISTS `savedlevelsrecords`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `savedlevelsrecords` (
  `levelID` int(11) NOT NULL,
  `imageID` int(11) NOT NULL,
  `cardNumber` int(11) NOT NULL,
  PRIMARY KEY (`levelID`,`imageID`,`cardNumber`),
  KEY `fk_records_images` (`imageID`),
  CONSTRAINT `fk_records_images` FOREIGN KEY (`imageID`) REFERENCES `images` (`imageid`) ON DELETE CASCADE,
  CONSTRAINT `fk_records_savedLevels` FOREIGN KEY (`levelID`) REFERENCES `savedlevels` (`levelid`) ON DELETE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `savedlevelsrecords`
--

LOCK TABLES `savedlevelsrecords` WRITE;
/*!40000 ALTER TABLE `savedlevelsrecords` DISABLE KEYS */;
INSERT INTO `savedlevelsrecords` VALUES (1,1,1),(1,1,3),(3,1,1),(3,1,5),(3,1,14),(3,1,23),(6,1,1),(6,1,5),(6,1,20),(1,2,2),(1,2,4),(3,2,3),(3,2,7),(3,2,16),(3,2,24),(6,2,2),(6,2,7),(6,2,22),(2,3,1),(2,3,3),(2,3,9),(3,3,2),(3,3,9),(3,3,18),(6,3,3),(6,3,9),(6,3,24),(2,4,2),(2,4,5),(2,4,10),(3,4,4),(3,4,11),(3,4,20),(6,4,4),(6,4,11),(6,4,26),(2,5,4),(2,5,7),(2,5,11),(3,5,6),(3,5,13),(3,5,21),(6,5,6),(6,5,13),(6,5,27),(7,5,1),(7,5,3),(7,5,10),(2,6,6),(2,6,8),(2,6,12),(3,6,8),(3,6,15),(3,6,22),(6,6,8),(6,6,15),(6,6,28),(7,6,2),(7,6,5),(7,6,12),(3,7,10),(3,7,17),(6,7,10),(6,7,17),(7,7,4),(7,7,7),(3,8,12),(3,8,19),(6,8,12),(6,8,19),(7,8,6),(7,8,9),(4,9,1),(4,9,3),(4,9,6),(4,9,8),(6,9,14),(6,9,21),(7,9,8),(7,9,11),(4,10,2),(4,10,5),(6,10,16),(6,10,23),(4,11,4),(4,11,7),(6,11,18),(6,11,25),(5,12,1),(5,12,3),(5,12,6),(5,12,8),(5,13,2),(5,13,5),(5,14,4),(5,14,7);
/*!40000 ALTER TABLE `savedlevelsrecords` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `users` (
  `username` varchar(50) NOT NULL,
  `playerID` int(11) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `gender` varchar(10) DEFAULT NULL,
  `phoneNumber` varchar(10) DEFAULT NULL,
  `isAdmin` int(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`username`),
  KEY `fk_users_player` (`playerID`),
  CONSTRAINT `fk_users_player` FOREIGN KEY (`playerID`) REFERENCES `players` (`playerid`) ON DELETE SET NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('admin',NULL,'admin123','M','0544412310',1),('player1',1,'pass1','M','0512345678',0),('player2',2,'pass2','F','0598765432',0),('player3',3,'pass3','M','0509876543',0);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-12-17 20:02:19
