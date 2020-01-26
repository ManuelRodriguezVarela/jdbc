package gal.san.clemente.tarefa3_acceso_datos.model.dao.implementacion;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import gal.san.clemente.tarefa3_acceso_datos.exception.ModelException;
import gal.san.clemente.tarefa3_acceso_datos.model.Provincia;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.IProvinciaDAO;
import gal.san.clemente.tarefa3_acceso_datos.model.dao.utils.ModelError;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ProvinciaJSONDAOImpl extends DAOImpl implements IProvinciaDAO {
    
    private File file;
    
    public ProvinciaJSONDAOImpl(File file) {
        this.file = file;
    }

    @Override
    public void insertar(Provincia entidad) throws ModelException {
       
    }

    @Override
    public void modificar(Provincia entidad) throws ModelException {
        
    }

    @Override
    public void eliminar(Provincia entidad) throws ModelException {

    }

    @Override
    public List<Provincia> obtenerTodos() throws ModelException {
        Provincia provincia;
        
        List<Provincia> provincias = new ArrayList<>();
        
        BufferedReader buferEntrada;
        
        try {
            //Creamos un fluxo de entrada para o arquivo
            FileReader fluxoDatos = new FileReader(file);
            //Creamos o bufer de entrada
            buferEntrada = new BufferedReader(fluxoDatos);
            //Imos lendo linea a linea
            StringBuilder jsonBuilder = new StringBuilder();
            String linea;
            while ((linea=buferEntrada.readLine()) != null) {
                jsonBuilder.append(linea).append("\n");
            }
            JsonParser parser = new JsonParser();
            //Construimos o String con todalas lineas lidas
            String json = jsonBuilder.toString();
            JsonArray gsonArr = parser.parse(json).getAsJsonArray();
            
            for (JsonElement obj : gsonArr) {
                //Pasamos o json a clase ca cal se corresponde
                Gson gson = new Gson();
                provincia = gson.fromJson(obj, Provincia.class);
                provincias.add(provincia);
                 //Temos que cerrar sempre o ficheiro
            }
            
            buferEntrada.close();
            
            
        } catch (IOException ex) {
            throw new ModelException(ModelError.ERROR_GET_ALL_PROVINCIAS, ex);
        }
        
        return provincias;
    }

    @Override
    public Provincia obtener(Long id) throws ModelException {
        return null;
    }
    
}
