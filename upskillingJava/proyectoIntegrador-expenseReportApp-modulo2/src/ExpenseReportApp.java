import entities.Expense;
import entities.ExpenseCategory;
import exceptions.InvalidExpenseException;

//=============INTERFACES============
import interfaces.ExpenseAmountValidator;
import interfaces.ExpenseCalculator;


//====================================
import implementations.ExpenseAmountValidatorImplementation;
import implementations.ExpenseCalculatorImplementation;
import utils.Utilities;

import java.util.*;

public class ExpenseReportApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ExpenseCalculator expenseCalculator = new ExpenseCalculatorImplementation();
        ExpenseAmountValidator expenseAmountValidator = new ExpenseAmountValidatorImplementation();
        // Declaramos un map para contar la aparición de categorias
        Map<String, Integer> countCategoryMap = new HashMap<>();
        // Refactorizamos el array a una List<Expense>
        List<Expense> expenses = new ArrayList<>();
        int index= 0;
        int amount= 0;
        String name;
        String date;
        // Definimos una variable que será definida por el usuario para controlar
        // la cantidad de iteraciones que hará el bucle do/while
        int cantGastosACargar;

        // Se inicializa la variable de control del do/while con lo definido por el usuario
        System.out.print("¿Cuántos gastos desea cargar?: ");
        cantGastosACargar = scanner.nextInt();
        do {
            try {
                Expense expense = new Expense();
                ExpenseCategory category = new ExpenseCategory();
                System.out.print("Ingrese el monto del gasto: ");
                amount = scanner.nextInt();

                if (!expenseAmountValidator.validateAmount(amount)) {
                    System.out.println("El monto es válido.");
                }
                scanner.nextLine();

                System.out.print("Ingrese la categoría del gasto: ");
                name = scanner.nextLine();

                System.out.println("Ingrese la fecha del gasto: (dd/MM/yyyy)");
                date = scanner.nextLine();

                // ActuaLizamos el map contador de categorias
                countCategoryMap.put(name, countCategoryMap.getOrDefault(name, 0) + 1);

                expense.setAmount(amount);
                category.setName(name);
                expense.setCategory(category);
                expense.setDate(date);
                System.out.println("Detalle del gasto ingresado: " + expense);
                System.out.println("Cálculo del monto del gasto ingresado: " + expenseCalculator.calculateExpense(expense));

                expenses.add(expense);
                index++;

            } catch (InvalidExpenseException exception) {
                System.out.println("Error" + exception);
            }



        } while (index < cantGastosACargar);
        System.out.println("Total del monto del gasto ingresado: " + expenseCalculator.calculateTotalExpense(expenses));

        System.out.println("DETALLE DE GASTOS INGRESADOS");
        //Antes de usar una forma declarativa
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
        // Implementamos programación funcional con Stream API para recorrer la lista de gastos y mostrar solo los primeros 5

        /*
         expenses.stream()
                .limit(5)
                .forEach(System.out::println);

            */

        // Recorremos el map para mostrar por consola
        System.out.println("CONTADOR POR CATEGORÍA");
        /* Antes de usar una forma declarativa
        for (Map.Entry<String, Integer> entry : countCategoryMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }*/
        // Implementamos programación funcional con Stream API para recorrer el map contador de categorias
        countCategoryMap.forEach((category, count) -> System.out.println(category + ": " + count));

        System.out.println();
        System.out.println("IMPRESIÓN DE GASTOS USANDO UN MÉTODO GENËRICO");
        // Si tuviesemos una lista de categorías podríamos usar el mismo método
        Utilities.imprimirElementos(expenses);
    }
}