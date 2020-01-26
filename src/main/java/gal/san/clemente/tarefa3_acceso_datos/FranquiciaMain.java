package gal.san.clemente.tarefa3_acceso_datos;

import gal.san.clemente.tarefa3_acceso_datos.model.dao.IDAOManager;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.implementacion.DAOManagerBBDDImpl;
import gal.san.clemente.tarefa3_acceso_datos.view.Inicio;
import gal.san.clemente.tarefa3_acceso_datos.view.MainMenu;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FranquiciaMain {
    
    public static void main(String[] args) {
        Inicio inicio = new Inicio();
        inicio.setLocationRelativeTo(null);
        inicio.setVisible(true);
        try {
            IDAOManager manager = new DAOManagerBBDDImpl();
            MainMenu menu = new MainMenu(manager);
            menu.setLocationRelativeTo(null);
            menu.setVisible(true);
        } catch (SQLException ex) {
            Logger.getLogger(FranquiciaMain.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
