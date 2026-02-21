package FundamentosJava;

/**
 * @author : ariel Zarate
 * */

public class TiposYVariables {

    public static void main(String[] args) {

        int edad = 30;
        double precio = 99.99;
        char letra = 'J';
        boolean esJavaGenial = true;

        System.out.println("Edad: " + edad);
        System.out.println("Precio: " + precio);
        System.out.println("Letra: " + letra);
        System.out.println("¿Es Java genial? " + esJavaGenial);

        System.out.println("\n");
        System.out.println("********Operadores**********");
        int a = 10, b = 5;
        System.out.println("Suma: " + (a + b));
        System.out.println("Resta: " + (a - b));
        System.out.println("Multiplicación: " + (a * b));
        System.out.println("División: " + (a / b));
        System.out.println("Módulo: " + (a % b));
    }

}
