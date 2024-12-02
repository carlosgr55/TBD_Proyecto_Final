package Modelo.Logica;

import Modelo.DAO.daoVeterinarios;
import Modelo.VO.Admin;
import Modelo.VO.Cliente;
import Modelo.VO.Veterinario;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class LogicaAdministrador {

    public void agregarVeterinario(Veterinario vet) throws SQLException {
        daoVeterinarios.agregar(vet);
    }

    public void eliminarVeterinario(Veterinario vet) throws SQLException {
        daoVeterinarios.borrar(vet.getUsuario());
    }

    public boolean accesoValido(String user, String password, Admin admin) {
        boolean valido = false;
        String registroUsuario = admin.getUsuario();
        String registroPassword = admin.getPassword();
        boolean acceso = registroUsuario.equals(user) && registroPassword.equals(password);
        if (acceso) {
            valido = true;
        }
        return valido;
    }

    public ArrayList<Veterinario> obtenerTodosVeterinarios() throws SQLException {
        return daoVeterinarios.getVeterinarios();
    }
}
