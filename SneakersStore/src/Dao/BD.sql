--CRIAR BANCO DE DADOS E TABELA CLIENTE
--Executar o comado de alter table apenas nas tabelas de Clients e Products
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
clientObs LONGTEXT,
primary key(id)
);

-- ALTER TABLE `sneakersstore`.`clients` 
-- ADD COLUMN `clientObs` LONGTEXT NULL AFTER `clientCity`;



CREATE TABLE products (
  id int NOT NULL AUTO_INCREMENT,
  productCode varchar(255) NOT NULL,
  productCategory varchar(14) NOT NULL,
  productDescription varchar(255) NOT NULL,
  productDtRegistration Datetime,
  productQuantityAvailable int DEFAULT 0 NOT NULL,
  productActive varchar(1) DEFAULT NULL,
  productLocation varchar(255) NOT NULL,
  productPrice double NOT NULL,
  producSize char(2) NOT NULL,
  productObs longtext,
  PRIMARY KEY (id),
  UNIQUE KEY productCode (productCode)
);

-- ALTER TABLE `sneakersstore`.`products` 
-- ADD COLUMN `productSize` CHAR(2) NOT NULL AFTER `productPrice`;

-- ALTER TABLE `sneakersstore`.`products` 
-- ADD COLUMN `productObs` LONGTEXT NULL AFTER `productSize`;



// Implementação futura para o PDV aguardando tela

CREATE TABLE inventory (
  id int NOT NULL AUTO_INCREMENT,
  productCode varchar(255) NOT NULL,
  quantity int DEFAULT NULL,
  PRIMARY KEY (id)
);

create table sale(
`idSale` int not null auto_increment,
`clientCPF` varchar(14) not null,
`formaPagamento` char(2) not null,
`vlTotal` double not null,
`vlDesc` double not null,
`postcode` varchar(255) NOT NULL,
`address` varchar(255) NOT NULL,
`district` varchar(255) NOT NULL,
`state` varchar(2) NOT NULL,
`city` varchar(255) NOT NULL,
`date` DATETIME,
primary key(idSale)
)

CREATE TABLE `itenssale` (
  `id` int NOT NULL AUTO_INCREMENT,
  `idSale` int not null,
  `productCode` varchar(255) NOT NULL,
  `quantity` int NOT NULL,
  `vlUnit` double not null,
  PRIMARY KEY (`id`),
  FOREIGN KEY (idSale) REFERENCES sale(idSale)
)

DELIMITER $
CREATE TRIGGER TG_itensSale_I AFTER INSERT
ON itensSale
FOR EACH ROW
BEGIN
	UPDATE products SET productQuantityAvailable = productQuantityAvailable - NEW.quantity
WHERE productCode = NEW.productCode;
END$

CREATE TRIGGER TG_ItensSale_D AFTER DELETE
ON itensSale
FOR EACH ROW
BEGIN
	UPDATE products SET productQuantityAvailable = productQuantityAvailable + OLD.quantity
WHERE productCode = OLD.productCode;
END$

DELIMITER ;

