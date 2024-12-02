package Modelo.Componentes;

import Controlador.ControladorAtenderCita;
import Controlador.ControladorDetalleCita;
import Excepciones.CitasException;
import Excepciones.ClientesExcepciones;
import Excepciones.UserNotFound;
import Modelo.DAO.daoCitas;
import Modelo.DAO.daoDiagnosticos;
import Modelo.VO.Cita;
import Modelo.VO.Diagnostico;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class HistorialTableModel extends AbstractTableModel {

    private String[] titulos = {"ID", "CLIENTE", "MASCOTA", "VETERINARIO", "FECHA", "DIAGNOSTICO"};
    private ArrayList<Diagnostico> listaDiagnosticos;

    public HistorialTableModel() {
        try {
            listaDiagnosticos = daoDiagnosticos.getLista();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (CitasException ex) {
            Logger.getLogger(HistorialTableModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClientesExcepciones ex) {
            Logger.getLogger(HistorialTableModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UserNotFound ex) {
            Logger.getLogger(HistorialTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    

    @Override
    public int getRowCount() {
        return listaDiagnosticos.size();
    }

    @Override
    public int getColumnCount() {
        return titulos.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Diagnostico diagnostico = listaDiagnosticos.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return diagnostico.getId();
            case 1:
                return diagnostico.getCita().getCliente().getUsuario();
            case 2:
                return diagnostico.getCita().getNomMascota();
            case 3:
                return diagnostico.getCita().getVet().getUsuario();
            case 4:
                return diagnostico.getCita().getFecha().toString();
            case 5:
                return "Ver historial";
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return titulos[column];
    }

}
