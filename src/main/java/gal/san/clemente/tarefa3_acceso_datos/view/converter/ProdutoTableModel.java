package gal.san.clemente.tarefa3_acceso_datos.view.converter;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.Producto;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.IProductoDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

 public class ProdutoTableModel extends AbstractTableModel {
     
    private IProductoDAO productoDAO;
    
    private List<Producto> productosDatos = new ArrayList<>();
     
    public ProdutoTableModel(IProductoDAO productoDAO) {
         this.productoDAO = productoDAO;
    }
    
    public void updateModelProducto() throws ModelException {
        productosDatos = productoDAO.obtenerTodos();
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0: return "ID";
            case 1: return "NOME";
            case 2: return "DESCRICIÓN";
            case 3: return "PREZO";
            default: return "[NO]"; 
        }
    }

    @Override
    public int getRowCount() {
        return productosDatos.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto producto = productosDatos.get(rowIndex);
        switch (columnIndex) {
            case 0: return producto.getId();
            case 1: return producto.getNome();
            case 2: return producto.getDescripcion();
            case 3: return producto.getPrezo();
            default: return "";
        }
    }
    
}
