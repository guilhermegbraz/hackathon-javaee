package com.stefanini.Core.usecase.usuario.detalharUmUsuario;

import com.stefanini.Core.exceptions.BusinessException;
import com.stefanini.Core.repositories.UsuarioRepository;
import com.stefanini.Core.usecase.usuario.mappers.UsuarioToExibirUsuarioDto;
import com.stefanini.Core.usecase.usuario.view.ExibirUsuarioDto;

public class DetalharUmUsuario {
    private final UsuarioRepository usuarioRepository;
    private final UsuarioToExibirUsuarioDto usuarioToExibirUsuarioDto;

    public DetalharUmUsuario(UsuarioRepository usuarioRepository, UsuarioToExibirUsuarioDto usuarioToExibirUsuarioDto) {
        this.usuarioRepository = usuarioRepository;
        this.usuarioToExibirUsuarioDto = usuarioToExibirUsuarioDto;
    }

    public ExibirUsuarioDto execute(Long id) {
        var usuario = this.usuarioRepository.recuperPorId(id);
        if(usuario == null) throw new BusinessException("Usuario não encontrado");

        return this.usuarioToExibirUsuarioDto.execute(usuario);
    }
}
