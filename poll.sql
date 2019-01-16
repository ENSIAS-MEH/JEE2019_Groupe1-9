-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 16, 2019 at 02:37 PM
-- Server version: 5.7.21
-- PHP Version: 7.1.19

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `poll`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `AdminId` int(11) NOT NULL,
  `Email` varchar(200) NOT NULL,
  `Password` varchar(200) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `choice`
--

CREATE TABLE `choice` (
  `ChoiceId` int(11) NOT NULL,
  `Description` text NOT NULL,
  `VotersNumber` int(11) NOT NULL,
  `PollId` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `poll`
--

CREATE TABLE `poll` (
  `PollId` int(11) NOT NULL,
  `Description` text NOT NULL,
  `Duration` int(11) NOT NULL,
  `Category` varchar(50) NOT NULL,
  `UserId` int(11) NOT NULL,
  `question` text NOT NULL,
  `_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `_number_choices` int(2) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `UserId` int(11) NOT NULL,
  `Password` varchar(200) NOT NULL,
  `Email` varchar(100) NOT NULL,
  `FirstName` varchar(50) NOT NULL,
  `LastName` varchar(50) NOT NULL,
  `BirthDate` varchar(12) DEFAULT NULL,
  `Gender` varchar(10) DEFAULT NULL,
  `Nationality` varchar(20) DEFAULT NULL,
  `IsActive` int(11) NOT NULL,
  `ProfileImage` varchar(100) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`UserId`, `Password`, `Email`, `FirstName`, `LastName`, `BirthDate`, `Gender`, `Nationality`, `IsActive`, `ProfileImage`) VALUES
(1, 'passwordtest', 'mailtest@gmail.com', 'fnametest', 'lnametest', '12-11-2000', 'male', 'moroccan', 1, 'https://localhost:80808'),
(2, 'qwer123', 'anass@gmail.com', 'Anass', 'BAIROUK', NULL, NULL, NULL, 1, NULL),
(3, 'anass123', 'bairouk@gmail.com', 'bihy', 'bihy', '22-12-2012', 'male', 'amazigh', 1, 'http://ensias.com/nothing'),
(4, 'password', 'email@gmail.com', 'firstName', 'lastName', 'maroc', 'hoooooomme', '1999-01-01', 1, 'profileImage'),
(5, 'qwerty', 'bairoukanasa5@gmail.com', 'Anass', 'BAIROUK', NULL, NULL, NULL, 1, NULL),
(6, 'qwerty', 'bairoukanasa5@hotmail.com', 'Anass', 'BAIROUK', NULL, NULL, NULL, 1, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `vote`
--

CREATE TABLE `vote` (
  `Type` varchar(20) NOT NULL,
  `ChoiceId` int(11) NOT NULL,
  `UserId` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`AdminId`);

--
-- Indexes for table `choice`
--
ALTER TABLE `choice`
  ADD PRIMARY KEY (`ChoiceId`),
  ADD KEY `fk_poll` (`PollId`);

--
-- Indexes for table `poll`
--
ALTER TABLE `poll`
  ADD PRIMARY KEY (`PollId`),
  ADD KEY `fk_user` (`UserId`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`UserId`),
  ADD UNIQUE KEY `Email` (`Email`);

--
-- Indexes for table `vote`
--
ALTER TABLE `vote`
  ADD PRIMARY KEY (`ChoiceId`,`UserId`),
  ADD KEY `fk_user1` (`UserId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `AdminId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `choice`
--
ALTER TABLE `choice`
  MODIFY `ChoiceId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `poll`
--
ALTER TABLE `poll`
  MODIFY `PollId` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `UserId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
