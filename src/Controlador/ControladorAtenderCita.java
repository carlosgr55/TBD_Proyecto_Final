/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Excepciones.DatosIncompletosException;
import Excepciones.MascotaExcepcion;
import Modelo.DAO.daoCitas;
import Modelo.DAO.daoDiagnosticos;
import Modelo.DAO.daoMascotas;
import Modelo.VO.Cita;
import Modelo.VO.Diagnostico;
import Modelo.VO.Mascota;
import Vista.VistaAtenderCita;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gambo
 */
public class ControladorAtenderCita {
    
    static VistaAtenderCita vistaAtender;
    static Cita citaActual;
    
    public static void mostrarVentana() {
        vistaAtender = new VistaAtenderCita();
        vistaAtender.setVisible(true);
        llenarCampos();
    }
    
    public static Cita getCitaActual() {
        return citaActual;
    }
    
    public static void guardarDiagnostico() throws DatosIncompletosException, SQLException {
        String diagnostico = vistaAtender.getTxt_diag().getText();
        double precio = (double) vistaAtender.getSpin_costo().getValue();
        if (diagnostico.length() == 0 || precio == 0) {
            throw new DatosIncompletosException("Deben de llenarse todos los campos");
        } else {
            diagnosticar();
            daoCitas.atenderCita(citaActual.getId());
        }
        
    }
    
    public static void diagnosticar() throws SQLException {
        String receta = vistaAtender.getTxt_diag().getText();
        double precio = (double) vistaAtender.getSpin_costo().getValue();
        
        Diagnostico diagnostico = new Diagnostico(receta, citaActual, precio);
        
        daoDiagnosticos.agregar(diagnostico);
        
    }
    
    public static void setCitaActual(Cita citaActual) {
        ControladorAtenderCita.citaActual = citaActual;
    }
    
    public static void llenarCampos() {
        try {
            String mascotNom = citaActual.getNomMascota();
            int index = indexMascota();
            System.out.println(index);
            Mascota mascota = daoMascotas.getMasCliente(mascotNom, citaActual.getCliente().getUsuario());
            vistaAtender.getTxt_motivo().setText(citaActual.getTipo());
            vistaAtender.getTxt_mascota().setText(citaActual.getNomMascota());
            vistaAtender.getTxt_cliente().setText(citaActual.getCliente().getNombre());
            vistaAtender.getTxt_especie().setText(mascota.getEspecie());
            if (mascota.getSexo() == 'H') {
                vistaAtender.getTxt_sexo().setText("Hembra");
            } else {
                vistaAtender.getTxt_sexo().setText("Macho");
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } catch (MascotaExcepcion ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    public static int indexMascota() {
        int index = 0;
        for (Mascota mascota : citaActual.getCliente().getMascotas()) {
            if (mascota.getNombre().equals(citaActual.getNomMascota())) {
                return index;
            } else {
                index++;
            }
        }
        return index;
    }
    
}
