package Conexion;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexion {

    private static Connection conexion = null;
    private static String cadena = "jdbc:mysql://localhost:3306/veterinaria_bd?useSSL=false&serverTimezone=America/Mexico_City";


   
    
    public static Connection getConexion(String user, String password) {
        try {
            conexion = DriverManager.getConnection(cadena, user, password);
        } catch (SQLException ex) {
            System.out.println("Conexion fallida error " + ex.getMessage());
        }
        return conexion;
    }

}
