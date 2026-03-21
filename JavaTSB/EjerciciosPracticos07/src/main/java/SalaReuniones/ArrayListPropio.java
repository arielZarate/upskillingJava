package SalaReuniones;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ArrayListPropio<T> {

    private T[] items;
    private int size;
    private int capacidad_inicial;


    //constructor por defecto en 10
    public ArrayListPropio() {
        this(10);
    }


    public ArrayListPropio(int capacity)  //constructor
    {
        if (capacity < 10) {
            capacity = 10;
        }
        this.capacidad_inicial = capacity;
        //casting
        items = (T[]) new Object[capacity];
        size = 0;
    }


    public void Agregar(T x) {
        //antes de agregar verifica el tamaño del array
        //si es muy grande lo achica
        ensureCapacity();
        items[size] = x;
        //una vez agregado el elemento sumo 1 size
        size++;
    }

    private void ensureCapacity() {
        //verifica si el tamaño es igual al tamaño del array
        //si es muy justo
        if (size == items.length) {

            //le agrego solamente dos casilleros mas al array
            //mentengo bajo el consumo de memoria
            int newSize = (int) (items.length + 2);
//            System.out.println("Agrandando a " + newSize);
            Object[] aux = new Object[newSize];
            //ya creado el nuevo array le paso los elementos con arryCopy
            System.arraycopy(items, 0, aux, 0, size);
            //vuelvo a introducir en item el nuevo vector aux;
            items = (T[]) aux;
        }
    }

    //verifica sie sta vacia
    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }


    public T get(int i) {
        //checkea si ese valor de indice no esta fuera de rango
        //si es menor a cero o mayor al size
        checkBounds(i);
        return items[i];
    }

    private void checkBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Fuera de rango");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(items[i]);
            sb.append(", ");
        }

        sb.append("]");
        return sb.toString();
    }


    //verifica si contiene el Objecto
    public boolean contains(Object x) {
        //compara a traves de equals
        for (int i = 0; i < size; i++) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    //elimina un elemento enel indice indicado y corre achica el vector
    public T remove(int index) {
        checkBounds(index);
        T value = items[index];
        System.arraycopy(items, index + 1, items, index, size - index - 1);
        size--;
        items[size] = null;
        return value;
    }


    //crea un objeto de tipo de esta clase privada que obviamente es interator
    public Iterator iterator() {
        return new ArrayListPropioIterator();
    }


//    void add(int index, E x)
//    E set(int index, E x)

    private class ArrayListPropioIterator implements Iterator<T> {

        /*como es una implementacion implementa
          sus tres metodos mas importantes
          hasNext()
          Next()
          Remove()

         */

        private int actual = 0;
        private boolean proximo = false;

        @Override
        public boolean hasNext() {
            return actual < size;
        }

        @Override
        public T next() {
            if (!hasNext())//sino hay mas elementos

            {
                throw new NoSuchElementException();
            }
            //si hay lo guarda en un tipo generico
            T res = items[actual];
            //lo guarda  y incrementa em  uno
            actual++;
            proximo = true;
            return res;
        }

        @Override
        public void remove() {
            if (!proximo) {
                throw new IllegalStateException();
            }
            //puede llamar al propio
            ArrayListPropio.this.remove(actual - 1);
            actual--;
            proximo = false;
        }


    }
}
