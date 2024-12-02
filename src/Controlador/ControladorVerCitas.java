package Controlador;

import Excepciones.CitasException;
import Excepciones.ClientesExcepciones;
import Excepciones.UserNotFound;
import Modelo.Componentes.CitasTableModel;
import Modelo.DAO.daoCitas;
import Modelo.DAO.daoVeterinarios;
import Modelo.VO.Cita;
import Modelo.VO.Cliente;
import Modelo.VO.Veterinario;
import Vista.VistaTablaCitasClientes;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class ControladorVerCitas {

    private static VistaTablaCitasClientes vistaCitas;

    public static void mostrarVentana(boolean mostrar) throws CitasException, SQLException, ClientesExcepciones, UserNotFound {
        ArrayList<Cita> lista = daoCitas.listaCitas();
        if (lista.size() != 0) {
            vistaCitas = new VistaTablaCitasClientes(); //Es necesario crear el objeto cuando se muestra la ventana para poder crear el filtro
            vistaCitas.setVisible(mostrar);
        } else {
            throw new CitasException("excepcoin");
        }

    }

    public static void cerrarVentana() {
        vistaCitas.setVisible(false);
        vistaCitas.dispose();
    }

    public static Cita getCitaTabla(int fila, JTable tabla) throws SQLException, CitasException, ClientesExcepciones, UserNotFound {
        Cita cita = null;
        if (fila == -1) {
            JOptionPane.showMessageDialog(null, "Debes seleccionar una fila");
        } else {
            String id = tabla.getValueAt(fila, 0).toString();
            cita = daoCitas.consulta(id);
        }
        return cita;
    }

    public static void regresar() {
        vistaCitas.setVisible(false);
        ControladorMenuInicio.mostraVentana();
        vistaCitas.dispose();
    }

    public static void filtrarTabla(Cliente cliente, TableRowSorter<TableModel> sorter) {
        String filtro = cliente.getUsuario();
        sorter.setRowFilter(RowFilter.regexFilter(filtro, 1));
    }

    public static JTable getTabla() {
        return vistaCitas.getTabla_citas();
    }

    public static void setTabla(JTable tabla) {
        vistaCitas.setTabla_citas(tabla);
    }

}
