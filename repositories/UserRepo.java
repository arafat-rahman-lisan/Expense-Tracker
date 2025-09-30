package repositories;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import entities.User;
import interfaces.IUserRepo;

public class UserRepo implements IUserRepo {

    private final String filePath;

    public UserRepo() {
        this.filePath = System.getProperty("user.dir") + "/repositories/data/users.txt";
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
    public void insertUser(User u) {
        try {
            FileWriter writer = new FileWriter(filePath, true);
            writer.write(u.getId() + ";" + u.getName() + ";" + u.getEmail() + ";" + u.getPassword() + "\n");
            writer.close();
            System.out.println("✅ User saved.");
        } catch (IOException e) {
            System.out.println("❌ Error saving user: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public User getUser(String email, String password) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    if (parts[2].equals(email) && parts[3].equals(password)) {
                        reader.close();
                        return new User(parts[0], parts[1], parts[2], parts[3]);
                    }
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("❌ Error reading user: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateUser(User u) {
        try {
            File inputFile = new File(filePath);
            File tempFile = new File(filePath + ".tmp");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4 && parts[0].equals(u.getId())) {
                    writer.write(u.getId() + ";" + u.getName() + ";" + u.getEmail() + ";" + u.getPassword() + "\n");
                } else {
                    writer.write(line + "\n");
                }
            }

            reader.close();
            writer.close();

            if (inputFile.delete()) {
                tempFile.renameTo(inputFile);
                System.out.println("✅ User updated.");
            } else {
                System.out.println("❌ Could not delete original file.");
            }
        } catch (IOException e) {
            System.out.println("❌ Error updating user: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public User searchUser(String userId) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4 && parts[0].equals(userId)) {
                    reader.close();
                    return new User(parts[0], parts[1], parts[2], parts[3]);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("❌ Error searching user: " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public User[] getAllUsers() {
        List<User> userList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 4) {
                    userList.add(new User(parts[0], parts[1], parts[2], parts[3]));
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("❌ Error loading users: " + e.getMessage());
            e.printStackTrace();
        }
        return userList.toArray(new User[0]);
    }
}
