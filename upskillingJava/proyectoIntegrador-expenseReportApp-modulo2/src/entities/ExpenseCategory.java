package entities;

public class ExpenseCategory {
    private String name;

    public ExpenseCategory() {
    }

    // constructor ExpenseCategory
    public ExpenseCategory(String name) {
        this.name = name;
    }


    //get name de category
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "ExpenseCategory{" +
                "name='" + name + '\'' +
                '}';
    }
}
