-- phpMyAdmin SQL Dump
-- version 4.1.12
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-05-2016 a las 09:01:00
-- Versión del servidor: 5.6.14
-- Versión de PHP: 5.5.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `asistencia`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `configuraciones`
--

CREATE TABLE IF NOT EXISTS `configuraciones` (
  `idConfiguraciones` int(11) NOT NULL AUTO_INCREMENT,
  `horaEntrada` varchar(10) NOT NULL,
  `horaSalida` varchar(10) NOT NULL,
  `horaRetardo` varchar(10) NOT NULL,
  `horaFalta` varchar(10) NOT NULL,
  `cargoFalta` int(11) NOT NULL,
  `bono` int(11) NOT NULL,
  PRIMARY KEY (`idConfiguraciones`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

CREATE TABLE IF NOT EXISTS `empleado` (
  `idEmpleado` int(11) NOT NULL AUTO_INCREMENT,
  `nombreEmpleado` varchar(100) NOT NULL,
  `calleEmpleado` varchar(100) NOT NULL,
  `numeroEmpleado` varchar(10) NOT NULL,
  `coloniaEmpleado` varchar(100) NOT NULL,
  `codigoPostal` varchar(5) NOT NULL,
  `ciudadEmpleado` varchar(100) NOT NULL,
  `estadoEmpleado` varchar(100) NOT NULL,
  `edadEmpleado` int(11) NOT NULL,
  `puestoEmpleado` varchar(100) NOT NULL,
  `fechaIngreso` varchar(100) NOT NULL,
  `sueldoEmpleado` int(11) NOT NULL,
  PRIMARY KEY (`idEmpleado`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=9 ;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`idEmpleado`, `nombreEmpleado`, `calleEmpleado`, `numeroEmpleado`, `coloniaEmpleado`, `codigoPostal`, `ciudadEmpleado`, `estadoEmpleado`, `edadEmpleado`, `puestoEmpleado`, `fechaIngreso`, `sueldoEmpleado`) VALUES
(3, 'Carlos Guillén González', 'Privada Las palmas', '120', 'Las palmas', '91020', 'Xalapa', 'Veracruz', 23, 'Administrador', '25 de marzo 2009', 1600),
(4, 'José Hernández Martínez', 'La soledad', '2', 'Higueras', '91030', 'Xalapa', 'Veracruz', 30, 'Empleado', '20 de Abril 2000', 1600),
(8, 'Isay Armando González Cruz', 'Melcho Ocampo', '67', 'Centro', '91300', 'Banderilla', 'Veracruz', 24, 'Programador', '22 de Abril 2000', 1600);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entrada`
--

CREATE TABLE IF NOT EXISTS `entrada` (
  `idEntrada` int(11) NOT NULL AUTO_INCREMENT,
  `empleado_idEmpleado` int(11) NOT NULL,
  `horaEntrada` varchar(10) NOT NULL,
  `diaEntrada` varchar(20) NOT NULL,
  `fechaDays` varchar(50) NOT NULL,
  `retardo` varchar(20) DEFAULT NULL,
  `falta` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idEntrada`,`empleado_idEmpleado`),
  KEY `fk_days_empleado1_idx` (`empleado_idEmpleado`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `entrada`
--

INSERT INTO `entrada` (`idEntrada`, `empleado_idEmpleado`, `horaEntrada`, `diaEntrada`, `fechaDays`, `retardo`, `falta`) VALUES
(1, 3, '8:30', 'Lunes', '9 de Mayo 2016', 'No', 'No'),
(2, 4, '8:32', 'Lunes', '9 de Mayo 2016', 'Sí', 'No'),
(4, 3, '8:30', 'Martes', '10 de Mayo 2016', 'No', 'No'),
(5, 4, '8:35', 'Viernes', '13 de mayo 2016', 'Sí', 'No');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `nomina`
--

CREATE TABLE IF NOT EXISTS `nomina` (
  `idNomina` int(11) NOT NULL AUTO_INCREMENT,
  `sueldoNeto` double NOT NULL,
  `empleado_idEmpleado` int(11) NOT NULL,
  PRIMARY KEY (`idNomina`,`empleado_idEmpleado`),
  KEY `fk_nomina_empleado_idx` (`empleado_idEmpleado`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=3 ;

--
-- Volcado de datos para la tabla `nomina`
--

INSERT INTO `nomina` (`idNomina`, `sueldoNeto`, `empleado_idEmpleado`) VALUES
(1, 1333.33, 3),
(2, 1600, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salida`
--

CREATE TABLE IF NOT EXISTS `salida` (
  `idSalida` int(11) NOT NULL AUTO_INCREMENT,
  `empleado_idEmpleado` int(11) NOT NULL,
  `horaSalida` varchar(10) NOT NULL,
  `diaSalida` varchar(20) NOT NULL,
  `fechaDays` varchar(50) NOT NULL,
  PRIMARY KEY (`idSalida`,`empleado_idEmpleado`),
  KEY `fk_days_empleado1_idx` (`empleado_idEmpleado`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 AUTO_INCREMENT=6 ;

--
-- Volcado de datos para la tabla `salida`
--

INSERT INTO `salida` (`idSalida`, `empleado_idEmpleado`, `horaSalida`, `diaSalida`, `fechaDays`) VALUES
(1, 3, '19:00', 'Lunes', '9 de Mayo 2016'),
(3, 4, '19:00', 'Lunes', '9 de Mayo 2016'),
(5, 3, '19:00', 'Martes', '10 de Mayo 2016');

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `entrada`
--
ALTER TABLE `entrada`
  ADD CONSTRAINT `fk_days_empleado1` FOREIGN KEY (`empleado_idEmpleado`) REFERENCES `empleado` (`idEmpleado`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `nomina`
--
ALTER TABLE `nomina`
  ADD CONSTRAINT `fk_nomina_empleado` FOREIGN KEY (`empleado_idEmpleado`) REFERENCES `empleado` (`idEmpleado`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `salida`
--
ALTER TABLE `salida`
  ADD CONSTRAINT `fk_days_empleado10` FOREIGN KEY (`empleado_idEmpleado`) REFERENCES `empleado` (`idEmpleado`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
