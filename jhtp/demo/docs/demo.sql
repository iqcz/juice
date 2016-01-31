drop table demo.address;
CREATE TABLE IF NOT EXISTS demo.address (
  ID int(10) unsigned NOT NULL auto_increment,
  username varchar(50) NOT NULL DEFAULT '' ,
  name varchar(50) NOT NULL DEFAULT '' ,
  sex varchar(10) ,
  mobile varchar(20) ,
  email varchar(50) ,
  qq varchar(20) ,
  company varchar(100) ,
  address varchar(100) ,
  postcode varchar(10) ,
  PRIMARY KEY (ID),
  UNIQUE KEY ID (ID),
   KEY ID_2 (ID)
);



#
# Dumping data for table 'demo.address'
#

INSERT INTO demo.address VALUES("1", "admin", "lzb", "男", "13812345678", "lzb@163.com", "12345678", "IBM", "北京市", "100085");
INSERT INTO demo.address VALUES("6", "admin", "admin", "mail", "13812345678", "abc@163.com", "12345678", "IBM", "北京市", "100085");
INSERT INTO demo.address VALUES("7", "admin", "test", "male", "13812345678", "ad@163.com", "12345678", "IBM", "北京市", "100085");
INSERT INTO demo.address VALUES("8", "admin", "test", "", "", "", "", "", "", "");
INSERT INTO demo.address VALUES("9", "admin", "test", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("10", "admin", "test", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("11", "admin", "test", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("12", "admin", "test", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("13", "admin", "test", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("14", "admin", "test", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("15", "admin", "test", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("16", "admin", "test", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("17", "admin", "test", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("18", "admin", "test", "", "", "", "", "", "", "");
INSERT INTO demo.address VALUES("19", "admin", "test", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("20", "admin", "test", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("21", "admin", "test", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("22", "admin", "test", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("23", "admin", "test", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("24", "admin", "test", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("25", "admin", "test", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("26", "admin", "test", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("27", "admin", "test", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("28", "admin", "test2", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("29", "admin", "test2", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("30", "admin", "test2", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("31", "admin", "test2", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("32", "admin", "test2", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("33", "admin", "test2", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("34", "admin", "test2", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("35", "admin", "test2", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("36", "admin", "test2", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("37", "admin", "test2", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("38", "admin", "test2", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("39", "admin", "test2", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("40", "admin", "test2", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("41", "admin", "test3", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("42", "admin", "test3", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("43", "admin", "test3", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("44", "admin", "test3", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("45", "admin", "test3", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("46", "admin", "test3", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("47", "admin", "test3", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("48", "admin", "test3", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("49", "admin", "test3", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("50", "admin", "test3", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("51", "admin", "test3", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("52", "admin", "test4", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("53", "admin", "test4", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("54", "admin", "test4", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("55", "admin", "test4", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("56", "admin", "test4", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("57", "admin", "test4", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("58", "admin", "test4", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("59", "admin", "test4", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("60", "admin", "test4", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("61", "admin", "test4", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("62", "admin", "test4", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("63", "admin", "test5", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("64", "admin", "test5", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("65", "admin", "test5", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("66", "admin", "test5", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("67", "admin", "test5", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("68", "admin", "test5", NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO demo.address VALUES("69", "admin", "test5", NULL, NULL, NULL, NULL, NULL, NULL, NULL);


#
# Table structure for table 'demo.meeting'
#

drop table demo.meeting;
CREATE TABLE IF NOT EXISTS demo.meeting (
  ID int(10) unsigned NOT NULL auto_increment,
  sender varchar(50) NOT NULL DEFAULT '' ,
  starttime varchar(20) ,
  endtime varchar(20) ,
  address varchar(100) ,
  title varchar(100) ,
  content text ,
  PRIMARY KEY (ID),
  UNIQUE KEY ID (ID),
   KEY ID_2 (ID)
);



#
# Dumping data for table 'demo.meeting'
#



#
# Table structure for table 'demo.notice'
#

drop table demo.notice;
CREATE TABLE IF NOT EXISTS demo.notice (
  ID int(10) unsigned NOT NULL auto_increment,
  sender varchar(50) NOT NULL DEFAULT '' ,
  title varchar(100) ,
  content text ,
  sendtime varchar(20) ,
  PRIMARY KEY (ID),
  UNIQUE KEY ID (ID),
   KEY ID_2 (ID)
);



#
# Dumping data for table 'demo.notice'
#



#
# Table structure for table 'demo.schedule'
#

drop table demo.schedule;
CREATE TABLE IF NOT EXISTS demo.schedule (
  ID int(10) unsigned NOT NULL auto_increment,
  username varchar(50) NOT NULL DEFAULT '' ,
  year int(4) ,
  month int(2) ,
  day int(2) ,
  plan text ,
  PRIMARY KEY (ID),
  UNIQUE KEY ID (ID),
   KEY ID_2 (ID)
);



#
# Dumping data for table 'demo.schedule'
#



#
# Table structure for table 'demo.sms'
#

drop table demo.sms;
CREATE TABLE IF NOT EXISTS demo.sms (
  ID int(10) unsigned NOT NULL auto_increment,
  username varchar(50) NOT NULL DEFAULT '' ,
  sender varchar(50) NOT NULL DEFAULT '' ,
  message text ,
  sendtime varchar(20) ,
  isRead varchar(1) DEFAULT '0' ,
  PRIMARY KEY (ID),
  UNIQUE KEY ID (ID),
   KEY ID_2 (ID)
);



#
# Dumping data for table 'demo.sms'
#



#
# Table structure for table 'demo.user'
#

drop table demo.user;
CREATE TABLE IF NOT EXISTS demo.user (
  ID int(10) unsigned NOT NULL auto_increment,
  username varchar(50) ,
  password varchar(50) ,
  email varchar(50) ,
  PRIMARY KEY (ID),
  UNIQUE KEY ID (ID),
   KEY ID_2 (ID)
);



#
# Dumping data for table 'demo.user'
#

INSERT INTO demo.user VALUES("1", "admin", "admin", "abc@163.com");


#
# Table structure for table 'demo.worklog'
#

drop table demo.worklog;
CREATE TABLE IF NOT EXISTS demo.worklog (
  ID int(10) unsigned NOT NULL auto_increment,
  username varchar(50) NOT NULL DEFAULT '' ,
  year int(4) ,
  month int(2) ,
  day int(2) ,
  title varchar(100) ,
  description text ,
  logtime varchar(20) ,
  PRIMARY KEY (ID),
  UNIQUE KEY ID (ID),
   KEY ID_2 (ID)
);



#
# Dumping data for table 'demo.worklog'
#

