package ArregloContadores;

import java.util.Scanner;

public class ArrayContador {

    public static void main(String[] args) {

        Contador.ejecutar();


    }

    private static class Contador {
        public static void ejecutar() {

            Scanner sc = new Scanner(System.in);

           int cont1 = 0;
            int cont2 = 0;
            int[] arreglo = null;


            arreglo = new int[2];


            int op2 = -1;
            do {
                System.out.println("ingrese 1 para cargar");
                System.out.println("ingrese 2 mostrar a cargar");
                System.out.println("Para cortar Presione 0");
                System.out.print("ingrese:");
                op2 = sc.nextInt();

                switch (op2) {
                    case 1:
                        System.out.print("num : ");
                        int num = sc.nextInt();

                        if (num <= 50) {
                            cont1++;
                            arreglo[0] =cont1;
                        } else {
                            cont2++;
                            arreglo[1] = cont2;
                        }

                        break;
                    case 2:
                        for (int i = 0; i < arreglo.length; i++) {

                            System.out.println(arreglo[i]);

                        }
                        break;
                    case 0:
                        System.out.println("corto la carga");
                        break;

                }
            }
            while (op2 != 0);


            System.out.println("El programa finalizo.");


        }
    }
}