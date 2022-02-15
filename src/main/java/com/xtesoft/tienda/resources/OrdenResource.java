package com.xtesoft.tienda.resources;

import com.xtesoft.tienda.entities.Cliente;
import com.xtesoft.tienda.entities.Orden;
import com.xtesoft.tienda.repositories.ClienteRepo;
import com.xtesoft.tienda.repositories.OrdenRepo;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/ordenes")
@Produces("application/json")
@Consumes("application/json")
public class OrdenResource {
    @Inject
    OrdenRepo ordenRepo;

    @GET
    public List<Orden> getAll() {
        return ordenRepo.listAll();
    }
}