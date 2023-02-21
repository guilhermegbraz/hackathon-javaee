package com.stefanini.Core.usecase.usuario.cadastro.validacoes;

import com.stefanini.Core.entities.Usuario;
import com.stefanini.Core.exceptions.BusinessException;

public class ValidadorTamanhoSenha implements ValidacoesCadastro{
    @Override
    public void validar(Usuario usuario) {
        if (usuario.getSenha().length() < 4 || usuario.getSenha().length() > 10)
            throw new BusinessException("O atributo senha deve possuir entre 4 e 10 caracteres");
    }
}
