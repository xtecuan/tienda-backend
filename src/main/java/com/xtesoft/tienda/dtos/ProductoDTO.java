package com.xtesoft.tienda.dtos;

import java.io.Serializable;

public class ProductoDTO implements Serializable {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ProductoDTO(Long id) {
        this.id = id;
    }

    public ProductoDTO() {

    }
}
