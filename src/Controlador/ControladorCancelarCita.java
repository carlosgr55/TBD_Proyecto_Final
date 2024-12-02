package Controlador;

import Excepciones.CitasException;
import Excepciones.ClientesExcepciones;
import Excepciones.UserNotFound;
import Modelo.DAO.daoCitas;
import Modelo.VO.Cita;
import Modelo.VO.Veterinario;
import Vista.VistaCancelarCita;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorCancelarCita {

    static VistaCancelarCita vistaCancelar;
    static Veterinario vetActual;

    public static void mostrarVentana() throws CitasException, SQLException, ClientesExcepciones, UserNotFound {
        ArrayList<Cita> lista = daoCitas.listaCitas();
        if (lista.isEmpty() || contarCitas() == 0) {
            throw new CitasException("No hay citas que mostrar");
        } else {
            vistaCancelar = new VistaCancelarCita();
            vistaCancelar.setVisible(true);
            vetActual = ControladorMenuVet.getVet();
            popularCombo();
        }
    }

    public static void cancelarCita() throws SQLException {
        daoCitas.cancelarCita((String) vistaCancelar.getCombo_citas().getSelectedItem());
        vistaCancelar.getCombo_citas().removeItem((String) vistaCancelar.getCombo_citas().getSelectedItem());
        vistaCancelar.setVisible(false);
        try {
            mostrarVentana();
            vistaCancelar.setVisible(false);
        } catch (CitasException ex) {
            ControladorMenuVet.mostrarVentana(true);
        } catch (ClientesExcepciones ex) {
            ControladorMenuVet.mostrarVentana(true);
        } catch (UserNotFound ex) {
            ControladorMenuVet.mostrarVentana(true);
        }
    }

    public static int contarCitas() throws SQLException, ClientesExcepciones, UserNotFound {
        int total = 0;
        ArrayList<Cita> lista = daoCitas.listaCitas();
        for (Cita cita : lista) {
            if (cita.getEstatus() == 'P') {
                total++;
            }
        }

        return total;
    }

    

    public static void atenderCita() throws SQLException, CitasException, ClientesExcepciones, UserNotFound {
        Cita citaActual = daoCitas.consulta((String) vistaCancelar.getCombo_citas().getSelectedItem());
        ControladorAtenderCita.setCitaActual(citaActual);
        ControladorAtenderCita.mostrarVentana();
    }

    public static void regresar() {
        vistaCancelar.setVisible(false);
        ControladorMenuVet.setVeterinarioActual(vetActual);
        ControladorMenuVet.mostrarVentana(true);
    }

    public static void popularCombo() throws CitasException, SQLException, ClientesExcepciones, UserNotFound {
        ArrayList<Cita> lista = daoCitas.listaCitas();
        for (Cita cita : lista) {
            if (cita.getVet().getUsuario().equals(vetActual.getUsuario()) && cita.getEstatus() == 'P') {
                vistaCancelar.getCombo_citas().addItem(cita.getId());
            } else {
                throw new CitasException("No hay citas que mostrar");
            }
        }
    }

    public static void llenarDatos() throws CitasException, SQLException, ClientesExcepciones, UserNotFound {
        if (contarCitas() == 0) {
            throw new CitasException("No hay cita");
        } else {
            Cita cita = daoCitas.consulta((String) vistaCancelar.getCombo_citas().getSelectedItem());
            vistaCancelar.getTxt_cliente().setText(cita.getCliente().getNombre());
            vistaCancelar.getTxt_mascota().setText(cita.getNomMascota());
            vistaCancelar.getTxt_motivo().setText(cita.getTipo());
        }
    }

}
