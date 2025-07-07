package com.weg.informativos.modulos.turma.aplicacao.repository;

import com.weg.informativos.modulos.turma.dominio.TurmaEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TurmaRepository extends JpaRepository<TurmaEntidade, UUID> {
}
