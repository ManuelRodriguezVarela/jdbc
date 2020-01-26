package gal.san.clemente.tarefa3_acceso_datos.model.dao.converter;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.Cliente;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.utils.ModelError;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ClienteConverterToBBDDImpl implements IConverter<Cliente, ResultSet>{

    @Override
    public Cliente BaseDataToEntity(ResultSet rs) throws ModelException {
        Cliente cliente = null;
        try {
            String nome = rs.getString("nome");
            String apelidos = rs.getString("apelidos");
            String email = rs.getString("email");
            cliente = new Cliente(nome, apelidos, email);
            cliente.setId(rs.getLong("id"));
        } catch (SQLException ex) {
            throw new ModelException(ModelError.ERROR_CONVERTER_TO_ENTITY, ex);
        }
        
        return cliente;
    }
    
}
