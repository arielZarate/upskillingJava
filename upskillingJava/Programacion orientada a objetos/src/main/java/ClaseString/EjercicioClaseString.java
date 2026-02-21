package ClaseString;


import java.util.Scanner;

/**
 * @author ariel Zarate

 * * Ejercicio:
 * Desarrolla un programa que solicite al usuario que ingrese una frase.
 *
 * •
 * Realiza las siguientes operaciones con la frase:
 *
 * •
 * Cuenta la cantidad de caracteres en la frase.
 *
 * •
 * Verifica si la frase contiene una determinada palabra utilizando el método contains().
 *
 * •
 * Convierte la frase a minúsculas y/o mayúsculas.
 *
 * •
 * Imprime solo la primera palabra de la frase utilizando el método substring().
 *
 * •
 * Agrega 2 o más palabras en cualquier punto de la frase.
 *
 * •
 * Muestra los resultados de cada operación en pantalla.
 *
 * **/
public class EjercicioClaseString {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese una frase:");
        String frase = scanner.nextLine();

        // Cuenta la cantidad de caracteres en la frase

        System.out.println("La cantidad de caracteres en la frase es: " + frase.length());

        // Verifica si la frase contiene una determinada palabra utilizando el método indexOf().
        System.out.println("Ingrese una palabra para verificar si está en la frase:");
        String palabra = scanner.nextLine();

        if (frase.contains(palabra)) {
            System.out.println("La frase contiene la palabra: " + palabra);
        } else {
            System.out.println("La frase no contiene la palabra: " + palabra);
        }


        // Convierte la frase a minúsculas y/o mayúsculas.
        System.out.println("Frase en mayúsculas: " + frase.toUpperCase());
        System.out.println("Frase en minúsculas: " + frase.toLowerCase());

        // Imprime solo la primera palabra de la frase utilizando el método substring().

        System.out.println("Primera palabra de la frase: " + frase.substring(0, 1));
    }

}
