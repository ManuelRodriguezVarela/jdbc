package gal.san.clemente.tarefa3_acceso_datos.view.converter;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.Tenda;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.ITendaDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

 public class TendaTableModel extends AbstractTableModel {
     
    private ITendaDAO tendaDAO;
    
    private List<Tenda> tendasDatos = new ArrayList<>();
     
    public TendaTableModel(ITendaDAO tendaDAO) {
         this.tendaDAO = tendaDAO;
    }
    
    public void updateModelTenda() throws ModelException {
        tendasDatos = tendaDAO.obtenerTodos();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID";
            case 1: return "NOME";
            case 2: return "PROVINCIA";
            case 3: return "CIDADE";
            default: return "[NO]"; 
        }
    }

    @Override
    public int getRowCount() {
        return tendasDatos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Tenda tenda = tendasDatos.get(rowIndex);
        switch (columnIndex) {
            case 0: return tenda.getId();
            case 1: return tenda.getNome();
            case 2: return tenda.getProvincia();
            case 3: return tenda.getCidade();
            default: return "";
        }
    }
    
}
