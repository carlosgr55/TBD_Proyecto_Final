/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import static Controlador.ControladorCancelarCliente.clienteActual;
import static Controlador.ControladorCancelarCliente.vistaCanClie;
import Excepciones.CitasException;
import Excepciones.ClientesExcepciones;
import Excepciones.UserNotFound;
import Modelo.DAO.daoCitas;
import Modelo.VO.Cita;
import Modelo.VO.Veterinario;
import Vista.VistaSelectorCita;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gambo
 */
public class ControladorSelecCita {

    static VistaSelectorCita vistaSelec;
    static Veterinario vetActual;

    public static void mostrarVentana() throws CitasException, SQLException, ClientesExcepciones, UserNotFound {
        ArrayList<Cita> lista = daoCitas.listaCitas();
        vetActual = ControladorMenuVet.getVet();
        if (!hayCitasPendientes()) {
            throw new CitasException("No hay citas que mostrar");
        } else {
            vistaSelec = new VistaSelectorCita();
            vistaSelec.setVisible(true);
            popularCombo();
            mensaje();
        }
    }

    public static boolean hayCitasPendientes() {
        int contador = 0;
        try {
            ArrayList<Cita> lista = daoCitas.listaCitasPendienteVet(vetActual.getUsuario());

            for (Cita cita : lista) {
                if (cita.getEstatus() == 'P') {
                    contador++;
                }
            }

        } catch (SQLException ex) {
            System.out.println("SQL EX " + ex.getMessage());
        } catch (ClientesExcepciones ex) {
        } catch (UserNotFound ex) {
        }
        return contador != 0;
    }

    public static int contarCitas() throws SQLException, ClientesExcepciones, UserNotFound {
        ArrayList<Cita> lista = daoCitas.listaCitas();
        int total = 0;
        for (Cita cita : lista) {
            if (cita.getEstatus() == 'P') {
                total++;
            }
        }
        return total;
    }

    public static void mensaje() {
        vistaSelec.getLb_aux().setText("Hola, " + vetActual.getNombre());
    }

    public static void atenderCita() throws SQLException, CitasException, ClientesExcepciones, UserNotFound {
        Cita citaActual = daoCitas.consulta((String) vistaSelec.getCombo_citas().getSelectedItem());
        ControladorAtenderCita.setCitaActual(citaActual);
        ControladorAtenderCita.mostrarVentana();

    }

    public static void regresar() {
        vistaSelec.setVisible(false);
        ControladorMenuVet.setVeterinarioActual(vetActual);
        ControladorMenuVet.mostrarVentana(true);
    }

    public static void popularCombo() {
        try {
            ArrayList<Cita> lista = daoCitas.listaCitasPendienteVet(vetActual.getUsuario());
            for (Cita cita : lista) {
                vistaSelec.getCombo_citas().addItem(cita.getId());
            }

        } catch (SQLException ex) {
            System.out.println("SQL EX " + ex.getMessage());
        } catch (ClientesExcepciones ex) {
        } catch (UserNotFound ex) {
        }
    }

    public static void llenarDatos() throws SQLException, CitasException, ClientesExcepciones, UserNotFound {
        Cita cita = daoCitas.consulta((String) vistaSelec.getCombo_citas().getSelectedItem());
        vistaSelec.getTxt_cliente().setText(cita.getCliente().getNombre());
        vistaSelec.getTxt_mascota().setText(cita.getNomMascota());
        vistaSelec.getTxt_motivo().setText(cita.getTipo());
    }

}
