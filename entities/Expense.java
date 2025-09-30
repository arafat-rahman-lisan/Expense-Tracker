package entities;

public class Expense {
    private String expenseId;
    private String userId;
    private String categoryId;
    private double amount;
    private String description;
    private String date;

    public Expense() {}

    public Expense(String expenseId, String userId, String categoryId, double amount, String description, String date) {
        this.expenseId = expenseId;
        this.userId = userId;
        this.categoryId = categoryId;
        this.amount = amount;
        this.description = description;
        this.date = date;
    }

    public void setExpenseId(String expenseId) { this.expenseId = expenseId; }
    public void setUserId(String userId) { this.userId = userId; }
    public void setCategoryId(String categoryId) { this.categoryId = categoryId; }
    public void setAmount(double amount) { this.amount = amount; }
    public void setDescription(String description) { this.description = description; }
    public void setDate(String date) { this.date = date; }

    public String getExpenseId() { return expenseId; }
    public String getUserId() { return userId; }
    public String getCategoryId() { return categoryId; }
    public double getAmount() { return amount; }
    public String getDescription() { return description; }
    public String getDate() { return date; }
}