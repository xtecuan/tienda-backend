CREATE TABLE public.clientes (
	id_cliente bigserial NOT NULL,
	nombres varchar(100) NOT NULL,
	apellidos varchar(100) NOT NULL,
	correoe varchar(100) NOT NULL,
	clave varchar(100) NOT NULL,
	CONSTRAINT clientes_pk PRIMARY KEY (id_cliente)
);
COMMENT ON TABLE public.clientes IS 'Tabla de clientes';
