package clases;

import java.util.Iterator;
public class Principal
{
    public static void main(String args[])
    {
        // creamos una lista para guardar cuentas de Inversion
        TSBSimpleList c = new TSBSimpleList();
        c.addInOrder( new Inversion (101, 2000, 2.1f) );
        c.addInOrder( new Inversion (212, 1000, 1.2f) ); 
        c.addInOrder( new Inversion (511, 3000, 3) );              
        System.out.println( "\nLista de Cuentas: " + c );
        
        // ahora recorremos la lista para calcular el saldo promedio...
        // ...usamos nuestra implementación detallada del patrón Iterator
        float a = 0;
        int b = 0;
        Iterator it = c.iterator();  // inicializamos el mecanismo de recorrido
        while( it.hasNext() )
        {
            Inversion x = (Inversion) it.next();   
            a += x.getSaldo();
            b++;
        }
        float prom = 0;
        if( b != 0 ) prom = a / b;
        System.out.println("Saldo Promedio: " + prom);
        
        // para recorrer la lista otra vez, reinicializamos el mecanismo iterador...
        // ... pero mostramos ahora el uso de un for...
        int s = 0;
        //*
        for(Object x : c) 
        {
            Inversion y = (Inversion) x;
            if(y.getSaldo() > prom) s++;
        }  
        
        /*/
        Iterator it2 = c.iterator();
        //*
        while(it2.hasNext()) 
        {
            Inversion y = (Inversion) it2.next();
            if ( y.getSaldo() > prom ) s++;
        }
        //*/ 

        System.out.println("Cantidad de cuentas con saldo mayor al promedio: " + s);
    }
}
