use RopaStore
;

INSERT INTO AREA VALUES (1,'Logística'),(2,'Almacén'),(3,'Ventas'),(4,'Compras'),(5,'Gerencia')
;

INSERT INTO CARGO VALUES(1,'Jefe'),(2,'Secretaria'),(3,'Asistente'),(4,'técnico')
;

INSERT INTO LOTE VALUES(1,'SECTOR A'),(2,'SECTOR B'),(3,'SECTOR C'),(4,'SECTOR D'),(5,'SECTOR E')
;

INSERT INTO TIPOPRODUCTO VALUES (1, 'Polo'),(2,'Jean'),(3,'Vestido'),(4,'Pantalón'),
(5,'Polera'),(6,'Casaca'),(7,'Short'),(8,'Sandalias'),(9,'Zapatillas'),(10,'Zapatos')
;
INSERT INTO TRABAJADOR VALUES 
('T001','Pablo','Fernández','71234565','998765432','pfernandez@ropastore.com','Av. Pasteles 234',1,1,'gfernandez'),
('T002','Gibeth','Peña','74854123','912561329','gpeña@ropastore.com','Av. Galletas 234',1,2,'gpena'),
('T003','Alexandra','Vilchez','79876545','967479819','avilchez@ropastore.com','Av. Cupcakes 234',1,3,'avilchez'),
('T004','Zadith','Flores','74567896','912456789','zflores@ropastore.com','Av. Alfajores 234',1,4,'zflores'),
('T005','Luis','Bautista','75739056','945678934','lbautista@ropastore.com','Av. Empanadas 234',1,5,'lbautista')
;

INSERT INTO PROVEEDOR VALUES 
('A001','955566677','Av.Venezuela 123','Sigular', '21234567896','luisperez@singular.com', 'Luis Pérez'),
('A002','912471845','Av. Venezuela 126','Squeeze','28391829302','zadithalarcon@squeeze.com','Zadith Alarcón'),
('A003','913848129','Av. Brasil 212','HyM','28361280381','miguelzavaleta@hym.com', 'Miguel Zavaleta'),
('A004','941234567', 'Av. Sta. Rosa 1234','Nike','24123456789','rosapilares@nike.com','Rosa Pilares'),
('A005','942345671', 'Av. Arequipa 1234','Luvaro','24234567891','joseluisvasquez@luvaro.com','JoseLuis Vasquez'),
('A006','943456712', 'Av. Girasol 1234','Sybilla','24345678912','nicolasabarca@sybilla.com','Nicolas Abarca'),
('A007','944567123', 'Av. Argentina 1234','Index','24456789123','pieroflores@index.com','Piero Flores'),
('A008','945671234', 'Av. Brasil 1234','Denimlab','24567891234','luigiloayza@denimlab.com','Luigi Loayza'),
('A009','946712345', 'Av. Nicolas Piérola 1234','Mango','24678912345','marianamachare@mango.com','Mario Machare'),
('A010','947123456', 'Av. Insurgentes 1234','Medium','24789123456','edernavarro@medium.com','Eder Navarro'),
('A011','941234561', 'Av. Fauccet 1234','Pioner','24891234567','mathiasmuñoz@pioner.com','Mathias Muñoz'),
('A012','941345612', 'Av. Tomás Valle 1234','Puma','24912345678','fernandovargas@puma.com','Fernando Vargas'),
('A013','944561123', 'Av. Alfonso Ugarte 1234','Adidas','24912345678','marianasanchez@adidas.com','Mariana Sanchez'),
('A014','941561123', 'Av. Quilca','Aldo','24112345678','arianamilla@aldo.com','Ariana Milla'),
('A015','941561234', 'Av. Precursores','Clarks','24123456781','ximenamondragon@clarks.com','Ximena Mondragón')
;

INSERT INTO TIPOBAJA VALUES(1,'Deteriodo'),(2,'Pérdida')
;

INSERT INTO ESTADO VALUES (1, 'disponible'), (2,'no disponible')

