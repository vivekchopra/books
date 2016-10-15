
CREATE DATABASE bookstore;
USE bookstore;

DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL default '',
  `description` varchar(200) NOT NULL default '',
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;
INSERT INTO `category` (`id`,`name`,`description`) VALUES (1,'Technical','Technical Books relating to programming languages, databases design methods and patterns.'),(2,'Biography','Biographical books of famous people.'),(3,'Cooking','Books to fit all your culinary needs, for experienced and beginners alike.'),(4,'Travel','Plan your next overseas trip, or even a trip down the highway with our comprehensive selection of travel books.');

DROP TABLE IF EXISTS `customerorder`;
CREATE TABLE `customerorder` (
  `id` int(11) NOT NULL auto_increment,
  `firstname` varchar(100) NOT NULL default '',
  `lastname` varchar(100) NOT NULL default '',
  `address` varchar(100) NOT NULL default '',
  `zipcode` varchar(10) NOT NULL default '',
  `orderdate` datetime NOT NULL default '0000-00-00 00:00:00',
  `status` int(11) NOT NULL default '0',
  `cardnumber` varchar(20) NOT NULL default '',
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;
INSERT INTO `customerorder` (`id`,`firstname`,`lastname`,`address`,`zipcode`,`orderdate`,`status`,`cardnumber`) VALUES (9,'Rupert','Jones','1234blahj','12345','2004-08-21 00:00:00',2,'4111111111111111'),(8,'Rupert','Jones','1234 Blag St St','123456','2004-08-21 00:00:00',2,'4111111111111111');

DROP TABLE IF EXISTS `orderitem`;
CREATE TABLE `orderitem` (
  `bookid` int(11) NOT NULL default '0',
  `orderid` int(11) default '0',
  `qty` int(11) NOT NULL default '0',
  `id` int(11) NOT NULL auto_increment,
  `unitprice` float NOT NULL default '0',
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;
INSERT INTO `orderitem` (`bookid`,`orderid`,`qty`,`id`,`unitprice`) VALUES (3,9,1,16,39.67),(1,9,10,15,59.99),(2,9,1,14,49.99),(2,8,1,13,49.99),(1,8,1,12,59.99),(6,8,1,11,18);

DROP TABLE IF EXISTS `orderstatus`;
CREATE TABLE `orderstatus` (
  `id` int(11) NOT NULL default '0',
  `name` varchar(20) NOT NULL default '',
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;
INSERT INTO `orderstatus` (`id`,`name`) VALUES (1,'DECLINED PAYMENT'),(2,'APPROVED PAYMENT');

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(100) NOT NULL default '',
  `description` varchar(200) NOT NULL default '',
  `unitprice` float NOT NULL default '0',
  `category` int(11) NOT NULL default '0',
  PRIMARY KEY  (`id`)
) TYPE=MyISAM;
INSERT INTO `book` (`id`,`name`,`description`,`unitprice`,`category`) VALUES (1,'Beginning JSP','This book!',59.99,1),(2,'Apache Tomcat Bible','A book on Apache Tomcat',49.99,1),(3,'Professional Apache Tomcat 5','Tomcat expertise from experienced developers for experienced developers',39.67,1),(4,'Leadership','Biography of Rudi Giulliani',29.99,2),(5,'Cooking For One','Excellent cooking tips for the beginner',19.95,3),(6,'North America','Travel tips and information for visitors to North America.',18,4);
