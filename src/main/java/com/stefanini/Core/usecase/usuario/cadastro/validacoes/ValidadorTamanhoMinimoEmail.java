package com.stefanini.Core.usecase.usuario.cadastro.validacoes;

import com.stefanini.Core.entities.Usuario;
import com.stefanini.Core.exceptions.BusinessException;

public class ValidadorTamanhoMinimoEmail implements ValidacoesCadastro{
    @Override
    public void validar(Usuario usuario) {
        if (usuario.getEmail().length() < 10)
            throw new BusinessException("O Atributo e-mail deve possuir no minimo 10 caracteres");
    }
}
