-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  lun. 29 avr. 2019 à 18:06
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

--
-- Déchargement des données de la table `commande`
--

INSERT INTO `commande` (`id`, `date_commande`, `reference`, `total`, `total_paiement`, `fournisseur`) VALUES
(69, '2019-04-23', 'cmd-02', 44, 0, 1),
(66, '2019-04-23', 'cmd-01', 3300, 0, 1);

--
-- Déchargement des données de la table `commande_item`
--

INSERT INTO `commande_item` (`id`, `prix`, `qte`, `qte_reception`, `reference_produit`, `commande`, `qte_affecte`) VALUES
(71, 4, 6, 0, 'pr-3', 69, 0),
(70, 2, 10, 0, 'stylo', 69, 4),
(68, 300, 3, 0, 'hp', 66, 0),
(67, 600, 4, 0, 'azus', 66, 2);

--
-- Déchargement des données de la table `commande_source`
--

INSERT INTO `commande_source` (`id`, `qte_affecte`, `reference_expression_besoin_item`, `commande_item`, `qte_livre`) VALUES
(82, 4, '77', 70, 0),
(83, 1, '74', 67, 0),
(84, 1, '74', 67, 0);

--
-- Déchargement des données de la table `fournisseur`
--

INSERT INTO `fournisseur` (`id`, `libelle`, `raison_social`, `reference`) VALUES
(1, 'companie x', 'sarl', 'fr-36');

--
-- Déchargement des données de la table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(89),
(89),
(89),
(89),
(89);
SET FOREIGN_KEY_CHECKS=1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
