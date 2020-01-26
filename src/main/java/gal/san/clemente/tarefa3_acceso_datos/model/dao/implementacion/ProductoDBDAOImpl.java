package gal.san.clemente.tarefa3_acceso_datos.model.dao.implementacion;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.Producto;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.IProductoDAO;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.utils.ModelError;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.utils.ModelQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.converter.IConverter;

public class ProductoDBDAOImpl extends DAOImpl implements IProductoDAO {
    
    private IConverter converterProducto;
    private Connection conexion;
    
    public ProductoDBDAOImpl(Connection conexion, IConverter converter) {
        this.conexion = conexion;
        this.converterProducto = converter;
    }

    @Override
    public void insertar(Producto entidad) throws ModelException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conexion.prepareStatement(ModelQuery.INSERT_PRODUCT);
            setStmt(stmt, entidad);
            if (stmt.executeUpdate() == 0) {
                throw new ModelException(ModelError.ERROR_INSERT_PRODUCT);
            }
            rs = stmt.getGeneratedKeys();
            if(rs.next()) {
                entidad.setId(rs.getLong(1));
            }
        } catch (SQLException ex) {
            throw new ModelException(ModelError.ERROR_INSERT_PRODUCT, ex);
        } finally {
            closePrepareStatement(stmt);
            closeResultSet(rs);
        }
    }

    @Override
    public void modificar(Producto entidad) throws ModelException {
        PreparedStatement stmt = null;
        try {
            stmt = conexion.prepareStatement(ModelQuery.UPDATE_PRODUCT);
            setStmt(stmt, entidad);
            stmt.setLong(4, entidad.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new ModelException(ModelError.ERROR_UPDATE_PRODUCT, ex);
        } finally {
            closePrepareStatement(stmt);
        }
    }

    @Override
    public void eliminar(Producto entidad) throws ModelException {
        PreparedStatement stmt = null;
        try {
            stmt = conexion.prepareStatement(ModelQuery.DELETE_PRODUCT);
            stmt.setLong(1, entidad.getId());
            if (stmt.executeUpdate() == 0) {
                throw new ModelException(ModelError.ERROR_DELETE_PRODUCT);
            }
        } catch(SQLException ex) {
            throw new ModelException(ModelError.ERROR_DELETE_PRODUCT, ex);
        } finally {
            closePrepareStatement(stmt);
        }
    }

    @Override
    public List<Producto> obtenerTodos() throws ModelException {
        PreparedStatement stmt =  null;
        ResultSet rs = null;
        List<Producto> productos = new ArrayList<>();
        
        try {
            stmt = conexion.prepareStatement(ModelQuery.GET_ALL_PRODUCTS);
            rs = stmt.executeQuery();
            while(rs.next()) {
                productos.add((Producto) converterProducto.BaseDataToEntity(rs));
            }
            
        } catch(SQLException ex) {
            throw new ModelException(ModelError.ERROR_GET_ALL_PRODUCT, ex);
        } finally {
            closeResultSet(rs);
            closePrepareStatement(stmt);
        }
        
        return productos;
    }

    @Override
    public Producto obtener(Long id) throws ModelException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Producto producto = null;
        
        try {
            stmt = conexion.prepareStatement(ModelQuery.GET_ONE_PRODUCT);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            if(rs.next()) {
                producto = (Producto) converterProducto.BaseDataToEntity(rs);
            }
        } catch(SQLException ex) {
            throw new ModelException(ModelError.ERROR_GET_ONE_PRODUCT, ex);
        } finally {
            if (rs != null) {
                closeResultSet(rs);
                closePrepareStatement(stmt);
            }
        }
        
        return producto;
    }
    
    private void setStmt(PreparedStatement stmt, Producto producto) throws SQLException {
        stmt.setString(1, producto.getNome());
        stmt.setString(2, producto.getDescripcion());
        stmt.setDouble(3, producto.getPrezo());
    }
    
}
