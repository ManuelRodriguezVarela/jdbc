package gal.san.clemente.tarefa3_acceso_datos.model;

import java.io.Serializable;
import java.util.Objects;

public class Tenda implements Serializable {

    private Long id;
    private String nome;
    private String cidade;
    private String provincia;

    public Tenda() {
    }

    public Tenda(String nome, String cidade, String provincia) {
        this.nome = nome;
        this.cidade = cidade;
        this.provincia = provincia;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Tenda other = (Tenda) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Tienda{" + "id=" + id + ", nome=" + nome + ", cidade=" + cidade + ", provincia=" + provincia + '}';
    }
    
}
