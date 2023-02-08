-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 08-02-2023 a las 14:29:31
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_zinema`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `aretoa`
--

CREATE TABLE `aretoa` (
  `Id_aretoa` int(11) NOT NULL,
  `IzenAret` varchar(30) DEFAULT NULL,
  `Id_zinema` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `aretoa`
--

INSERT INTO `aretoa` (`Id_aretoa`, `IzenAret`, `Id_zinema`) VALUES
(1, 'Areto 1', 1),
(2, 'Areto 2', 1),
(3, 'Areto 3', 1),
(4, 'Areto 1', 2),
(5, 'Areto 2', 2),
(6, 'Areto 3', 2),
(7, 'Areto 1', 3),
(8, 'Areto 2', 3),
(9, 'Areto 3', 3);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bezeroa`
--

CREATE TABLE `bezeroa` (
  `Id_bezeroa` varchar(30) NOT NULL,
  `IzeBez` varchar(30) NOT NULL,
  `AbizBez` varchar(30) NOT NULL,
  `Adina` int(11) NOT NULL,
  `Sexua` enum('gizon','emakume') DEFAULT NULL,
  `NAN` varchar(9) DEFAULT NULL,
  `Pasahitza` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `bezeroa`
--

INSERT INTO `bezeroa` (`Id_bezeroa`, `IzeBez`, `AbizBez`, `Adina`, `Sexua`, `NAN`, `Pasahitza`) VALUES
('aingeru1', 'Aingeru', 'Siranaula', 54, 'emakume', '12345678R', '1234'),
('ibai0', 'Ibai', 'Alvarez', 22, 'gizon', '12345678D', '1234');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `erosketa`
--

CREATE TABLE `erosketa` (
  `Id_erosketa` int(11) NOT NULL,
  `Deskontua` int(11) DEFAULT NULL,
  `Totala` float DEFAULT NULL,
  `Id_bezeroa` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `erosketa`
--

INSERT INTO `erosketa` (`Id_erosketa`, `Deskontua`, `Totala`, `Id_bezeroa`) VALUES
(1, 20, 12, 'ibai0');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `filma`
--

CREATE TABLE `filma` (
  `Id_filma` int(11) NOT NULL,
  `Izenburua` varchar(30) DEFAULT NULL,
  `Generoa` enum('Beldurra','Komedia','Drama','Zientzia') DEFAULT NULL,
  `Iraupena` int(11) DEFAULT NULL,
  `Prezioa` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `filma`
--

INSERT INTO `filma` (`Id_filma`, `Izenburua`, `Generoa`, `Iraupena`, `Prezioa`) VALUES
(1, 'Handia', 'Drama', 116, 4.5),
(2, 'La lista de Schindler', 'Drama', 197, 4.5),
(3, 'Cadena Perpetua', 'Drama', 142, 4.5),
(4, 'Million Dollar Baby', 'Drama', 133, 4.5),
(5, '2001: Odisea en el espacio', 'Zientzia', 142, 5.75),
(6, 'La novia de Frankenstein', 'Zientzia', 75, 5.75),
(7, 'El planeta de los simios', 'Zientzia', 115, 5.75),
(8, 'Alien, el octavo pasajero', 'Zientzia', 117, 5.75),
(9, 'Scary movie', 'Komedia', 90, 6.25),
(10, 'El gran Lebowsky', 'Komedia', 119, 6.25),
(11, 'La vida de Brian', 'Komedia', 94, 6.25),
(12, 'Aterriza como puedas', 'Komedia', 88, 6.25),
(13, 'Psicosis', 'Beldurra', 108, 6.5),
(14, 'El resplandor', 'Beldurra', 146, 6.5),
(15, 'Drácula', 'Beldurra', 155, 6.5),
(16, 'Cisne negro', 'Beldurra', 110, 6.5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `saioa`
--

CREATE TABLE `saioa` (
  `Id_saioa` int(11) NOT NULL,
  `Ordua` time DEFAULT NULL,
  `Data` date DEFAULT NULL,
  `Id_aretoa` int(11) DEFAULT NULL,
  `Id_filma` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `saioa`
--

INSERT INTO `saioa` (`Id_saioa`, `Ordua`, `Data`, `Id_aretoa`, `Id_filma`) VALUES
(1, '15:15:00', '2023-02-06', 1, 1),
(2, '19:30:00', '2023-02-08', 1, 6),
(3, '16:30:00', '2023-02-15', 2, 10),
(4, '18:20:00', '2023-02-06', 2, 16),
(5, '14:15:00', '2023-02-23', 3, 7),
(6, '21:20:00', '2023-03-25', 3, 2),
(7, '19:00:00', '2023-02-06', 4, 14),
(8, '22:50:00', '2023-03-17', 4, 11),
(9, '13:40:00', '2023-02-28', 5, 4),
(10, '20:00:00', '2023-03-22', 5, 9),
(11, '13:45:00', '2023-03-03', 6, 12),
(12, '19:05:00', '2023-03-01', 6, 15),
(13, '17:00:00', '2023-02-06', 7, 13),
(14, '19:55:00', '2023-03-25', 7, 3),
(15, '16:40:00', '2023-03-30', 8, 8),
(16, '00:00:22', '2023-02-27', 8, 5),
(17, '18:15:00', '2023-02-06', 2, 1),
(18, '15:30:00', '2023-02-08', 3, 6),
(19, '19:30:00', '2023-02-15', 1, 10),
(20, '15:20:00', '2023-02-06', 3, 16),
(21, '17:15:00', '2023-02-23', 1, 7),
(22, '18:20:00', '2023-03-25', 2, 2),
(23, '14:00:00', '2023-02-06', 5, 14),
(24, '18:50:00', '2023-03-17', 6, 11),
(25, '17:40:00', '2023-02-28', 4, 4),
(26, '16:00:00', '2023-03-22', 6, 9),
(27, '17:45:00', '2023-03-03', 5, 12),
(28, '15:05:00', '2023-03-01', 4, 15),
(29, '14:00:00', '2023-02-06', 8, 13),
(30, '15:55:00', '2023-03-25', 9, 3),
(31, '19:40:00', '2023-03-30', 7, 8),
(32, '00:00:19', '2023-02-27', 7, 5);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sarrera`
--

CREATE TABLE `sarrera` (
  `Id_sarrera` int(11) NOT NULL,
  `Id_saioa` int(11) DEFAULT NULL,
  `Id_erosketa` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `sarrera`
--

INSERT INTO `sarrera` (`Id_sarrera`, `Id_saioa`, `Id_erosketa`) VALUES
(1, 1, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `zinema`
--

CREATE TABLE `zinema` (
  `Id_zinema` int(11) NOT NULL,
  `IzenZin` varchar(30) DEFAULT NULL,
  `Kokalekua` varchar(100) DEFAULT NULL,
  `Bounds` varchar(30) DEFAULT NULL,
  `Route` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `zinema`
--

INSERT INTO `zinema` (`Id_zinema`, `IzenZin`, `Kokalekua`, `Bounds`, `Route`) VALUES
(1, 'Cinesa Zubiarte', 'Leizaola Lehendakariaren Kalea, 2, 48009 Bilbo, Bizkaia', '10,69,199,168', 'src/resources/zubi.png'),
(2, 'Cinesa Max Ocio', 'Barrio, Kareaga Kalea, S/N, 48903 Barakaldo, Biscay', '219,69,199,168', 'src/resources/max_cinesa.png'),
(3, 'Golem Alhondiga', 'Arriquíbar Plaza, 4, 48001 Bilbo, Bizkaia', '428,69,212,168', 'src/resources/golem.png'),
(4, 'Cinesa Zubiarte', 'Leizaola Lehendakariaren Kalea, 2, 48009 Bilbo, Bizkaia', '10,240,199,168', 'src/resources/zubi.png');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `aretoa`
--
ALTER TABLE `aretoa`
  ADD PRIMARY KEY (`Id_aretoa`),
  ADD KEY `FK_film_areto` (`Id_zinema`);

--
-- Indices de la tabla `bezeroa`
--
ALTER TABLE `bezeroa`
  ADD PRIMARY KEY (`Id_bezeroa`),
  ADD UNIQUE KEY `NAN` (`NAN`);

--
-- Indices de la tabla `erosketa`
--
ALTER TABLE `erosketa`
  ADD PRIMARY KEY (`Id_erosketa`,`Id_bezeroa`),
  ADD KEY `FK_bezero_eros` (`Id_bezeroa`);

--
-- Indices de la tabla `filma`
--
ALTER TABLE `filma`
  ADD PRIMARY KEY (`Id_filma`);

--
-- Indices de la tabla `saioa`
--
ALTER TABLE `saioa`
  ADD PRIMARY KEY (`Id_saioa`),
  ADD KEY `FK_filma_funtzi` (`Id_filma`),
  ADD KEY `FK_aretoa_funtzi` (`Id_aretoa`);

--
-- Indices de la tabla `sarrera`
--
ALTER TABLE `sarrera`
  ADD PRIMARY KEY (`Id_sarrera`),
  ADD KEY `FK_funtzi_sarrera` (`Id_saioa`),
  ADD KEY `FK_eros_sarrera` (`Id_erosketa`);

--
-- Indices de la tabla `zinema`
--
ALTER TABLE `zinema`
  ADD PRIMARY KEY (`Id_zinema`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `aretoa`
--
ALTER TABLE `aretoa`
  ADD CONSTRAINT `FK_film_areto` FOREIGN KEY (`Id_zinema`) REFERENCES `zinema` (`Id_zinema`);

--
-- Filtros para la tabla `erosketa`
--
ALTER TABLE `erosketa`
  ADD CONSTRAINT `FK_bezero_eros` FOREIGN KEY (`Id_bezeroa`) REFERENCES `bezeroa` (`Id_bezeroa`);

--
-- Filtros para la tabla `saioa`
--
ALTER TABLE `saioa`
  ADD CONSTRAINT `FK_aretoa_funtzi` FOREIGN KEY (`Id_aretoa`) REFERENCES `aretoa` (`Id_aretoa`),
  ADD CONSTRAINT `FK_filma_funtzi` FOREIGN KEY (`Id_filma`) REFERENCES `filma` (`Id_filma`);

--
-- Filtros para la tabla `sarrera`
--
ALTER TABLE `sarrera`
  ADD CONSTRAINT `FK_eros_sarrera` FOREIGN KEY (`Id_erosketa`) REFERENCES `erosketa` (`Id_erosketa`),
  ADD CONSTRAINT `FK_funtzi_sarrera` FOREIGN KEY (`Id_saioa`) REFERENCES `saioa` (`Id_saioa`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
