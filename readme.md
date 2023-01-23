My follow along from the course spring-cloud-fundamentals on Udemy...

create database mydb;

use mydb

create table product(
id int AUTO_INCREMENT PRIMARY KEY,
name varchar(20),
description varchar(100),
price decimal(8,3) 
);

create table coupon(
id int AUTO_INCREMENT PRIMARY KEY,
code varchar(20),
discount decimal(8,3),
exp_date varchar(100) 
);

Note you must have a local git repo holding a 

product-service.properties
and
product-service-dev.properties

with values like:

spring.datasource.url=jdbc:mysql://localhost:3306/mydb
spring.datasource.username=root
spring.datasource.password=root

server.port=9091

spring.application.name=product-service
eureka.instance.prefer-ip-address=true
