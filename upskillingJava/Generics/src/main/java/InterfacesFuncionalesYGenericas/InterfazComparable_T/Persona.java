package InterfazComparable_T;

public class Persona  implements Comparable<Persona>{
    private String name;
    private int age;


    public Persona() {
    }

    public Persona(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }



    ///metodo comparable por edad

    @Override
    public int compareTo(Persona otraPersona) {

        // se puede comparar depende la edad ejemplo
        return Integer.compare(this.age,otraPersona.age);
    }
}
