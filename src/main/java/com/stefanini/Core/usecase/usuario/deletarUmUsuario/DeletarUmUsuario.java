package com.stefanini.Core.usecase.usuario.deletarUmUsuario;

import com.stefanini.Core.exceptions.BusinessException;
import com.stefanini.Core.repositories.UsuarioRepository;

public class DeletarUmUsuario {
    private final UsuarioRepository usuarioRepository;

    public DeletarUmUsuario(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void execute(Long id) {
        try{
            this.usuarioRepository.deletar(id);
        } catch(Exception exception) {
            throw new BusinessException("Usuario não encontrado");
        }

    }
}
