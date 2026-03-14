package implementations;

import entities.Expense;
import interfaces.ExpenseCalculator;

import java.util.List;

public class ExpenseCalculatorImplementation implements ExpenseCalculator {
    @Override
    public double calculateExpense(Expense expense) {
        return expense.getAmount();
    }

    //Antes de implementar la Stream API
    @Override


    //metodo para sumar los totales de getAmount
    public double calculateTotalExpense(List<Expense> expenses) {
        double totalExpense = 0;
        for (Expense expense : expenses) {
            totalExpense += expense.getAmount();
        }
        return totalExpense;
    }

    // Refactorizamos el tipo del parámetros para recibir una lista, ya no un array
    /*
        @Override
    public double calculateTotalExpense(List<Expense> expenses) {
        // Utilizamos una forma declarativa con Stream API para realizar la suma de los montos de gasto de manera más concisa
        return expenses.stream()
                .mapToDouble(Expense::getAmount)
                .sum();
    }
    * */

}
