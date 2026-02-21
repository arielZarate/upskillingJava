package FundamentosJava;

import java.util.Scanner;

/**
 * @author : ariel Zarate
 * */
public class BuclesYCondicionales {
    public static void main(String[] args) {

        System.out.println("****condicional Basico****");
        Condicional();

        System.out.println("\n****Bucles******");
        System.out.println("bucle for ");
        bucleFor();

        System.out.println("bucle while");
        bucleWhile();

        System.out.println("bucle do-while");
        bucleDoWhile();

        System.out.println("****condicional  par /impar ****");
        CondicionalNumeroPar();
    }


    public static void Condicional(){
        int edad = 18;

        if (edad >= 18) {
            System.out.println("Eres mayor de edad.");
        } else {
            System.out.println("Eres menor de edad.");
        }
    }

    public static void CondicionalNumeroPar(){
        Scanner scanner=new Scanner(System.in);
        //defining a variable
        int number=0;
        System.out.println("ingrese un numero: \n");
         number=scanner.nextInt();
        //Check if the number is divisible by 2 or not
        if(number%2==0){
            System.out.println("numero par ");
        }else{
            System.out.println("numero impar");
        }
    }

    public static void bucleFor(){
        for (int i = 1; i <= 5; i++) {
            System.out.println("Número: " + i);
        }
    }

    public static void bucleWhile(){
        int i = 1;
        while (i <= 5) {
            System.out.println("Número: " + i);
            i++;
        }
    }

    public static void bucleDoWhile() {
        int i = 1;
        do {
            System.out.println("Número: " + i);
            i++;
        } while (i <= 5);

    }
}
