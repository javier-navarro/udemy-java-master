INSERT INTO clientes (id,apellido,creado_en,editado_en,forma_de_pago,nombre) VALUES (1,'Jaeger',NULL,NULL,'debito','Eren'),(2,'Ackerman',NULL,NULL,'credito','Mikasa'),(3,'Arlet',NULL,NULL,'paypal','Armin'),(4,'Braun',NULL,NULL,'debito','Reiner '),(5,'Dzeko',NULL,NULL,'paypal','Edin'),(6,'Hoover',NULL,NULL,'credito','Bertolt'),(9,'De Bruyne',NULL,NULL,'paypal','Edin'),(10,'saske',NULL,NULL,'debito','Enrique'),(11,'sol',NULL,NULL,'match','ana'),(12,'Rengoku','2024-07-01 16:47:52.000000','2024-07-01 16:50:19.000000','credito','Kyojuro'),(13,'Kamado','2024-07-01 16:55:52.000000','2024-07-01 16:56:44.000000','paypal','Nezuko'),(14,'Ackerman',NULL,NULL,'debito','Levi'),(15,'Zoe',NULL,NULL,NULL,'Hange'),(16,'Smith',NULL,NULL,NULL,'Erwin'),(17,'Kirstein',NULL,NULL,NULL,'Jean'),(18,'Springer',NULL,NULL,NULL,'Connie'),(19,'Leonhart',NULL,NULL,NULL,'Annie');
INSERT INTO alumnos (id,nombre,apellido) values (1,"Obanai" ,"Iguro");
INSERT INTO alumnos (id,nombre,apellido) values (2,"Zanemi" ,"Zhinazugawa");
INSERT INTO cursos (id,profesor,titulo) values (1,"sonia" ,"lenguaje");
INSERT INTO cursos (id,profesor,titulo) values (2,"fredy" ,"matematicas");

insert into direcciones(calle,numero) values ("vaticano", 123);
insert into direcciones(calle,numero) values ("taicho", 456);

insert into tbl_clientes_direcciones (id_cliente,id_direccion) values (1,1);
insert into tbl_clientes_direcciones (id_cliente,id_direccion) values (1,2);

insert into clientes_detalles (prime, puntos_acumulados,cliente_detalle_id) values (1,8000,1);

insert into tbl_alumnos_cursos(alumno_id,curso_id) values (1,1);
insert into tbl_alumnos_cursos(alumno_id,curso_id) values (1,2);

insert into facturas (descripcion, total, id_cliente) values ("oficina", 4000, 1);
insert into facturas (descripcion, total, id_cliente) values ("casa", 2000, 1);
insert into facturas (descripcion, total, id_cliente) values ("deporte", 3000, 1);
insert into facturas (descripcion, total, id_cliente) values ("computacion", 7000, 2);