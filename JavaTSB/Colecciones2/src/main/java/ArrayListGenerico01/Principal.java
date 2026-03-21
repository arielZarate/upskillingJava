package ArrayListGenerico01;

import java.util.Iterator;

public class Principal {
    public static void main(String[] args) {

        TSBArrayList<Integer> l = new TSBArrayList<>(10);
        for (int i = 0; i < 15; i++) {
            l.add(i);
        }

        Iterator<Integer> it = l.iterator();
        while(it.hasNext()) {
            int value = it.next();
            System.out.println(value);
            if (value == 10) {
                it.remove();
            }
        }
        System.out.println(l);
    }
}
