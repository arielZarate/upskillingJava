package entities;


import interfaces.ExpenseCalculator;

public class Expense {
    private double amount;

    // el tipo es de ExpensedCategory
    private ExpenseCategory category;
    private String date;



    //constructor sin parametros
    public Expense() {
    }


    //constructor con parametros
    public Expense(double amount, ExpenseCategory category, String date) {
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    //===========amount===========================
    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
    //============================================




    //============ category=========================
    public ExpenseCategory getCategory() {
        return category;
    }

    public void setCategory(ExpenseCategory category) {
        this.category = category;
    }
    //============================================


    //==================Date==============================
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
    //====================================================



    //metodo del object --> toString por eso override
    @Override
    public String toString() {
        return "Expense{" +
                "amount=" + amount +
                ", category=" + category +
                ", date=" + date +
                '}';
    }
}
