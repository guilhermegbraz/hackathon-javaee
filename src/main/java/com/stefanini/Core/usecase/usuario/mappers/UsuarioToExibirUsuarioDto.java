package com.stefanini.Core.usecase.usuario.mappers;

import com.stefanini.Core.entities.Usuario;
import com.stefanini.Core.usecase.usuario.view.ExibirUsuarioDto;

public class UsuarioToExibirUsuarioDto {
    public ExibirUsuarioDto execute(Usuario usuario) {
        return new ExibirUsuarioDto(usuario.getNome(), usuario.getLogin(),
                usuario.getEmail(), usuario.getDataDeNascimento());
    }
}
