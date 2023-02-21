package com.stefanini.Dataproviders.Jpa.repository;

import com.stefanini.Core.entities.Usuario;
import com.stefanini.Core.repositories.UsuarioRepository;
import com.stefanini.Dataproviders.Jpa.entity.UsuarioEntity;
import com.stefanini.Dataproviders.dao.GenericDAO;
import com.stefanini.Dataproviders.mapper.UsuarioEntityToUsuario;
import com.stefanini.Dataproviders.mapper.UsuarioToUsuarioEntity;

import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@ApplicationScoped
public class UsuarioJpaRepository extends GenericDAO<UsuarioEntity, Long> implements UsuarioRepository {


    private final UsuarioEntityToUsuario usuarioEntityToUsuario;
    private final UsuarioToUsuarioEntity usuarioToUsuarioEntity;

    public UsuarioJpaRepository( UsuarioEntityToUsuario usuarioEntityToUsuario, UsuarioToUsuarioEntity usuarioEntity) {

        this.usuarioEntityToUsuario = usuarioEntityToUsuario;
        this.usuarioToUsuarioEntity = usuarioEntity;
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
        var usuarioEntity = this.usuarioToUsuarioEntity.execute(usuario);
        this.save(usuarioEntity);
        return usuarioEntity.getId();
    }

    @Override
    public List<Usuario> listarTodos() {
        List<UsuarioEntity> usuarioEntityList = this.listAll();

        return this.usuarioEntityToUsuario.execute(usuarioEntityList);
    }

    @Override
    public Usuario recuperPorId(Long id) {
        var usuario = this.findById(id);
        if (usuario == null) return null;
        return this.usuarioEntityToUsuario.execute(usuario);
    }

    @Override
    public Usuario atualizar(Usuario usuarioAtualizado) {
        return this.usuarioEntityToUsuario.execute(
                this.update(
                        this.usuarioToUsuarioEntity.execute(usuarioAtualizado)
                )
        );
    }

    @Override
    public void deletar(Long id) {
        this.delete(id);
    }

    @Override
    public boolean loginJaCadastrado(String email) {
        return false;
    }
}
