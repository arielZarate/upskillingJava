package FundamentosJava;

/**
 * @author : ariel Zarate
 * */

public class Funciones {
    // Método sin retorno
    public static void saludar() {
        System.out.println("¡Hola, bienvenido a Java!");
    }

    // Método con retorno
    public static int sumar(int a, int b) {
        return a + b;
    }

    //lanzador
    public static void main(String[] args) {
        saludar();
        int resultado = sumar(10, 5);
        System.out.println("La suma es: " + resultado);
    }

}

