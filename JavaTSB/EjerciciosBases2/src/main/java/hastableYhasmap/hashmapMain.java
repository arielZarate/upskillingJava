package hastableYhasmap;

import java.util.HashMap;
import java.util.Iterator;

public class hashmapMain {
    public static void main(String[] args) {
        HashMap <Integer,String> personas=new HashMap<>();

        personas.put(1561,"juan Poronga");
        personas.put(15646541,"Belen Poronga");
        personas.put(1167941,"rodrigo antonio Poronga");


        System.out.println("\nRecorriendo con foreach");
        for (Integer cedula: personas.keySet()) {
            System.out.println("cedula -->" + cedula);
        }

        System.out.println("*********");


        System.out.println("\nusando los get");
        System.out.println(personas.get(1561));


        System.out.println("\n***EntrySet******");
        System.out.println( personas.entrySet());



        System.out.println("\n***Recorriendo con Iterator******");
        Iterator it=personas.entrySet().iterator();

        while(it.hasNext())
        {
            Object o=it.next();

            System.out.println(o.toString());
        }


    }
}
