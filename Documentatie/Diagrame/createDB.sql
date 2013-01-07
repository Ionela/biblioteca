SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

DROP SCHEMA IF EXISTS `biblioteca` ;
CREATE SCHEMA IF NOT EXISTS `biblioteca` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `biblioteca` ;

-- -----------------------------------------------------
-- Table `biblioteca`.`Carti`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Carti` ;

CREATE  TABLE IF NOT EXISTS `biblioteca`.`Carti` (
  `idCarte` INT NOT NULL AUTO_INCREMENT ,
  `cota` VARCHAR(10) NOT NULL ,
  `titlu` VARCHAR(200) NULL ,
  `autori` VARCHAR(200) NULL ,
  `isbn` VARCHAR(45) NULL ,
  `editura` VARCHAR(100) NULL ,
  `locAparitie` VARCHAR(100) NULL ,
  `anAparitie` INT NULL ,
  `observatii` VARCHAR(400) NULL ,
  `durataImprumut` INT NULL DEFAULT 1 ,
  PRIMARY KEY (`idCarte`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca`.`Useri`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Useri` ;

CREATE  TABLE IF NOT EXISTS `biblioteca`.`Useri` (
  `idUser` INT NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(45) NOT NULL ,
  `password` VARCHAR(45) NOT NULL ,
  `nume` VARCHAR(50) NULL ,
  `email` VARCHAR(45) NULL ,
  `telefon` VARCHAR(45) NULL ,
  `adresa` VARCHAR(100) NULL ,
  `drepturi` INT NULL DEFAULT 0 ,
  PRIMARY KEY (`idUser`) ,
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca`.`Imprumuturi`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Imprumuturi` ;

CREATE  TABLE IF NOT EXISTS `biblioteca`.`Imprumuturi` (
  `idImprumut` INT NOT NULL AUTO_INCREMENT ,
  `idCarte` INT NOT NULL ,
  `idUser` INT NOT NULL ,
  `dinData` DATE NULL ,
  `panaInData` DATE NULL ,
  `Imprumuturicol` VARCHAR(45) NULL ,
  PRIMARY KEY (`idImprumut`) ,
  INDEX `FK_imprumuturi_carti_idx` (`idCarte` ASC) ,
  INDEX `FK_imprumuturi_useri_idx` (`idUser` ASC) ,
  UNIQUE INDEX `idCarte_UNIQUE` (`idCarte` ASC) ,
  CONSTRAINT `FK_imprumuturi_carti`
    FOREIGN KEY (`idCarte` )
    REFERENCES `biblioteca`.`Carti` (`idCarte` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_imprumuturi_useri`
    FOREIGN KEY (`idUser` )
    REFERENCES `biblioteca`.`Useri` (`idUser` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `biblioteca`.`Rezervari`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `biblioteca`.`Rezervari` ;

CREATE  TABLE IF NOT EXISTS `biblioteca`.`Rezervari` (
  `idRezervare` INT NOT NULL AUTO_INCREMENT ,
  `idUser` INT NULL ,
  `idCarte` INT NULL ,
  `dinData` DATE NULL ,
  `panaInData` DATE NULL ,
  PRIMARY KEY (`idRezervare`) ,
  INDEX `FK_idUser_idx` (`idUser` ASC) ,
  INDEX `FK_rezervari_carti_idx` (`idCarte` ASC) ,
  CONSTRAINT `FK_rezercari_useri`
    FOREIGN KEY (`idUser` )
    REFERENCES `biblioteca`.`Useri` (`idUser` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `FK_rezervari_carti`
    FOREIGN KEY (`idCarte` )
    REFERENCES `biblioteca`.`Carti` (`idCarte` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- -----------------------------------------------------
-- Data for table `biblioteca`.`Useri`
-- -----------------------------------------------------
START TRANSACTION;
USE `biblioteca`;
INSERT INTO `biblioteca`.`Useri` (`idUser`, `username`, `password`, `nume`, `email`, `telefon`, `adresa`, `drepturi`) VALUES (1, 'admin', 'admin', 'Administrator', 'admin@yahoo.com', '0751958115', 'Brasov', 2);

COMMIT;
