import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class InventoryChecker {

    public static void main(String[] args) {
        String fileName = "inventory.txt";

        // Try-with-resources handles automatic file closing
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            
            String line;
            System.out.println("--- Out of Stock Items ---");

            // Read the file line by line
            while ((line = reader.readLine()) != null) {
                // Skip empty lines to prevent errors
                if (line.trim().isEmpty()) continue;

                // Split the line using the hyphen "-" delimiter
                // e.g., "Mouse-0" becomes ["Mouse", "0"]
                String[] parts = line.split("-");
                
                if (parts.length == 2) {
                    String productName = parts.trim();
                    int quantity = Integer.parseInt(parts.trim());

                    // Check if the item is out of stock
                    if (quantity == 0) {
                        System.out.println(productName + " is out of stock");
                    }
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("Error: The file '" + fileName + "' was not found.");
        } catch (IOException e) {
            System.err.println("Error reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Format error: Invalid quantity found in the inventory file.");
        }
    }
}