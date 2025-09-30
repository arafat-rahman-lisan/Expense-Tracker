package interfaces;

import entities.Expense;

public interface IExpenseRepo {
    void insertExpense(Expense e);
    Expense[] getAllExpensesByUser(String userId);
    Expense searchExpense(String expenseId);
    void updateExpense(Expense e); // Add this to match ExpenseRepo
}
