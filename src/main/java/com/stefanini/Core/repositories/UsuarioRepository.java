package com.stefanini.Core.repositories;

import com.stefanini.Core.entities.Usuario;

import java.util.List;
import java.util.Set;

public interface UsuarioRepository {
    List<Usuario> listarAniversariantesDoMes(String mes);
    Set<String>  listarProvedoresEmailUsuarios();
    List<Usuario> listarUsuariosComInicial(String primeiraLetra);

    Long cadastrarUsuario(Usuario usuario);
    List<Usuario> listarTodos();
    Usuario recuperPorId(Long id);
    Usuario atualizar(Usuario usuarioAtualizado);
    void deletar(Long id);
    boolean loginJaCadastrado(String email);

}
