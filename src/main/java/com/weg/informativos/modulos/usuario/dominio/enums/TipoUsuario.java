package com.weg.informativos.modulos.usuario.dominio.enums;

import org.springframework.security.core.GrantedAuthority;

public enum TipoUsuario implements GrantedAuthority {
    ADMINISTRADOR("ROLE_ADM"),
    NORMAL("ROLE_NORMAL");

    String grantedAuthority;

    TipoUsuario(String grantedAuthority){
        this.grantedAuthority = grantedAuthority;
    }

    @Override
    public String getAuthority() {
        return grantedAuthority;
    }
}
