package com.stefanini.Core.usecase.usuario.cadastro.validacoes;

import com.stefanini.Core.entities.Usuario;
import com.stefanini.Core.exceptions.BusinessException;
import com.stefanini.Core.repositories.UsuarioRepository;

public class ValidadorLoginUnico implements ValidacoesCadastro{
    private final UsuarioRepository usuarioRepository;

    public ValidadorLoginUnico(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void validar(Usuario usuario) {
        if(this.usuarioRepository.loginJaCadastrado(usuario.getLogin()))
            throw new BusinessException("Email ja cadastrado");
    }
}
