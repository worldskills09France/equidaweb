-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 18, 2025 at 05:20 PM
-- Server version: 11.8.5-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `equida`
--
CREATE DATABASE IF NOT EXISTS `equida` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_uca1400_ai_ci;
USE `equida`;

-- --------------------------------------------------------

--
-- Table structure for table `cheval`
--

CREATE TABLE `cheval` (
  `id` int(11) NOT NULL,
  `nom` varchar(150) NOT NULL,
  `date_naissance` date NOT NULL,
  `race_id` int(11) DEFAULT NULL,
  `sire` varchar(14) DEFAULT NULL,
  `robe_id` int(11) DEFAULT NULL,
  `proprietaire_id` int(11) DEFAULT NULL,
  `papa_id` int(11) DEFAULT NULL,
  `maman_id` int(11) DEFAULT NULL,
  `photo` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `cheval`
--

INSERT INTO `cheval` (`id`, `nom`, `date_naissance`, `race_id`, `sire`, `robe_id`, `proprietaire_id`, `papa_id`, `maman_id`, `photo`) VALUES
(1, 'Eclipse', '2017-03-12', 4, '00000000000001', 1, NULL, 3, 2, 'https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcT7FaBXCI-8AES646DtCzdrVFWBYlL0xq5xYQ&s'),
(2, 'Aztec', '2019-07-04', 4, '00000000000002', NULL, NULL, 5, 4, NULL),
(3, 'orion', '2015-05-23', 5, '00000000000003', NULL, NULL, NULL, NULL, NULL),
(4, 'Tempête de Feu', '2017-03-12', 1, '00000000000004', NULL, NULL, NULL, NULL, NULL),
(5, 'Éclair Noir', '2019-07-04', 2, '00000000000005', NULL, NULL, NULL, NULL, NULL),
(6, 'Vent du Nord', '2015-05-23', 3, '00000000000006', NULL, NULL, NULL, NULL, NULL),
(7, 'Comète', '2018-01-01', 4, '00000000000007', NULL, NULL, NULL, NULL, NULL),
(8, 'Silver Snow', '2020-11-17', 5, '00000000000008', NULL, NULL, NULL, NULL, NULL),
(9, 'Caramel', '2016-06-30', 6, '00000000000009', 1, NULL, NULL, NULL, NULL),
(10, 'Storm', '2021-10-10', 1, '00000000000010', NULL, NULL, NULL, NULL, NULL),
(11, 'Mustang', '2014-08-03', 2, '00000000000011', NULL, NULL, NULL, NULL, NULL),
(12, 'Rising Sun', '2019-04-22', 3, '00000000000012', NULL, NULL, NULL, NULL, NULL),
(13, 'Phantom', '2016-12-05', 4, '00000000000013', NULL, NULL, NULL, NULL, NULL),
(14, 'Pompom', '2025-07-13', 2, '00000000000014', NULL, NULL, NULL, NULL, NULL),
(15, 'Fleur du désert', '2023-06-30', 6, '00000000000015', NULL, NULL, NULL, NULL, NULL),
(16, 'Luis', '2005-12-22', 1, '00000000000016', NULL, NULL, NULL, NULL, NULL),
(17, 'sqdqs', '2025-11-25', 4, NULL, NULL, NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `course`
--

CREATE TABLE `course` (
  `id` int(11) NOT NULL,
  `prix` varchar(50) NOT NULL,
  `date` date NOT NULL,
  `ville` varchar(50) NOT NULL,
  `temps` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

--
-- Dumping data for table `course`
--

INSERT INTO `course` (`id`, `prix`, `date`, `ville`, `temps`) VALUES
(1, 'Dakar', '2025-11-11', 'Nice', '7min 30sec 25ms'),
(2, 'Worldskills', '2025-10-19', 'Marseille', '30min 57sec 15ms');

-- --------------------------------------------------------

--
-- Table structure for table `course_cheval`
--

CREATE TABLE `course_cheval` (
  `id_cheval` int(11) NOT NULL,
  `id_course` int(11) NOT NULL,
  `classement` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

--
-- Dumping data for table `course_cheval`
--

INSERT INTO `course_cheval` (`id_cheval`, `id_course`, `classement`) VALUES
(1, 1, 1),
(1, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `proprietaire`
--

CREATE TABLE `proprietaire` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

--
-- Dumping data for table `proprietaire`
--

INSERT INTO `proprietaire` (`id`, `nom`) VALUES
(1, 'LUIS'),
(2, 'JUNIOR');

-- --------------------------------------------------------

--
-- Table structure for table `race`
--

CREATE TABLE `race` (
  `id` int(11) NOT NULL,
  `nom` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `race`
--

INSERT INTO `race` (`id`, `nom`) VALUES
(1, 'Pur-sang anglais'),
(2, 'Quarter Horse'),
(3, 'Frison'),
(4, 'Andalou'),
(5, 'Lipizzan'),
(6, 'Mustang');

-- --------------------------------------------------------

--
-- Table structure for table `robe`
--

CREATE TABLE `robe` (
  `id` int(11) NOT NULL,
  `libelle` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_uca1400_ai_ci;

--
-- Dumping data for table `robe`
--

INSERT INTO `robe` (`id`, `libelle`) VALUES
(1, 'Alezan'),
(2, 'Bai'),
(3, 'Noir'),
(4, 'Gris'),
(5, 'Isabelle'),
(6, 'Pie');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cheval`
--
ALTER TABLE `cheval`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_race` (`race_id`),
  ADD KEY `fk_robe` (`robe_id`),
  ADD KEY `fk_proprietaire` (`proprietaire_id`),
  ADD KEY `fk_papa` (`papa_id`),
  ADD KEY `fk_maman` (`maman_id`);

--
-- Indexes for table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `course_cheval`
--
ALTER TABLE `course_cheval`
  ADD PRIMARY KEY (`id_cheval`,`id_course`),
  ADD KEY `fk_course` (`id_course`);

--
-- Indexes for table `proprietaire`
--
ALTER TABLE `proprietaire`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `race`
--
ALTER TABLE `race`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `robe`
--
ALTER TABLE `robe`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cheval`
--
ALTER TABLE `cheval`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `course`
--
ALTER TABLE `course`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `proprietaire`
--
ALTER TABLE `proprietaire`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `race`
--
ALTER TABLE `race`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `robe`
--
ALTER TABLE `robe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `cheval`
--
ALTER TABLE `cheval`
  ADD CONSTRAINT `fk_maman` FOREIGN KEY (`maman_id`) REFERENCES `cheval` (`id`),
  ADD CONSTRAINT `fk_papa` FOREIGN KEY (`papa_id`) REFERENCES `cheval` (`id`),
  ADD CONSTRAINT `fk_proprietaire` FOREIGN KEY (`proprietaire_id`) REFERENCES `proprietaire` (`id`),
  ADD CONSTRAINT `fk_race` FOREIGN KEY (`race_id`) REFERENCES `race` (`id`),
  ADD CONSTRAINT `fk_robe` FOREIGN KEY (`robe_id`) REFERENCES `robe` (`id`);

--
-- Constraints for table `course_cheval`
--
ALTER TABLE `course_cheval`
  ADD CONSTRAINT `fk_cheval` FOREIGN KEY (`id_cheval`) REFERENCES `cheval` (`id`),
  ADD CONSTRAINT `fk_course` FOREIGN KEY (`id_course`) REFERENCES `course` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
