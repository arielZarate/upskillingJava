package TSBAvlSearchTree;

import java.util.Comparator;

/**
 * Una clase que representa un estudiante, para mostrar la forma de implementar
 * la interface Comparable y la interface Comparator.
 * @author Ing. Valerio Frittelli.
 * @version Octubre de 2017.
 */
public class Student implements Comparable<Student> 
{
    private int id;
    private String name;
    
    public Student(int id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public int getId() 
    {
        return id;
    }

    public void setId(int id) 
    {
        this.id = id;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    @Override
    public int hashCode() 
    {
        int hash = 7;
        hash = 67 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) { return true; }
        if (obj == null) { return false; }
        if (getClass() != obj.getClass()) { return false; }
        
        final Student other = (Student) obj;
        if (this.id != other.id) { return false; }
        return true;
    }
    
    @Override
    public String toString() 
    {
        return "Student{" + "id=" + id + ", name=" + name + '}';
    }

    /**
     * Establece una relación de orden entre dos objetos Student. La comparación
     * realizada por compareTo() establece lo que se considera el "orden 
     * natural" entre dos objetos de la clase Student.
     * @param o el objeto que será comparado contra el objeto actual.
     * @return un valor positivo si el objeto actual es mayor que o, o un valor
     *         negativo si es menor, el valor 0 si ambos objetos se consideran 
     *         iguales.
     */
    @Override
    public int compareTo(Student o) 
    {
        return this.id - o.id;
    }
    
    /**
     * Retorna un Comparator para los objetos de esta clase. El Comparator que
     * se retorna establece una relación de orden basada en la comparación de 
     * los nombres de los estudiantes (en forma lexicográfica). 
     * @return 
     */
    public static Comparator<Student> comparator()
    {
        return new NameComparator();
    }
    
    /*
     * Clase interna para gestionar un Comparator que pueda comparar dos objetos
     * Student pero no como lo hace compareTo() (que compara los id) sino 
     * comparando los nombres. La clase además de interna, es static para poder
     * gestionarla desde un método estático.
     */
    private static class NameComparator implements Comparator<Student>
    {
        /**
         * Establece una relación de orden entre dos objetos Student. La 
         * comparación realizada por compare() NO establece el "orden natural" 
         * entre dos objetos de la clase Student, sino una estrategia basada en 
         * otro criterio.
         * @param o1 el primer objeto que será comparado.
         * @param o2 el primer objeto que será comparado.
         * @return un valor positivo si el nombre de o1 es mayor que el de o2, o
         *         un valor negativo si el nombre de o1 es menor que el de o2, o
         *         el valor 0 si ambos objetos tienen el mismo valor de nombre.
         */
        @Override
        public int compare(Student o1, Student o2) 
        {
            return o1.name.compareTo(o2.name);
        }
    }
}
