package ListaGenerica;

import java.util.AbstractList;
import java.util.ArrayList;

public class PrincipalListaGenerica {
    public static void main(String[] args) {

        /**
         * Podriamos tener un objeto object para manejar cualquier tipo
         * el porblema de esta solucion esta en que tenes que hacer mucho casting y estar validando mucho
         * por eso la solucion es la Programacion Generica es aquella que permite usar cualquier tipo de clase
         * como puede ser string , o integer sin hacer Casting y tiene algunas caracteristicas
         * #Mayor facilidad de codigo
         * #Reutilizacion de codigo (cosa que no se podia con ArrayLis)
         * #comprobacion de errores en tiempo compilacion
         */



        /***
         * lo agrega al tipo File y no tira error el compilador
         * por que sabe que esta bien la sintaxis ,pero en tiempo de ejecucion se clavara
         */
        //archivos.add(new File("tipoFile.hsdgds"));

        /**
         * Ahora quiero agregar archivos
         * debo crear una clase para cada cosa
         */

        /*archivos.add(new File("gestion_Pedidos.ccdhd") );

        File nombrePersona=(File)archivos.get(0);
        System.out.println(nombrePersona);

         */

        //   objectEjemplo  archivos =new objectEjemplo(4);


        /**
         Problemas de la progrmacion comun solo con objectEjemplo usando objectos
         debemos hacer casting funciona pero no es la solucion
         */
        // String nombrePersona=(String)archivos.get(4);
        //System.out.println(nombrePersona);




        /**
         * la solucion es crear unArrayList de tipo <nombreTipo>
         *     de esta forma directamente el compilador dara error si trato de meter un file
         *     un arrayList de tipo string  objectEjemplo<String> lista=new objectEjemplo <>();
         *     lista.add(new File("archivoFile")); ===> esto dara error
         */



        ClaseGenerica<String> generic=new ClaseGenerica<>();
        generic.setAtributo("Maria");
        System.out.println(generic.getAtributo());

        /**
         * creamos una instancia de la clase persona
         */
        Persona per1=new Persona("Ana");

        ClaseGenerica <Persona> generic2=new ClaseGenerica<>();

        generic2.setAtributo(per1);


        System.out.println(generic2.getAtributo());







    }
}

