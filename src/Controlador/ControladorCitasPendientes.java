/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Excepciones.CitasException;
import Excepciones.ClientesExcepciones;
import Excepciones.UserNotFound;
import Modelo.DAO.daoCitas;
import Modelo.DAO.daoVeterinarios;
import Modelo.VO.Cita;
import Modelo.VO.Veterinario;
import Vista.VistaCitasPendientes;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import static java.util.stream.DoubleStream.builder;

/**
 *
 * @author danii
 */
public class ControladorCitasPendientes {

    static daoVeterinarios daoVeterinarios = new daoVeterinarios();
    static Veterinario veterinarioActual;
    static VistaCitasPendientes citasp;

    public static void mostrarVentana() throws CitasException, SQLException, ClientesExcepciones, UserNotFound {
        ArrayList<Cita> lista = daoCitas.listaCitas();
        if (!lista.isEmpty()) {
            veterinarioActual = ControladorMenuVet.veterinarioActual;
            citasp = new VistaCitasPendientes();
            citasp.setVisible(true);
            citasp.getArea().setText(mostrarCitasVeterinarios());
        } else {
            throw new CitasException("No hay citas que mostrar");
        }

    }

    public static void setVeterinarioActual(Veterinario veterinarioActual) {
        veterinarioActual = veterinarioActual;
    }

    public static String mostrarCitasVeterinarios() throws SQLException, ClientesExcepciones, UserNotFound {
        ArrayList<Cita> lista = daoCitas.listaCitas();
        StringBuilder builder = new StringBuilder();
        if (veterinarioActual != null) {
            builder.append("Veterinario:      ").append(veterinarioActual.getUsuario()).append("\n");
            builder.append("Citas:          \n");
            for (Cita cita : lista) {
                if (cita.getEstatus() == 'P') {
                    builder.append("Cliente: ").append(cita.getCliente().getNombre()).append(" | Mascota: ").append(cita.getNomMascota()).append(" | Fecha: ").append(cita.getFecha().toString()).append("-\n");
                }
            }
            builder.append("-\n");
        } else {
            builder.append("No se ha seleccionado un veterinario");
        }
        return builder.toString();
    }

}
