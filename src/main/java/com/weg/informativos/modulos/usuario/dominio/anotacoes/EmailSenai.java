package com.weg.informativos.modulos.usuario.dominio.anotacoes;

import com.weg.informativos.modulos.usuario.dominio.validadores.EmailSenaiValidador;
import jakarta.validation.Constraint;
import org.springframework.validation.annotation.Validated;

@Constraint(validatedBy = EmailSenaiValidador.class)
public @interface EmailSenai {


}
