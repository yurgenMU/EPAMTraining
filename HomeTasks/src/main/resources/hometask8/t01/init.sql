CREATE DATABASE IF NOT EXISTS EPAMdb;

USE EPAMdb;

CREATE TABLE IF NOT EXISTS epamdb.players (
  `id`        INT         NOT NULL AUTO_INCREMENT
  COMMENT '',
  `FirstName` VARCHAR(45) NOT NULL
  COMMENT '',
  `LastName`  VARCHAR(45) NULL
  COMMENT '',
  PRIMARY KEY (`id`)
    COMMENT ''
);

INSERT INTO epamdb.players
(
  FirstName,
  LastName)
VALUES
  ('Sergio', 'Romero'), ('David', 'de Gea'), ('Juan', 'Mata'), ('Michael', 'Carrick');
