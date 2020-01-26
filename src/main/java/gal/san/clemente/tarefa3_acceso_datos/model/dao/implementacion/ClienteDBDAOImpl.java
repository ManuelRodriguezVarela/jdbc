package gal.san.clemente.tarefa3_acceso_datos.model.dao.implementacion;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.Cliente;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.utils.ModelError;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.utils.ModelQuery;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.IClienteDAO;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.converter.IConverter;
import org.sqlite.jdbc3.JDBC3PreparedStatement;

public class ClienteDBDAOImpl extends DAOImpl implements IClienteDAO {
    
    private IConverter converterCliente;
    private Connection conexion;
    
    public ClienteDBDAOImpl(Connection conexion, IConverter converter) {
        this.conexion = conexion;
        this.converterCliente = converter;
    }

    @Override
    public void insertar(Cliente entidad) throws ModelException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = conexion.prepareStatement(ModelQuery.INSERT_CLIENTE);
            setStmt(stmt, entidad);
            if (stmt.executeUpdate() == 0) {
                throw new ModelException(ModelError.ERROR_INSERT_CLIENTE);
            }
            rs = stmt.getGeneratedKeys();
            if(rs.next()) {
                entidad.setId(rs.getLong(1));
            }
        } catch (SQLException ex) {
            throw new ModelException(ModelError.ERROR_INSERT_CLIENTE, ex);
        } finally {
            closePrepareStatement(stmt);
            closeResultSet(rs);
        }
    }

    @Override
    public void modificar(Cliente entidad) throws ModelException {
        PreparedStatement stmt = null;
        try {
            stmt = conexion.prepareStatement(ModelQuery.UPDATE_CLIENTE);
            setStmt(stmt, entidad);
            stmt.setLong(4, entidad.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            throw new ModelException(ModelError.ERROR_UPDATE_CLIENTE, ex);
        } finally {
            closePrepareStatement(stmt);
        }
    }

    @Override
    public void eliminar(Cliente entidad) throws ModelException {
        PreparedStatement stmt = null;
        try {
            stmt = conexion.prepareStatement(ModelQuery.DELETE_CLIENTE);
            stmt.setLong(1, entidad.getId());
            if (stmt.executeUpdate() == 0) {
                throw new ModelException(ModelError.ERROR_DELETE_CLIENTE);
            }
        } catch(SQLException ex) {
            throw new ModelException(ModelError.ERROR_DELETE_CLIENTE, ex);
        } finally {
            closePrepareStatement(stmt);
        }
    }

    @Override
    public List<Cliente> obtenerTodos() throws ModelException {
        PreparedStatement stmt =  null;
        ResultSet rs = null;
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            stmt = conexion.prepareStatement(ModelQuery.GET_ALL_CLIENTES);
            rs = stmt.executeQuery();
            while(rs.next()) {
                clientes.add((Cliente) converterCliente.BaseDataToEntity(rs));
            }
            
        } catch(SQLException ex) {
            throw new ModelException(ModelError.ERROR_GET_ALL_CLIENTES, ex);
        } finally {
            closeResultSet(rs);
            closePrepareStatement(stmt);
        }
        
        return clientes;
    }

    @Override
    public Cliente obtener(Long id) throws ModelException {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cliente cliente = null;
        
        try {
            stmt = conexion.prepareStatement(ModelQuery.GET_ONE_CLIENTE);
            stmt.setLong(1, id);
            rs = stmt.executeQuery();
            if(rs.next()) {
                cliente = (Cliente) converterCliente.BaseDataToEntity(rs);
            }
        } catch(SQLException ex) {
            throw new ModelException(ModelError.ERROR_GET_ONE_CLIENTE, ex);
        } finally {
            if (rs != null) {
                closeResultSet(rs);
                closePrepareStatement(stmt);
            }
        }
        
        return cliente;
    }
    
    private void setStmt(PreparedStatement stmt, Cliente cliente) throws SQLException {
        stmt.setString(1, cliente.getNome());
        stmt.setString(2, cliente.getApelidos());
        stmt.setString(3, cliente.getEmail());
    }
    
}
