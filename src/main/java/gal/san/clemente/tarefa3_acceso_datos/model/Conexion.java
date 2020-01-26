/**
 * Clase eXemplo de conexión. TEST E PROBAS
 */
//package gal.san.clemente.tarefa3_acceso_datos.model;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//
//public class Conexion {
//
//    private Connection connection = null;
//
//    public Conexion() throws SQLException {
//        try {
//            conectar();
//            transaccion();
//            consulta();
//        } finally {
//            cerrar();
//        }
//
//    }
//
//    public void conectar() throws SQLException {
//        String jdbc = "jdbc:sqlite:./franquicia";
//        //creando conexión a través de url
//        connection = DriverManager.getConnection(jdbc);
//        System.out.println("Estoy dentro");
//        //setAutocommit a false para poder hacer transacciones e más de una consulta, por
//        //defecto es true, implica que cada sentencia sql tiene su transacción
//        connection.setAutoCommit(false);
//    }
//
//    public void cerrar() throws SQLException {
//        connection.close();
//    }
//
//    public void consulta() throws SQLException {
//        Statement statement = connection.createStatement();
//        ResultSet set = statement.executeQuery("select id, nome, apellidos from empleados");
//        while (set.next()) {
//            int id = set.getByte("id");
//            String nome = set.getString("nome");
//            String apellidos = set.getString("apellidos");
//            System.out.println("Alumno: nome: " + nome + " apellidos " + apellidos);
//        }
//        set.close();
//        statement.close();
//    }
//
//    //para evitar inyección de código sql
//    public void consulta2(String apellido) throws SQLException {
//        String query = "select id, nome, apellidos from empleados where apellidos like ?";
//        //más segurado cuando recibimos parámetros, para web. Evita la inyección de código malicioso
//        PreparedStatement statement = connection.prepareStatement(query);
//        statement.setString(1, apellido);
//        ResultSet set = statement.executeQuery();
//        while (set.next()) {
//            int id = set.getByte("id");
//            String nome = set.getString("nome");
//            String apellidos = set.getString("apellidos");
//            System.out.println("Alumno: nome: " + nome + " apellidos " + apellidos);
//        }
//        set.close();
//        statement.close();
//    }
//
//    //transaciones
//    public void transaccion() throws SQLException {
//        final String TENDA = "INSERT INTO tendas(nome) VALUES(?)";
//        final String PRODUCTO = "INSERT INTO productos(nome, descripcion, prezo) VALUES(?, ?, ?)";
//        PreparedStatement tenda = null, producto = null;
//        try {
//            tenda = connection.prepareStatement(TENDA);
//            tenda.setString(1, "A Bonita");
//            //devuelve las filas modificadas o 0 si no se modifica ninguna
//            tenda.executeUpdate();
//
//            producto = connection.prepareStatement(PRODUCTO);
//            producto.setString(1, "Lentellas");
//            producto.setString(2, "Paquete de 1kg de lentellas");
//            producto.setDouble(3, 1.95);
//            producto.executeUpdate();
//
//            //transacción
//            connection.commit();
//        } catch (SQLException e) {
//            // si algo falla hacemos el rollback
//            connection.rollback();
//            e.printStackTrace();
//        } finally {
//            if (tenda != null) {
//                //cerramos el preparedStatement
//                tenda.close();
//            }
//            if (producto != null) {
//                //cerramos el preparedStatement
//                producto.close();
//            }
//        }
//
//    }
//
//    private static final Logger LOG = LoggerFactory.getLogger(Conexion.class);
//
//    public static void main(String args[]) {
//        try {
//            new Conexion();
//        } catch (SQLException e) {
//            LOG.error("Error durante la conexión a la bbdd", e);
//        }
//    }
//}
