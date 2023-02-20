package com.stefanini.Core.usecase.usuario.cadastro.validacoes;

import com.stefanini.Core.entities.Usuario;
import com.stefanini.Core.exceptions.BusinessException;

public class ValidadorTamanhoMaximoNome implements ValidacoesCadastro{
    @Override
    public void validar(Usuario usuario) {
        if(usuario.getNome().length() > 50)
            throw new BusinessException("O atributo nome não deve exceder 50 caracteres");
    }
}
