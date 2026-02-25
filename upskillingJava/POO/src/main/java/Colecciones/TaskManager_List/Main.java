package Colecciones.TaskManager_List;


/**
 * ### En el método `main`, crea una instancia de `TaskManager` y realiza las siguientes operaciones:
 * Agrega algunas tareas utilizando el método `addTask()`.
 * <p>
 * • Marca una tarea como completada utilizando el método `markTaskAsCompleted()`.
 * <p>
 * • Elimina una tarea utilizando el método `removeTask()`.
 * <p>
 * • Muestra la lista de tareas utilizando el método `printTaskList()`.
 * <p>
 * • Utiliza el método `contains()` para verificar si una tarea específica está en la lista
 * <p>
 * • Utiliza el método `isEmpty()` para verificar si la lista de tareas está vacía.
 * <p>
 * • Utiliza el método `sort()` para ordenar las tareas alfabéticamente.
 * <p>
 * • Utiliza el método `toArray()` para obtener un arreglo de las tareas.
 *
 *
 */
public class Main {

    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        taskManager.addTask("Estudiar Java");
        taskManager.addTask("Hacer ejercicio");
        taskManager.addTask("Comprar comida");

        taskManager.markTaskAsCompleted(0);

        taskManager.printTaskList();
        taskManager.removeTask(1);

        taskManager.printTaskList();

        System.out.println(taskManager.contains("Comprar comida"));
        System.out.println(taskManager.contains("Hacer ejercicio"));


        System.out.println("\nLa lista esta vacia ? = " +taskManager.isEmpty());

        taskManager.addTask("Dormir");
        taskManager.addTask("Leer un libro");
        taskManager.addTask("Cocinar");

        taskManager.sort();


        System.out.println("\nLista ordenada alfabeticamente");
        taskManager.printTaskList();


        System.out.println("\nArreglo de tareas:");
        String[] tasksArray = taskManager.toArray();
        for (String task : tasksArray) {
            System.out.println(task);
        }

    }
}
