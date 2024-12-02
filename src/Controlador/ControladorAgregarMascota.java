package Controlador;

import Modelo.Logica.LogicaClientes;
import Modelo.VO.Cliente;
import Modelo.VO.Mascota;
import Vista.VistaAgregarMascota;
import Vista.VistaRegistrarMascota;
import java.sql.SQLException;

public class ControladorAgregarMascota {
    
    static VistaAgregarMascota vistaAgregar = new VistaAgregarMascota();
    static Cliente cliente;
    static LogicaClientes logicaCliente = new LogicaClientes();
    
    public static void mostrarVentana() {
        vistaAgregar.setVisible(true);
        cliente = ControladorMenuInicio.getClienteActual();
    }
    
    public static Cliente getCliente() {
        return cliente;
    }
    
    public static void setCliente(Cliente cliente) {
        ControladorRegistrarMascota.cliente = cliente;
    }
    
    public static void regresar() {
        vistaAgregar.setVisible(false);
        vistaAgregar.dispose();
        ControladorMenuInicio.mostraVentana();
    }
    
    public static void registrar() throws SQLException {
        logicaCliente.agregarMascota(crearMascota());
        vistaAgregar.setVisible(false);
        ControladorMenuInicio.mostraVentana();
        vistaAgregar.dispose();
        mostrar();
    }
    
    private static void mostrar() {
        for (Mascota mascota : cliente.getMascotas()) {
            System.out.println(mascota.toString());
            
        }
    }
    
    public static Mascota crearMascota() {
        String nombre = vistaAgregar.getTxt_nombre().getText();
        char sexo = getSexo();
        String especie = getEspecie();
        String clienteU = cliente.getUsuario();
        Mascota mascota = new Mascota(nombre, especie, sexo);
        mascota.setCliente(clienteU);
        return mascota;
        
    }
    
    public static String getEspecie() {
        return (String) vistaAgregar.getCombo_especie().getSelectedItem();
    }
    
    private static char getSexo() {
        if (vistaAgregar.getRb_macho().isSelected()) {
            return 'M';
        } else {
            return 'H';
        }
    }
}
