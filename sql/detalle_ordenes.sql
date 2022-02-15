CREATE TABLE public.detalle_ordenes (
	id_detalle_orden bigserial NOT NULL,
	id_orden bigint NOT NULL,
	id_producto bigint NOT NULL,
	cantidad bigint NOT NULL,
	CONSTRAINT detalle_ordenes_pk PRIMARY KEY (id_detalle_orden),
	CONSTRAINT detalle_ordenes_fk_productos FOREIGN KEY (id_producto) REFERENCES public.productos(id_producto),
	CONSTRAINT detalle_ordenes_fk_ordenes FOREIGN KEY (id_orden) REFERENCES public.ordenes(id_orden)
);
COMMENT ON TABLE public.detalle_ordenes IS 'Detalle de la orden';
