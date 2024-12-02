package Modelo.Logica;

import Excepciones.DatosIncompletosException;

public class LogicaCampos {

    public static void camposLlenos(boolean lleno) throws DatosIncompletosException {
        if (!lleno) {
            throw new DatosIncompletosException();
        }
    }    

}
