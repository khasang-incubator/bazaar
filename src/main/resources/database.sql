-- Clean table
DROP TABLE Human ;
DROP TABLE City ;
DROP TABLE Specialty ;

--Clean tables users & roles
DROP TABLE users;
DROP TABLE roles;

--Create table for users & roles
CREATE TABLE users (
  id INTEGER PRIMARY KEY NOT NULL ,
  name VARCHAR(255),
  login VARCHAR(255),
  password VARCHAR(255),
  role_id INTEGER
);

CREATE TABLE roles(
  id INTEGER PRIMARY KEY NOT NULL ,
  role_name VARCHAR(255)
);

INSERT INTO users VALUES (1,'admin','admin','$2a$04$md8jevFeaNNt9U02kjT3qeoud8J9KvXjHwlh5oJTKrdKyHTLx4C3q',1);
INSERT INTO roles VALUES (1,'ROLE_ADMIN');
INSERT INTO roles VALUES (2,'ROLE_USER');

--SELECT login, password, TRUE FROM users WHERE login = 'admin';
--SELECT u.login, r.role_name FROM users u JOIN roles r ON u.role_id = r.id where login = 'admin';
--SELECT u.login, r.role_name FROM users u, roles r where u.role_id = r.id and login = 'admin';

CREATE TABLE Human (
  key1 INT NOT NULL,
  name VARCHAR(50),
  field2 INT,
  key2 INT NOT NULL,
  key3 INT NOT NULL,
  PRIMARY KEY (key1));


CREATE TABLE City (
  key2 INT NOT NULL,
  cityname VARCHAR(50),
  field2 VARCHAR(1),
  field3 VARCHAR(1),
  PRIMARY KEY (key2));



CREATE TABLE Specialty (
  key3 INT NOT NULL,
  namespecialty VARCHAR(50),
  PRIMARY KEY (key3));


INSERT INTO Human VALUES (3, 'Erik', 8, 1, 6) ;
INSERT INTO Human VALUES (5, 'John', 3, 4, 4) ;
INSERT INTO Human VALUES (6, 'Mark', 3, 7, 1) ;
INSERT INTO Human VALUES (7, 'Peter', 6, 8, 5) ;
INSERT INTO Human VALUES (8, 'Harry', 0, 9, 2) ;

INSERT INTO City VALUES (1, 'New York', 'A', 'N') ;
INSERT INTO City VALUES (2, 'Sao Paulo', 'B', 'N') ;
INSERT INTO City VALUES (4, 'Paris', 'C', 'Y') ;
INSERT INTO City VALUES (5, 'London', 'C', 'Y') ;
INSERT INTO City VALUES (6, 'Rome', 'C', 'Y') ;
INSERT INTO City VALUES (9, 'Madrid', 'C', 'Y') ;
INSERT INTO City VALUES (0, 'Bangalore', 'D', 'N') ;

INSERT INTO Specialty VALUES (1, 'Engineer') ;
INSERT INTO Specialty VALUES (2, 'Surgeon') ;
INSERT INTO Specialty VALUES (3, 'DBA') ;
INSERT INTO Specialty VALUES (4, 'Lawyer') ;
INSERT INTO Specialty VALUES (5, 'Teacher') ;
INSERT INTO Specialty VALUES (6, 'Actor') ;

