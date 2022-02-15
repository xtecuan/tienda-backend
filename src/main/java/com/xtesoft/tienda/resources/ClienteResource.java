package com.xtesoft.tienda.resources;

import com.xtesoft.tienda.entities.Cliente;
import com.xtesoft.tienda.entities.Producto;
import com.xtesoft.tienda.repositories.ClienteRepo;
import com.xtesoft.tienda.repositories.ProductoRepo;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/clientes")
@Produces("application/json")
@Consumes("application/json")
public class ClienteResource {
    @Inject
    ClienteRepo clienteRepo;

    @GET
    public List<Cliente> getAll() {
        return clienteRepo.listAll();
    }
}