package interfaces.InterfacesCalculadora;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CalculadoraBasica c1=new CalculadoraBasica();

        Scanner scan=new Scanner(System.in);


        System.out.println("ingrese el numero A \n");
        int a=scan.nextInt();
        //
        System.out.println("ingrese el numero B \n");
        int b=scan.nextInt();





        System.out.println("Sumar:" + c1.sumar(a,b));
        System.out.println("Sumar:" + c1.restar(a,b));



    }

}
