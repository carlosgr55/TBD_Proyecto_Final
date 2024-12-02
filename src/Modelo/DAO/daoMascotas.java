/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo.DAO;

import java.sql.*;
import Conexion.*;
import Excepciones.MascotaExcepcion;
import Modelo.VO.Mascota;
import java.util.ArrayList;

/**
 *
 * @author gambo
 */
public class daoMascotas {

    private static final Connection conexion = Conexion.getConexion("root", "Motomami55");

    public static void agregar(Mascota mascota, String cliente) throws SQLException {
        String nombre = mascota.getNombre();
        String especie = mascota.getEspecie();
        char sexo = mascota.getSexo();

        String statement = "INSERT INTO mascotas (nombre, cliente, sexo, especie)"
                + "VALUES (?,?,?,?)";
        PreparedStatement pst = conexion.prepareStatement(statement);

        pst.setString(1, nombre);
        pst.setString(2, cliente);
        pst.setString(3, sexo + "");
        pst.setString(4, especie);
        pst.executeUpdate();

    }

    public static void modificar(Mascota nuevo, int id) throws SQLException {
        String nombre = nuevo.getNombre();
        String especie = nuevo.getEspecie();
        char sexo = nuevo.getSexo();

        String statement = "UPDATE mascotas "
                + "SET nombre = ?, especie = ?, sexo = ? "
                + " WHERE id = ?";
        PreparedStatement pst = conexion.prepareStatement(statement);

        pst.setInt(4, id);
        pst.setString(1, nombre);
        pst.setString(2, especie);
        pst.setString(3, sexo + "");
        pst.executeUpdate();
    }

    public static Mascota consulta(int id) throws SQLException, MascotaExcepcion {
        Mascota mascota = null;
        String statement = "SELECT * FROM mascotas WHERE id = ?";
        PreparedStatement pst = conexion.prepareStatement(statement);
        pst.setInt(1, id);
        ResultSet rst = pst.executeQuery();
        if (rst.next()) {
            String nombre = rst.getString("nombre");
            String especie = rst.getString("especie");
            char sexo = rst.getString("sexo").charAt(0);
            String cliente;
            if(rst.getString("cliente") != null){
                cliente = rst.getString("cliente");
            }else{
                cliente = "Usuario Eliminado";
            }
            mascota = new Mascota(id, nombre, especie, sexo, cliente);
            return mascota;
        } else {
            throw new MascotaExcepcion("Mascota no encontrada");
        }
    }

    public static ArrayList<Mascota> listaMascotasCliente(String cliente) throws SQLException {
        ArrayList<Mascota> lista = new ArrayList<>();
        String statement = "SELECT * FROM mascotas WHERE cliente = ?";
        PreparedStatement pst = conexion.prepareStatement(statement);
        pst.setString(1, cliente);
        ResultSet rst = pst.executeQuery();

        while (rst.next()) {
            int id = rst.getInt("id");
            String nombre = rst.getString("nombre");
            String especie = rst.getString("especie");
            char sexo = rst.getString("sexo").charAt(0);
            lista.add(new Mascota(id, nombre, especie, sexo, cliente));
        }
        return lista;
    }

    public static void borrar(Mascota mascota) throws SQLException {
        String nombre = mascota.getNombre();
        String cliente = mascota.getCliente();
        String especie = mascota.getEspecie();
        String statement = "DELETE FROM mascotas WHERE nombre = ? AND cliente = ? AND especie = ?";

        PreparedStatement pst = conexion.prepareStatement(statement);
        pst.setString(1, nombre);
        pst.setString(2, cliente);
        pst.setString(3, especie);
        pst.executeUpdate();
    }

    public static Mascota getMasCliente(String nomMascota, String cliente) throws SQLException, MascotaExcepcion {
        Mascota mascota = null;
        String statement = "SELECT * FROM mascotas WHERE nombre = ? AND cliente = ?";
        PreparedStatement pst = conexion.prepareStatement(statement);
        pst.setString(1, nomMascota);
        pst.setString(2, cliente);
        ResultSet rst = pst.executeQuery();
        if (rst.next()) {
            int id = rst.getInt("id");
            String nombre = rst.getString("nombre");
            String especie = rst.getString("especie");
            char sexo = rst.getString("sexo").charAt(0);
            mascota = new Mascota(id, nombre, especie, sexo, cliente);
            return mascota;
        } else {
            throw new MascotaExcepcion("Mascota no encontrada");
        }

    }

}
