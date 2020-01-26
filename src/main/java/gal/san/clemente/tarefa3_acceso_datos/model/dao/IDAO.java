package gal.san.clemente.tarefa3_acceso_datos.model.dao;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import java.util.List;

public interface IDAO<T, K> {
    void insertar(T entidad) throws ModelException;
    
    void modificar(T entidad) throws ModelException;
    
    void eliminar(T entidad) throws ModelException;
    
    List<T> obtenerTodos() throws ModelException;
    
    T obtener(K id) throws ModelException;
}
