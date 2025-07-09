package com.weg.informativos.modulos.usuario.dominio.cases;

import com.weg.informativos.core.cases.UseCase;
import com.weg.informativos.core.dtos.TokenDto;
import com.weg.informativos.infraestrutura.providers.JwtTokenProvider;
import com.weg.informativos.modulos.usuario.aplicacao.dtos.UsuarioLoginDto;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class UsuarioLoginCase implements UseCase<UsuarioLoginDto, TokenDto> {

    private final JwtTokenProvider jwtTokenProvider;
    private final AuthenticationManager authenticationManager;

    public UsuarioLoginCase(JwtTokenProvider jwtTokenProvider, AuthenticationManager authenticationManager) {
        this.jwtTokenProvider = jwtTokenProvider;
        this.authenticationManager = authenticationManager;
    }

    @Override
    public TokenDto executar(UsuarioLoginDto usuarioLoginDto){
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(usuarioLoginDto.email(), usuarioLoginDto.senha()));
        String token = jwtTokenProvider.generateToken(usuarioLoginDto.email());

        return new TokenDto(token);
    }

}
