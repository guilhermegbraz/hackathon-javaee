package com.stefanini.Core.usecase.usuario.listarProvedores;

import com.stefanini.Core.repositories.UsuarioRepository;

import java.util.Set;

public class ListarProvedores {

    private final UsuarioRepository usuarioRepository;

    public ListarProvedores(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Set<String> execute() {
        return this.usuarioRepository.listarProvedoresEmailUsuarios();
    }
}
