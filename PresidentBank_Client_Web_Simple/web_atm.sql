-- phpMyAdmin SQL Dump
-- version 4.8.2
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Mar 22, 2019 at 04:08 AM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `web_atm`
--

-- --------------------------------------------------------

--
-- Table structure for table `accounts`
--

CREATE TABLE `accounts` (
  `id` int(11) NOT NULL,
  `uuid` char(36) NOT NULL,
  `user_id` int(11) NOT NULL,
  `name` char(50) NOT NULL,
  `balance` double NOT NULL,
  `created_at` datetime NOT NULL,
  `updated_at` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `accounts`
--

INSERT INTO `accounts` (`id`, `uuid`, `user_id`, `name`, `balance`, `created_at`, `updated_at`) VALUES
(1, '5b060fd3-3bf0-4c16-bbdd-e355a9b51ee8', 3, '551533916', 11000000, '2019-03-20 12:15:21', '2019-03-20 12:22:24'),
(2, 'afdb71e6-3075-4ee1-a216-a6d83324a737', 4, '551530001', 4000000, '2019-03-20 12:16:18', '2019-03-20 12:22:24');

-- --------------------------------------------------------

--
-- Table structure for table `funds_transfer`
--

CREATE TABLE `funds_transfer` (
  `id` int(11) NOT NULL,
  `uuid` char(36) NOT NULL,
  `transaction_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `funds_transfer`
--

INSERT INTO `funds_transfer` (`id`, `uuid`, `transaction_id`, `user_id`, `account_id`, `created_at`, `updated_at`) VALUES
(1, '85eedc42-3153-487c-8ce0-8837382246d8', 1, 4, 2, '2019-03-20 12:22:24', '2019-03-20 12:22:24');

-- --------------------------------------------------------

--
-- Table structure for table `migrations`
--

CREATE TABLE `migrations` (
  `id` int(10) UNSIGNED NOT NULL,
  `migration` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `batch` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Table structure for table `transactions`
--

CREATE TABLE `transactions` (
  `id` int(11) NOT NULL,
  `uuid` char(36) NOT NULL,
  `user_id` int(11) NOT NULL,
  `type_id` int(11) NOT NULL,
  `account_id` int(11) NOT NULL,
  `amount` double NOT NULL,
  `created_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transactions`
--

INSERT INTO `transactions` (`id`, `uuid`, `user_id`, `type_id`, `account_id`, `amount`, `created_at`, `updated_at`) VALUES
(1, '25055c1b-5213-44c1-a5fc-6cf36f081589', 3, 2, 1, 3000000, '2019-03-20 12:22:24', '2019-03-20 12:22:24');

-- --------------------------------------------------------

--
-- Table structure for table `transaction_types`
--

CREATE TABLE `transaction_types` (
  `id` int(11) NOT NULL,
  `name` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaction_types`
--

INSERT INTO `transaction_types` (`id`, `name`) VALUES
(1, 'Saving'),
(2, 'Transfer'),
(3, 'Pay Bill'),
(4, 'Withdraw'),
(5, 'Deposit');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` int(10) UNSIGNED NOT NULL,
  `uuid` char(36) COLLATE utf8mb4_unicode_ci NOT NULL,
  `first_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_name` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `remember_token` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `created_at` timestamp NULL DEFAULT NULL,
  `updated_at` timestamp NULL DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `uuid`, `first_name`, `last_name`, `email`, `password`, `remember_token`, `created_at`, `updated_at`) VALUES
(1, '0c52e558-6498-4511-8e6c-389c3f237b4c', 'Bil Awal', 'Fathur Rizky', 'bil@mail.com', '$2y$10$Rk5YXk2hHDdAH3sLxAiAROIJwMvXwzFnBrGhgVDT0K1AaZwygsSJ6', 'dg4d8ffWYZV9Wa3AgiagyIwUrp0dSyY1AoVGwyKPUW9cmFwxIhIXySFAAIlY', '2019-03-20 12:10:28', '2019-03-20 12:10:28'),
(2, '436dd273-6c90-409f-b199-53f0f4c3ef2d', 'Rika', 'Ironah', 'rika@mail.com', '$2y$10$.lUUMXDN83nGloY/gZ7VP.G67oeBZVC2Wo2BOT/av4QrR6v3Xtzm6', '9HQKOSrIca4ftnpNUCMuP8tSItcGplVlJkWHTNt2DbtuL417Risme232fYY8', '2019-03-20 12:10:52', '2019-03-20 12:10:52'),
(3, '65dd7411-6de5-40b4-a375-cfee157cc57c', 'Marisha', 'Claudia', 'marisha@mail.com', '$2y$10$6qzBup8/PoXcOA.t/BnrzOet7QDRGbpe4jdvidtAEuL65is6zwmSS', 'gIuHOVdroza1hqMTzyQ5EUwjLGOK1yTEJ7uwKSxaZIBtLilwuFap14drTUZt', '2019-03-20 12:11:25', '2019-03-20 12:11:25'),
(4, '66d9175e-201e-4641-876a-6c1c7ed857b7', 'Paulinus', 'Lambert', 'paul@mail.com', '$2y$10$8LGn/9mccZlwzQSiVXX3tePyH7sKbrHZehK42RFzoTdqnL7teBoWi', 'xD4R0BQUP2QNrTHmcMYT9euR4b3OfDaDjiulEyAgdFHuNya2pvxl2FuAORDd', '2019-03-20 12:11:41', '2019-03-20 12:11:41');

-- --------------------------------------------------------

--
-- Table structure for table `vw_funds_transfers`
--

CREATE TABLE `vw_funds_transfers` (
  `id` int(11) NOT NULL,
  `uiid` char(36) NOT NULL,
  `transaction_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `acccount_id` int(11) NOT NULL,
  `from_user_id` int(11) NOT NULL,
  `to_user_id` int(11) NOT NULL,
  `created_at` datetime DEFAULT CURRENT_TIMESTAMP,
  `updated_at` datetime DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `accounts`
--
ALTER TABLE `accounts`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`);

--
-- Indexes for table `funds_transfer`
--
ALTER TABLE `funds_transfer`
  ADD PRIMARY KEY (`id`),
  ADD KEY `transaction_id` (`transaction_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `account_id` (`account_id`);

--
-- Indexes for table `migrations`
--
ALTER TABLE `migrations`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `transactions`
--
ALTER TABLE `transactions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `type_id` (`type_id`),
  ADD KEY `account_id` (`account_id`);

--
-- Indexes for table `transaction_types`
--
ALTER TABLE `transaction_types`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `vw_funds_transfers`
--
ALTER TABLE `vw_funds_transfers`
  ADD PRIMARY KEY (`id`),
  ADD KEY `transaction_id` (`transaction_id`),
  ADD KEY `user_id` (`user_id`),
  ADD KEY `acccount_id` (`acccount_id`),
  ADD KEY `from_user_id` (`from_user_id`),
  ADD KEY `to_user_id` (`to_user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `accounts`
--
ALTER TABLE `accounts`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `funds_transfer`
--
ALTER TABLE `funds_transfer`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `migrations`
--
ALTER TABLE `migrations`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `transactions`
--
ALTER TABLE `transactions`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `transaction_types`
--
ALTER TABLE `transaction_types`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `vw_funds_transfers`
--
ALTER TABLE `vw_funds_transfers`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
