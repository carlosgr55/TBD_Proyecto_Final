package Controlador;

import Excepciones.UserNotFound;
import Modelo.DAO.daoVeterinarios;
import Modelo.VO.Veterinario;
import Vista.VistaAgregarVet;
import Vista.VistaDatosVet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class ControladorDatosVet {

    private static VistaDatosVet vistaDatos;

    public static void mostrarVentana() {
        vistaDatos = new VistaDatosVet();
        vistaDatos.setVisible(true);
        cargarDatosVeterinarios();
    }

    public static void eliminarVeterinario(String nom) throws SQLException {
        daoVeterinarios.borrar(nom);
        vistaDatos.setVisible(false);
        mostrarVentana();
    }

    public static void agregarEspecialidad(Veterinario vet, String especialidad) {
        // Obtener el veterinario seleccionado        
        if (vet != null) {
            ArrayList<String> especialidades = vet.getEspecialidad();
            especialidades.add(especialidad);
            vet.setEspecialidad(especialidades);
            mostraDatos(vet);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha seleccionado ningún veterinario.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void regresar() {
        vistaDatos.setVisible(false);
        ControladorMenuAdmi.mostrarVentana();
        vistaDatos.dispose();
    }

    public static void agregarVeterinario(Veterinario nuevoVet, String nuevaEspecialidad) {
        nuevoVet.addEspecialidad(nuevaEspecialidad);
        cargarDatosVeterinarios();
        mostraDatos(nuevoVet);
    }

    public static void modificarDatos() {

    }

    public static void evento() throws SQLException, UserNotFound {
        Veterinario vet = daoVeterinarios.consulta((String) vistaDatos.getComboBoxVeterinarios().getSelectedItem());
    }

    public static void limpiar() {
        vistaDatos.getTxt_Nombre().setText("");
        vistaDatos.getTxt_Apellido().setText("");
        vistaDatos.getTxt_Cedula().setText("");
        vistaDatos.getTxt_Password().setText("");
        vistaDatos.getTxt_Correo().setText("");
        vistaDatos.getTxt_Usuario().setText("");
        vistaDatos.getTxt_Sueldo().setText("");
        vistaDatos.getTxt_Telefono().setText("");
    }

    public static void mostraDatos(Veterinario vet) {

        if (vet != null) {
            vistaDatos.getTxt_Nombre().setText(vet.getNombre());
            vistaDatos.getTxt_Apellido().setText(vet.getApellido());
            vistaDatos.getTxt_Cedula().setText(vet.getCedula());
            vistaDatos.getTxt_Correo().setText(vet.getCorreo());
            vistaDatos.getTxt_Usuario().setText(vet.getUsuario());
            vistaDatos.getTxt_Password().setText(vet.getPassword());
            vistaDatos.getTxt_Sueldo().setText(Double.toString(vet.getSueldo()));
            vistaDatos.getTxt_Telefono().setText(vet.getTelefono());

        } else {
            // Si el veterinario es null, limpiar todos los campos de texto
            vistaDatos.getTxt_Nombre().setText("");
            vistaDatos.getTxt_Apellido().setText("");
            vistaDatos.getTxt_Cedula().setText("");
            vistaDatos.getTxt_Password().setText("");
            vistaDatos.getTxt_Correo().setText("");
            vistaDatos.getTxt_Usuario().setText("");
            vistaDatos.getTxt_Sueldo().setText("");
            vistaDatos.getTxt_Telefono().setText("");
        }
    }

    public static void mostraDatosUltimoVet() throws SQLException, UserNotFound {
        Veterinario vet = daoVeterinarios.consulta((String) vistaDatos.getComboBoxVeterinarios().getSelectedItem());

        if (vet != null) {
            vistaDatos.getTxt_Nombre().setText(vet.getNombre());
            vistaDatos.getTxt_Apellido().setText(vet.getApellido());
            vistaDatos.getTxt_Cedula().setText(vet.getCedula());
            vistaDatos.getTxt_Correo().setText(vet.getCorreo());
            vistaDatos.getTxt_Usuario().setText(vet.getUsuario());
            vistaDatos.getTxt_Password().setText(vet.getPassword());
            vistaDatos.getTxt_Sueldo().setText(Double.toString(vet.getSueldo()));
            vistaDatos.getTxt_Telefono().setText(vet.getTelefono());

        } else {
            // Si el veterinario es null, limpiar todos los campos de texto
            vistaDatos.getTxt_Nombre().setText("");
            vistaDatos.getTxt_Apellido().setText("");
            vistaDatos.getTxt_Cedula().setText("");
            vistaDatos.getTxt_Password().setText("");
            vistaDatos.getTxt_Correo().setText("");
            vistaDatos.getTxt_Usuario().setText("");
            vistaDatos.getTxt_Sueldo().setText("");
            vistaDatos.getTxt_Telefono().setText("");
        }
    }

    public static void cargarDatosVeterinarios() {
        try {
            ArrayList<Veterinario> listaVeterinarios = daoVeterinarios.getVeterinarios();

            for (Veterinario veterinario : listaVeterinarios) {
                vistaDatos.getComboBoxVeterinarios().addItem(veterinario.getUsuario());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorDatosVet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void itemChanged() throws SQLException, UserNotFound {
        Veterinario vet = daoVeterinarios.consulta((String) vistaDatos.getComboBoxVeterinarios().getSelectedItem());
        mostraDatos(vet);

    }

    /*public static void mostrarDatosVeterinarioSeleccionado() {
    JComboBox<String> comboBoxVeterinarios = vistaDatos.getComboBoxVeterinarios();
    String nombreVeterinarioSeleccionado = (String) comboBoxVeterinarios.getSelectedItem();

    ArrayList<Veterinario> listaVeterinarios = repoVeterinarios.getLista();

}*/
}
