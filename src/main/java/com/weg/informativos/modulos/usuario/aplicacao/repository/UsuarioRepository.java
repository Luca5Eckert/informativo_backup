package com.weg.informativos.modulos.usuario.aplicacao.repository;

import com.weg.informativos.modulos.usuario.dominio.UsuarioEntidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioEntidade, UUID> {

    public Optional<UsuarioEntidade> findByEmail(String email);

}
