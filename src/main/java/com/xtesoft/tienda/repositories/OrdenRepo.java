package com.xtesoft.tienda.repositories;

import com.xtesoft.tienda.entities.Orden;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class OrdenRepo implements PanacheRepositoryBase<Orden,Long> {
}
