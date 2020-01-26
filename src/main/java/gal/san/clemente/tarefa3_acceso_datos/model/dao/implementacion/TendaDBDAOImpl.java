package gal.san.clemente.tarefa3_acceso_datos.model.dao.implementacion;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.Tenda;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.ITendaDAO;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.utils.ModelError;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.utils.ModelQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.converter.IConverter;

public class TendaDBDAOImpl extends DAOImpl implements ITendaDAO {
    
    private IConverter converterTenda;
    private Connection conexion;
    
    public TendaDBDAOImpl(Connection conexion, IConverter converter) {
        this.conexion = conexion;
        this.converterTenda = converter;
    }

    @Override
    public void insertar(Tenda entidad) throws ModelException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conexion.prepareStatement(ModelQuery.INSERT_TENDA);
            setStmt(stmt, entidad);
            if (stmt.executeUpdate() == 0) {
                throw new ModelException(ModelError.ERROR_INSERT_TENDA);
            }
            rs = stmt.getGeneratedKeys();
            if(rs.next()) {
                entidad.setId(rs.getLong(1));
            }
        } catch (SQLException ex) {
            throw new ModelException(ModelError.ERROR_INSERT_TENDA, ex);
        } finally {
            closePrepareStatement(stmt);
            closeResultSet(rs);
        }
    }

    @Override
    public void modificar(Tenda entidad) throws ModelException {
        PreparedStatement stmt = null;
        try {
            stmt = conexion.prepareStatement(ModelQuery.UPDATE_TENDA);
            setStmt(stmt, entidad);
            stmt.setLong(4, entidad.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new ModelException(ModelError.ERROR_UPDATE_TENDA, ex);
        } finally {
            closePrepareStatement(stmt);
        }
    }

    @Override
    public void eliminar(Tenda entidad) throws ModelException {
        PreparedStatement stmt = null;
        try {
            stmt = conexion.prepareStatement(ModelQuery.DELETE_TENDA);
            stmt.setLong(1, entidad.getId());
            if (stmt.executeUpdate() == 0) {
                throw new ModelException(ModelError.ERROR_DELETE_TENDA);
            }
        } catch(SQLException ex) {
            throw new ModelException(ModelError.ERROR_DELETE_TENDA, ex);
        } finally {
            closePrepareStatement(stmt);
        }
    }

    @Override
    public List<Tenda> obtenerTodos() throws ModelException {
        PreparedStatement stmt =  null;
        ResultSet rs = null;
        List<Tenda> tendas = new ArrayList<>();
        
        try {
            stmt = conexion.prepareStatement(ModelQuery.GET_ALL_TENDA);
            rs = stmt.executeQuery();
            while(rs.next()) {
                tendas.add((Tenda) converterTenda.BaseDataToEntity(rs));
            }
            
        } catch(SQLException ex) {
            throw new ModelException(ModelError.ERROR_GET_ALL_TENDA, ex);
        } finally {
            closeResultSet(rs);
            closePrepareStatement(stmt);
        }
        
        return tendas;
    }

    @Override
    public Tenda obtener(Long id) throws ModelException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Tenda tenda = null;
        
        try {
            stmt = conexion.prepareStatement(ModelQuery.GET_ONE_TENDA);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            if(rs.next()) {
                tenda = (Tenda) converterTenda.BaseDataToEntity(rs);
            }
        } catch(SQLException ex) {
            throw new ModelException(ModelError.ERROR_GET_ONE_TENDA, ex);
        } finally {
            if (rs != null) {
                closeResultSet(rs);
                closePrepareStatement(stmt);
            }
        }
        
        return tenda;
    }
    
    private void setStmt(PreparedStatement stmt, Tenda tenda) throws SQLException {
        stmt.setString(1, tenda.getNome());
        stmt.setString(2, tenda.getCidade());
        stmt.setString(3, tenda.getProvincia());
    }
    
}
