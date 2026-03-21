package hastableYhasmap;

import  java.util.Hashtable;
import java.util.Enumeration;
import java.util.Iterator;

public class hastableMain {
    public static  void main(String[] args) {
        Hashtable contenedor=new Hashtable();

        /**
         * Nos vamos a ayudar del método .put() para insertar elementos dentro de la Hashtable Java:
         */
        contenedor.put("101", "Harry");
        contenedor.put("102", "Potter");
        contenedor.put("103", "IRONMAN");
        contenedor.put("104", "IRONMAN");
        contenedor.put("105", "HALLO");

        /**
         *Si queremos obtener un valor de la Hashtable Java tendremos que pasarle al método .get() la clave que queremos recuperar:
         */


        System.out.println("obteniendo mediante el get()");
        System.out.println(contenedor.get("105"));
        System.out.println(contenedor.get("101"));

      /**
        Mediante un Enumeration vamos a recorrer el contenido de nuestra Hashtable Java:
       */

        System.out.println("Recorriendo con Enumeration");
        Enumeration enumeration = contenedor.elements();
        while (enumeration.hasMoreElements()) {
            System.out.println(""+"hashtable valores: " + enumeration.nextElement());
        }

        System.out.println("Recorriendo con iterator");
        Iterator e=contenedor.entrySet().iterator();
        while (e.hasNext())
        {
            Object o=  e.next();
            System.out.println("hashtable valores: " + o);

        }

        /**
         *  Si queremos saber cuales
         *  son las claves de la Hashtable Java usamos el método .keys().
         */

        System.out.println("todas las keys");
        Enumeration llaves = contenedor.keys();
        while (llaves.hasMoreElements()) {
            System.out.println(""+"hashtable llaves: " + llaves.nextElement());
        }

    }
}
