-- base de datos taller
create database taller;

\c taller; -- conectando a la base de datos

-- creacion de tablas

create table marca(
	id_marca integer primary key,
	desc_marca varchar
);

insert into marca values(1,'NISSAN');
insert into marca values(2,'CHEVROLET');
insert into marca values(3,'VOLKSWAGEN');
insert into marca values(4,'KIA');
insert into marca values(5,'HONDA');
insert into marca values(6,'TOYOTA');
insert into marca values(7,'FORD');
insert into marca values(8,'MAZDA');
insert into marca values(9,'DODGE');
insert into marca values(10,'JEEP');
insert into marca values(11,'AUDI');
insert into marca values(12,'MERCEDES BENZ');
insert into marca values(13,'HYUNDAI');	
insert into marca values(14,'SUZUKI');
insert into marca values(15,'CHRYSLER');
insert into marca values(16,'FERRARI');
insert into marca values(17,'LAMBORGHINI');	


create table color(
	id_color integer primary key,
	desc_color varchar
);

insert into color values(1,'AMARILLO');
insert into color values(2,'VERDE');
insert into color values(3,'BLANCO');
insert into color values(4,'ROJO');
insert into color values(5,'AZUL');
insert into color values(6,'NEGRO');
insert into color values(7,'GRIS');
insert into color values(8,'NARANJA');
insert into color values(9,'CAFE');
insert into color values(10,'ROSA');	


create table auto(
	No_placa varchar primary key,
	id_marca integer references marca,
	modelo varchar,
	id_color integer references color
);


create table cliente(
	id_cliente integer,
	No_placa varchar references auto,
	nombre varchar,
	apellidos varchar,
	domicilio varchar, 
	email varchar,
	telefono varchar,
	primary key(id_cliente,No_placa)
);


create table orden_servicio(
	No_orden integer primary key,
	fec_orden date default current_date,
	id_cliente integer,
	No_placa varchar,
	hora_ent time,
	hora_sal time,
	diagnostico text,
	foto_diag varchar,
	serv_realizado text,
	foto_serv_real varchar,
	foreign key(id_cliente,No_placa) references cliente
);
