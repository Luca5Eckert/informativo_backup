package com.weg.informativos.modulos.usuario.aplicacao.validadores;

import com.weg.informativos.modulos.usuario.aplicacao.anotacoes.SenhaForte;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

import java.util.regex.Pattern;

@Component
public class SenhaForteValidator implements ConstraintValidator<SenhaForte, String> {

    private final Pattern NUMERO = Pattern.compile("(?=.*\\d)");
    private final Pattern LETRA_MINUSCULA = Pattern.compile("(?=.*[a-z])");
    private final Pattern LETRA_MAIUSCULA = Pattern.compile("(?=.*[A-Z])");
    private final Pattern CARACTER_ESPECIAL = Pattern.compile("(?=.*[$*&@#])");


    @Override
    public boolean isValid(String senha, ConstraintValidatorContext context) {
        if(senha.isBlank()){
            return false;
        }

        context.disableDefaultConstraintViolation();

        boolean isValid = true;


        if (senha.length() < 8) {
            context.buildConstraintViolationWithTemplate("Senha precisa ter no mínimo 8 caracteres").addConstraintViolation();
            return false;
        }

        if(!NUMERO.matcher(senha).matches()){
            context.buildConstraintViolationWithTemplate("Senha precisa ter no mínimo um número").addConstraintViolation();
            isValid = false;
        }

        if(!LETRA_MINUSCULA.matcher(senha).matches()){
            context.buildConstraintViolationWithTemplate("Senha precisa ter no mínimo uma letra minuscula").addConstraintViolation();
            isValid = false;
        }

        if(!LETRA_MAIUSCULA.matcher(senha).matches()){
            context.buildConstraintViolationWithTemplate("Senha precisa ter no mínimo uma letra maiuscula").addConstraintViolation();
            isValid = false;
        }

        if(!CARACTER_ESPECIAL.matcher(senha).matches()){
            context.buildConstraintViolationWithTemplate("Senha precisa ter no mínimo um caracter especial").addConstraintViolation();
            isValid = false;
        }

        return isValid;

    }
}
