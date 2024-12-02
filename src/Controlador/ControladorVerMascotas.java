package Controlador;

import Excepciones.MascotaExcepcion;
import Modelo.DAO.daoMascotas;
import Modelo.VO.Cliente;
import Modelo.VO.Mascota;
import Vista.VistaAgendarCita;
import Vista.VistaMascotas;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ControladorVerMascotas {

    static VistaMascotas vistaMascota;
    static Cliente clienteActual;
    static ArrayList<Mascota> listaMascota;

    public static void mostrarVentana() throws MascotaExcepcion {
        try {
            vistaMascota = new VistaMascotas();
            vistaMascota.setVisible(true);
            clienteActual = ControladorMenuInicio.getClienteActual();
            listaMascota = daoMascotas.listaMascotasCliente(clienteActual.getUsuario());
            if (!listaVacia(listaMascota)) {
                popularCombo();
                evento();
            } else {
                ControladorMenuInicio.mostraVentana();
                JOptionPane.showMessageDialog(null, "No hay mascotas que mostrar");
                vistaMascota.setVisible(false);
                vistaMascota.dispose();
                throw new MascotaExcepcion();
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void eliminar() {
        Mascota mascota = getMascota((String) vistaMascota.getCombo_mascotas().getSelectedItem());
        ControladorConfimarEliminar.mostrarVentana(vistaMascota, true, mascota);
        boolean confirmo = ControladorConfimarEliminar.confirmacion;
        if (confirmo) {
            borrarMascota(mascota);
            vistaMascota.setVisible(false);
            vistaMascota.dispose();
            try {
                mostrarVentana();
            } catch (MascotaExcepcion ex) {
                JOptionPane.showMessageDialog(vistaMascota, "No hay mascotas que mostrar");
            }
        } else {

        }
    }

    public static boolean listaVacia(ArrayList<Mascota> mascota) {
        return mascota.isEmpty();
    }

    private static void borrarMascota(Mascota mascota) {
        try {
            daoMascotas.borrar(mascota);
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public static void popularCombo() {
        int i = 0;
        for (Mascota mascota : listaMascota) {
            String nombre = mascota.getNombre();
            vistaMascota.getCombo_mascotas().addItem(nombre);
        }
    }

    public static void evento() {
        String nombre = (String) vistaMascota.getCombo_mascotas().getSelectedItem();
        Mascota mascota = getMascota(nombre);
        llenarCampos(mascota);
    }

    public static void modificar() {
        habilitarBotones(false, false, true, false);
        habilitarCampos(true);
    }

    public static void guardar() throws SQLException {
        String nombre = (String) vistaMascota.getCombo_mascotas().getSelectedItem();
        int index = listaMascota.indexOf(getMascota(nombre));
        int id = listaMascota.get(index).getId();
        String nuevoNombre = vistaMascota.getTxt_nombre().getText();
        String nuevaEspecie = (String) vistaMascota.getCombo_especie().getSelectedItem();
        char sexo;
        if (vistaMascota.getRb_macho().isSelected()) {
            sexo = 'M';
        } else {
            sexo = 'H';
        }
        Mascota nuevaMascota = new Mascota(nuevoNombre, nuevaEspecie, sexo);
        daoMascotas.modificar(nuevaMascota, id);

        vistaMascota.dispose();
        try {
            mostrarVentana();
        } catch (MascotaExcepcion ex) {
            JOptionPane.showMessageDialog(vistaMascota, "No hay mascotas que mostrar");
        }
        habilitarBotones(true, true, false, true);
        habilitarCampos(false);
    }

    private static void limpiarCombo() {
        int total = vistaMascota.getComponentCount();
        for (int i = 0; i < total; i++) {
            vistaMascota.getCombo_mascotas().remove(i);
        }
    }

    private static void habilitarCampos(boolean campos) {
        vistaMascota.getTxt_nombre().setEnabled(campos);
        vistaMascota.getCombo_especie().setEnabled(campos);
        vistaMascota.getRb_hembra().setEnabled(true);
        vistaMascota.getRb_macho().setEnabled(true);

    }

    private static void habilitarBotones(boolean eliminar, boolean modificar, boolean guardar, boolean selector) {
        vistaMascota.getBtn_eliminar().setEnabled(eliminar);
        vistaMascota.getBtn_modificar().setEnabled(modificar);
        vistaMascota.getBtn_guardar().setEnabled(guardar);
        vistaMascota.getCombo_mascotas().setEnabled(selector);
    }

    public static void llenarCampos(Mascota mascota) {
        String nombre = mascota.getNombre();
        String especie = mascota.getEspecie();
        char sexo = mascota.getSexo();

        vistaMascota.getTxt_nombre().setText(nombre);
        vistaMascota.getCombo_especie().setSelectedItem(especie);
        if (sexo == 'M') {
            vistaMascota.getRb_macho().setSelected(true);
        } else {
            vistaMascota.getRb_hembra().setSelected(true);
        }

    }

    public static Mascota getMascota(String nombre) {
        Mascota pet = null;
        for (Mascota mascota : listaMascota) {
            if (mascota.getNombre().equals(nombre)) {
                pet = mascota;
            }
        }
        return pet;
    }

}
