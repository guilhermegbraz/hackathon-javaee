package com.stefanini.Dataproviders.mapper;

import com.stefanini.Core.entities.Usuario;
import com.stefanini.Dataproviders.Jpa.entity.UsuarioEntity;

public class UsuarioToUsuarioEntity {
    public UsuarioEntity execute(Usuario usuario) {
        UsuarioEntity usuarioEntity = new UsuarioEntity(usuario.getNome(), usuario.getLogin(),
                usuario.getEmail(), usuario.getSenha(), usuario.getDataDeNascimento());
        if(usuario.getId() != null) usuarioEntity.setId(usuario.getId());
        return usuarioEntity;
    }
}
