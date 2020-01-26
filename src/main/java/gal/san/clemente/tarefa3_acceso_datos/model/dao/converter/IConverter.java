package gal.san.clemente.tarefa3_acceso_datos.model.dao.converter;

import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;

public interface IConverter<T, E> {
    T BaseDataToEntity(E baseData) throws ModelException;
}
