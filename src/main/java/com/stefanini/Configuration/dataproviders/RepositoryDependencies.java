package com.stefanini.Configuration.dataproviders;

import com.stefanini.Dataproviders.Jpa.entity.UsuarioEntity;
import com.stefanini.Dataproviders.Jpa.repository.UsuarioJpaRepository;
import com.stefanini.Dataproviders.dao.GenericDAO;
import com.stefanini.Dataproviders.mapper.UsuarioEntityToUsuario;
import com.stefanini.Dataproviders.mapper.UsuarioToUsuarioEntity;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Produces;

@ApplicationScoped
public class RepositoryDependencies {

    class  UsuarioEntityDao extends GenericDAO<UsuarioEntity, Long>{}

    @Produces
    @ApplicationScoped
    public GenericDAO<UsuarioEntity, Long> UsuarioEntityDao() {
        return new UsuarioEntityDao();
    }

    @Produces
    @ApplicationScoped
    public UsuarioEntityToUsuario usuarioEntityToUsuario() {
        return new UsuarioEntityToUsuario();
    }

    @Produces
    @ApplicationScoped
    public UsuarioToUsuarioEntity usuarioToUsuarioEntity() {
        return new UsuarioToUsuarioEntity();
    }

}
