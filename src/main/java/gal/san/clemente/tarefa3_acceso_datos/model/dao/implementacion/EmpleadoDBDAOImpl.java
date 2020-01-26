package gal.san.clemente.tarefa3_acceso_datos.model.dao.implementacion;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.Empleado;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.IEmpleadoDAO;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.utils.ModelError;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.utils.ModelQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.converter.IConverter;

public class EmpleadoDBDAOImpl extends DAOImpl implements IEmpleadoDAO {
    
    private IConverter converterEmpleado;
    private Connection conexion;
    
    public EmpleadoDBDAOImpl(Connection conexion, IConverter converter) {
        this.conexion = conexion;
        this.converterEmpleado = converter;
    }

    @Override
    public void insertar(Empleado entidad) throws ModelException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conexion.prepareStatement(ModelQuery.INSERT_EMPLEADO);
            setStmt(stmt, entidad);
            if (stmt.executeUpdate() == 0) {
                throw new ModelException(ModelError.ERROR_INSERT_EMPLEADO);
            }
            rs = stmt.getGeneratedKeys();
            if(rs.next()) {
                entidad.setId(rs.getLong(1));
            }
        } catch (SQLException ex) {
            throw new ModelException(ModelError.ERROR_INSERT_EMPLEADO, ex);
        } finally {
            closePrepareStatement(stmt);
            closeResultSet(rs);
        }
    }

    @Override
    public void modificar(Empleado entidad) throws ModelException {
        PreparedStatement stmt = null;
        try {
            stmt = conexion.prepareStatement(ModelQuery.UPDATE_EMPLEADO);
            setStmt(stmt, entidad);
            stmt.setLong(3, entidad.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new ModelException(ModelError.ERROR_UPDATE_EMPLEADO, ex);
        } finally {
            closePrepareStatement(stmt);
        }
    }

    @Override
    public void eliminar(Empleado entidad) throws ModelException {
        PreparedStatement stmt = null;
        try {
            stmt = conexion.prepareStatement(ModelQuery.DELETE_EMPLEADO);
            stmt.setLong(1, entidad.getId());
            if (stmt.executeUpdate() == 0) {
                throw new ModelException(ModelError.ERROR_DELETE_EMPLEADO);
            }
        } catch(SQLException ex) {
            throw new ModelException(ModelError.ERROR_DELETE_EMPLEADO, ex);
        } finally {
            closePrepareStatement(stmt);
        }
    }

    @Override
    public List<Empleado> obtenerTodos() throws ModelException {
        PreparedStatement stmt =  null;
        ResultSet rs = null;
        List<Empleado> empleados = new ArrayList<>();
        
        try {
            stmt = conexion.prepareStatement(ModelQuery.GET_ALL_EMPLEADO);
            rs = stmt.executeQuery();
            while(rs.next()) {
                empleados.add((Empleado) converterEmpleado.BaseDataToEntity(rs));
            }
            
        } catch(SQLException ex) {
            throw new ModelException(ModelError.ERROR_GET_ALL_EMPLEADO, ex);
        } finally {
            closeResultSet(rs);
            closePrepareStatement(stmt);
        }
        
        return empleados;
    }

    @Override
    public Empleado obtener(Long id) throws ModelException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Empleado empleado = null;
        
        try {
            stmt = conexion.prepareStatement(ModelQuery.GET_ONE_EMPLEADO);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            if(rs.next()) {
                empleado = (Empleado) converterEmpleado.BaseDataToEntity(rs);
            }
        } catch(SQLException ex) {
            throw new ModelException(ModelError.ERROR_GET_ONE_EMPLEADO, ex);
        } finally {
            if (rs != null) {
                closeResultSet(rs);
                closePrepareStatement(stmt);
            }
        }
        
        return empleado;
    }
    
    private void setStmt(PreparedStatement stmt, Empleado empleado) throws SQLException {
        stmt.setString(1, empleado.getNome());
        stmt.setString(2, empleado.getApelidos());
    }
    
}
