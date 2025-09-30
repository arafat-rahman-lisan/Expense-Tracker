package repositories;

import java.io.*;

import entities.Expense;
import interfaces.IExpenseRepo;

public class ExpenseRepo implements IExpenseRepo {

    private final String filePath;

    public ExpenseRepo() {
        this.filePath = System.getProperty("user.dir") + "/repositories/data/expenses.txt";
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("File initialization error: " + e.getMessage());
        }
    }

    @Override
    public void insertExpense(Expense e) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(e.getExpenseId() + ";" + e.getUserId() + ";" + e.getCategoryId() + ";" +
                         e.getAmount() + ";" + e.getDescription() + ";" + e.getDate() + "\n");
            writer.close();
            System.out.println("✅ Expense saved.");
        } catch (IOException e1) {
            System.out.println("❌ Error saving expense: " + e1.getMessage());
            e1.printStackTrace();
        }
    }

    @Override
    public Expense[] getAllExpensesByUser(String userId) {
        Expense[] list = new Expense[100];
        int index = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 6 && parts[1].equals(userId)) {
                    list[index++] = new Expense(parts[0], parts[1], parts[2],
                                                Double.parseDouble(parts[3]), parts[4], parts[5]);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("❌ Error reading expenses: " + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public Expense searchExpense(String expenseId) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 6 && parts[0].equals(expenseId)) {
                    reader.close();
                    return new Expense(parts[0], parts[1], parts[2],
                                       Double.parseDouble(parts[3]), parts[4], parts[5]);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("❌ Error searching expense: " + e.getMessage());
        }
        return null;
    }

    @Override
    public void updateExpense(Expense updatedExpense) {
        File inputFile = new File(filePath);
        File tempFile = new File(filePath + ".tmp");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 6 && parts[0].equals(updatedExpense.getExpenseId())) {
                    writer.write(updatedExpense.getExpenseId() + ";" +
                                 updatedExpense.getUserId() + ";" +
                                 updatedExpense.getCategoryId() + ";" +
                                 updatedExpense.getAmount() + ";" +
                                 updatedExpense.getDescription() + ";" +
                                 updatedExpense.getDate() + "\n");
                } else {
                    writer.write(line + "\n");
                }
            }

            reader.close();
            writer.close();

            if (inputFile.delete()) {
                tempFile.renameTo(inputFile);
                System.out.println("✅ Expense updated.");
            } else {
                System.out.println("❌ Could not delete original expense file.");
            }
        } catch (IOException e) {
            System.out.println("❌ Error updating expense: " + e.getMessage());
        }
    }
}
