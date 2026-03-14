package interfaces;

import entities.Expense;
import java.util.List;

public interface ExpenseCalculator {

    //este metodo recibe un Expense object y hace algo
    double calculateExpense(Expense expense);


    //este recibe una Lista de expense y hace algo
    double calculateTotalExpense(List<Expense> expenses); // Refactorizamos el tipo del parámetros para recibir una lista, ya no un array
}
