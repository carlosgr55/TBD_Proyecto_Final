package Modelo.DAO;

import Conexion.Conexion;
import Excepciones.ClientesExcepciones;
import Modelo.VO.Cliente;
import java.util.ArrayList;
import java.sql.*;

public class daoClientes {

    private final static Connection conexion = Conexion.getConexion("cliente", "cliente123");

    public static void agregarCliente(Cliente cliente) throws SQLException {
        String usuario = cliente.getUsuario();
        String password = cliente.getPassword();
        String nombre = cliente.getNombre();
        String apellido = cliente.getApellido();
        String telefono = cliente.getTelefono();
        String correo = cliente.getCorreo();
        /* String statement = "INSERT INTO clientes (usuario, password, nombre,"
                + "apellido, telefono, correo)"
                + "VALUES (?,?,?,?)";

        PreparedStatement pst = conexion.prepareStatement(statement);
        pst.setString(1, usuario);
        pst.setString(2, password);
        pst.setString(3, nombre);
        pst.setString(4, apellido);
        pst.executeUpdate();

        statement = "INSERT INTO telcliente(usuario, telefono) value (" + usuario + ", " + telefono + ")";
        PreparedStatement pst2 = conexion.prepareStatement(statement);
        pst2.executeUpdate();

        statement = "INSERT INTO correocliente(usuario, correo) value (" + usuario + ", " + correo + ")";
        PreparedStatement pst3 = conexion.prepareStatement(statement);
        pst3.executeUpdate();*/
        String statement = "call crearcliente(?,?,?,?,?,?)";
        PreparedStatement pst = conexion.prepareStatement(statement);
        pst.setString(1, usuario);
        pst.setString(2, password);
        pst.setString(3, nombre);
        pst.setString(4, apellido);
        pst.setString(5, correo);
        pst.setString(6, telefono);
        pst.executeUpdate();

    }

    public static boolean existe(String user) throws SQLException {
        PreparedStatement pst = conexion.prepareStatement("SELECT * FROM clientes where usuario= '" + user + "'");
        ResultSet rst = pst.executeQuery();
        return rst.next();
    }

    public static Cliente consulta(String user) throws SQLException, ClientesExcepciones {
        Cliente cliente = null;
        PreparedStatement pst = conexion.prepareStatement("SELECT a.*, b.correo, c.telefono FROM clientes a inner join correoCliente b on "
                + "b.usuario = a.usuario inner join telcliente c on a.usuario = c.usuario WHERE a.usuario ='" + user.trim() + "'");
        ResultSet rst = pst.executeQuery();
        if (rst.next()) {
            String usuario = rst.getString("usuario");
            String password = rst.getString("password");
            String nombre = rst.getString("nombre");
            String apellido = rst.getString("apellido");
            String telefono = rst.getString("c.telefono");
            String correo = rst.getString("b.correo");
            cliente = new Cliente(usuario, password, nombre, apellido, telefono, correo);
            return cliente;
        } else {
            throw new ClientesExcepciones("Cliente no existe");
        }
    }

    public static void borrar(String user) throws SQLException {
        PreparedStatement pst = conexion.prepareStatement("DELETE FROM clientes WHERE usuario = '" + user + "'");
        pst.executeUpdate();
    }

    public static void modificar(Cliente clienteNuevo, String user) throws SQLException {
        String usuario = clienteNuevo.getUsuario();
        String password = clienteNuevo.getPassword();
        String nombre = clienteNuevo.getNombre();
        String apellido = clienteNuevo.getApellido();
        String telefono = clienteNuevo.getTelefono();
        String correo = clienteNuevo.getCorreo();
        String statement = "UPDATE clientes "
                + "SET usuario = ?, password = ?, nombre = ?, apellido = ?, telefono = ?, correo = ? "
                + "WHERE usuario = ?;";

        PreparedStatement pst = conexion.prepareStatement(statement);
        pst.setString(1, usuario);
        pst.setString(2, password);
        pst.setString(3, nombre);
        pst.setString(4, apellido);
        pst.setString(5, telefono);
        pst.setString(6, correo);
        pst.setString(7, user);

        pst.executeUpdate();
    }

}
