# Ejercicio de Gestión de Gastos en Java

Este ejercicio tiene como objetivo implementar una aplicación en Java para la gestión de gastos. La aplicación debe permitir al usuario ingresar diferentes gastos, clasificarlos por categorías, y calcular el total de los gastos ingresados. Además, se incluyen validaciones y manejo de excepciones para garantizar la integridad de los datos.

## Descripción de Clases y Paquetes

### Paquete `entities`

1. **Clase `Expense`**
    - Atributos:
        - `amount`: doble que representa el monto del gasto.
        - `category`: tipo `ExpenseCategory` que representa la categoría del gasto.
        - `date`: cadena que representa la fecha del gasto.
    - Métodos:
        - Constructores con y sin parámetros.
        - Getters y setters para cada atributo.
        - Método `toString` sobrescrito.

2. **Clase `SpecialExpense`**
    - Hereda de `Expense`.
    - Atributos:
        - `reason`: cadena que representa la razón del gasto especial.
    - Métodos:
        - Constructores con y sin parámetros.
        - Getters y setters para `reason`.

3. **Clase `Income`**
    - Atributos:
        - `amount`: doble que representa el monto del ingreso.
    - Métodos:
        - Constructores con y sin parámetros.
        - Getters y setters para `amount`.

4. **Clase `ExpenseCategory`**
    - Atributos:
        - `name`: cadena que representa el nombre de la categoría.
    - Métodos:
        - Constructor con y sin parámetros.
        - Getters y setters para `name`.
        - Método `toString` sobrescrito.

### Paquete `exceptions`

1. **Clase `InvalidExpenseException`**
    - Hereda de `Exception`.
    - Constructor que recibe un mensaje.

### Paquete `interfaces`

1. **Interfaz `ExpenseAmountValidator`**
    - Método:
        - `boolean validateAmount(double amount)` que lanza `InvalidExpenseException`.

2. **Interfaz `ExpenseCalculator`**
    - Métodos:
        - `double calculateExpense(Expense expense)`.
        - `double calculateTotalExpense(List<Expense> expenses)`.

### Paquete `implementations`

1. **Clase `ExpenseAmountValidatorImplementation`**
    - Implementa `ExpenseAmountValidator`.
    - Método:
        - `boolean validateAmount(double amount)` que lanza `InvalidExpenseException`.

2. **Clase `ExpenseCalculatorImplementation`**
    - Implementa `ExpenseCalculator`.
    - Métodos:
        - `double calculateExpense(Expense expense)`.
        - `double calculateTotalExpense(List<Expense> expenses)`.

### Clase `ExpenseReportApp`

- Método `main` que realiza las siguientes tareas:
    - Pide al usuario ingresar el número de gastos a cargar.
    - Para cada gasto:
        - Pide al usuario ingresar el monto, la categoría y la fecha.
        - Valida el monto ingresado.
        - Agrega el gasto a una lista.
        - Calcula y muestra el monto del gasto ingresado.
    - Calcula y muestra el total de los gastos ingresados.
    - Muestra el detalle de los gastos ingresados.
    - Muestra un contador por categoría.

## Instrucciones

1. **Configurar el proyecto:**
    - Crear los paquetes `entities`, `exceptions`, `interfaces`, `implementations` y la clase principal `ExpenseReportApp`.

2. **Implementar las clases y métodos:**
    - Crear y completar las clases y métodos mencionados en la descripción anterior.

3. **Ejecutar la aplicación:**
    - Compilar y ejecutar `ExpenseReportApp`.
    - Ingresar los datos según las indicaciones y observar los resultados en la consola.

## Consideraciones

- Asegurarse de manejar las excepciones correctamente.
- Utilizar buenas prácticas de programación, como encapsulación y separación de responsabilidades.
- Refactorizar el código cuando sea necesario para mejorar la legibilidad y mantenibilidad.

¡Buena suerte y feliz codificación!
