package SimpleListOrdenada;

public class Main {
    public static void main(String[] args) {
        ListaSimple a = new ListaSimple();
        a.AddInOrder(33);
        a.AddInOrder(12);

        System.out.println(a.toString());


        a.AddInOrder(99);
        a.AddInOrder(19);
        a.AddInOrder(5);
        System.out.println(a.toString());


        a.removeFirst();
        System.out.println(a.toString());

        System.out.println("");
        System.out.println("agregamos primero");
        a.AddFisrt(999);
        System.out.println(a.toString());

        //
        System.out.println("");
        System.out.println("Borramos la lista con clear");
        a.Clear();
        System.out.println(a.toString());

    }



}
