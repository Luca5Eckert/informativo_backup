package com.weg.informativos.modulos.tag.dominio;

import com.weg.informativos.modulos.tag.dominio.enums.TipoTag;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "tag_tb")
public class TagEntidade {

    @EmbeddedId
    private TagId tagId;

    public TagEntidade() {
    }

    public TagEntidade(TagId tagId) {
        this.tagId = tagId;
    }

    public TagEntidade(TipoTag tipo, String valor) {
        this.tagId = new TagId(tipo, valor);
    }

    public TagId getTagId() {
        return tagId;
    }

    public void setTagId(TagId tagId) {
        this.tagId = tagId;
    }

    public TipoTag getTipoTag() {
        return this.tagId != null ? this.tagId.getTipo() : null;
    }

    public String getValor() {
        return this.tagId != null ? this.tagId.getValor() : null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagEntidade that = (TagEntidade) o;
        return Objects.equals(tagId, that.tagId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tagId);
    }
}