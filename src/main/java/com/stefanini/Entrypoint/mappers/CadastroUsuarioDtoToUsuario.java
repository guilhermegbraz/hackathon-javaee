package com.stefanini.Entrypoint.mappers;

import com.stefanini.Core.entities.Usuario;
import com.stefanini.Entrypoint.rest.dto.CadastroUsuarioDTO;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CadastroUsuarioDtoToUsuario {
    public Usuario execute(CadastroUsuarioDTO usuarioDTO) {
        return new Usuario(usuarioDTO.getNome(), usuarioDTO.getLogin(),
                usuarioDTO.getEmail(), usuarioDTO.getSenha(), usuarioDTO.getDataDeNascimento());
    }
}
