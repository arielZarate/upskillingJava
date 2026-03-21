package VectorDeEnterosFor;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

    /*
    - Cargar un vector con n números enteros.
    (n ingresado por teclado).
- Informar:
1) Promedio de todos
2) Ubicación del menor
3) Cantidad de pares
- Generar un segundo vector que contenga los valores del vector original que sean múltiplos de un divisor d ingresado por teclado. el segundo vector no debe tener lugares vacios

     */
        Scanner sc=new Scanner(System.in);
        int []vector;  //declarando un vector
        System.out.println("Programa de  vectores");
        System.out.println("ingrese el tamaño del vector");


        int param=sc.nextInt();

        vector=new int[param];//creando  el vector con el parametro pasado por laclase scanner
        System.out.println("se ha creado un vector de tamaño " + vector.length);

        //recoriendo el vector con un for y cargando los valores
        System.out.println("ingresar valores del vector");
        System.out.println("***FOR*****");
        for (int i = 0; i < vector.length; i++) {
            vector[i]=sc.nextInt();
        }


        /*
        System.out.println("****FOR EACH (objetos)*******");
        for (int x :vector ) {
            System.out.println( "valor" + x);
        }
         */

        System.out.println("*****Resultados*******");
        System.out.println("");
        System.out.println("Promedio es  " + Promedio(vector));
        System.out.println("eL Menor esta en el indice " + UbicacionMenor(vector));
        System.out.println("Cantidad de pares " + CantPares(vector));


    }

    //metodos estaticos de laclase

    public static float Promedio(int [] v){
        float suma=0, prom=0 , cant=0;

        for (int i = 0; i < v.length; i++) {
            suma+=v[i];
            cant++ ;
        }
        prom=suma/cant;
        return prom;
    }


    public static int UbicacionMenor(int []v){
        int menor=0;
        int mayor=9999;
        int indice=0;
        for (int i = 0; i < v.length ; i++) {
         if(  v[i] < mayor)
         {
             menor=v[i];
             indice=i;
             mayor=v[i]+1;

         }
        }

        return indice;
    }


    public static int CantPares(int [] v)
    {
        int cant=0;

        for (int i = 0; i < v.length ; i++) {


            if(v[i] % 2 ==0)
            {
                cant ++;
            }
        }
        return cant;
    }
}


