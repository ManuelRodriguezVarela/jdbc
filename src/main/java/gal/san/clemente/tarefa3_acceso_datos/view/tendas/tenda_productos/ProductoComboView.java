package gal.san.clemente.tarefa3_acceso_datos.view.tendas.tenda_productos;

import gal.san.clemente.tarefa3_acceso_datos.model.Producto;
import java.util.Objects;

public class ProductoComboView {
    //Patrón adapter. Se crea un campo tipo profesor getter y setter y en equal y en el toString lo que queremos
    private Producto producto;

    public ProductoComboView(Producto producto) {
        this.producto = producto;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.producto);
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
        final ProductoComboView other = (ProductoComboView) obj;
        if (!Objects.equals(this.producto, other.producto)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return producto.getId() + " - " + producto.getNome();
    }
    
}
