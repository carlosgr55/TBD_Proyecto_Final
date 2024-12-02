package Modelo.VO;

public class Mascota {

    private int id;
    private String nombre;
    private String especie; //Solo puede ser: PERRO, GATO, AVE, PEZ, ROEDOR
    private char sexo;
    private String cliente;

    public Mascota(String nombre, String especie, char sexo) {
        this.nombre = nombre;
        this.especie = especie;
        this.sexo = sexo;
    }

    public Mascota(int id, String nombre, String especie, char sexo, String cliente) {
        this.id = id;
        this.nombre = nombre;
        this.especie = especie;
        this.sexo = sexo;
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return nombre;
    }

}
