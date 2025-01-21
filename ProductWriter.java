
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;

public class ProductWriter {
    public static void main(String[] args) {
        ArrayList<Product> products = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        
        String ID;
        String name;
        String description;
        double cost;
        boolean done = false;

        do {
            // Get the product data using SafeInput methods
            ID = SafeInput.getNonZeroLenString(in, "Enter ID (6 digits)");
            name = SafeInput.getNonZeroLenString(in, "Enter product name");
            description = SafeInput.getNonZeroLenString(in, "Enter product description");
            cost = SafeInput.getRangedDouble(in, "Enter product cost", 0.0, 9999.99);

            // Create and add the product to the ArrayList
            Product product = new Product(ID, name, description, cost);
            products.add(product);

            // Ask if user wants to add another record
            done = !SafeInput.getYNConfirm(in, "Do you want to add another product?");
        } while (!done);

        // Write to file
        String fileName = SafeInput.getNonZeroLenString(in, "Enter the file name to save");

        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            // Write each product to the file
            for (Product product : products) {
                writer.println(product.toCSVDataRecord());
            }
            System.out.println("Data written to file successfully!");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
