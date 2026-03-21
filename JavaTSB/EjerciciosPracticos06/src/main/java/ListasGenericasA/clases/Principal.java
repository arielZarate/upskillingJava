package ListasGenericasA.clases;

public class Principal
{
    public static void main(String args[])
    {
        // creamos una lista para guardar cuentas de Inversion y Corrientes, mezcladas... 
        // ...sin parametrizar se comporta como una lista generica heterogenea... 
        TSBSimpleList c = new TSBSimpleList();
        c.addFirst( new Inversion (101, 2000, 2.1f) );
        c.addFirst( new Inversion (212, 1000, 1.2f) ); 
        c.addFirst( new Corriente (140, 2030, true) );  // ok...
        c.addFirst( new Inversion (511, 3000, 3) );              
        System.out.println( "\nLista de Cuentas: " + c );
        
        // creamos otra lista pero parametrizada, para guardar cuentas de Inversion...
        // si intentamos guardar algo que NO sea Inversion, no compila...
        // ... esta parametrizada, se comporta como homogenea.
        TSBSimpleList <Inversion> d = new TSBSimpleList <> ();
        d.addFirst( new Inversion (101, 2000, 2.1f) );
        d.addFirst( new Inversion (212, 1000, 1.2f) ); 
        // d.addFirst( new Cliente () );  // esto no compila!!!
        d.addFirst( new Inversion (511, 3000, 3) );              
        System.out.println( "\nLista de Cuentas: " + d );
    }
}
