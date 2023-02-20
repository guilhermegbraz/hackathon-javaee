package com.stefanini.Core.usecase.usuario.cadastro;

import com.stefanini.Core.entities.Usuario;
import com.stefanini.Core.exceptions.BusinessException;
import com.stefanini.Core.repositories.UsuarioRepository;
import com.stefanini.Core.usecase.usuario.cadastro.validacoes.ValidacoesCadastro;

import java.util.List;


public class CadastroUsuario {
    private final UsuarioRepository usuarioRepository;
    private final List<ValidacoesCadastro> validacoes;
    private final CriptografarSenha criptografarSenha;

    public CadastroUsuario(UsuarioRepository usuarioRepository, List<ValidacoesCadastro> validacoes, CriptografarSenha criptografarSenha) {
        this.usuarioRepository = usuarioRepository;
        this.validacoes = validacoes;
        this.criptografarSenha = criptografarSenha;
    }

    public String execute(Usuario usuario) {
        try {
            this.validacoes.forEach(validacao -> validacao.validar(usuario));
            usuario.setSenha(this.criptografarSenha.execute(usuario.getSenha()));
            var id = this.usuarioRepository.cadastrarUsuario(usuario);
            return String.valueOf(id);
        } catch (BusinessException exception) {
            throw exception;
        }
    }
}
