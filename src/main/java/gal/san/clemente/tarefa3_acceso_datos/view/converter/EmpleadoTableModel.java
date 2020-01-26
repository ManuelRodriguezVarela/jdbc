package gal.san.clemente.tarefa3_acceso_datos.view.converter;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.Empleado;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.IEmpleadoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

 public class EmpleadoTableModel extends AbstractTableModel {
     
    private IEmpleadoDAO empleadoDAO;
    
    private List<Empleado> empleadosDatos = new ArrayList<>();
     
    public EmpleadoTableModel(IEmpleadoDAO empleadoDAO) {
         this.empleadoDAO = empleadoDAO;
    }
    
    public void updateModelEmpleado() throws ModelException {
        empleadosDatos = empleadoDAO.obtenerTodos();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID";
            case 1: return "NOME";
            case 2: return "APELIDOS";
            default: return "[NO]"; 
        }
    }

    @Override
    public int getRowCount() {
        return empleadosDatos.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Empleado empleado = empleadosDatos.get(rowIndex);
        switch (columnIndex) {
            case 0: return empleado.getId();
            case 1: return empleado.getNome();
            case 2: return empleado.getApelidos();
            default: return "";
        }
    }
    
}
