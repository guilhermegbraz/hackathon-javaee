package com.stefanini.Core.usecase.usuario.listarTodosUsuarios;

import com.stefanini.Core.repositories.UsuarioRepository;
import com.stefanini.Core.usecase.usuario.mappers.UsuarioToExibirUsuarioDto;
import com.stefanini.Core.usecase.usuario.view.ExibirUsuarioDto;
import com.stefanini.Dataproviders.Jpa.repository.UsuarioJpaRepository;

import java.util.ArrayList;
import java.util.List;

public class ListarTodosUsuarios {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioToExibirUsuarioDto usuarioToExibirUsuarioDto;

    public ListarTodosUsuarios(UsuarioJpaRepository usuarioJpaRepository, UsuarioToExibirUsuarioDto usuarioToExibirUsuarioDto) {
        this.usuarioRepository = usuarioJpaRepository;
        this.usuarioToExibirUsuarioDto = usuarioToExibirUsuarioDto;
    }

    public List<ExibirUsuarioDto> execute() {
        var usuarios = this.usuarioRepository.listarTodos();
        List<ExibirUsuarioDto> dtoUsuarios = new ArrayList<>();
        usuarios.forEach(usuario -> dtoUsuarios.add(this.usuarioToExibirUsuarioDto.execute(usuario)));

        return dtoUsuarios;
    }

}
