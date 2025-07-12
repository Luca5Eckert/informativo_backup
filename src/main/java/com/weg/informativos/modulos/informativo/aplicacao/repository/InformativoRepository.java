package com.weg.informativos.modulos.informativo.aplicacao.repository;

import com.weg.informativos.modulos.informativo.dominio.InformativoEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InformativoRepository extends JpaRepository<InformativoEntidade, UUID> {
}
