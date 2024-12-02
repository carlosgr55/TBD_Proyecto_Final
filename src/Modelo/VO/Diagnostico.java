package Modelo.VO;

public class Diagnostico {

    private String id;
    private String diagnostico;
    private Cita cita;
    private double precio;

    public Diagnostico(String diagnostico, Cita cita, double precio) {
        this.diagnostico = diagnostico;
        this.cita = cita;
        this.precio = precio;
        this.id = "D" + cita.getId();
    }

    public Diagnostico(String diagnostico, Cita cita) {
        this.diagnostico = diagnostico;
        this.cita = cita;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public Cita getCita() {
        return cita;
    }

    public void setCita(Cita cita) {
        this.cita = cita;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
