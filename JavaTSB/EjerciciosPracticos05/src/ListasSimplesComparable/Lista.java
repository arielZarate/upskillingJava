package ListasSimplesComparable;

import java.util.NoSuchElementException;

public class Lista {


    private Nodo frente;

    public Lista() {
        frente = null;
    }


    /*antes era
    public void agregar(Object x)
     *{
    *}
 */

    public void agregar(Comparable x) {
        if (x == null) return;
        if (frente != null && x.getClass() != frente.getInfo().getClass()) return;

        Nodo nuevo = new Nodo(x, frente);
        frente = nuevo;
    }

    public boolean estaVacía() {
        return frente == null;
    }

    public void borrar() {
        if (frente == null) throw new NoSuchElementException("La lista esta vacía");
        frente = frente.getNext();
    }

    public boolean contiene(Comparable x) {

        Nodo p = frente;
        // Este ciclo corta cuando la lista se acaba o cuando se encuentra x
        //El metodo compareTo
        //devuelve 0 si son iguales ; 1 si es mayor ; -1 si es menor
        while (p != null && p.getInfo().compareTo(x) != 0) {
            p = p.getNext();
        }

        return p != null;
    }


    /*
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
     */
    public StringBuilder listado() {
        StringBuilder salida = new StringBuilder();
        salida.append(" [");
        Nodo p = frente;
        while (p != null) {
            if(p.getNext() !=null) salida=salida.append(" - ");
            salida.append(p.getInfo() + " - ");
            p = p.getNext();
        }

        salida.append(" ]");
        return salida;

    }


    @Override
    public String toString() {
        return "Lista{" +
                "frente=" + frente.toString() +
                '}';
    }
}
