CREATE DATABASE RopaStore;

USE RopaStore;

CREATE TABLE AREA
( 
	IdTipoArea           varchar(3)  NOT NULL ,
	Descripcion          varchar(20)  NOT NULL 
);



ALTER TABLE AREA
	ADD  PRIMARY KEY  CLUSTERED (IdTipoArea ASC);



CREATE TABLE BAJA_PRODUCTO
( 
	CodBajaPro           char(5)  NOT NULL ,
	IdTrabajador         char(4)  NOT NULL ,
	FechaBaja            datetime  NOT NULL 
);



ALTER TABLE BAJA_PRODUCTO
	ADD  PRIMARY KEY  CLUSTERED (CodBajaPro ASC);



CREATE TABLE CARGO
( 
	IdCargo              varchar(3)  NOT NULL ,
	Descripcion          varchar(20)  NOT NULL 
);



ALTER TABLE CARGO
	ADD  PRIMARY KEY  CLUSTERED (IdCargo ASC);



CREATE TABLE DETALLE_BAJA
( 
	IdProducto           char(4)  NOT NULL ,
	CodBajaPro           char(5)  NOT NULL ,
	Cantidad             smallint  NOT NULL ,
	IdTipoBaja           varchar(3)  NULL 
);



ALTER TABLE DETALLE_BAJA
	ADD  PRIMARY KEY  CLUSTERED (IdProducto ASC,CodBajaPro ASC);



CREATE TABLE DETALLE_COMPRA
( 
	CodCompraPro        char(5)  NOT NULL ,
	IdProducto           char(4)  NOT NULL ,
	PrecioCompra         decimal(10,2) NOT NULL ,
	Cantidad             smallint  NULL ,
	Monto                decimal(10,2) NOT NULL 
);



ALTER TABLE DETALLE_COMPRA
	ADD  PRIMARY KEY  CLUSTERED (CodCompraPro ASC,IdProducto ASC);


CREATE TABLE COMPRA_PRODUCTO
( 
	CodCompraPro        char(5)  NOT NULL ,
	FechaPedido          datetime  NULL ,
	IdProveedor          char(4)  NOT NULL ,
	MontoTotal           decimal(10,2)  NOT NULL 
);


ALTER TABLE COMPRA_PRODUCTO
	ADD  PRIMARY KEY  CLUSTERED (CodCompraPro ASC);

CREATE TABLE LOTE
(
IdLote varchar(3) PRIMARY KEY,
Descripcrion varchar(20) NOT NULL

);


CREATE TABLE PRODUCTO
( 
	IdProducto           char(4)  NOT NULL ,
	IdTipoPro            varchar(3)  NOT NULL ,
	IdProveedor          char(4)  NOT NULL ,
	Nombre               varchar(40)  NOT NULL ,
	Cantidad             smallint  NOT NULL ,
	Precio               decimal(10,2) NOT NULL ,
	StockMinimo          smallint  NOT NULL ,
	StockMaximo          smallint  NOT NULL ,
	IdLote				varchar(3) NOT NULL,
	idestado               integer  NOT NULL
);

CREATE TABLE ESTADO
(   idestado INTEGER PRIMARY KEY,
    descripcion varchar(20)
);

ALTER TABLE PRODUCTO
	ADD FOREIGN KEY (idestado) REFERENCES ESTADO(idestado)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;

ALTER TABLE PRODUCTO
	ADD  PRIMARY KEY  CLUSTERED (IdProducto ASC);



CREATE TABLE PROVEEDOR
( 
	IdProveedor          char(4)  NOT NULL ,
	Telefono             varchar(11)  NOT NULL ,
	Direccion            varchar(80)  NOT NULL ,
	Empresa              varchar(20)  NOT NULL ,
	RUC                  varchar(11)  NOT NULL ,
	Correo               varchar(60)  NOT NULL ,
	Representante        varchar(60)  NULL 
);



ALTER TABLE PROVEEDOR
	ADD  PRIMARY KEY  CLUSTERED (IdProveedor ASC);



CREATE TABLE TIPOBAJA
( 
	IdTipoBaja           varchar(3)  NOT NULL ,
	Descripcion          varchar(20)  NOT NULL 
);



ALTER TABLE TIPOBAJA
	ADD  PRIMARY KEY  CLUSTERED (IdTipoBaja ASC);



CREATE TABLE TIPOPRODUCTO
( 
	IdTipoPro            varchar(3)  NOT NULL ,
	Descripcion          varchar(20)  NOT NULL 
);



ALTER TABLE TIPOPRODUCTO
	ADD  PRIMARY KEY  CLUSTERED (IdTipoPro ASC);



CREATE TABLE TRABAJADOR
( 
	IdTrabajador         char(4)  NOT NULL ,
	Nombres              varchar(30)  NOT NULL ,
	Apellidos            varchar(30)  NOT NULL ,
	DNI                  varchar(8)  NOT NULL ,
	Telefono             varchar(11)  NOT NULL ,
	Correo               varchar(60)  NOT NULL ,
	Direccion            varchar(60)  NOT NULL ,
	IdCargo              varchar(3)  NOT NULL ,
	IdTipoArea           varchar(3)  NOT NULL ,
	Contraseña           varchar(250)  NOT NULL
);



ALTER TABLE TRABAJADOR
	ADD  PRIMARY KEY  CLUSTERED (IdTrabajador ASC);

ALTER TABLE PRODUCTO
	ADD FOREIGN KEY (IdLote) REFERENCES LOTE(IdLote)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;


ALTER TABLE BAJA_PRODUCTO
	ADD  FOREIGN KEY (IdTrabajador) REFERENCES TRABAJADOR(IdTrabajador)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;




ALTER TABLE DETALLE_BAJA
	ADD  FOREIGN KEY (IdProducto) REFERENCES PRODUCTO(IdProducto)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;




ALTER TABLE DETALLE_BAJA
	ADD  FOREIGN KEY (CodBajaPro) REFERENCES BAJA_PRODUCTO(CodBajaPro)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;



ALTER TABLE DETALLE_BAJA
	ADD  FOREIGN KEY (IdTipoBaja) REFERENCES TIPOBAJA(IdTipoBaja)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;




ALTER TABLE DETALLE_COMPRA
	ADD  FOREIGN KEY (CodCompraPro) REFERENCES COMPRA_PRODUCTO(CodCompraPro)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;




ALTER TABLE DETALLE_COMPRA
	ADD  FOREIGN KEY (IdProducto) REFERENCES PRODUCTO(IdProducto)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;




ALTER TABLE COMPRA_PRODUCTO
	ADD  FOREIGN KEY (IdProveedor) REFERENCES PROVEEDOR(IdProveedor)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;




ALTER TABLE PRODUCTO
	ADD  FOREIGN KEY (IdTipoPro) REFERENCES TIPOPRODUCTO(IdTipoPro)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;



ALTER TABLE PRODUCTO
	ADD  FOREIGN KEY (IdProveedor) REFERENCES PROVEEDOR(IdProveedor)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;




ALTER TABLE TRABAJADOR
	ADD  FOREIGN KEY (IdTipoArea) REFERENCES AREA(IdTipoArea)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;




ALTER TABLE TRABAJADOR
	ADD  FOREIGN KEY (IdCargo) REFERENCES CARGO(IdCargo)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION;