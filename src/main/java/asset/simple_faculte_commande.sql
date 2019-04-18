-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  jeu. 18 avr. 2019 à 10:13
-- Version du serveur :  10.1.35-MariaDB
-- Version de PHP :  7.2.9

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
-- Base de données :  `simple_faculte_commande`
--

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE `commande` (
  `id` bigint(20) NOT NULL,
  `date_commande` date DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL,
  `total` double NOT NULL,
  `total_paiement` double NOT NULL,
  `fournisseur` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id`, `date_commande`, `reference`, `total`, `total_paiement`, `fournisseur`) VALUES
(1, '2019-02-11', 'cmd-03', 250, 50, 1),
(3, '2019-03-05', 'cmd-01', 167, 0, 1),
(6, '2019-03-01', 'cmd-02', 403, 0, 1),
(15, '2019-04-25', 'hhh', 9, 0, 1);

-- --------------------------------------------------------

--
-- Structure de la table `commande_item`
--

CREATE TABLE `commande_item` (
  `id` bigint(20) NOT NULL,
  `prix` double NOT NULL,
  `qte` int(11) NOT NULL,
  `qte_reception` int(11) NOT NULL,
  `reference_produit` varchar(255) DEFAULT NULL,
  `commande` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commande_item`
--

INSERT INTO `commande_item` (`id`, `prix`, `qte`, `qte_reception`, `reference_produit`, `commande`) VALUES
(2, 50, 5, 0, 'pr1', 1),
(4, 9, 7, 0, 'pr2', 3),
(5, 26, 4, 0, 'pr3', 3),
(7, 13, 19, 0, 'pr1', 6),
(8, 13, 12, 0, 'pr2', 6),
(16, 3, 3, 0, 'hhh', 15);

-- --------------------------------------------------------

--
-- Structure de la table `commande_source`
--

CREATE TABLE `commande_source` (
  `id` bigint(20) NOT NULL,
  `qte_affecte` int(11) NOT NULL,
  `reference_expression_besoin_item` varchar(255) DEFAULT NULL,
  `commande_item` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `commande_source`
--

INSERT INTO `commande_source` (`id`, `qte_affecte`, `reference_expression_besoin_item`, `commande_item`) VALUES
(12, 1, '11', 7),
(13, 3, '14', 7);

-- --------------------------------------------------------

--
-- Structure de la table `fournisseur`
--

CREATE TABLE `fournisseur` (
  `id` bigint(20) NOT NULL,
  `libelle` varchar(255) DEFAULT NULL,
  `raison_social` varchar(255) DEFAULT NULL,
  `reference` varchar(255) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `fournisseur`
--

INSERT INTO `fournisseur` (`id`, `libelle`, `raison_social`, `reference`) VALUES
(1, 'companie x', 'sarl', 'fr-36');

-- --------------------------------------------------------

--
-- Structure de la table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(17),
(17),
(17),
(17),
(17);

-- --------------------------------------------------------

--
-- Structure de la table `paiement`
--

CREATE TABLE `paiement` (
  `id` bigint(20) NOT NULL,
  `date_paiement` date DEFAULT NULL,
  `montant` double NOT NULL,
  `type` varchar(255) DEFAULT NULL,
  `commande` bigint(20) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `paiement`
--

INSERT INTO `paiement` (`id`, `date_paiement`, `montant`, `type`, `commande`) VALUES
(14, '2019-03-30', 50, NULL, 1);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `commande`
--
ALTER TABLE `commande`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKrupnw7i4hq1m1s78m9ui94xs3` (`fournisseur`);

--
-- Index pour la table `commande_item`
--
ALTER TABLE `commande_item`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK4obrfcid8ag7xmsyw50xefiee` (`commande`);

--
-- Index pour la table `commande_source`
--
ALTER TABLE `commande_source`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK2uaujun7ojxj9ni32fkccch0` (`commande_item`);

--
-- Index pour la table `fournisseur`
--
ALTER TABLE `fournisseur`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `paiement`
--
ALTER TABLE `paiement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKsd8tiyjo210tcu5qtm74io9t6` (`commande`);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
