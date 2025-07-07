package com.weg.informativos.modulos.informativo.dominio;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table( name = "informativo_tb")
public class InformativoEntidade {

    @Id
    private final UUID id;

    public InformativoEntidade(UUID id) {
        this.id = id;
    }
}
