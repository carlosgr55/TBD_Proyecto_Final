/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Excepciones.RecepcionException;
import Modelo.Logica.LogicaRecepcion;
import Modelo.VO.Recepcion;
import Vista.VistaRegistrarMascota;
import Vista.VistaRegistrarRecepcion;
import java.awt.Dialog;
import java.sql.SQLException;

public class ControladorRegistrarRecepcion {

    static VistaRegistrarRecepcion vistaRegistro;
    static LogicaRecepcion logica = new LogicaRecepcion();

    public static void mostrarVentan() {
        vistaRegistro = new VistaRegistrarRecepcion();
        vistaRegistro.setVisible(true);
    }

    public static Recepcion crearRecepcion() {
        String nombre = vistaRegistro.getTxt_nombre().getText();
        String apellido = vistaRegistro.getTxt_apellido().getText();
        String correo = vistaRegistro.getTxt_correo().getText();
        String telefono = vistaRegistro.getTxt_telefono().getText();
        String usuario = vistaRegistro.getTxt_user().getText();
        String password = vistaRegistro.getTxt_nombre().getText();
        double sueldo = (double) vistaRegistro.getSpin_sueldo().getValue();
        Recepcion nuevo = new Recepcion(usuario, password, sueldo, nombre, apellido, telefono, correo);
        return nuevo;
    }

    public static void guardarCambios() throws SQLException, RecepcionException {
        Recepcion recep = crearRecepcion();
        if (logica.agregarRecepcion(recep)) {
            vistaRegistro.setVisible(false);
            ControladorModificarRecepcion.mostrarVentana();
        }
    }

}
