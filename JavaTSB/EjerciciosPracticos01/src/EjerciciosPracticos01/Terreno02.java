package EjerciciosPracticos01;

import java.util.Scanner;

public class Terreno02 {

    public static void main(String[] args) {


      /*
      Ingresar por teclado las medidas de frente y fondo (en metros) de un terreno y determinar:

Impuestos a pagar, sabiendo que abona $ 80 por m2
Cantidad de metros de alambre requeridos para realizar un cerco de 3 vueltas.
      * */
        System.out.println("*********Terreno************");

        Scanner sc=new Scanner(System.in);
        final int precio=80;


        System.out.println("ingrese las medidas");
        System.out.println("frente:");
        Float frente=sc.nextFloat();
        System.out.println("fondo:");
        Float fondo=sc.nextFloat();
        Float rtdo=precio*(frente*fondo);



        System.out.println("El valor del m2 es $" + precio);
        System.out.println("Los impuestos a pagar son: " + rtdo + " pesos");
        System.out.println("La Cantidad de metros de alambre requeridos para realizar un cerco de 3 vueltas es " + rtdo*3 + "  mts" );
    }
}



