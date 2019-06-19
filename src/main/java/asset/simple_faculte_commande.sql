-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 19, 2019 at 02:48 PM
-- Server version: 10.1.35-MariaDB
-- PHP Version: 7.2.9

SET FOREIGN_KEY_CHECKS=0;
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `simple_faculte_commande`
--

-- --------------------------------------------------------

--
-- Table structure for table `commande`
--

CREATE TABLE `commande` (
  `id` bigint(20) NOT NULL,
  `date_commande` date DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `total` double NOT NULL,
  `total_paiement` double NOT NULL,
  `fournisseur` bigint(20) DEFAULT NULL,
  `reference_offre` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `commande`
--

INSERT INTO `commande` (`id`, `date_commande`, `reference`, `total`, `total_paiement`, `fournisseur`, `reference_offre`) VALUES
(98, '2019-05-29', 'cmd-02', 160, 160, 1, ''),
(95, '2019-05-29', 'cmd-01', 29000, 0, 1, '');

-- --------------------------------------------------------

--
-- Table structure for table `commande_item`
--

CREATE TABLE `commande_item` (
  `id` bigint(20) NOT NULL,
  `prix` double NOT NULL,
  `qte` int(11) NOT NULL,
  `qte_reception` int(11) NOT NULL,
  `reference_produit` varchar(255) DEFAULT NULL,
  `commande` bigint(20) DEFAULT NULL,
  `qte_affecte` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `commande_item`
--

INSERT INTO `commande_item` (`id`, `prix`, `qte`, `qte_reception`, `reference_produit`, `commande`, `qte_affecte`) VALUES
(100, 2, 30, 0, 'stylo', 98, 3),
(99, 5, 20, 0, 'pr-3', 98, 0),
(97, 3000, 3, 0, 'hp', 95, 0),
(96, 4000, 5, 0, 'azus', 95, 0);

-- --------------------------------------------------------

--
-- Table structure for table `commande_source`
--

CREATE TABLE `commande_source` (
  `id` bigint(20) NOT NULL,
  `qte_affecte` int(11) NOT NULL,
  `reference_expression_besoin_item` varchar(255) DEFAULT NULL,
  `commande_item` bigint(20) DEFAULT NULL,
  `qte_livre` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `commande_source`
--

INSERT INTO `commande_source` (`id`, `qte_affecte`, `reference_expression_besoin_item`, `commande_item`, `qte_livre`) VALUES
(101, 3, '87', 100, 0);

-- --------------------------------------------------------

--
-- Table structure for table `fournisseur`
--

CREATE TABLE `fournisseur` (
  `id` bigint(20) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `raison_social` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `numero` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `fournisseur`
--

INSERT INTO `fournisseur` (`id`, `libelle`, `raison_social`, `reference`, `email`, `numero`) VALUES
(1, 'companie x', 'sarl', 'fr-36', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(104),
(104),
(104),
(104),
(104);

-- --------------------------------------------------------

--
-- Table structure for table `paiement`
--

CREATE TABLE `paiement` (
  `id` bigint(20) NOT NULL,
  `date_paiement` date DEFAULT NULL,
  `montant` double NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `commande` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `paiement`
--

INSERT INTO `paiement` (`id`, `date_paiement`, `montant`, `type`, `commande`) VALUES
(102, '2019-06-17', 120, 'cash', 98),
(103, '2019-06-18', 40, 'cash', 98);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrupnw7i4hq1m1s78m9ui94xs3` (`fournisseur`);

--
-- Indexes for table `commande_item`
--
ALTER TABLE `commande_item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4obrfcid8ag7xmsyw50xefiee` (`commande`);

--
-- Indexes for table `commande_source`
--
ALTER TABLE `commande_source`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2uaujun7ojxj9ni32fkccch0` (`commande_item`);

--
-- Indexes for table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `paiement`
--
ALTER TABLE `paiement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsd8tiyjo210tcu5qtm74io9t6` (`commande`);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
