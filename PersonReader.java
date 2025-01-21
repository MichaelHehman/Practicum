
import java.io.*;
import java.util.Scanner;

//main class
public class PersonReader {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // Prompt the user for the file name
        String fileName = SafeInput.getNonZeroLenString(in, "Enter the name of the file to read");

    }
}

//file reading

try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
    String line;
    System.out.printf("%-10s %-15s %-15s %-10s %-5s%n", "ID", "First Name", "Last Name", "Title", "YOB");
    System.out.println("-------------------------------------------------------------");

    while ((line = reader.readLine()) != null) {
        // Split the line into parts
        String[] parts = line.split(",\\s*");
        if (parts.length == 5) {
            System.out.printf("%-10s %-15s %-15s %-10s %-5s%n", parts[0], parts[1], parts[2], parts[3], parts[4]);
        } else {
            System.out.println("Invalid record: " + line);
        }
    }
} catch (FileNotFoundException e) {
    System.out.println("File not found: " + e.getMessage());
} catch (IOException e) {
    System.out.println("Error reading file: " + e.getMessage());
}

