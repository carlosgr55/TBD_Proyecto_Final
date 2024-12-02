package Controlador;

import static Controlador.ControladorVerMascotas.listaMascota;
import static Controlador.ControladorVerMascotas.vistaMascota;
import Excepciones.CitasException;
import Excepciones.UserNotFound;
import Modelo.Componentes.FechaIsNull;
import Modelo.DAO.daoCitas;
import Modelo.DAO.daoMascotas;
import Modelo.DAO.daoVeterinarios;
import Modelo.Logica.LogicaCitas;
import Modelo.Logica.LogicaVeterinario;
import Modelo.VO.Cita;
import Modelo.VO.Cliente;
import Modelo.VO.Mascota;
import Modelo.VO.Veterinario;
import Vista.VistaAgendarCita;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.metal.MetalIconFactory;

public class ControladorAgendarCita {

    static VistaAgendarCita vistaAgendar;
    static LogicaCitas logicaCitas = new LogicaCitas();
    static LogicaVeterinario logicaVeterinario = new LogicaVeterinario();
    private static ArrayList<LocalDateTime> fechas = new ArrayList<>();
    static Cliente cliente;
    static ArrayList<Mascota> listaMascota;

    public static void popularCombo() {
        for (Mascota mascota : listaMascota) {
            String nombre = mascota.getNombre();
            vistaAgendar.getCombo_mascotas().addItem(nombre);
        }
    }

    public static void mostrarVentanda() throws SQLException {
        vistaAgendar = new VistaAgendarCita();
        cliente = ControladorMenuInicio.getClienteActual();
        listaMascota = daoMascotas.listaMascotasCliente(cliente.getUsuario());
        vistaAgendar.setVisible(true);
        evento();
        popularCombo();

    }

    public static void modificarVentana(Cita cita) {
        vistaAgendar.setVisible(true);
        String tipo = cita.getTipo();
        String mascota = cita.getNomMascota();
        String fecha = cita.getFecha().toString();
        vistaAgendar.getComb_tipo().setSelectedItem(tipo);
        popularCombo();
        vistaAgendar.getCombo_mascotas().setSelectedItem(mascota);
        evento();
        //vistaAgendar.getCombo_fechas().setSelectedItem(fecha);
    }

    public static void evento() {
        String tipo = (String) vistaAgendar.getComb_tipo().getSelectedItem();

        switch (tipo) {
            case "Estetico":
                vistaAgendar.getComb_estetico().setVisible(true);
                vistaAgendar.getLb_estetico().setVisible(true);
                break;
            case "Revision":
                vistaAgendar.getComb_estetico().setVisible(false);
                vistaAgendar.getLb_estetico().setVisible(false);
                break;
            case "Vacunacion":
                vistaAgendar.getComb_estetico().setVisible(false);
                vistaAgendar.getLb_estetico().setVisible(false);
                break;
            case "Esterelizacion":
                vistaAgendar.getComb_estetico().setVisible(false);
                vistaAgendar.getLb_estetico().setVisible(false);
                break;
        }

    }

    public static Veterinario getVeterinario() throws SQLException {
        Veterinario vet = null;
        String especialidad = getEspecialidad();
        //LocalDateTime hora = LocalDateTime.parse((String) vistaAgendar.getCombo_fechas().getSelectedItem());
        String hora = (String) vistaAgendar.getSelecFecha().getCombo_fecha().getSelectedItem();

        for (Veterinario vetAux : daoVeterinarios.getVeterinarios()) {

            boolean fechaDisponible = vetAux.getHorasDisponibles().contains(hora);
            boolean especialidadCorrecta = vetAux.getEspecialidad().contains(especialidad);

            if (fechaDisponible && especialidadCorrecta) {
                vet = vetAux;
            }
        }
        return vet;
    }

    private static String getEspecialidad() {
        String especialidad = "";
        String tipo = (String) vistaAgendar.getComb_tipo().getSelectedItem();
        switch (tipo) {
            case "Estetico":
                especialidad = "Estetica";
                break;
            case "Revision":
                especialidad = "General";
                break;
            case "Vacunacion":
                especialidad = "General";
                break;
            case "Esterelizacion":
                especialidad = "Cirujana";
                break;
        }

        return especialidad;
    }

    public static Cita agendarCita() throws FechaIsNull, SQLException, CitasException, UserNotFound {
        String tipo = (String) vistaAgendar.getComb_estetico().getSelectedItem();
        String nomMascota = (String) vistaAgendar.getCombo_mascotas().getSelectedItem();
        LocalDateTime fecha = vistaAgendar.getSelecFecha().getFechaHora();
        Cliente clienteActual = cliente;
        Cita cita = logicaCitas.crearCita(clienteActual, nomMascota, tipo, fecha);

        //daoCitas.agregar(cita);
        return cita;
    }

    public static void limpiarCombo() {
        int total = vistaAgendar.getSelecFecha().getCombo_fecha().getItemCount();
        for (int i = 0; i < total; i++) {
            vistaAgendar.getSelecFecha().getCombo_fecha().removeItemAt(0);
        }
    }

}
