-- MySQL dump 10.13  Distrib 8.0.31, for Win64 (x86_64)
--
-- Host: localhost    Database: starwars
-- ------------------------------------------------------
-- Server version	8.0.31

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
-- Table structure for table `movie_people`
--

DROP TABLE IF EXISTS `movie_people`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movie_people` (
  `movie_id` int NOT NULL,
  `character_id` int DEFAULT NULL,
  KEY `movie_id` (`movie_id`),
  KEY `character_id` (`character_id`),
  CONSTRAINT `movie_people_ibfk_2` FOREIGN KEY (`movie_id`) REFERENCES `movies` (`movie_id`),
  CONSTRAINT `movie_people_ibfk_3` FOREIGN KEY (`character_id`) REFERENCES `people` (`people_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movie_people`
--

LOCK TABLES `movie_people` WRITE;
/*!40000 ALTER TABLE `movie_people` DISABLE KEYS */;
INSERT INTO `movie_people` VALUES (1,1),(1,2),(1,3),(1,4),(1,5),(1,6),(1,7),(1,8),(1,9),(1,10),(1,12),(1,13),(1,14),(1,15),(1,16),(1,18),(1,19),(1,81),(2,1),(2,2),(2,3),(2,4),(2,5),(2,10),(2,13),(2,14),(2,18),(2,20),(2,21),(2,22),(2,23),(2,24),(2,25),(2,26),(3,1),(3,2),(3,3),(3,4),(3,5),(3,10),(3,13),(3,14),(3,16),(3,18),(3,20),(3,21),(3,22),(3,25),(3,27),(3,28),(3,29),(3,30),(3,31),(3,45),(4,2),(4,3),(4,10),(4,11),(4,16),(4,20),(4,21),(4,32),(4,33),(4,34),(4,35),(4,36),(4,37),(4,38),(4,39),(4,40),(4,41),(4,42),(4,43),(4,44),(4,46),(4,47),(4,48),(4,49),(4,50),(4,51),(4,52),(4,53),(4,54),(4,55),(4,56),(4,57),(4,58),(4,59),(5,2),(5,3),(5,6),(5,7),(5,10),(5,11),(5,20),(5,21),(5,22),(5,33),(5,35),(5,36),(5,40),(5,43),(5,46),(5,51),(5,52),(5,53),(5,58),(5,59),(5,60),(5,61),(5,62),(5,63),(5,64),(5,65),(5,66),(5,67),(5,68),(5,69),(5,70),(5,71),(5,72),(5,73),(5,74),(5,75),(5,76),(5,77),(5,78),(5,82),(6,1),(6,2),(6,3),(6,4),(6,5),(6,6),(6,7),(6,10),(6,11),(6,12),(6,13),(6,20),(6,21),(6,33),(6,35),(6,46),(6,51),(6,52),(6,53),(6,54),(6,55),(6,56),(6,58),(6,63),(6,64),(6,67),(6,68),(6,75),(6,78),(6,79),(6,80),(6,81),(6,82),(6,83);
/*!40000 ALTER TABLE `movie_people` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `movies`
--

DROP TABLE IF EXISTS `movies`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `movies` (
  `movie_id` int NOT NULL,
  `title` varchar(50) DEFAULT NULL,
  `producer` varchar(100) DEFAULT NULL,
  `director` varchar(100) DEFAULT NULL,
  `release_date` date DEFAULT NULL,
  PRIMARY KEY (`movie_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `movies`
--

