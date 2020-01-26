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

public class DAOManagerJSONImpl implements IDAOManager {
    
    private File file;
    
    private IProvinciaDAO provinciaDAO = null;

    public DAOManagerJSONImpl() throws SQLException {
        file = new File("./provincias.json");
    }

    @Override
    public IClienteDAO getClienteDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IEmpleadoDAO getEmpleadoDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IProductoDAO getProductoDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ITendaDAO getTendaDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ITendaProductoDAO getTendaProductoDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ITendaEmpleadoDAO getTendaEmpleadoDAO() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public IProvinciaDAO getProvinciaDAO() {
        if(provinciaDAO == null) {
            provinciaDAO = new ProvinciaJSONDAOImpl(file);
        }
        return provinciaDAO;
    }
    
}
