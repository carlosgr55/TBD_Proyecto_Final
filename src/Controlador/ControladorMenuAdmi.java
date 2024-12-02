package Controlador;

import Modelo.DAO.daoVeterinarios;
import Modelo.VO.Veterinario;
import Vista.VistaMenuAdmin;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class ControladorMenuAdmi {

    private static VistaMenuAdmin vistaMenu = new VistaMenuAdmin();
    private static daoVeterinarios daoVet = new daoVeterinarios();

    public static void mostrarVentana() {
        vistaMenu.setVisible(true);
    }

    public static void salir() {
        System.exit(0);
    }

    

}
