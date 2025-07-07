package com.weg.informativos.modulos.usuario.aplicacao.dtos;

import com.weg.informativos.modulos.usuario.aplicacao.anotacoes.SenhaForte;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioCadastroDto(@NotBlank(message = "Nome não pode ser ficar vazio")  String nome, @NotBlank(message = "Email não pode ser ficar vazio") String email, @NotBlank(message = "Senha não pode ficar em branco") @SenhaForte @Size(min = 8, message = "A senha deve ter no mínimo 8 caracteres") String senha, String senhaConfirmacao) {

    public boolean eMesmoSenha(){
        return senha.equals(senhaConfirmacao);
    }


}

