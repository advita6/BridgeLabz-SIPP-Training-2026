import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ResultPortal {

    public static void main(String[] args) {
        String inputFile = "students_input.txt";
        String outputFile = "report_cards.txt";

        // Step 1: Read and process the input file
        // Try-with-resources automatically closes the BufferedReader
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            
            String line;
            System.out.println("Processing student records...");

            // Read line by line until the end of the file
            while ((line = reader.readLine()) != null) {
                // Skip empty lines
                if (line.trim().isEmpty()) continue;

                // Expected format: Name, Mark1, Mark2, Mark3...
                String[] parts = line.split(",");
                String studentName = parts.trim();
                
                int totalMarks = 0;
                int subjectCount = parts.length - 1;

                // Parse marks and calculate total
                for (int i = 1; i <= subjectCount; i++) {
                    totalMarks += Integer.parseInt(parts[i].trim());
                }

                // Compute average
                double average = subjectCount > 0 ? (double) totalMarks / subjectCount : 0.0;

                // Step 2: Append the results to the output file
                appendReportCard(outputFile, studentName, totalMarks, average);
            }
            
            System.out.println("Report cards successfully updated in: " + outputFile);

        } catch (FileNotFoundException e) {
            // Graceful handling of missing input file
            System.err.println("Error: The input file '" + inputFile + "' was not found.");
            System.err.println("Please ensure the file exists and try again.");
        } catch (IOException e) {
            System.err.println("An I/O error occurred while reading the file: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Format error: Found a non-numeric value in the marks data.");
        }
    }

    /**
     * Appends a formatted report card to the specified file.
     * Setting the second argument of FileWriter to 'true' enables append mode.
     */
    private static void appendReportCard(String filePath, String name, int total, double average) {
        // Passing 'true' to FileWriter enables appending without overwriting old data
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            
            writer.write("====================================\n");
            writer.write(String.format("STUDENT REPORT CARD\n"));
            writer.write("====================================\n");
            writer.write(String.format("Name:    %s\n", name));
            writer.write(String.format("Total:   %d\n", total));
            writer.write(String.format("Average: %.2f\n", average));
            writer.write("====================================\n\n");
            
        } catch (IOException e) {
            System.err.println("Error writing report card for " + name + ": " + e.getMessage());
        }
    }
}