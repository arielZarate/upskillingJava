package BuscarOrdenar;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        /*
        1. Ordenar y buscar
           Desarrollar un programa con menú de opciones que implemente lo siguiente:

          Generar en un arreglo n elementos numéricos aleatorios (pueden existir duplicados)
          y  ordenarlo en forma ascendente Mostrar el arreglo

          Buscar un elemento x dentro del arreglo (x se ingresa por teclado).
          Si no existe, informarlo. Si existe, cambiar su signo.
         */

        int opcion, n, x, pos = -1;
        boolean ordenado = false;
        Scanner scanner = new Scanner(System.in);
        Vector vector = new Vector(1);
        do {
            System.out.println("-------------------------------");
            System.out.println("MENU DE ARREGLOS");
            System.out.println("1. Generar");
            System.out.println("2. Mostrar");
            System.out.println("3. Buscar");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opcion: ");
            opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    ordenado = true;
                    System.out.print("Ingrese tamaño del vector: ");
                    n = scanner.nextInt();

                    //llama al constructor y le pasa por parametro el tamaño
                    vector = new Vector(n);
                    vector.generate();
                    vector.OrderAscendent();
                    System.out.println("Vector generado");
                    break;
                case 2:
                    //mostrar el vector
                    vector.MostrarVectorForEach();
                    break;
                case 3:
                    System.out.print("Ingrese el valor a buscar: ");
                    x = (int)scanner.nextInt();


                    //MODIFIQUE  EL CODIGO CON UN METODO QUE ME DEVUELVE TRUE O FALSE

                    boolean b = false;
                    //Comprobamos si el valor x existe en el arreglo , el metodo Devuelve true o false
                    if(vector.ExisteElemento(x) == false )
                    {
                        System.out.println("El valor x NO existe en el arreglo");
                    }
                    else{
                        //por el lado del exito
                    System.out.println("El valor pasado por parametro existe");
                    System.out.println( "El nuevo valor es " + vector.CambiarValorANegativo(x));
                }
                    break;
                case 0:
                    System.out.println("Hasta pronto!");
                    break;
                default:
                    System.out.println("Esa opción no existe");
            }
            System.out.println("-------------------------------");
        }
        while (opcion != 0);

    }
}
