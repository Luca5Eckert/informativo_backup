package com.weg.informativos.modulos.usuario.aplicacao.validadores;

import javax.xml.validation.ValidatorHandler;

import com.weg.informativos.modulos.usuario.aplicacao.anotacoes.EmailSenai;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class EmailSenaiValidador implements ConstraintValidator<EmailSenai, String> {

    private static String emailSenai = "@estudante.sesisenai.org.br";

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.contains(emailSenai);
    }
}
