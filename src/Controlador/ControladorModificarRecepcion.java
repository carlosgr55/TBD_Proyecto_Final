/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Excepciones.RecepcionException;
import Excepciones.UserNotFound;
import Modelo.DAO.daoRecepcion;
import Modelo.Logica.LogicaRecepcion;
import Modelo.VO.Recepcion;
import Vista.VistaModificarCita;
import Vista.VistaModificarRecepcion;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gambo
 */
public class ControladorModificarRecepcion {

    static LogicaRecepcion logicaRecep = new LogicaRecepcion();
    static VistaModificarRecepcion vistaMod;
    static ArrayList<Recepcion> listaRecepcion;
    static char estado = 'v'; //V de ver datos, M de modificar, A de anadir

    public static void mostrarVentana() throws SQLException {
        listaRecepcion = daoRecepcion.lista();
        vistaMod = new VistaModificarRecepcion();
        popularCombo();
        vistaMod.setVisible(true);
        evento();
    }

    public static void popularCombo() {
        int total = listaRecepcion.size();
        for (int i = 0; i < total; i++) {
            String user = listaRecepcion.get(i).getUser();
            vistaMod.getComb_recepcion().addItem(user);
        }
    }

    public static void limpiarCombo() {
        int total = vistaMod.getComb_recepcion().getItemCount();
        for (int i = 0; i < total; i++) {
            vistaMod.getComb_recepcion().remove(i);
        }
    }

    public static void modificar() {
        habilitarCampos(true, true, true, true, true, true, true);
        vistaMod.getComb_recepcion().setEnabled(false);
        habilitarBotones(true, false, false, false, true);
    }

    public static void evento() {
        try {
            llenarDatos();
        } catch (SQLException ex) {
            System.out.println("Database error" + ex.getMessage());
        } catch (UserNotFound ex) {
            Logger.getLogger(ControladorModificarRecepcion.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static char getEstado() {
        return estado;
    }

    public static void setEstado(char estado) {
        ControladorModificarRecepcion.estado = estado;
    }

    public static void regresar() {
        vistaMod.setVisible(false);
        ControladorMenuAdmi.mostrarVentana();
    }

    public static void addUsuario() {
        vistaMod.setVisible(false);
        ControladorRegistrarRecepcion.mostrarVentan();

    }

    public static void guardarCambios() throws SQLException, RecepcionException {
        Recepcion nuevo = crearRecepcion();
        String antiguo = (String) vistaMod.getComb_recepcion().getSelectedItem();

        if (logicaRecep.modificarRecepcion(antiguo, nuevo)) {
            vistaMod.setVisible(false);
            mostrarVentana();
        } else {
            JOptionPane.showConfirmDialog(vistaMod, "No se pudo modificar");
        }

    }

    public static void eliminar() throws SQLException {
        int input = JOptionPane.showConfirmDialog(vistaMod, "Deseas borrar a " + vistaMod.getTxt_nombre().getText());
        if (input == 0) {
            String receAEliminar = (String) vistaMod.getComb_recepcion().getSelectedItem();
            daoRecepcion.borrar(receAEliminar);
            vistaMod.setVisible(false);
            vistaMod.dispose();
            mostrarVentana();
        }
    }

    public static Recepcion crearRecepcion() {
        String nombre = vistaMod.getTxt_nombre().getText();
        String apellido = vistaMod.getTxt_apellido().getText();
        String correo = vistaMod.getTxt_correo().getText();
        String telefono = vistaMod.getTxt_telefono().getText();
        String usuario = vistaMod.getTxt_user().getText();
        String password = vistaMod.getTxt_password().getText();
        double sueldo = (double) vistaMod.getSpin_sueldo().getValue();
        Recepcion nuevo = new Recepcion(usuario, password, sueldo, nombre, apellido, telefono, correo);
        return nuevo;
    }

    public static void addUser(String user) {
        vistaMod.getComb_recepcion().addItem(user);
        vistaMod.getComb_recepcion().setSelectedItem(user);
    }

    public static void limpiarCampos() {
        vistaMod.getTxt_nombre().setText("");
        vistaMod.getTxt_apellido().setText("");
        vistaMod.getTxt_correo().setText("");
        vistaMod.getTxt_telefono().setText("");
        vistaMod.getTxt_user().setText("");
        vistaMod.getTxt_password().setText("");
        vistaMod.getSpin_sueldo().setValue(0);
    }

    public static void llenarDatos() throws SQLException, UserNotFound {
        String user = (String) vistaMod.getComb_recepcion().getSelectedItem();
        Recepcion recep = daoRecepcion.consulta(user);
        vistaMod.getTxt_nombre().setText(recep.getNombre());
        vistaMod.getTxt_apellido().setText(recep.getApellido());
        vistaMod.getTxt_correo().setText(recep.getCorreo());
        vistaMod.getTxt_telefono().setText(recep.getTelefono());
        vistaMod.getTxt_user().setText(recep.getUser());
        vistaMod.getTxt_password().setText(recep.getPassword());
        vistaMod.getSpin_sueldo().setValue(recep.getSueldo());

    }

    public static void habilitarCampos(boolean nom, boolean ap, boolean correo, boolean tel, boolean sueldo, boolean user, boolean pass) {
        vistaMod.getTxt_nombre().setEditable(nom);
        vistaMod.getTxt_apellido().setEditable(ap);
        vistaMod.getTxt_correo().setEditable(correo);
        vistaMod.getTxt_telefono().setEditable(tel);
        vistaMod.getTxt_user().setEditable(user);
        vistaMod.getTxt_password().setEditable(pass);
        vistaMod.getSpin_sueldo().setEnabled(sueldo);
    }

    public static void habilitarBotones(boolean guardar, boolean add, boolean mod, boolean eliminar, boolean reg) {
        vistaMod.getBtn_add().setEnabled(add);
        vistaMod.getBtn_eliminar().setEnabled(eliminar);
        vistaMod.getBtn_modificar().setEnabled(mod);
        vistaMod.getBtn_regresar().setEnabled(reg);
        vistaMod.getBtn_guardar().setEnabled(guardar);

    }

}
