package Trivago;

import java.beans.ExceptionListener;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        /*
        Este ejercicio intenta replicar la funcionalidad del sitio de Trivago,
        pero en una pequeña muestra.
         Suponiendo que el usuario ya ha seleccionado su ciudad de destino,
          y obtenido un conjunto de n hoteles,
        el programa debe generar automáticamente un arreglo bidimensional,
          donde cada fila representa un hotel y cada columna el precio de dicho
          hotel en los sitios Despegar, Booking y Expedia respectivamente.
        Con los datos cargados, el programa debe implementar la siguiente funcionalidad:
    • Mostrar los resultados de la búsqueda (arreglo)
    • Informar el precio promedio para cada sitio
    • Generar un nuevo listado conteniendo, para cada hotel, el mejor precio de los 3 sitios
         */
        //********************************************
        try {
            Trivago trivago = new Trivago();


            Scanner scanner = new Scanner(System.in);
            int opcion, n = -1;
            do {
                System.out.println("-------------------------------");
                System.out.println("MENU DE ARREGLOS");
                System.out.println("1. Ciudades");
                System.out.println("2. Generar Hoteles");
                System.out.println("3. Buscar (Arreglo)");
                System.out.println("4. Precio Promedio de cada sitio");
                System.out.println("5. Mejor Precio Por Hotel ");
                System.out.println("0. Salir");
                System.out.print("Ingrese su opcion: \n");
                opcion = scanner.nextInt();
                switch (opcion) {

                    case 1:
                        // int op2=-1;
                        //  do{
                          trivago.Mostrarciudades();
                        // op2 = scanner.nextInt();
                        // }while(op2 != 0);
                        break;

                    case 2:
                       System.out.println("ingrese la cantidad de hoteles a generar");
                        int cant = scanner.nextInt();
                        //int  cant = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de Hoteles que decea generar"));

                        System.out.println("|Hotel|*****|Precio|");
                         trivago.Imprimir(trivago.generarHotelesAleatorios(cant));
                        break;

                    case 3:
                        System.out.print("Ingrese nombre de Hotel a buscar: ");

                 /*
                 Para introducir varias lineas string se usa  nextLine()
                 pero ocurre el error de que como el nextLine() toma el enter
                 como un salto de linea automatico infiriendo que ya cargaste los datos
                 2 opciones

                 1era solucion   sca.skip("\n");
                  String nom = scanner.nextLine();
                 2da solucion    scanner.nextLine();
                            String nom = scanner.nextLine();
                  */
                        // scanner.nextLine();
                        scanner.skip("\n");
                        String nom = scanner.nextLine();

                        //replaceAll quita los espacios en blanco entre palabras
                        String aux = nom.replaceAll(" ", "");
                        //System.out.println("se va ingresar " +  aux);

                        System.out.println("-------------");
                           System.out.println(trivago.BuscarNombreHotel(aux));
                        break;


                    case 4:
                        System.out.println("Precio Promedio ");
                         System.out.println("el precio Promedio Gral (no por ciudad) para vacacionar es de : $" + trivago.PrecioPromedio() + " dolares \n");
                        System.out.println("Cosa que vos negro pobre argentino no podes hacer , andate a rio Ceballos no mas 🤣🤣🤣🤣🤣🤣🤣 ");
                        break;
                    case 5:

                        //trivago.Imprimir(trivago.onlyNames);
                        System.out.print("ingrese el nombre del hotel para saber el precio");
                        scanner.skip("\n");
                        String nom2 = scanner.nextLine();

                        //replaceAll quita los espacios en blanco entre palabras
                        String aux2 = nom2.replaceAll(" ", "");
                        //System.out.println("se va ingresar " +  aux2);

                        System.out.println("-------------");
                        System.out.println("Precio menor  por hotel es : $ "+trivago.MejorPrecioPorHotel(aux2));
                        break;

                    case 0:
                        System.out.println("Ha finalizado el Programa Prueba ");
                        System.out.println("@copyrigth ArielZarate");
                        break;
                    default:
                        System.out.println("Esa opción no existe");
                }
                //System.out.println("-------------------------------");
            }
            while (opcion != 0);





        } catch (Exception e) {
            System.out.println("Error: " + e.fillInStackTrace());
            System.out.println("Ha ocurrido un Error En la Ejecucion del Programa\nEjecute nuevamente!!");

        }
    }
}




