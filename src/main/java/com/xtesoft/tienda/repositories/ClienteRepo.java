package com.xtesoft.tienda.repositories;

import com.xtesoft.tienda.entities.Cliente;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ClienteRepo implements PanacheRepositoryBase<Cliente,Long> {
}
