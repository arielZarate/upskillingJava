## 1. Ejercicio de gestión de tareas:

Crea una aplicación de consola para gestionar una lista de tareas. El programa debe permitir agregar tareas, marcar tareas como completadas, 
eliminar tareas y mostrar el estado actual de la lista de tareas. Sigue los pasos a continuación:

1. Crea una clase principal llamada TaskManager.

2. Declara una variable de instancia de tipo List<String> para almacenar las tareas.

3. Inicializa la lista de tareas como una instancia de ArrayList.

4. Crea un método llamado `addTask` que tome como parámetro una tarea (de tipo String) y la agregue a la lista de tareas utilizando el método `add()`.

5. Crea un método llamado `markTaskAsCompleted` que tome como parámetro el índice de una tarea y la marque como completada.

6. Crea un método llamado `removeTask` que tome como parámetro el índice de una tarea y la elimine de la lista utilizando el método `remove()`.

7. Crea un método llamado `printTaskList` que muestre todas las tareas de la lista utilizando un bucle for-each y los métodos `size()` y `get()`



### En el método `main`, crea una instancia de `TaskManager` y realiza las siguientes operaciones:
Agrega algunas tareas utilizando el método `addTask()`.

• Marca una tarea como completada utilizando el método `markTaskAsCompleted()`.

• Elimina una tarea utilizando el método `removeTask()`.

• Muestra la lista de tareas utilizando el método `printTaskList()`.

• Utiliza el método `contains()` para verificar si una tarea específica está en la lista

• Utiliza el método `isEmpty()` para verificar si la lista de tareas está vacía.

• Utiliza el método `sort()` para ordenar las tareas alfabéticamente.

• Utiliza el método `toArray()` para obtener un arreglo de las tareas.



## 2. Ejercicio de gestión de invitados a una fiesta:

Crea una aplicación de consola para gestionar una lista de invitados a una fiesta. El programa debe permitir agregar invitados, eliminar invitados, mostrar la lista de invitados y verificar si un invitado específico está en la lista. Sigue los pasos a continuación:

1. Crea una clase principal llamada PartyGuestList.

2. Declara una variable de instancia de tipo Set<String> para almacenar los invitados.

3. Inicializa el conjunto de invitados como una instancia de HashSet.

4. Crea un método llamado `addGuest` que tome como parámetro un invitado (de tipo String) y lo agregue al conjunto de invitados utilizando el método `add()`.

5. Crea un método llamado `removeGuest` que tome como parámetro un invitado y lo elimine del conjunto utilizando el método `remove()`.

6. Crea un método llamado `isGuestInList` que tome como parámetro un invitado y verifique si está presente en el conjunto utilizando el método `contains()`.

7. Crea un método llamado `getTotalGuests` que devuelva el número total de invitados utilizando el método `size()`.

### En el método `main`, crea una instancia de `PartyGuestList` y realiza las siguientes operaciones:

• Agrega invitados utilizando el método `addGuest()`.

• Verifica si un invitado específico está en la lista utilizando el método `isGuestInList()`.

• Elimina un invitado utilizando el método `removeGuest()`.

• Muestra el número total de invitados utilizando el método `getTotalGuests()`.

• Utiliza el método `isEmpty()` para verificar si la lista de invitados está vacía.





## Ejercicio de registro de alumnos y calificaciones:

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

### En el método `main`, crea una instancia de `StudentRecord` y realiza las siguientes operaciones:

• Agrega alumnos y sus calificaciones utilizando el método `addStudent()`.

• Verifica si un alumno está en el registro utilizando el método `isStudentInRecord()`.

• Obtiene la calificación de un alumno utilizando el método `getGrade()`.

• Elimina a un alumno utilizando el método `removeStudent()`.

• Utiliza el método `containsValue()` para verificar si una calificación específica está en el registro.

• Utiliza el método `keySet()` para obtener un conjunto de los nombres de los alumnos en el registro.