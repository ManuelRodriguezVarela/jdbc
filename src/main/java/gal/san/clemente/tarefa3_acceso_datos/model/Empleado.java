package gal.san.clemente.tarefa3_acceso_datos.model;

import java.io.Serializable;
import java.util.Objects;

public class Empleado implements Serializable {

    private Long id;
    private String nome;
    private String apelidos;

    public Empleado() {
    }

    public Empleado(String nome, String apelidos) {
        this.nome = nome;
        this.apelidos = apelidos;
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

    public String getApelidos() {
        return apelidos;
    }

    public void setApelidos(String apelidos) {
        this.apelidos = apelidos;
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
        final Empleado other = (Empleado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nome=" + nome + ", apelidos=" + apelidos + '}';
    }
    
}
