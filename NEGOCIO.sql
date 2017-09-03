-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 31, 2017 at 10:14 PM
-- Server version: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `omc`
--

-- --------------------------------------------------------

--
-- Table structure for table `NEGOCIO`
--

CREATE TABLE `negocio` (
  `CD_NGOCO` int(11) NOT NULL,
  `NM_CIA` varchar(100) NOT NULL,
  `CD_RAMO` int(11) NOT NULL,
  `CD_APOLICE` int(11) NOT NULL,
  `CD_APOLICE_SUSEP` int(11) NOT NULL,
  `CD_MDUPR` int(11) NOT NULL,
  `DS_MDUPR` varchar(100) NOT NULL,
  `DT_EMISSAO` date NOT NULL,
  `DT_INICIO_VIGEN` date NOT NULL,
  `DT_FIM_VIGEN` date NOT NULL,
  `CD_SITUC_NGOCO` varchar(100) NOT NULL,
  `CD_ESTPL` int(11) NOT NULL,
  `DT_VIGEN_PROPOR` date NOT NULL,
  `CD_GRP_PRDUT` int(11) NOT NULL,
  `DS_GrpPrdut` varchar(100) NOT NULL,
  `CD_PLACA` varchar(100) NOT NULL,
  `CD_CHASSI` varchar(100) NOT NULL,
  `NR_ITSEG` int(11) NOT NULL,
  `CD_CORRETOR` int(11) NOT NULL,
  `NM_CORRETOR` varchar(100) NOT NULL,
  `CD_SUCURSAL` int(11) NOT NULL,
  `NM_SUCURSAL` varchar(100) NOT NULL,
  `ST_NEGOCIO` varchar(100) NOT NULL,
  `CD_ENDOSSO` int(11) NOT NULL,
  `CD_CLIEN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `NEGOCIO`
--
ALTER TABLE `NEGOCIO`
  ADD PRIMARY KEY (`CD_NGOCO`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `NEGOCIO`
--
ALTER TABLE `NEGOCIO`
  MODIFY `CD_NGOCO` int(11) NOT NULL AUTO_INCREMENT;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;


select * from negocio;