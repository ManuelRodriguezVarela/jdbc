package gal.san.clemente.tarefa3_acceso_datos.model;

import java.io.Serializable;
import java.util.Objects;

public class Producto implements Serializable {

    private Long id;
    private String nome;
    private String descripcion;
    private Double prezo;

    public Producto() {
    }

    public Producto(String nome, String descripcion, Double prezo) {
        this.nome = nome;
        this.descripcion = descripcion;
        this.prezo = prezo;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrezo() {
        return prezo;
    }

    public void setPrezo(Double prezo) {
        this.prezo = prezo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final Producto other = (Producto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nome=" + nome + ", descripcion=" + descripcion + ", prezo=" + prezo + '}';
    }
    
}
