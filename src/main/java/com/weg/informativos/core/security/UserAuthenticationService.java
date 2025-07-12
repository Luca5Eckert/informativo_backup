package com.weg.informativos.core.security;

import com.weg.informativos.infraestrutura.security.user.UserDetailsImpl;
import com.weg.informativos.modulos.usuario.dominio.UsuarioEntidade;
import org.springframework.security.core.context.SecurityContextHolder;

//lida com acesso a autenticacao do usuario no sistemas
public class UserAuthenticationService {

    /*método """Certo"
    public static UserDetailsImpl getUser(){
        return (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getDetails();
    }
     */

    public static UserDetailsImpl getUser(){
        return new UserDetailsImpl(new UsuarioEntidade());
    }

}
