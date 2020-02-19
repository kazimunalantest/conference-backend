-- MySQL dump 10.13  Distrib 5.6.40, for macos10.13 (x86_64)
--
-- Host: 127.0.0.1    Database: n11db
-- ------------------------------------------------------
-- Server version	5.6.40

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
-- Table structure for table `event`
--

DROP TABLE IF EXISTS `event`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `event` (
  `oid` varchar(32) NOT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  `content` varchar(255) DEFAULT NULL,
  `header` varchar(255) NOT NULL,
  `presentation_time` varchar(255) NOT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `event`
--

-- LOCK TABLES `event` WRITE;
-- /*!40000 ALTER TABLE `event` DISABLE KEYS */;
-- INSERT INTO `event` VALUES ('402881e4704cb91501704cb95b2f0000','2020-02-16 06:39:41',NULL,'-','Architecting Your Codebase','60min'),('402881e4704cb91501704cb9a6260001','2020-02-16 06:40:00',NULL,'-','Overdoing it in Python','45min'),('402881e4704cb91501704cb9a6270002','2020-02-16 06:40:00',NULL,'-','Flavors of Concurrency in Java','30min'),('402881e4704cb91501704cb9a6270003','2020-02-16 06:40:00',NULL,'-','Ruby Errors from Mismatched Gem Versions','45min'),('402881e4704cb91501704cb9a6270004','2020-02-16 06:40:00',NULL,'-','JUnit 5 - Shaping the Future of Testing on the JVM','60min'),('402881e4704cb91501704cb9a6270005','2020-02-16 06:40:00','2020-02-16 09:04:06','-','Cloud Native Java lightning','5min'),('402881e4704cb91501704cb9a6270006','2020-02-16 06:40:00',NULL,'-','Communicating Over Distance','60min'),('402881e4704cb91501704cb9a6270007','2020-02-16 06:40:00',NULL,'-','AWS Technical Essentials','45min'),('402881e4704cb91501704cb9a6270008','2020-02-16 06:40:00',NULL,'-','Continuous Delivery','30min'),('402881e4704cb91501704cb9a6270009','2020-02-16 06:40:00',NULL,'-','Monitoring Reactive Applications','30min'),('402881e4704cb91501704cb9a628000a','2020-02-16 06:40:00',NULL,'-','Pair Programming vs Noise','45min'),('402881e4704cb91501704cb9a628000b','2020-02-16 06:40:00',NULL,'-','Rails Magic','60min'),('402881e4704cb91501704cb9a628000c','2020-02-16 06:40:00',NULL,'-','Microservices Just Right','60min'),('402881e4704cb91501704cb9a628000d','2020-02-16 06:40:00',NULL,'-','Clojure Ate Scala (on my project)','45min'),('402881e4704cb91501704cb9a628000e','2020-02-16 06:40:00',NULL,'-','Perfect Scalability','30min'),('402881e4704cb91501704cb9a629000f','2020-02-16 06:40:00',NULL,'-','Apache Spark','30min'),('402881e4704cb91501704cb9a6290010','2020-02-16 06:40:00',NULL,'-','Async Testing on JVM','60min'),('402881e4704cb91501704cb9a6290011','2020-02-16 06:40:00',NULL,'-','A World Without HackerNews','30min'),('402881e4704cb91501704cb9a6290012','2020-02-16 06:40:00',NULL,'-','User Interface CSS in Apps','30min'),('8ae4800b70570c0d0170570c23ad0000','2020-02-18 06:46:18','2020-02-18 06:46:18',NULL,'Test','60min'),('8ae4800b7057dc72017057dc836c0000','2020-02-18 10:33:54','2020-02-18 10:33:55',NULL,'Test','60min');
-- /*!40000 ALTER TABLE `event` ENABLE KEYS */;
-- UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-18 18:13:24
