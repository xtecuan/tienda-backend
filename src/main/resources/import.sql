INSERT INTO public.clientes (nombres, apellidos, correoe) VALUES('Julian', 'Rivera-Pineda', 'xtecuan@protonmail.com');
INSERT INTO public.clientes (nombres, apellidos, correoe) VALUES('Jessica Gabriela', 'Hernández Vaquero', 'jessicagabrielavaquero22@gmail.com');
INSERT INTO public.clientes (nombres, apellidos, correoe) VALUES('Marta Elisa del Pilar', 'Pineda de Rivera', 'martaederivera@gmail.com');
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

