package com.xtesoft.tienda.resources;

import com.xtesoft.tienda.entities.Cliente;
import com.xtesoft.tienda.entities.Producto;
import com.xtesoft.tienda.repositories.ClienteRepo;
import com.xtesoft.tienda.repositories.ProductoRepo;

import javax.inject.Inject;
import javax.json.Json;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
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

    @GET
    @Path("{id}")
    public Cliente getSingle(@PathParam("id") Long id) {
        Cliente entity = clienteRepo.findById(id);
        if (entity == null) {
            throw new WebApplicationException("Cliente with id of " + id + " does not exist.", 404);
        }
        return entity;
    }

    @POST
    @Transactional
    public Response create(Cliente cliente) {
        if (cliente.getId() != null) {
            throw new WebApplicationException("Id was invalidly set on request.", 422);
        }
        clienteRepo.persist(cliente);
        return Response.ok(cliente).status(201).build();
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