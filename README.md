# hrsystem
1) This Repository consists of 2 Systems(Backend and Frontend), each of it as a seperate system.
2) Technology stack used:
   1) Backend for API - Spring Boot
   2) Front End - ReactJS(using Create React App)
   3) Database - MySQL
   
# Setup

Database
--------
1) Create DB Schema in MySQL - hr_system
2) Username is: root , Password: root
3) When Spring boot App starts tables will be automatically created(enabled DDL)

Backend
-------
1) Start Spring Boot server which runs on port 5000

Frontend
--------
1) Start React Frontend on port 3000
2) Login using:
  1) Username = admin
  2) Password = password

Sample SQL
---------
1) Insert admin for Authentication

INSERT INTO `hr_system`.`admin`
(`id`,
`name`,
`role`,
`password`)
VALUES
(1,'admin','admin','password');
