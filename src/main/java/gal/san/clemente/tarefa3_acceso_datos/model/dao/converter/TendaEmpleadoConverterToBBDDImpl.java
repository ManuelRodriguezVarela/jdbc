package gal.san.clemente.tarefa3_acceso_datos.model.dao.converter;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.utils.ModelError;
import gal.san.clemente.tarefa3_acceso_datos.model.TendaEmpleado;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TendaEmpleadoConverterToBBDDImpl implements IConverter<TendaEmpleado, ResultSet>{

    @Override
    public TendaEmpleado BaseDataToEntity(ResultSet rs) throws ModelException {
        TendaEmpleado tendaEmpleado = null;
        try {
            Long idTenda = rs.getLong("tenda");
            Long idEmpleado = rs.getLong("empregado");
            Integer numeroHorasSemana = rs.getInt("numero_horas_semana");
            tendaEmpleado = new TendaEmpleado(idTenda, idEmpleado, numeroHorasSemana);
            tendaEmpleado.setId(rs.getLong("id"));
        } catch (SQLException ex) {
            throw new ModelException(ModelError.ERROR_CONVERTER_TO_ENTITY, ex);
        }
        
        return tendaEmpleado;
    }
    
}
