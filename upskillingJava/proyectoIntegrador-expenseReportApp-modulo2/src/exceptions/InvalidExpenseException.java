package exceptions;

// Excepción customizada
public class InvalidExpenseException extends Exception {
    public InvalidExpenseException(String message) {
        super(message);
    }
}
