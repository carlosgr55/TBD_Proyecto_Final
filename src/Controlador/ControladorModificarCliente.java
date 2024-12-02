package Controlador;

import Excepciones.ClientesExcepciones;
import Modelo.DAO.daoClientes;
import Modelo.Logica.LogicaClientes;
import Modelo.VO.Cliente;
import Vista.VistaModificarCliente;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControladorModificarCliente {
    
    static VistaModificarCliente vistaModificar = new VistaModificarCliente();
    static Cliente clienteActual = ControladorMenuInicio.getClienteActual();
    static LogicaClientes logicaCliente = new LogicaClientes();
    
    public static void mostrarVentana() {
        vistaModificar.setVisible(true);
        mostrarDatos();
    }
    
    public static void regresar(String usuario) throws SQLException, ClientesExcepciones {
        Cliente cliente = daoClientes.consulta(usuario);
        ControladorMenuInicio.mostrarVentana(cliente);
    }
    
    public static void mostrarDatos() {
        vistaModificar.getTxt_nombre().setText(clienteActual.getNombre());
        vistaModificar.getTxt_apellido().setText(clienteActual.getApellido());
        vistaModificar.getTxt_correo().setText(clienteActual.getCorreo());
        vistaModificar.getTxt_telefono().setText(clienteActual.getTelefono());
        vistaModificar.getTxt_user().setText(clienteActual.getUsuario());
        vistaModificar.getTxt_password().setText(clienteActual.getPassword());
    }
    
    public static void actualizarDatos() throws SQLException, ClientesExcepciones {
        String usuariorAnterior = clienteActual.getUsuario();
        String nombre = vistaModificar.getTxt_nombre().getText().trim();
        String apellido = vistaModificar.getTxt_apellido().getText().trim();
        String correo = vistaModificar.getTxt_correo().getText().trim();
        String telefono = vistaModificar.getTxt_telefono().getText().trim();
        String usuario = vistaModificar.getTxt_user().getText().trim();
        String password = vistaModificar.getTxt_password().getText().trim();
        Cliente nuevo = new Cliente(usuario, password, nombre, apellido, telefono, correo);
        
        if (logicaCliente.modificar(usuariorAnterior, nuevo)) {
            regresar(nuevo.getUsuario());
        } else {
            JOptionPane.showMessageDialog(vistaModificar, "NO HUBO MODIFICACION");
        }
        
    }
    
    public static void eliminarCuenta() throws SQLException {
        String password = JOptionPane.showInputDialog(null, "Ingresa tu contraseña");
        if (password.equals(clienteActual.getPassword())) {
            eliminar();
        } else {
            JOptionPane.showMessageDialog(vistaModificar, "No se pudo eliminar la cuenta");
        }
    }
    
    private static void eliminar() throws SQLException {
        daoClientes.borrar(clienteActual.getUsuario());
        ControladorInicioSesion.mostrarVentana();
        vistaModificar.setVisible(false);
        vistaModificar.dispose();
        
    }
}
