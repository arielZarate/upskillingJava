package TSBArrayList;

import java.util.Iterator;


/**
 * Clase para incluir un simple main() de prueba para la clase ArrayList.
 * 
 * @author Ing. Valerio Frittelli.
 * @version Agosto de 2017.
 */
public class TestTSBArrayList
{
    public static void main(String args[])throws CloneNotSupportedException
    {
        // un arreglo auxiliar de nombres...
        String nombres[] = {"Ana", "Luis", "Carlos", "Luz", "Juan", "Maria"};

        // creación de un ArrayList...
        TSBArrayList<String> al = new TSBArrayList<String>(5);
        System.out.println("Lista inicial: " + al); 
        
        // inserción de cadenas...
        for(int i=0; i<nombres.length; i++)
        {
            al.add(nombres[i]);
        }
        System.out.println("Luego de invocar a add(): " + al);

        TSBArrayList<String> copia = (TSBArrayList<String>) al.clone();
        System.out.println("Lista copiada: " + copia);
        
        // eliminación de una cadena...
        al.remove(3);
        System.out.println("Luego de invocar a remove() una vez: " + al);
        System.out.println("Lista copiada: " + copia);  
        
        TSBArrayList<String> copia2 = new TSBArrayList<>(al);
        System.out.println("Segunda copia: " + copia2);  
        
        // eliminación masiva usando remove():
        while(al.size()>0)
        {
            al.remove(0);
        }
        System.out.println("Luego de invocar a remove() muchas veces: " + al);
        
        // regeneración de la lista inicial...
        for(int i=0; i<nombres.length; i++)
        {
            al.add(nombres[i]);
        }
        System.out.println("Luego de invocar a add(): " + al);

        // acceso a un componente individual...
        String nom = (String) al.get(4);
        System.out.println("Nombre recuperado con get(): " + nom);
        
        // cambio de un componente individual...
        al.set(5, "David");
        System.out.println("Contenido luego de usar set(): " + al); 
        
        al.add(3, "Diana");
        System.out.println("Luego de insertar en casilla 3: " + al);
        
        int id = al.size();
        al.add(id, "Diego");
        System.out.println("Luego de insertar en casilla " +  id + ": " + al);        
     
        System.out.println("Contenido usando iterador: ");         
        Iterator<String> it = al.iterator();
        while(it.hasNext())
        {
            Object x = it.next();
            System.out.println(x);
        }
        
        System.out.println("Contenido con iterador, pero eliminado el nombre 'Carlos': ");         
        Iterator<String> it2 = al.iterator();
        while(it2.hasNext())
        {
            String x = it2.next();
            if(x.equals("Carlos")) it2.remove();
            else System.out.println(x);
        }
        System.out.println("Contenido luego de eliinar a 'Carlos' con el iterador: " + al);         
        
        
        al.clear();
        // regeneración de la lista inicial...
        for(int i=0; i<nombres.length; i++)
        {
            al.add(nombres[i]);
        }
        System.out.println("Luego de invocar a clear() y volver a generarla: " + al);
        
        String nombre = "Luis";
        boolean r = al.contains(nombre);
        System.out.println("El nombre " + nombre + " está en la lista??? " + r);
        
        al.clear();
        al.trimToSize();
        System.out.println("Lista luego de clear() y trimToSize(): " + al);
    }
}
