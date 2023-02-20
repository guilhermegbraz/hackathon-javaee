package com.stefanini.Core.usecase.usuario.cadastro.validacoes;

import com.stefanini.Core.entities.Usuario;
import com.stefanini.Core.exceptions.BusinessException;

import java.util.regex.Pattern;

public class ValidadorEmailValido implements ValidacoesCadastro{

    private  String regex;
    private  Pattern pattern ;
    public ValidadorEmailValido() {
        this.regex = "^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,}$";
        this.pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
    }

    @Override
    public void validar(Usuario usuario) {
       if (!pattern.matcher(usuario.getEmail()).matches()) throw new BusinessException("Email invalido");
    }
}
