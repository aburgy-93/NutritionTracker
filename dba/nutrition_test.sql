-- MySQL dump 10.13  Distrib 9.2.0, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: nutrition_test
-- ------------------------------------------------------
-- Server version	9.2.0

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `food_table`
--

DROP TABLE IF EXISTS `food_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food_table` (
                              `id` int NOT NULL AUTO_INCREMENT,
                              `food_name` varchar(100) NOT NULL,
                              `food_type` varchar(25) DEFAULT NULL,
                              `serving_size` int NOT NULL,
                              `serving_name` varchar(10) NOT NULL,
                              `calories` int NOT NULL,
                              `fat` decimal(5,2) NOT NULL,
                              `carbs` decimal(5,2) NOT NULL,
                              `protein` decimal(5,2) NOT NULL,
                              PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food_table`
--

LOCK TABLES `food_table` WRITE;
/*!40000 ALTER TABLE `food_table` DISABLE KEYS */;
INSERT INTO `food_table` VALUES (1,'Chicken Breast','Meat',1,'Ounce',37,0.30,0.00,8.50),(2,'White Rice','Grain',1,'Cup',242,0.40,53.00,4.30);
/*!40000 ALTER TABLE `food_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food_tracker`
--

DROP TABLE IF EXISTS `food_tracker`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food_tracker` (
                                `id` int NOT NULL AUTO_INCREMENT,
                                `user_id` int NOT NULL,
                                `food_id` int NOT NULL,
                                `date` date NOT NULL,
                                `serving_size` int NOT NULL,
                                `meal_time` varchar(50) NOT NULL,
                                `total_calories` double NOT NULL,
                                `total_protein` decimal(5,2) NOT NULL,
                                `total_carbs` decimal(5,2) NOT NULL,
                                `total_fat` decimal(5,2) NOT NULL,
                                PRIMARY KEY (`id`),
                                KEY `user_id` (`user_id`),
                                KEY `food_id` (`food_id`),
                                CONSTRAINT `food_tracker_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `food_user` (`id`) ON DELETE CASCADE,
                                CONSTRAINT `food_tracker_ibfk_2` FOREIGN KEY (`food_id`) REFERENCES `food_table` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food_tracker`
--

LOCK TABLES `food_tracker` WRITE;
/*!40000 ALTER TABLE `food_tracker` DISABLE KEYS */;
INSERT INTO `food_tracker` VALUES (1,1,1,'2025-02-15',5,'Lunch',185.0,43.0,0,2.0), (2, 1, 2, '2025-02-20', 1, 'Lunch', 242, 4.3, 53.0, 0.4);
/*!40000 ALTER TABLE `food_tracker` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `food_user`
--

DROP TABLE IF EXISTS `food_user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `food_user` (
                             `id` int NOT NULL AUTO_INCREMENT,
                             `access_privileges` varchar(55) NOT NULL DEFAULT 'user',
                             `first_name` varchar(255) NOT NULL,
                             `last_name` varchar(255) NOT NULL,
                             `email` varchar(50) DEFAULT NULL,
                             `user_weight` int DEFAULT NULL,
                             `birthDate` varchar(15) DEFAULT NULL,
                             PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `food_user`
--

LOCK TABLES `food_user` WRITE;
/*!40000 ALTER TABLE `food_user` DISABLE KEYS */;
INSERT INTO `food_user` VALUES (1,'admin','Alex','Burgy','aburgy@madisoncollege.edu',200,'1/01/1984');
/*!40000 ALTER TABLE `food_user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-02-20 10:18:50
