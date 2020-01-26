package gal.san.clemente.tarefa3_acceso_datos.model.dao.converter;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.Producto;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.utils.ModelError;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoConverterToBBDDImpl implements IConverter<Producto, ResultSet>{

    @Override
    public Producto BaseDataToEntity(ResultSet rs) throws ModelException {
        Producto producto = null;
        try {
            String nome = rs.getString("nome");
            String descripcion = rs.getString("descripcion");
            Double prezo = rs.getDouble("prezo");
            producto = new Producto(nome, descripcion, prezo);
            producto.setId(rs.getLong("id"));
        } catch (SQLException ex) {
            throw new ModelException(ModelError.ERROR_CONVERTER_TO_ENTITY, ex);
        }
        
        return producto;
    }
    
}
