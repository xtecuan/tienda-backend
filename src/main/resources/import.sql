INSERT INTO public.clientes (nombres, apellidos, correoe,clave,rol) VALUES('Julian', 'Rivera-Pineda', 'xtecuan@protonmail.com',digest('X4tecuan$', 'sha256'),'admin');
INSERT INTO public.clientes (nombres, apellidos, correoe,clave,rol) VALUES('Jessica Gabriela', 'Hernández Vaquero', 'jessicagabrielavaquero22@gmail.com',digest('Jessita123$', 'sha256'),'user');
INSERT INTO public.clientes (nombres, apellidos, correoe,clave,rol) VALUES('Marta Elisa del Pilar', 'Pineda de Rivera', 'martaederivera@gmail.com',digest('auxilio123$','sha256'),'user');
INSERT INTO public.clientes (nombres, apellidos, correoe,clave,rol) VALUES('Gabriel', 'Bran', 'gabriel.bran@promerica.com.sv',digest('promerica123$','sha256'),'user');
INSERT INTO public.productos (nombre, descripcion, precio) VALUES('Lenovo Thinkpad T470s', 'Laptop', 1350.85);
INSERT INTO public.productos (nombre, descripcion, precio) VALUES('JBL TUNE500BT', 'Headphones', 36.45);
INSERT INTO public.productos (nombre, descripcion, precio) VALUES('MI Earphones', 'Earphones', 8.78);
INSERT INTO public.ordenes (id_cliente, fecha) VALUES(1, '2022-02-14 22:57:30.835');
INSERT INTO public.ordenes (id_cliente, fecha) VALUES(2, '2022-02-14 22:57:49.349');
INSERT INTO public.ordenes (id_cliente, fecha) VALUES(3, '2022-02-14 22:58:46.022');
INSERT INTO public.detalle_ordenes (id_orden, id_producto, cantidad) VALUES(1, 1, 1);
INSERT INTO public.detalle_ordenes (id_orden, id_producto, cantidad) VALUES(2, 2, 2);
INSERT INTO public.detalle_ordenes (id_orden, id_producto, cantidad) VALUES(3, 3, 4);
INSERT INTO public.detalle_ordenes (id_orden, id_producto, cantidad) VALUES(1, 2, 1);
INSERT INTO public.detalle_ordenes (id_orden, id_producto, cantidad) VALUES(2, 1, 1);
INSERT INTO public.detalle_ordenes (id_orden, id_producto, cantidad) VALUES(3, 1, 1);

