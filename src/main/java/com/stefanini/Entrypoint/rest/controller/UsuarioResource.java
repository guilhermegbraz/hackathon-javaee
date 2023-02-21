package com.stefanini.Entrypoint.rest.controller;

import com.stefanini.Core.entities.Usuario;
import com.stefanini.Core.exceptions.BusinessException;
import com.stefanini.Core.usecase.usuario.cadastro.CadastroUsuario;
import com.stefanini.Core.usecase.usuario.detalharUmUsuario.DetalharUmUsuario;
import com.stefanini.Core.usecase.usuario.listarTodosUsuarios.ListarTodosUsuarios;
import com.stefanini.Dataproviders.Jpa.entity.UsuarioEntity;
import com.stefanini.Dataproviders.Jpa.repository.UsuarioJpaRepository;
import com.stefanini.Dataproviders.dao.GenericDAO;
import com.stefanini.Entrypoint.mappers.CadastroUsuarioDtoToUsuario;
import com.stefanini.Entrypoint.rest.dto.CadastroUsuarioDTO;
import org.jboss.resteasy.annotations.Body;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

@Path("/usuario")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    @Inject
    private CadastroUsuarioDtoToUsuario converterUsuarioDtoToUsuario;

    @Inject
    CadastroUsuario cadastroUsuario;
    @Inject
    ListarTodosUsuarios listarTodosUsuarios;
    @Inject
    DetalharUmUsuario detalharUmUsuario;

    @Inject
    UsuarioJpaRepository usuarioJpaRepository;

    @GET
    public Response hello() {
        return Response.status(200).entity(usuarioJpaRepository.listarTodos()).build();
    }

    @POST
    public Response CriarUsuario( CadastroUsuarioDTO novoUsuario) {
        try{
            Usuario usuario = converterUsuarioDtoToUsuario.execute(novoUsuario);
            var id = cadastroUsuario.execute(usuario);
            URI uri = UriBuilder.fromPath("/usuario/{id}").resolveTemplate("id", id).build();
            usuario.setId(Long.valueOf(id));
            return Response.created(uri).status(Response.Status.CREATED).build();
        }catch (BusinessException exception) {
            return Response.status(Response.Status.BAD_REQUEST).entity(exception.getMessage()).build();
        }
    }

    @GET
    public Response ListarUsuarios() {
        var usuarios = this.listarTodosUsuarios.execute();
        return Response.status(Response.Status.OK).entity(usuarios).build();
    }

    @GET
    @Path("/{idUsuario}")
    public Response detalharUsuario(@PathParam("idUsuario") String idUsuario) {
        try{
            var usuario = this.detalharUmUsuario.execute(Long.valueOf(idUsuario));
            return Response.status(Response.Status.FOUND).entity(usuario).build();
        } catch(BusinessException exception){
            return Response.status(Response.Status.NOT_FOUND).entity(exception.getMessage()).build();
        }
    }


}
