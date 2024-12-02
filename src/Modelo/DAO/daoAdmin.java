/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import Conexion.Conexion;
import Modelo.VO.Veterinario;
import com.mysql.cj.protocol.Resultset;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;

/**
 *
 * @author gambo
 */
public class daoAdmin {

    private final static Connection conexion = Conexion.getConexion("admin", "tokischa");

    public static void agregar(Veterinario veterinario) throws SQLException {
        String usuario = veterinario.getUsuario();
        String password = veterinario.getPassword();
        String nombre = veterinario.getNombre();
        String apellido = veterinario.getApellido();
        String telefono = veterinario.getTelefono();
        String correo = veterinario.getCorreo();
        double sueldo = veterinario.getSueldo();
        String cedula = veterinario.getCedula();

        PreparedStatement pst = conexion.prepareStatement("call crearvet(?,?,?,?,?,?,?,?");
        pst.setString(1, usuario.trim());
        pst.setString(2, password.trim());
        pst.setString(3, nombre.trim());
        pst.setString(4, apellido.trim());
        pst.setString(5, correo);
        pst.setString(6, telefono);
        pst.setDouble(7, sueldo);
        pst.setString(8, cedula);
        pst.executeUpdate();
        /*
        System.out.println("Correo");
        String statement = "INSERT INTO correoVet(usuario, correo) value (" + correo + ")";
        PreparedStatement pst2 = conexion.prepareStatement(statement);
        pst2.executeUpdate();

        statement = "INSERT INTO telVet(usuario, correo) value (" + telefono + ")";
        PreparedStatement pst3 = conexion.prepareStatement(statement);
        pst3.executeUpdate();*/

    }

    public static double utilidadCitas() throws SQLException {
        String statement = "select ganadocitas()";
        PreparedStatement pst = conexion.prepareStatement(statement);
        ResultSet rst = pst.executeQuery();
        rst.next();
        DecimalFormat df = new DecimalFormat("0.00");
        return Double.parseDouble(df.format(rst.getDouble(1)));
    }

    public static double pagoVets() throws SQLException {

        String statement = "select pagoVets()";
        PreparedStatement pst = conexion.prepareStatement(statement);
        ResultSet rst = pst.executeQuery();
        rst.beforeFirst();
        rst.next();

        return rst.getDouble(1);
    }
    
    public static String citaSolicitada() throws SQLException{
        String statement = "select citamassolicitada()";
        PreparedStatement pst = conexion.prepareStatement(statement);
        ResultSet rst = pst.executeQuery();
        rst.beforeFirst();
        rst.next();
        
        return rst.getString(1);
    }
}
