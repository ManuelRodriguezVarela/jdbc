package gal.san.clemente.tarefa3_acceso_datos.model.dao.implementacion;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.TendaEmpleado;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.ITendaEmpleadoDAO;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.utils.ModelError;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.utils.ModelQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.converter.IConverter;

public class TendaEmpleadoDBDAOImpl extends DAOImpl implements ITendaEmpleadoDAO {
    
    private IConverter converterTendaEmpleado;
    private Connection conexion;
    
    public TendaEmpleadoDBDAOImpl(Connection conexion, IConverter converter) {
        this.conexion = conexion;
        this.converterTendaEmpleado = converter;
    }

    @Override
    public void insertar(TendaEmpleado entidad) throws ModelException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conexion.prepareStatement(ModelQuery.INSERT_TENDA_EMPLEADO);
            setStmt(stmt, entidad);
            if (stmt.executeUpdate() == 0) {
                throw new ModelException(ModelError.ERROR_INSERT_TENDA_EMPLEADO);
            }
            rs = stmt.getGeneratedKeys();
            if(rs.next()) {
                entidad.setId(rs.getLong(1));
            }
        } catch (SQLException ex) {
            throw new ModelException(ModelError.ERROR_INSERT_TENDA_EMPLEADO, ex);
        } finally {
            closePrepareStatement(stmt);
            closeResultSet(rs);
        }
    }

    @Override
    public void modificar(TendaEmpleado entidad) throws ModelException {
        PreparedStatement stmt = null;
        try {
            stmt = conexion.prepareStatement(ModelQuery.UPDATE_TENDA_EMPLEADO);
            setStmt(stmt, entidad);
            stmt.setLong(4, entidad.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new ModelException(ModelError.ERROR_UPDATE_TENDA_EMPLEADO, ex);
        } finally {
            closePrepareStatement(stmt);
        }
    }

    @Override
    public void eliminar(TendaEmpleado entidad) throws ModelException {
        PreparedStatement stmt = null;
        try {
            stmt = conexion.prepareStatement(ModelQuery.DELETE_TENDA_EMPLEADO);
            stmt.setLong(1, entidad.getId());
            if (stmt.executeUpdate() == 0) {
                throw new ModelException(ModelError.ERROR_DELETE_TENDA_EMPLEADO);
            }
        } catch(SQLException ex) {
            throw new ModelException(ModelError.ERROR_DELETE_TENDA_EMPLEADO, ex);
        } finally {
            closePrepareStatement(stmt);
        }
    }

    @Override
    public List<TendaEmpleado> obtenerTodos() throws ModelException {
        PreparedStatement stmt =  null;
        ResultSet rs = null;
        List<TendaEmpleado> empregadosTenda = new ArrayList<>();
        
        try {
            stmt = conexion.prepareStatement(ModelQuery.GET_ALL_TENDA_EMPLEADO);
            rs = stmt.executeQuery();
            while(rs.next()) {
                empregadosTenda.add((TendaEmpleado) converterTendaEmpleado.BaseDataToEntity(rs));
            }
            
        } catch(SQLException ex) {
            throw new ModelException(ModelError.ERROR_GET_ALL_TENDA_EMPLEADO, ex);
        } finally {
            closeResultSet(rs);
            closePrepareStatement(stmt);
        }
        
        return empregadosTenda;
    }

    @Override
    public TendaEmpleado obtener(Long id) throws ModelException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        TendaEmpleado tendaEmpleado = null;
        
        try {
            stmt = conexion.prepareStatement(ModelQuery.GET_ONE_TENDA_EMPLEADO);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            if(rs.next()) {
                tendaEmpleado = (TendaEmpleado) converterTendaEmpleado.BaseDataToEntity(rs);
            }
        } catch(SQLException ex) {
            throw new ModelException(ModelError.ERROR_GET_ONE_TENDA_EMPLEADO, ex);
        } finally {
            if (rs != null) {
                closeResultSet(rs);
                closePrepareStatement(stmt);
            }
        }
        
        return tendaEmpleado;
    }
    
    private void setStmt(PreparedStatement stmt, TendaEmpleado tendaEmpleado) throws SQLException {
        stmt.setLong(1, tendaEmpleado.getIdTenda());
        stmt.setLong(2, tendaEmpleado.getIdEmpleado());
        stmt.setInt(3, tendaEmpleado.getNumeroHorasSemana());
    }
    
}
