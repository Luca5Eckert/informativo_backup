package com.weg.informativos.modulos.usuario.dominio;

import com.weg.informativos.modulos.usuario.dominio.enums.TipoUsuario;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "usuario_tb")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = true)
public class UsuarioEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private final UUID id;

    private String nome;
    private String email;
    private String senha;
    private TipoUsuario tipoUsuario;

    @CreationTimestamp
    private final LocalDateTime criadoEm;

    @UpdateTimestamp
    private LocalDateTime atualizadoEm;



}
