package com.xtesoft.tienda.dtos;

import java.io.Serializable;

public class OrdenDTO implements Serializable {
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public OrdenDTO() {
    }

    public OrdenDTO(Long id) {
        this.id = id;
    }
}
