package Modelo.Componentes;

import Controlador.ControladorDetalleCita;
import Excepciones.ClientesExcepciones;
import Excepciones.UserNotFound;
import Modelo.DAO.daoCitas;
import Modelo.VO.Cita;
import Modelo.VO.Cliente;
import Modelo.VO.Veterinario;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.AbstractTableModel;

public class CitasTableModel extends AbstractTableModel {

    private String[] titulos = {"ID", "CLIENTE", "MASCOTA", "VETERINARIO", "FECHA", "HORA", "MOTIVO", "ESTATUS"};
    private ArrayList<Cita> listaCitas;

    public CitasTableModel() {
        try {
            this.listaCitas = daoCitas.listaCitas();
        } catch (SQLException ex) {
            System.out.println("SQL EXCEPCION "+ex.getMessage());
        } catch (ClientesExcepciones ex) {
            Logger.getLogger(CitasTableModel.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UserNotFound ex) {
            Logger.getLogger(CitasTableModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public int getRowCount() {
        return listaCitas.size();
    }

    @Override
    public int getColumnCount() {
        return titulos.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Cita cita = listaCitas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return cita.getId();
            case 1:
                return cita.getCliente().getUsuario();
            case 2:
                return cita.getNomMascota();
            case 3:
                return cita.getVet().getUsuario();
            case 4:
                return cita.getFecha().getDayOfMonth() + "-" + cita.getFecha().getMonthValue() + "-" + cita.getFecha().getYear();
            case 5:
                return cita.getFecha().getHour() + ":" + cita.getFecha().getMinute();
            case 6:
                return cita.getTipo();
            case 7:
                if (cita.getEstatus() == 'P') {
                    return "Pendiente";
                } else if (cita.getEstatus() == 'A') {
                    return "Diagnosticada";
                } else {
                    return "Cancelada";
                }
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        return titulos[column];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Cita cita = listaCitas.get(rowIndex);
        switch (columnIndex) {
            case 0:
                cita.setId((String) aValue);
            case 1:
                cita.setCliente((Cliente) aValue);
            case 2:
                cita.setNomMascota((String) aValue);
            case 3:
                cita.setVet((Veterinario) aValue);
            case 4:
                cita.setFecha((LocalDateTime) aValue);
            case 5:
                cita.setFecha((LocalDateTime) aValue);
            case 6:
                cita.setTipo((String) aValue);
            case 7:
                cita.setEstatus((char) aValue);
        }
        fireTableCellUpdated(rowIndex, columnIndex);
    }
    
    

}
