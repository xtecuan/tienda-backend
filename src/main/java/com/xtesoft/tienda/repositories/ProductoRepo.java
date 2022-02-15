package com.xtesoft.tienda.repositories;

import com.xtesoft.tienda.entities.Producto;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProductoRepo implements PanacheRepositoryBase<Producto,Long> {
}
