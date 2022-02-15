CREATE TABLE public.ordenes (
	id_orden bigserial NOT NULL,
	id_cliente int8 NOT NULL,
	fecha timestamp NOT NULL,
	CONSTRAINT ordenes_pk PRIMARY KEY (id_orden),
	CONSTRAINT ordenes_fk_clientes FOREIGN KEY (id_cliente) REFERENCES public.clientes(id_cliente)
);
COMMENT ON TABLE public.ordenes IS 'Tabla de ordenes de productos por cliente';
