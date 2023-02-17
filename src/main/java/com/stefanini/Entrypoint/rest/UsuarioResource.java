package com.stefanini.Entrypoint.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/usuario")
public class UsuarioResource {

    @GET
    @Produces
    public Response hello() {return Response.status(200).entity("Hello from my resourse").build();}
}
