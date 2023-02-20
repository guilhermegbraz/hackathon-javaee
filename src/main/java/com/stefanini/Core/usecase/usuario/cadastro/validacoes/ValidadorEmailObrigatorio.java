package com.stefanini.Core.usecase.usuario.cadastro.validacoes;

import com.stefanini.Core.entities.Usuario;
import com.stefanini.Core.exceptions.BusinessException;

public class ValidadorEmailObrigatorio implements ValidacoesCadastro{
    @Override
    public void validar(Usuario usuario) {
        if (usuario.getEmail() == null || usuario.getEmail().trim().length() == 0)
            throw new BusinessException("O atributo email é obrigatório");

    }
}
