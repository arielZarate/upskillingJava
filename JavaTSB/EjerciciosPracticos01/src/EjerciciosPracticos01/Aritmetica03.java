package EjerciciosPracticos01;


import java.util.Scanner;

public class Aritmetica03 {
    public static void main(String[] args) {
        /*
     3. Aritmética
     Desarrollar un programa que a partir de dos datos ingresados
     por teclado, realice
     sobre ellos las cuatro operaciones aritméticas básicas.
     */


        System.out.println("********Operaciones matematicas*******");
        Scanner sc=new Scanner(System.in);
        System.out.println("ingrese un valor ");
        float x=sc.nextFloat();
        System.out.println("ingrese otro valor ");
        float z=sc.nextFloat();

        System.out.println("\n**** operacion de la suma **** \n");
        int suma= (int) ((int)x+z);
        System.out.println("la suma de "+ (int)x + " mas "+ (int)z+ " es : " + suma);



        System.out.println("\n**** operacion de la resta **** \n");
        int  resta=(int) ((int)x-z);
        System.out.println("la resta de "+ (int)x + " menos "+ (int)z+ " es : " + resta);


        System.out.println("\n**** operacion de la Multiplicacion **** \n");
        int mult= (int) ((int)x*z);
        System.out.println("la multiplicacion de "+ (int)x + " x "+ (int)z+ " es : " + mult);


        System.out.println("\n**** operacion de la Division **** \n");
        float div= x/ z;

        if(z !=0)
        { System.out.println("la division de "+ (int)x + " div "+ (int)z + " es : " + div);
        }else
        {
            System.out.println("El valor del denominador es cero ");
        }


        System.out.println("*****Fin de las  Operaciones*****");
    }











}
