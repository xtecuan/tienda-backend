package com.xtesoft.tienda.resources;

import com.xtesoft.tienda.dtos.UserDTO;
import com.xtesoft.tienda.entities.Cliente;
import com.xtesoft.tienda.repositories.ClienteRepo;
import org.jboss.logging.Logger;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/auth")
@Produces("application/json")
@Consumes("application/json")
public class AuthResource {
    @Inject
    ClienteRepo clienteRepo;
    @Inject
    Logger log;

    @POST
    public Cliente getSingle(UserDTO usuario) {
        log.info("correoe: "+usuario.getCorreoe());
        log.info("clave:" + usuario.getClave());
        Cliente entity = clienteRepo.findByEmailAndPass(usuario.getCorreoe(),usuario.getClave());
        if (entity == null) {
            throw new WebApplicationException("Cliente with email of " + usuario.getCorreoe() + " does not exist.", 404);
        }
        log.info(entity);
        return entity;
    }
}