INSERT INTO PRODUCTO VALUES
('P001',1,'A001','Polo Manga Larga Hombre',77,24.95,20,100,3,1),
('P002',1,'A002','Polo Manga Corta Hombre',24,39.92,15,100,3,1),
('P003',1,'A003','Polo oversize de algodón',24,20,15,100,3,1),
('P004',1,'A004','Polo manga larga',24,30,15,100,3,1),
('P005',1,'A005','Polo Manga Larga Mujer',24,27.96,15,100,3,1),
('P006',2,'A006','Jean para Mujer Urb Mom Fit',24,35.99,15,100,1,1),
('P007',2,'A007','Jean para Mujer Wideleg Inx Ttemp',24,99,15,100,1,1),
('P008',2,'A008','Jean Wide Leg Mujer',24,75,15,100,1,1),
('P009',2,'A009','Jean Básico Mujer',24,55.93,15,100,1,1),
('P010',2,'A010','Jean Flare Mujer',24,55.96,15,100,1,1),
('P011',3,'A011','Vestido Corto Mujer',24,79.9,15,100,2,1),
('P012',3,'A012','Vestido para Mujer Camille',24,39.98,15,100,2,1),
('P013',3,'A013','Vestido en mezcla',24,77.99,15,100,2,1),
('P014',3,'A014','Vestido Perdita Verde',24,88.95,15,100,2,1),
('P015',3,'A015','Vestido Sport Mujer',24,99.5,15,100,2,1),
('P016',4,'A001','Pantalón de punto Loose',24,69.9,15,100,4,1),
('P017',4,'A001','Pantalón Denim Light Timeré Palazo',24,39.95,15,100,4,1),
('P018',4,'A002','Pantalón de buzo holgado',24,39.92,15,100,4,1),
('P019',4,'A003','Pantalón Flare Mujer',24,39.92,15,100,4,1),
('P020',4,'A004','Pantalon Jean Stch Liro Campana',24,39.92,15,100,4,1),
('P032',7,'A001','Short Denim Mujer',24,39.92,15,100,1,1),
('P033',7,'A002','Short Corto Damas Accent Lounge',24,39.92,15,100,1,1),
('P034',7,'A003','Short Color Básico',24,39.92,15,100,1,1),
('P035',7,'A004','Short Doblado Básico',24,39.92,15,100,1,1),
('P036',8,'A005','Sandalias de piscina',24,39.92,15,100,2,1),
('P037',8,'A006','Sandalias Iyumi',24,39.92,15,100,2,1),
('P038',8,'A007','Sandalias Para Mujer',24,39.92,15,100,2,1),
('P039',8,'A008','Sandalias con taco de Mujer Blanco',24,39.92,15,100,2,1),
('P040',8,'A009','Sandalias de tiras',24,39.92,15,100,2,1),
('P041',9,'A010','Zapatillas Urbanas',24,39.92,15,100,4,1),
('P042',9,'A011','Zapatillas Forum Low Blanco',24,39.92,15,100,4,1),
('P043',9,'A012','Zapatillas de poliéster reciclado mujer',24,39.92,15,100,4,1),
('P044',9,'A013','Zapatillas Deportivas',24,39.92,15,100,4,1),
('P045',9,'A014','Zapatillas Urbanas para Mujer Breaknet',24,39.92,15,100,4,1),
('P046',10,'A015','Zapatos casuales negros',24,39.92,15,100,5,1),
('P047',10,'A001','Zapatos casuales Mujer Rosas',24,39.92,15,100,5,1),
('P048',10,'A002','Zapatos casuales Mujer Elevated',24,39.92,15,100,5,1),
('P049',10,'A003','Zapatos casuales Mujer Serena Paige Sand',24,39.92,15,100,5,1),
('P050',10,'A004','Zapatos de salón Medusa',24,39.92,15,100,5,1),
('P021',5,'A005','Polera con capucha y motivo',24,39.92,15,100,5,1),
('P022',5,'A006','Polera oversize con capucha',24,39.92,15,100,5,1),
('P023',5,'A007','Polera Cuello con Print Manga Larga',24,39.92,15,100,5,1),
('P024',5,'A008','Polera Básica con capucha Manga Larga',24,39.92,15,100,5,1),
('P025',5,'A009','Polera Teddy Con Cierre Manga Larga',24,39.92,15,100,5,1),
('P026',6,'A010','Casaca Cortaviento Con Capucha',24,39.92,15,100,3,1),
('P027',6,'A011','Casaca para Mujer Urb',24,39.92,15,100,3,1),
('P028',6,'A012','Casaca Mujer',24,39.92,15,100,3,1),
('P029',6,'A013','Casaca Deportiva con capucha Manga Larga',24,39.92,15,100,3,1),
('P030',6,'A014','Casaca Desire Azul',24,39.92,15,100,3,1),
('P031',7,'A015','Short de Borde Blanco',24,39.92,15,100,1,1)
;
select*from Producto
;