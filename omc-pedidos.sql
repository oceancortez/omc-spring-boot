DROP DATABASE IF EXISTS OMC;

CREATE DATABASE IF NOT EXISTS OMC;

USE OMC;

CREATE TABLE `omc`.`cliente` (
  `CODCLI` BIGINT NOT NULL AUTO_INCREMENT,
  `NOMCLI` VARCHAR(100) NOT NULL,
  `DATCADCLI` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `DATULTALTCLI` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`CODCLI`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


CREATE TABLE `category` (
    `CODCAT` BIGINT NOT NULL AUTO_INCREMENT,
    `NAMCAT` VARCHAR(150) NOT NULL UNIQUE,
    `DESCAT` MEDIUMTEXT,
    `PICCAT` LONGBLOB,
    `DATCADCAT` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
	`DATULTALTCAT` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    CONSTRAINT `PK_Category` PRIMARY KEY (`CODCAT`))
    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8; 
    

INSERT INTO category VALUES(null,'Produce','Dried fruit and bean curd', null, null, null);
INSERT INTO category VALUES(null,'Condiments','Dried fruit and bean curd', null, null, null);
INSERT INTO category VALUES(null,'Confections','Dried fruit and bean curd',null, null, null);
INSERT INTO category VALUES(null,'Dairy ','Dried fruit and bean curd',null, null, null);

select * from category;

-- -----------------------------------------------------------------------------


CREATE TABLE `omc`.`produto` (
  `CODPRD` BIGINT NOT NULL AUTO_INCREMENT,
  `NOMPRD` VARCHAR(100) NOT NULL,
  `VLRPRD` DECIMAL(10,4) NOT NULL DEFAULT 0,
  `DATCADPRD` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `DATULTALTPRD` TIMESTAMP NOT NULL  DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`CODPRD`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

ALTER TABLE `omc`.`produto` 
ADD COLUMN `QTDPRD` INT NOT NULL AFTER `VLRPRD`;

ALTER TABLE `omc`.`produto` 
ADD UNIQUE INDEX `NOMPRD_UNIQUE` (`NOMPRD` ASC);

-- ------------------------- Create table category
ALTER TABLE `omc`.`produto` 
ADD COLUMN `CODCAT` BIGINT(20) NOT NULL AFTER `DATULTALTPRD`;

ALTER TABLE `omc`.`produto` 
ADD INDEX `FK_CODCAT_idx` (`CODCAT` ASC);

UPDATE `omc`.`produto` SET `CODCAT`='1' WHERE `CODPRD`> 0;

ALTER TABLE `omc`.`produto` 
ADD CONSTRAINT `FK_CODCAT`
  FOREIGN KEY (`CODCAT`)
  REFERENCES `omc`.`category` (`CODCAT`)
  ON DELETE NO ACTION
  ON UPDATE NO ACTION;

select * from `omc`.`produto` ;


-- --------------------------------------------------------------------------------------------------------

CREATE TABLE `omc`.`pedido` (
  `CODPED` BIGINT NOT NULL,
  `CODCLI` BIGINT NOT NULL,
  `CODPRD` BIGINT NOT NULL,
  `DATCADPED` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `DATULTALTPED` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`CODPED`),
  INDEX `FK_CODCLIE_idx` (`CODCLI` ASC),
  INDEX `FK_CODPRD_idx` (`CODPRD` ASC),
  CONSTRAINT `FK_CODCLIE`
    FOREIGN KEY (`CODCLI`)
    REFERENCES `omc`.`cliente` (`CODCLI`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_CODPRD`
    FOREIGN KEY (`CODPRD`)
    REFERENCES `omc`.`produto` (`CODPRD`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

ALTER TABLE `omc`.`pedido` 
ADD COLUMN `NOMPED` VARCHAR(45) NOT NULL AFTER `CODPED`;

ALTER TABLE `omc`.`pedido` 
CHANGE COLUMN `CODPRD` `CODPRD` BIGINT(20) NOT NULL AFTER `CODPED`;

ALTER TABLE `omc`.`pedido` 
DROP PRIMARY KEY,
ADD PRIMARY KEY (`CODPED`, `CODPRD`);

ALTER TABLE `omc`.`produto` 
ADD UNIQUE INDEX `NOMPRD_UNIQUE` (`NOMPRD` ASC);

-- ----------------------------------------------------------------------------


-- ALTER TABLE `omc`.`pedido` 
-- DROP PRIMARY KEY,
-- ADD PRIMARY KEY (`CODPED`);


-- DROP TABLE PEDIDO;
-- DROP TABLE CLIENTE;
-- DROP TABLE PRODUTO;



 -- INSERT INTO `omc`.`cliente` (`NOMCLI`) VALUES ('OXI LTDA');
select * from omc.cliente;

--  INSERT INTO `OMC`.`PRODUTO`(`NOMPRD`) VALUES ('PRODUTO DO OXI');
select * from omc.PRODUTO;
-- delete from omc.produto where codprd = 1;
  -- delete from omc.produto where codprd > 28;

-- INSERT INTO `omc`.`pedido` (`CODPED`, `CODCLI`, `CODPRD`) VALUES ('1', '1', '1');
select * from omc.pedido;

-- delete from omc.pedido where codped > 0;


select * from omc.cliente c;

select * from omc.cliente c
left join omc.pedido ped  on ped.codcli = c.codcli
where c.codcli = 3;


select * from omc.category;

-- change de password
-- GRANT ALL PRIVILEGES ON *.* TO 'root'@'localhost' IDENTIFIED BY '' WITH GRANT OPTION;

-- Error Code: 1451. Cannot delete or update a parent row: a foreign key constraint fails (`omc`.`pedido`, CONSTRAINT `FK_CODPRD` FOREIGN KEY (`CODPRD`) REFERENCES `produto` (`CODPRD`) ON DELETE NO ACTION ON UPDATE NO ACTION)







