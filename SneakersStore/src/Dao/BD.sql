//CRIAR BANCO DE DADOS E TABELA CLIENTE
create database sneakersstore

create table clients(
id int not null auto_increment,
clientCode varchar(255) not null,
clientCPF varchar(14) unique not null,
clientName varchar(255) not null,
clientDtBirth varchar(10),
clientEmail varchar(255) not null,
clientCellphone varchar(20),
clientDtLastBuy varchar(10),
clientPostcode varchar(255) not null,
clientAddress varchar(255) not null,
clientDistrict varchar(255) not null,
clientState varchar(2) not null,
clientCity varchar(255) not null,
primary key(id)
);

CREATE TABLE inventory (
  id int NOT NULL AUTO_INCREMENT,
  productCode varchar(255) NOT NULL,
  quantity int DEFAULT NULL,
  productQuantityAvailable int DEFAULT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE products (
  id int NOT NULL AUTO_INCREMENT,
  productCode varchar(255) NOT NULL,
  productCategory varchar(14) NOT NULL,
  productDescription varchar(255) NOT NULL,
  productDtRegistration Datetime,
  productQuantityAvailable int DEFAULT NULL,
  productActive varchar(1) DEFAULT NULL,
  productLocation varchar(255) NOT NULL,
  productPrice double NOT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY productCode (productCode)
)