package gal.san.clemente.tarefa3_acceso_datos.view.converter;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.Cliente;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.IClienteDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

 public class ClienteTableModel extends AbstractTableModel {
     
    private IClienteDAO clienteDAO;
    
    private List<Cliente> clientesDatos = new ArrayList<>();
     
    public ClienteTableModel(IClienteDAO clienteDAO) {
         this.clienteDAO = clienteDAO;
    }
    
    public void updateModelCliente() throws ModelException {
        clientesDatos = clienteDAO.obtenerTodos();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID";
            case 1: return "NOME";
            case 2: return "APELIDOS";
            case 3: return "EMAIL";
            default: return "[NO]"; 
        }
    }

    @Override
    public int getRowCount() {
        return clientesDatos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cliente cliente = clientesDatos.get(rowIndex);
        switch (columnIndex) {
            case 0: return cliente.getId();
            case 1: return cliente.getNome();
            case 2: return cliente.getApelidos();
            case 3: return cliente.getEmail();
            default: return "";
        }
    }
    
}
