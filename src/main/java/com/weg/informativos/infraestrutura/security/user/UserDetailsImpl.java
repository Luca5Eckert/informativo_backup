package com.weg.informativos.infraestrutura.security.user;

import com.weg.informativos.modulos.usuario.dominio.UsuarioEntidade;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {

    private final UsuarioEntidade usuario;

    public UserDetailsImpl(UsuarioEntidade usuario) {
        this.usuario = usuario;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(usuario.getTipoUsuario());
    }

    @Override
    public String getPassword() {
        return usuario.getSenha();
    }

    @Override
    public String getUsername() {
        return usuario.getNome();
    }

    public String getEmail() {
        return usuario.getEmail();
    }

}
