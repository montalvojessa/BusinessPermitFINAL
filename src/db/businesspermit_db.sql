-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 22, 2025 at 03:07 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `businesspermit_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `applications`
--

CREATE TABLE `applications` (
  `application_id` int(11) NOT NULL,
  `u_id` int(11) DEFAULT NULL,
  `username` varchar(50) NOT NULL,
  `firstname` varchar(50) NOT NULL,
  `lastname` varchar(50) NOT NULL,
  `business_name` varchar(100) NOT NULL,
  `business_type` varchar(100) NOT NULL,
  `barangay_clearance_no` varchar(50) NOT NULL,
  `status` varchar(20) DEFAULT 'pending',
  `submitted_at` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `applications`
--

INSERT INTO `applications` (`application_id`, `u_id`, `username`, `firstname`, `lastname`, `business_name`, `business_type`, `barangay_clearance_no`, `status`, `submitted_at`) VALUES
(7, 14, 'rhex123', 'delima', 'rhex', 'Juan Eatery', 'Food', 'DhFHSH1234124', 'approved', '2025-05-22 12:18:35');

-- --------------------------------------------------------

--
-- Table structure for table `tbl_log`
--

CREATE TABLE `tbl_log` (
  `log_id` int(11) NOT NULL,
  `u_id` int(11) NOT NULL,
  `u_username` varchar(50) NOT NULL,
  `login_time` timestamp NOT NULL DEFAULT current_timestamp(),
  `u_type` varchar(50) NOT NULL,
  `log_status` enum('Pending','Active','Inactive','') NOT NULL,
  `logout_time` timestamp NULL DEFAULT NULL,
  `log_description` text DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_log`
--

