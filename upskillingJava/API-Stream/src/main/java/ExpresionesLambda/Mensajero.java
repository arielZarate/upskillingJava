package ExpresionesLambda;


/**
 *
 * @author Ariel Zarate

 *  FunctionalInterface
 * “Esta interfaz está pensada para lambdas”
   “No le agregues métodos abstractos”
   Es una señal de diseño, no solo técnica.
 *
 * */

@FunctionalInterface
public interface Mensajero {

    public void enviarMensaje(String nombre, String edad);

    public static void main(String[] args) {

        Mensajero mensajero = (nombre, edad) -> System.out.println("Hola " + nombre + ", tu edad es: " + edad);

        mensajero.enviarMensaje("Juan", "30");

    }
}
