-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Apr 12, 2025 at 11:41 AM
-- Server version: 8.2.0
-- PHP Version: 8.2.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tttn`
--

-- --------------------------------------------------------

--
-- Table structure for table `hieusuat`
--

DROP TABLE IF EXISTS `hieusuat`;
CREATE TABLE IF NOT EXISTS `hieusuat` (
  `Mahieusuat` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `Ngaydanhgia` date DEFAULT NULL,
  `Diem` int DEFAULT NULL,
  `Muctieu` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Kpi` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Ketqua` varchar(200) COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`Mahieusuat`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `luong`
--

DROP TABLE IF EXISTS `luong`;
CREATE TABLE IF NOT EXISTS `luong` (
  `Maluong` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `Thangluong` int NOT NULL,
  `Tonggiolam` int NOT NULL,
  `Luongcoban` decimal(18,2) NOT NULL,
  `Tangca` decimal(18,2) NOT NULL,
  `Thuongphat` decimal(18,2) DEFAULT NULL,
  `Phucap` decimal(18,2) DEFAULT NULL,
  `Tienthue` decimal(18,2) DEFAULT NULL,
  `Tienbaohiem` decimal(18,2) DEFAULT NULL,
  `Phucloi` decimal(18,2) DEFAULT NULL,
  PRIMARY KEY (`Maluong`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `nhanvien`
--

DROP TABLE IF EXISTS `nhanvien`;
CREATE TABLE IF NOT EXISTS `nhanvien` (
  `Manhanvien` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `Tennhanvien` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `ngaysinh` datetime(6) DEFAULT NULL,
  `CCCD` varchar(12) COLLATE utf8mb4_general_ci NOT NULL,
  `Diachi` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `SDT` varchar(15) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Email` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `pass` varchar(100) COLLATE utf8mb4_general_ci NOT NULL,
  `role` varchar(100) COLLATE utf8mb4_general_ci NOT NULL DEFAULT 'nhanvien',
  `Trangthailamviec` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
  PRIMARY KEY (`Manhanvien`),
  UNIQUE KEY `CCCD` (`CCCD`),
  UNIQUE KEY `Email` (`Email`),
  UNIQUE KEY `SDT` (`SDT`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `nhanvien`
--

INSERT INTO `nhanvien` (`Manhanvien`, `Tennhanvien`, `ngaysinh`, `CCCD`, `Diachi`, `SDT`, `Email`, `pass`, `role`, `Trangthailamviec`, `password`) VALUES
('1', 'Nguyễn Việt Phương', '2016-04-12 00:00:00.000000', '123456', 'abcd', '012345679', 'phuong@gmail.com', '', 'nhanvien', 'đang làm việc', ''),
('2', 'Thong', '2016-04-18 00:00:00.000000', '123459', 'hgvhg', '02615156', 'thong@gmail.com', '123', 'nhanvien', 'đang làm việc', '');

-- --------------------------------------------------------

--
-- Table structure for table `phucloi`
--

DROP TABLE IF EXISTS `phucloi`;
CREATE TABLE IF NOT EXISTS `phucloi` (
  `Maphucloi` varchar(10) COLLATE utf8mb4_general_ci NOT NULL,
  `Loaiphucloi` varchar(50) COLLATE utf8mb4_general_ci NOT NULL,
  `Mota` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL,
  `Ngayhieuluc` date NOT NULL,
  `Giatriphucloi` decimal(18,2) NOT NULL,
  PRIMARY KEY (`Maphucloi`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
