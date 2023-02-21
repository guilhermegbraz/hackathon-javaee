package com.stefanini.Core.usecase.usuario.cadastro.validacoes;

import com.stefanini.Core.entities.Usuario;
import com.stefanini.Core.exceptions.BusinessException;

public class ValidadorTamanhoLogin implements ValidacoesCadastro{
    @Override
    public void validar(Usuario usuario) {
        if(usuario.getLogin().length() < 5 || usuario.getLogin().length() > 20)
            throw new BusinessException("O atributo Login deve possuir entre 5 e 20 caracteres");
    }
}
