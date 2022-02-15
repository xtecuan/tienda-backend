package com.xtesoft.tienda.resources;

import com.xtesoft.tienda.entities.Producto;
import com.xtesoft.tienda.repositories.ProductoRepo;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/productos")
@Produces("application/json")
@Consumes("application/json")
public class ProductoResource {
    @Inject
    ProductoRepo productoRepo;

    @GET
    public List<Producto> getAll() {
        return productoRepo.listAll();
    }
}