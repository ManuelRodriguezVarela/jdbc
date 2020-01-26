package gal.san.clemente.tarefa3_acceso_datos.model.dao.converter;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.utils.ModelError;
import gal.san.clemente.tarefa3_acceso_datos.model.TendaProducto;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TendaProductoConverterToBBDDImpl implements IConverter<TendaProducto, ResultSet>{

    @Override
    public TendaProducto BaseDataToEntity(ResultSet rs) throws ModelException {
        TendaProducto tendaProducto = null;
        try {
            Long idTenda = rs.getLong("tenda");
            Long idProducto = rs.getLong("empregado");
            Integer stock = rs.getInt("stock");
            tendaProducto = new TendaProducto(idTenda, idProducto, stock);
            tendaProducto.setId(rs.getLong("id"));
        } catch (SQLException ex) {
            throw new ModelException(ModelError.ERROR_CONVERTER_TO_ENTITY, ex);
        }
        
        return tendaProducto;
    }
    
}
