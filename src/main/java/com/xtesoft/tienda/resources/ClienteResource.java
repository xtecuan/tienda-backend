package com.xtesoft.tienda.resources;

import com.xtesoft.tienda.dtos.UserDTO;
import com.xtesoft.tienda.entities.Cliente;
import com.xtesoft.tienda.entities.Producto;
import com.xtesoft.tienda.repositories.ClienteRepo;
import com.xtesoft.tienda.repositories.ProductoRepo;
import org.jboss.logging.Logger;

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

    @Inject
    Logger log;

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
    @Path("/findByEmailAndPass")
    public Cliente getSingle(UserDTO user) {
        Cliente entity = clienteRepo.findByEmailAndPass(user.getCorreoe(),user.getClave());
        if (entity == null) {
            throw new WebApplicationException("Cliente with email of " + user.getCorreoe() + " does not exist.", 404);
        }
        log.info(entity);
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

    @DELETE
    @Path("{id}")
    @Transactional
    public Response delete(@PathParam("id") Long id) {
        Cliente entity = clienteRepo.findById(id);
        if (entity == null) {
            throw new WebApplicationException("Cliente with id of " + id + " does not exist.", 404);
        }
        clienteRepo.delete(entity);
        return Response.status(204).build();
    }

    @PUT
    @Path("{id}")
    @Transactional
    public Cliente update(@PathParam("id") Long id, Cliente cliente){
        Cliente entity = clienteRepo.findById(id);
        if(cliente==null){
            throw new WebApplicationException("Cliente with id of " + id + " does not exist.", 404);
        }
        if(cliente.getApellidos()==null){
            throw new WebApplicationException("Cliente apellidos was not set on request.", 422);
        }
        if(cliente.getNombres()==null){
            throw new WebApplicationException("Cliente nombres was not set on request.", 422);
        }
        if(cliente.getCorreoe()==null){
            throw new WebApplicationException("Cliente correoe was not set on request.", 422);
        }
        entity.setApellidos(cliente.getApellidos());
        entity.setNombres(cliente.getNombres());
        entity.setCorreoe(cliente.getCorreoe());
        clienteRepo.persist(entity);
        return entity;
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
