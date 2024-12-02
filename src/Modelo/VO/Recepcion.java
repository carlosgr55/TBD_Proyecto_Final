package Modelo.VO;

import java.time.LocalDateTime;

public class Recepcion extends Persona {

    private String user, password;
    private double sueldo;

    public Recepcion(String user, String password, double sueldo, String nombre, String apellido, String telefono, String correo) {
        super(nombre, apellido, telefono, correo);
        this.user = user;
        this.password = password;
        this.sueldo = sueldo;
    }

    public Recepcion(String user, String password, double sueldo) {
        this.user = user;
        this.password = password;
        this.sueldo = sueldo;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

}
