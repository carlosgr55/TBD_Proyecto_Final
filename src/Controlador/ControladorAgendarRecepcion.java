/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Excepciones.CitasException;
import Excepciones.ClientesExcepciones;
import Excepciones.UserNotFound;
import Modelo.Componentes.FechaIsNull;
import Modelo.DAO.daoClientes;
import Modelo.DAO.daoMascotas;
import Modelo.DAO.daoVeterinarios;
import Modelo.Logica.LogicaCitas;
import Modelo.Logica.LogicaClientes;
import Modelo.Logica.LogicaVeterinario;
import Modelo.VO.Cita;
import Modelo.VO.Cliente;
import Modelo.VO.Mascota;
import Modelo.VO.Veterinario;
import Vista.VistaAgendarCita;
import Vista.VistaAgendarRecepcion;
import java.awt.Color;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gambo
 */
public class ControladorAgendarRecepcion {

    static VistaAgendarRecepcion vistaAgeRec = new VistaAgendarRecepcion();
    static boolean usuarioValido = false;
    static daoClientes clientesdao = ControladorInicioSesion.getDao();
    static LogicaVeterinario logicaVeterinario = new LogicaVeterinario();
    static LogicaClientes logicaCliente = new LogicaClientes();
    static LogicaCitas logicaCitas = new LogicaCitas();

    public static void mostrarVentana() {
        vistaAgeRec.getBtn_siguiente().setEnabled(false);
        vistaAgeRec.getLb_mensaje().setVisible(false);
        vistaAgeRec.setVisible(true);
    }

    public static void verificarUsuario(String txt) throws SQLException, ClientesExcepciones {
        vistaAgeRec.getLb_mensaje().setVisible(true);
        if (!logicaCliente.existe(txt)) {
            vistaAgeRec.getBtn_siguiente().setEnabled(false);
            vistaAgeRec.getLb_mensaje().setText("El cliente no existe");
            limpiarDatos();

        } else {
            Cliente cliente = daoClientes.consulta(txt);
            vistaAgeRec.getLb_mensaje().setText("ENCONTRADDE");
            llenarDatos(cliente);
            evento();
            habilitar(true, true, true);
            vistaAgeRec.getBtn_siguiente().setEnabled(true);
        }
    }

    public static void limpiarDatos() {
        try {
            vistaAgeRec.getTxt_nombre().setText("");
            limpiarCombo();
            limpiarMascotas();
            habilitar(false, false, false);
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("EXCEPCION INDEX OUT OF BOUND");
        }
    }

    public static void limpiarMascotas() throws ArrayIndexOutOfBoundsException {
        int total = vistaAgeRec.getComb_mascotas().getItemCount();
        for (int i = 0; i < total; i++) {
            vistaAgeRec.getComb_mascotas().removeItemAt(i);
        }
    }

    public static void regresar() {
        ControladorMenuRecepcion.mostrarVentana();
        vistaAgeRec.setVisible(false);
        vistaAgeRec.dispose();
    }

    public static void llenarDatos(Cliente cliente) {
        vistaAgeRec.getTxt_nombre().setText(cliente.getNombre() + " " + cliente.getApellido());
        popularMascotas(cliente);
        habilitar(true, true, true);
    }

    public static void popularMascotas(Cliente cliente) {
        try {
            ArrayList<Mascota> lista = daoMascotas.listaMascotasCliente(cliente.getUsuario());
            for (Mascota mascota : lista) {
                vistaAgeRec.getComb_mascotas().addItem(mascota.getNombre());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void habilitar(boolean mascotas, boolean tipo, boolean fecha) {
        vistaAgeRec.getComb_mascotas().setEnabled(mascotas);
        vistaAgeRec.getComb_tipo().setEnabled(tipo);
        vistaAgeRec.getSelecFecha1().setEnabled(fecha);
    }

    public static void evento() {
        String tipo = (String) vistaAgeRec.getComb_tipo().getSelectedItem();

        switch (tipo) {
            case "Estetico":
                vistaAgeRec.getComb_estetico().setVisible(true);
                vistaAgeRec.getLb_estetico().setVisible(true);
                break;
            case "Revision":
                vistaAgeRec.getComb_estetico().setVisible(false);
                vistaAgeRec.getLb_estetico().setVisible(false);
                break;
            case "Vacunacion":
                vistaAgeRec.getComb_estetico().setVisible(false);
                vistaAgeRec.getLb_estetico().setVisible(false);
                break;
            case "Esterelizacion":
                vistaAgeRec.getComb_estetico().setVisible(false);
                vistaAgeRec.getLb_estetico().setVisible(false);
                break;
        }

    }

    public static Cita crearCita() throws FechaIsNull, SQLException, ClientesExcepciones, CitasException, UserNotFound {
        Cliente cliente = daoClientes.consulta(vistaAgeRec.getTxt_usuario().getText().trim());
        LocalDateTime fecha = vistaAgeRec.getSelecFecha1().getFechaHora();
        String mascota = (String) vistaAgeRec.getComb_mascotas().getSelectedItem();
        String tipo = (String) vistaAgeRec.getComb_tipo().getSelectedItem();
        Cita cita = logicaCitas.crearCita(cliente, mascota, tipo, fecha);
        return cita;
    }

    public static void limpiarCombo() {
        int total = vistaAgeRec.getSelecFecha1().getCombo_fecha().getItemCount();
        for (int i = 0; i < total; i++) {
            vistaAgeRec.getSelecFecha1().getCombo_fecha().removeItemAt(0);
        }
    }

    public static void mensaje(String msg) {
        vistaAgeRec.getLb_mensaje().setVisible(true);
        vistaAgeRec.getLb_mensaje().setText(msg);
        vistaAgeRec.getLb_mensaje().setForeground(Color.red);
    }

}
