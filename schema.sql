CREATE DATABASE IF NOT EXISTS mydb CHARACTER SET = 'utf8mb4' COLLATE 'utf8mb4_unicode_ci';

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
