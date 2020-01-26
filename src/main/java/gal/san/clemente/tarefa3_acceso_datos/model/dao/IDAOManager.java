package gal.san.clemente.tarefa3_acceso_datos.model.dao;

public interface IDAOManager {
    
    IClienteDAO getClienteDAO();
    
    IEmpleadoDAO getEmpleadoDAO();
    
    IProductoDAO getProductoDAO();
    
    ITendaDAO getTendaDAO();
    
    ITendaProductoDAO getTendaProductoDAO();
    
    ITendaEmpleadoDAO getTendaEmpleadoDAO();
    
    IProvinciaDAO getProvinciaDAO();
    
}
