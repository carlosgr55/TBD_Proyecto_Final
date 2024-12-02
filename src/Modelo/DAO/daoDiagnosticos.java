package Modelo.DAO;

import Conexion.Conexion;
import Excepciones.CitasException;
import Excepciones.ClientesExcepciones;
import Excepciones.DiagnosticosException;
import Excepciones.UserNotFound;
import Modelo.VO.Cita;
import Modelo.VO.Diagnostico;
import java.util.ArrayList;
import java.sql.*;

public class daoDiagnosticos {

    private static final Connection conexion = Conexion.getConexion("root", "Motomami55");

    public static void agregar(Diagnostico diagnostico) throws SQLException {
        String id = diagnostico.getId();
        String cita = diagnostico.getCita().getId();
        String diag = diagnostico.getDiagnostico();
        double precio = diagnostico.getPrecio();

        String statement = "INSERT INTO diagnosticos (id, cita, diagnostico, precio)"
                + "VALUES (?,?,?,?)";
        PreparedStatement pst = conexion.prepareStatement(statement);
        pst.setString(1, id);
        pst.setString(2, cita);
        pst.setString(3, diag);
        pst.setDouble(4, precio);
        pst.executeUpdate();

    }

    public static Diagnostico consulta(String id) throws SQLException, DiagnosticosException, CitasException, ClientesExcepciones, UserNotFound {
        Diagnostico diag = null;

        String statement = "SELECT * FROM diagnosticos WHERE id='" + id + "'";
        PreparedStatement pst = conexion.prepareStatement(statement);
        ResultSet rst = pst.executeQuery();

        if (rst.next()) {
            Cita cita = daoCitas.consulta(rst.getString("cita"));
            String diagnostico = rst.getString("diagnostico");
            double precio = rst.getDouble("precio");
            diag = new Diagnostico(diagnostico, cita, precio);
            diag.setId(id);
            return diag;
        } else {
            throw new DiagnosticosException("No exite el diagnostico");
        }

    }

    public static ArrayList<Diagnostico> getLista() throws SQLException, CitasException, ClientesExcepciones, UserNotFound {
        ArrayList<Diagnostico> lista = new ArrayList<>();

        PreparedStatement pst = conexion.prepareStatement("SELECT * FROM diagnosticos");
        ResultSet rst = pst.executeQuery();

        while (rst.next()) {
            String id = rst.getString("id");
            Cita cita = daoCitas.consulta(rst.getString("cita"));
            String diagnostico = rst.getString("diagnostico");
            double precio = rst.getDouble("precio");
            lista.add(new Diagnostico(diagnostico, cita, precio));
        }
        
        return lista;

    }

}
