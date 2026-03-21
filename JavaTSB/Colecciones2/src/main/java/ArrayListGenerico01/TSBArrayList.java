package ArrayListGenerico01;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class TSBArrayList<T> {

    private T[] items;
    private int size;
    private int initial_capacity;

    public TSBArrayList() {
        this(10);
    }

    public TSBArrayList(int capacity) {
        if (capacity < 10) {
            capacity = 10;
        }
        initial_capacity = capacity;
        items = (T[]) new Object[capacity];
        size = 0;
    }

    public void add(T x) {
        ensureCapacity();
        items[size] = x;
        size++;
    }

    private void ensureCapacity() {
        if (size == items.length) {
            int newSize = (int) (items.length * 1.5);
//            System.out.println("Agrandando a " + newSize);
            Object[] aux = new Object[newSize];
            System.arraycopy(items, 0, aux, 0, size);
            items = (T[]) aux;
        }
    }

    public void clear() {
        items = (T[]) new Object[initial_capacity];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }


    public T get(int i) {
        checkBounds(i);
        return items[i];
    }

    private void checkBounds(int i) {
        if (i < 0 || i >= size) {
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

    public boolean contains(Object x) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(x)) {
                return true;
            }
        }
        return false;
    }

    public T remove(int index) {
        checkBounds(index);
        T value = items[index];
        System.arraycopy(items, index+1, items, index, size-index-1);
        size --;
        items[size] = null;
        return value;
    }

    public Iterator iterator() {
        return new TSBArrayListIterator();
    }



//    void add(int index, E x)
//    E set(int index, E x)

    private class TSBArrayListIterator implements Iterator<T>{

        private int actual = 0;
        private boolean next_ok = false;

        @Override
        public boolean hasNext() {
            return actual < size;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T res = items[actual];
            actual++;
            next_ok = true;
            return res;
        }

        @Override
        public void remove() {
            if (! next_ok) {
                throw new IllegalStateException();
            }
            TSBArrayList.this.remove(actual-1);
            actual--;
            next_ok = false;
        }
    }

}
