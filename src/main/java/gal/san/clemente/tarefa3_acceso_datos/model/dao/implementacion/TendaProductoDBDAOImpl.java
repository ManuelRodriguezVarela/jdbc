package gal.san.clemente.tarefa3_acceso_datos.model.dao.implementacion;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.TendaProducto;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.ITendaProductoDAO;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.utils.ModelError;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.utils.ModelQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.converter.IConverter;

public class TendaProductoDBDAOImpl extends DAOImpl implements ITendaProductoDAO {
    
    private IConverter converterTendaProducto;
    private Connection conexion;
    
    public TendaProductoDBDAOImpl(Connection conexion, IConverter converter) {
        this.conexion = conexion;
        this.converterTendaProducto = converter;
    }

    @Override
    public void insertar(TendaProducto entidad) throws ModelException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conexion.prepareStatement(ModelQuery.INSERT_TENDA_PRODUCTO);
            setStmt(stmt, entidad);
            if (stmt.executeUpdate() == 0) {
                throw new ModelException(ModelError.ERROR_INSERT_TENDA_PRODUCTO);
            }
            rs = stmt.getGeneratedKeys();
            if(rs.next()) {
                entidad.setId(rs.getLong(1));
            }
        } catch (SQLException ex) {
            throw new ModelException(ModelError.ERROR_INSERT_TENDA_PRODUCTO, ex);
        } finally {
            closePrepareStatement(stmt);
            closeResultSet(rs);
        }
    }

    @Override
    public void modificar(TendaProducto entidad) throws ModelException {
        PreparedStatement stmt = null;
        try {
            stmt = conexion.prepareStatement(ModelQuery.UPDATE_TENDA_PRODUCTO);
            setStmt(stmt, entidad);
            stmt.setLong(4, entidad.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new ModelException(ModelError.ERROR_UPDATE_TENDA_PRODUCTO, ex);
        } finally {
            closePrepareStatement(stmt);
        }
    }

    @Override
    public void eliminar(TendaProducto entidad) throws ModelException {
        PreparedStatement stmt = null;
        try {
            stmt = conexion.prepareStatement(ModelQuery.DELETE_TENDA_PRODUCTO);
            stmt.setLong(1, entidad.getId());
            if (stmt.executeUpdate() == 0) {
                throw new ModelException(ModelError.ERROR_DELETE_TENDA_PRODUCTO);
            }
        } catch(SQLException ex) {
            throw new ModelException(ModelError.ERROR_DELETE_TENDA_PRODUCTO, ex);
        } finally {
            closePrepareStatement(stmt);
        }
    }

    @Override
    public List<TendaProducto> obtenerTodos() throws ModelException {
        PreparedStatement stmt =  null;
        ResultSet rs = null;
        List<TendaProducto> productosTenda = new ArrayList<>();
        
        try {
            stmt = conexion.prepareStatement(ModelQuery.GET_ALL_TENDA_PRODUCTO);
            rs = stmt.executeQuery();
            while(rs.next()) {
                productosTenda.add((TendaProducto) converterTendaProducto.BaseDataToEntity(rs));
            }
            
        } catch(SQLException ex) {
            throw new ModelException(ModelError.ERROR_GET_ALL_TENDA_PRODUCTO, ex);
        } finally {
            closeResultSet(rs);
            closePrepareStatement(stmt);
        }
        
        return productosTenda;
    }
    
     @Override
    public List<TendaProducto> obtenerTodos(Long tendaId) throws ModelException {
        PreparedStatement stmt =  null;
        ResultSet rs = null;
        List<TendaProducto> productosTenda = new ArrayList<>();
        
        try {
            stmt = conexion.prepareStatement(ModelQuery.GET_ALL_TENDA_PRODUCTO_POR_TENDA);
            stmt.setLong(1, tendaId);
            rs = stmt.executeQuery();
            while(rs.next()) {
                productosTenda.add((TendaProducto) converterTendaProducto.BaseDataToEntity(rs));
            }
            
        } catch(SQLException ex) {
            throw new ModelException(ModelError.ERROR_GET_ALL_TENDA_PRODUCTO, ex);
        } finally {
            closeResultSet(rs);
            closePrepareStatement(stmt);
        }
        
        return productosTenda;
    }

    @Override
    public TendaProducto obtener(Long id) throws ModelException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        TendaProducto tendaProducto = null;
        
        try {
            stmt = conexion.prepareStatement(ModelQuery.GET_ONE_TENDA_PRODUCTO);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            if(rs.next()) {
                tendaProducto = (TendaProducto) converterTendaProducto.BaseDataToEntity(rs);
            }
        } catch(SQLException ex) {
            throw new ModelException(ModelError.ERROR_GET_ONE_TENDA_PRODUCTO, ex);
        } finally {
            if (rs != null) {
                closeResultSet(rs);
                closePrepareStatement(stmt);
            }
        }
        
        return tendaProducto;
    }
    
    private void setStmt(PreparedStatement stmt, TendaProducto tendaProducto) throws SQLException {
        stmt.setLong(1, tendaProducto.getIdTenda());
        stmt.setLong(2, tendaProducto.getIdProducto());
        stmt.setInt(3, tendaProducto.getStock());
    }
    
}
