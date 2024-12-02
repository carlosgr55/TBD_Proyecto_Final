package Modelo.VO;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

public class Veterinario extends Persona {

    private String cedula;
    private ArrayList<String> especialidad = new ArrayList<>();
    private double sueldo;
    private String usuario;
    private String password;
    private ArrayList<LocalDateTime> disponibilidad = new ArrayList<>();
    private ArrayList<String> horasDisponibles = new ArrayList<>();

    public Veterinario(String cedula, double sueldo, String usuario, String password, String nombre, String apellido, String telefono, String correo) {
        super(nombre, apellido, telefono, correo);
        this.cedula = cedula;
        this.sueldo = sueldo;
        this.usuario = usuario;
        this.password = password;
        cargarDisp();
    }
    
    
    

    public Veterinario() {
        super();
        cedula = "";
        sueldo = 0;
        usuario = "";
        password = "";
        especialidad = null;
        cargarDisp();
    }

    public ArrayList<String> getHorasDisponibles() {
        return horasDisponibles;
    }

    public void setHorasDisponibles(ArrayList<String> horasDisponibles) {
        this.horasDisponibles = horasDisponibles;
    }
    
    

    private void cargarDisp() {
        this.horasDisponibles.add("09:00");
        this.horasDisponibles.add("10:00");
        this.horasDisponibles.add("11:00");
        this.horasDisponibles.add("12:00");
        this.horasDisponibles.add("13:00");
        this.horasDisponibles.add("14:00");
        this.horasDisponibles.add("15:00");
        this.horasDisponibles.add("16:00");
        this.horasDisponibles.add("17:00");
        this.horasDisponibles.add("18:00");
    }

    public void addHora(LocalDateTime hora) {
        this.disponibilidad.add(hora);
    }

    public void quitarHora(LocalDateTime hora) {
        this.disponibilidad.remove(hora);
    }

    public void addEspecialidad(String esp) {
        this.especialidad.add(esp);
    }

    public void quitarEspecialidad(String esp) {
        this.especialidad.remove(esp);
    }

    public ArrayList<String> getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(ArrayList<String> especialidad) {
        this.especialidad = especialidad;
    }

    public ArrayList<LocalDateTime> getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(ArrayList<LocalDateTime> disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Veterinario{" + "cedula=" + cedula + ", especialidad=" + especialidad + ", sueldo=" + sueldo + ", usuario=" + usuario + ", password=" + password + ", disponibilidad=" + disponibilidad + '}';
    }

}
