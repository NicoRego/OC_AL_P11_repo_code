DROP DATABASE IF EXISTS `pocapi`;
CREATE DATABASE `pocapi`;

USE pocapi;

DROP TABLE IF EXISTS `hospital`;
CREATE TABLE `hospital` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `free_beds` int NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `specialty`;
CREATE TABLE `specialty` (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

DROP TABLE IF EXISTS `hospital_specialty`;
CREATE TABLE hospital_specialty (
hospital_id INT NOT NULL,
specialty_id INT NOT NULL,
FOREIGN KEY (hospital_id) REFERENCES hospital (id) ON DELETE CASCADE ON UPDATE CASCADE,
FOREIGN KEY (specialty_id) REFERENCES specialty (id) ON DELETE CASCADE ON UPDATE CASCADE,
PRIMARY KEY (hospital_id, specialty_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;
