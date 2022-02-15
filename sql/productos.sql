CREATE TABLE public.productos (
	id_producto bigserial NOT NULL,
	nombre varchar(150) NOT NULL,
	descripcion varchar(500) NULL,
	precio numeric(10, 2) NOT NULL,
	CONSTRAINT productos_pk PRIMARY KEY (id_producto)
);
COMMENT ON TABLE public.productos IS 'Tabla de productos';
