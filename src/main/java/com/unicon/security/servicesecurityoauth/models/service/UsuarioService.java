package com.unicon.security.servicesecurityoauth.models.service;

import com.unicon.security.servicesecurityoauth.models.dao.UsuarioDao;
import com.unicon.security.servicesecurityoauth.models.entity.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService implements IUsuarioService, UserDetailsService {

    private Logger log = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    private UsuarioDao client;

    @Override
    public Usuario findByUsername(String username) {
        return client.findByUsername(username);
    }

    @Override
    public Usuario update(Usuario usuario, Long id) {
        usuario.setId(id);
        return client.save(usuario);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Usuario usuario = client.findByUsername(username);

            List<GrantedAuthority> authorities = usuario.getRoles().stream()
                    .map(role -> new SimpleGrantedAuthority(role.getNombre()))
                    .peek(authority -> log.info("Role: " + authority.getAuthority())).collect(Collectors.toList());

            log.info("Usuario autenticado: " + username);
            log.info("Usuario password: " + usuario.getPassword());

            return new User(usuario.getUsername(), usuario.getPassword(), usuario.getEnabled(), true, true, true,
                    authorities);

        } catch (Exception e) {
            String error = "Error en el login, no existe el usuario '" + username + "' en el sistema";
            log.error(error, e);

            throw new UsernameNotFoundException(error);
        }
    }
}
