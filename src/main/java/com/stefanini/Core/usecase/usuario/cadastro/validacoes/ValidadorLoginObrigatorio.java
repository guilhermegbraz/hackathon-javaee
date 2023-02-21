package com.stefanini.Core.usecase.usuario.cadastro.validacoes;

import com.stefanini.Core.entities.Usuario;
import com.stefanini.Core.exceptions.BusinessException;

public class ValidadorLoginObrigatorio implements ValidacoesCadastro{
    @Override
    public void validar(Usuario usuario) {
        if (usuario.getLogin() == null || usuario.getLogin().trim().length() == 0) throw new BusinessException("O atributo login é obrigatório");
    }
}
