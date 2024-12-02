package Controlador;

import Excepciones.ClientesExcepciones;
import Modelo.DAO.daoClientes;
import Modelo.Logica.LogicaClientes;
import Modelo.VO.Cliente;
import Vista.VistaInicioSesion;
import java.awt.Color;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class ControladorInicioSesion {

    static VistaInicioSesion vInicio = new VistaInicioSesion();
    static ControladorCrearCuenta crearCuenta;
    static daoClientes dao = new daoClientes();
    static LogicaClientes logica = new LogicaClientes();

    public static void mostrarVentana() {
        vInicio.setVisible(true);
    }

    public static void registro() {

        crearCuenta.mostrarVentana();
        vInicio.setVisible(false);
    }

    public static void iniciarSesion() throws SQLException, ClientesExcepciones {
        String user = vInicio.getTxt_usuario().getText();
        String password = vInicio.getTxt_password().getText();
        if (logica.existe(user)) {
            mensaje("El cliente existe");
            Cliente cliente = dao.consulta(user);
            accesar(user, password, cliente);
        } else {
            mensaje("Nombre de usuario no encontrado");
        }

    }

    private static void accesar(String user, String password, Cliente cliente) {
        boolean acceso = logica.accesoValido(user, password, cliente);
        if (acceso) {
            mensaje("Acceso valido");
            ControladorMenuInicio.setClienteActual(cliente);
            ControladorMenuInicio.mostraVentana();
            vInicio.dispose();
        } else {
            mensaje("Contraseña invalida intente de nuevo");
        }
    }

    private static void mensaje(String msg) {
        JLabel label = vInicio.getLbl_auxiliar();
        label.setText(msg);
        vInicio.setLbl_auxiliar(label);
        vInicio.getLbl_auxiliar().setVisible(true);
    }

    public static daoClientes getDao() {
        return dao;
    }

    public static void setDao(daoClientes dao) {
        ControladorInicioSesion.dao = dao;
    }

}
