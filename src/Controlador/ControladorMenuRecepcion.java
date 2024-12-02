package Controlador;

import Vista.VistaMenuRecepcion;

public class ControladorMenuRecepcion {

    static VistaMenuRecepcion vistaRecepcion = new VistaMenuRecepcion();
    static boolean confirmacion;

    public static void mostrarVentana() {
        vistaRecepcion.setVisible(true);
    }

    public static void salir() {
        System.exit(0);
    }

    public static void cerrarSesion() {
        //AGREGAR CODIGO PARA CUANDO ESTE LISTO LOS LOGIN
    }

    public static void registrarCliente() {

    }

    public static void agendarCitaRec() {
        //Preguntar si tiene cuenta
        ControladorAgendarRecepcion.mostrarVentana();
        
    }
    
    public static void setConfirmacion(boolean valor){
        confirmacion = valor;
    }

}
