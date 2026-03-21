package Prueba2;

import java.util.Scanner;

public class Main2 {


    public static void main(String[] args) {
       /*
        Object obj = "Peter Gabriel";

        System.out.println(obj);

        */

        int num=0;
        String letra="";
        Scanner sc=new Scanner(System.in);
        Object v[] = new Object[10];

        for (int i = 0; i < v.length ; i++) {

            System.out.print("numero :");
            v[i]=sc.nextInt();

            System.out.println("");


            /*
            System.out.print("letra:");
            v[i]=sc.nextLine();
             */




        }


        for (Object o: v) {
            System.out.println(o);
        }
    }

}


