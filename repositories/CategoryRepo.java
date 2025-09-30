package repositories;

import java.io.*;
import entities.Category;
import interfaces.ICategoryRepo;

public class CategoryRepo implements ICategoryRepo {

    private final String filePath;

    public CategoryRepo() {
        this.filePath = System.getProperty("user.dir") + "/repositories/data/categories.txt";
        File file = new File(filePath);
        try {
            if (!file.exists()) {
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("File init error: " + e.getMessage());
        }
    }

    @Override
    public void insertCategory(Category c) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(c.getCategoryId() + ";" + c.getName() + "\n");
            writer.close();
            System.out.println("✅ Category saved.");
        } catch (IOException ex) {
            System.out.println("❌ Error saving category: " + ex.getMessage());
        }
    }

    @Override
    public Category[] getAllCategories() {
        Category[] list = new Category[100];
        int index = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2) {
                    list[index++] = new Category(parts[0], parts[1]);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("❌ Error reading categories: " + e.getMessage());
        }
        return list;
    }

    @Override
    public void removeCategory(String id) {
        File inputFile = new File(filePath);
        File tempFile = new File(filePath + ".tmp");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2 && !parts[0].equals(id)) {
                    writer.write(line + "\n");
                }
            }

            reader.close();
            writer.close();

            if (inputFile.delete()) {
                tempFile.renameTo(inputFile);
                System.out.println("✅ Category removed.");
            } else {
                System.out.println("❌ Could not delete original file.");
            }
        } catch (IOException e) {
            System.out.println("❌ Error removing category: " + e.getMessage());
        }
    }

    @Override
    public void updateCategory(Category c) {
        File inputFile = new File(filePath);
        File tempFile = new File(filePath + ".tmp");

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2 && parts[0].equals(c.getCategoryId())) {
                    writer.write(c.getCategoryId() + ";" + c.getName() + "\n");
                } else {
                    writer.write(line + "\n");
                }
            }

            reader.close();
            writer.close();

            if (inputFile.delete()) {
                tempFile.renameTo(inputFile);
                System.out.println("✅ Category updated.");
            } else {
                System.out.println("❌ Could not delete original file.");
            }
        } catch (IOException e) {
            System.out.println("❌ Error updating category: " + e.getMessage());
        }
    }

    @Override
    public Category searchCategory(String id) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2 && parts[0].equals(id)) {
                    reader.close();
                    return new Category(parts[0], parts[1]);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("❌ Error searching category: " + e.getMessage());
        }
        return null;
    }
}
