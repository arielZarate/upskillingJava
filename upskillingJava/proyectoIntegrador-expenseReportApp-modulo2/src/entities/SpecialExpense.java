package entities;

import java.time.LocalDate;



// esta clase hereda de Expense todos sus atributos
public class SpecialExpense extends Expense {
    private String reason;

    public SpecialExpense() {
    }

    public SpecialExpense(double amount, ExpenseCategory category, String date, String reason) {
        super(amount, category, date);
        this.reason = reason;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}
