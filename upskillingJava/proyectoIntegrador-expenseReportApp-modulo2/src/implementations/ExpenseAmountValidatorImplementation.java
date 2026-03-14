package implementations;

import exceptions.InvalidExpenseException;
import interfaces.ExpenseAmountValidator;

public class ExpenseAmountValidatorImplementation implements ExpenseAmountValidator {
    @Override
    public boolean validateAmount(double amount) throws InvalidExpenseException {
        if (amount < 0) {
            throw new InvalidExpenseException("El monto debe ser igual o mayor a cero.");
        }
        return true;
    }
}
