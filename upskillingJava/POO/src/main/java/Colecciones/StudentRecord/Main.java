package Colecciones.StudentRecord;

/**
 *
 • Agrega alumnos y sus calificaciones utilizando el método `addStudent()`.

 • Verifica si un alumno está en el registro utilizando el método `isStudentInRecord()`.

 • Obtiene la calificación de un alumno utilizando el método `getGrade()`.

 • Elimina a un alumno utilizando el método `removeStudent()`.

 • Utiliza el método `containsValue()` para verificar si una calificación específica está en el registro.

 • Utiliza el método `keySet()` para obtener un conjunto de los nombres de los alumnos en el registro.
 * */

public class Main {
    public static void main(String[] args) {
        StudentRecord record = new StudentRecord();

        // Agregar alumnos y calificaciones
        record.addStudent("Alice", 85);
        record.addStudent("Bob", 92);
        record.addStudent("Charlie", 78);

        // Verificar si un alumno está en el registro
        System.out.println("Is Alice in the record? " + record.isStudentInRecord("Alice"));
        System.out.println("Is David in the record? " + record.isStudentInRecord("David"));

        // Obtener la calificación de un alumno
        System.out.println("Alice's grade: " + record.getGrade("Alice"));
        System.out.println("David's grade: " + record.getGrade("David"));

        // Eliminar a un alumno
        record.removeStudent("Bob");

        // Verificar si una calificación específica está en el registro
        System.out.println("Is there a grade of 92 in the record? " + record.isStudentInRecord("Bob"));
        System.out.println("Is there a grade of 85 in the record? " + record.isStudentInRecord("Alice"));

        // Obtener un conjunto de los nombres de los alumnos en el registro
        System.out.println("Students in the record: " + record.getAllStudentsByKey() );
    }
}
