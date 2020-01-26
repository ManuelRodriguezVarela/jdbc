package gal.san.clemente.tarefa3_acceso_datos.view.converter;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.Provincia;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.IProvinciaDAO;
import gal.san.clemente.tarefa3_acceso_datos.view.tendas.ProvinciaComboView;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;

 public class ProvinciasComboModel extends DefaultComboBoxModel<ProvinciaComboView> {
     
    private IProvinciaDAO provinciaDAO;
    
    private List<Provincia> provincias;

    public ProvinciasComboModel(IProvinciaDAO provinciaDAO) {
        this.provinciaDAO = provinciaDAO;
        this.provincias = new ArrayList<>();
    }
    
    public void update() throws ModelException {
        if(provinciaDAO != null) {
            provincias = provinciaDAO.obtenerTodos();
            removeAllElements();
            for(Provincia provincia: provincias) {
                addElement(new ProvinciaComboView(provincia));
            } 
            
        }       
    }
     
    
}
