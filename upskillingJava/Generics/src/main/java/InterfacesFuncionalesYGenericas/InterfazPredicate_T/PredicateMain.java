package InterfazPredicate_T;

/*
Predicate<T>
La interfaz funcional `Predicate<T>` representa una condición que se puede evaluar para cualquier tipo de
dato. Tiene un método llamado `test` que toma un argumento de tipo `T` y devuelve un valor booleano

(seguramente habrás notado que hay un símbolo de diamante `<T>` junto al nombre de la interfaz, este es
un concepto llamado "genéricos", que nos permite crear clases e interfaces que pueden trabajar con
diferentes tipos de datos sin especificarlos de antemano. Pero no te preocupes, profundizaremos en este
tema más adelante, por el momento, pensemos que T puede ser cualquier tipo dentro de nuestra
aplicación).


*
* */


import java.util.Scanner;
import java.util.function.Predicate;

public class PredicateMain {

    public static void main(String[] args) {

        Predicate<Integer> esPar=num-> num%2==0;

        Scanner n=new Scanner(System.in);
        System.out.println("Ingrese un numero\n");
        int num=n.nextInt();

        boolean res=esPar.test(num);
        if (res) {
            System.out.println("El numero " + num + " es par");
        } else {
            System.out.println("El numero " + num + " es Impar");
        }


    }

}
