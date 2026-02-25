package Colecciones.StudentRecord;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 Crea una aplicación de consola sencilla para llevar un registro de los alumnos y sus calificaciones. El programa debe permitir agregar alumnos
 junto con sus calificaciones, buscar la calificación de un alumno, eliminar a un alumno del registro y verificar si un alumno está en el registro.
 Sigue los pasos a continuación:

 Crea una clase principal llamada StudentRecord.

 • Declara una variable de instancia de tipo Map<String, Integer> para almacenar los alumnos y sus calificaciones.

 • Utiliza `String` para representar el nombre del alumno y `Integer` para representar la calificación. Inicializa el mapa como una instancia de HashMap.

 • Crea un método llamado `addStudent` que tome como parámetros el nombre del alumno y su calificación, y los agregue al mapa utilizando el método `put()`.

 • Crea un método llamado `removeStudent` que tome como parámetro el nombre del alumno y lo elimine del mapa utilizando el método `remove()`.

 • Crea un método llamado `getGrade` que tome como parámetro el nombre del alumno y devuelva su calificación utilizando el método `get()`.

 • Crea un método llamado `isStudentInRecord` que tome como parámetro el nombre del alumno y verifique si está presente en el mapa utilizando el método `containsKey()`.


 * */

public class StudentRecord {

    private Map<String, Integer> studentGrades=null;

    public StudentRecord() {
        studentGrades = new HashMap<>();
    }

    public void addStudent(String name, int grade) {
        studentGrades.put(name, grade);
        System.out.println("student " + name + " added with grade " + grade);
    }

    public void removeStudent(String name) {
        studentGrades.remove(name);
        System.out.println("student " + name + " removed from the record.");
    }

    public Integer getGrade(String name) {
        return studentGrades.get(name);
    }

    public boolean isStudentInRecord(String name) {
        return studentGrades.containsKey(name);
    }

    public Set<String> getAllStudentsByKey() {
        return studentGrades.keySet();
    }

    public void printAllStudents() {
        System.out.println("Student Record:");
        for (Map.Entry<String, Integer> entry : studentGrades.entrySet()) {
            System.out.println("Name: " + entry.getKey() + ", Grade: " + entry.getValue());
        }
    }

}
