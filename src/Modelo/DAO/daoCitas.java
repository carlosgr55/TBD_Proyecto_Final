package Modelo.DAO;

import Conexion.Conexion;
import Excepciones.CitasException;
import Excepciones.ClientesExcepciones;
import Excepciones.UserNotFound;
import Modelo.VO.Cita;
import Modelo.VO.Cliente;
import Modelo.VO.Veterinario;
import java.util.ArrayList;
import java.sql.*;
import java.time.LocalDateTime;

public class daoCitas {

    private final static Connection conexion = Conexion.getConexion("root", "Motomami55");

    public static void agregar(Cita cita) throws SQLException {
        String id = cita.getId();
        String tipo = cita.getTipo();
        String cliente = cita.getCliente().getUsuario();
        String veterinario = cita.getVet().getUsuario();
        String mascota = cita.getNomMascota();
        int dia = cita.getFecha().getDayOfMonth();
        int mes = cita.getFecha().getMonthValue();
        int ano = cita.getFecha().getYear();
        int hora = cita.getFecha().getHour();
        int minutos = 0;
        String estatus = cita.getEstatus() + "";

        String statement = "INSERT INTO citas (id, cliente, veterinario, mascota, dia, mes,"
                + "ano, hora, minutos, tipo, estatus)"
                + "VALUES (?,?,?,?,?,?,?,?,?,?,?)";

        PreparedStatement pst = conexion.prepareStatement(statement);
        pst.setString(1, id);
        pst.setString(2, cliente);
        pst.setString(3, veterinario);
        pst.setString(4, mascota);
        pst.setInt(5, dia);
        pst.setInt(6, mes);
        pst.setInt(7, ano);
        pst.setInt(8, hora);
        pst.setInt(9, minutos);
        pst.setString(10, tipo);
        pst.setString(11, estatus);
        pst.executeUpdate();

    }

    public static ArrayList<Cita> listaCitas() throws SQLException, ClientesExcepciones, UserNotFound {
        ArrayList<Cita> lista = new ArrayList<>();
        PreparedStatement pst = conexion.prepareStatement("SELECT * FROM citas");
        ResultSet rst = pst.executeQuery();

        while (rst.next()) {
            String id = rst.getString("id");
            Cliente cliente;
            if (rst.getString("cliente") != null) {
                cliente = daoClientes.consulta(rst.getString("cliente"));
            } else {
                cliente = new Cliente("Usuario eliminado", "", "Usuario eliminado", "", "", "");
            }
            Veterinario vet;
            if (rst.getString("veterinario") != null) {
                vet = daoVeterinarios.consulta(rst.getString("veterinario"));
            } else {
                vet = new Veterinario("", 0, "USUARIOELIMINADO", "", "USUARIO", "ELIMINADO", "", "");
            }
            String nomMascota = rst.getString("mascota");
            String tipo = rst.getString("tipo");
            char estatus = rst.getString("estatus").charAt(0);
            int dia = Integer.parseInt(rst.getString("dia"));
            int mes = Integer.parseInt(rst.getString("mes"));
            int ano = Integer.parseInt(rst.getString("ano"));
            int hora = Integer.parseInt(rst.getString("hora"));
            int minutos = Integer.parseInt(rst.getString("minutos"));
            LocalDateTime fecha = LocalDateTime.of(ano, mes, dia, hora, minutos);
            lista.add(new Cita(id, vet, cliente, nomMascota, fecha, tipo, estatus));
        }

        return lista;
    }

