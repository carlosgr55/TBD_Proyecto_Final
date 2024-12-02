/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Modelo.VO.Diagnostico;
import Vista.VistaVerHistorial;
import java.awt.Dialog;

/**
 *
 * @author gambo
 */
public class ControladorVerHistorial {

    static VistaVerHistorial vistaVer;
    static Diagnostico diag;

    public static void mostrarVentana(Dialog owner, boolean modal, Diagnostico diagnostic) {
        vistaVer = new VistaVerHistorial(owner, "Historial medico", modal);
        diag = diagnostic;
        llenarDiagnostico();
        vistaVer.setVisible(true);
    }

    public static void llenarDiagnostico() {
        vistaVer.getTxt_diagnostico().setText(diag.getDiagnostico());
    }

    public static Diagnostico getDiag() {
        return diag;
    }

    public static void setDiag(Diagnostico diag) {
        ControladorVerHistorial.diag = diag;
    }

}
