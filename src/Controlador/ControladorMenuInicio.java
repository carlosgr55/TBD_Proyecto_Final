package Controlador;

import Excepciones.CitasException;
import Excepciones.ClientesExcepciones;
import Excepciones.UserNotFound;
import Modelo.DAO.daoClientes;
import Modelo.DAO.daoMascotas;
import Modelo.VO.Cliente;
import Modelo.VO.Mascota;
import Vista.VistaMenuInicio;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.w3c.dom.ls.LSOutput;

public class ControladorMenuInicio {

    static VistaMenuInicio menu;
    static int index;
    private static Cliente clienteActual;

    public static void cerrar() {
        ControladorInicioSesion.mostrarVentana();
        menu.dispose();
        clienteActual = null;
    }

    public static void setClienteActual(Cliente cliente) {
        clienteActual = cliente;
    }

    public static void mostraVentana() {
        menu = new VistaMenuInicio();
        menu.setVisible(true);
        menu.getLbl_mensaje().setText("Hola, " + clienteActual.getNombre());
    }

    public static void mostrarVentana(Cliente cliente) {
        clienteActual = cliente;
        mostraVentana();
    }

    public static void salir() {
        System.exit(0);
    }

    public static Cliente getClienteActual() {
        return clienteActual;
    }

    public static void agendarCita() {
        try {
            ArrayList<Mascota> lista = daoMascotas.listaMascotasCliente(clienteActual.getUsuario());
            if (!lista.isEmpty()) {
                ControladorAgendarCita.mostrarVentanda();
            } else {
                JOptionPane.showMessageDialog(menu, "No hay mascotas registradas");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void setVisible(boolean estado) {
        menu.setVisible(estado);
    }

    public static void verCitas() throws CitasException, SQLException, ClientesExcepciones, UserNotFound {
        menu.setVisible(false);
        ControladorVerCitas.mostrarVentana(true);
    }

}
