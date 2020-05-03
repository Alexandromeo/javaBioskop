-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 03, 2020 at 10:11 AM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bioskop`
--

-- --------------------------------------------------------

--
-- Table structure for table `movie_data`
--

CREATE TABLE `movie_data` (
  `md_id` bigint(11) NOT NULL,
  `md_title` varchar(255) NOT NULL,
  `md_price` int(11) NOT NULL,
  `md_stock` int(11) NOT NULL,
  `md_created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `movie_data`
--

INSERT INTO `movie_data` (`md_id`, `md_title`, `md_price`, `md_stock`, `md_created_at`) VALUES
(1, 'Titanic', 45000, 10, '2020-04-29 07:56:15'),
(2, 'Danur', 55000, 25, '2020-04-29 08:05:13'),
(3, 'Dilan', 50000, 40, '2020-04-30 03:12:15'),
(4, 'Cek Toko Sebelah', 50000, 35, '2020-05-01 04:02:15');

-- --------------------------------------------------------

--
-- Table structure for table `transaction_data`
--

CREATE TABLE `transaction_data` (
  `td_id` bigint(11) NOT NULL,
  `td_user` bigint(11) NOT NULL,
  `td_movie` bigint(11) NOT NULL,
  `td_amount` int(5) NOT NULL,
  `td_voucher` bigint(11) NOT NULL,
  `td_created_at` timestamp NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction_data`
--

INSERT INTO `transaction_data` (`td_id`, `td_user`, `td_movie`, `td_amount`, `td_voucher`, `td_created_at`) VALUES
(2, 16, 2, 2, 2, '2020-05-01 04:33:42'),
(3, 17, 1, 1, 1, '2020-05-01 04:38:11'),
(4, 16, 1, 1, 1, '2020-05-01 04:49:42'),
(8, 16, 3, 1, 3, '2020-05-03 04:22:46');

-- --------------------------------------------------------

--
-- Table structure for table `user_data`
--

CREATE TABLE `user_data` (
  `ud_id` bigint(11) NOT NULL,
  `ud_email` varchar(255) NOT NULL,
  `ud_password` varchar(255) NOT NULL,
  `ud_role` int(1) NOT NULL,
  `ud_saldo` int(10) NOT NULL,
  `ud_created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_data`
--

INSERT INTO `user_data` (`ud_id`, `ud_email`, `ud_password`, `ud_role`, `ud_saldo`, `ud_created_at`) VALUES
(12, 'alexandromeo@makinrajin.com', 'pass', 1, 0, '2020-04-28 13:17:54'),
(13, 'alexandromeo123@gmail.com', 'pass', 2, 0, '2020-04-28 13:18:22'),
(14, 'alex@gmail.com', 'pass', 1, 0, '2020-04-28 14:06:48'),
(15, 'a', 'a', 1, 0, '2020-04-29 07:16:28'),
(16, 'b', 'b', 2, 80000, '2020-05-03 04:22:46'),
(17, 'c', 'c', 2, 25000, '2020-05-03 01:24:21');

-- --------------------------------------------------------

--
-- Table structure for table `voucher_data`
--

CREATE TABLE `voucher_data` (
  `vd_id` bigint(11) NOT NULL,
  `vd_name` varchar(255) NOT NULL,
  `vd_discount` int(3) NOT NULL,
  `vd_duration` int(5) NOT NULL,
  `vd_created_at` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `voucher_data`
--

INSERT INTO `voucher_data` (`vd_id`, `vd_name`, `vd_discount`, `vd_duration`, `vd_created_at`) VALUES
(1, '', 0, 999999999, '2020-05-01 03:17:45'),
(2, 'COBASINI', 25, 10, '2020-04-30 06:19:26'),
(3, 'DIS10', 10, 5, '2020-05-01 03:17:18');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `movie_data`
--
ALTER TABLE `movie_data`
  ADD PRIMARY KEY (`md_id`);

--
-- Indexes for table `transaction_data`
--
ALTER TABLE `transaction_data`
  ADD PRIMARY KEY (`td_id`),
  ADD KEY `td_voucher` (`td_voucher`),
  ADD KEY `td_user` (`td_user`),
  ADD KEY `td_movie` (`td_movie`);

--
-- Indexes for table `user_data`
--
ALTER TABLE `user_data`
  ADD PRIMARY KEY (`ud_id`);

--
-- Indexes for table `voucher_data`
--
ALTER TABLE `voucher_data`
  ADD PRIMARY KEY (`vd_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `movie_data`
--
ALTER TABLE `movie_data`
  MODIFY `md_id` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `transaction_data`
--
ALTER TABLE `transaction_data`
  MODIFY `td_id` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `user_data`
--
ALTER TABLE `user_data`
  MODIFY `ud_id` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT for table `voucher_data`
--
ALTER TABLE `voucher_data`
  MODIFY `vd_id` bigint(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `transaction_data`
--
ALTER TABLE `transaction_data`
  ADD CONSTRAINT `transaction_data_ibfk_1` FOREIGN KEY (`td_voucher`) REFERENCES `voucher_data` (`vd_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaction_data_ibfk_2` FOREIGN KEY (`td_user`) REFERENCES `user_data` (`ud_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `transaction_data_ibfk_3` FOREIGN KEY (`td_movie`) REFERENCES `movie_data` (`md_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
