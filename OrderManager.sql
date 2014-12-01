CREATE USER ordermanager@localhost identified BY '123456';
GRANT usage ON *.* TO ordermanager@localhost identified BY '123456';
CREATE DATABASE IF NOT EXISTS ordermanager;
GRANT ALL privileges ON ordermanager.* TO ordermanager@localhost;
USE ordermanager;
CREATE TABLE ordertable
  (
     id INT PRIMARY KEY AUTO_INCREMENT,
	 number VARCHAR(20),
     date VARCHAR(20),
	 theme VARCHAR(250),
	 filename varchar(100),
     notes varchar(1000),
	 type varchar(40),
     file longblob,
  created   TIMESTAMP DEFAULT NOW()
  );
