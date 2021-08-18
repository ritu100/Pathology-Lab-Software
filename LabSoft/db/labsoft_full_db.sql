CREATE DATABASE  IF NOT EXISTS `labsoft` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */;
USE `labsoft`;
-- MySQL dump 10.13  Distrib 8.0.12, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: labsoft
-- ------------------------------------------------------
-- Server version	8.0.12

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
-- Table structure for table `tab_company_names`
--

DROP TABLE IF EXISTS `tab_company_names`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tab_company_names` (
  `cmp_id` int(11) NOT NULL AUTO_INCREMENT,
  `cmp_name` varchar(100) NOT NULL,
  PRIMARY KEY (`cmp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_company_names`
--

LOCK TABLES `tab_company_names` WRITE;
/*!40000 ALTER TABLE `tab_company_names` DISABLE KEYS */;
INSERT INTO `tab_company_names` VALUES (1,'CiplaDen'),(2,'Arihant Lab Services');
/*!40000 ALTER TABLE `tab_company_names` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_doctors_info`
--

DROP TABLE IF EXISTS `tab_doctors_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tab_doctors_info` (
  `doc_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `doc_name` varchar(100) NOT NULL,
  `doc_address` varchar(250) DEFAULT 'Nashik, Maharashtra, India - 422101',
  `doc_email` varchar(100) DEFAULT NULL,
  `doc_contact1` decimal(10,0) NOT NULL,
  `doc_contact2` decimal(10,0) DEFAULT '0',
  `doc_graduation` varchar(10) NOT NULL,
  `doc_pg` varchar(10) DEFAULT NULL,
  `doc_other_edu` varchar(100) DEFAULT NULL,
  `doc_hospital` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`doc_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_doctors_info`
--

LOCK TABLES `tab_doctors_info` WRITE;
/*!40000 ALTER TABLE `tab_doctors_info` DISABLE KEYS */;
INSERT INTO `tab_doctors_info` VALUES (1,'Dr. Ajay Jagtap','Nashik Road','ajay@gmail.com',9822993815,9689862684,'MBBS','MD','Diploma in Pediatrics','Sanjivan Hospital'),(2,'Dr. Rutuja Jadhav','Bytco, Jail Road, Nashik Road','rutuja@outlook.com',9422474233,0,'BAMS','MS','Diploma','Mayura Health Care'),(3,'Dr. Anil Kakade','Shlimar, CBS, Nashik.','anil@gmail.com',9958689535,7350896556,'MBBS','MS','none','Sai Hospital'),(4,'Dr. Vijay Jadhav','Bytco Point, Jailroad, Nashik Raod, Nashik.','vijay@gmail.com',9689278932,9822568945,'MBBS','MD','DGO','Vedant Healthcare'),(5,'Dr. Dinesh Borade','Smangaon Road, Near Govt Poly, Nashik.','dinesh@gmail.com',9852456963,7365984211,'BDS','MS','DGO','Shree Ram Netralaya'),(6,'Dr. Manisha Nerkar','Nandur Naka, Bapat Road, Nashik Road.','manisha@gmail.com',1234567891,9876543219,'MBBS','MD','none','Rose Eye'),(7,'Dr. Jayant Sathe','Mumbai Naka, Nashik, Maha.','jayant@d.com',1245896321,4587956321,'MBBS','MD','none','none'),(8,'Dr. Abhijit Pawar','Pavan Nagar, Panchvati, Nashik.','abhijit@gmail.com',5269854256,9536251456,'MBBS','MD','no','no'),(9,'Dr. Ajit Kale','Nashik Road, Nashik, Maha.','ajit@kale.com',4589752352,4589632158,'MBBS','MD','none','none'),(10,'Dr. Pramod Patil','Meri Colony, Dindori Road, Panchavati.','pramod@voot.com',5864985655,2565694236,'MBBS','MD','none','none'),(11,'Dr. Mayuri Patil','Kamatwade, Uttam Nagar, Nashik.','mayuri@izeal.com',1237894560,4569631470,'MBBS','MD','CCH','Patil Clinic'),(12,'Dr. Niharika Thete','Sardar Enclave, Jai Bhavani Road, Nashik Road.','neha@gmail.com',5248613975,6324895671,'MBBS','MD','Eye Tech.','Ganraj Rugnalaya'),(13,'Dr. Manasi Naikeade','Jatra Hotel, Konark Nagar, Nashik.','manasi@gmail.com',8546984565,2495681235,'BHMS','MS','none','clinic'),(14,'Dr. Anup Malave','Adgaon Naka, Panchavati, Nashik.','anup@gmail.com',8426971346,2486753951,'BAMS','MD','DGO','Sadguru');
/*!40000 ALTER TABLE `tab_doctors_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_major_issues`
--

DROP TABLE IF EXISTS `tab_major_issues`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tab_major_issues` (
  `issue_id` int(11) NOT NULL AUTO_INCREMENT,
  `issue_name` varchar(100) NOT NULL,
  PRIMARY KEY (`issue_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_major_issues`
--

LOCK TABLES `tab_major_issues` WRITE;
/*!40000 ALTER TABLE `tab_major_issues` DISABLE KEYS */;
INSERT INTO `tab_major_issues` VALUES (1,'Diabetics'),(2,'Blood Pressure'),(3,'Kidney Stone'),(4,'Low Blood Pressure'),(5,'Asthama'),(6,'Backpain');
/*!40000 ALTER TABLE `tab_major_issues` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tab_patients_info`
--

DROP TABLE IF EXISTS `tab_patients_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tab_patients_info` (
  `p_id` int(11) NOT NULL AUTO_INCREMENT,
  `p_name` varchar(100) NOT NULL,
  `p_add1` varchar(50) DEFAULT NULL,
  `p_add2` varchar(50) DEFAULT NULL,
  `p_add3` varchar(50) DEFAULT NULL,
  `p_email` varchar(100) NOT NULL,
  `p_contact1` decimal(10,0) NOT NULL,
  `p_contact2` decimal(10,0) NOT NULL,
  `p_ocp` varchar(50) DEFAULT NULL,
  `p_dob` varchar(50) DEFAULT NULL,
  `p_age` int(11) DEFAULT NULL,
  `p_issue` varchar(50) DEFAULT NULL,
  `p_familydoc` varchar(100) DEFAULT NULL,
  `p_other` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`p_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tab_patients_info`
--

LOCK TABLES `tab_patients_info` WRITE;
/*!40000 ALTER TABLE `tab_patients_info` DISABLE KEYS */;
INSERT INTO `tab_patients_info` VALUES (1,'Mr. Anil Shelar','E - 50, Swamini Apt.','Konark Nagar','Nashik','anil@gmail.com',9822993815,9422473342,'Service','08-03-1991',27,'Blood Pressure','Dr. Rutuja Jadhav','Cough and Fever'),(2,'Mrs. Mangala Taru','Seva Sadan','Bytco Point','Nashik Road','mangala@gmail.com',9822568974,9453869571,'Manager','17-11-1965',53,'Diabetics','Dr. Jayant Sathe','none');
/*!40000 ALTER TABLE `tab_patients_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_form_details`
--

DROP TABLE IF EXISTS `tbl_form_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_form_details` (
  `form_id` int(11) DEFAULT NULL,
  `test_id` int(11) DEFAULT NULL,
  `test_name` varchar(45) DEFAULT NULL,
  `test_cat` varchar(45) DEFAULT NULL,
  `test_subcat` varchar(45) DEFAULT NULL,
  `test_exam` varchar(45) DEFAULT NULL,
  `test_factor` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_form_details`
--

LOCK TABLES `tbl_form_details` WRITE;
/*!40000 ALTER TABLE `tbl_form_details` DISABLE KEYS */;
INSERT INTO `tbl_form_details` VALUES (1,1,'CBC','Hematology','None','Examinition of Blood','CBC Blood Cell'),(1,1,'CBC','Hematology','None','Examinition of Blood','Random Sugar');
/*!40000 ALTER TABLE `tbl_form_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_form_main`
--

DROP TABLE IF EXISTS `tbl_form_main`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_form_main` (
  `form_id` int(11) NOT NULL AUTO_INCREMENT,
  `form_date` varchar(45) DEFAULT NULL,
  `pat_id` int(11) DEFAULT NULL,
  `pat_name` varchar(45) DEFAULT NULL,
  `pat_email` varchar(50) DEFAULT NULL,
  `pat_contact` decimal(10,0) DEFAULT NULL,
  `pat_age` int(11) DEFAULT NULL,
  `doc_id` int(11) DEFAULT NULL,
  `doc_name` varchar(45) DEFAULT NULL,
  `is_active` int(11) DEFAULT '1',
  PRIMARY KEY (`form_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_form_main`
--

LOCK TABLES `tbl_form_main` WRITE;
/*!40000 ALTER TABLE `tbl_form_main` DISABLE KEYS */;
INSERT INTO `tbl_form_main` VALUES (1,'28-02-2019',1,'Mr. Anil Shelar','anil@gmail.com',9822993815,27,11,'Dr. Mayuri Patil',0);
/*!40000 ALTER TABLE `tbl_form_main` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_login_details`
--

DROP TABLE IF EXISTS `tbl_login_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_login_details` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(100) DEFAULT NULL,
  `user_type` varchar(50) DEFAULT NULL,
  `login_name` varchar(50) DEFAULT NULL,
  `login_password` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_login_details`
--

LOCK TABLES `tbl_login_details` WRITE;
/*!40000 ALTER TABLE `tbl_login_details` DISABLE KEYS */;
INSERT INTO `tbl_login_details` VALUES (1,'Administrator','Admin','admin','admin123');
/*!40000 ALTER TABLE `tbl_login_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_major_tests`
--

DROP TABLE IF EXISTS `tbl_major_tests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_major_tests` (
  `test_id` int(11) NOT NULL AUTO_INCREMENT,
  `test_name` varchar(45) DEFAULT NULL,
  `test_category` varchar(45) DEFAULT NULL,
  `test_subcat` varchar(45) DEFAULT NULL,
  `test_exam` varchar(45) DEFAULT NULL,
  `test_desc` varchar(250) DEFAULT NULL,
  PRIMARY KEY (`test_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_major_tests`
--

LOCK TABLES `tbl_major_tests` WRITE;
/*!40000 ALTER TABLE `tbl_major_tests` DISABLE KEYS */;
INSERT INTO `tbl_major_tests` VALUES (1,'CBC','Hematology','None','Examinition of Blood','Count Blood Cells'),(2,'ESR','Hematology','None','Examinition of Blood','ESR Information'),(3,'PSMP','Hematology','None','Examinition of Blood','PSMP Information'),(4,'Blood Group','Hematology','None','Examinition of Blood','To check blood group of a person'),(5,'BT/CT/PT/APTT','Hematology','None','Examinition of Blood','BT/CT/PT/APTT');
/*!40000 ALTER TABLE `tbl_major_tests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_med_cmp`
--

DROP TABLE IF EXISTS `tbl_med_cmp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_med_cmp` (
  `med_cmp_id` int(11) NOT NULL AUTO_INCREMENT,
  `med_cmp_name` varchar(100) NOT NULL,
  PRIMARY KEY (`med_cmp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_med_cmp`
--

LOCK TABLES `tbl_med_cmp` WRITE;
/*!40000 ALTER TABLE `tbl_med_cmp` DISABLE KEYS */;
INSERT INTO `tbl_med_cmp` VALUES (1,'Cipla Den'),(2,'Glenmark'),(3,'Megafine'),(4,'Sreeven'),(5,'Pharmahopers'),(6,'Ritesh Chemicals'),(7,'Dev Life Sciences'),(8,'Curivo Health'),(9,'MyLan'),(10,'Fabino Pharma'),(11,'Ernst Pharmacia'),(12,'Parul Healthcare'),(13,'Acekinetics'),(14,'Medifame Biotech');
/*!40000 ALTER TABLE `tbl_med_cmp` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_med_stock`
--

DROP TABLE IF EXISTS `tbl_med_stock`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_med_stock` (
  `stock_id` int(11) NOT NULL AUTO_INCREMENT,
  `med_name` varchar(45) DEFAULT NULL,
  `med_category` varchar(45) DEFAULT NULL,
  `min_level` bigint(8) DEFAULT NULL,
  `med_stock` bigint(8) DEFAULT NULL,
  PRIMARY KEY (`stock_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_med_stock`
--

LOCK TABLES `tbl_med_stock` WRITE;
/*!40000 ALTER TABLE `tbl_med_stock` DISABLE KEYS */;
INSERT INTO `tbl_med_stock` VALUES (1,'Vicks Action 500','Tablets',50,100),(2,'Imol','Syrups',25,10),(3,'Vittalect 250','Tablets',100,100),(4,'Xpect PD','Saline',10,200),(5,'Nasoclear','Syringe',50,100);
/*!40000 ALTER TABLE `tbl_med_stock` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_medicines`
--

DROP TABLE IF EXISTS `tbl_medicines`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_medicines` (
  `med_id` int(11) NOT NULL AUTO_INCREMENT,
  `med_name` varchar(50) NOT NULL,
  `med_cmp` varchar(50) NOT NULL,
  `med_price` float NOT NULL,
  `med_type` varchar(50) NOT NULL,
  `med_qty` int(11) NOT NULL,
  PRIMARY KEY (`med_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_medicines`
--

LOCK TABLES `tbl_medicines` WRITE;
/*!40000 ALTER TABLE `tbl_medicines` DISABLE KEYS */;
INSERT INTO `tbl_medicines` VALUES (1,'Vicks Action 500','Cipla Den',2.5,'Tablets',50),(2,'Imol','Megafine',45.2,'Syrups',25),(3,'Vittalect 250','Ritesh Chemicals',8.3,'Tablets',100),(4,'Xpect PD','Acekinetics',320,'Saline',10),(5,'Nasoclear','Medifame Biotech',100,'Syringe',50);
/*!40000 ALTER TABLE `tbl_medicines` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_purchase_details`
--

DROP TABLE IF EXISTS `tbl_purchase_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_purchase_details` (
  `ord_id` int(11) DEFAULT NULL,
  `ord_date` varchar(50) DEFAULT NULL,
  `med_name` varchar(50) DEFAULT NULL,
  `med_type` varchar(50) DEFAULT NULL,
  `med_qty` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_purchase_details`
--

LOCK TABLES `tbl_purchase_details` WRITE;
/*!40000 ALTER TABLE `tbl_purchase_details` DISABLE KEYS */;
INSERT INTO `tbl_purchase_details` VALUES (1,'25-02-2019','Vicks Action 500','Tablets',100),(1,'25-02-2019','Imol','Syrups',100),(1,'25-02-2019','Vittalect 250','Tablets',100),(1,'25-02-2019','Xpect PD','Saline',100),(1,'25-02-2019','Nasoclear','Syringe',100),(2,'25-02-2019','Vittalect 250','Tablets',200),(2,'25-02-2019','Nasoclear','Syringe',100);
/*!40000 ALTER TABLE `tbl_purchase_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_purchase_master`
--

DROP TABLE IF EXISTS `tbl_purchase_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_purchase_master` (
  `ord_id` int(11) NOT NULL AUTO_INCREMENT,
  `ord_date` varchar(50) NOT NULL,
  `supp_name` varchar(100) NOT NULL,
  `supp_email` varchar(45) DEFAULT NULL,
  `supp_contact1` decimal(10,0) DEFAULT NULL,
  `supp_contact2` decimal(10,0) DEFAULT NULL,
  `supp_cmp` varchar(100) DEFAULT NULL,
  `is_active` int(1) NOT NULL DEFAULT '1',
  PRIMARY KEY (`ord_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_purchase_master`
--

LOCK TABLES `tbl_purchase_master` WRITE;
/*!40000 ALTER TABLE `tbl_purchase_master` DISABLE KEYS */;
INSERT INTO `tbl_purchase_master` VALUES (1,'25-02-2019','Mr. Santosh Sarkate','santosh@gmail.com',1234567891,1234567897,'CiplaDen',0),(2,'25-02-2019','Mr. Raju S. Shingate','raju@gmail.com',9822456897,9689254837,'Arihant Lab Services',0);
/*!40000 ALTER TABLE `tbl_purchase_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_reading_detail`
--

DROP TABLE IF EXISTS `tbl_reading_detail`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_reading_detail` (
  `detail_id` int(11) NOT NULL AUTO_INCREMENT,
  `reading_id` int(11) DEFAULT NULL,
  `test_id` int(11) DEFAULT NULL,
  `test_name` varchar(45) DEFAULT NULL,
  `test_factor` varchar(45) DEFAULT NULL,
  `test_unit` varchar(45) DEFAULT NULL,
  `test_min` int(11) DEFAULT NULL,
  `test_max` int(11) DEFAULT NULL,
  `test_reading` int(11) DEFAULT '0',
  PRIMARY KEY (`detail_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_reading_detail`
--

LOCK TABLES `tbl_reading_detail` WRITE;
/*!40000 ALTER TABLE `tbl_reading_detail` DISABLE KEYS */;
INSERT INTO `tbl_reading_detail` VALUES (1,1,1,'CBC','CBC Blood Cell','M/G',2,5,3),(2,1,1,'CBC','Random Sugar','K/cell',10,100,50);
/*!40000 ALTER TABLE `tbl_reading_detail` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_reading_main`
--

DROP TABLE IF EXISTS `tbl_reading_main`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_reading_main` (
  `reading_id` int(11) NOT NULL AUTO_INCREMENT,
  `reading_date` varchar(45) DEFAULT NULL,
  `form_id` int(11) DEFAULT NULL,
  `form_date` varchar(45) DEFAULT NULL,
  `cust_id` int(11) DEFAULT NULL,
  `cust_name` varchar(45) DEFAULT NULL,
  `doc_id` int(11) DEFAULT NULL,
  `doc_name` varchar(45) DEFAULT NULL,
  `test_exam` varchar(45) DEFAULT NULL,
  `IsDelivered` int(11) DEFAULT '0',
  PRIMARY KEY (`reading_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_reading_main`
--

LOCK TABLES `tbl_reading_main` WRITE;
/*!40000 ALTER TABLE `tbl_reading_main` DISABLE KEYS */;
INSERT INTO `tbl_reading_main` VALUES (1,'27-03-2019',1,'28-02-2019',1,'Mr. Anil Shelar',11,'Dr. Mayuri Patil','Examinition of Blood',1);
/*!40000 ALTER TABLE `tbl_reading_main` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_recv_details`
--

DROP TABLE IF EXISTS `tbl_recv_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_recv_details` (
  `recv_id` int(11) NOT NULL,
  `med_name` varchar(45) DEFAULT NULL,
  `med_type` varchar(45) DEFAULT NULL,
  `ord_qty` int(11) DEFAULT NULL,
  `unit_price` float DEFAULT NULL,
  `recv_qty` int(11) DEFAULT NULL,
  `med_amt` double DEFAULT NULL,
  `amt_tax` float DEFAULT NULL,
  `med_total` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_recv_details`
--

LOCK TABLES `tbl_recv_details` WRITE;
/*!40000 ALTER TABLE `tbl_recv_details` DISABLE KEYS */;
INSERT INTO `tbl_recv_details` VALUES (1,'Vicks Action 500','Tablets',100,2.5,100,250,2,255),(1,'Imol','Syrups',100,45.3,100,4530,3,4665.9),(1,'Vittalect 250','Tablets',100,8.5,100,850,2,867),(2,'Vittalect 250','Tablets',100,8.6,50,430.00003,2,438.60004),(2,'Nasoclear','Syringe',100,110.56,25,2764,3,2846.92);
/*!40000 ALTER TABLE `tbl_recv_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_recv_master`
--

DROP TABLE IF EXISTS `tbl_recv_master`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_recv_master` (
  `recv_id` int(11) NOT NULL AUTO_INCREMENT,
  `ord_id` int(11) DEFAULT NULL,
  `recv_date` varchar(45) DEFAULT NULL,
  `ord_date` varchar(45) DEFAULT NULL,
  `supp_name` varchar(45) DEFAULT NULL,
  `supp_contact` decimal(10,0) DEFAULT NULL,
  `recv_total` decimal(10,2) DEFAULT NULL,
  `recv_disc` float DEFAULT NULL,
  `recv_paid` decimal(10,2) DEFAULT NULL,
  PRIMARY KEY (`recv_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_recv_master`
--

LOCK TABLES `tbl_recv_master` WRITE;
/*!40000 ALTER TABLE `tbl_recv_master` DISABLE KEYS */;
INSERT INTO `tbl_recv_master` VALUES (1,1,'25-02-2019','25-02-2019','Mr. Santosh Sarkate',1234567891,5787.90,5,5498.51),(2,2,'25-02-2019','25-02-2019','Mr. Raju S. Shingate',9822456897,3285.52,10,2956.97);
/*!40000 ALTER TABLE `tbl_recv_master` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_supplier_info`
--

DROP TABLE IF EXISTS `tbl_supplier_info`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_supplier_info` (
  `supp_id` int(11) NOT NULL AUTO_INCREMENT,
  `supp_name` varchar(100) NOT NULL,
  `supp_add1` varchar(50) DEFAULT NULL,
  `supp_add2` varchar(50) DEFAULT NULL,
  `supp_add3` varchar(50) DEFAULT NULL,
  `supp_email` varchar(100) DEFAULT NULL,
  `supp_contact1` decimal(10,0) NOT NULL,
  `supp_contact2` decimal(10,0) NOT NULL,
  `supp_company` varchar(100) NOT NULL,
  `supp_cmp_add1` varchar(50) DEFAULT NULL,
  `supp_cmp_add2` varchar(50) DEFAULT NULL,
  `supp_other` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`supp_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_supplier_info`
--

LOCK TABLES `tbl_supplier_info` WRITE;
/*!40000 ALTER TABLE `tbl_supplier_info` DISABLE KEYS */;
INSERT INTO `tbl_supplier_info` VALUES (1,'Mr. Santosh Sarkate','Shop No 5','Shalimar, CBS','Nashik','santosh@gmail.com',1234567891,1234567897,'CiplaDen','Malegaon MIDC','Sinnar, Nashik','nope'),(2,'Mr. Raju S. Shingate','Kakaji Nagar','Nashik Road','Nashik','raju@gmail.com',9822456897,9689254837,'Arihant Lab Services','Jai Bhavani Road','Nashik Road','nothing');
/*!40000 ALTER TABLE `tbl_supplier_info` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_test_cat`
--

DROP TABLE IF EXISTS `tbl_test_cat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_test_cat` (
  `cat_id` int(11) NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`cat_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_test_cat`
--

LOCK TABLES `tbl_test_cat` WRITE;
/*!40000 ALTER TABLE `tbl_test_cat` DISABLE KEYS */;
INSERT INTO `tbl_test_cat` VALUES (1,'Microbiology'),(2,'Serology'),(3,'Clinical'),(4,'Hematology'),(5,'Immunohematology'),(6,'Pathology'),(7,'Radiobioassay'),(8,'Histocompatibility'),(9,'Cytogenetics'),(10,'Bio-Chemistry'),(11,'Body Profile'),(12,'Hormones'),(13,'Special'),(14,'Histopathology');
/*!40000 ALTER TABLE `tbl_test_cat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_test_charges`
--

DROP TABLE IF EXISTS `tbl_test_charges`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_test_charges` (
  `test_id` int(11) NOT NULL,
  `test_name` varchar(45) DEFAULT NULL,
  `test_charge` float DEFAULT '100.25',
  PRIMARY KEY (`test_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_test_charges`
--

LOCK TABLES `tbl_test_charges` WRITE;
/*!40000 ALTER TABLE `tbl_test_charges` DISABLE KEYS */;
INSERT INTO `tbl_test_charges` VALUES (1,'CBC',150.25);
/*!40000 ALTER TABLE `tbl_test_charges` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_test_exam`
--

DROP TABLE IF EXISTS `tbl_test_exam`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_test_exam` (
  `exam_id` int(4) NOT NULL AUTO_INCREMENT,
  `exam_name` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`exam_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_test_exam`
--

LOCK TABLES `tbl_test_exam` WRITE;
/*!40000 ALTER TABLE `tbl_test_exam` DISABLE KEYS */;
INSERT INTO `tbl_test_exam` VALUES (1,'Examinition of Blood'),(2,'Examinition of Urine'),(3,'Examinition of Stool');
/*!40000 ALTER TABLE `tbl_test_exam` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_test_factors`
--

DROP TABLE IF EXISTS `tbl_test_factors`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_test_factors` (
  `test_id` int(11) DEFAULT NULL,
  `test_name` varchar(45) DEFAULT NULL,
  `factor_name` varchar(45) DEFAULT NULL,
  `factor_unit` varchar(45) DEFAULT NULL,
  `factor_min` int(11) DEFAULT NULL,
  `factor_max` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_test_factors`
--

LOCK TABLES `tbl_test_factors` WRITE;
/*!40000 ALTER TABLE `tbl_test_factors` DISABLE KEYS */;
INSERT INTO `tbl_test_factors` VALUES (1,'CBC','CBC Blood Cell','M/G',2,5),(1,'CBC','Random Sugar','K/cell',10,100),(3,'PSMP','xyze','x',1,2);
/*!40000 ALTER TABLE `tbl_test_factors` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_test_subcat`
--

DROP TABLE IF EXISTS `tbl_test_subcat`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
 SET character_set_client = utf8mb4 ;
CREATE TABLE `tbl_test_subcat` (
  `sub_id` int(4) NOT NULL AUTO_INCREMENT,
  `cat_name` varchar(50) NOT NULL,
  `subcat_name` varchar(50) DEFAULT 'None',
  PRIMARY KEY (`sub_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_test_subcat`
--

LOCK TABLES `tbl_test_subcat` WRITE;
/*!40000 ALTER TABLE `tbl_test_subcat` DISABLE KEYS */;
INSERT INTO `tbl_test_subcat` VALUES (1,'Clinical','Urine'),(2,'Clinical','Stool'),(3,'Clinical','Sputum'),(4,'Clinical','Semen Analysis'),(5,'Clinical','Mantoux(TT)');
/*!40000 ALTER TABLE `tbl_test_subcat` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'labsoft'
--

--
-- Dumping routines for database 'labsoft'
--
/*!50003 DROP PROCEDURE IF EXISTS `sp_getAllCompanies` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_getAllCompanies`()
BEGIN
select cmp_name from labsoft.tab_company_names;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getAllDocNames` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_getAllDocNames`()
BEGIN
select doc_name from labsoft.tab_doctors_info;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getAllIssues` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_getAllIssues`()
BEGIN
select issue_name from labsoft.tab_major_issues;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getCharges` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_getCharges`(in rid int)
BEGIN
SELECT distinct t2.test_id,t2.test_name,t2.test_charge 
FROM labsoft.tbl_reading_detail t1, labsoft.tbl_test_charges t2 
where t1.reading_id = rid and t1.test_id = t2.test_id order by test_id;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getDocNames` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_getDocNames`()
BEGIN
select tab_doctors_info.doc_id, tab_doctors_info.doc_name
from labsoft.tab_doctors_info;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getLastCatID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_getLastCatID`(out maxid int)
BEGIN
select max(cat_id) into maxid from labsoft.tbl_test_cat;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getLastDocID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_getLastDocID`(out maxid int(4))
BEGIN
set maxid = 0;
select max(doc_id) into maxid from labsoft.tab_doctors_info;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getLastExamID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_getLastExamID`(out maxid int)
BEGIN
select max(exam_id) into maxid from labsoft.tbl_test_exam;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getLastOrdID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_getLastOrdID`(out maxid int(4))
BEGIN
	set maxid=0;
	select max(ord_id) into maxid from labsoft.tbl_purchase_master;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getLastPatID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_getLastPatID`(out maxid int)
BEGIN
set maxid = 0;
select max(p_id) into maxid from labsoft.tab_patients_info;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getLastReadingID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_getLastReadingID`(out maxid int(4))
BEGIN
select max(reading_id) into maxid from labsoft.tbl_reading_main;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getLastRecvID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_getLastRecvID`(out maxid int(4))
BEGIN
	set maxid = 0;
	select max(recv_id) into maxid from labsoft.tbl_recv_master;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getLastSubCatID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_getLastSubCatID`(out maxid int(4))
BEGIN
select max(sub_id) into maxid from labsoft.tbl_test_subcat;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getLastSuppID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_getLastSuppID`(out maxid int)
BEGIN
set maxid = 0;
select max(tbl_supplier_info.supp_id) into maxid from labsoft.tbl_supplier_info;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getLastTestID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_getLastTestID`(out maxid int(4))
BEGIN
select max(test_id) into maxid from labsoft.tbl_major_tests;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getLastUserID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_getLastUserID`(out maxid int)
BEGIN
set maxid = 0;
select max(t.user_id) into maxid from labsoft.tbl_login_details t;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getPatientNames` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_getPatientNames`()
BEGIN
select tab_patients_info.p_id, tab_patients_info.p_name
from labsoft.tab_patients_info;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getSelectedTestID` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_getSelectedTestID`(in tname varchar(50), out tid int(10))
BEGIN
select test_id into tid from labsoft.tbl_major_tests where test_name = tname;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getSingleDocDetails` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_getSingleDocDetails`(in docId int)
BEGIN
select t.doc_name, t.doc_address, t.doc_email, t.doc_contact1, t.doc_contact2, 
t.doc_graduation, t.doc_pg, t.doc_other_edu, t.doc_hospital
from labsoft.tab_doctors_info t
where t.doc_id=docId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getSinglePatDetails` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_getSinglePatDetails`(in pId int)
BEGIN
select t.p_name, t.p_add1, t.p_add2, t.p_add3, t.p_email, t.p_contact1, t.p_contact2, 
t.p_ocp, t.p_dob, t.p_age, t.p_issue, t.p_familydoc, t.p_other
from labsoft.tab_patients_info t
where t.p_id=pId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getSingleSuppDetails` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_getSingleSuppDetails`(in suppId int)
BEGIN
select t.supp_name, t.supp_add1, t.supp_add2, t.supp_add3, t.supp_email, t.supp_contact1, 
t.supp_contact2, t.supp_company, t.supp_cmp_add1, t.supp_cmp_add2, t.supp_other
from labsoft.tbl_supplier_info t
where t.supp_id = suppId;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getSuppNames` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_getSuppNames`()
BEGIN
select tbl_supplier_info.supp_id, tbl_supplier_info.supp_name
from labsoft.tbl_supplier_info;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_getUserPass` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_getUserPass`(
	in type1	varchar(50),
    in login	varchar(50),
    in pass		varchar(50),
    out flag	boolean
)
BEGIN
declare cnt int;
set cnt = 0;
select count(t.login_name) into cnt from labsoft.tbl_login_details t 
where t.user_type = type1 and t.login_name = login and t.login_password = pass;

if cnt > 0 then
	set flag = true;
else
	set flag = false;
end if;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertDocDetails` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_insertDocDetails`(
	in doc_name 		varchar(100),
    in doc_address 		varchar(250),
    in doc_email 		varchar(100),
    in doc_contact1 	decimal(10,0),
    in doc_contact2 	decimal(10,0),
    in doc_graduation 	varchar(10),
    in doc_pg 			varchar(10),
    in doc_other_edu 	varchar(100),
    in doc_hospital 	varchar(100)
)
BEGIN
	if (doc_name = '' || doc_name = null) then
		set doc_name = 'Unknown';
	end if;
    
    if (doc_contact1 <= 0 || doc_contact1 = null) then
		set doc_contact1 = 9422474233;
    end if;
    
    if (doc_graduation = '' || doc_graduation = null) then
		set doc_graduation = 'MBBS';
    end if;
    
    insert into labsoft.tab_doctors_info
    (tab_doctors_info.doc_name, tab_doctors_info.doc_address, tab_doctors_info.doc_email, tab_doctors_info.doc_contact1, 
     tab_doctors_info.doc_contact2, tab_doctors_info.doc_graduation, tab_doctors_info.doc_pg, tab_doctors_info.doc_other_edu, 
     tab_doctors_info.doc_hospital)
	values
    (doc_name, doc_address, doc_email, doc_contact1, doc_contact2, doc_graduation, doc_pg, doc_other_edu, doc_hospital);    
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertPatDetails` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_insertPatDetails`(
	in p_name 		varchar(100),
    in p_add1 		varchar(50),
    in p_add2 		varchar(50),
    in p_add3 		varchar(50),
    in p_email 		varchar(100),
    in p_contact1 	decimal(10,0),
    in p_contact2 	decimal(10,0),
    in p_ocp 		varchar(50),
    in p_dob 		varchar(50),
    in p_age 		int,
    in p_issue 		varchar(50),
    in p_familydoc 	varchar(100),
    in p_other		varchar(100)
)
BEGIN
	if (p_name = '' || p_name = null) then
		set p_name = 'Unknown';
	end if;
    
    if (p_contact1 <= 0 || p_contact1 = null) then
		set p_contact1 = 9422474233;
    end if;
    
    if (p_ocp = '' || p_ocp = null) then
		set p_ocp = 'Service';
    end if;
    
    insert into labsoft.tab_patients_info
    (tab_patients_info.p_name, tab_patients_info.p_add1, tab_patients_info.p_add2, tab_patients_info.p_add3, 
     tab_patients_info.p_email, tab_patients_info.p_contact1, tab_patients_info.p_contact2, 
     tab_patients_info.p_ocp, tab_patients_info.p_dob, tab_patients_info.p_age, tab_patients_info.p_issue, 
     tab_patients_info.p_familydoc, tab_patients_info.p_other)
	values
    (p_name, p_add1, p_add2, p_add3, p_email, p_contact1, p_contact2, p_ocp, p_dob, p_age, p_issue, p_familydoc, p_other);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertSuppDetails` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_insertSuppDetails`(
	in suppName 	varchar(100),
    in suppAdd1 	varchar(50),
    in suppAdd2 	varchar(50),
    in suppAdd3 	varchar(50),
    in suppEmail 	varchar(100),
    in suppContact1	decimal(10,0),
    in suppContact2	decimal(10,0),
    in suppCmpName	varchar(100),
    in suppCmpAdd1 	varchar(50),
    in suppCmpAdd2 	varchar(50),
    in suppOther 	varchar(100)    
)
BEGIN
	insert into labsoft.tbl_supplier_info(supp_name, supp_add1, supp_add2, supp_add3, supp_email, 
    supp_contact1, supp_contact2, supp_company, supp_cmp_add1, supp_cmp_add2, supp_other)
    values(suppName, suppAdd1, suppAdd2, suppAdd3, suppEmail, suppContact1, suppContact2, 
    suppCmpName, suppCmpAdd1, suppCmpAdd2, suppOther);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_insertUserDetails` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_insertUserDetails`(
	in userName		varchar(100),
    in userType		varchar(50),
    in loginName	varchar(50),
    in loginPass	varchar(50)
)
BEGIN
	insert into labsoft.tbl_login_details(user_name, user_type, login_name, login_password) 
    values(userName, userType, loginName, loginPass);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_setCompany` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_setCompany`(in cmpName varchar(100))
BEGIN
insert into labsoft.tab_company_names(cmp_name) values(cmpName);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_setIssues` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_setIssues`(in is_name varchar(100))
BEGIN
insert into labsoft.tab_major_issues(issue_name) 
values(is_name);
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `sp_updateStock` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`nspl`@`%` PROCEDURE `sp_updateStock`(in medName varchar(50),in qty bigint(8))
BEGIN
	declare temp bigint default 0;
    select med_stock into temp from labsoft.tbl_med_stock where med_name = medName;
    set temp = temp + qty;
    update labsoft.tbl_med_stock set med_stock = temp where med_name = medName;
END ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-04-02  2:59:36
