-- MySQL dump 10.13  Distrib 8.0.44, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: ropastore
-- ------------------------------------------------------
-- Server version	8.0.44

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `area`
--

DROP TABLE IF EXISTS `area`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `area` (
  `IdTipoArea` varchar(3) NOT NULL,
  `Descripcion` varchar(20) NOT NULL,
  PRIMARY KEY (`IdTipoArea`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `area`
--

LOCK TABLES `area` WRITE;
/*!40000 ALTER TABLE `area` DISABLE KEYS */;
INSERT INTO `area` VALUES ('1','Logística'),('2','Almacén'),('3','Ventas'),('4','Compras'),('5','Gerencia');
/*!40000 ALTER TABLE `area` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `baja_producto`
--

DROP TABLE IF EXISTS `baja_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `baja_producto` (
  `CodBajaPro` char(5) NOT NULL,
  `IdTrabajador` char(4) NOT NULL,
  `FechaBaja` datetime NOT NULL,
  PRIMARY KEY (`CodBajaPro`),
  KEY `IdTrabajador` (`IdTrabajador`),
  CONSTRAINT `baja_producto_ibfk_1` FOREIGN KEY (`IdTrabajador`) REFERENCES `trabajador` (`IdTrabajador`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `baja_producto`
--

LOCK TABLES `baja_producto` WRITE;
/*!40000 ALTER TABLE `baja_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `baja_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cargo`
--

DROP TABLE IF EXISTS `cargo`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cargo` (
  `IdCargo` varchar(3) NOT NULL,
  `Descripcion` varchar(20) NOT NULL,
  PRIMARY KEY (`IdCargo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cargo`
--

LOCK TABLES `cargo` WRITE;
/*!40000 ALTER TABLE `cargo` DISABLE KEYS */;
INSERT INTO `cargo` VALUES ('1','Jefe'),('2','Secretaria'),('3','Asistente'),('4','técnico');
/*!40000 ALTER TABLE `cargo` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `compra_producto`
--

DROP TABLE IF EXISTS `compra_producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `compra_producto` (
  `CodCompraPro` char(5) NOT NULL,
  `FechaPedido` datetime DEFAULT NULL,
  `IdProveedor` char(4) NOT NULL,
  `MontoTotal` decimal(10,2) NOT NULL,
  PRIMARY KEY (`CodCompraPro`),
  KEY `IdProveedor` (`IdProveedor`),
  CONSTRAINT `compra_producto_ibfk_1` FOREIGN KEY (`IdProveedor`) REFERENCES `proveedor` (`IdProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `compra_producto`
--

LOCK TABLES `compra_producto` WRITE;
/*!40000 ALTER TABLE `compra_producto` DISABLE KEYS */;
/*!40000 ALTER TABLE `compra_producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_baja`
--

DROP TABLE IF EXISTS `detalle_baja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_baja` (
  `IdProducto` char(4) NOT NULL,
  `CodBajaPro` char(5) NOT NULL,
  `Cantidad` smallint NOT NULL,
  `IdTipoBaja` varchar(3) DEFAULT NULL,
  PRIMARY KEY (`IdProducto`,`CodBajaPro`),
  KEY `CodBajaPro` (`CodBajaPro`),
  KEY `IdTipoBaja` (`IdTipoBaja`),
  CONSTRAINT `detalle_baja_ibfk_1` FOREIGN KEY (`IdProducto`) REFERENCES `producto` (`IdProducto`),
  CONSTRAINT `detalle_baja_ibfk_2` FOREIGN KEY (`CodBajaPro`) REFERENCES `baja_producto` (`CodBajaPro`),
  CONSTRAINT `detalle_baja_ibfk_3` FOREIGN KEY (`IdTipoBaja`) REFERENCES `tipobaja` (`IdTipoBaja`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_baja`
--

LOCK TABLES `detalle_baja` WRITE;
/*!40000 ALTER TABLE `detalle_baja` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_baja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `detalle_compra`
--

DROP TABLE IF EXISTS `detalle_compra`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `detalle_compra` (
  `CodCompraPro` char(5) NOT NULL,
  `IdProducto` char(4) NOT NULL,
  `PrecioCompra` decimal(10,2) NOT NULL,
  `Cantidad` smallint DEFAULT NULL,
  `Monto` decimal(10,2) NOT NULL,
  PRIMARY KEY (`CodCompraPro`,`IdProducto`),
  KEY `IdProducto` (`IdProducto`),
  CONSTRAINT `detalle_compra_ibfk_1` FOREIGN KEY (`CodCompraPro`) REFERENCES `compra_producto` (`CodCompraPro`),
  CONSTRAINT `detalle_compra_ibfk_2` FOREIGN KEY (`IdProducto`) REFERENCES `producto` (`IdProducto`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `detalle_compra`
--

LOCK TABLES `detalle_compra` WRITE;
/*!40000 ALTER TABLE `detalle_compra` DISABLE KEYS */;
/*!40000 ALTER TABLE `detalle_compra` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `estado`
--

DROP TABLE IF EXISTS `estado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `estado` (
  `idestado` int NOT NULL,
  `descripcion` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`idestado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `estado`
--

LOCK TABLES `estado` WRITE;
/*!40000 ALTER TABLE `estado` DISABLE KEYS */;
INSERT INTO `estado` VALUES (1,'disponible'),(2,'no disponible');
/*!40000 ALTER TABLE `estado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `lote`
--

DROP TABLE IF EXISTS `lote`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `lote` (
  `IdLote` varchar(3) NOT NULL,
  `descripcion` varchar(20) NOT NULL,
  PRIMARY KEY (`IdLote`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `lote`
--

LOCK TABLES `lote` WRITE;
/*!40000 ALTER TABLE `lote` DISABLE KEYS */;
INSERT INTO `lote` VALUES ('1','SECTOR A'),('2','SECTOR B'),('3','SECTOR C'),('4','SECTOR D'),('5','SECTOR E');
/*!40000 ALTER TABLE `lote` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `producto`
--

DROP TABLE IF EXISTS `producto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `producto` (
  `IdProducto` char(4) NOT NULL,
  `IdTipoPro` varchar(3) NOT NULL,
  `IdProveedor` char(4) NOT NULL,
  `Nombre` varchar(40) NOT NULL,
  `Cantidad` smallint NOT NULL,
  `Precio` decimal(10,2) NOT NULL,
  `StockMinimo` smallint NOT NULL,
  `StockMaximo` smallint NOT NULL,
  `IdLote` varchar(3) NOT NULL,
  `idestado` int NOT NULL,
  PRIMARY KEY (`IdProducto`),
  KEY `idestado` (`idestado`),
  KEY `IdLote` (`IdLote`),
  KEY `IdTipoPro` (`IdTipoPro`),
  KEY `IdProveedor` (`IdProveedor`),
  CONSTRAINT `producto_ibfk_1` FOREIGN KEY (`idestado`) REFERENCES `estado` (`idestado`),
  CONSTRAINT `producto_ibfk_2` FOREIGN KEY (`IdLote`) REFERENCES `lote` (`IdLote`),
  CONSTRAINT `producto_ibfk_3` FOREIGN KEY (`IdTipoPro`) REFERENCES `tipoproducto` (`IdTipoPro`),
  CONSTRAINT `producto_ibfk_4` FOREIGN KEY (`IdProveedor`) REFERENCES `proveedor` (`IdProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `producto`
--

LOCK TABLES `producto` WRITE;
/*!40000 ALTER TABLE `producto` DISABLE KEYS */;
INSERT INTO `producto` VALUES ('P001','1','A001','Polo Manga Larga Hombre',77,24.95,20,100,'3',1),('P002','1','A002','Polo Manga Corta Hombre',24,39.92,15,100,'3',1),('P003','1','A003','Polo oversize de algodón',24,20.00,15,100,'3',1),('P004','1','A004','Polo manga larga',24,30.00,15,100,'3',1),('P005','1','A005','Polo Manga Larga Mujer',24,27.96,15,100,'3',1),('P006','2','A006','Jean para Mujer Urb Mom Fit',24,35.99,15,100,'1',1),('P007','2','A007','Jean para Mujer Wideleg Inx Ttemp',24,99.00,15,100,'1',1),('P008','2','A008','Jean Wide Leg Mujer',24,75.00,15,100,'1',1),('P009','2','A009','Jean Básico Mujer',24,55.93,15,100,'1',1),('P010','2','A010','Jean Flare Mujer',24,55.96,15,100,'1',1),('P011','3','A011','Vestido Corto Mujer',24,79.90,15,100,'2',1),('P012','3','A012','Vestido para Mujer Camille',24,39.98,15,100,'2',1),('P013','3','A013','Vestido en mezcla',24,77.99,15,100,'2',1),('P014','3','A014','Vestido Perdita Verde',24,88.95,15,100,'2',1),('P015','3','A015','Vestido Sport Mujer',24,99.50,15,100,'2',1),('P016','4','A001','Pantalón de punto Loose',24,69.90,15,100,'4',1),('P017','4','A001','Pantalón Denim Light Timeré Palazo',24,39.95,15,100,'4',1),('P018','4','A002','Pantalón de buzo holgado',24,39.92,15,100,'4',1),('P019','4','A003','Pantalón Flare Mujer',24,39.92,15,100,'4',1),('P020','4','A004','Pantalon Jean Stch Liro Campana',24,39.92,15,100,'4',1),('P021','5','A005','Polera con capucha y motivo',24,39.92,15,100,'5',1),('P022','5','A006','Polera oversize con capucha',24,39.92,15,100,'5',1),('P023','5','A007','Polera Cuello con Print Manga Larga',24,39.92,15,100,'5',1),('P024','5','A008','Polera Básica con capucha Manga Larga',24,39.92,15,100,'5',1),('P025','5','A009','Polera Teddy Con Cierre Manga Larga',24,39.92,15,100,'5',1),('P026','6','A010','Casaca Cortaviento Con Capucha',24,39.92,15,100,'3',1),('P027','6','A011','Casaca para Mujer Urb',24,39.92,15,100,'3',1),('P028','6','A012','Casaca Mujer',24,39.92,15,100,'3',1),('P029','6','A013','Casaca Deportiva con capucha Manga Larga',24,39.92,15,100,'3',1),('P030','6','A014','Casaca Desire Azul',24,39.92,15,100,'3',1),('P031','7','A015','Short de Borde Blanco',24,39.92,15,100,'1',1),('P032','7','A001','Short Denim Mujer',24,39.92,15,100,'1',1),('P033','7','A002','Short Corto Damas Accent Lounge',24,39.92,15,100,'1',1),('P034','7','A003','Short Color Básico',24,39.92,15,100,'1',1),('P035','7','A004','Short Doblado Básico',24,39.92,15,100,'1',1),('P036','8','A005','Sandalias de piscina',24,39.92,15,100,'2',1),('P037','8','A006','Sandalias Iyumi',24,39.92,15,100,'2',1),('P038','8','A007','Sandalias Para Mujer',24,39.92,15,100,'2',1),('P039','8','A008','Sandalias con taco de Mujer Blanco',24,39.92,15,100,'2',1),('P040','8','A009','Sandalias de tiras',24,39.92,15,100,'2',1),('P041','9','A010','Zapatillas Urbanas',24,39.92,15,100,'4',1),('P042','9','A011','Zapatillas Forum Low Blanco',24,39.92,15,100,'4',1),('P043','9','A012','Zapatillas de poliéster reciclado mujer',24,39.92,15,100,'4',1),('P044','9','A013','Zapatillas Deportivas',24,39.92,15,100,'4',1),('P045','9','A014','Zapatillas Urbanas para Mujer Breaknet',24,39.92,15,100,'4',1),('P046','10','A015','Zapatos casuales negros',24,39.92,15,100,'5',1),('P047','10','A001','Zapatos casuales Mujer Rosas',24,39.92,15,100,'5',1),('P048','10','A002','Zapatos casuales Mujer Elevated',24,39.92,15,100,'5',1),('P049','10','A003','Zapatos casuales Mujer Serena Paige Sand',24,39.92,15,100,'1',1);
/*!40000 ALTER TABLE `producto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `proveedor`
--

DROP TABLE IF EXISTS `proveedor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `proveedor` (
  `IdProveedor` char(4) NOT NULL,
  `Telefono` varchar(11) NOT NULL,
  `Direccion` varchar(80) NOT NULL,
  `Empresa` varchar(20) NOT NULL,
  `RUC` varchar(11) NOT NULL,
  `Correo` varchar(60) NOT NULL,
  `Representante` varchar(60) DEFAULT NULL,
  PRIMARY KEY (`IdProveedor`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `proveedor`
--

LOCK TABLES `proveedor` WRITE;
/*!40000 ALTER TABLE `proveedor` DISABLE KEYS */;
INSERT INTO `proveedor` VALUES ('A001','955566677','Av.Venezuela 123','Sigular','21234567896','luisperez@singular.com','Luis Pérez'),('A002','912471845','Av. Venezuela 126','Squeeze','28391829302','zadithalarcon@squeeze.com','Zadith Alarcón'),('A003','913848129','Av. Brasil 212','HyM','28361280381','miguelzavaleta@hym.com','Miguel Zavaleta'),('A004','941234567','Av. Sta. Rosa 1234','Nike','24123456789','rosapilares@nike.com','Rosa Pilares'),('A005','942345671','Av. Arequipa 1234','Luvaro','24234567891','joseluisvasquez@luvaro.com','JoseLuis Vasquez'),('A006','943456712','Av. Girasol 1234','Sybilla','24345678912','nicolasabarca@sybilla.com','Nicolas Abarca'),('A007','944567123','Av. Argentina 1234','Index','24456789123','pieroflores@index.com','Piero Flores'),('A008','945671234','Av. Brasil 1234','Denimlab','24567891234','luigiloayza@denimlab.com','Luigi Loayza'),('A009','946712345','Av. Nicolas Piérola 1234','Mango','24678912345','marianamachare@mango.com','Mario Machare'),('A010','947123456','Av. Insurgentes 1234','Medium','24789123456','edernavarro@medium.com','Eder Navarro'),('A011','941234561','Av. Fauccet 1234','Pioner','24891234567','mathiasmuñoz@pioner.com','Mathias Muñoz'),('A012','941345612','Av. Tomás Valle 1234','Puma','24912345678','fernandovargas@puma.com','Fernando Vargas'),('A013','944561123','Av. Alfonso Ugarte 1234','Adidas','24912345678','marianasanchez@adidas.com','Mariana Sanchez'),('A014','941561123','Av. Quilca','Aldo','24112345678','arianamilla@aldo.com','Ariana Milla'),('A015','941561234','Av. Precursores','Clarks','24123456781','ximenamondragon@clarks.com','Ximena Mondragón');
/*!40000 ALTER TABLE `proveedor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipobaja`
--

DROP TABLE IF EXISTS `tipobaja`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipobaja` (
  `IdTipoBaja` varchar(3) NOT NULL,
  `Descripcion` varchar(20) NOT NULL,
  PRIMARY KEY (`IdTipoBaja`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipobaja`
--

LOCK TABLES `tipobaja` WRITE;
/*!40000 ALTER TABLE `tipobaja` DISABLE KEYS */;
INSERT INTO `tipobaja` VALUES ('1','Deteriodo'),('2','Pérdida');
/*!40000 ALTER TABLE `tipobaja` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tipoproducto`
--

DROP TABLE IF EXISTS `tipoproducto`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `tipoproducto` (
  `IdTipoPro` varchar(3) NOT NULL,
  `Descripcion` varchar(20) NOT NULL,
  PRIMARY KEY (`IdTipoPro`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tipoproducto`
--

LOCK TABLES `tipoproducto` WRITE;
/*!40000 ALTER TABLE `tipoproducto` DISABLE KEYS */;
INSERT INTO `tipoproducto` VALUES ('1','Polo'),('10','Zapatos'),('2','Jean'),('3','Vestido'),('4','Pantalón'),('5','Polera'),('6','Casaca'),('7','Short'),('8','Sandalias'),('9','Zapatillas');
/*!40000 ALTER TABLE `tipoproducto` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `trabajador`
--

DROP TABLE IF EXISTS `trabajador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `trabajador` (
  `IdTrabajador` char(4) NOT NULL,
  `Nombres` varchar(30) NOT NULL,
  `Apellidos` varchar(30) NOT NULL,
  `DNI` varchar(8) NOT NULL,
  `Telefono` varchar(11) NOT NULL,
  `Correo` varchar(60) NOT NULL,
  `Direccion` varchar(60) NOT NULL,
  `IdCargo` varchar(3) NOT NULL,
  `IdTipoArea` varchar(3) NOT NULL,
  `Contraseña` varchar(250) NOT NULL,
  PRIMARY KEY (`IdTrabajador`),
  KEY `IdTipoArea` (`IdTipoArea`),
  KEY `IdCargo` (`IdCargo`),
  CONSTRAINT `trabajador_ibfk_1` FOREIGN KEY (`IdTipoArea`) REFERENCES `area` (`IdTipoArea`),
  CONSTRAINT `trabajador_ibfk_2` FOREIGN KEY (`IdCargo`) REFERENCES `cargo` (`IdCargo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `trabajador`
--

LOCK TABLES `trabajador` WRITE;
/*!40000 ALTER TABLE `trabajador` DISABLE KEYS */;
INSERT INTO `trabajador` VALUES ('T001','Pablo','Fernández','71234565','998765432','pfernandez@ropastore.com','Av. Pasteles 234','1','1','gfernandez'),('T002','Gibeth','Peña','74854123','912561329','gpeña@ropastore.com','Av. Galletas 234','1','2','gpena'),('T003','Alexandra','Vilchez','79876545','967479819','avilchez@ropastore.com','Av. Cupcakes 234','1','3','avilchez'),('T004','Zadith','Flores','74567896','912456789','zflores@ropastore.com','Av. Alfajores 234','1','4','zflores'),('T005','Luis','Bautista','75739056','945678934','lbautista@ropastore.com','Av. Empanadas 234','1','5','lbautista');
/*!40000 ALTER TABLE `trabajador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'ropastore'
--

--
-- Dumping routines for database 'ropastore'
--
/*!50003 DROP PROCEDURE IF EXISTS `usp_area` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_area`()
begin
select*from AREA;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_cargo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_cargo`()
begin
select*from CARGO;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_lote` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_lote`()
begin
select*from LOTE;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_productos` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_productos`()
begin
select *from PRODUCTO;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_productos_add` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_productos_add`(
id char(4), tipo int, idproveedor char(4), nombre varchar(40), cantidad smallint, precio decimal(10,2),
min smallint, max smallint, idlote int, estado bit)
begin
	insert into PRODUCTO values (id, tipo, idproveedor, nombre, cantidad, precio,min, max, idlote, estado);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_productos_delete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_productos_delete`(
id CHAR(4))
begin
	delete from PRODUCTO WHERE IdProducto=id;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_productos_update` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_productos_update`(
id char(4), tipo int, idproveedor char(4), nombre varchar(40), cantidad smallint, precio decimal(10,2),
min smallint, max smallint, idlote int, estado bit)
begin
	update PRODUCTO set IdTipoPro=tipo, IdProveedor=idproveedor, Nombre=nombre, Cantidad=cantidad, Precio=precio,StockMinimo=min, StockMaximo=max, IdLote=idlote, Estado=estado where IdProducto=id;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_proveedor` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_proveedor`()
begin
select *
from PROVEEDOR;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_proveedor_add` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_proveedor_add`(
id char(4), telefono varchar(11), direccion varchar(80), empresa varchar(20),ruc varchar(11),correo varchar(60),
representante varchar(60))
begin
	insert into PROVEEDOR values 
	(id, telefono, direccion, empresa,ruc,correo,representante);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_proveedor_delete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_proveedor_delete`(
id CHAR(4))
begin
	delete from PROVEEDOR WHERE IdProveedor=id;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_proveedor_update` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_proveedor_update`(
id char(4), telefono varchar(11), direccion varchar(80), empresa varchar(20),ruc varchar(11),correo varchar(60),
representante varchar(60))
begin
	update PROVEEDOR set telefono=telefono, direccion=direccion, empresa=empresa,ruc=ruc,correo=correo,representante=representante where IdProveedor=id;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_tipotpo` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_tipotpo`()
begin
select*from TIPOPRODUCTO;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_trabajadores` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_trabajadores`()
begin
select *
from Trabajador;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_trabajadores_add` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_trabajadores_add`(id char(4), nombres varchar(30), apellidos varchar(30), dni varchar(8),tel varchar(11),correo varchar(60),
direccion varchar(60),idcargo int, idarea int, contraseña varchar(20))
begin
	insert into Trabajador values (id,nombres,apellidos,dni,tel,correo,direccion,idcargo,idarea,contraseña);
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_trabajadores_delete` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_trabajadores_delete`(
id CHAR(4))
begin
	delete from TRABAJADOR WHERE IdTrabajador=id;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!50003 DROP PROCEDURE IF EXISTS `usp_trabajadores_update` */;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8mb4 */ ;
/*!50003 SET character_set_results = utf8mb4 */ ;
/*!50003 SET collation_connection  = utf8mb4_0900_ai_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
CREATE DEFINER=`root`@`localhost` PROCEDURE `usp_trabajadores_update`(
id char(4), nombres varchar(30), apellidos varchar(30), dni varchar(8),tel varchar(11),correo varchar(60),
direccion varchar(60),idcargo int, idarea int, contraseña varchar(20))
begin
	update TRABAJADOR set Nombres=nombres,Apellidos=apellidos,DNI=dni,Telefono=tel,Correo=correo,Direccion=direccion,IdCargo=idcargo,IdTipoArea=idarea,Contraseña=contraseña where IdTrabajador=id;
end ;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-11-02 23:36:21
