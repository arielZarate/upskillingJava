package Colecciones.TaskManager_List;


import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ariel Zarate
 * Crea una aplicación de consola para gestionar una lista de tareas. El programa debe permitir agregar tareas, marcar tareas como completadas,
 * eliminar tareas y mostrar el estado actual de la lista de tareas. Sigue los pasos a continuación:
 * <p>
 * 1. Crea una clase principal llamada TaskManager.
 * <p>
 * 2. Declara una variable de instancia de tipo List<String> para almacenar las tareas.
 * <p>
 * 3. Inicializa la lista de tareas como una instancia de ArrayList.
 * <p>
 * 4. Crea un método llamado `addTask` que tome como parámetro una tarea (de tipo String) y la agregue a la lista de tareas utilizando el método `add()`.
 * <p>
 * 5. Crea un método llamado `markTaskAsCompleted` que tome como parámetro el índice de una tarea y la marque como completada.
 * <p>
 * 6. Crea un método llamado `removeTask` que tome como parámetro el índice de una tarea y la elimine de la lista utilizando el método `remove()`.
 * <p>
 * 7. Crea un método llamado `printTaskList` que muestre todas las tareas de la lista utilizando un bucle for-each y los métodos `size()` y `get()`
 *
 */


public class TaskManager {
    //2 y 3
    private List<String> taskList = new ArrayList<>();


    public TaskManager() {
    }

    //4
    public void addTask(String task) {
        taskList.add(task);
        System.out.println("task added");
    }

    //5
    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < taskList.size()) {
            String taskFound = taskList.get(index);
            taskList.set(index, "completed");
        }
    }

    //6
    public void removeTask(int index) {
        if (index >= 0 && index < taskList.size()) {
            taskList.remove(index);
            System.out.println("task removed");
        }
    }


    public void printTaskList() {
        for (int i = 0; i < taskList.size(); i++) {
            System.out.println("task " + i + " : " + taskList.get(i));
        }
    }


    // Utiliza el método `contains()` para verificar si una tarea específica está en la lista

    public boolean contains(String task) {
        return taskList.contains(task);
    }

    // Utiliza el método `isEmpty()` para verificar si la lista de tareas está vacía.

    public boolean isEmpty() {
        return taskList.isEmpty();
    }


  // Utiliza el método `sort()` para ordenar las tareas alfabéticamente.

    public void sort() {
        taskList.sort(String::compareTo);
    }


//  • Utiliza el método `toArray()` para obtener un arreglo de las tareas.

    public String[] toArray() {
       return taskList.toArray(new String[0]);

//        String[] tasksArray = new String[taskList.size()];
//        for (int i = 0; i < taskList.size(); i++) {
//            tasksArray[i] = taskList.get(i);
//        }
//        return tasksArray;
    }

}
