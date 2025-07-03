package com.weg.informativos.modulos.usuario.aplicacao.dtos;

public record UsuarioCadastroDto(String nome, String email, String senha, String senhaConfirmacao) {

    public boolean eMesmoEmail(){
        return senha.equals(senhaConfirmacao);
    }


}

