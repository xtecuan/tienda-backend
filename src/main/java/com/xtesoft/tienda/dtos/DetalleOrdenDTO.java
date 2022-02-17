package com.xtesoft.tienda.dtos;


import java.io.Serializable;

public class DetalleOrdenDTO implements Serializable {
    private Long id;
    private ProductoDTO idProducto;
    private Long cantidad;
    private OrdenDTO idOrden;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductoDTO getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(ProductoDTO idProducto) {
        this.idProducto = idProducto;
    }

    public Long getCantidad() {
        return cantidad;
    }

    public void setCantidad(Long cantidad) {
        this.cantidad = cantidad;
    }

    public OrdenDTO getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(OrdenDTO idOrden) {
        this.idOrden = idOrden;
    }
}
