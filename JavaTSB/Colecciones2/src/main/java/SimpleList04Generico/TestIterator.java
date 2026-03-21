package SimpleList04Generico;

import java.util.Iterator;
import java.util.LinkedList;
public class TestIterator
{
    public static void main(String args[])
    {
        // creamos una SimpleList de numeros y probamos el metodo remove() del iterador...
        TSBSimpleList<Integer> listatsb = new TSBSimpleList<>();
        listatsb.addFirst(10);
        listatsb.addFirst(15);
        listatsb.addFirst(13);
        listatsb.addFirst(18);

        Iterator<Integer> it = listatsb.iterator();
        int contador = 1;
        while(it.hasNext())
        {
            // it.remove();  // excepcion...
            System.out.println("Valor en la posicion " + contador + ": " + it.next());
            // if(contador == 1) { it.remove(); it.remove(); } // excepcion...
            // if(contador == 1) { it.remove(); }  // ok...
            it.remove();
            contador++;
        }
        System.out.println("La SimpleList es: " + listatsb);
        System.out.println();
        
        // creamos una LinkedList de numeros y probamos el metodo remove() del iterador...
        LinkedList<Integer> listalinked = new LinkedList<>();
        listalinked.addFirst(10);
        listalinked.addFirst(15);
        listalinked.addFirst(13);
        listalinked.addFirst(18);

        Iterator<Integer> it2 = listalinked.iterator();
        int contador2 = 1;
        while(it2.hasNext())
        {
            // it2.remove(); // excepcion...
            System.out.println("Valor en la posicion " + contador2 + ": " + it2.next());
            // if(contador2 == 1) { it2.remove(); it2.remove(); } // excepcion...
            // if(contador2 == 1) { it2.remove(); } // ok...
            it2.remove();
            contador2++;
        }
        System.out.println("La LinkedList es: " + listalinked);
    }            
}
