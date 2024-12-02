package Modelo.Logica;

import Excepciones.VeterinarioException;
import Modelo.DAO.daoVeterinarios;
import Modelo.VO.Veterinario;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class LogicaVeterinario {

    public boolean vetExiste(String user) throws SQLException {
        return daoVeterinarios.existe(user);
    }
    
    public boolean agregarVeterinario(Veterinario veterinario) throws SQLException, VeterinarioException{
        if(!vetExiste(veterinario.getUsuario())){
            
            daoVeterinarios.agregar(veterinario);
            
            return true;
        }else{
            throw new VeterinarioException("El veterinario ya existe");
        }
    }


}
