package br.com.model;

import java.util.Objects;

public class ListaTelefonica {

    private String telefone;

    public ListaTelefonica(String telefone) {
            this.telefone = telefone;
    }

    public String getNumero() {
        return telefone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListaTelefonica that)) return false;
        return Objects.equals(telefone, that.telefone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(telefone);
    }

    @Override
    public String toString() {
        return telefone;
    }
}
