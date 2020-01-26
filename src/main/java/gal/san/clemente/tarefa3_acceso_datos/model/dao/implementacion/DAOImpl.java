package gal.san.clemente.tarefa3_acceso_datos.model.dao.implementacion;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOImpl {
    
    protected void closeResultSet(ResultSet rs) throws ModelException {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                throw new ModelException("Error en SQL", ex);
            }
        }
    }
    
    protected void closePrepareStatement(PreparedStatement stmt) throws ModelException {
        if(stmt != null) {
            try {
                stmt.close();
            } catch (SQLException ex) {
                throw new ModelException("Error en SQL", ex);
            }
        } 
    }
}
