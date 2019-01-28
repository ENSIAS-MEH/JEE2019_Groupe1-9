-- phpMyAdmin SQL Dump
-- version 4.8.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jan 28, 2019 at 11:52 AM
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

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`AdminId`, `Email`, `Password`) VALUES
(1, 'anas@gmail.com', '1234');

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

--
-- Dumping data for table `choice`
--

INSERT INTO `choice` (`ChoiceId`, `Description`, `VotersNumber`, `PollId`) VALUES
(1, 'oh yeah ', 6, 13),
(2, 'nihaha ', 0, 13),
(3, 'ok', 0, 13),
(4, 'dsfkldslaf', 0, 14),
(5, 'sdfkfdslmfds', 0, 14),
(6, 'dsfkodsf', 0, 14),
(7, 'sdafdsa', 1, 15),
(8, 'asdfds', 10, 15),
(9, 'sdfsdg', 0, 15),
(10, 'who ', 0, 16),
(11, 'you', 1, 16),
(12, 'him', 0, 16),
(13, 'him', 0, 17),
(14, 'the guy you know', 0, 17),
(15, 'your best friend ', 0, 17),
(16, 'i din\'t konw', 0, 18),
(17, 'this not true ', 1, 18),
(18, 'I\'m not sure ', 0, 18),
(19, 'ok i\'m testing', 1, 19),
(20, 'no kidding', 0, 19),
(21, 'not really', 0, 19),
(22, 'this is a joke', 0, 19);

-- --------------------------------------------------------

--
-- Table structure for table `poll`
--

CREATE TABLE `poll` (
  `PollId` int(11) NOT NULL,
  `Description` text NOT NULL,
  `Category` varchar(50) NOT NULL,
  `UserId` int(11) NOT NULL,
  `pollDate` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `expires` date DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `poll`
--

INSERT INTO `poll` (`PollId`, `Description`, `Category`, `UserId`, `pollDate`, `expires`) VALUES
(1, 'This is the description of the poll', 'this is the category', 5, '2019-01-16 15:43:02', NULL),
(2, 'this is my test', 'an other test', 2, '2019-01-22 09:24:49', '2019-01-22'),
(17, 'who is jon snow', 'No category chosen', 7, '2019-01-27 16:14:02', '2019-01-02'),
(5, 'ok ok  this is my test', 'an other test', 2, '2019-01-22 10:06:48', '2019-01-22'),
(19, 'this is just a test', 'No category chosen', 5, '2019-01-28 10:44:27', '2019-02-15'),
(8, 'ok ok  this is my test', 'an other test', 2, '2019-01-22 10:11:34', '2019-01-22'),
(9, 'ok ok  this is my test', 'an other test', 2, '2019-01-22 10:11:44', '2019-01-22'),
(10, 'ok ok  this is my test', 'an other test', 2, '2019-01-22 10:13:16', '2019-01-22'),
(11, 'ok ok  this is my test', 'an other test', 2, '2019-01-22 10:14:16', '2019-01-22'),
(12, 'ok ok  this is my test', 'an other test', 2, '2019-01-22 10:15:31', '2019-01-22'),
(13, 'this one is from the app', 'No category chosen', 7, '2019-01-22 10:16:32', '2019-01-17'),
(14, 'this is just a test', 'No category chosen', 7, '2019-01-22 14:40:40', '2019-01-18'),
(15, 'ajsnfdjsa', 'No category chosen', 7, '2019-01-22 14:43:08', '2019-04-18'),
(16, 'this is just a test ?', 'No category chosen', 7, '2019-01-27 16:01:02', '2019-03-22'),
(18, 'this is just a test', 'No category chosen', 7, '2019-01-27 16:17:33', '2019-02-15');

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
  ADD UNIQUE KEY `vote_pk` (`ChoiceId`,`UserId`),
  ADD KEY `fk_user1` (`UserId`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `AdminId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `choice`
--
ALTER TABLE `choice`
  MODIFY `ChoiceId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT for table `poll`
--
ALTER TABLE `poll`
  MODIFY `PollId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `UserId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
