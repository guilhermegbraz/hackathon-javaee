package com.stefanini.Core.usecase.usuario.cadastro.validacoes;

import com.stefanini.Core.entities.Usuario;
import com.stefanini.Core.exceptions.BusinessException;

public class ValidadorNomeObrigatório implements ValidacoesCadastro{
    @Override
    public void validar(Usuario usuario) {
        if(usuario.getNome() == null || usuario.getNome().trim().length() == 0){
            throw new BusinessException("O atributo nome não pode estar em branco");
        }
    }
}
