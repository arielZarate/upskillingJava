package interfaces;

import exceptions.InvalidExpenseException;

// Interfaz funcional
@FunctionalInterface
public interface ExpenseAmountValidator {
    boolean validateAmount(double amount) throws InvalidExpenseException;
}
