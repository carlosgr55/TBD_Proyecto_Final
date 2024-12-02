/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.Logica;

import Excepciones.RecepcionException;
import Modelo.DAO.daoRecepcion;
import Modelo.VO.Recepcion;
import java.sql.SQLException;

/**
 *
 * @author gambo
 */
public class LogicaRecepcion {

    public boolean recepExiste(String user) throws SQLException {
        return daoRecepcion.existe(user);
    }

    public boolean agregarRecepcion(Recepcion recepcion) throws SQLException, RecepcionException {
        if (!recepExiste(recepcion.getUser())) {
            daoRecepcion.agregar(recepcion);
            return true;
        } else {
            throw new RecepcionException("Usuario ya existente");
        }
    }

    public boolean modificarRecepcion(String usuarioAnt, Recepcion nuevo) throws SQLException, RecepcionException {
        boolean modificado = false;

        if (usuarioAnt.equals(nuevo.getUser())) {
            daoRecepcion.modificar(nuevo, usuarioAnt);
            modificado = true;
        } else {

            if (recepExiste(nuevo.getUser())) {
                throw new RecepcionException("Nombre de usuario ya exister");
            } else {
                daoRecepcion.modificar(nuevo, usuarioAnt);
                modificado = true;
            }
        }
        return modificado;
    }

}
