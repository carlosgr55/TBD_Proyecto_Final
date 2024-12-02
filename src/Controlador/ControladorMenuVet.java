/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import static Controlador.ControladorCrearCuenta.vistaCrear;
import static Controlador.ControladorMenuInicio.menu;
import static Controlador.ControladorVerCitas.mostrarVentana;
import Modelo.DAO.daoCitas;
import Modelo.DAO.daoVeterinarios;
import Modelo.VO.Cita;
import Modelo.VO.Cliente;
import Modelo.VO.Veterinario;
import Vista.VistaCitasPendientes;
import Vista.VistaTablaCitasClientes;
import Vista.VistaMenuVeterinario;
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author danii
 */
public class ControladorMenuVet {

    private static VistaTablaCitasClientes vistaCitas;
    static VistaMenuVeterinario vistaMenuVeter;
    static Veterinario veterinarioActual;

    public static void mostrarVentana(boolean mostrar) {
        vistaMenuVeter = new VistaMenuVeterinario();
        vistaMenuVeter.setVisible(mostrar);
        mensaje();
    }

    public static void mensaje() {
        vistaMenuVeter.getLb_aux().setText("Hola, " + veterinarioActual.getNombre());
    }

    public static Veterinario getVet() {
        return veterinarioActual;
    }

    public static void regresar() {
        vistaMenuVeter.setVisible(false);
        ControladorInicioPersonal.mostrarVentana();
        vistaMenuVeter.dispose();
    }

    public static void salir() {
        System.exit(0);
    }

    public static Veterinario getVeterinarioActual() {
        return veterinarioActual;
    }

    public static void setVeterinarioActual(Veterinario veterinarioActual) {
        ControladorMenuVet.veterinarioActual = veterinarioActual;
    }

}
