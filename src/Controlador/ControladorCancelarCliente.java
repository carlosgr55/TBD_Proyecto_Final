/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Excepciones.CitasException;
import Excepciones.ClientesExcepciones;
import Excepciones.UserNotFound;
import Modelo.DAO.daoCitas;
import Modelo.VO.Cita;
import Modelo.VO.Cliente;
import Modelo.VO.Veterinario;
import Vista.VistaCancelarCita;
import Vista.VistaCancelarCliente;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author gambo
 */
public class ControladorCancelarCliente {

    static VistaCancelarCliente vistaCanClie;
    static Cliente clienteActual;

    public static void mostrarVentana() throws CitasException {
        clienteActual = ControladorMenuInicio.getClienteActual();

        if (!hayCitasPendientes()) {
            throw new CitasException("No hay citas que mostrar");
        } else {
            vistaCanClie = new VistaCancelarCliente();
            vistaCanClie.setVisible(true);
            popularCombo();
        }
    }

    public static void cancelarCita() throws CitasException, SQLException {
        String id = (String) vistaCanClie.getCombo_citas().getSelectedItem();
            daoCitas.cancelarCita(id);
        vistaCanClie.setVisible(false);

    }

    public static void popularCombo() {
        try {
            ArrayList<Cita> lista = daoCitas.listaCitasPendienteCliente(clienteActual.getUsuario());
            for (Cita cita : lista) {
                vistaCanClie.getCombo_citas().addItem(cita.getId());
            }

        } catch (SQLException ex) {
            System.out.println("SQL EX " + ex.getMessage());
        } catch (ClientesExcepciones ex) {
            Logger.getLogger(ControladorCancelarCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UserNotFound ex) {
            Logger.getLogger(ControladorCancelarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void error() {
        ControladorMenuInicio.mostraVentana();
        ControladorMenuInicio.setClienteActual(clienteActual);
    }

    public static void llenarDatos() throws CitasException {
        try {
            Cita cita = daoCitas.consulta((String) vistaCanClie.getCombo_citas().getSelectedItem());
            vistaCanClie.getTxt_mascota().setText(cita.getNomMascota());
            vistaCanClie.getTxt_cliente().setText(cita.getCliente().getUsuario());
            vistaCanClie.getTxt_motivo().setText(cita.getTipo());

        } catch (SQLException ex) {
            Logger.getLogger(ControladorCancelarCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClientesExcepciones ex) {
            Logger.getLogger(ControladorCancelarCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UserNotFound ex) {
            Logger.getLogger(ControladorCancelarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //Returns true si hay citas pendientes, returns false si no
    public static boolean hayCitasPendientes() {
        int contador = 0;
        try {
            ArrayList<Cita> lista = daoCitas.listaCitasCliente(clienteActual.getUsuario());

            for (Cita cita : lista) {
                if (cita.getEstatus() == 'P') {
                    contador++;
                }
            }

        } catch (SQLException ex) {
            System.out.println("SQL EX " + ex.getMessage());
        } catch (ClientesExcepciones ex) {
            Logger.getLogger(ControladorCancelarCliente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UserNotFound ex) {
            Logger.getLogger(ControladorCancelarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        return contador != 0;

    }

    public static Cliente getClienteActual() {
        return clienteActual;
    }

    public static void setClienteActual(Cliente clienteActual) {
        ControladorCancelarCliente.clienteActual = clienteActual;
    }

}
