package com.stefanini.Configuration.core;

import com.stefanini.Core.usecase.usuario.atualizarUsuario.AtualizarUmUsuario;
import com.stefanini.Core.usecase.usuario.cadastro.CadastroUsuario;
import com.stefanini.Core.usecase.usuario.cadastro.CriptografarSenha;
import com.stefanini.Core.usecase.usuario.cadastro.validacoes.*;
import com.stefanini.Core.usecase.usuario.deletarUmUsuario.DeletarUmUsuario;
import com.stefanini.Core.usecase.usuario.detalharUmUsuario.DetalharUmUsuario;
import com.stefanini.Core.usecase.usuario.listarProvedores.ListarProvedores;
import com.stefanini.Core.usecase.usuario.listarTodosUsuarios.ListarTodosUsuarios;
import com.stefanini.Core.usecase.usuario.mappers.UsuarioToExibirUsuarioDto;
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

    @Produces
    @ApplicationScoped
    public ListarTodosUsuarios listarTodosUsuarios(UsuarioJpaRepository usuarioJpaRepository) {
        return new ListarTodosUsuarios(usuarioJpaRepository, new UsuarioToExibirUsuarioDto());
    }

    @Produces
    @ApplicationScoped
    public DetalharUmUsuario DetalharUmUsuario(UsuarioJpaRepository usuarioJpaRepository) {
        return new DetalharUmUsuario(usuarioJpaRepository, new UsuarioToExibirUsuarioDto());
    }

    @Produces
    @ApplicationScoped
    public DeletarUmUsuario deletarUmUsuario(UsuarioJpaRepository usuarioJpaRepository) {
        return new DeletarUmUsuario(usuarioJpaRepository);
    }

    @Produces
    @ApplicationScoped
    public AtualizarUmUsuario atualizarUmUsuario(List<ValidacoesCadastro> validacoesCadastros,
                                              UsuarioJpaRepository usuarioJpaRepository) {
        return new AtualizarUmUsuario(usuarioJpaRepository, validacoesCadastros,
                new CriptografarSenha(), new UsuarioToExibirUsuarioDto());
    }

    @Produces
    @ApplicationScoped
    public ListarProvedores listarProvedores(UsuarioJpaRepository usuarioJpaRepository) {
        return new ListarProvedores(usuarioJpaRepository);
    }
}
