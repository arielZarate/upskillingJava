package ManejoCadenas;

import javax.sound.midi.SysexMessage;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {
        Cadenas cadenas=new Cadenas();
        int op=-1;

        Scanner sc=new Scanner(System.in);

        do{
            System.out.println("**Manejo de cadenas en java**");
            System.out.println("ingrese 1 : para encontrar un caracter en una cadena");
            System.out.print("ingrese su opcion:");
            int x=sc.nextInt();

            switch (x)
            {
                case 1:
                    System.out.println("debe ingresar el formato: (cadena,caracter)");
                    System.out.print("ingrese la cadena: ");
                    //"Hola Juan Carlos Chupa Pija ..! @"
                    sc.skip("\n");
                    String cadena=sc.next();


                    System.out.print("ahora el caracter :");
                    String aux=sc.next();
                    //lo que hago es obtener el primer caracter del string
                    char c=aux.charAt(0);

                    if( cadenas.ExisteCaracter(cadena,c))
                    {
                        System.out.println("El caracter " + c + " esta en la cadena " + "' " + cadena+ "' ");
                    }
                    else{
                        System.out.println("no se ha encontrado el caracter");
                    }

                    break;
                default:
                    System.out.println("ha ingresado incorrectamente la opcion");
            }

        }while(op!=0);


        System.out.println("ha finzalizado el programa 🚓🏍🏎🚂🚋🛺🚗✈🛩🚀🛸");




    }

}
