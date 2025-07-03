package com.weg.informativos.security;

import com.weg.informativos.modulos.usuario.aplicacao.repositorio.UsuarioRepositorio;
import com.weg.informativos.modulos.usuario.dominio.UsuarioEntidade;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.UUID;

public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepositorio usuarioRepositorio;

    public UserDetailsServiceImpl(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsuarioEntidade userFound = usuarioRepositorio.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("O usuário não foi encontrado"));
        return new UserDetailsImpl(userFound);
    }
}
