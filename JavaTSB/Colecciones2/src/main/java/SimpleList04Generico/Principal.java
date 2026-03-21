package SimpleList04Generico;

import java.util.*;
public class Principal
{
    public static void main(String args[])
    {
        // creamos una lista para guardar cuentas de objetos mezclados... 
        // ...sin parametrizar se comporta como una lista generica heterogenea... 
        TSBSimpleList c = new TSBSimpleList();
        c.addInOrder( new Inversion (101, 2000, 2.1f) );
        c.addInOrder( new Inversion (212, 1000, 1.2f) ); 
        //c.addInOrder( new Corriente (140, 2030, true) ); // esto compila... y funciona sin problemas...
        //c.addInOrder( new Cliente(24, "Juan") );  // esto compila pero lanza una excepcion...
        c.addInOrder( new Inversion (511, 3000, 3) );              
        System.out.println( "\nLista de Cuentas: " + c );
        
        // creamos otra lista pero parametrizada, para guardar cuentas de Inversion...
        // ... esta parametrizada, se comporta como homogenea.
        TSBSimpleList <Inversion> d = new TSBSimpleList <>();
        //SimpleList <Inversion> d = new SimpleList <>(); // esto es lo mismo que lo anterior...
        
        d.addInOrder( new Inversion (101, 2000, 2.1f) );
        d.addInOrder( new Inversion (212, 1000, 1.2f) ); 
        //d.addInOrder( new Corriente (140, 2030, true) ); // no compila...
        //d.addInOrder( new Cliente () );  // esto no compila...
        d.addInOrder( new Inversion (511, 3000, 3) );              
        System.out.println( "\nLista de Cuentas: " + d );
        
        // y ahora mostramos la forma de usar el iterador...
        
        // una lista de numeros...
        TSBSimpleList <Integer> lista = new TSBSimpleList<>();
        lista.addInOrder(1);
        lista.addInOrder(2);
        lista.addInOrder(3);
        lista.addInOrder(4);
        lista.addInOrder(5);

        // mostrar la lista a partir del iterador...
        System.out.println();
        Iterator <Integer> i = lista.iterator();
        //int s = 0;
        while(i.hasNext())
        {
            System.out.println("Objeto recuperado: " + i.next() );
            //s += i.next();
        }
        
        // suma de la lista de numeros... usando el ciclo for each...
        int suma = 0;
        for(int item : lista)
        {
            suma += item; // aca hace auto-deboxing...
        }
        System.out.println("\nSuma: " + suma);        
    }
}
