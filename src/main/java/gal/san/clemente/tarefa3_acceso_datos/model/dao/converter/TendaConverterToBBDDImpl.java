package gal.san.clemente.tarefa3_acceso_datos.model.dao.converter;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.utils.ModelError;
import gal.san.clemente.tarefa3_acceso_datos.model.Tenda;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TendaConverterToBBDDImpl implements IConverter<Tenda, ResultSet>{

    @Override
    public Tenda BaseDataToEntity(ResultSet rs) throws ModelException {
        Tenda tenda = null;
        try {
            String nome = rs.getString("nome");
            String cidade = rs.getString("cidade");
            String provincia = rs.getString("provincia");
            tenda = new Tenda(nome, cidade, provincia);
            tenda.setId(rs.getLong("id"));
        } catch (SQLException ex) {
            throw new ModelException(ModelError.ERROR_CONVERTER_TO_ENTITY, ex);
        }
        
        return tenda;
    }
    
}
