/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Excepciones.VeterinarioException;
import Modelo.Logica.LogicaVeterinario;
import Modelo.VO.Veterinario;
import Vista.VistaAgregarVet;
import java.sql.SQLException;

/**
 *
 * @author gambo
 */
public class ControladorAgregarVet {

    static VistaAgregarVet vistaAgregar;
    static LogicaVeterinario logica = new LogicaVeterinario();

    public static void mostrarVentana() {
        vistaAgregar = new VistaAgregarVet();
        vistaAgregar.setVisible(true);

    }

    public static void agregarVet() throws SQLException, VeterinarioException {
        // TODO add your handling code here:
        String nombre = vistaAgregar.getTxt_Nombre().getText();
        String apellido = vistaAgregar.getTxt_Apellido().getText();
        String telefono = vistaAgregar.getTxt_Telefono().getText();
        String cedula = vistaAgregar.getTxt_Cedula().getText();
        String usuario = vistaAgregar.getTxt_Usuario().getText();
        String password = vistaAgregar.getTxt_Password().getText();
        String correo = vistaAgregar.getTxt_Correo().getText();
        double sueldo = (double) vistaAgregar.getTxt_sueldo().getValue();

        Veterinario nuevoVeterinario = new Veterinario(cedula, sueldo, usuario, password, nombre, apellido, telefono, correo);
        logica.agregarVeterinario(nuevoVeterinario);
    }

    public static void limpiar() {
        vistaAgregar.getTxt_Nombre().setText("");
        vistaAgregar.getTxt_Apellido().setText("");
        vistaAgregar.getTxt_Cedula().setText("");
        vistaAgregar.getTxt_Password().setText("");
        vistaAgregar.getTxt_Correo().setText("");
        vistaAgregar.getTxt_Usuario().setText("");
        vistaAgregar.getTxt_sueldo().setValue(0);
        vistaAgregar.getTxt_Telefono().setText("");
    }

    public static void regresar() {
        vistaAgregar.setVisible(false);
        ControladorDatosVet.mostrarVentana();
        vistaAgregar.dispose();
    }

}
