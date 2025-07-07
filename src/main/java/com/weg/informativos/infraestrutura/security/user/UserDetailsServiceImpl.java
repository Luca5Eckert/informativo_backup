package com.weg.informativos.infraestrutura.security.user;

import com.weg.informativos.modulos.usuario.aplicacao.repository.UsuarioRepository;
import com.weg.informativos.modulos.usuario.dominio.UsuarioEntidade;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsServiceImpl implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    public UserDetailsServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public UserDetailsImpl loadUserByUsername(String email) throws UsernameNotFoundException {
        UsuarioEntidade userFound = usuarioRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("O usuário não foi encontrado"));
        return new UserDetailsImpl(userFound);
    }
}
