package com.weg.informativos.modulos.tag.dominio;

import com.weg.informativos.modulos.tag.dominio.enums.TipoTag;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TagId implements Serializable {

    @Enumerated(EnumType.STRING)
    @Column(name = "tipo_tag", nullable = false)
    private TipoTag tipo;

    @Column(name = "valor_tag", nullable = false)
    private String valor;

    public TagId() {
    }

    public TagId(TipoTag tipo, String valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public TipoTag getTipo() {
        return tipo;
    }

    public void setTipo(TipoTag tipo) {
        this.tipo = tipo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagId tagId = (TagId) o;
        return tipo == tagId.tipo && Objects.equals(valor, tagId.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, valor);
    }
}