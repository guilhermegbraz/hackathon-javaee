package com.stefanini.Configuration.dataproviders;

import com.stefanini.Dataproviders.Jpa.entity.UsuarioEntity;
import com.stefanini.Dataproviders.dao.GenericDAO;

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
}
