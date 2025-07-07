package com.weg.informativos.modulos.usuario.dominio.validadores;

import com.weg.informativos.modulos.usuario.dominio.anotacoes.EmailSenai;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailSenaiValidador implements ConstraintValidator<EmailSenai, String> {

    private static String emailSenai = "@estudante.sesisenai.org.br";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.contains(emailSenai);
    }
}
