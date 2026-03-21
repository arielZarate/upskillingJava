package InterfacesFuncionales;

public class MainFuncional {






    /*
* Una interfaz funcional en Java es una interfaz que contiene exactamente un solo método abstracto. Este
método es conocido como el "método funcional". La principal utilidad de una interfaz funcional es
proporcionar un único punto de entrada para una función, permitiendo así su uso en expresiones lambda.
Características principales:
 Un solo método abstracto: Sólo debe contener un método abstracto sin implementación.
 Múltiples métodos default o static: Puede tener múltiples métodos default o static con
implementaciones.
 Usos de expresiones lambda: Las interfaces funcionales se utilizan en Java principalmente
para habilitar la programación funcional, permitiendo la implementación concisa de
comportamientos a través de expresiones lambda.
*
* */




    public static void main(String[] args) {

        OperaracionesMatematicas suma= (a,b)-> a+b;
        OperaracionesMatematicas resta=(a,b)->a-b;


        System.out.println("Suma:" + suma.Operar(25,25));
        System.out.println("Resta:" + resta.Operar(130,85));


    }
}
