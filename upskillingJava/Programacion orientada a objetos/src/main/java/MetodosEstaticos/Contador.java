package MetodosEstaticos;

/**
 *@author :Ariel zarate
 * La clase Contador es un ejemplo de cómo utilizar métodos estáticos para mantener un contador global
 * se puede incrementar o decrementar el contador utilizando métodos estáticos y no estáticos respectivamente.
 * El métod obtenerContador es estático, lo que permite acceder al valor del contador sin necesidad de crear una instancia de la clase Contador.
 * Esto demuestra cómo los métodos estáticos pueden ser utilizados para compartir datos entre todas las instancias de una clase o para mantener un estado global.
 *
 * */

public class Contador {

    private static int contador = 0;

    public Contador() {
    }

    public static void incrementarContador() {
        contador++;
    }

    public void decrementarContador() {
        contador--;
    }

    public static int obtenerContador() {
        return contador;
    }


}
