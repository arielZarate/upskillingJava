package Excepciones;

public class OperacionExcepcion extends RuntimeException {


    //aplico sobrecarga
    public OperacionExcepcion(String message, Throwable cause) {
        super(message, cause);

    }

    public OperacionExcepcion(String message) {
        super(message);

    }

}
