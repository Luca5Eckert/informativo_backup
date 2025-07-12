package com.weg.informativos.modulos.informativo.dominio;

import com.weg.informativos.modulos.tag.dominio.TagEntidade;
import com.weg.informativos.modulos.usuario.dominio.UsuarioEntidade;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "informativo_tb")
public class InformativoEntidade {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private final UUID id;

    private String titulo;
    private String conteudo;

    @ManyToOne
    @JoinColumn(name = "id")
    private UsuarioEntidade criadoPor;

    private int nivelImportancia;

    @CreationTimestamp
    private final LocalDateTime criadoEm;

    @UpdateTimestamp
    private LocalDateTime editadorEm;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "informativo_tag_tb",
            joinColumns = @JoinColumn(name = "informativo_id"), // Coluna que referencia InformativoEntidade
            inverseJoinColumns = { // Colunas que referenciam TagEntidade (chave composta)
                    @JoinColumn(name = "tag_tipo", referencedColumnName = "tipo_tag"), // Referencia o campo 'tipo' da TagId
                    @JoinColumn(name = "tag_valor", referencedColumnName = "valor_tag")  // Referencia o campo 'valor' da TagId
            }
    )
    private Set<TagEntidade> tags = new HashSet<>();

    public InformativoEntidade() {
        this.criadoEm = null;
        this.id = null;
    }

    public InformativoEntidade(String titulo, String conteudo, int nivelImportancia, Set<TagEntidade> tags, UsuarioEntidade criadoPor ) {
        this.id = null;
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.nivelImportancia = nivelImportancia;
        this.tags = tags;
        this.criadoPor = criadoPor;
        this.criadoEm = null;
    }

    public UUID getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public int getNivelImportancia() {
        return nivelImportancia;
    }

    public void setNivelImportancia(int nivelImportancia) {
        this.nivelImportancia = nivelImportancia;
    }

    public Set<TagEntidade> getTags() {
        return tags;
    }

    public void setTags(Set<TagEntidade> tags) {
        this.tags = tags;
    }

    public void addTag(TagEntidade tag) {
        this.tags.add(tag);
    }

    public void removeTag(TagEntidade tag) {
        this.tags.remove(tag);
    }
}