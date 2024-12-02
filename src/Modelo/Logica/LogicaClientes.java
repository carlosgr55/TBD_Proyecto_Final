package Modelo.Logica;

import Excepciones.ClientesExcepciones;
import Modelo.DAO.daoClientes;
import Modelo.DAO.daoMascotas;
import Modelo.VO.Cliente;
import Modelo.VO.Mascota;
import java.sql.SQLException;
import java.util.ArrayList;

public class LogicaClientes {
    
    public void agregarMascota(Mascota mascota) throws SQLException {
        daoMascotas.agregar(mascota, mascota.getCliente());
        
    }
    
    public boolean clienteExiste(Cliente cliente) throws SQLException {
        String user = cliente.getUsuario();
        return daoClientes.existe(user);
        
    }
    
    public void agregarCliente(Cliente cliente) throws SQLException {
        if (!clienteExiste(cliente)) {
            daoClientes.agregarCliente(cliente);
        }
    }
    
    public boolean modificar(String usuarioAnt, Cliente nuevo) throws SQLException, ClientesExcepciones {
        boolean modificado = false;
        
        if (usuarioAnt.equals(nuevo.getUsuario())) {
            daoClientes.modificar(nuevo, usuarioAnt);
            modificado = true;
        } else {
            
            if (existe(nuevo.getUsuario())) {
                throw new ClientesExcepciones("NOMBRE DE USUARIO NO DISPONIBLE");
            } else {
                daoClientes.modificar(nuevo, usuarioAnt);
                modificado = true;
            }
        }
        return modificado;
    }
    
    public boolean existe(String user) throws SQLException {
        return daoClientes.existe(user);
    }
    
    public boolean accesoValido(String user, String password, Cliente cliente) {
        boolean valido = false;
        String registroUsuario = cliente.getUsuario();
        String registroPassword = cliente.getPassword();
        boolean acceso = registroUsuario.equals(user) && registroPassword.equals(password);
        if (acceso) {
            valido = true;
        }
        return valido;
    }
    
    public boolean numeroValido(String numero) {
        boolean valido = false;
        char[] caracteres = numero.toCharArray();
        int numCaracteres = caracteres.length;
        boolean numerico = esNumerico(numero);
        
        if (numCaracteres == 10 && numerico) {
            valido = true;
        }
        return valido;
    }
    
    public static boolean esNumerico(String cadena) {
        
        boolean resultado;
        
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        
        return resultado;
    }
    
}
