Bd
-- borra la bd si existe
DROP DATABASE IF EXISTS BDBiblioteca;
-- creamos la bd
CREATE DATABASE BDBiblioteca;
-- activamos la bd
USE BDBiblioteca;

CREATE TABLE tb_categorias (
  idcategoria int auto_increment not null primary key,
  nombre_ct varchar(50) not null
);

CREATE TABLE tb_editoriales (
  ideditorial int auto_increment not null primary key,
  nombre_ed varchar(50) not null
);

CREATE TABLE tb_usuarios (
  idusuario int auto_increment not null primary key,
  nombre varchar(100) not null,
  direccion varchar(200) not null,
  telefono varchar(20) not null,
  corr_usu varchar(50) not null,
  contra_usu varchar(20) not null
);

CREATE TABLE tb_libros (
  idlibro int auto_increment not null primary key,
  titulo varchar(100) not null,
  autor varchar(100) not null,
  idcategoria int not null,
  ideditorial int not null,
  disponibilidad boolean not null,
  constraint fk_categoria foreign key  (idcategoria) references tb_categorias (idcategoria),
  constraint fk_editorial foreign key  (ideditorial) references tb_editoriales (ideditorial)
);

CREATE TABLE tb_prestamos (
  idprestamo int auto_increment not null primary key,
  idlibro int not null,
  idusuario int not null,
  fecha_prestamo date not null,
  fecha_devolucion date,
  constraint fk_libro foreign key  (idlibro) references tb_libros (idlibro),
  constraint fk_usuario foreign key  (idusuario) references tb_usuarios (idusuario)
);

insert into tb_categorias values (null,'Ficción');
insert into tb_categorias values (null,'Ciencia Ficción');
insert into tb_categorias values (null,'Romance');

insert into tb_editoriales values (null,'Scribner');
insert into tb_editoriales values (null,'Secker & Warburg');
insert into tb_editoriales values (null,'Thomas Egerton');

insert into tb_usuarios values (null,'Juan Sanchez', 'Calle Principal 123', '123456789','jsanchez@gmail','js123');
insert into tb_usuarios values (null,'María García', 'Avenida Central 456', '987654321','mgarcia@gmail','mg123');
insert into tb_usuarios values (null,'Luis Rodríguez', 'Plaza Mayor 789', '456789123','lrodriguez@gmail','lr123');

insert into tb_libros values (null,'El Gran Gatsby', 'F. Scott Fitzgerald', 1, 1, 1);
insert into tb_libros values (null,'1984', 'George Orwell', 2, 2, 1);
insert into tb_libros values (null,'Orgullo y Prejuicio', 'Jane Austen', 3, 3, 0);

insert into tb_prestamos values (null,1, 1, '2023-03-01', '2023-04-15');
insert into tb_prestamos values (null,2, 2, '2023-03-02', '2023-04-16');
insert into tb_prestamos values (null,3, 3, '2023-03-03', '2023-04-17');



SELECT * FROM tb_libros;
SELECT * FROM tb_usuarios;
SELECT * FROM tb_categorias;
SELECT * FROM tb_editoriales;
SELECT * FROM tb_prestamos;





SELECT l.titulo AS libro, c.nombre_ct AS categoria, e.nombre_ed AS editorial
FROM tb_libros l
JOIN tb_categorias c ON l.idcategoria = c.idcategoria
JOIN tb_editoriales e ON l.ideditorial = e.ideditorial
WHERE l.disponibilidad = 1;

