package Controlador;

import Excepciones.DatosIncompletosException;
import Modelo.DAO.daoClientes;
import Modelo.Logica.LogicaClientes;
import Modelo.VO.Cliente;
import Vista.VistaCrearCuenta;
import java.awt.Color;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ControladorCrearCuenta {

    static VistaCrearCuenta vistaCrear;
    static LogicaClientes logica = new LogicaClientes();
    public static boolean esRecepcion = false;

    public static void mostrarVentana() {
        vistaCrear = new VistaCrearCuenta();
        vistaCrear.setVisible(true);
    }
    public static void mostrarVentana(boolean recep) {
        esRecepcion = recep;
        vistaCrear = new VistaCrearCuenta();
        vistaCrear.setVisible(true);
    }

    public static void regresar() {
        vistaCrear.setVisible(false);
        ControladorInicioSesion.mostrarVentana();
    }

    public static Cliente crearCliente() {
        String nombre = vistaCrear.getTxt_nombre().getText();
        String apellido = vistaCrear.getTxt_apellido().getText();
        String correo = vistaCrear.getTxt_correo().getText();
        String celular = vistaCrear.getTxt_celular().getText();
        String usuario = vistaCrear.getTxt_usuario().getText();
        String password = vistaCrear.getTxt_password().getText();

        Cliente cliente = new Cliente(usuario, password, nombre, apellido, celular, correo);
        return cliente;
    }

    public static boolean validarNumero() {
        boolean valido = false;
        String numero = vistaCrear.getTxt_celular().getText();
        if (logica.numeroValido(numero)) {
            valido = true;
        }
        return valido;
    }

    public static boolean addCliente(Cliente cliente) throws SQLException {
        boolean creado = false;
        boolean existe = logica.existe(cliente.getUsuario());
        if (!existe) {
            creado = true;
            logica.agregarCliente(cliente);
        }
        return creado;
    }

    public static void puedeUsarse(String txt) throws SQLException {
        if (!logica.existe(txt)) {
            vistaCrear.getLb_usAux().setVisible(true);
            vistaCrear.getLb_usAux().setText("Nombre de usuario disponible");
            vistaCrear.getLb_usAux().setForeground(Color.GREEN);
            vistaCrear.getBtn_crear().setEnabled(true);
        } else {
            vistaCrear.getLb_usAux().setVisible(true);
            vistaCrear.getLb_usAux().setText("Nombre de usuario NO disponible");
            vistaCrear.getLb_usAux().setForeground(Color.RED);
            vistaCrear.getBtn_crear().setEnabled(false);
        }
    }

   
}
