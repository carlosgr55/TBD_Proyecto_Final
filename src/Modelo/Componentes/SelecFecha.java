/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Modelo.Componentes;

import Fecha.Fecha;
import com.toedter.calendar.JDateChooser;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author gambo
 */
public class SelecFecha extends javax.swing.JPanel {

    private ArrayList<String> horas = new ArrayList<>();

    /**
     * Creates new form SelecFecha
     */
    public SelecFecha() {
        initComponents();
        popularCombo();
        //minFecha();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        combo_fecha = new javax.swing.JComboBox<>();
        selec_fecha = new com.toedter.calendar.JDateChooser();

        setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(selec_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(combo_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(combo_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(selec_fecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    public DefaultComboBoxModel modelo() {
        llenarHoras();
        popularCombo();
        String[] arreglo = (String[]) this.horas.toArray();
        DefaultComboBoxModel modelo = new DefaultComboBoxModel(arreglo);
        return modelo;
    }

    public void popularCombo() {
        llenarHoras();
        int i = 0;
        for (String hora : horas) {
            combo_fecha.addItem(hora);
        }
    }

    private Date minFecha() {
        LocalDateTime hoy = Fecha.diaActual();
        int dia = hoy.getDayOfYear() + 1;
        int mes = hoy.getMonthValue() - 1;
        int ano = hoy.getYear();
        Date date = new Date(ano, 3, dia);
        //selec_fecha.setMinSelectableDate(date);
        return date;
    }

    public Fecha getFecha() throws FechaIsNull {
        Date fechaaux = selec_fecha.getDate();
        if (fechaaux == null) {
            throw new FechaIsNull("Se debe de seleccionar una fecha");
        } else {
            Date date = selec_fecha.getDate();
            LocalDate fecha = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int hora = getHora();
            int dia = fecha.getDayOfMonth();
            int mes = fecha.getMonthValue();
            int ano = fecha.getYear();
            int min = 0;
            Fecha retFecha = new Fecha(dia, mes, ano, hora, min);
            return retFecha;
        }
    }

    public LocalDateTime getFechaHora() throws FechaIsNull {
        Date fechaaux = selec_fecha.getDate();
        if (fechaaux == null) {
            throw new FechaIsNull("Se debe de seleccionar una fecha");
        } else {
            Date date = this.selec_fecha.getDate();
            int hora = getHora();
            LocalDate fecha = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
            int dia = fecha.getDayOfMonth();
            int mes = fecha.getMonthValue();
            int ano = fecha.getYear();
            int min = 0;
            LocalDateTime local = LocalDateTime.of(ano, mes, dia, hora, min);
            return local;
        }
    }

    public int getHora() {
        String hora = (String) combo_fecha.getSelectedItem();
        String dece = "" + hora.charAt(0);
        String uni = "" + hora.charAt(1);
        int decena = Integer.parseInt(dece) * 10;
        int unidad = Integer.parseInt(uni);
        return decena + unidad;
    }

    public void quitarHora(String hora) {
        int index = this.horas.indexOf(hora);
        this.horas.remove(hora);
        combo_fecha.remove(index);
    }

    private void llenarHoras() {
        this.horas.add("09:00");
        this.horas.add("10:00");
        this.horas.add("11:00");
        this.horas.add("12:00");
        this.horas.add("13:00");
        this.horas.add("14:00");
        this.horas.add("15:00");
        this.horas.add("16:00");
        this.horas.add("17:00");
        this.horas.add("18:00");
    }

    public JComboBox<String> getCombo_fecha() {
        return combo_fecha;
    }

    public void setCombo_fecha(JComboBox<String> combo_fecha) {
        this.combo_fecha = combo_fecha;
    }

    public JDateChooser getSelec_fecha() {
        return selec_fecha;
    }

    public void setSelec_fecha(JDateChooser selec_fecha) {
        this.selec_fecha = selec_fecha;
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> combo_fecha;
    private com.toedter.calendar.JDateChooser selec_fecha;
    // End of variables declaration//GEN-END:variables
}