LOCK TABLES `movies` WRITE;
/*!40000 ALTER TABLE `movies` DISABLE KEYS */;
INSERT INTO `movies` VALUES (1,'A New Hope','Gary Kurtz, Rick McCallum','George Lucas','1977-05-25'),(2,'The Empire Strikes Back','Gary Kurtz, Rick McCallum','Irvin Kershner','1980-05-17'),(3,'Return of the Jedi','Howard G. Kazanjian, George Lucas, Rick McCallum','Richard Marquand','1983-05-25'),(4,'The Phantom Menace','Rick McCallum','George Lucas','1999-05-19'),(5,'Attack of the Clones','Rick McCallum','George Lucas','2002-05-16'),(6,'Revenge of the Sith','Rick McCallum','George Lucas','2005-05-19');
/*!40000 ALTER TABLE `movies` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `people`
--

DROP TABLE IF EXISTS `people`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `people` (
  `people_id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `species` int DEFAULT NULL,
  `height` int DEFAULT NULL,
  `home_world` int DEFAULT NULL,
  `birth_year` varchar(45) DEFAULT NULL,
  `gender` varchar(45) DEFAULT NULL,
  `eye_color` varchar(45) DEFAULT NULL,
  `hair_color` varchar(45) DEFAULT NULL,
  `skin_color` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`people_id`),
  KEY `species` (`species`),
  KEY `home_world` (`home_world`),
  CONSTRAINT `people_ibfk_1` FOREIGN KEY (`species`) REFERENCES `species` (`species_id`),
  CONSTRAINT `people_ibfk_2` FOREIGN KEY (`home_world`) REFERENCES `planets` (`planet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `people`
--

LOCK TABLES `people` WRITE;
/*!40000 ALTER TABLE `people` DISABLE KEYS */;
INSERT INTO `people` VALUES (1,'Luke Skywalker',0,172,1,'19BBY','male','blue','blond','fair'),(2,'C-3PO',2,167,1,'112BBY','n/a','yellow','n/a','gold'),(3,'R2-D2',2,96,8,'33BBY','n/a','red','n/a','white, blue'),(4,'Darth Vader',0,202,1,'41.9BBY','male','yellow','none','white'),(5,'Leia Organa',0,150,2,'19BBY','female','brown','brown','light'),(6,'Owen Lars',0,178,1,'52BBY','male','blue','brown, grey','light'),(7,'Beru Whitesun lars',0,165,1,'47BBY','female','blue','brown','light'),(8,'R5-D4',2,97,1,'unknown','n/a','red','n/a','white, red'),(9,'Biggs Darklighter',0,183,1,'24BBY','male','brown','black','light'),(10,'Obi-Wan Kenobi',0,182,20,'57BBY','male','blue-gray','auburn, white','fair'),(11,'Anakin Skywalker',0,188,1,'41.9BBY','male','blue','blond','fair'),(12,'Wilhuff Tarkin',0,180,21,'64BBY','male','blue','auburn, grey','fair'),(13,'Chewbacca',3,228,14,'200BBY','male','blue','brown','unknown'),(14,'Han Solo',0,180,22,'29BBY','male','brown','brown','fair'),(15,'Greedo',4,173,23,'44BBY','male','black','n/a','green'),(16,'Jabba Desilijic Tiure',5,175,24,'600BBY','hermaphrodite','orange','n/a','green-tan, brown'),(18,'Wedge Antilles',0,170,22,'21BBY','male','hazel','brown','fair'),(19,'Jek Tono Porkins',0,180,26,'unknown','male','blue','brown','fair'),(20,'Yoda',6,66,28,'896BBY','male','brown','white','green'),(21,'Palpatine',0,170,8,'82BBY','male','yellow','grey','pale'),(22,'Boba Fett',0,183,10,'31.5BBY','male','brown','black','fair'),(23,'IG-88',2,200,28,'15BBY','none','red','none','metal'),(24,'Bossk',7,190,29,'53BBY','male','red','none','green'),(25,'Lando Calrissian',0,177,30,'31BBY','male','brown','black','dark'),(26,'Lobot',0,175,6,'37BBY','male','blue','none','light'),(27,'Ackbar',8,180,31,'41BBY','male','orange','none','brown mottle'),(28,'Mon Mothma',0,150,32,'48BBY','female','blue','auburn','fair'),(29,'Arvel Crynyd',0,-1,28,'unknown','male','brown','brown','fair'),(30,'Wicket Systri Warrick',9,88,7,'8BBY','male','brown','brown','brown'),(31,'Nien Nunb',10,160,33,'unknown','male','black','none','grey'),(32,'Qui-Gon Jinn',0,193,28,'92BBY','male','blue','brown','fair'),(33,'Nute Gunray',11,191,18,'unknown','male','red','none','mottled green'),(34,'Finis Valorum',0,170,9,'91BBY','male','blue','blond','fair'),(35,'PadmÃ© Amidala',0,185,8,'46BBY','female','brown','brown','light'),(36,'Jar Jar Binks',12,196,8,'52BBY','male','orange','none','orange'),(37,'Roos Tarpals',12,224,8,'unknown','male','orange','none','grey'),(38,'Rugor Nass',12,206,8,'unknown','male','orange','none','green'),(39,'Ric OliÃ©',0,183,8,'unknown','male','blue','brown','fair'),(40,'Watto',13,137,34,'unknown','male','yellow','black','blue, grey'),(41,'Sebulba',14,112,35,'unknown','male','orange','none','grey, red'),(42,'Quarsh Panaka',0,183,8,'62BBY','male','brown','black','dark'),(43,'Shmi Skywalker',0,163,1,'72BBY','female','brown','black','fair'),(44,'Darth Maul',22,175,36,'54BBY','male','yellow','none','red'),(45,'Bib Fortuna',15,180,37,'unknown','male','pink','none','pale'),(46,'Ayla Secura',15,178,37,'48BBY','female','hazel','none','blue'),(47,'Ratts Tyerel',16,79,38,'unknown','male','unknown','none','grey, blue'),(48,'Dud Bolt',17,94,39,'unknown','male','yellow','none','blue, grey'),(49,'Gasgano',18,122,40,'unknown','male','black','none','white, blue'),(50,'Ben Quadinaros',19,163,41,'unknown','male','orange','none','grey, green, yellow'),(51,'Mace Windu',0,188,42,'72BBY','male','brown','none','dark'),(52,'Ki-Adi-Mundi',20,198,43,'92BBY','male','yellow','white','pale'),(53,'Kit Fisto',21,196,44,'unknown','male','black','none','green'),(54,'Eeth Koth',22,171,45,'unknown','male','brown','black','brown'),(55,'Adi Gallia',23,184,9,'unknown','female','blue','none','dark'),(56,'Saesee Tiin',24,188,47,'unknown','male','orange','none','pale'),(57,'Yarael Poof',25,264,48,'unknown','male','yellow','none','white'),(58,'Plo Koon',26,188,49,'22BBY','male','black','none','orange'),(59,'Mas Amedda',27,196,50,'unknown','male','blue','none','blue'),(60,'Gregar Typho',0,185,8,'unknown','male','brown','black','dark'),(61,'CordÃ©',0,157,8,'unknown','female','brown','brown','light'),(62,'Cliegg Lars',0,183,1,'82BBY','male','blue','brown','fair'),(63,'Poggle the Lesser',28,183,11,'unknown','male','yellow','none','green'),(64,'Luminara Unduli',29,170,51,'58BBY','female','blue','black','yellow'),(65,'Barriss Offee',29,166,51,'40BBY','female','blue','black','yellow'),(66,'DormÃ©',1,165,8,'unknown','female','brown','brown','light'),(67,'Dooku',1,193,52,'102BBY','male','brown','white','fair'),(68,'Bail Prestor Organa',1,191,2,'67BBY','male','brown','black','tan'),(69,'Jango Fett',0,183,53,'66BBY','male','brown','black','tan'),(70,'Zam Wesell',30,168,54,'unknown','female','yellow','blonde','fair, green, yellow'),(71,'Dexter Jettster',31,198,55,'unknown','male','yellow','none','brown'),(72,'Lama Su',32,229,10,'unknown','male','black','none','grey'),(73,'Taun We',32,213,10,'unknown','female','black','none','grey'),(74,'Jocasta Nu',1,167,9,'unknown','female','blue','white','fair'),(75,'R4-P17',0,96,28,'unknown','female','red, blue','none','silver, red'),(76,'Wat Tambor',33,193,56,'unknown','male','unknown','none','green, grey'),(77,'San Hill',34,191,57,'unknown','male','gold','none','grey'),(78,'Shaak Ti',35,178,58,'unknown','female','black','none','red, blue, white'),(79,'Grievous',36,216,59,'unknown','male','green, yellow','none','brown, white'),(80,'Tarfful',3,234,14,'unknown','male','blue','brown','brown'),(81,'Raymus Antilles',0,188,2,'unknown','male','brown','brown','light'),(82,'Sly Moore',0,178,60,'unknown','female','white','none','pale'),(83,'Tion Medon',37,206,12,'unknown','male','black','none','grey');
/*!40000 ALTER TABLE `people` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `planets`
--

DROP TABLE IF EXISTS `planets`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `planets` (
  `planet_id` int NOT NULL,
  `name` varchar(45) DEFAULT NULL,
  `climate` varchar(45) DEFAULT NULL,
  `terrain` varchar(45) DEFAULT NULL,
  `population` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`planet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `planets`
--

LOCK TABLES `planets` WRITE;
/*!40000 ALTER TABLE `planets` DISABLE KEYS */;
INSERT INTO `planets` VALUES (0,'',' unknown',' unknown',' unknown'),(1,'Tatooine','arid','desert','200000'),(2,'Alderaan','temperate','grasslands, mountains','2000000000'),(3,'Yavin IV','temperate, tropical','jungle, rainforests','1000'),(4,'Hoth','frozen','tundra, ice caves, mountain ranges','unknown'),(5,'Dagobah','murky','swamp, jungles','unknown'),(6,'Bespin','temperate','gas giant','6000000'),(7,'Endor','temperate','forests, mountains, lakes','30000000'),(8,'Naboo','temperate','grassy hills, swamps, forests, mountains','4500000000'),(9,'Coruscant','temperate','cityscape, mountains','1000000000000'),(10,'Kamino','temperate','ocean','1000000000'),(11,'Geonosis','temperate, arid','rock, desert, mountain, barren','100000000000'),(12,'Utapau','temperate, arid, windy','scrublands, savanna, canyons, sinkholes','95000000'),(13,'Mustafar','hot','volcanoes, lava rivers, mountains, caves','20000'),(14,'Kashyyyk','tropical','jungle, forests, lakes, rivers','45000000'),(15,'Polis Massa','artificial temperate ','airless asteroid','1000000'),(16,'Mygeeto','frigid','glaciers, mountains, ice canyons','19000000'),(17,'Felucia','hot, humid','fungus forests','8500000'),(18,'Cato Neimoidia','temperate, moist','mountains, fields, forests, rock arches','10000000'),(19,'Saleucami','hot','caves, desert, mountains, volcanoes','1400000000'),(20,'Stewjon','temperate','grass','unknown'),(21,'Eriadu','polluted','cityscape','22000000000'),(22,'Corellia','temperate','plains, urban, hills, forests','3000000000'),(23,'Rodia','hot','jungles, oceans, urban, swamps','1300000000'),(24,'Nal Hutta','temperate','urban, oceans, swamps, bogs','7000000000'),(25,'Dantooine','temperate','oceans, savannas, mountains, grasslands','1000'),(26,'Bestine IV','temperate','rocky islands, oceans','62000000'),(27,'Ord Mantell','temperate','plains, seas, mesas','4000000000'),(28,'unknown','unknown','unknown','unknown'),(29,'Trandosha','arid','mountains, seas, grasslands, deserts','42000000'),(30,'Socorro','arid','deserts, mountains','300000000'),(31,'Mon Cala','temperate','oceans, reefs, islands','27000000000'),(32,'Chandrila','temperate','plains, forests','1200000000'),(33,'Sullust','superheated','mountains, volcanoes, rocky deserts','18500000000'),(34,'Toydaria','temperate','swamps, lakes','11000000'),(35,'Malastare','arid, temperate, tropical','swamps, deserts, jungles, mountains','2000000000'),(36,'Dathomir','temperate','forests, deserts, savannas','5200'),(37,'Ryloth','temperate, arid, subartic','mountains, valleys, deserts, tundra','1500000000'),(38,'Aleen Minor','unknown','unknown','unknown'),(39,'Vulpter','temperate, artic','urban, barren','421000000'),(40,'Troiken','unknown','desert, tundra, rainforests, mountains','unknown'),(41,'Tund','unknown','barren, ash','0'),(42,'Haruun Kal','temperate','toxic cloudsea, plateaus, volcanoes','705300'),(43,'Cerea','temperate','verdant','450000000'),(44,'Glee Anselm','tropical, temperate','lakes, islands, swamps, seas','500000000'),(45,'Iridonia','unknown','rocky canyons, acid pools','unknown'),(46,'Tholoth','unknown','unknown','unknown'),(47,'Iktotch','arid, rocky, windy','rocky','unknown'),(48,'Quermia','unknown','unknown','unknown'),(49,'Dorin','temperate','unknown','unknown'),(50,'Champala','temperate','oceans, rainforests, plateaus','3500000000'),(51,'Mirial','unknown','deserts','unknown'),(52,'Serenno','unknown','rainforests, rivers, mountains','unknown'),(53,'Concord Dawn','unknown','jungles, forests, deserts','unknown'),(54,'Zolan','unknown','unknown','unknown'),(55,'Ojom','frigid','oceans, glaciers','500000000'),(56,'Skako','temperate','urban, vines','500000000000'),(57,'Muunilinst','temperate','plains, forests, hills, mountains','5000000000'),(58,'Shili','temperate','cities, savannahs, seas, plains','unknown'),(59,'Kalee','arid, temperate, tropical','rainforests, cliffs, canyons, seas','4000000000'),(60,'Umbara','unknown','unknown','unknown');
/*!40000 ALTER TABLE `planets` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `species`
--

DROP TABLE IF EXISTS `species`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `species` (
  `species_id` int NOT NULL,
  `classification` varchar(45) DEFAULT NULL,
  `language` varchar(45) DEFAULT NULL,
  `designation` varchar(45) DEFAULT NULL,
  `homeworld` int DEFAULT NULL,
  `name` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`species_id`),
  KEY `homeworld_idx` (`homeworld`),
  CONSTRAINT `species_ibfk_1` FOREIGN KEY (`homeworld`) REFERENCES `planets` (`planet_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `species`
--

LOCK TABLES `species` WRITE;
/*!40000 ALTER TABLE `species` DISABLE KEYS */;
INSERT INTO `species` VALUES (0,'unknown','unknown','unknown',0,'unknown'),(1,'mammal','Galactic Basic','sentient',9,'Human'),(2,'artificial','n/a','sentient',0,'Droid'),(3,'mammal','Shyriiwook','sentient',14,'Wookie'),(4,'sentient','Galatic Basic','reptilian',23,'Rodian'),(5,'gastropod','Huttese','sentient',24,'Hutt'),(6,'mammal','Galactic basic','sentient',28,'Yodas species'),(7,'reptile','Dosh','sentient',29,'Trandoshan'),(8,'amphibian','Mon Calamarian','sentient',31,'Mon Calamari'),(9,'mammal','Ewokese','sentient',7,'Ewok'),(10,'mammal','Sullutese','sentient',33,'Sullustan'),(11,'unknown','Neimoidia','sentient',18,'Neimodian'),(12,'amphibian','Gungan basic','sentient',8,'Gungan'),(13,'mammal','Toydarian','sentient',34,'Toydarian'),(14,'mammal','Dugese','sentient',35,'Dug'),(15,'mammals','Twileki','sentient',37,'Twilek'),(16,'reptile','Aleena','sentient',38,'Aleena'),(17,'unknown','vulpterish','sentient',39,'Vulptereen'),(18,'unknown','Xextese','sentient',40,'Xexto'),(19,'unknown','Tundan','sentient',41,'Toong'),(20,'mammal','Cerean','sentient',43,'Cerean'),(21,'amphibian','Nautila','sentient',44,'Nautolan'),(22,'mammal','Zabraki','sentient',45,'Zabrak'),(23,'mammal','unknown','sentient',46,'Tholothian'),(24,'unknown','Iktotchese','sentient',47,'Iktotchi'),(25,'mammal','Quermian','sentient',48,'Quermian'),(26,'unknown','Kel Dor','sentient',49,'Kel Dor'),(27,'amphibian','Chagria','sentient',50,'Chagrian'),(28,'insectoid','Geonosian','sentient',11,'Geonosian'),(29,'mammal','Mirialan','sentient',51,'Mirialan'),(30,'reptilian','Clawdite','sentient',54,'Clawdite'),(31,'amphibian','besalisk','sentient',55,'Besalisk'),(32,'amphibian','Kaminoan','sentient',10,'Kaminoan'),(33,'mammal','Skakoan','sentient',56,'Skakoan'),(34,'mammal','Muun','sentient',57,'Muun'),(35,'mammal','Togruti','sentient',58,'Togruta'),(36,'reptile','Kaleesh','sentient',59,'Kaleesh'),(37,'mammal','Utapese','sentient',12,'Pauan');
/*!40000 ALTER TABLE `species` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2022-11-12 15:36:39
