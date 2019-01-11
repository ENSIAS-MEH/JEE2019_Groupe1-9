-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  mer. 09 jan. 2019 à 09:29
-- Version du serveur :  5.7.21
-- Version de PHP :  5.6.35

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `votingsystem`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

DROP TABLE IF EXISTS `admin`;
CREATE TABLE IF NOT EXISTS `admin` (
  `AdminId` int(11) NOT NULL AUTO_INCREMENT,
  `Email` varchar(200) NOT NULL,
  `Password` varchar(200) NOT NULL,
  PRIMARY KEY (`AdminId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `choice`
--

DROP TABLE IF EXISTS `choice`;
CREATE TABLE IF NOT EXISTS `choice` (
  `ChoiceId` int(11) NOT NULL AUTO_INCREMENT,
  `Description` text NOT NULL,
  `VotersNumber` int(11) NOT NULL,
  `PollId` int(11) NOT NULL,
  PRIMARY KEY (`ChoiceId`),
  FOREIGN KEY fk_poll (`PollId`)
  REFERENCES `poll` (`PollId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `poll`
--

DROP TABLE IF EXISTS `poll`;
CREATE TABLE IF NOT EXISTS `poll` (
  `PollId` int(11) NOT NULL AUTO_INCREMENT,
  `Description` text NOT NULL,
  `Duration` int(11) NOT NULL,
  `Category` varchar(50) NOT NULL,
  `UserId` int(11) NOT NULL,
  PRIMARY KEY (`PollId`),
  FOREIGN KEY fk_user (`UserId`)
  REFERENCES `user` (`UserId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

DROP TABLE IF EXISTS `user`;
CREATE TABLE IF NOT EXISTS `user` (
  `UserId` int(11) NOT NULL AUTO_INCREMENT,
  `Password` varchar(200) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `BirthDate` varchar(12) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Nationality` varchar(20) NOT NULL,
  `IsActive` int(11) NOT NULL,
  `ProfileImage` varchar(100) NOT NULL,
  PRIMARY KEY (`UserId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `vote`
--

DROP TABLE IF EXISTS `vote`;
CREATE TABLE IF NOT EXISTS `vote` (
  `Type` varchar(20) NOT NULL,
  `ChoiceId` int(11) NOT NULL,
  `UserId` int(11) NOT NULL,
  PRIMARY KEY (`ChoiceId`,`UserId`),
  FOREIGN KEY fk_user1 (`UserId`)
  REFERENCES `user` (`UserId`),  
  FOREIGN KEY fk_choice (`ChoiceId`)
  REFERENCES `choice` (`ChoiceId`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
