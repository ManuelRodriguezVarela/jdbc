package gal.san.clemente.tarefa3_acceso_datos.view.tendas.tenda_empregados;

import gal.san.clemente.tarefa3_acceso_datos.model.Empleado;
import java.util.Objects;

public class EmpleadoComboView {
    //Patrón adapter. Se crea un campo tipo profesor getter y setter y en equal y en el toString lo que queremos
    private Empleado empleado;

    public EmpleadoComboView(Empleado empleado) {
        this.empleado = empleado;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + Objects.hashCode(this.empleado);
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
        final EmpleadoComboView other = (EmpleadoComboView) obj;
        if (!Objects.equals(this.empleado, other.empleado)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return empleado.getId() + " - " + empleado.getNome();
    }
    
}
