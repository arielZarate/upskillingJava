package entradaDatos;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);

        System.out.println("ingrese un numero");
        int i=sc.nextInt();


        System.out.println("ingrese un otro numero");
        int j=sc.nextInt();


        int suma=i+j;
        System.out.println("los datos ingresados son " + i + " y " + j + " y la suma de ambos es " + suma);

    }
}
