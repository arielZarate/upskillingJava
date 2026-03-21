package NumeroPrimo;

import javax.sound.midi.SysexMessage;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        NumeroPrimo n =new NumeroPrimo();
        Scanner sc = new Scanner(System.in);
        int op=0;
        double val=0.0;
        do {
            System.out.println("\n****numeros primos*****");
            System.out.println("ingrese 1 para ingresar un numero y saber si es primo");
            System.out.println("ingrese 2 para ingresar un vector de numeros y saber cual es primo");
            System.out.println("ingrese 3 para ingresar un vector de numeros y saber cual es primer numero primo");
            System.out.println("ingrese 0 para cortar ");
            op=sc.nextInt();


            switch (op)
            {
                case 0:
                    System.out.println("fin del programa");break;
                case 1:
                    System.out.println("ingrese un numero");
                    val=sc.nextDouble();
                    System.out.println(n.esPrimo(val));

                    break;
                case 2:
                    System.out.println("ingrese el tamaño del vector");
                    int tam=sc.nextInt();
                    double val2=0;
                    double []v=new double[tam];

                    for (int i = 0; i < v.length; i++) {
                        System.out.print("ingrese numero a cargar");
                        val2= sc.nextDouble();
                        v[i]=val2;
                    }

                    System.out.println("Calculamos los primos");
                   n.esPrimoVector(v);
                   break;
                case 3:
                    System.out.println("ingrese el tamaño del vector");
                    int tam2=sc.nextInt();
                    double val3=0;
                    double []v1=new double[tam2];

                    for (int i = 0; i < v1.length; i++) {
                        System.out.print("ingrese numero a cargar: ");
                        val3= sc.nextDouble();
                        v1[i]=val3;
                    }

                    System.out.println("Calculamos los primos");
                    n.PrimerNumeroPrimo(v1);
                    break;

                default:
                    System.out.println("ingreso una opcion incorrecta");
            }

        }while (op!=0);



    }
}
