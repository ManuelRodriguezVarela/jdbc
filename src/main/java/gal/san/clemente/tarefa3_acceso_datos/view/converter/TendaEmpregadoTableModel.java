package gal.san.clemente.tarefa3_acceso_datos.view.converter;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.Tenda;
import gal.san.clemente.tarefa3_acceso_datos.model.TendaEmpleado;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.ITendaEmpleadoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

 public class TendaEmpregadoTableModel extends AbstractTableModel {
     
    private ITendaEmpleadoDAO tendaEmpleadoDAO;
    
    private Tenda tenda;
    
    private List<TendaEmpleado> tendasEmpleadosDatos = new ArrayList<>();
     
    public TendaEmpregadoTableModel(ITendaEmpleadoDAO tendaEmpleadoDAO, Tenda tenda) {
         this.tendaEmpleadoDAO = tendaEmpleadoDAO;
         this.tenda = tenda;
    }
    
    public void updateModelTenda() throws ModelException {
        tendasEmpleadosDatos = tendaEmpleadoDAO.obtenerTodos(tenda.getId());
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID";
            case 1: return "TENDA";
            case 2: return "EMPREGADO";
            case 3: return "NÚMERO DE HORAS SEMANA";
            default: return "[NO]"; 
        }
    }

    @Override
    public int getRowCount() {
        return tendasEmpleadosDatos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        TendaEmpleado tendaEmpleado = tendasEmpleadosDatos.get(rowIndex);
        switch (columnIndex) {
            case 0: return tendaEmpleado.getId();
            case 1: return tendaEmpleado.getIdTenda();
            case 2: return tendaEmpleado.getIdEmpleado();
            case 3: return tendaEmpleado.getNumeroHorasSemana();
            default: return "";
        }
    }
    
}
