package com.weg.informativos.modulos.turma.dominio;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;

@Entity
@Table(name = "turma_tb")
public class TurmaEntidade {

    @Id
    private final UUID id;

    public TurmaEntidade(UUID id) {
        this.id = id;
    }
}
