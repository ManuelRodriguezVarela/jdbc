package gal.san.clemente.tarefa3_acceso_datos.model.dao.implementacion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SQLiteConnection {
    private String jdbc = "jdbc:sqlite:./franquicia";
    private static Connection conexion = null;

    private SQLiteConnection() throws SQLException {
        //creando conexión a través de url
        conexion = DriverManager.getConnection(jdbc); 
    }
    
    public static Connection getConexion() throws SQLException {
        if(conexion == null) {
            new SQLiteConnection();
        }
        return conexion;
    }
}
