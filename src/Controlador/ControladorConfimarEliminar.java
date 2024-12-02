package Controlador;

import Modelo.VO.Mascota;
import Vista.VistaConfirmarEliminar;
import java.awt.Dialog;
import javax.swing.JLabel;

public class ControladorConfimarEliminar {

    static VistaConfirmarEliminar vistaConfirmar;
    public static boolean confirmacion;
    private static Mascota mascota;

    public static void mostrarVentana(Dialog parent, boolean modal, Mascota mascot) {
        vistaConfirmar = new VistaConfirmarEliminar(parent, modal);
        llenarLbl(mascot);
        vistaConfirmar.setVisible(true);
    }

    public static void confirmar(boolean confirmar) {
        confirmacion = confirmar;
        vistaConfirmar.setVisible(false);
        vistaConfirmar.dispose();
    }

    public static void llenarLbl(Mascota pet) {
        JLabel label = vistaConfirmar.getLb_datos();
        label.setText(pet.getNombre());
        vistaConfirmar.setLb_datos(label);
    }
}
