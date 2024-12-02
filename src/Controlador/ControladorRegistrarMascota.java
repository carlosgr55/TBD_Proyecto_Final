package Controlador;

import Modelo.Logica.LogicaClientes;
import Modelo.VO.Cliente;
import Modelo.VO.Mascota;
import Vista.VistaRegistrarMascota;
import java.awt.Menu;
import java.sql.SQLException;

public class ControladorRegistrarMascota {

    static VistaRegistrarMascota vistaRegistro;
    static Cliente cliente;
    static boolean esRecepcion = ControladorCrearCuenta.esRecepcion;
    static LogicaClientes logicaCliente = new LogicaClientes();

    public static void mostrarVentana() {
        vistaRegistro = new VistaRegistrarMascota();
        vistaRegistro.setVisible(true);
    }

    public static Cliente getCliente() {
        return cliente;
    }

    public static void setCliente(Cliente clienten) {
        cliente = clienten;
    }

    public static void registrar() throws SQLException {
        if (!esRecepcion) {
            logicaCliente.agregarMascota(crearMascota());
            vistaRegistro.setVisible(false);
            vistaRegistro.dispose();
            ControladorInicioSesion.mostrarVentana();

        } else {
            logicaCliente.agregarMascota(crearMascota());
            vistaRegistro.setVisible(false);
            ControladorMenuRecepcion.mostrarVentana();
            vistaRegistro.dispose();
        }

    }

    public static Mascota crearMascota() {
        String nombre = vistaRegistro.getTxt_nombre().getText();
        char sexo = getSexo();
        String especie = getEspecie();
        String clienteU = cliente.getUsuario();
        Mascota mascota = new Mascota(nombre, especie, sexo);
        mascota.setCliente(clienteU);
        return mascota;

    }

    public static String getEspecie() {
        return (String) vistaRegistro.getCombo_especie().getSelectedItem();
    }

    private static char getSexo() {
        if (vistaRegistro.getRb_macho().isSelected()) {
            return 'M';
        } else {
            return 'H';
        }
    }

}
