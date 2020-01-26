package gal.san.clemente.tarefa3_acceso_datos.model.dao.converter;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.utils.ModelError;
import gal.san.clemente.tarefa3_acceso_datos.model.Empleado;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoConverterToBBDDImpl implements IConverter<Empleado, ResultSet>{

    @Override
    public Empleado BaseDataToEntity(ResultSet rs) throws ModelException {
        Empleado empleado = null;
        try {
            String nome = rs.getString("nome");
            String apelidos = rs.getString("apelidos");
            empleado = new Empleado(nome,apelidos);
            empleado.setId(rs.getLong("id"));
        } catch (SQLException ex) {
            throw new ModelException(ModelError.ERROR_CONVERTER_TO_ENTITY, ex);
        }
        
        return empleado;
    }
    
}
