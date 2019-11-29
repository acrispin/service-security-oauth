package com.unicon.security.servicesecurityoauth.models.service;

import com.unicon.security.servicesecurityoauth.models.entity.Usuario;

public interface IUsuarioService {
    public Usuario findByUsername(String username);

    public Usuario update(Usuario usuario, Long id);
}
