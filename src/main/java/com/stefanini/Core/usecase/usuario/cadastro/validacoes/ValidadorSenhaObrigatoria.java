package com.stefanini.Core.usecase.usuario.cadastro.validacoes;

import com.stefanini.Core.entities.Usuario;
import com.stefanini.Core.exceptions.BusinessException;
import com.stefanini.Core.usecase.usuario.cadastro.validacoes.ValidacoesCadastro;

public class ValidadorSenhaObrigatoria implements ValidacoesCadastro {
    @Override
    public void validar(Usuario usuario) {
        if (usuario.getSenha() == null || usuario.getSenha().trim().length() == 0)
            throw new BusinessException("O atributo email é obrigatório");
    }
}
