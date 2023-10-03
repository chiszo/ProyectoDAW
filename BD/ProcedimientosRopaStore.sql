use RopaStore
;

/*TRABAJADORES*/
delimiter //
CREATE PROCEDURE usp_trabajadores()
begin
select *
from Trabajador;
end //
delimiter ;

delimiter //
create procedure usp_trabajadores_add(id char(4), nombres varchar(30), apellidos varchar(30), dni varchar(8),tel varchar(11),correo varchar(60),
direccion varchar(60),idcargo int, idarea int, contraseña varchar(20))
begin
	insert into Trabajador values (id,nombres,apellidos,dni,tel,correo,direccion,idcargo,idarea,contraseña);
end //
delimiter ;

delimiter //
create procedure usp_trabajadores_update(
id char(4), nombres varchar(30), apellidos varchar(30), dni varchar(8),tel varchar(11),correo varchar(60),
direccion varchar(60),idcargo int, idarea int, contraseña varchar(20))
begin
	update TRABAJADOR set Nombres=nombres,Apellidos=apellidos,DNI=dni,Telefono=tel,Correo=correo,Direccion=direccion,IdCargo=idcargo,IdTipoArea=idarea,Contraseña=contraseña where IdTrabajador=id;
end //
delimiter ;

delimiter //
create procedure usp_trabajadores_delete(
id CHAR(4))
begin
	delete from TRABAJADOR WHERE IdTrabajador=id;
end //
delimiter ;

/*PRODUCTOS*/
delimiter //
CREATE PROCEDURE usp_productos()
begin
select *from PRODUCTO;
end //
delimiter ;

delimiter //
create procedure usp_productos_add(
id char(4), tipo int, idproveedor char(4), nombre varchar(40), cantidad smallint, precio decimal(10,2),
min smallint, max smallint, idlote int, estado bit)
begin
	insert into PRODUCTO values (id, tipo, idproveedor, nombre, cantidad, precio,min, max, idlote, estado);
end //
delimiter ;

delimiter //
create procedure usp_productos_update(
id char(4), tipo int, idproveedor char(4), nombre varchar(40), cantidad smallint, precio decimal(10,2),
min smallint, max smallint, idlote int, estado bit)
begin
	update PRODUCTO set IdTipoPro=tipo, IdProveedor=idproveedor, Nombre=nombre, Cantidad=cantidad, Precio=precio,StockMinimo=min, StockMaximo=max, IdLote=idlote, Estado=estado where IdProducto=id;
end //
delimiter ;

delimiter //
create procedure usp_productos_delete(
id CHAR(4))
begin
	delete from PRODUCTO WHERE IdProducto=id;
end //
delimiter ;

/*PROVEEDOR*/
delimiter //
CREATE PROCEDURE usp_proveedor()
begin
select *
from PROVEEDOR;
end //
delimiter ;

delimiter //
create procedure usp_proveedor_add(
id char(4), telefono varchar(11), direccion varchar(80), empresa varchar(20),ruc varchar(11),correo varchar(60),
representante varchar(60))
begin
	insert into PROVEEDOR values 
	(id, telefono, direccion, empresa,ruc,correo,representante);
end //
delimiter ;

delimiter //
create procedure usp_proveedor_update(
id char(4), telefono varchar(11), direccion varchar(80), empresa varchar(20),ruc varchar(11),correo varchar(60),
representante varchar(60))
begin
	update PROVEEDOR set telefono=telefono, direccion=direccion, empresa=empresa,ruc=ruc,correo=correo,representante=representante where IdProveedor=id;
end //
delimiter ;

delimiter //
create procedure usp_proveedor_delete(
id CHAR(4))
begin
	delete from PROVEEDOR WHERE IdProveedor=id;
end //
delimiter ;

/*LOTE*/
delimiter //
create procedure usp_lote()
begin
select*from LOTE;
end //
delimiter ;

/*TIPO DE PRODUCTO*/
delimiter //
create procedure usp_tipotpo()
begin
select*from TIPOPRODUCTO;
end //
delimiter ;

/*CARGO*/
delimiter //
create procedure usp_cargo()
begin
select*from CARGO;
end //
delimiter ;

 /*ÁREA*/
 delimiter //
create procedure usp_area()
begin
select*from AREA;
end //
delimiter ;