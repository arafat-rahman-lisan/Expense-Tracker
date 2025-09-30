package repositories;

import java.io.*;

public class FileIO {
    public void writeInFile(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("repositories/data/" + fileName, true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String readFromFile(String fileName) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("repositories/data/" + fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return content.toString();
    }
}
