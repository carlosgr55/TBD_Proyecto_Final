package Excepciones;

import java.awt.Component;
import javax.swing.JOptionPane;

public class DatosIncompletosException extends Exception {

    public DatosIncompletosException() {
        super();
        JOptionPane.showMessageDialog(null, "Los campos marcados con * deben estar llenos");
    }

    public DatosIncompletosException(String msg) {
        super(msg);
    }
}
