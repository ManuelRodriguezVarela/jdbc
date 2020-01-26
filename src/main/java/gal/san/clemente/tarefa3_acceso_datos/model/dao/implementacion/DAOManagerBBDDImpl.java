package gal.san.clemente.tarefa3_acceso_datos.model.dao.implementacion;

import gal.san.clemente.tarefa3_acceso_datos.model.dao.IClienteDAO;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.IDAOManager;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.IEmpleadoDAO;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.IProductoDAO;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.IProvinciaDAO;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.ITendaDAO;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.ITendaEmpleadoDAO;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.ITendaProductoDAO;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.converter.ClienteConverterToBBDDImpl;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.converter.EmpleadoConverterToBBDDImpl;
import java.sql.Connection;
import java.sql.SQLException;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.converter.IConverter;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.converter.ProductoConverterToBBDDImpl;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.converter.TendaConverterToBBDDImpl;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.converter.TendaEmpleadoConverterToBBDDImpl;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.converter.TendaProductoConverterToBBDDImpl;
import java.io.File;

public class DAOManagerBBDDImpl implements IDAOManager {
    
    private Connection conexion;
    
    private File file;
    
    private IEmpleadoDAO empleadoDAO = null;
    
    private ITendaDAO tendaDAO = null;
    
    private IClienteDAO clienteDAO = null;
    
    private IProductoDAO productoDAO = null;
    
    private ITendaProductoDAO tendaProductoDAO = null;
    
    private ITendaEmpleadoDAO tendaEmpleadoDAO = null;

    public DAOManagerBBDDImpl() throws SQLException {
        conexion = SQLiteConnection.getConexion();
    }

    @Override
    public IClienteDAO getClienteDAO() {
        if(clienteDAO == null) {
            IConverter clienteConverter = new ClienteConverterToBBDDImpl();
            clienteDAO = new ClienteDBDAOImpl(conexion, clienteConverter);
        }
        return clienteDAO;
    }

    @Override
    public IEmpleadoDAO getEmpleadoDAO() {
        if(empleadoDAO == null) {
            IConverter empleadoConverter = new EmpleadoConverterToBBDDImpl();
            empleadoDAO = new EmpleadoDBDAOImpl(conexion, empleadoConverter);
        }
        return empleadoDAO;
    }

    @Override
    public IProductoDAO getProductoDAO() {
        if(productoDAO == null) {
            IConverter productoConverter = new ProductoConverterToBBDDImpl();
            productoDAO = new ProductoDBDAOImpl(conexion, productoConverter);
        }
        return productoDAO;
    }

    @Override
    public ITendaDAO getTendaDAO() {
        if(tendaDAO == null) {
            IConverter tendaConverter = new TendaConverterToBBDDImpl();
            tendaDAO = new TendaDBDAOImpl(conexion, tendaConverter);
        }
        return tendaDAO;
    } 
    
    @Override
    public ITendaProductoDAO getTendaProductoDAO() {
        if(tendaProductoDAO == null) {
            IConverter tendaProductoConverter = new TendaProductoConverterToBBDDImpl();
            tendaProductoDAO = new TendaProductoDBDAOImpl(conexion, tendaProductoConverter);
        }
        return tendaProductoDAO;
    } 
    
    @Override
    public ITendaEmpleadoDAO getTendaEmpleadoDAO() {
        if(tendaEmpleadoDAO == null) {
            IConverter tendaEmpleadoConverter = new TendaEmpleadoConverterToBBDDImpl();
            tendaProductoDAO = new TendaProductoDBDAOImpl(conexion, tendaEmpleadoConverter);
        }
        return tendaEmpleadoDAO;
    } 

    @Override
    public IProvinciaDAO getProvinciaDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
