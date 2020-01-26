package gal.san.clemente.tarefa3_acceso_datos.model;

import java.io.Serializable;
import java.util.Objects;

public class TendaEmpleado implements Serializable {

    private Long id;
    private Long idTenda;
    private Long idEmpleado;
    private Integer numeroHorasSemana;

    public TendaEmpleado() {
    }

    public TendaEmpleado(Long idTenda, Long idEmpleado, Integer numeroHorasSemana) {
        this.idTenda = idTenda;
        this.idEmpleado = idEmpleado;
        this.numeroHorasSemana = numeroHorasSemana;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdTenda() {
        return idTenda;
    }

    public void setIdTenda(Long idTenda) {
        this.idTenda = idTenda;
    }

    public Long getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(Long idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public Integer getNumeroHorasSemana() {
        return numeroHorasSemana;
    }

    public void setNumeroHorasSemana(Integer numeroHorasSemana) {
        this.numeroHorasSemana = numeroHorasSemana;
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
        final TendaEmpleado other = (TendaEmpleado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TendaEmpregado{" + "id=" + id + ", idTenda=" + idTenda + ", idEmpleado=" + idEmpleado + ", numeroHorasSemana=" + numeroHorasSemana + '}';
    }
    
}