    public static Cita consulta(String id) throws SQLException, CitasException, ClientesExcepciones, UserNotFound {
        Cita cita = null;
        String statement = "SELECT * FROM citas where id = '" + id + "'";
        PreparedStatement pst = conexion.prepareStatement(statement);
        ResultSet rst = pst.executeQuery();

        if (rst.next()) {
            Cliente cliente;
            if (rst.getString("cliente") != null) {
                cliente = daoClientes.consulta(rst.getString("cliente"));
            } else {
                cliente = new Cliente("Usuario eliminado", "", "Usuario eliminado", "", "", "");
            }
            Veterinario vet;
            if (rst.getString("veterinario") != null) {
                vet = daoVeterinarios.consulta(rst.getString("veterinario"));
            } else {
                vet = new Veterinario("", 0, "USUARIOELIMINADO", "", "USUARIO", "ELIMINADO", "", "");
            }
            String nomMascota = rst.getString("mascota");
            String tipo = rst.getString("tipo");
            char estatus = rst.getString("estatus").charAt(0);
            int dia = Integer.parseInt(rst.getString("dia"));
            int mes = Integer.parseInt(rst.getString("mes"));
            int ano = Integer.parseInt(rst.getString("ano"));
            int hora = Integer.parseInt(rst.getString("hora"));
            int minutos = Integer.parseInt(rst.getString("minutos"));
            LocalDateTime fecha = LocalDateTime.of(ano, mes, dia, hora, minutos);
            cita = new Cita(id, vet, cliente, nomMascota, fecha, tipo, estatus);
            return cita;
        } else {
            throw new CitasException("Cita no encontrada");
        }

    }

    public static void eliminar(String id) throws SQLException {
        String statement = "DELETE FROM citas where id ='" + id + "'";
        PreparedStatement pst = conexion.prepareStatement(statement);
        pst.executeUpdate();
    }

    public static void modificar(Cita citaNueva, String id) throws SQLException {
        String veterinario = citaNueva.getVet().getUsuario();
        String mascota = citaNueva.getNomMascota();
        int dia = citaNueva.getFecha().getDayOfMonth();
        int mes = citaNueva.getFecha().getMonthValue();
        int ano = citaNueva.getFecha().getYear();
        int hora = citaNueva.getFecha().getHour();
        int minutos = 0;
        String statement = "UPDATE citas "
                + "SET veterinario = ?, mascota = ?, "
                + "dia = ?, mes =?, ano =?, hora =?, minutos =?"
                + "WHERE id = ?";
        PreparedStatement pst = conexion.prepareStatement(statement);
        pst.setString(1, veterinario);
        pst.setString(2, mascota);
        pst.setInt(3, dia);
        pst.setInt(4, mes);
        pst.setInt(5, ano);
        pst.setInt(6, hora);
        pst.setInt(7, minutos);
        pst.setString(8, id);
        pst.executeUpdate();
    }

    public static ArrayList<String> vetsOcupados(int dia, int mes, int ano, int hora, int min) throws SQLException {
        ArrayList<String> lista = new ArrayList<>();
        String statement = "SELECT veterinario FROM citas WHERE "
                + "dia = ? AND mes = ? AND ano = ? AND hora = ? AND minutos = ?";
        PreparedStatement pst = conexion.prepareStatement(statement);

        pst.setInt(1, dia);
        pst.setInt(2, mes);
        pst.setInt(3, ano);
        pst.setInt(4, hora);
        pst.setInt(5, min);

        ResultSet rst = pst.executeQuery();

        while (rst.next()) {
            lista.add(rst.getString("veterinario"));
            System.out.println(rst.getString("veterinario"));
        }
        return lista;
    }

    public static int getUltimoId() throws SQLException {
        String statement = "SELECT id FROM citas ORDER BY id desc LIMIT 1";
        PreparedStatement pst = conexion.prepareStatement(statement);
        ResultSet rst = pst.executeQuery();
        int id = 0;
        if (rst.next()) {
            id = Integer.parseInt(rst.getString("id"));
        }
        return id;
    }

    public static void cancelarCita(String id) throws SQLException {
        String statment = "UPDATE citas SET estatus = ? "
                + "WHERE id = ?";
        PreparedStatement pst = conexion.prepareStatement(statment);
        pst.setString(1, "C");
        pst.setString(2, id);
        pst.executeUpdate();
    }

    public static void atenderCita(String id) throws SQLException {
        String statment = "UPDATE citas SET estatus = ? "
                + "WHERE id = ?";
        PreparedStatement pst = conexion.prepareStatement(statment);
        pst.setString(1, "A");
        pst.setString(2, id);
        pst.executeUpdate();
    }

