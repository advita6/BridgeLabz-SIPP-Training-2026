import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class GroceryBillReader {

    public static void main(String[] args) {
        // Name of the file to be read
        String fileName = "bill.txt";
        
        // Variable to keep track of the total number of lines
        int lineCount = 0;

        System.out.println("--- Reading Grocery Bill Contents ---");

        // Try-with-resources automatically closes both BufferedReader and FileReader
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            
            String currentLine;

            // Read the file line by line until reader.readLine() returns null
            while ((currentLine = reader.readLine()) != null) {
                // Display the current line on the console
                System.out.println(currentLine);
                
                // Increment the line counter
                lineCount++;
            }

            // Print the final summary
            System.out.println("-------------------------------------");
            System.out.println("Total number of lines in the file: " + lineCount);

        } catch (FileNotFoundException e) {
            System.err.println("Error: The file '" + fileName + "' could not be found.");
            System.err.println("Please place 'bill.txt' in the project directory and try again.");
        } catch (IOException e) {
            System.err.println("An error occurred while reading the file: " + e.getMessage());
        }
    }
}