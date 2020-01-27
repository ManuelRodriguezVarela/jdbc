package gal.san.clemente.tarefa3_acceso_datos.view.converter;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.Producto;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.IProductoDAO;
import gal.san.clemente.tarefa3_acceso_datos.view.tendas.tenda_productos.ProductoComboView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

 public class ProductosComboModel extends DefaultComboBoxModel<ProductoComboView> {
     
    private IProductoDAO productoDAO;
    
    private List<Producto> productos;

    public ProductosComboModel(IProductoDAO productoDAO) {
        this.productoDAO = productoDAO;
        this.productos = new ArrayList<>();
    }
    
    public void update() throws ModelException {
        if(productoDAO != null) {
            productos = productoDAO.obtenerTodos();
            removeAllElements();
            for(Producto producto: productos) {
                addElement(new ProductoComboView(producto));
            } 
            
        }       
    }
     
    
}
