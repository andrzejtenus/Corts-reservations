--
-- Dumping data for table `OpeningHours`
--

LOCK TABLES `opening_hours` WRITE;
INSERT INTO opening_hours VALUES 
(1, 0, "8:00:00", "16:00:00", 0), 
(2, 1, "8:00:00", "16:00:00", 1),
(3, 2, "8:00:00", "16:00:00", 1),
(4, 3, "8:00:00", "16:00:00", 1),
(5, 4, "8:00:00", "16:00:00", 1),
(6, 5, "8:00:00", "16:00:00", 1),
(7, 6, "8:00:00", "16:00:00", 0);
UNLOCK TABLES;

--
-- Dumping data for table `roles`
--
INSERT INTO roles(name) VALUES('ROLE_USER');
INSERT INTO roles(name) VALUES('ROLE_PM');
INSERT INTO roles(name) VALUES('ROLE_ADMIN');


