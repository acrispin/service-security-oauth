package com.unicon.security.api.oauth.models.service;

import com.unicon.security.api.oauth.models.entity.Usuario;

public interface IUsuarioService {
    public Usuario findByUsername(String username);

    public Usuario update(Usuario usuario, Long id);
}
