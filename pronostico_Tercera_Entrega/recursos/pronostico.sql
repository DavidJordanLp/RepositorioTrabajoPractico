-- --------------------------------------------------------
-- Host:                         172.16.1.59
-- Versión del servidor:         5.7.33-0ubuntu0.16.04.1 - (Ubuntu)
-- SO del servidor:              Linux
-- HeidiSQL Versión:             11.2.0.6213
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para pronosticos
CREATE DATABASE IF NOT EXISTS `pronosticos` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_spanish_ci */;
USE `pronosticos`;

-- Volcando estructura para tabla pronosticos.datos_pronosticos
CREATE TABLE IF NOT EXISTS `datos_pronosticos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `jugador` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  `equipo1` varchar(50) COLLATE utf8_spanish_ci NOT NULL DEFAULT '',
  `ganaEquipo1` char(1) COLLATE utf8_spanish_ci NOT NULL,
  `empate` char(1) COLLATE utf8_spanish_ci NOT NULL,
  `ganaEquipo2` char(1) COLLATE utf8_spanish_ci NOT NULL,
  `equipo2` varchar(50) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

-- Volcando datos para la tabla pronosticos.datos_pronosticos: ~32 rows (aproximadamente)
/*!40000 ALTER TABLE `datos_pronosticos` DISABLE KEYS */;
INSERT INTO `datos_pronosticos` (`id`, `jugador`, `equipo1`, `ganaEquipo1`, `empate`, `ganaEquipo2`, `equipo2`) VALUES
	(1, 'David', 'Argentina', '', '', 'X', 'Saudi Arabia'),
	(2, 'David', 'Mexico', '', 'X', '', 'Poland'),
	(3, 'David', 'Poland', 'X', '', '', 'Saudi Arabia'),
	(4, 'David', 'Argentina', 'X', '', '', 'Mexico'),
	(5, 'David', 'France', 'X', '', '', 'Australia'),
	(6, 'David', 'Morocco', '', 'X', '', 'Croatia'),
	(7, 'David', 'Germany', 'X', '', '', 'Japan'),
	(8, 'David', 'Spain', '', 'X', '', 'Costa Rica'),
	(9, 'Carina', 'Argentina', '', '', 'X', 'Saudi Arabia'),
	(10, 'Carina', 'Mexico', 'X', '', '', 'Poland'),
	(11, 'Carina', 'Poland', 'X', '', '', 'Saudi Arabia'),
	(12, 'Carina', 'Argentina', 'X', '', '', 'Mexico'),
	(13, 'Carina', 'France', 'X', '', '', 'Australia'),
	(14, 'Carina', 'Morocco', '', '', 'X', 'Croatia'),
	(15, 'Carina', 'Germany', '', '', 'X', 'Japan'),
	(16, 'Carina', 'Spain', 'X', '', '', 'Costa Rica'),
	(17, 'Lucas', 'Argentina', '', '', 'X', 'Saudi Arabia'),
	(18, 'Lucas', 'Mexico', '', 'X', '', 'Poland'),
	(19, 'Lucas', 'Poland', 'X', '', '', 'Saudi Arabia'),
	(20, 'Lucas', 'Argentina', 'X', '', '', 'Mexico'),
	(21, 'Lucas', 'France', 'X', '', '', 'Australia'),
	(22, 'Lucas', 'Morocco', '', '', 'X', 'Croatia'),
	(23, 'Lucas', 'Germany', '', '', 'X', 'Japan'),
	(24, 'Lucas', 'Spain', '', 'X', '', 'Costa Rica'),
	(25, 'Luis', 'Argentina', 'X', '', '', 'Saudi Arabia'),
	(26, 'Luis', 'Mexico', '', '', 'X', 'Poland'),
	(27, 'Luis', 'Poland', '', 'X', '', 'Saudi Arabia'),
	(28, 'Luis', 'Argentina', 'X', '', '', 'Mexico'),
	(29, 'Luis', 'France', 'X', '', '', 'Australia'),
	(30, 'Luis', 'Morocco', '', 'X', '', 'Croatia'),
	(31, 'Luis', 'Germany', '', '', 'X', 'Japan'),
	(32, 'Luis', 'Spain', 'X', '', '', 'Costa Rica');
/*!40000 ALTER TABLE `datos_pronosticos` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
