package Comparable;

public class Principal
{
    public static void main(String args[])
    {
        Array a = new Array(5);
        a.set(0, "casa");
        a.set(1, "perro");
        a.set(2, "sol");
        a.set(3, "silla");
        a.set(4, "auto");
        System.out.print("Vector a original: " + a.toString());
        a.sort();
        System.out.println("\nVector a ordenado: " + a);
        
        Array b = new Array(3);
        b.set(0, new Cliente(23, "Juan"));
        b.set(1, new Cliente(2, "Ana"));
        b.set(2, new Cliente(5, "Luis"));
        System.out.print("Vector b original: " + b.toString());
        b.sort();
        System.out.println("\nVector b ordenado: " + b);
        
        Array c = new Array(3);
        c.set(0, new Inversion(501, 2000, 2.1f));
        c.set(1, new Corriente(212, 1000, true));
        c.set(2, new Corriente(111, 2300, false));
        System.out.print("Vector c original: " + c.toString());
        c.sort();        
        System.out.println("\nVector c ordenado: " + c);
    }
}
