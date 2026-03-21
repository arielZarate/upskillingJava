package excepciones.ExcepcionesCustomizados;

public class CustomException extends Exception{


    // Constructor que acepta un mensaje de error
    public CustomException(String mensaje) {
        super(mensaje);
    }

}
