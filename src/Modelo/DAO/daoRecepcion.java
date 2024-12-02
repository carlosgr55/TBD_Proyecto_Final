package Modelo.DAO;

import Conexion.Conexion;
import Excepciones.UserNotFound;
import Modelo.VO.Recepcion;
import Modelo.VO.Veterinario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class daoRecepcion {

    private final static Connection conexion = Conexion.getConexion("root", "Motomami55");

    public static void agregar(Recepcion recepcion) throws SQLException {
        String usuario = recepcion.getUser();
        String password = recepcion.getPassword();
        String nombre = recepcion.getNombre();
        String apellido = recepcion.getApellido();
        String telefono = recepcion.getTelefono();
        String correo = recepcion.getCorreo();
        double sueldo = recepcion.getSueldo();

        PreparedStatement pst = conexion.prepareStatement("INSERT INTO recepcionistas (usuario, password, "
                + "nombre, apellido, sueldo, telefono, correo) "
                + "VALUES (?,?,?,?,?,?,?)");
        pst.setString(1, usuario.trim());
        pst.setString(2, password.trim());
        pst.setString(3, nombre.trim());
        pst.setString(4, apellido.trim());
        pst.setDouble(5, sueldo);
        pst.setString(6, telefono.trim());
        pst.setString(7, correo.trim());
        pst.executeUpdate();
    }

    public static boolean existe(String user) throws SQLException {
        PreparedStatement pst = conexion.prepareStatement("SELECT * FROM recepcionistas where usuario= '" + user + "'");
        ResultSet rst = pst.executeQuery();
        return rst.next();
    }

    public static Recepcion consulta(String user) throws SQLException, UserNotFound {
        Recepcion recepcion = null;
        PreparedStatement pst = conexion.prepareStatement("SELECT * FROM recepcionistas WHERE usuario = '" + user.trim() + "'");
        ResultSet rst = pst.executeQuery();
        if (rst.next()) {
            String usuario = rst.getString("usuario");
            String password = rst.getString("password");
            String nombre = rst.getString("nombre");
            String apellido = rst.getString("apellido");
            String telefono = rst.getString("telefono");
            String correo = rst.getString("correo");
            double sueldo = rst.getDouble("sueldo");

            recepcion = new Recepcion(user, password, sueldo, nombre, apellido, telefono, correo);

            return recepcion;
        } else {
            throw new UserNotFound("Recepcion no encontrado");
        }
    }

    public static void borrar(String user) throws SQLException {
        PreparedStatement pst = conexion.prepareStatement("DELETE FROM recepcionistas WHERE usuario = '" + user + "'");
        pst.executeUpdate();
    }

    public static void modificar(Recepcion recepNuevo, String user) throws SQLException {
        String usuario = recepNuevo.getUser();
        String password = recepNuevo.getPassword();
        String nombre = recepNuevo.getNombre();
        String apellido = recepNuevo.getApellido();
        String telefono = recepNuevo.getTelefono();
        String correo = recepNuevo.getCorreo();
        double sueldo = recepNuevo.getSueldo();

        String statement = "UPDATE recepcionistas "
                + "SET usuario = ?, password = ?, nombre = ?, apellido = ?, telefono = ?, "
                + "correo = ?, sueldo = ?"
                + "WHERE usuario = ?;";

        PreparedStatement pst = conexion.prepareStatement(statement);
        pst.setString(1, usuario);
        pst.setString(2, password);
        pst.setString(3, nombre);
        pst.setString(4, apellido);
        pst.setString(5, telefono);
        pst.setString(6, correo);
        pst.setDouble(7, sueldo);
        pst.setString(8, user);

        pst.executeUpdate();
    }

    public static ArrayList<Recepcion> lista() throws SQLException {
        ArrayList<Recepcion> lista = new ArrayList<>();
        PreparedStatement pst = conexion.prepareStatement("SELECT * FROM recepcionistas");
        ResultSet rst = pst.executeQuery();

        while (rst.next()) {
            String usuario = rst.getString("usuario");
            String password = rst.getString("password");
            String nombre = rst.getString("nombre");
            String apellido = rst.getString("apellido");
            String telefono = rst.getString("telefono");
            String correo = rst.getString("correo");
            double sueldo = rst.getDouble("sueldo");
            lista.add(new Recepcion(usuario, password, sueldo, nombre, apellido, telefono, correo));
        }
        return lista;
    }
}
