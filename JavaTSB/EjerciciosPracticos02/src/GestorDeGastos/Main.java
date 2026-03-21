package GestorDeGastos;


import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {


    /*
  3. Gestor de Gastos
Una empresa cuenta con 3 sucursales numeradas desde la 0 a la 2,
y necesita gestionar sus gastos por mes. De cada gasto se registra lo siguiente:
    • Código.
    • Descripción.
    • Mes (1-12).
    • Sucursal (0-2)
    • Importe.
Se necesita hacer lo siguiente, trabajando desde un menú de opciones:
    1. Cargar los n gastos en un vector.
    2. Mostrar el vector de gastos, ordenado por importe.
    3. Buscar un gasto con código c, siendo c un valor que se carga por teclado.
    Si lo encuentra mostrar sus datos y reemplazar el importe con un valor
    ingresado por teclado, sino lo encuentra informar con un mensaje.
    4. Generar una matriz de acumulación, que represente el gasto total por mes y sucursal.
     */


        Scanner sc = new Scanner(System.in);
        int opcion;
        int tam=0;
        int code1,code2=0;
        int codigo,mes,sucursal=-1;
        String descripcion=""; double importe=0;
        Gastos []gastos;





        System.out.println(" Ingrese cuantos gastos va registrar ");
        tam=sc.nextInt();

        if(tam!=0) {
            {
                gastos = new Gastos[tam];
                System.out.println("Vector de Gastos Generado");
                System.out.println("----------------------");
            }

            do {
                System.out.println("----------------------");
                System.out.println("****MENU DE GASTOS*******");

                System.out.println("1. Cargar gastos ");
                System.out.println("2. Mostrar Gastos ");
                System.out.println("3. Buscar un gasto con código");
                System.out.println("4. Generar matriz de acumulacion de total por mes y sucursal");
                System.out.println("0. Salir");
                System.out.print("Ingrese su opcion: ");
                opcion = sc.nextInt();

                switch (opcion) {
                    case 1:


                        System.out.println("\n--Cargamos los datos--");

                        for (int i = 0; i < gastos.length; i++) {
                            System.out.print("ingrese Codigo :");
                            codigo = sc.nextInt();

                            System.out.print("ingrese Descripcion :");
                            descripcion = sc.next();

                            System.out.print("ingrese mes [1-12]:");
                            mes = sc.nextInt();

                            System.out.print("ingrese sucursal [1-2-3] :");
                            sucursal = sc.nextInt();

                            System.out.print("ingrese importe :");
                            importe = sc.nextDouble();

                            gastos[i] = new Gastos(codigo, descripcion, mes, sucursal, importe);

                            System.out.println("datos Cargados con exito\n");

                        }
                        break;


                    case 2:
                        for (int i = 0; i < gastos.length ; i++) {
                            System.out.println(gastos[i].toString());
                        }break;


                    case 3:
                        System.out.println("--------------------");
                        System.out.println("ingrese un codigo de gasto");
                        code1=sc.nextInt();
                        for (int i = 0; i < gastos.length; i++) {
                            if(gastos[i].getCodigo()==code1)
                            {
                                System.out.println("El codigo es " + gastos[i].getCodigo());
                                System.out.println("ingrese el nuevo codigo para mofificar el anterior");
                                code2=sc.nextInt();
                                gastos[i].setCodigo(code2);
                                System.out.println("codigo modificado con exito");
                                break;

                            }else {
                                System.out.println("No se encuentro el codigo buscado En la sucursal esta " );
                            }
                        }
                        break;

                    case 4:
                        int cant=0;
                        double suma1=0 ,suma2=0,suma3=0;

                        // 4. Generar una matriz de acumulación, que represente el gasto total por mes y sucursal.
                        System.out.println("********AVISO! Debe tener varios dias de gastos generados******\n");

                        System.out.println("GastoTotal  Sucursal");
                        for (int i = 0; i < gastos.length; i++) {
                            if(gastos[i].getSucursal()==1) {
                                suma1 += gastos[i].getImporte();

                                System.out.println(suma1 + "        " + gastos[i].getSucursal());
                            }
                            else
                            if(gastos[i].getSucursal()==2)
                            {
                                suma2+= gastos[i].getImporte();
                                System.out.println(suma2 +"        "+ gastos[i].getSucursal() );
                            }
                            else
                            if(gastos[i].getSucursal()==3)
                                suma3+= gastos[i].getImporte();
                            System.out.println(suma3 +"        "+ gastos[i].getSucursal() );

                        }
                                /*

                        for (int i = 0; i < gastos.length; i++) {

                        }

                        for (int i = 0; i < gastos.length; i++) {

                        }

                                 */

                        break;
                    case 0:
                        System.out.println("Hasta pronto!");
                        break;
                    default:
                        System.out.println("Esa opción no existe");
                }


            } while (opcion != 0);


        }else {
            System.out.println("Error tamaño de vector incorrecto!!");

        }
    }

}