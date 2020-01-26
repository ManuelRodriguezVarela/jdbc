package gal.san.clemente.tarefa3_acceso_datos.model.dao;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.TendaProducto;
import java.util.List;

public interface ITendaProductoDAO extends IDAO<TendaProducto, Long> {
    List<TendaProducto> obtenerTodos(Long tendaId) throws ModelException;
}
