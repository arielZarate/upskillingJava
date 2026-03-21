package EjerciciosPracticos01;

import java.util.Scanner;

public class Bienvenido01 {


    public static void main(String[] args) {

        System.out.println("Bienvenido a TSB\n");


        Scanner sc=new Scanner(System.in);
        System.out.println("Ingrese nombre de Alumno");
        String name=sc.nextLine();

        System.out.println("");
        System.out.println("Bienvenido [" +name+ "] a TSB" );

    }
}
