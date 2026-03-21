
package ListasSimplesComparable;
import java.util.Random;

public class Programa {
    public static void main(String[] args) {
        Lista l = new Lista();

        Random r =new Random();
        int n = r.nextInt(100);

        for (int i = 0; i < 500; i++) {
            l.agregar(r.nextDouble());
        }
        System.out.println(l.listado());


        l.agregar("Hola");
        l.agregar("Chau");

        System.out.println("esta en lista o no??");
        System.out.print(l.contiene(434.0));


        System.out.println("\n Nueva Lista de String");
        Lista l2 = new Lista();
        l2.agregar("asdfasdf");
        l2.agregar("adsdfg");
        l2.agregar("zzz");

        System.out.println("\n ESta en la lista o no?");
        System.out.println(l2.contiene("zzz"));
        //while (!l2.estaVacía())
        //    l2.borrar();

        System.out.println("\n");

        System.out.println(l2.listado());
    }
}
