package com.xtesoft.tienda.resources;

import com.xtesoft.tienda.entities.Cliente;
import com.xtesoft.tienda.entities.Orden;
import com.xtesoft.tienda.repositories.ClienteRepo;
import com.xtesoft.tienda.repositories.OrdenRepo;

import javax.inject.Inject;
import javax.json.Json;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
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

    @GET
    @Path("{id}")
    public Orden getSingle(@PathParam("id") Long id) {
        Orden entity = ordenRepo.findById(id);
        if (entity == null) {
            throw new WebApplicationException("Orden with id of " + id + " does not exist.", 404);
        }
        return entity;
    }

    @POST
    @Transactional
    public Response create(Orden orden) {
        if (orden.getId() != null) {
            throw new WebApplicationException("Id was invalidly set on request.", 422);
        }
        ordenRepo.persist(orden);
        return Response.ok(orden).status(201).build();
    }

    @Provider
    public static class ErrorMapper implements ExceptionMapper<Exception> {

        @Override
        public Response toResponse(Exception exception) {
            int code = 500;
            if (exception instanceof WebApplicationException) {
                code = ((WebApplicationException) exception).getResponse().getStatus();
            }
            return Response.status(code)
                    .entity(Json.createObjectBuilder().add("error", exception.getMessage()).add("code", code).build())
                    .build();
        }

    }
}