INSERT INTO `tbl_log` (`log_id`, `u_id`, `u_username`, `login_time`, `u_type`, `log_status`, `logout_time`, `log_description`) VALUES
(1, 28, 'hanseo123', '2025-03-29 12:45:06', 'Success - User Login', 'Active', NULL, ''),
(2, 24, 'paran1234', '2025-03-29 12:45:19', 'Success - Admin Login', 'Inactive', '2025-03-30 10:54:31', ''),
(3, 28, 'hanseo123', '2025-03-29 12:50:24', 'Success - User Login', 'Active', NULL, ''),
(4, 24, 'paran1234', '2025-03-29 12:50:35', 'Success - Admin Login', 'Inactive', '2025-03-30 10:54:31', ''),
(5, 24, 'paran1234', '2025-03-29 12:59:13', 'Success - Admin Login', 'Inactive', '2025-03-30 10:54:31', ''),
(6, 24, 'paran1234', '2025-03-29 12:59:58', 'Success - Admin Login', 'Inactive', '2025-03-30 10:54:31', ''),
(7, 24, 'paran1234', '2025-03-29 13:00:25', 'Success - Admin Login', 'Inactive', '2025-03-30 10:54:31', ''),
(8, 24, 'paran1234', '2025-03-29 13:05:20', 'Success - Admin Login', 'Inactive', '2025-03-30 10:54:31', ''),
(9, 24, 'paran1234', '2025-03-30 10:49:16', 'Success - Admin Login', 'Inactive', '2025-03-30 10:54:31', ''),
(10, 24, 'paran1234', '2025-03-30 10:54:26', 'Success - Admin Login', 'Inactive', '2025-03-30 10:54:31', ''),
(12, 29, 'beboy123', '2025-03-30 11:57:38', 'Success - User Login', 'Active', NULL, ''),
(13, 29, 'beboy123', '2025-03-30 12:48:21', 'Success - User Login', 'Active', NULL, ''),
(14, 29, 'beboy123', '2025-03-30 12:50:04', 'Success - User Login', 'Active', NULL, ''),
(15, 29, 'beboy123', '2025-03-30 12:53:56', 'Success - User Login', 'Active', NULL, ''),
(16, 29, 'beboy123', '2025-03-30 13:02:29', 'Success - User Login', 'Active', NULL, ''),
(17, 29, 'beboy123', '2025-03-30 13:02:39', 'Success - User Login', 'Active', NULL, ''),
(18, 29, 'beboy123', '2025-03-30 13:05:06', 'Success - User Login', 'Active', NULL, ''),
(19, 24, 'paran1234', '2025-04-12 12:24:45', 'Success - Admin Login', 'Inactive', '2025-04-12 12:26:23', NULL),
(20, 24, 'paran1234', '2025-04-12 12:25:34', 'Admin', 'Inactive', '2025-04-12 12:26:23', 'Admin Added a New Account: frans123'),
(21, 24, 'paran1234', '2025-04-12 12:28:05', 'Success - Admin Login', 'Inactive', '2025-04-12 13:35:50', NULL),
(22, 31, 'jay123', '2025-04-12 13:02:46', 'Failed - Inactive Account', 'Inactive', '2025-04-12 13:03:29', NULL),
(23, 31, 'jay123', '2025-04-12 13:03:28', 'Success - User Login', 'Inactive', '2025-04-12 13:03:29', NULL),
(24, 31, 'jay123', '2025-04-12 13:03:44', 'User Reset Their Password', 'Inactive', '2025-04-12 13:07:26', NULL),
(25, 31, 'jay123', '2025-04-12 13:06:55', 'Success - User Action', 'Inactive', '2025-04-12 13:07:26', 'User Reset Their Password'),
(26, 31, 'jay123', '2025-04-12 13:07:24', 'Success - User Login', 'Inactive', '2025-04-12 13:07:26', NULL),
(27, 33, 'rhex123', '2025-04-12 13:32:58', 'Success - User Action', 'Inactive', '2025-04-26 04:16:48', 'New user registered: rhex123'),
(28, 31, 'jay123', '2025-04-12 13:33:58', 'Success - User Login', 'Inactive', '2025-04-12 13:34:00', NULL),
(30, 31, 'jay123', '2025-04-12 13:34:23', 'Success - User Login', 'Inactive', '2025-04-12 13:34:39', NULL),
(31, 31, 'jay123', '2025-04-12 13:34:37', 'Success - User Action', 'Inactive', '2025-04-12 13:34:39', 'User Changed Their Password'),
(32, 31, 'jay123', '2025-04-12 13:35:00', 'Success - User Login', 'Active', NULL, NULL),
(33, 24, 'paran1234', '2025-04-12 13:35:22', 'Success - Admin Login', 'Inactive', '2025-04-12 13:35:50', NULL),
(34, 24, 'paran1234', '2025-04-12 13:35:30', 'Admin', 'Inactive', '2025-04-12 13:35:50', 'Deleted user account with ID: 12'),
(35, 33, 'rhex123', '2025-04-15 12:27:30', 'Success - User Login', 'Inactive', '2025-04-26 04:16:48', NULL),
(36, 33, 'rhex123', '2025-04-15 12:28:58', 'Success - User Login', 'Inactive', '2025-04-26 04:16:48', NULL),
(37, 33, 'rhex123', '2025-04-15 12:31:38', 'Success - User Login', 'Inactive', '2025-04-26 04:16:48', NULL),
(38, 24, 'paran1234', '2025-04-15 12:33:20', 'Success - Admin Login', 'Inactive', '2025-04-15 12:33:33', NULL),
(39, 24, 'paran1234', '2025-04-15 12:34:02', 'Success - Admin Login', 'Inactive', '2025-04-26 04:42:39', NULL),
(40, 24, 'paran1234', '2025-04-15 12:34:44', 'Success - Admin Login', 'Inactive', '2025-04-26 04:42:39', NULL),
(41, 24, 'paran1234', '2025-04-15 12:36:35', 'Success - Admin Login', 'Inactive', '2025-04-26 04:42:39', NULL),
(42, 24, 'paran1234', '2025-04-15 12:43:08', 'Success - Admin Login', 'Inactive', '2025-04-26 04:42:39', NULL),
(43, 24, 'paran1234', '2025-04-15 12:46:08', 'Success - Admin Login', 'Inactive', '2025-04-26 04:42:39', NULL),
(44, 24, 'paran1234', '2025-04-15 12:49:35', 'Success - Admin Login', 'Inactive', '2025-04-26 04:42:39', NULL),
(45, 33, 'rhex123', '2025-04-15 12:52:17', 'Success - User Login', 'Inactive', '2025-04-26 04:16:48', NULL),
(46, 33, '', '2025-04-15 12:52:26', 'Success - User Action', 'Active', NULL, 'User Reset Their Password'),
(47, 33, 'rhex123', '2025-04-15 12:55:09', 'Success - User Login', 'Inactive', '2025-04-26 04:16:48', NULL),
(48, 33, '', '2025-04-15 12:55:18', 'Success - User Action', 'Active', NULL, 'User Loan a Money'),
(49, 33, 'rhex123', '2025-04-15 12:58:04', 'Success - User Login', 'Inactive', '2025-04-26 04:16:48', NULL),
(50, 33, 'rhex123', '2025-04-15 12:58:12', 'Success - User Action', 'Inactive', '2025-04-26 04:16:48', 'User Loan a Money'),
(51, 24, 'paran1234', '2025-04-15 13:04:11', 'Success - Admin Login', 'Inactive', '2025-04-26 04:42:39', NULL),
(52, 24, 'paran1234', '2025-04-15 13:06:27', 'Success - Admin Login', 'Inactive', '2025-04-26 04:42:39', NULL),
(53, 24, 'paran1234', '2025-04-15 13:09:27', 'Success - Admin Login', 'Inactive', '2025-04-26 04:42:39', NULL),
(54, 24, 'paran1234', '2025-04-15 13:09:30', 'Success - User Action', 'Inactive', '2025-04-26 04:42:39', 'Admin approved Loan ID: 3'),
(55, 24, 'paran1234', '2025-04-15 13:11:40', 'Success - Admin Login', 'Inactive', '2025-04-26 04:42:39', NULL),
(56, 24, 'paran1234', '2025-04-15 13:11:44', 'Success - User Action', 'Inactive', '2025-04-26 04:42:39', 'Admin rejected Loan ID: 2'),
(57, 33, 'rhex123', '2025-04-15 13:56:19', 'Success - User Login', 'Inactive', '2025-04-26 04:16:48', NULL),
(58, 33, 'rhex123', '2025-04-26 04:16:42', 'Success - User Login', 'Inactive', '2025-04-26 04:16:48', NULL),
(59, 33, 'rhex123', '2025-04-26 04:17:22', 'Success - User Login', 'Inactive', '2025-04-26 04:32:07', NULL),
(60, 33, 'rhex123', '2025-04-26 04:22:06', 'Success - User Login', 'Inactive', '2025-04-26 04:32:07', NULL),
(61, 33, 'rhex123', '2025-04-26 04:25:25', 'Success - User Login', 'Inactive', '2025-04-26 04:32:07', NULL),
(62, 33, 'rhex123', '2025-04-26 04:26:17', 'Success - User Login', 'Inactive', '2025-04-26 04:32:07', NULL),
(63, 33, 'rhex123', '2025-04-26 04:28:24', 'Success - User Login', 'Inactive', '2025-04-26 04:32:07', NULL),
(64, 33, 'rhex123', '2025-04-26 04:29:12', 'Success - User Login', 'Inactive', '2025-04-26 04:32:07', NULL),
(65, 33, 'rhex123', '2025-04-26 04:30:22', 'Success - User Login', 'Inactive', '2025-04-26 04:32:07', NULL),
(66, 33, 'rhex123', '2025-04-26 04:31:44', 'Success - User Login', 'Inactive', '2025-04-26 04:32:07', NULL),
(67, 33, 'rhex123', '2025-04-26 04:32:04', 'Success - User Action', 'Inactive', '2025-04-26 04:32:07', 'User Loan a Money'),
(68, 24, 'paran1234', '2025-04-26 04:32:14', 'Success - Admin Login', 'Inactive', '2025-04-26 04:42:39', NULL),
(69, 24, 'paran1234', '2025-04-26 04:36:50', 'Success - Admin Login', 'Inactive', '2025-04-26 04:42:39', NULL),
(70, 24, 'paran1234', '2025-04-26 04:39:02', 'Success - Admin Login', 'Inactive', '2025-04-26 04:42:39', NULL),
(71, 24, 'paran1234', '2025-04-26 04:42:27', 'Success - Admin Login', 'Inactive', '2025-04-26 04:42:39', NULL),
(72, 24, 'paran1234', '2025-04-26 04:42:31', 'Success - User Action', 'Inactive', '2025-04-26 04:42:39', 'Admin approved Loan ID: 5'),
(73, 33, 'rhex123', '2025-04-26 04:42:46', 'Success - User Login', 'Inactive', '2025-04-26 04:46:09', NULL),
(74, 24, 'paran1234', '2025-04-26 04:44:28', 'Success - Admin Login', 'Inactive', '2025-04-26 04:44:39', NULL),
(75, 24, 'paran1234', '2025-04-26 04:44:33', 'Success - User Action', 'Inactive', '2025-04-26 04:44:39', 'Admin approved Loan ID: 4'),
(80, 33, 'rhex123', '2025-04-26 04:45:49', 'Success - User Login', 'Inactive', '2025-04-26 04:46:09', NULL),
(81, 33, 'rhex123', '2025-04-26 04:46:07', 'Success - User Action', 'Inactive', '2025-04-26 04:46:09', 'User Loan a Money'),
(82, 33, 'rhex123', '2025-04-26 04:49:59', 'Success - User Login', 'Inactive', '2025-04-26 04:50:00', NULL),
(83, 24, 'paran1234', '2025-04-26 04:50:08', 'Success - Admin Login', 'Inactive', '2025-04-26 04:51:31', NULL),
(84, 24, 'paran1234', '2025-04-26 04:50:13', 'Success - User Action', 'Inactive', '2025-04-26 04:51:31', 'Admin approved Loan ID: 6'),
(85, 33, 'rhex123', '2025-04-26 04:51:02', 'Success - User Login', 'Inactive', '2025-04-26 04:53:53', NULL),
(86, 33, 'rhex123', '2025-04-26 04:51:12', 'Success - User Action', 'Inactive', '2025-04-26 04:53:53', 'User Loan a Money'),
(87, 24, 'paran1234', '2025-04-26 04:51:22', 'Success - Admin Login', 'Inactive', '2025-04-26 04:51:31', NULL),
(88, 24, 'paran1234', '2025-04-26 04:51:28', 'Success - User Action', 'Inactive', '2025-04-26 04:51:31', 'Admin approved Loan ID: 7'),
(89, 33, 'rhex123', '2025-04-26 04:51:42', 'Success - User Login', 'Inactive', '2025-04-26 04:53:53', NULL),
(90, 33, 'rhex123', '2025-04-26 04:53:34', 'Success - User Login', 'Inactive', '2025-04-26 04:53:53', NULL),
(91, 33, 'rhex123', '2025-04-26 04:53:51', 'Success - User Action', 'Inactive', '2025-04-26 04:53:53', 'User Loan a Money'),
(92, 24, 'paran1234', '2025-04-26 04:54:23', 'Success - Admin Login', 'Inactive', '2025-04-26 04:54:32', NULL),
(93, 24, 'paran1234', '2025-04-26 04:54:27', 'Success - User Action', 'Inactive', '2025-04-26 04:54:32', 'Admin approved Loan ID: 8'),
(94, 33, 'rhex123', '2025-04-26 04:54:48', 'Success - User Login', 'Inactive', '2025-04-26 04:54:51', NULL),
(95, 33, 'rhex123', '2025-04-26 04:58:13', 'Success - User Login', 'Inactive', '2025-04-26 04:58:30', NULL),
(96, 33, 'rhex123', '2025-04-26 04:58:27', 'Success - User Action', 'Inactive', '2025-04-26 04:58:30', 'User Loan a Money'),
(97, 24, 'paran1234', '2025-04-26 04:58:37', 'Success - Admin Login', 'Inactive', '2025-04-26 04:58:46', NULL),
(98, 24, 'paran1234', '2025-04-26 04:58:41', 'Success - User Action', 'Inactive', '2025-04-26 04:58:46', 'Admin approved Loan ID: 9'),
(99, 33, 'rhex123', '2025-04-26 04:59:04', 'Success - User Login', 'Inactive', '2025-04-26 05:01:26', NULL),
(100, 33, 'rhex123', '2025-04-26 05:01:24', 'Success - User Login', 'Inactive', '2025-04-26 05:01:26', NULL),
(102, 33, 'rhex123', '2025-04-26 05:04:46', 'Success - User Login', 'Inactive', '2025-04-26 05:04:54', NULL),
(103, 34, 'greg123', '2025-04-26 05:10:01', 'Success - User Action', 'Inactive', '2025-04-26 05:10:39', 'New user registered: greg123'),
(104, 34, 'greg123', '2025-04-26 05:10:28', 'Success - User Login', 'Inactive', '2025-04-26 05:10:39', NULL),
(105, 34, 'greg123', '2025-04-26 05:10:38', 'Success - User Action', 'Inactive', '2025-04-26 05:10:39', 'User Loan a Money'),
(106, 24, 'paran1234', '2025-04-26 05:10:46', 'Success - Admin Login', 'Inactive', '2025-04-26 05:10:54', NULL),
(107, 24, 'paran1234', '2025-04-26 05:10:50', 'Success - User Action', 'Inactive', '2025-04-26 05:10:54', 'Admin approved Loan ID: 10'),
(169, 35, 'shasha123', '2025-05-22 13:01:35', 'Success - User Action', 'Inactive', '2025-05-22 13:04:39', 'New user registered: shasha123'),
(170, 35, 'shasha123', '2025-05-22 13:01:52', 'Success - User Login', 'Inactive', '2025-05-22 13:04:39', NULL),
(171, 35, 'shasha123', '2025-05-22 13:04:38', 'Success - User Login', 'Inactive', '2025-05-22 13:04:39', NULL),
(172, 36, 'montalvo123', '2025-05-22 13:05:12', 'Success - User Action', 'Inactive', '2025-05-22 13:05:44', 'New user registered: montalvo123'),
(173, 36, 'montalvo123', '2025-05-22 13:05:19', 'Failed - Inactive Account', 'Inactive', '2025-05-22 13:05:44', NULL),
(174, 36, 'montalvo123', '2025-05-22 13:05:41', 'Success - Admin Login', 'Inactive', '2025-05-22 13:05:44', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `tbl_users`
--

CREATE TABLE `tbl_users` (
  `u_id` int(11) NOT NULL,
  `u_fname` varchar(50) NOT NULL,
  `u_lname` varchar(50) NOT NULL,
  `u_email` varchar(50) NOT NULL,
  `u_username` varchar(255) NOT NULL,
  `u_password` varchar(50) NOT NULL,
  `u_type` varchar(50) NOT NULL,
  `u_status` varchar(50) NOT NULL,
  `security_question` varchar(255) NOT NULL,
  `security_answer` varchar(255) NOT NULL,
  `u_image` varchar(500) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `tbl_users`
--

INSERT INTO `tbl_users` (`u_id`, `u_fname`, `u_lname`, `u_email`, `u_username`, `u_password`, `u_type`, `u_status`, `security_question`, `security_answer`, `u_image`) VALUES
(14, 'kayeshea', 'basilan', 'kaye123@gmail.com', 'kaye1233', 'NBYWrmoA/JoDM/ch9Tgq8p41ekFyon8BzFcia+U+AQc=', 'Admin', 'Active', '', '', ''),
(21, 'ross', 'sabio', 'rosssabio@gmail.com', 'ross1234', 'NBYWrmoA/JoDM/ch9Tgq8p41ekFyon8BzFcia+U+AQc=', 'Admin', 'Active', '', '', ''),
(22, 'daniel', 'failadona', 'danielfailadona@gmail.com', 'daniel1234', 'NBYWrmoA/JoDM/ch9Tgq8p41ekFyon8BzFcia+U+AQc=', 'Admin', 'Active', '', '', ''),
(24, 'benjohns', 'parans', 'benjohn@gmail.com', 'paran1234', 'ky88G1YlfOhTmsJp16q0JVDaz4gY0HXwvfGZBWKq4+8=', 'Admin', 'Active', '', '', 'src/images/471615836_1140707197730657_5811624390488339862_n.jpg'),
(25, 'sarno', 'mamen', 'sarnomamen@gmail.com', 'mamen123', 'ky88G1YlfOhTmsJp16q0JVDaz4gY0HXwvfGZBWKq4+8=', 'User', 'Active', '', '', ''),
(28, 'han', 'seo', 'hanseo@gmail.com', 'hanseo123', 'ky88G1YlfOhTmsJp16q0JVDaz4gY0HXwvfGZBWKq4+8=', 'User', 'Active', '', '', ''),
(29, 'beboy', 'padriga', 'beboypadriga@gmail.com', 'beboy123', 'DR6kwlbNUKKnzL/SKz2ZWfb9ML2EC5/zx8Ze5OId8G0=', 'User', 'Active', 'What\'s the name of your first pet?', 'browny', 'C:\\Users\\milan\\OneDrive\\Desktop\\Odin\\src\\images\\462574929_1530386207674650_925214417452153602_n.jpg'),
(30, 'frans', 'ababa', 'fransababa@gmail.com', 'frans123', 'ky88G1YlfOhTmsJp16q0JVDaz4gY0HXwvfGZBWKq4+8=', 'Pending', 'User', 'What\'s the name of your first pet?', 'OstyYRKvTUuxwHH/PXNPTcb9/gMXt56CfKg7QYENPfA=', 'frans123_462581453_1264063778238587_8963988102995952736_n.jpg'),
(31, 'jay', 'boss', 'jayboss@gmail.com', 'jay123', 'ky88G1YlfOhTmsJp16q0JVDaz4gY0HXwvfGZBWKq4+8=', 'User', 'Active', 'What\'s the name of your first pet?', 'OstyYRKvTUuxwHH/PXNPTcb9/gMXt56CfKg7QYENPfA=', 'Null'),
(32, 'mark', 'pacaldo', 'markpacaldo@gmail.com', 'mark123', 'ky88G1YlfOhTmsJp16q0JVDaz4gY0HXwvfGZBWKq4+8=', 'User', 'Active', 'What\'s the name of your first pet?', 'Fkd2iMDgBpnGz6RJejYS1+g8UyBitkslD+2JCBKO1Ug=', 'Null'),
(33, 'delima', 'rhex', 'delimarhex@gmail.com', 'rhex123', 'ky88G1YlfOhTmsJp16q0JVDaz4gY0HXwvfGZBWKq4+8=', 'User', 'Active', 'What\'s the name of your first pet?', 'Fkd2iMDgBpnGz6RJejYS1+g8UyBitkslD+2JCBKO1Ug=', 'Null'),
(34, 'greg', 'boss', 'gregboss@gmail.com', 'greg123', 'ky88G1YlfOhTmsJp16q0JVDaz4gY0HXwvfGZBWKq4+8=', 'Admin', 'Active', 'What\'s your favorite food?', '3kM+1VChYkp0J5qjDDa1LyhEJmEMAUtwAi5MiJ68qHU=', 'src/images/467719808_849346147222609_1601374335414698002_n.jpg'),
(35, 'sha', 'sha', 'shasha@gmail.com', 'shasha123', 'ky88G1YlfOhTmsJp16q0JVDaz4gY0HXwvfGZBWKq4+8=', 'User', 'Active', 'What\'s the name of your first pet?', 'Fkd2iMDgBpnGz6RJejYS1+g8UyBitkslD+2JCBKO1Ug=', 'Null'),
(36, 'mon', 'ja', 'montalvo@gmail.com', 'montalvo123', 'ky88G1YlfOhTmsJp16q0JVDaz4gY0HXwvfGZBWKq4+8=', 'Admin', 'Active', 'What\'s your favorite food?', '3kM+1VChYkp0J5qjDDa1LyhEJmEMAUtwAi5MiJ68qHU=', 'Null');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `applications`
--
ALTER TABLE `applications`
  ADD PRIMARY KEY (`application_id`),
  ADD KEY `u_id` (`u_id`);

--
-- Indexes for table `tbl_log`
--
ALTER TABLE `tbl_log`
  ADD PRIMARY KEY (`log_id`),
  ADD KEY `fk_log_user_id` (`u_id`);

--
-- Indexes for table `tbl_users`
--
ALTER TABLE `tbl_users`
  ADD PRIMARY KEY (`u_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `applications`
--
ALTER TABLE `applications`
  MODIFY `application_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `tbl_log`
--
ALTER TABLE `tbl_log`
  MODIFY `log_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=175;

--
-- AUTO_INCREMENT for table `tbl_users`
--
ALTER TABLE `tbl_users`
  MODIFY `u_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=37;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `applications`
--
ALTER TABLE `applications`
  ADD CONSTRAINT `applications_ibfk_1` FOREIGN KEY (`u_id`) REFERENCES `tbl_users` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `tbl_log`
--
ALTER TABLE `tbl_log`
  ADD CONSTRAINT `fk_log_user_id` FOREIGN KEY (`u_id`) REFERENCES `tbl_users` (`u_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
