package TSBAvlSearchTree;

/**
 * Un main para probar en forma simple la clase TSBAVLSearchTree.
 * @author Ing. Valerio Frittelli.
 */
public class Test 
{
    public static void main(String args[])
    {
        // algunos estudiantes para hacer pruebas...
        Student s1 = new Student(50, "Ana");
        Student s2 = new Student(10, "Luis");
        Student s3 = new Student(30, "Carla");
        Student s4 = new Student(20, "Juan");

        // un árbol de estudiantes - orden natural (por id - con compareTo())...
        TSBAVLSearchTree<Student> t1 = new TSBAVLSearchTree<>();
        t1.add(s1);
        t1.add(s2);
        t1.add(s3);
        t1.add(s4);
        System.out.println("Listado de estudiantes (orden: por id):");
        System.out.println(t1);
                
        // un árbol de estudiantes - orden natural (por name - con compare())...
        TSBAVLSearchTree<Student> t2 = new TSBAVLSearchTree<>(Student.comparator());
        t2.add(s1);
        t2.add(s2);
        t2.add(s3);
        t2.add(s4);
        System.out.println("Listado de estudiantes (orden: por name):");
        System.out.println(t2);
    }
}
