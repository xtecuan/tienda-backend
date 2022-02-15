package com.xtesoft.tienda.resources;

import com.xtesoft.tienda.entities.DetalleOrden;
import com.xtesoft.tienda.entities.Orden;
import com.xtesoft.tienda.repositories.DetalleOrdenRepo;
import com.xtesoft.tienda.repositories.OrdenRepo;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/detalleordenes")
@Produces("application/json")
@Consumes("application/json")
public class DetalleOrdenResource {
    @Inject
    DetalleOrdenRepo detalleOrdenRepo;

    @GET
    public List<DetalleOrden> getAll() {
        return detalleOrdenRepo.listAll();
    }
}