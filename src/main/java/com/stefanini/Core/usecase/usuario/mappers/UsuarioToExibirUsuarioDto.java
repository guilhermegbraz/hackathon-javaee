package com.stefanini.Core.usecase.usuario.mappers;

import com.stefanini.Core.entities.Usuario;
import com.stefanini.Core.usecase.usuario.view.ExibirUsuarioDto;

import java.util.ArrayList;
import java.util.List;

public class UsuarioToExibirUsuarioDto {
    public ExibirUsuarioDto execute(Usuario usuario) {
        return new ExibirUsuarioDto(usuario.getNome(), usuario.getLogin(),
                usuario.getEmail(), usuario.getDataDeNascimento());
    }

    public List<ExibirUsuarioDto> execute(List<Usuario> usuarios) {
        List<ExibirUsuarioDto> exibirUsuarioDtoList = new ArrayList<>();
        usuarios.forEach(usuario -> exibirUsuarioDtoList.add(this.execute(usuario)));

        return exibirUsuarioDtoList;
    }
}
