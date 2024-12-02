/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Excepciones.UserNotFound;
import Modelo.DAO.daoRecepcion;
import Modelo.DAO.daoVeterinarios;
import Modelo.Logica.LogicaRecepcion;
import Modelo.Logica.LogicaVeterinario;
import Modelo.VO.Admin;
import Modelo.VO.Cliente;
import Modelo.VO.Recepcion;
import Modelo.VO.Veterinario;
import Vista.VistaInicioPersonal;
import java.awt.Color;
import java.sql.SQLException;

/**
 *
 * @author gambo
 */
public class ControladorInicioPersonal {

    static VistaInicioPersonal vistaPersonal = new VistaInicioPersonal();
    static Admin admin = new Admin();
    static Veterinario veterinarioActual;
    static LogicaRecepcion logicaRecep = new LogicaRecepcion();
    static LogicaVeterinario logicaVet = new LogicaVeterinario();
    ControladorCitasPendientes controladorCitasPendientes = new ControladorCitasPendientes();

    public static boolean esRecepcion = false;
    public static boolean esAdmin = false;
    public static boolean esVet = false;

    public static void mostrarVentana() {
        vistaPersonal = new VistaInicioPersonal();
        vistaPersonal.setVisible(true);
    }

    public static void detectarUsuario(String password) throws UserNotFound, SQLException {
        String user = vistaPersonal.getTxt_user().getText();
        vistaPersonal.getTxt_mensaje().setVisible(false);
        if (user.equals(admin.getUsuario())) {
            esAdmin = true;
            accesoAdmin(user, password);
        }else if (logicaVet.vetExiste(user)) {
            esVet = true;
            Veterinario veterinario = daoVeterinarios.consulta(user);
            accesoVet(user, password, veterinario);
        } else {
            throw new UserNotFound("Usuario no existe");
        }
    }

    public static void accesoVet(String user, String pass, Veterinario vet) {
        boolean valido = user.equals(vet.getUsuario()) && vet.getPassword().equals(pass);
        if (valido) {
            veterinarioActual = vet;
            ControladorMenuVet.setVeterinarioActual(vet);
            ControladorMenuVet.setVeterinarioActual(vet);
            vistaPersonal.setVisible(false);
            ControladorMenuVet.mostrarVentana(true);
        } else {
            mensaje("Contraseña incorrecta");
        }
    }

    public static void setVetActual(Veterinario vet) {
        veterinarioActual = vet;
    }

    public static Veterinario getVetActual() {
        return veterinarioActual;
    }

    public static void accesoRec(String user, String pass, Recepcion recep) {
        boolean valido = user.equals(recep.getUser()) && recep.getPassword().equals(pass);
        if (valido) {
            ControladorMenuRecepcion.mostrarVentana();
            vistaPersonal.setVisible(false);

        } else {
            mensaje("Contraseña incorrecta");
        }
    }

    public static void accesoAdmin(String user, String pass) {
        boolean valido = user.equals(admin.getUsuario()) && admin.getPassword().equals(pass);
        if (valido) {
            ControladorMenuAdmi.mostrarVentana();
            vistaPersonal.setVisible(false);

        } else {
            mensaje("Contraseña incorrecta");
        }
    }

    public static void salir() {
        System.exit(0);
    }

    public static void mensaje(String msg) {
        vistaPersonal.getTxt_mensaje().setVisible(true);
        vistaPersonal.getTxt_mensaje().setForeground(Color.red);
        vistaPersonal.getTxt_mensaje().setText(msg);
    }

}
