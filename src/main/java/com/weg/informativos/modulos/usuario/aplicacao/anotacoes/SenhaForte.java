package com.weg.informativos.modulos.usuario.aplicacao.anotacoes;

import com.weg.informativos.modulos.usuario.aplicacao.validadores.SenhaForteValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = SenhaForteValidator.class )
@Target({ ElementType.FIELD, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
public @interface SenhaForte {

    String mensagem() default "Senha não é forte o suficiente";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
