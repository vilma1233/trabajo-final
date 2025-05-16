package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    private static final String URL = "jdbc:mysql://127.0.0.1:3306/sistemaventas";  // Cambia "tu_base_de_datos" por el nombre de tu base de datos
    private static final String USER = "root";  // Usuario por defecto en XAMPP
    private static final String PASSWORD = "";  // Contraseña por defecto (vacía en XAMPP)

    public static Connection conectar() throws SQLException {
        try {
            // Establecer la conexión
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            return con;
        } catch (SQLException e) {
            System.out.println("Error de conexión: " + e.getMessage());
            throw e;
        }
    }
}