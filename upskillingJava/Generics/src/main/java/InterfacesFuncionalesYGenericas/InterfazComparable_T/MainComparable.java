package InterfazComparable_T;


/*
*Comparable<T>
Esta interfaz define un único método llamado `compareTo()`,
El método compareTo devuelve un valor entero que indica la relación entre
* los dos objetos. Los posibles valores de retorno son:

Un número negativo si el objeto actual es menor que el objeto especificado.
Cero si el objeto actual es igual al objeto especificado.
Un número positivo si el objeto actual es mayor que el objeto especificado.
*
*
*
* */

import java.util.Scanner;

public class MainComparable {

    public static void main(String[] args) {

        Scanner scan=new Scanner(System.in);

        System.out.println("Ingrese nombre de la primera persona\n");
        String name1=scan.next();

        System.out.println("Ingrese la edad  de la primera persona\n");
        int  age1=scan.nextInt();

        InterfazComparable_T.Persona p1=new InterfazComparable_T.Persona(name1,age1);


        System.out.println("Ingrese nombre de la segunda persona");
        String name2=scan.next();

        System.out.println("Ingrese la edad  de la segunda persona");
        int  age2=scan.nextInt();
        InterfazComparable_T.Persona p2=new InterfazComparable_T.Persona(name2,age2);

        System.out.println("#############################################");

         int result=p1.compareTo(p2);
        if(result>0)
        {
            System.out.println("Las edades no son iguales dio : " +result + ", La edad de  "+ p1.getName() + " es mayor que " +p2.getName());
        }
        else if(result==0)
        {
            System.out.println("Las edades son iguales dio: " +result);
        }
        else {
            System.out.println("Las edades no son iguales dio: " +result + ", La edad de  "+ p2.getName() + " es mayor que " +p1.getName());
        }



    }

}


