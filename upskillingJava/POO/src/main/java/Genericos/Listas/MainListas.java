package Listas;

import java.util.ArrayList;
import java.util.List;

public class MainListas {


    public static void main(String[] args) {


        List lista = new ArrayList();
        lista.add("Hola soy Ariel");

        lista.add(345);

        //el problema de esto es que debo castearlo porque el tipo del elemento en la posisicon [1] es number

      // String n = (String) lista.get(1).toString();

        //son tofdos objetos en la lista ya que no tiene tipo string
       // System.out.println(n);

        for (Object ele : lista) {

            System.out.println((String)ele.toString());
        }
        System.out.println("El código que has proporcionado tiene algunos problemas, principalmente debido \n " +
                        "al uso de una lista sin tipo genérico especificado. En Java, antes de la introducción \n" +
                        "de los genéricos en Java 5, las colecciones como ArrayList se utilizaban sin especificar \n" +
                        "el tipo de elementos que contenían, lo que podía llevar a problemas de tipo y necesidad \n" +
                        "de castings explícitos. Sin embargo, desde Java 5, es preferible utilizar genéricos \n" +
                        "para evitar estos problemas"

                );


        System.out.println("******Solucion************");

        //creo otro array par que se  vea la difeencia no mas

        List<String> xmen=new ArrayList<>();
        //ahora me obliga  a declarar si o si tipos String no le puedo meter number

        xmen.add("Wolverine");
        xmen.add("Storm");
        xmen.add("Charles");
        xmen.add("Scope");
        xmen.add("Ave Fenix");


        System.out.println(" List<String> xmen=new ArrayList<>();\n" +
                " //ahora me obliga  a declarar si o si tipos String no le puedo meter number");

        System.out.println("*********mostrando elementos************");

        for(String ele: xmen)
        {
            System.out.println(ele);
        }



    }
}