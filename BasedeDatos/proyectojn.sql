-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 24-10-2018 a las 23:54:04
-- Versión del servidor: 10.1.36-MariaDB
-- Versión de PHP: 7.2.10

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyectojn`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `alumnos`
--

CREATE TABLE `alumnos` (
  `idAlumno` int(8) NOT NULL,
  `idImportes` int(8) NOT NULL,
  `idNotas` int(8) NOT NULL,
  `DNI` varchar(8) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Ape_Paterno` varchar(45) NOT NULL,
  `Ape_Materno` varchar(45) NOT NULL,
  `Direccion` varchar(45) NOT NULL,
  `Telefono` varchar(45) NOT NULL,
  `Edad` varchar(45) NOT NULL,
  `Grado` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asistente_matricula`
--

CREATE TABLE `asistente_matricula` (
  `idAsistente_Matricula` int(8) NOT NULL,
  `idEmpleados` int(8) NOT NULL,
  `Cargo` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `docentes`
--

CREATE TABLE `docentes` (
  `idDocentes` int(8) NOT NULL,
  `idEmpleados` int(8) NOT NULL,
  `Salon` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `idEmpleados` int(8) NOT NULL,
  `idDocentes` int(8) NOT NULL,
  `idAsistente_Matricula` int(8) NOT NULL,
  `idPagos` int(8) NOT NULL,
  `DNI` varchar(8) NOT NULL,
  `Nombre` varchar(45) NOT NULL,
  `Apellidos` varchar(45) NOT NULL,
  `Direccion` varchar(45) NOT NULL,
  `Telefono` varchar(45) NOT NULL,
  `Edad` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `importes`
--

CREATE TABLE `importes` (
  `idImportes` int(8) NOT NULL,
  `idAlumno` int(8) NOT NULL,
  `Tipo_Pago` varchar(45) NOT NULL,
  `Importe` int(4) NOT NULL,
  `DNI_Responsable` varchar(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `matricula`
--

CREATE TABLE `matricula` (
  `idMatricula` int(8) NOT NULL,
  `idUsuarios` int(8) NOT NULL,
  `idAlumno` int(8) NOT NULL,
  `idAsistente_Matricula` int(8) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `notas`
--

CREATE TABLE `notas` (
  `idNotas` int(8) NOT NULL,
  `idAlumno` int(8) NOT NULL,
  `LM` int(2) NOT NULL,
  `CI` int(2) NOT NULL,
  `CA` int(2) NOT NULL,
  `Computo` int(2) NOT NULL,
  `PS` int(2) NOT NULL,
  `Religion` int(2) NOT NULL,
  `EF` int(2) NOT NULL,
  `Minichef` int(2) NOT NULL,
  `Tutoria` int(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `salarioempleados`
--

CREATE TABLE `salarioempleados` (
  `idPagos` int(8) NOT NULL,
  `idEmpleados` int(8) NOT NULL,
  `SalarioNeto` varchar(45) NOT NULL,
  `FechadePago` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `idUsuarios` int(8) NOT NULL,
  `idEmpleados` int(8) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `email` varchar(45) NOT NULL,
  `imagen` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD PRIMARY KEY (`idAlumno`),
  ADD KEY `fk_Alumnos_Importes1_idx` (`idImportes`),
  ADD KEY `fk_Alumnos_Notas1_idx` (`idNotas`);

--
-- Indices de la tabla `asistente_matricula`
--
ALTER TABLE `asistente_matricula`
  ADD PRIMARY KEY (`idAsistente_Matricula`),
  ADD KEY `fk_Asistente_Matricula_Empleados1_idx` (`idEmpleados`);

--
-- Indices de la tabla `docentes`
--
ALTER TABLE `docentes`
  ADD PRIMARY KEY (`idDocentes`),
  ADD KEY `fk_Docentes_Empleados1_idx` (`idEmpleados`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`idEmpleados`),
  ADD KEY `fk_Empleados_Docentes1_idx` (`idDocentes`),
  ADD KEY `fk_Empleados_SalarioEmpleados1_idx` (`idPagos`),
  ADD KEY `fk_Empleados_Asistente_Matricula1_idx` (`idAsistente_Matricula`);

--
-- Indices de la tabla `importes`
--
ALTER TABLE `importes`
  ADD PRIMARY KEY (`idImportes`),
  ADD KEY `fk_Importes_Alumnos_idx` (`idAlumno`);

--
-- Indices de la tabla `matricula`
--
ALTER TABLE `matricula`
  ADD PRIMARY KEY (`idMatricula`),
  ADD KEY `fk_Matricula_Alumnos1_idx` (`idAlumno`),
  ADD KEY `fk_Matricula_Usuarios1_idx` (`idUsuarios`),
  ADD KEY `fk_Matricula_Asistente_Matricula1_idx` (`idAsistente_Matricula`);

--
-- Indices de la tabla `notas`
--
ALTER TABLE `notas`
  ADD PRIMARY KEY (`idNotas`),
  ADD KEY `fk_Notas_Alumnos_idx` (`idAlumno`);

--
-- Indices de la tabla `salarioempleados`
--
ALTER TABLE `salarioempleados`
  ADD PRIMARY KEY (`idPagos`),
  ADD KEY `fk_SalarioEmpleados_Empleados1_idx` (`idEmpleados`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idUsuarios`),
  ADD KEY `fk_Usuarios_Empleados1_idx` (`idEmpleados`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `alumnos`
--
ALTER TABLE `alumnos`
  ADD CONSTRAINT `fk_Alumnos_Importes1` FOREIGN KEY (`idImportes`) REFERENCES `importes` (`idImportes`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Alumnos_Notas1` FOREIGN KEY (`idNotas`) REFERENCES `notas` (`idNotas`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `asistente_matricula`
--
ALTER TABLE `asistente_matricula`
  ADD CONSTRAINT `fk_Asistente_Matricula_Empleados1` FOREIGN KEY (`idEmpleados`) REFERENCES `empleados` (`idEmpleados`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `docentes`
--
ALTER TABLE `docentes`
  ADD CONSTRAINT `fk_Docentes_Empleados1` FOREIGN KEY (`idEmpleados`) REFERENCES `empleados` (`idEmpleados`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD CONSTRAINT `fk_Empleados_Asistente_Matricula1` FOREIGN KEY (`idAsistente_Matricula`) REFERENCES `asistente_matricula` (`idAsistente_Matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Empleados_Docentes1` FOREIGN KEY (`idDocentes`) REFERENCES `docentes` (`idDocentes`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Empleados_SalarioEmpleados1` FOREIGN KEY (`idPagos`) REFERENCES `salarioempleados` (`idPagos`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `importes`
--
ALTER TABLE `importes`
  ADD CONSTRAINT `fk_Importes_Alumnos` FOREIGN KEY (`idAlumno`) REFERENCES `alumnos` (`idAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `matricula`
--
ALTER TABLE `matricula`
  ADD CONSTRAINT `fk_Matricula_Alumnos1` FOREIGN KEY (`idAlumno`) REFERENCES `alumnos` (`idAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Matricula_Asistente_Matricula1` FOREIGN KEY (`idAsistente_Matricula`) REFERENCES `asistente_matricula` (`idAsistente_Matricula`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `fk_Matricula_Usuarios1` FOREIGN KEY (`idUsuarios`) REFERENCES `usuarios` (`idUsuarios`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `notas`
--
ALTER TABLE `notas`
  ADD CONSTRAINT `fk_Notas_Alumnos` FOREIGN KEY (`idAlumno`) REFERENCES `alumnos` (`idAlumno`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `salarioempleados`
--
ALTER TABLE `salarioempleados`
  ADD CONSTRAINT `fk_SalarioEmpleados_Empleados1` FOREIGN KEY (`idEmpleados`) REFERENCES `empleados` (`idEmpleados`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `fk_Usuarios_Empleados1` FOREIGN KEY (`idEmpleados`) REFERENCES `empleados` (`idEmpleados`) ON DELETE NO ACTION ON UPDATE NO ACTION;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
