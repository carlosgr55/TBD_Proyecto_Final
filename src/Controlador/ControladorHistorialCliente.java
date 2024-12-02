/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Excepciones.CitasException;
import Excepciones.ClientesExcepciones;
import Excepciones.DiagnosticosException;
import Excepciones.MascotaExcepcion;
import Excepciones.UserNotFound;
import Modelo.DAO.daoCitas;
import Modelo.DAO.daoClientes;
import Modelo.DAO.daoDiagnosticos;
import Modelo.DAO.daoMascotas;
import Modelo.VO.Cliente;
import Modelo.VO.Diagnostico;
import Modelo.VO.Mascota;
import Vista.VistaHistorialCliente;
import Vista.VistaHistorialVet;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author gambo
 */
public class ControladorHistorialCliente {

    static VistaHistorialCliente vistaHistCliente;

    static Cliente clienteActual;

    public static void mostrarVentana() throws MascotaExcepcion, DiagnosticosException, SQLException, CitasException, ClientesExcepciones, UserNotFound {
        ArrayList<Diagnostico> lista = daoDiagnosticos.getLista();
        clienteActual = ControladorMenuInicio.getClienteActual();
        if (lista.size() != 0) {
            vistaHistCliente = new VistaHistorialCliente();
            vistaHistCliente.setVisible(true);
            buscarUsuario();
        } else {
            throw new DiagnosticosException("Diagnostico exepcion");
        }
    }

    public static void regresar() {
        vistaHistCliente.setVisible(false);
        ControladorMenuInicio.mostraVentana();
    }

    public static void buscarUsuario() throws MascotaExcepcion {
        try {
            ArrayList<Mascota> lista = daoMascotas.listaMascotasCliente(clienteActual.getUsuario());
            limpiarCombo();
            if (lista.size() == 0) {
                throw new MascotaExcepcion("No hay mascota que mostar");
            } else {
                popularCombo(clienteActual.getUsuario());
            }
        } catch (SQLException ex) {
            Logger.getLogger(ControladorHistorialCliente.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void verHistorial() throws SQLException, DiagnosticosException, CitasException, ClientesExcepciones, UserNotFound {
        int fila = vistaHistCliente.getTabla_diag().getSelectedRow();
        int columna = vistaHistCliente.getTabla_diag().getSelectedColumn();
        if (columna == 5) {
            String idDiag = (String) vistaHistCliente.getTabla_diag().getValueAt(fila, 0);
            Diagnostico diagnostico = daoDiagnosticos.consulta(idDiag);
            ControladorVerHistorial.mostrarVentana(vistaHistCliente, true, diagnostico);
        }
    }

    public static void filtrar(TableRowSorter<TableModel> sorter) {
        if (vistaHistCliente.getComb_mascotas().getSelectedIndex() == -1) {
        } else {
            String filtro = (String) vistaHistCliente.getComb_mascotas().getSelectedItem();
            sorter.setRowFilter(RowFilter.regexFilter(filtro, 2));
        }
    }

    public static void popularCombo(String user) {
        try {
            ArrayList<Mascota> lista = daoMascotas.listaMascotasCliente(clienteActual.getUsuario());
            limpiarCombo();
            for (Mascota mascota : lista) {
                vistaHistCliente.getComb_mascotas().addItem(mascota.getNombre());
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void limpiarCombo() {
        for (int i = 0; i < vistaHistCliente.getComb_mascotas().getItemCount(); i++) {
            vistaHistCliente.getComb_mascotas().removeItemAt(i);
        }
    }
}
