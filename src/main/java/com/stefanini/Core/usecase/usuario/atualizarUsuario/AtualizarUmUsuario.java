package com.stefanini.Core.usecase.usuario.atualizarUsuario;

import com.stefanini.Core.entities.Usuario;
import com.stefanini.Core.exceptions.BusinessException;
import com.stefanini.Core.repositories.UsuarioRepository;
import com.stefanini.Core.usecase.usuario.cadastro.CriptografarSenha;
import com.stefanini.Core.usecase.usuario.cadastro.validacoes.ValidacoesCadastro;
import com.stefanini.Core.usecase.usuario.mappers.UsuarioToExibirUsuarioDto;
import com.stefanini.Core.usecase.usuario.view.ExibirUsuarioDto;

import java.util.List;

public class AtualizarUmUsuario {

    private final UsuarioRepository usuarioRepository;
    private final List<ValidacoesCadastro> validacoesCadastros;
    private final CriptografarSenha criptografarSenha;
    private final UsuarioToExibirUsuarioDto usuarioToExibirUsuarioDto;

    public AtualizarUmUsuario(UsuarioRepository usuarioRepository, List<ValidacoesCadastro> validacoesCadastros, CriptografarSenha criptografarSenha, UsuarioToExibirUsuarioDto usuarioToExibirUsuarioDto) {
        this.usuarioRepository = usuarioRepository;
        this.validacoesCadastros = validacoesCadastros;
        this.criptografarSenha = criptografarSenha;
        this.usuarioToExibirUsuarioDto = usuarioToExibirUsuarioDto;
    }

    public ExibirUsuarioDto execute(Usuario possivelUsuarioAtualizado) {

        Usuario usuarioAtualizavel = this.usuarioRepository.recuperPorId(possivelUsuarioAtualizado.getId());
        if(usuarioAtualizavel == null) throw new BusinessException("Usuario não encontrado");

        if(possivelUsuarioAtualizado.getNome() != null) usuarioAtualizavel.setNome(possivelUsuarioAtualizado.getNome());
        if(possivelUsuarioAtualizado.getLogin() != null) usuarioAtualizavel.setLogin(possivelUsuarioAtualizado.getLogin());
        if(possivelUsuarioAtualizado.getEmail() != null) usuarioAtualizavel.setEmail(possivelUsuarioAtualizado.getEmail());
        if(possivelUsuarioAtualizado.getSenha() != null) usuarioAtualizavel.setSenha(possivelUsuarioAtualizado.getSenha());
        if(possivelUsuarioAtualizado.getDataDeNascimento() != null)
            usuarioAtualizavel.setDataDeNascimento(possivelUsuarioAtualizado.getDataDeNascimento());

        this.validacoesCadastros.forEach(validacao -> validacao.validar(usuarioAtualizavel));
        usuarioAtualizavel.setSenha(this.criptografarSenha.execute(usuarioAtualizavel.getSenha()));


        return this.usuarioToExibirUsuarioDto.execute(this.usuarioRepository.atualizar(usuarioAtualizavel));
    }
}
