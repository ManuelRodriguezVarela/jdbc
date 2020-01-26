package gal.san.clemente.tarefa3_acceso_datos.model;

import java.io.Serializable;
import java.util.Objects;

public class TendaProducto implements Serializable {

    private Long id;
    private Long idTenda;
    private Long idProducto;
    private Integer stock;

    public TendaProducto() {
    }

    public TendaProducto(Long idTenda, Long idProducto, Integer stock) {
        this.idTenda = idTenda;
        this.idProducto = idProducto;
        this.stock = stock;
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

    public Long getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final TendaProducto other = (TendaProducto) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TendaProducto{" + "id=" + id + ", idTenda=" + idTenda + ", idProducto=" + idProducto + ", stock=" + stock + '}';
    }
    
}
