package ArrayListGenerico01;

import java.util.Iterator;

public class Principal {
    public static void main(String[] args) {

        TSBArrayList<Integer> arrayList = new TSBArrayList<>(10);

        /**
         * primera forma de recorrer el arrayList
         */
        for (int i = 0; i < 15; i++) {
            arrayList.add(i);
        }


        /**
         * segunda forma de recorrer el arrayList con un iterator
         */
        Iterator<Integer> it = arrayList.iterator();
        while(it.hasNext()) {
            int value = it.next();
            System.out.println(value);
            if (value == 10) {
                it.remove();
            }
        }
        System.out.println(arrayList);
    }
}
