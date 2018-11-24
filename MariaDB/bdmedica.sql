-- Adminer 4.6.3 MySQL dump

SET NAMES utf8;
SET time_zone = '+00:00';
SET foreign_key_checks = 0;
SET sql_mode = 'NO_AUTO_VALUE_ON_ZERO';
DROP database bdmedica;
CREATE DATABASE `bdmedica` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bdmedica`;

CREATE TABLE `cita` (
  `id_cita` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_expediente` bigint(20) NOT NULL,
  `id_profesional_salud` int(11) NOT NULL,
  `id_historia_clinica` bigint(20) NOT NULL,
  `fecha_consulta` date NOT NULL,
  `fecha_proxima_consulta` date DEFAULT NULL,
  `estado` bit(1) NOT NULL DEFAULT b'0',
  `observaciones` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`id_cita`),
  KEY `fk_cita_2_idx` (`id_profesional_salud`),
  KEY `fk_cita_3_idx` (`id_historia_clinica`),
  KEY `fk_cita_1_idx` (`id_expediente`),
  CONSTRAINT `fk_cita_1` FOREIGN KEY (`id_expediente`) REFERENCES `expediente_clinico` (`id_expediente_clinico`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cita_2` FOREIGN KEY (`id_profesional_salud`) REFERENCES `profesional_salud` (`id_profesional_salud`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_cita_3` FOREIGN KEY (`id_historia_clinica`) REFERENCES `historia_clinica` (`id_historia_clinica`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `cita` (`id_cita`, `id_expediente`, `id_profesional_salud`, `id_historia_clinica`, `fecha_consulta`, `fecha_proxima_consulta`, `estado`, `observaciones`) VALUES
(1,	1,	1,	1,	'2018-11-11',	'2018-11-11',	CONV('0', 2, 10) + 0,	'afsdasfasdf');

CREATE TABLE `contacto_profesional_salud` (
  `id_contacto_profesional_salud` int(11) NOT NULL AUTO_INCREMENT,
  `id_profesional_salud` int(11) NOT NULL,
  `tipo_contacto` set('Telefono','Mail','Direccion','Email') NOT NULL,
  `informacion` varchar(45) NOT NULL,
  PRIMARY KEY (`id_contacto_profesional_salud`),
  KEY `fk_contacto_profesional_salud_1_idx` (`id_profesional_salud`),
  CONSTRAINT `fk_contacto_profesional_salud_1` FOREIGN KEY (`id_profesional_salud`) REFERENCES `profesional_salud` (`id_profesional_salud`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `contacto_profesional_salud` (`id_contacto_profesional_salud`, `id_profesional_salud`, `tipo_contacto`, `informacion`) VALUES
(1,	1,	'Telefono',	'1231-3455');

CREATE TABLE `especialidad` (
  `id_especialidad` int(11) NOT NULL AUTO_INCREMENT,
  `id_profesion` int(11) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`id_especialidad`),
  KEY `fk_especialidad_1_idx` (`id_profesion`),
  CONSTRAINT `fk_especialidad_1` FOREIGN KEY (`id_profesion`) REFERENCES `profesion` (`id_profesion`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `especialidad` (`id_especialidad`, `id_profesion`, `nombre`, `descripcion`) VALUES
(1,	1,	'MEDICO INTERNISTA',	'BLABLABLABLAALB');

CREATE TABLE `especialidad_por_profesional` (
  `id_especialidad_por_profesional` int(11) NOT NULL AUTO_INCREMENT,
  `id_profesional_salud` int(11) NOT NULL,
  `id_especialidad` int(11) NOT NULL,
  `jvp_supervisora` set('MEDICA','ODONTOLOGICA','ENFERMERIA','LABORATORIO CLINICO','PSICOLOGIA','QUIMICO FARMACEUTICO','VETERINARIA') NOT NULL,
  `numer_jvp` varchar(45) NOT NULL,
  `ejerciendo` bit(1) NOT NULL,
  PRIMARY KEY (`id_especialidad_por_profesional`),
  KEY `fk_especialidad_por_profesion_1_idx` (`id_especialidad`),
  KEY `fk_especialidad_por_profesion_2_idx` (`id_profesional_salud`),
  CONSTRAINT `fk_especialidad_por_profesion_1` FOREIGN KEY (`id_especialidad`) REFERENCES `especialidad` (`id_especialidad`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_especialidad_por_profesion_2` FOREIGN KEY (`id_profesional_salud`) REFERENCES `profesional_salud` (`id_profesional_salud`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `especialidad_por_profesional` (`id_especialidad_por_profesional`, `id_profesional_salud`, `id_especialidad`, `jvp_supervisora`, `numer_jvp`, `ejerciendo`) VALUES
(1,	1,	1,	'MEDICA',	'13453',	CONV('0', 2, 10) + 0);

CREATE TABLE `expediente_clinico` (
  `id_expediente_clinico` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_paciente` bigint(20) NOT NULL,
  `fecha_registro` date NOT NULL,
  `estado_expediente` bit(1) NOT NULL,
  `observaciones` varchar(45) NOT NULL,
  PRIMARY KEY (`id_expediente_clinico`),
  KEY `fk_expediente_clinico_1_idx` (`id_paciente`),
  CONSTRAINT `fk_expediente_clinico_1` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id_paciente`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `expediente_clinico` (`id_expediente_clinico`, `id_paciente`, `fecha_registro`, `estado_expediente`, `observaciones`) VALUES
(1,	1,	'2018-11-11',	CONV('1', 2, 10) + 0,	'NINGUNA');

CREATE TABLE `historia_clinica` (
  `id_historia_clinica` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_expediente` bigint(20) NOT NULL,
  `id_profesional_salud` int(11) NOT NULL,
  `fecha_creacion` datetime NOT NULL,
  `fecha_ingreso` datetime DEFAULT NULL,
  `fecha_alta` datetime DEFAULT NULL,
  `motivo_consulta` varchar(60) NOT NULL,
  `enfermedad_actual` longtext NOT NULL,
  `antecedentes` longtext NOT NULL,
  `datos_subjetivos` longtext NOT NULL,
  `examen_fisico` longtext NOT NULL,
  `diagnostico` longtext NOT NULL,
  `plan_diagnostico` longtext NOT NULL,
  `pronostico` longtext NOT NULL,
  PRIMARY KEY (`id_historia_clinica`),
  KEY `fk_historia_clinica_1_idx` (`id_expediente`),
  KEY `fk_historia_clinica_2_idx` (`id_profesional_salud`),
  CONSTRAINT `fk_historia_clinica_1` FOREIGN KEY (`id_expediente`) REFERENCES `expediente_clinico` (`id_expediente_clinico`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_historia_clinica_2` FOREIGN KEY (`id_profesional_salud`) REFERENCES `profesional_salud` (`id_profesional_salud`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `historia_clinica` (`id_historia_clinica`, `id_expediente`, `id_profesional_salud`, `fecha_creacion`, `fecha_ingreso`, `fecha_alta`, `motivo_consulta`, `enfermedad_actual`, `antecedentes`, `datos_subjetivos`, `examen_fisico`, `diagnostico`, `plan_diagnostico`, `pronostico`) VALUES
(1,	1,	1,	'2018-11-11 02:39:02',	'2018-11-11 02:39:02',	'2018-11-11 02:39:02',	'ASABER',	'IUDOIFUDOIUSDOIGUPSODUFGPOSIDUFPGOISUDFG',	'SDFGSDFGSDFGSDFGSDFG',	'SDFGSDFGSFGSDFG',	'SDFGSDFGSDFGSDFG',	'SDFGSDFGSDFGSDFG',	'SFGSDFGSDFGSDFGSFG',	'SDFGSDFGSFGSDFGS');

CREATE TABLE `medicamento` (
  `id_medicamento` int(11) NOT NULL AUTO_INCREMENT,
  `id_tipo_medicamento` int(11) NOT NULL,
  `composicion_quimica` varchar(45) NOT NULL,
  `concentracion_quimica` varchar(45) NOT NULL,
  `grupo_edad` set('Pediatrico','Niño','Adulto','Adulto Mayor') NOT NULL,
  `via_administracion` set('Oral','Inyectable','Topico','Aereo') NOT NULL,
  `advertencias` varchar(45) NOT NULL,
  `contraindicaciones` varchar(45) NOT NULL,
  `dosis` varchar(45) NOT NULL,
  PRIMARY KEY (`id_medicamento`),
  KEY `fk_medicamento_1_idx` (`id_tipo_medicamento`),
  CONSTRAINT `fk_medicamento_1` FOREIGN KEY (`id_tipo_medicamento`) REFERENCES `tipo_medicamento` (`id_tipo_medicamento`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `medicamento` (`id_medicamento`, `id_tipo_medicamento`, `composicion_quimica`, `concentracion_quimica`, `grupo_edad`, `via_administracion`, `advertencias`, `contraindicaciones`, `dosis`) VALUES
(1,	1,	'asaber',	'20%',	'Adulto',	'Oral',	'neles',	'neles',	'neles');

CREATE TABLE `medicamentos_por_receta` (
  `id_medicamentos_por_receta` bigint(8) NOT NULL AUTO_INCREMENT,
  `id_medicamento` int(11) NOT NULL,
  `id_receta` bigint(20) NOT NULL,
  `cantidad_medicamento` varchar(45) NOT NULL,
  `indicaciones_generales` varchar(100) NOT NULL,
  PRIMARY KEY (`id_medicamentos_por_receta`),
  KEY `fk_medicamentos_por_receta_1_idx` (`id_medicamento`),
  KEY `fk_medicamentos_por_receta_2_idx` (`id_receta`),
  CONSTRAINT `fk_medicamentos_por_receta_1` FOREIGN KEY (`id_medicamento`) REFERENCES `medicamento` (`id_medicamento`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_medicamentos_por_receta_2` FOREIGN KEY (`id_receta`) REFERENCES `receta` (`id_receta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `medicamentos_por_receta` (`id_medicamentos_por_receta`, `id_medicamento`, `id_receta`, `cantidad_medicamento`, `indicaciones_generales`) VALUES
(1,	1,	1,	'12',	'SDFSADFASDFASDF');

CREATE TABLE `paciente` (
  `id_paciente` bigint(20) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(60) NOT NULL,
  `apellidos` varchar(60) NOT NULL,
  `dui` varchar(10) DEFAULT NULL,
  `nit` varchar(17) DEFAULT NULL,
  `fecha_nacimiento` date NOT NULL,
  `tipo_sangre` set('A+','A-','B+','B-','AB+','AB-','O+','O-') NOT NULL,
  `direccion_registrada` varchar(100) NOT NULL,
  `ubicacion_geografica` set('Urbano','Marginal','Rural') NOT NULL,
  `telefono` varchar(9) NOT NULL,
  `genero` set('Masculino','Femenimo','No especifica') NOT NULL,
  `alergico` varchar(80) NOT NULL,
  `informacion_emergencia` varchar(45) NOT NULL,
  `nacionalidad` varchar(45) NOT NULL,
  `estado_civil` varchar(45) NOT NULL,
  `ocupacion` varchar(45) NOT NULL,
  `religion` varchar(45) NOT NULL,
  PRIMARY KEY (`id_paciente`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `paciente` (`id_paciente`, `nombres`, `apellidos`, `dui`, `nit`, `fecha_nacimiento`, `tipo_sangre`, `direccion_registrada`, `ubicacion_geografica`, `telefono`, `genero`, `alergico`, `informacion_emergencia`, `nacionalidad`, `estado_civil`, `ocupacion`, `religion`) VALUES
(1,	'MARIA JUANA',	'LOPEZ LOPEZ',	'32145739-0',	'1234-345578-123-1',	'1995-05-12',	'O-',	'RIUWEYOIRQYOIRYQOIWUERWER',	'Urbano',	'1234-3445',	'Femenimo',	'PENICILINA',	'ALGUNA INFORMACION DE EMERGENCIA',	'SALVADOREÑA',	'CASADA',	'AMA DE CASA',	'CRISTIANA');

CREATE TABLE `profesion` (
  `id_profesion` int(11) NOT NULL AUTO_INCREMENT,
  `grado_academico` set('Empirico','Tecnico','Licenciatura','Doctorado') NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  `estado_profesion` bit(1) NOT NULL,
  `capacidad_recetar` bit(1) NOT NULL,
  PRIMARY KEY (`id_profesion`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `profesion` (`id_profesion`, `grado_academico`, `nombre`, `descripcion`, `estado_profesion`, `capacidad_recetar`) VALUES
(1,	'Doctorado',	'MEDICO',	'Doctor e medicina',	CONV('1', 2, 10) + 0,	CONV('1', 2, 10) + 0);

CREATE TABLE `profesional_salud` (
  `id_profesional_salud` int(11) NOT NULL AUTO_INCREMENT,
  `nombres` varchar(50) NOT NULL,
  `apellidos` varchar(50) NOT NULL,
  `dui` varchar(11) NOT NULL,
  `nit` varchar(17) DEFAULT NULL,
  `fecha_nacimiento` date NOT NULL,
  `tipo_sangre` varchar(45) NOT NULL,
  `direccion_registrada` varchar(100) NOT NULL,
  `genero` set('Masculino','Femenimo','No especifica') NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  PRIMARY KEY (`id_profesional_salud`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `profesional_salud` (`id_profesional_salud`, `nombres`, `apellidos`, `dui`, `nit`, `fecha_nacimiento`, `tipo_sangre`, `direccion_registrada`, `genero`, `usuario`, `password`) VALUES
(1,	'JUAN ANTONIO',	'PEREZ HERNANDEZ',	'12345678-0',	'0000-123456-123-1',	'1985-05-12',	'ORH+',	'EN ALGUN LUGAR DEL CARAJO',	'Masculino',	'JAPH',	'JAPH');

CREATE TABLE `receta` (
  `id_receta` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_paciente` bigint(20) NOT NULL,
  `id_profesional_salud` int(11) NOT NULL,
  `tipo_receta` int(11) NOT NULL,
  `tipo_estado_receta` int(11) NOT NULL,
  `fecha_emision` date NOT NULL,
  `fecha_despacho` date DEFAULT NULL,
  `indicaciones_generales` varchar(100) NOT NULL,
  `comentarios` varchar(100) NOT NULL,
  PRIMARY KEY (`id_receta`),
  KEY `fk_receta_1_idx` (`id_paciente`),
  KEY `fk_receta_2_idx` (`id_profesional_salud`),
  KEY `fk_receta_3_idx` (`tipo_receta`),
  KEY `fk_receta_4_idx` (`tipo_estado_receta`),
  CONSTRAINT `fk_receta_1` FOREIGN KEY (`id_paciente`) REFERENCES `paciente` (`id_paciente`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_receta_2` FOREIGN KEY (`id_profesional_salud`) REFERENCES `profesional_salud` (`id_profesional_salud`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_receta_3` FOREIGN KEY (`tipo_receta`) REFERENCES `tipo_receta` (`id_tipo_receta`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_receta_4` FOREIGN KEY (`tipo_estado_receta`) REFERENCES `tipo_estado_receta` (`id_tipo_estado_receta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `receta` (`id_receta`, `id_paciente`, `id_profesional_salud`, `tipo_receta`, `tipo_estado_receta`, `fecha_emision`, `fecha_despacho`, `indicaciones_generales`, `comentarios`) VALUES
(1,	1,	1,	1,	1,	'2018-11-11',	'2018-11-11',	'DFSDFASD',	'SDFGSDFGSDFG');

CREATE TABLE `tipo_estado_receta` (
  `id_tipo_estado_receta` int(11) NOT NULL AUTO_INCREMENT,
  `estado` bit(1) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `descripcion` varchar(100) NOT NULL,
  PRIMARY KEY (`id_tipo_estado_receta`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `tipo_estado_receta` (`id_tipo_estado_receta`, `estado`, `nombre`, `descripcion`) VALUES
(1,	CONV('1', 2, 10) + 0,	'CREADA',	'LA RECETA ESTA CREADA PERO NO HA SIDO ENTREGADA');

CREATE TABLE `tipo_medicamento` (
  `id_tipo_medicamento` int(11) NOT NULL AUTO_INCREMENT,
  `estado` bit(1) NOT NULL,
  `nombre` varchar(60) NOT NULL,
  `descripcion_general` varchar(100) NOT NULL,
  PRIMARY KEY (`id_tipo_medicamento`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `tipo_medicamento` (`id_tipo_medicamento`, `estado`, `nombre`, `descripcion_general`) VALUES
(1,	CONV('1', 2, 10) + 0,	'ANTIBIOTICO',	'USO EXCLUSIVO PARA TRATAMIENTO DE INFECCIONES');

CREATE TABLE `tipo_receta` (
  `id_tipo_receta` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(60) NOT NULL,
  `estado` bit(1) NOT NULL,
  `comentarios` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id_tipo_receta`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `tipo_receta` (`id_tipo_receta`, `nombre`, `estado`, `comentarios`) VALUES
(1,	'RECETA USO UNICO',	CONV('1', 2, 10) + 0,	'RECETA DE USO UNICO');

CREATE TABLE `tratamiento_medico` (
  `id_tratamiento_medico` bigint(20) NOT NULL AUTO_INCREMENT,
  `id_historia_clinica` bigint(20) NOT NULL,
  `id_receta` bigint(20) NOT NULL,
  `indicaciones_tratamiento` longtext NOT NULL,
  `observaciones_tratamiento` longtext NOT NULL,
  PRIMARY KEY (`id_tratamiento_medico`),
  KEY `fk_tratamiento_medico_1_idx` (`id_historia_clinica`),
  KEY `fk_tratamiento_medico_2_idx` (`id_receta`),
  CONSTRAINT `fk_tratamiento_medico_1` FOREIGN KEY (`id_historia_clinica`) REFERENCES `historia_clinica` (`id_historia_clinica`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_tratamiento_medico_2` FOREIGN KEY (`id_receta`) REFERENCES `receta` (`id_receta`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

INSERT INTO `tratamiento_medico` (`id_tratamiento_medico`, `id_historia_clinica`, `id_receta`, `indicaciones_tratamiento`, `observaciones_tratamiento`) VALUES
(1,	1,	1,	'23WESDFGASDFGSDFGSDFG',	'SFGSDFGSDFG');

-- 2018-11-13 23:34:21
