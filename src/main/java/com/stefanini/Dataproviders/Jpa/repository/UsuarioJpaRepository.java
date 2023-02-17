package com.stefanini.Dataproviders.Jpa.repository;

import com.stefanini.Core.entities.Usuario;
import com.stefanini.Core.repositories.UsuarioRepository;
import com.stefanini.Dataproviders.Jpa.entity.UsuarioEntity;
import com.stefanini.Dataproviders.dao.GenericDAO;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class UsuarioJpaRepository implements UsuarioRepository {

    @Inject
    private  GenericDAO<UsuarioEntity, Long> userDAO;

    public UsuarioJpaRepository(GenericDAO<UsuarioEntity, Long> userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public List<Usuario> listarAniversariantesDoMes(String mes) {
        return null;
    }

    @Override
    public Set<String> listarProvedoresEmailUsuarios() {
        return null;
    }

    @Override
    public List<Usuario> listarUsuariosComInicial(String primeiraLetra) {
        return null;
    }

    @Override
    public Long cadastrarUsuario(Usuario usuario) {
        return null;
    }

    @Override
    public List<Usuario> listarTodos() {
        return null;
    }

    @Override
    public Usuario recuperPorId(Long id) {
        return null;
    }

    @Override
    public void atualizar(Usuario usuarioAtualizado) {

    }

    @Override
    public void deletar(Long id) {

    }
}
