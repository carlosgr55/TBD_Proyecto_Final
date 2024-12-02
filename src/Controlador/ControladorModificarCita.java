package Controlador;

import Excepciones.CitasException;
import Excepciones.ClientesExcepciones;
import Excepciones.UserNotFound;
import Modelo.Componentes.FechaIsNull;
import Modelo.DAO.daoCitas;
import Modelo.Logica.LogicaCitas;
import Modelo.Logica.LogicaVeterinario;
import Modelo.VO.Cita;
import Modelo.VO.Cliente;
import Modelo.VO.Veterinario;
import Vista.VistaModificarCita;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

public class ControladorModificarCita {

    static VistaModificarCita vistaMod = new VistaModificarCita();
    static LogicaVeterinario logicaVeterinario = new LogicaVeterinario();
    static LogicaCitas logicaCita = new LogicaCitas();
    static JTable tabla = ControladorVerCitas.getTabla();
    static int fila = tabla.getSelectedRow();
    static String id = (String) tabla.getValueAt(fila, 0);
    static Cita cita;

    public static void mostrarVentana() throws SQLException, CitasException, ClientesExcepciones, UserNotFound {
        vistaMod.setVisible(true);
        cita = daoCitas.consulta(id);
        mostrarDatos();
    }

    public static void mostrarDatos() {
        evento();
        vistaMod.getTxt_nomMascota().setText(cita.getNomMascota());
        vistaMod.getComb_tipo().setSelectedItem(cita.getTipo());

    }

    public static void modificar() throws FechaIsNull, SQLException, CitasException, UserNotFound {
        String idMod = cita.getId();
        Cliente cliente = cita.getCliente();
        String tipo = (String) vistaMod.getComb_tipo().getSelectedItem();
        String mascota = (String) vistaMod.getTxt_nomMascota().getText().trim();
        LocalDateTime fecha = vistaMod.getSelecFecha1().getFechaHora();

        Cita citaNueva = logicaCita.crearCita(cliente, mascota, tipo, fecha);
        daoCitas.modificar(citaNueva, idMod);

    }

    public static void evento() {
        String tipo = (String) vistaMod.getComb_tipo().getSelectedItem();

        switch (tipo) {
            case "Estetico":
                vistaMod.getComb_estetico().setVisible(true);
                vistaMod.getLb_estetico().setVisible(true);
                break;
            case "Revision":
                vistaMod.getComb_estetico().setVisible(false);
                vistaMod.getLb_estetico().setVisible(false);
                break;
            case "Vacunacion":
                vistaMod.getComb_estetico().setVisible(false);
                vistaMod.getLb_estetico().setVisible(false);
                break;
            case "Esterelizacion":
                vistaMod.getComb_estetico().setVisible(false);
                vistaMod.getLb_estetico().setVisible(false);
                break;
        }

    }

}
