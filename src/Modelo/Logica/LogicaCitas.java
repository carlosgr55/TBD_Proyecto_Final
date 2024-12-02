package Modelo.Logica;

import Excepciones.CitasException;
import Excepciones.UserNotFound;
import Modelo.DAO.daoCitas;
import Modelo.DAO.daoVeterinarios;
import Modelo.VO.Cita;
import Modelo.VO.Cliente;
import Modelo.VO.Veterinario;
import Vista.VistaAgendarCita;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Random;

public class LogicaCitas {

    private Random rand = new Random();

    public Cita crearCita(Cliente cliente, String mascota, String tipo, LocalDateTime fecha) throws SQLException, CitasException, UserNotFound {
        int dia = fecha.getDayOfMonth();
        int mes = fecha.getMonthValue();
        int ano = fecha.getYear();
        int hora = fecha.getHour();
        int min = fecha.getMinute();
        Veterinario vet = getVetDisp(dia, mes, ano, hora, min);
        Cita cita = new Cita("", vet, cliente, mascota, fecha, tipo);
        int ultimoId = daoCitas.getUltimoId();
        cita.crearId(ultimoId);
        System.out.println(cita.toString());
        return cita;
    }

    public Veterinario getVetDisp(int dia, int mes, int ano, int hora, int min) throws SQLException, CitasException, UserNotFound {
        ArrayList<String> vetsOcupados = daoCitas.vetsOcupados(dia, mes, ano, hora, min);
        ArrayList<String> vetsPotenciales = daoVeterinarios.veterinariosPotenciales();
        vetsPotenciales.removeAll(vetsOcupados);

        if (vetsOcupados.isEmpty()) {
            Veterinario veterinario = daoVeterinarios.consulta(vetsPotenciales.getLast());
            return veterinario;
        }

        if (vetsPotenciales.size() == 0) {
            throw new CitasException("No hay citas disponibles para esta fecha, seleccione otra hora o dia");
        } else {
            int total = vetsPotenciales.size();
            String vet = vetsPotenciales.get(0);
            Veterinario veterinarioDisp = daoVeterinarios.consulta(vet);

            return veterinarioDisp;
        }
    }

}
