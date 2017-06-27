-- MySQL dump 10.13  Distrib 5.7.18, for Linux (x86_64)
--
-- Host: localhost    Database: db
-- ------------------------------------------------------
-- Server version	5.7.18

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
-- Table structure for table `FARMERS_MARKET`
--

DROP TABLE IF EXISTS `FARMERS_MARKET`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `FARMERS_MARKET` (
  `uuid` binary(16) NOT NULL,
  `city` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `email` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `state` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `street_address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `website` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `zip` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `contact` binary(16) DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  KEY `FK6tt0ynyys511qtyov3m4cebkh` (`contact`),
  CONSTRAINT `FK6tt0ynyys511qtyov3m4cebkh` FOREIGN KEY (`contact`) REFERENCES `USERS` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FARMERS_MARKET`
--

LOCK TABLES `FARMERS_MARKET` WRITE;
/*!40000 ALTER TABLE `FARMERS_MARKET` DISABLE KEYS */;
INSERT INTO `FARMERS_MARKET` VALUES ('06b00aea42e547b1','Dewey Beach',NULL,'Fifer Orchards Local-Fresh Market','(302) 227-8680','DE','200 Cullen Street','www.fiferorchards.com','19971',NULL),('0caa7f8d7fce4ea8','Georgetown',NULL,'Elmer\'s Market','(302) 337-8388','DE','13257 Seashore Highway','','19947',NULL),('2bbd10f16575463e','Wilmington',NULL,'Bright Spot Mobile Urban Farm Market','(302) 658-4171','DE','1901 North Market Street','','19801',NULL),('2c6bd5c0e3bd42ba','Wilmington',NULL,'Bright Spot Mobile Urban Farm Market','(302) 658-4171','DE','504 South Clayton Street','','19805',NULL),('3098140580094945','Greenwood',NULL,'Anderson\'s Produce Market','(302) 349-4640','DE','10967 Beach Highway','www.sites.google.com/site/andersonsproducemarket/','19950',NULL),('36ee56f8166e4d98','Wilmington',NULL,'Bright Spot Mobile Urban Farm Market','(302) 658-4171','DE','131 North Market Street','','19801',NULL),('3fc52750ff4d420b','Wilmington',NULL,'Bright Spot Mobile Urban Farm Market','(302) 658-4171','DE','2200 West 4th Street','','19805',NULL),('458bd896897046f4','New Castle',NULL,'Vince\'s Market','(302) 322-0386','DE','380 Pulaski Highway','','19720',NULL),('66bf22ae9ce04c62','Greenwood',NULL,'Adams Fruit Market','(302) 349-4924','DE','2239 Seashore Highway','www.adamsfruitmarket.com','19950',NULL),('6b897d5d0d864fd8','Wilmington',NULL,'Bright Spot Mobile Urban Farm Market','(302) 658-4171','DE','2nd & French Streets','','19801',NULL),('78ab2ca11ba2482f','Townsend',NULL,'Powers Farm Market','','DE','324 VanDyke-Maryland Line Road','http://www.thepowersfarm.com/','19734',NULL),('7fc35a63e12541eb','Bridgeville',NULL,'Farmer Gene\'s Market','(302) 349-4121','DE','4213 Seashore Highway','','19933',NULL),('8dd862d07d604580','Wilmington',NULL,'Bright Spot Mobile Urban Farm Market','(302) 658-4171','DE','100 South West Street','','19801',NULL),('e54bbf44cf524d5d','Greenwood',NULL,'Ma & Pa\'s Market','(302) 349-5607','DE','4987 Seashore Highway','','19950',NULL),('ea1aed59baab4b2e','Wilmington',NULL,'Highland Orchards Farm Market','(302) 478-4042','DE','1431 Foulk Road','www.highlandorchardsfarmmarket.com','19803',NULL),('edc6da7df78c46c2','Milford',NULL,'Joe\'s Market','(302) 632-2491','DE','10567 Coastal Highway','','19963',NULL),('eeefe7b38cfa460c','Dover',NULL,'John\'s Market','(302) 423-7035','DE','4693 Kenton Road','','19904',NULL),('effeb4112db449f8','Selbyville',NULL,'Johnson\'s Country Market','(302) 436-3276','DE','36258 Zion Church Road','www.JohnsonsCountryMarket.com','19975',NULL),('fa57fae158424e9f','Frederica',NULL,'Red Barn Farm Market','(302) 335-4890','DE','7360 Bay Road','','19947',NULL),('ff3845e1fedf4776','Ocean View',NULL,'Good Earth Market','302-537-7100','DE','31806 Good Earth Lane','www.goodearthmarket.com','19970',NULL);
/*!40000 ALTER TABLE `FARMERS_MARKET` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `FARMS`
--

DROP TABLE IF EXISTS `FARMS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `FARMS` (
  `uuid` binary(16) NOT NULL,
  `city` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `state` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `street_address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `website` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `zip` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `owner` binary(16) DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  KEY `FKakj4gev6bct2nb56e0kinedss` (`owner`),
  CONSTRAINT `FKakj4gev6bct2nb56e0kinedss` FOREIGN KEY (`owner`) REFERENCES `USERS` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `FARMS`
--

LOCK TABLES `FARMS` WRITE;
/*!40000 ALTER TABLE `FARMS` DISABLE KEYS */;
INSERT INTO `FARMS` VALUES ('05d8dbaeaf364f0b','Harrington','Flagstone Farm','(302) 349-5726','DE','10574 Memory Road','','19952',NULL),('0e164c75adfe403e','Bridgeville','Street\'s Produce Market','(302) 337-7330','DE','18973 Sussex Highway','','19933',NULL),('0e3732b2a6574f21','Townsend','Baronage Farm','(302) 598-6662','DE','311 Black Stallion Road','www.baronagefarm.com','19734',NULL),('0ec3272f5ee3451e','Seaford','Marvelous Produce','(302)-628-1940','DE','22958 Sussex Highway','www.marvelousproducefarms.com','19973',NULL),('0f16852e6aa040b5','Milford','Fresh Connection','(302) 684-8498','DE','9598 Coastal Highway','','19963',NULL),('0f9d22e43ab344d1','Ellendale','Ernest Fruit Farm','(302) 349-5986','DE','15092 S. Union Church Road','','19941',NULL),('12d4364475eb4f7e','Dover','U-Pick Strawberries','(302) 423-7035','DE','4693 Kenton Road','','19901',NULL),('1bc7b5b9dd324c02','Delmar','Adam\'s Greenhouses & Produce','(302)-846-0652','DE','14757 Line Road','www.sunnysidenurseryandadamsgreenhouses.com','19940',NULL),('1f925ac209f4460f','Seaford','Woodland Harvest Farm','(302) 629-2686','DE','4091 Woodland Ferry Road','','19973',NULL),('219ddc3af25d49b7','Milton','Dawn\'s Country Market','(302) 644-4760','DE','30511 Cave Neck Road','www.dawnscountrymarket.com','19968',NULL),('2469c1d38f4c4509','Georgetown','Steven & PopPop\'s','(302) 933-0454','DE','24532 Deep Branch Road','','19947',NULL),('24861486d85f4f37','Laurel','Dickerson Farms','(302) 857-0826','DE','32370 Gordy Road','','19956',NULL),('26274600629a493d','Seaford','Peaches and Honey Farm','(302) 629-5271','DE','3188 Bowman Road','','19973',NULL),('29a676ce3de34465','Georgetown','Plymouth Produce','(302) 856-6998','DE','18751 North DuPont Highway','','19947',NULL),('2b7f99a92e7c4bf8','Dover','Bobola Farm & Florist','(302) 492-3367','DE','5268 Forrest Avenue','www.bobolaflorist.com','19904',NULL),('2bfaa782224c4c72','Millsboro','The Farm Stand at The Givens\'','(302) 933-8001','DE','29930 John J. Williams Highway','Facebook','19966',NULL),('2d954771f6aa4d35','Middletown','Filaskys Produce','(302) 378-2754','DE','1343 Bunker Hill Road','','19709',NULL),('2e2a91027cd34112','Laurel','Givens Produce','(302) 228-4640','DE','8947 Woodland Ferry Road','','19956',NULL),('2f0f3ed3052d4117','Felton','Paradise Peaches','(302) 284-3008','DE','2445 Paradise Alley Road','','19943',NULL),('31a49d5f64b14c8d','Frankford','East View Farm','(302) 436-4605','DE','36144 Bayard Road','','19945',NULL),('356dd4e5f6a5421d','Felton','Walters Produce','(302) 284-4619','DE','8571 South DuPont Highway','','19943',NULL),('35c8f1a4d1a04772','Selbyville','Magee Farms - Selbyville','(302) 436-5589','DE','34857 Lighthouse Road','www.mageefarms.com','19975',NULL),('3827f57a6c5840f5','Camden-Wyoming','T.A. Farms','(302) 492-3030','DE','4664 Mud Mill Road','www.tafarms.com','19934',NULL),('38a61465068d4c92','Seaford','Quillen Apiaries','(302) 629-9430','DE','907 Heritage Drive','','19973',NULL),('38ae1280913f49e1','Laurel','The Hen House','(302) 875-6922','DE','11465 Sycamore Road','www.thehenhousede.com','19956',NULL),('3c5922e94e00439f','Lewes','Magee Farms - Lewes','(302) 644-1023','DE','33761 Westcoats Rd','www.mageefarms.com','19958',NULL),('3e1a86fbe2834a3b','Townsend','Willey Farms','(302) 378-8441','DE','4092 DuPont Parkway','www.willeyfarmsde.com','19734',NULL),('4d8efa93e59d4ba6','Laurel','Lakeside Farms/Coastal Growers','(302) 875-4245','DE','32206 Hastings Drive','','19956',NULL),('4dee43107de24b55','Dover','Cowgills Corner Sheep and Wool Farm Bed and Breakfast','(302) 734-5743','DE','7299 Bayside Drive','','19901',NULL),('5180b2704f54431e','Milton','Outback Farm','(302) 645-8742','DE','30155 Cave Neck Road','','19968',NULL),('52d48e36eb894820','Wilmington','Greenbank Mill and Philips Farm','(302) 999-9001','DE','500 Greenbank Road','www.greenbankmill.com','19808',NULL),('58663d8cf8214428','Laurel','Two Belle Farms','(302) 875-7367','DE','30297 Discount Land Road','','19956',NULL),('5a0dd785dca04028','Bridgeville','Fresh To You Produce','(302) 349-4953','DE','12620 Seashore Highway','','19933',NULL),('5baa8820a297485d','Dagsboro','Hay Wagon Country Produce','(410)868-4617','DE','32766 DuPont Boulevard','Facebook','19939',NULL),('605d02fd098d40e8','Bridgeville','Evans Farms Produce','(302) 337-8130','DE','9843 Seashore Highway','www.EvansFarmsProduce.com','19933',NULL),('626c6bc6e656424f','Greenwood','Deep Grass Nursery','(302) 398-4413','DE','13847 Staytonville Road','www.deepgrassnursery.com','19950',NULL),('626d599ac9eb4e45','Frankford','Birdsong Gardens','(302) 537-9680','DE','34382 Daisey Road','www.birdsongardens.com','19945',NULL),('6a68468bbaf445de','Harrington','Triple M Farms','(302) 398-8039','DE','10326 Shawnee Road','www.triplemfarmsde.com','19952',NULL),('6e1c5556e02f4cc5','Townsend','Fairview Farms','(302) 378-0611','DE','380 Green Giant Road','','19734',NULL),('6e37cc116d53494b','Clayton','Willow Rock Gardens','(302) 223-8190','DE','2104 Sewell Branch Road','www.willowrockgardensllc.com','19938',NULL),('6ff26cf5e44f45e7','Hockessin','Highland Orchards of Hockessin','(302) 239-4915','DE','7460 Lancaster Pike','https://sites.google.com/site/henrettysmarket/home','19709',NULL),('74a96473f9954527','Frankford','Bennett Orchards','(302) 732-3358','DE','31442 Peach Tree Land','www.bennettorchards.com','19945',NULL),('74ede87ae093494b','Selbyville','Magee Farms','(302) 436-5589','DE','34857 Lighthouse Road','www.mageefarms.com','19975',NULL),('74fa018b42184f54','Harbeson','Lawson\'s Produce','(302) 745-0666','DE','18581 Route 5','','19951',NULL),('76da11dfed9d4cad','Georgetown','Folke Family Funny Farm','(302) 856-4321','DE','24199 Lewes-Georgetown Highway','','19947',NULL),('7a986de8df8a4e28','Greenville','Coverdale Farm','(302) 239-2334','DE','543 Way Road','www.delawarenaturesociety.org','19807',NULL),('7bc173e83a85444b','Greenwood','Del-Ridge Farms','(302) 542-5172','DE','11623 Sussex Highway','','19950',NULL),('7eba3e63053940e8','Felton','Wothers\' Produce','(302) 284-9840','DE','378 Irish Hill Road','','19943',NULL),('7fcadf584d354baf','Lewes','Garden Shack Farm','(302) 945-2938','DE','19884 Beaver Dam Road','www.gardenshackfarm.com','',NULL),('82f5c5ba8f874ec7','Dagsboro','Parsons Farms Produce','(302) 732-3336','DE','30489 Parsons Road','','19939',NULL),('836e209260464649','Wyoming','Wicked R Western Production','(302) 492-3327','DE','2621 Sandy Bend Road','www.wickedrwestern.com','19934',NULL),('8533daa16ce34dc7','Greenwood','Don\'s Tree Farm','(302) 349-0555','DE','6396 Hickman Road','www.donstreefarm.com','19950',NULL),('86c20364050b4972','Frankford','Kingsley Orchards','(302) 732-9567','DE','24349 Blueberry Lane','http://www.kingsleyorchards.com/','19945',NULL),('89e86ee2600744fc','Laurel','Laurel Farmers Auction Market','(302) 875-3147','DE','10667 Georgetown Road','www.laurelauctionmarket.com','19956',NULL),('8d732aa9e8cd44db','Dover','Ficners Farm','(302) 674-4677','DE','1911 Fast Landing Road','www.ficnerfarm.com','19901',NULL),('919effe555c34b0a','Wilmington','Urban Acres Mobile Farm Stand - Broom St','(302) 547-1573','DE','1800 North Broom Street','','19802',NULL),('9258962328db4da0','Marydel','Shiloh Lea Farm','(302) 492-3789','DE','3716 Mahan Corner Road','','19964',NULL),('96f313873baf4121','Dover','Delaware Agricultural Museum','(302) 734-1618','DE','866 North DuPont Highway','www.agriculturalmuseum.org','19901',NULL),('9ee86bb504db4187','Bear','Mansion House Farm','(302) 834-6723','DE','2656 Porter Road & Mansion House Road','','19701',NULL),('a94847b322af4ab7','Clayton','Greenspring Farms','(302) 653-0239','DE','1331 Clayton-Greenspring Road','','19938',NULL),('aaa1b977f6a443a6','Wilmington','Ramsey\'s Farm','(302) 477-1499','DE','330 Ramsey Road','www.ramseysfarm.com','19803',NULL),('ad8cb862afb24d46','Millsboro','Country Living Produce','(302) 934-9045','DE','28086 Cross Keys Road','','19966',NULL),('ae01db058a9748e4','Middletown','Colemans Christmas Tree Farm','(302) 378-8949','DE','550 Silver Run Road','www.colemanstreefarm.com','19709',NULL),('af4fdfbab61f41eb','Millsboro','Muzzi Farms','(302) 362-3659','DE','32861 Long Neck Road','','19966',NULL),('b12e2cdc20774eb4','Laurel','Brick House Farm','(302) 396-8236','DE','12890 County Seat Highway','','19956',NULL),('b6b0673f4b0446b3','Milton','Lavender Fields at Warrington Manor','(302) 684-1514','DE','18864 Cool Springs Road','www.lavenderfieldsde.com','19968',NULL),('b8cd417325894c10','Rehoboth','Rustic Acres Farm Market/Rehoboth Dairy','(302) 245-8308','DE','37217 Rustic Acres Lane','','19971',NULL),('bacd85b55c5a4e00','Longneck','Longneck Produce at Bay City','(302) 236-0082','DE','Longneck Road','','19966',NULL),('c19afd03832c47af','Bridgeville','Handley\'s U-Pick','(302)337-9593','DE','6094 Epworth Church Road','','19933',NULL),('c22ee3e2687345da','Laurel','Mr. Peppers Pumpkin Patch','(302) 875-3939','DE','13000 Laurel Road','www.mrpepperspumpkinpatch.com','19956',NULL),('c3d48ec26577457a','Greenwood','Little Wagon Produce','(302) 349-5100','DE','2667 Seashore Highway','www.littlewagonproduce.com','19950',NULL),('d095f3aaea9045e6','Dover','White Gate Farms','(302) 233-1711','DE','883 Dyke Branch Road','','19901',NULL),('d39805acb02d4810','Bridgeville','Zitvogel Farms','(302) 249-7957','DE','13713 Haven Road','www.zitvogelfarms.com','19933',NULL),('d3afa9b9b1e24155','Milton','Brittingham\'s Produce','(302) 684-4232','DE','16001 Harbeson Road','','19968',NULL),('d68b40bab7a94b4d','Smyrna','Hazeye Farms','(302) 750-0786','DE','242 South DuPont Highway','','19977',NULL),('d72a6b10c943407e','Georgetown','Stag Run Farm','(302) 629-0415','DE','23656 Foxcroft Lane','www.delmarvafarmlife.com','19947',NULL),('dc4624a03efd4f02','Milford','Hill\'s Fresh Plants & Produce','(302) 422-8554','DE','1795 Milford-Harrington Highway','www.hillsfresh.net','19963',NULL),('dfd09652d6864a4f','Greenwood','Short\'s Brothers','(302) 349-4182','DE','2449 Seashore Highway','','19950',NULL),('e08576b06bfa48e9','Woodside','Loblolly Acres','(302) 284-9255','DE','3893 Turkey Point Road','www.loblollyacres.com','19980',NULL),('e0979984ff814f0f','Middletown','Thousand Acre Farm','302-893-3510','DE','260 South Reedy Point Road','www.thousandacrefarm.com','19709',NULL),('e15be5a432b942a8','Wilmington','Marini Produce','(302) 475-5754','DE','2121 Veale Road','','19810',NULL),('eb59fd6c84824751','Wilmington','Wayside Terrace Farming','(302) 650-5626','DE','5300 Kennett Pike','','19807',NULL),('f04bf288c725426e','Rehoboth Beach','Tomato Sunshine','(302) 226-9533','DE','4312 Highway One North','www.tomatosunshine.com','19971',NULL),('f05e91cca52c404e','Seaford','MaeBrook Farm','(302) 858-3435','DE','8022 Hearns Pond Rd','www.maebrookproduce.com','19973',NULL),('f1d31808324c4f7b','Newark','John\'s Homegrown and Farm Fresh Produce','(302) 834-3747','DE','3055 Old County Road','','19702',NULL),('f25ed1ed59fb45ed','Ocean View','Ocean View Produce','(302) 462-5377','DE','97 Atlantic Avenue','','',NULL),('f726f1ab05964a73','Middletown','Edwards Farm','(302) 376-1557','DE','1416 Bethel Church Road','','19709',NULL),('f95a5eabf54f4ff4','Millsboro','Adkins Produce','(302) 945-9700','DE','32008 Long Neck Road','','19966',NULL),('fa19950a63a8442d','Newark','Ray Drejka','(302) 239-2010','DE','200 North Star Road','','19711',NULL),('fb4367cdbea249ab','Middletown','Frightland','(302) 838-0256','DE','Route 13 & 301 Port Penn Road','www.frightland.com','19709',NULL),('fc3e4633e02a4033','Bridgeville','T.S. Smith and Sons','(302) 337-8271','DE','8887 Redden Road','www.tssmithandsonsfarm.com','19933',NULL),('fe7b40b18d004577','Greenwood','Judy Brothers','(302) 349-4187','DE','12565 Blacksmith Shop Road','','19950',NULL);
/*!40000 ALTER TABLE `FARMS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ITEMS`
--

DROP TABLE IF EXISTS `ITEMS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ITEMS` (
  `uuid` binary(16) NOT NULL,
  `category` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `quantity` double DEFAULT NULL,
  `order_number` binary(16) DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  KEY `FKm7dyc8cbehqd5lph5u0bxrays` (`order_number`),
  CONSTRAINT `FKm7dyc8cbehqd5lph5u0bxrays` FOREIGN KEY (`order_number`) REFERENCES `ORDERS` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ITEMS`
--

LOCK TABLES `ITEMS` WRITE;
/*!40000 ALTER TABLE `ITEMS` DISABLE KEYS */;
/*!40000 ALTER TABLE `ITEMS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ORDERS`
--

DROP TABLE IF EXISTS `ORDERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ORDERS` (
  `uuid` binary(16) NOT NULL,
  `date_time` datetime NOT NULL,
  `order_number` binary(16) DEFAULT NULL,
  PRIMARY KEY (`uuid`),
  KEY `FKm4j6ifc02oe93l2o26mo2yuvo` (`order_number`),
  CONSTRAINT `FKm4j6ifc02oe93l2o26mo2yuvo` FOREIGN KEY (`order_number`) REFERENCES `USERS` (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ORDERS`
--

LOCK TABLES `ORDERS` WRITE;
/*!40000 ALTER TABLE `ORDERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `ORDERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `PARTNERS`
--

DROP TABLE IF EXISTS `PARTNERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `PARTNERS` (
  `uuid` binary(16) NOT NULL,
  `city` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `name` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `street_address` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `state` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `PARTNERS`
--

LOCK TABLES `PARTNERS` WRITE;
/*!40000 ALTER TABLE `PARTNERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `PARTNERS` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `USERS`
--

DROP TABLE IF EXISTS `USERS`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `USERS` (
  `uuid` binary(16) NOT NULL,
  `preferred_location` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  `phone` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `type` varchar(255) COLLATE utf8_unicode_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_unicode_ci NOT NULL,
  PRIMARY KEY (`uuid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `USERS`
--

LOCK TABLES `USERS` WRITE;
/*!40000 ALTER TABLE `USERS` DISABLE KEYS */;
/*!40000 ALTER TABLE `USERS` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-06-27 13:52:19
