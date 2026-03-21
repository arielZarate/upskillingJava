package hashMapConEqualsYHashCode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Map;

public class hashMap {
    public static void main(String[] args) {


        /**
         Map es la interface Mayor que contiene a HashMap y SortedMap
         de HashMap deriva HashTable
         de SortedMap deriva TreeMap
         */
        Map m = new HashMap();

        //creamos los objetos
        Alumnos person1 = new Alumnos("Juan", 18);
        Alumnos person2 = new Alumnos("Miguel", 25);
        Alumnos person3 = new Alumnos("Luis", 18);
        Alumnos person4 = new Alumnos("Luis", 18);


        m.put(person1, "valor1");
        m.put(person2, "valor2");
        m.put(person3, "valor1");
        m.put(person4, "mi valor");


        System.out.println("Keys:  " + m.keySet());
        System.out.println("Tamaño del hashMap: " + m.size());
        System.out.println("Valores del Value(): " + m.values());

        Iterator it = m.entrySet().iterator();
        while (it.hasNext()) {
            // Alumnos a= (Alumnos) it.next();
            Map.Entry entry = (Map.Entry) it.next();
            Alumnos k = (Alumnos) entry.getKey();
            String v = (String) entry.getValue();

            System.out.println(k.hashCode());
        }




    }
}


class Alumnos {
    private int age;
    private String name;

    Alumnos(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Alumnos{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }

        final Alumnos other = (Alumnos) obj;
        if (this.name != other.name) {
            return false;
        }
        return true;
    }



    /*
    @Override
    public boolean equals(Object o) {
        if (o instanceof Alumnos) {
            Alumnos p = (Alumnos)o;
            return this.name.equals(p.name);
        } else {
            return false;
        }
    }

     */


    @Override
    public int hashCode() {
        //return age * this.name.length();
        int hash = 7;
        hash = 11 * hash + this.age;
        return hash;
    }


}


