package com.stefanini.Core.usecase.usuario.listarTodosUsuarios;

import com.stefanini.Core.usecase.usuario.mappers.UsuarioToExibirUsuarioDto;
import com.stefanini.Core.usecase.usuario.view.ExibirUsuarioDto;
import com.stefanini.Dataproviders.Jpa.repository.UsuarioJpaRepository;

import java.util.ArrayList;
import java.util.List;

public class ListarTodosUsuarios {
    private final UsuarioJpaRepository usuarioJpaRepository;
    private final UsuarioToExibirUsuarioDto usuarioToExibirUsuarioDto;

    public ListarTodosUsuarios(UsuarioJpaRepository usuarioJpaRepository, UsuarioToExibirUsuarioDto usuarioToExibirUsuarioDto) {
        this.usuarioJpaRepository = usuarioJpaRepository;
        this.usuarioToExibirUsuarioDto = usuarioToExibirUsuarioDto;
    }

    public List<ExibirUsuarioDto> execute() {
        var usuarios = this.usuarioJpaRepository.listarTodos();
        List<ExibirUsuarioDto> dtoUsuarios = new ArrayList<>();
        usuarios.forEach(usuario -> dtoUsuarios.add(this.usuarioToExibirUsuarioDto.execute(usuario)));

        return dtoUsuarios;
    }

}
