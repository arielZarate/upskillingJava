package SimpleListOrdenada;


/**
 * @author ariel Zarate
 */

public class ListaSimple {
    private Nodo frente;


    //constructor
    public ListaSimple() {
        frente = null;
    }

    public void AddFisrt(int x) {
        /**
         * creo un nuevo Nodo donde le paso por parametro un valor
         * y frente que hasta ahora esta iniciliazado en null
         */
        Nodo nuevo = new Nodo(x, frente);
        this.frente = nuevo;
    }

    public void AddInOrder(int x) {
        Nodo nuevo = new Nodo(x, null);
        Nodo f = frente, aux = null;
        while (f != null && x >= f.getInfo()) {
            //cuando se cuemple que f es null(ultimo y x > a lo que tiene f en su getInfo)
            //guardo f en una variable auxiliar
            aux = f;
            //ahora a f le asigno lo que tiene f en su proximo que es null
            f = f.getNext();
        }
        //ahora le asigno al nodo creado lo que tiene f
        nuevo.setNext(f);
        if (aux != null) {
            aux.setNext(nuevo);
        } else frente = nuevo;
    }


    public void Clear() {
        frente = null;
    }

    public int getFirst() {
        int x = -1;
        if (this.frente != null) {
            x = frente.getInfo();
        }

        return x;
    }

    public int removeFirst() {
        int x = -1;
        if (this.frente != null) {
            x = frente.getInfo();
            frente = frente.getNext();
        }
        return x;

    }

    public String toString() {
        Nodo p = frente;
        String res = "[ ";
        while (p != null) {
            res = res + p.getInfo();
            //esto verificva que sea el ultimo
            if (p.getNext() != null) res = res + " - ";
            p = p.getNext();
        }
        res = res + " ]";
        return res;
    }


}



