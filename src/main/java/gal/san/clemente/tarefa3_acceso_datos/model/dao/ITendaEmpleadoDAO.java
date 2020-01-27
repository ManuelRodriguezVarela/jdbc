package gal.san.clemente.tarefa3_acceso_datos.model.dao;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.TendaEmpleado;
import java.util.List;

public interface ITendaEmpleadoDAO extends IDAO<TendaEmpleado, Long> {
    List<TendaEmpleado> obtenerTodos(Long tendaId) throws ModelException;
}
