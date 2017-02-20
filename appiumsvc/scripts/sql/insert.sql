-- MySQL dump 10.13  Distrib 5.7.9, for Win64 (x86_64)
--
-- Host: localhost    Database: cleansmiles
-- ------------------------------------------------------
-- Server version	5.7.9-log

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
-- Dumping data for table `city`
--

LOCK TABLES `city` WRITE;
/*!40000 ALTER TABLE `city` DISABLE KEYS */;
INSERT INTO `city` VALUES (1,'Delhi',1),(4,'Lucknow',1);
/*!40000 ALTER TABLE `city` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `country`
--

LOCK TABLES `country` WRITE;
/*!40000 ALTER TABLE `country` DISABLE KEYS */;
INSERT INTO `country` VALUES (1,'India','Asia'),(2,'USA','Americas'),(3,'France','Europe'),(4,'UK','Europe'),(5,'Canada','Americas'),(6,'Banglades','Asia'),(7,'Sri Lanka','Asia');
/*!40000 ALTER TABLE `country` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `regiondata`
--

LOCK TABLES `regiondata` WRITE;
/*!40000 ALTER TABLE `regiondata` DISABLE KEYS */;
/*!40000 ALTER TABLE `regiondata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `vendordata`
--

LOCK TABLES `vendordata` WRITE;
/*!40000 ALTER TABLE `vendordata` DISABLE KEYS */;
INSERT INTO `vendordata` VALUES (1,'Alpha','BVQPB3465A','A',2,1,NULL,NULL),(2,'Beta','BVQPB3469A','A',2,1,NULL,NULL);
/*!40000 ALTER TABLE `vendordata` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping data for table `vendorlist`
--

LOCK TABLES `vendorlist` WRITE;
/*!40000 ALTER TABLE `vendorlist` DISABLE KEYS */;
INSERT INTO `vendorlist` VALUES (1,'Alpha',0),(2,'Beta',0),(3,'Gamma',0);
/*!40000 ALTER TABLE `vendorlist` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-02-20 23:30:09
