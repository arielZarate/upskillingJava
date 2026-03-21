package ProcesosBasicosArreglo;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //String lote="lote01.txt";
        File f = new File("lote01.txt");
        Scanner sc = new Scanner(System.in);

        Arreglo arreglo = new Arreglo();

        ArrayList<Double> grupo = new ArrayList<Double>();
        //array para poder cargar grupo de 8 numeros
        Double val;


        int op = -1;
        //Double val = 0.0;
        do {
            System.out.println("");
            System.out.println("****Menu de Arreglo de Numeros ****");

            System.out.println("ingrese - 1 para Inicializar el Arreglo (sino lo inicializa no devolvera nada!) ");
            System.out.println("ingrese - 2 para Obtener Listado de Arreglo ");
            System.out.println("ingrese - 3 para Obtener Primer Numero Primo del arreglo ");
            System.out.println("ingrese - 4 para Obtener La Mediana ");
            System.out.println("ingrese - 5 para Obtener El Promedio ");
            System.out.println("ingrese - 6 para Cargar Grupo de Numeros (debera ingresar ud a mano)");
            System.out.println("ingrese - 7 para obtener El Numero mayor del Arreglo ");
            System.out.println("ingrese - 0 para cortar!!!");
            System.out.print("ingrese su opcion:");
            op = sc.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Lectura de numeros en un archivo de texto , aguarde un momento por favor ....");
                    arreglo.InicializarVector(f);
                    System.out.println("Se ha leido el lote de numeros de forma exitosa!");
                    // JOptionPane.showMessageDialog(null,"Se ha inicializado con exito Arreglo ","Array con Lote de numeros",JOptionPane.INFORMATION_MESSAGE);

                    break;
                case 2:
                    System.out.println("****Listado***** \n");
                    System.out.println(arreglo.toString() + "\n\t***Fin de Listado de numeros ***");
                    break;
                case 3:
                    System.out.println("El primer nº primo es el numero " +arreglo.PrimerNumeroPrimo());

                    break;
                case 4:
                    System.out.println("La mediana es " + arreglo.CalcularMediana());
                    break;
                case 5:
                    System.out.println("La suma de Numeros es: " + arreglo.SumaNumerosArreglo() + "\nLa cantidad es: " + arreglo.CantidadNumeros() + "\nEl promedio es: " + arreglo.PromedioArreglo());
                    break;
                case 6:

                    int i;
                    System.out.println("Debe ingresar 3 numeros ");
                    for (i = 0; i < 3; i++) {
                        System.out.println("ingrese numero:");
                        sc.skip("\n");
                        val = sc.nextDouble();

                        // sc.nextLine();
                        grupo.add(i,val);
                    }

                    System.out.println(arreglo.BuscarGrupoDeNumeros(grupo));
                    break;

                case 7:
                    System.out.println(arreglo.NumeroMayorArreglo());
                    break;
                case 0:
                    System.out.println("Ups 🙄😥😯😯😯😯 Corto el programa.");
                    break;
                default:
                    System.out.println("Ha seleccionado incorrectamente");
                    break;
            }


        } while (op != 0);

        System.out.println("🏍🏍🏍🏍🏍🏍🏍🏍🏍🏍🏍🏍🏍 Ha finalizado el menu 🚀🚀🚀🚀🚀");


    }
}
