package com.stefanini.Entrypoint.mappers;

import com.stefanini.Core.entities.Usuario;
import com.stefanini.Entrypoint.rest.dto.AtualizarUsuarioDTO;
import javax.enterprise.context.ApplicationScoped;
import java.time.LocalDate;


@ApplicationScoped
public class AtualizarUsuarioDtoToUsuario {
    public Usuario execute(AtualizarUsuarioDTO atualizarUsuarioDto) {
        return new Usuario(atualizarUsuarioDto.getId(), atualizarUsuarioDto.getNome(), atualizarUsuarioDto.getLogin(),
                atualizarUsuarioDto.getEmail(), atualizarUsuarioDto.getSenha(), atualizarUsuarioDto.getDataDeNascimento()
               );
    }
}
