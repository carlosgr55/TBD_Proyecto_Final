package Modelo.VO;

public class Admin extends Persona {

    private String Usuario;
    private String Password;

    public Admin(String nombre, String apellido, String telefono, String correo, int edad) {
        super(nombre, apellido, telefono, correo);
    }

    public Admin() {
        super("Tokischa", "Castro", "65515145", "Toki69@gmail.com");
        this.Usuario = "toki";
        this.Password = "chulo";
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

}
