package com.stefanini.Configuration.core;

import com.stefanini.Core.usecase.usuario.cadastro.CadastroUsuario;
import com.stefanini.Core.usecase.usuario.cadastro.CriptografarSenha;
import com.stefanini.Core.usecase.usuario.cadastro.validacoes.*;
import com.stefanini.Dataproviders.Jpa.repository.UsuarioJpaRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;
import java.util.List;

public class UsuarioUsecaseConfig {

    @Produces
    @ApplicationScoped
    public List<ValidacoesCadastro> validacoesCadastros(UsuarioJpaRepository usuarioJpaRepository) {
        return List.of( new ValidadorNomeObrigatório(), new ValidadorTamanhoMaximoNome(),
                 new ValidadorLoginObrigatorio(), new ValidadorEmailObrigatorio(), new ValidadorSenhaObrigatoria(),
                new ValidadorLoginUnico(usuarioJpaRepository), new ValidadorTamanhoLogin(),
                new ValidadorTamanhoMinimoEmail(), new ValidadorEmailValido(), new ValidadorTamanhoSenha());
    }

    @Produces
    @ApplicationScoped
    public CadastroUsuario cadastroUsuario(List<ValidacoesCadastro> validacoesCadastros,
                                           UsuarioJpaRepository usuarioJpaRepository) {
        return new CadastroUsuario(usuarioJpaRepository, validacoesCadastros, new CriptografarSenha());
    }
}