    public static ArrayList<Cita> listaCitasCliente(String cliente) throws SQLException, ClientesExcepciones, UserNotFound {
        ArrayList<Cita> lista = new ArrayList<>();
        String statement = "SELECT * FROM citas WHERE cliente = ?";

        PreparedStatement pst = conexion.prepareStatement(statement);
        pst.setString(1, cliente);
        ResultSet rst = pst.executeQuery();

        while (rst.next()) {
            String id = rst.getString("id");
            Cliente cliente1 = daoClientes.consulta(rst.getString("cliente"));
            Veterinario vet = daoVeterinarios.consulta(rst.getString("veterinario"));
            String nomMascota = rst.getString("mascota");
            String tipo = rst.getString("tipo");
            char estatus = rst.getString("estatus").charAt(0);
            int dia = Integer.parseInt(rst.getString("dia"));
            int mes = Integer.parseInt(rst.getString("mes"));
            int ano = Integer.parseInt(rst.getString("ano"));
            int hora = Integer.parseInt(rst.getString("hora"));
            int minutos = Integer.parseInt(rst.getString("minutos"));
            LocalDateTime fecha = LocalDateTime.of(ano, mes, dia, hora, minutos);
            lista.add(new Cita(id, vet, cliente1, nomMascota, fecha, tipo, estatus));
        }
        return lista;
    }

    public static ArrayList<Cita> listaCitasPendienteCliente(String cliente) throws SQLException, ClientesExcepciones, UserNotFound {
        ArrayList<Cita> lista = new ArrayList<>();
        String statement = "SELECT * FROM citas WHERE cliente = ? AND estatus = 'P' ";

        PreparedStatement pst = conexion.prepareStatement(statement);
        pst.setString(1, cliente);
        ResultSet rst = pst.executeQuery();

        while (rst.next()) {
            String id = rst.getString("id");
            Cliente cliente1 = daoClientes.consulta(rst.getString("cliente"));
            Veterinario vet = daoVeterinarios.consulta(rst.getString("veterinario"));
            String nomMascota = rst.getString("mascota");
            String tipo = rst.getString("tipo");
            char estatus = rst.getString("estatus").charAt(0);
            int dia = Integer.parseInt(rst.getString("dia"));
            int mes = Integer.parseInt(rst.getString("mes"));
            int ano = Integer.parseInt(rst.getString("ano"));
            int hora = Integer.parseInt(rst.getString("hora"));
            int minutos = Integer.parseInt(rst.getString("minutos"));
            LocalDateTime fecha = LocalDateTime.of(ano, mes, dia, hora, minutos);
            lista.add(new Cita(id, vet, cliente1, nomMascota, fecha, tipo, estatus));
        }
        return lista;
    }

    public static ArrayList<Cita> listaCitasPendienteVet(String vet) throws SQLException, ClientesExcepciones, UserNotFound {
        ArrayList<Cita> lista = new ArrayList<>();
        String statement = "SELECT * FROM citas WHERE veterinario = ? AND estatus = 'P' ";

        PreparedStatement pst = conexion.prepareStatement(statement);
        pst.setString(1, vet);
        ResultSet rst = pst.executeQuery();

        while (rst.next()) {
            String id = rst.getString("id");
            Cliente cliente1 = daoClientes.consulta(rst.getString("cliente"));
            Veterinario vete = daoVeterinarios.consulta(rst.getString("veterinario"));
            String nomMascota = rst.getString("mascota");
            String tipo = rst.getString("tipo");
            char estatus = rst.getString("estatus").charAt(0);
            int dia = Integer.parseInt(rst.getString("dia"));
            int mes = Integer.parseInt(rst.getString("mes"));
            int ano = Integer.parseInt(rst.getString("ano"));
            int hora = Integer.parseInt(rst.getString("hora"));
            int minutos = Integer.parseInt(rst.getString("minutos"));
            LocalDateTime fecha = LocalDateTime.of(ano, mes, dia, hora, minutos);
            lista.add(new Cita(id, vete, cliente1, nomMascota, fecha, tipo, estatus));
        }
        return lista;
    }

}
