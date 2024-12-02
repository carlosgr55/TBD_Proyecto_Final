package Controlador;

import Excepciones.CitasException;
import Excepciones.ClientesExcepciones;
import Excepciones.DiagnosticosException;
import Excepciones.MascotaExcepcion;
import Excepciones.UserNotFound;
import Modelo.DAO.daoClientes;
import Modelo.DAO.daoDiagnosticos;
import Modelo.DAO.daoMascotas;
import Modelo.Logica.LogicaClientes;
import Modelo.VO.Cliente;
import Modelo.VO.Diagnostico;
import Modelo.VO.Mascota;
import Vista.VistaHistorialVet;
import java.awt.Color;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ControladorHistorial {

    static VistaHistorialVet vistaHistorial;
    static LogicaClientes logicaClientes = new LogicaClientes();

    public static void mostrarVentana() throws DiagnosticosException, SQLException, CitasException, ClientesExcepciones, UserNotFound {
        ArrayList<Diagnostico> lista = daoDiagnosticos.getLista();
        if (lista.size() != 0) {
            vistaHistorial = new VistaHistorialVet();
            vistaHistorial.setVisible(true);
        } else {
            throw new DiagnosticosException("Diagnostico excepcion");
        }
    }

    public static void popularCombo(String cliente) throws SQLException {
        limpiarCombo();
        vistaHistorial.getComb_mascotas().setEnabled(false);
        if (usuarioEncontrado(cliente)) {
            ArrayList<Mascota> lista = daoMascotas.listaMascotasCliente(cliente);
            for (Mascota mascota : lista) {
                vistaHistorial.getComb_mascotas().addItem(mascota.getNombre());
                vistaHistorial.getComb_mascotas().setEnabled(true);

            }
        } else {
            limpiarCombo();
            vistaHistorial.getComb_mascotas().setEnabled(false);

        }
    }

    public static boolean usuarioEncontrado(String cliente) throws SQLException {
        return logicaClientes.existe(cliente);
    }

    public static void regresar() {
        vistaHistorial.setVisible(false);
        ControladorMenuVet.mostrarVentana(true);
    }

    public static void buscarUsuario() throws MascotaExcepcion, SQLException, ClientesExcepciones {
        limpiarCombo();
        vistaHistorial.getComb_mascotas().setEnabled(false);
        String user = vistaHistorial.getTxt_usuario().getText();
        if (logicaClientes.existe(user)) {
            vistaHistorial.getComb_mascotas().setEnabled(true);
            vistaHistorial.getLb_aux().setVisible(false);
            popularCombo(user);
        } else {
            vistaHistorial.getComb_mascotas().setEnabled(false);
            limpiarCombo();
            vistaHistorial.getLb_aux().setVisible(true);
            vistaHistorial.getLb_aux().setText("Cliente no encontrado");
            vistaHistorial.getLb_aux().setForeground(Color.red);
        }

    }

    public static void verHistorial() throws SQLException, DiagnosticosException, CitasException, ClientesExcepciones, UserNotFound {
        int fila = vistaHistorial.getTabla_diag().getSelectedRow();
        int columna = vistaHistorial.getTabla_diag().getSelectedColumn();
        if (columna == 5) {
            String idDiag = (String) vistaHistorial.getTabla_diag().getValueAt(fila, 0);
            Diagnostico diagnostico = daoDiagnosticos.consulta(idDiag);
            ControladorVerHistorial.mostrarVentana(vistaHistorial, true, diagnostico);
        }
    }

    public static void filtroUsuario(String cliente, TableRowSorter<TableModel> sorter) {
        sorter.setRowFilter(RowFilter.regexFilter(cliente, 1));
    }

    public static void filtrar(TableRowSorter<TableModel> sorter) {
        if (vistaHistorial.getComb_mascotas().getSelectedIndex() == -1) {
        } else {
            String filtro = (String) vistaHistorial.getComb_mascotas().getSelectedItem();
            sorter.setRowFilter(RowFilter.regexFilter(filtro, 2));
        }
    }

    public static void limpiarCombo() {
        for (int i = 0; i < vistaHistorial.getComb_mascotas().getItemCount(); i++) {
            vistaHistorial.getComb_mascotas().removeItemAt(i);
        }
    }

}
